//package com.lovish.logistic.platform.service;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import com.lovish.logistic.platform.dto.CreateOnlinePaymentResponseDto;
//import com.lovish.logistic.platform.dto.OnlinePaymentResponseDto;
//import com.lovish.logistic.platform.dto.RefundPaymentRequestDto;
//import com.lovish.logistic.platform.dto.VerifyOnlinePaymentRequestDto;
//import com.lovish.logistic.platform.entity.OnlinePayment;
//import com.lovish.logistic.platform.entity.Shipment;
//import com.lovish.logistic.platform.entity.User;
//import com.lovish.logistic.platform.enums.PaymentMethod;
//import com.lovish.logistic.platform.enums.PaymentStatus;
//import com.lovish.logistic.platform.exception.BadRequestException;
//import com.lovish.logistic.platform.exception.ResourceNotFoundException;
//import com.lovish.logistic.platform.mapper.OnlinePaymentMapper;
//import com.lovish.logistic.platform.repository.OnlinePaymentRepository;
//import com.lovish.logistic.platform.repository.ShipmentRepository;
//import com.lovish.logistic.platform.repository.UserRepository;
//import com.razorpay.Order;
//import com.razorpay.Payment;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import com.razorpay.Refund;
//import com.razorpay.Utils;
//
//@Service
//public class OnlinePaymentServiceImpl implements OnlinePaymentService {
//
//	private final RazorpayClient razorpayClient;
//	private final OnlinePaymentRepository onlinePaymentRepository;
//	private final ShipmentRepository shipmentRepository;
//	private final UserRepository userRepository;
//	private final OnlinePaymentMapper onlinePaymentMapper;
//
//	@Value("${razorpay.key-id:}")
//	private String razorpayKeyId;
//
//	@Value("${razorpay.key-secret:}")
//	private String razorpayKeySecret;
//
//	public OnlinePaymentServiceImpl(RazorpayClient razorpayClient, OnlinePaymentRepository onlinePaymentRepository,
//			ShipmentRepository shipmentRepository, UserRepository userRepository,
//			OnlinePaymentMapper onlinePaymentMapper) {
//
//		this.razorpayClient = razorpayClient;
//		this.onlinePaymentRepository = onlinePaymentRepository;
//		this.shipmentRepository = shipmentRepository;
//		this.userRepository = userRepository;
//		this.onlinePaymentMapper = onlinePaymentMapper;
//	}
//
//	private void validateRazorpayConfiguration() {
//		if (razorpayKeyId == null || razorpayKeyId.isBlank() || razorpayKeySecret == null || razorpayKeySecret.isBlank()
//				|| razorpayClient == null) {
//			throw new BadRequestException("Razorpay credentials are not configured");
//		}
//	}
//
//	private User getCurrentUser() {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//
//		return userRepository.findByUsername(username)
//				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));
//	}
//
//	private Shipment getOwnedShipment(String shipmentId, String customerId) {
//		Shipment shipment = shipmentRepository.findById(shipmentId)
//				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
//
//		if (!customerId.equals(shipment.getCustomerId())) {
//			throw new BadRequestException("You are not authorized to pay for this shipment");
//		}
//
//		return shipment;
//	}
//
//	private long toPaise(BigDecimal amount) {
//		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
//			throw new BadRequestException("Payment amount must be positive");
//		}
//
//		try {
//			return amount.setScale(2, RoundingMode.UNNECESSARY).movePointRight(2).longValueExact();
//		} catch (ArithmeticException ex) {
//			throw new BadRequestException("Payment amount must have at most two decimal places");
//		}
//	}
//
//	private CreateOnlinePaymentResponseDto toOrderResponse(OnlinePayment payment) {
//
//		return new CreateOnlinePaymentResponseDto(payment.getShipmentId(), payment.getId(),
//				payment.getRazorpayOrderId(), razorpayKeyId, payment.getAmount(), payment.getCurrency(),
//				payment.getStatus().name());
//	}
//
//	@Override
//	public CreateOnlinePaymentResponseDto createOrder(String shipmentId) {
//		validateRazorpayConfiguration();
//
//		User customer = getCurrentUser();
//		Shipment shipment = getOwnedShipment(shipmentId, customer.getId());
//
//		if (shipment.getPaymentMethod() != PaymentMethod.ONLINE) {
//			throw new BadRequestException("Razorpay is available only for ONLINE payments");
//		}
//
//		if (shipment.getPaymentStatus() == PaymentStatus.PAID) {
//			throw new BadRequestException("Shipment payment has already been completed");
//		}
//
//		if (shipment.getShippingCost() == null) {
//			throw new BadRequestException("Shipment shipping cost is not available");
//		}
//
//		BigDecimal amount = shipment.getShippingCost();
//		long amountInPaise = toPaise(amount);
//
//		// Reuse an existing pending order for this shipment when possible.
//		var existing = onlinePaymentRepository.findFirstByShipmentIdAndCustomerIdOrderByCreatedAtDesc(shipmentId,
//				customer.getId());
//
//		if (existing.isPresent()) {
//			OnlinePayment previous = existing.get();
//
//			if (previous.getStatus() == PaymentStatus.PENDING && previous.getRazorpayOrderId() != null
//					&& previous.getAmount().compareTo(amount) == 0) {
//				return toOrderResponse(previous);
//			}
//		}
//
//		try {
//			JSONObject orderRequest = new JSONObject();
//			orderRequest.put("amount", amountInPaise);
//			orderRequest.put("currency", "INR");
//			orderRequest.put("receipt", "ship_" + shipment.getId());
//
//			JSONObject notes = new JSONObject();
//			notes.put("shipmentId", shipment.getId());
//			notes.put("customerId", customer.getId());
//			orderRequest.put("notes", notes);
//
//			Order razorpayOrder = razorpayClient.orders.create(orderRequest);
//
//			OnlinePayment payment = new OnlinePayment();
//			payment.setShipmentId(shipment.getId());
//			payment.setCustomerId(customer.getId());
//			payment.setRazorpayOrderId(razorpayOrder.get("id"));
//			payment.setAmount(amount);
//			payment.setCurrency("INR");
//			payment.setStatus(PaymentStatus.PENDING);
//			payment.setCreatedAt(LocalDateTime.now());
//			payment.setUpdatedAt(LocalDateTime.now());
//
//			OnlinePayment saved = onlinePaymentRepository.save(payment);
//
//			return toOrderResponse(saved);
//
//		} catch (RazorpayException ex) {
//			throw new BadRequestException("Unable to create Razorpay order");
//		}
//	}
//
//	@Override
//	public OnlinePaymentResponseDto verifyPayment(VerifyOnlinePaymentRequestDto request) {
//
//		validateRazorpayConfiguration();
//
//		User customer = getCurrentUser();
//
//		OnlinePayment payment = onlinePaymentRepository.findByRazorpayOrderId(request.getRazorpayOrderId())
//				.orElseThrow(() -> new ResourceNotFoundException("Online payment order not found"));
//
//		if (!customer.getId().equals(payment.getCustomerId())) {
//			throw new BadRequestException("You are not authorized to verify this payment");
//		}
//
//		if (payment.getStatus() == PaymentStatus.PAID) {
//			return onlinePaymentMapper.toResponseDto(payment);
//		}
//
//		try {
//			JSONObject attributes = new JSONObject();
//			attributes.put("razorpay_order_id", request.getRazorpayOrderId());
//			attributes.put("razorpay_payment_id", request.getRazorpayPaymentId());
//			attributes.put("razorpay_signature", request.getRazorpaySignature());
//
//			boolean validSignature = Utils.verifyPaymentSignature(attributes, razorpayKeySecret);
//
//			if (!validSignature) {
//				throw new BadRequestException("Invalid Razorpay payment signature");
//			}
//
//			Payment razorpayPayment = razorpayClient.payments.fetch(request.getRazorpayPaymentId());
//
//			String gatewayOrderId = razorpayPayment.get("order_id");
//			String gatewayStatus = razorpayPayment.get("status");
//			Number gatewayAmount = (Number) razorpayPayment.get("amount");
//			String gatewayCurrency = razorpayPayment.get("currency");
//
//			if (!payment.getRazorpayOrderId().equals(gatewayOrderId)) {
//				throw new BadRequestException("Payment does not belong to this order");
//			}
//
//			if (gatewayAmount == null || gatewayAmount.longValue() != toPaise(payment.getAmount())) {
//				throw new BadRequestException("Payment amount does not match the order");
//			}
//
//			if (!"INR".equalsIgnoreCase(gatewayCurrency)) {
//				throw new BadRequestException("Unexpected payment currency");
//			}
//
//			payment.setRazorpayPaymentId(request.getRazorpayPaymentId());
//			payment.setUpdatedAt(LocalDateTime.now());
//
//			if ("captured".equalsIgnoreCase(gatewayStatus)) {
//				payment.setStatus(PaymentStatus.PAID);
//
//				Shipment shipment = getOwnedShipment(payment.getShipmentId(), customer.getId());
//
//				shipment.setPaymentStatus(PaymentStatus.PAID);
//				shipment.setUpdatedAt(LocalDateTime.now());
//				shipmentRepository.save(shipment);
//
//			} else if ("failed".equalsIgnoreCase(gatewayStatus)) {
//				payment.setStatus(PaymentStatus.FAILED);
//			}
//			// An authorized-but-not-captured payment remains PENDING.
//
//			OnlinePayment saved = onlinePaymentRepository.save(payment);
//
//			return onlinePaymentMapper.toResponseDto(saved);
//
//		} catch (RazorpayException ex) {
//			throw new BadRequestException("Unable to verify payment with Razorpay");
//		}
//	}
//
//	@Override
//	public List<OnlinePaymentResponseDto> getMyPayments() {
//		User customer = getCurrentUser();
//
//		return onlinePaymentRepository.findByCustomerIdOrderByCreatedAtDesc(customer.getId()).stream()
//				.map(onlinePaymentMapper::toResponseDto).toList();
//	}
//
//	@Override
//	public OnlinePaymentResponseDto refundPayment(String paymentId, RefundPaymentRequestDto request) {
//
//		validateRazorpayConfiguration();
//
//		OnlinePayment payment = onlinePaymentRepository.findById(paymentId)
//				.orElseThrow(() -> new ResourceNotFoundException("Online payment not found"));
//
//		if (payment.getStatus() != PaymentStatus.PAID) {
//			throw new BadRequestException("Only paid transactions can be refunded");
//		}
//
//		// This initial implementation supports full refunds only.
//		if (request.getAmount().compareTo(payment.getAmount()) != 0) {
//			throw new BadRequestException("Refund amount must equal the original payment amount");
//		}
//
//		if (payment.getRazorpayPaymentId() == null) {
//			throw new BadRequestException("Razorpay payment ID is missing");
//		}
//
//		try {
//			JSONObject refundRequest = new JSONObject();
//			refundRequest.put("amount", toPaise(request.getAmount()));
//			refundRequest.put("speed", "normal");
//
//			Refund refund = razorpayClient.payments.refund(payment.getRazorpayPaymentId(), refundRequest);
//
//			payment.setRazorpayRefundId(refund.get("id"));
//			payment.setUpdatedAt(LocalDateTime.now());
//
//			String refundStatus = refund.get("status");
//
//			// Do not mark REFUNDED while the provider says it is pending.
//			if ("processed".equalsIgnoreCase(refundStatus)) {
//				payment.setStatus(PaymentStatus.REFUNDED);
//
//				Shipment shipment = shipmentRepository.findById(payment.getShipmentId())
//						.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
//
//				shipment.setPaymentStatus(PaymentStatus.REFUNDED);
//				shipment.setUpdatedAt(LocalDateTime.now());
//				shipmentRepository.save(shipment);
//			}
//
//			return onlinePaymentMapper.toResponseDto(onlinePaymentRepository.save(payment));
//
//		} catch (RazorpayException ex) {
//			throw new BadRequestException("Unable to request refund from Razorpay");
//		}
//	}
//}

package com.lovish.logistic.platform.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.CreateOnlinePaymentResponseDto;
import com.lovish.logistic.platform.dto.OnlinePaymentResponseDto;
import com.lovish.logistic.platform.dto.RefundPaymentRequestDto;
import com.lovish.logistic.platform.dto.VerifyOnlinePaymentRequestDto;
import com.lovish.logistic.platform.entity.OnlinePayment;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.PaymentMethod;
import com.lovish.logistic.platform.enums.PaymentStatus;
import com.lovish.logistic.platform.enums.RefundStatus;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.mapper.OnlinePaymentMapper;
import com.lovish.logistic.platform.repository.OnlinePaymentRepository;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Refund;
import com.razorpay.Utils;

@Service
public class OnlinePaymentServiceImpl implements OnlinePaymentService {

	private final RazorpayClient razorpayClient;
	private final OnlinePaymentRepository onlinePaymentRepository;
	private final ShipmentRepository shipmentRepository;
	private final UserRepository userRepository;
	private final OnlinePaymentMapper onlinePaymentMapper;

	@Value("${razorpay.key-id:}")
	private String razorpayKeyId;

	@Value("${razorpay.key-secret:}")
	private String razorpayKeySecret;

	public OnlinePaymentServiceImpl(RazorpayClient razorpayClient, OnlinePaymentRepository onlinePaymentRepository,
			ShipmentRepository shipmentRepository, UserRepository userRepository,
			OnlinePaymentMapper onlinePaymentMapper) {

		this.razorpayClient = razorpayClient;
		this.onlinePaymentRepository = onlinePaymentRepository;
		this.shipmentRepository = shipmentRepository;
		this.userRepository = userRepository;
		this.onlinePaymentMapper = onlinePaymentMapper;
	}

	private void validateRazorpayConfiguration() {
		if (razorpayKeyId == null || razorpayKeyId.isBlank() || razorpayKeySecret == null || razorpayKeySecret.isBlank()
				|| razorpayClient == null) {
			throw new BadRequestException("Razorpay credentials are not configured properly");
		}
	}

	private User getCurrentUser() {
		var authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || !authentication.isAuthenticated() || authentication.getName() == null
				|| "anonymousUser".equals(authentication.getName())) {
			throw new BadRequestException("Authentication is required");
		}

		String username = authentication.getName();

		return userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));
	}

	private Shipment getOwnedShipment(String shipmentId, String customerId) {
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

		if (!customerId.equals(shipment.getCustomerId())) {
			throw new BadRequestException("You are not authorized to pay for this shipment");
		}

		return shipment;
	}

	private long toPaise(BigDecimal amount) {
		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new BadRequestException("Payment amount must be positive");
		}

		try {
			return amount.setScale(2, RoundingMode.UNNECESSARY).movePointRight(2).longValueExact();
		} catch (ArithmeticException ex) {
			throw new BadRequestException("Payment amount must have at most two decimal places");
		}
	}

	private CreateOnlinePaymentResponseDto toOrderResponse(OnlinePayment payment) {

		return new CreateOnlinePaymentResponseDto(payment.getShipmentId(), payment.getId(),
				payment.getRazorpayOrderId(), razorpayKeyId, payment.getAmount(), payment.getCurrency(),
				payment.getStatus().name());
	}

	@Override
	public CreateOnlinePaymentResponseDto createOrder(String shipmentId) {
		validateRazorpayConfiguration();

		User customer = getCurrentUser();
		Shipment shipment = getOwnedShipment(shipmentId, customer.getId());

		if (shipment.getPaymentMethod() != PaymentMethod.ONLINE) {
			throw new BadRequestException("Razorpay is available only for ONLINE payments");
		}

		if (shipment.getPaymentStatus() == PaymentStatus.PAID) {
			throw new BadRequestException("Shipment payment has already been completed");
		}

		if (shipment.getPaymentStatus() == PaymentStatus.REFUNDED) {
			throw new BadRequestException("This shipment payment has already been refunded");
		}

		if (shipment.getShippingCost() == null) {
			throw new BadRequestException("Shipment shipping cost is not available");
		}

		BigDecimal amount = shipment.getShippingCost();
		long amountInPaise = toPaise(amount);

		try {
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", amountInPaise);
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "ship_" + shipment.getId() + "_" + System.currentTimeMillis());

			JSONObject notes = new JSONObject();
			notes.put("shipmentId", shipment.getId());
			notes.put("customerId", customer.getId());
			orderRequest.put("notes", notes);

			Order razorpayOrder = razorpayClient.orders.create(orderRequest);

			OnlinePayment payment = new OnlinePayment();
			payment.setShipmentId(shipment.getId());
			payment.setCustomerId(customer.getId());
			payment.setRazorpayOrderId(razorpayOrder.get("id"));
			payment.setAmount(amount);
			payment.setCurrency("INR");
			payment.setStatus(PaymentStatus.PENDING);
			payment.setRefundStatus(RefundStatus.NONE);
			payment.setRefundedAmount(BigDecimal.ZERO);
			payment.setCreatedAt(LocalDateTime.now());
			payment.setUpdatedAt(LocalDateTime.now());

			OnlinePayment saved = onlinePaymentRepository.save(payment);

			return toOrderResponse(saved);

		} catch (RazorpayException ex) {
			throw new BadRequestException("Unable to create Razorpay order: " + ex.getMessage());
		}
	}

	@Override
	public OnlinePaymentResponseDto verifyPayment(VerifyOnlinePaymentRequestDto request) {
		validateRazorpayConfiguration();

		if (request == null || request.getRazorpayOrderId() == null || request.getRazorpayOrderId().isBlank()
				|| request.getRazorpayPaymentId() == null || request.getRazorpayPaymentId().isBlank()
				|| request.getRazorpaySignature() == null || request.getRazorpaySignature().isBlank()) {
			throw new BadRequestException("Razorpay order ID, payment ID, and signature are required");
		}

		User customer = getCurrentUser();

		OnlinePayment payment = onlinePaymentRepository.findByRazorpayOrderId(request.getRazorpayOrderId())
				.orElseThrow(() -> new ResourceNotFoundException("Online payment order not found"));

		if (!customer.getId().equals(payment.getCustomerId())) {
			throw new BadRequestException("You are not authorized to verify this payment");
		}

		if (payment.getStatus() == PaymentStatus.PAID || payment.getStatus() == PaymentStatus.REFUNDED) {
			return onlinePaymentMapper.toResponseDto(payment);
		}

		try {
			JSONObject attributes = new JSONObject();
			attributes.put("razorpay_order_id", request.getRazorpayOrderId());
			attributes.put("razorpay_payment_id", request.getRazorpayPaymentId());
			attributes.put("razorpay_signature", request.getRazorpaySignature());

			boolean validSignature = Utils.verifyPaymentSignature(attributes, razorpayKeySecret);

			if (!validSignature) {
				throw new BadRequestException("Invalid Razorpay payment signature");
			}

			Payment razorpayPayment = razorpayClient.payments.fetch(request.getRazorpayPaymentId());

			String gatewayOrderId = razorpayPayment.get("order_id");
			String gatewayStatus = razorpayPayment.get("status");
			Number gatewayAmount = razorpayPayment.get("amount");
			String gatewayCurrency = razorpayPayment.get("currency");

			if (!payment.getRazorpayOrderId().equals(gatewayOrderId)) {
				throw new BadRequestException("Payment does not belong to this order");
			}

			if (gatewayAmount == null || gatewayAmount.longValue() != toPaise(payment.getAmount())) {
				throw new BadRequestException("Payment amount does not match the order");
			}

			if (!"INR".equalsIgnoreCase(gatewayCurrency) || !"INR".equalsIgnoreCase(payment.getCurrency())) {
				throw new BadRequestException("Unexpected payment currency");
			}

			Shipment shipment = getOwnedShipment(payment.getShipmentId(), customer.getId());

			LocalDateTime now = LocalDateTime.now();

			if ("captured".equalsIgnoreCase(gatewayStatus)) {
				payment.setRazorpayPaymentId(request.getRazorpayPaymentId());
				payment.setStatus(PaymentStatus.PAID);
				payment.setUpdatedAt(now);

				shipment.setPaymentStatus(PaymentStatus.PAID);
				shipment.setUpdatedAt(now);
				shipmentRepository.save(shipment);

			} else if ("failed".equalsIgnoreCase(gatewayStatus)) {
				payment.setRazorpayPaymentId(request.getRazorpayPaymentId());
				payment.setStatus(PaymentStatus.FAILED);
				payment.setUpdatedAt(now);

			} else if (payment.getStatus() == PaymentStatus.PENDING) {
				payment.setRazorpayPaymentId(request.getRazorpayPaymentId());
				payment.setUpdatedAt(now);
			}

			OnlinePayment saved = onlinePaymentRepository.save(payment);
			return onlinePaymentMapper.toResponseDto(saved);

		} catch (RazorpayException ex) {
			throw new BadRequestException("Unable to verify payment with Razorpay: " + ex.getMessage());
		}
	}

	@Override
	public List<OnlinePaymentResponseDto> getMyPayments() {
		User customer = getCurrentUser();

		return onlinePaymentRepository.findByCustomerIdOrderByCreatedAtDesc(customer.getId()).stream()
				.map(onlinePaymentMapper::toResponseDto).toList();
	}

	@Override
	public OnlinePaymentResponseDto refundPayment(String paymentId, RefundPaymentRequestDto request) {

		validateRazorpayConfiguration();

		OnlinePayment payment = onlinePaymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Online payment not found"));

		if (payment.getStatus() != PaymentStatus.PAID) {
			throw new BadRequestException("Only paid transactions can be refunded");
		}

		if (request == null || request.getAmount() == null || payment.getAmount() == null
				|| request.getAmount().compareTo(payment.getAmount()) != 0) {
			throw new BadRequestException("Refund amount must equal the original payment amount");
		}

		if (payment.getRazorpayPaymentId() == null || payment.getRazorpayPaymentId().isBlank()) {
			throw new BadRequestException("Razorpay payment ID is missing");
		}

		if (payment.getRefundStatus() == RefundStatus.PENDING || payment.getRefundStatus() == RefundStatus.PROCESSED) {
			throw new BadRequestException("A refund has already been requested or processed");
		}

		try {
			JSONObject refundRequest = new JSONObject();
			refundRequest.put("amount", toPaise(request.getAmount()));
			refundRequest.put("speed", "normal");

			Refund refund = razorpayClient.payments.refund(payment.getRazorpayPaymentId(), refundRequest);

			String gatewayRefundStatus = refund.get("status");

			payment.setRazorpayRefundId(refund.get("id"));
			payment.setRefundStatus(RefundStatus.PENDING);
			payment.setUpdatedAt(LocalDateTime.now());

			if ("processed".equalsIgnoreCase(gatewayRefundStatus)) {
				payment.setRefundStatus(RefundStatus.PROCESSED);
				payment.setRefundedAmount(payment.getAmount());
				payment.setStatus(PaymentStatus.REFUNDED);

				Shipment shipment = shipmentRepository.findById(payment.getShipmentId())
						.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

				shipment.setPaymentStatus(PaymentStatus.REFUNDED);
				shipment.setUpdatedAt(LocalDateTime.now());
				shipmentRepository.save(shipment);

			} else if ("failed".equalsIgnoreCase(gatewayRefundStatus)) {
				payment.setRefundStatus(RefundStatus.FAILED);
			}

			OnlinePayment savedPayment = onlinePaymentRepository.save(payment);
			return onlinePaymentMapper.toResponseDto(savedPayment);

		} catch (RazorpayException ex) {
			throw new BadRequestException("Unable to request refund from Razorpay");
		}
	}

}