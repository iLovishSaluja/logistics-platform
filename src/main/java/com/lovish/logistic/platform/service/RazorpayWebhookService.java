//package com.lovish.logistic.platform.service;
//
//import java.time.LocalDateTime;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import com.lovish.logistic.platform.entity.OnlinePayment;
//import com.lovish.logistic.platform.entity.Shipment;
//import com.lovish.logistic.platform.enums.PaymentStatus;
//import com.lovish.logistic.platform.repository.OnlinePaymentRepository;
//import com.lovish.logistic.platform.repository.ShipmentRepository;
//import com.razorpay.Utils;
//
//@Service
//public class RazorpayWebhookService {
//
//	@Value("${razorpay.webhook-secret:}")
//	private String webhookSecret;
//
//	private final OnlinePaymentRepository paymentRepository;
//	private final ShipmentRepository shipmentRepository;
//
//	public RazorpayWebhookService(OnlinePaymentRepository paymentRepository, ShipmentRepository shipmentRepository) {
//		this.paymentRepository = paymentRepository;
//		this.shipmentRepository = shipmentRepository;
//	}
//
//	public void process(String body, String signature) throws Exception {
//		if (webhookSecret == null || webhookSecret.isBlank()) {
//			throw new IllegalStateException("Razorpay webhook secret is not configured");
//		}
//
//		if (signature == null || !Utils.verifyWebhookSignature(body, signature, webhookSecret)) {
//			throw new IllegalArgumentException("Invalid Razorpay webhook signature");
//		}
//
//		JSONObject event = new JSONObject(body);
//		String eventName = event.optString("event");
//
//		JSONObject payload = event.optJSONObject("payload");
//		if (payload == null) {
//			return;
//		}
//
//		if ("payment.captured".equals(eventName) || "payment.failed".equals(eventName)) {
//
//			JSONObject paymentWrapper = payload.optJSONObject("payment");
//			JSONObject paymentEntity = paymentWrapper == null ? null : paymentWrapper.optJSONObject("entity");
//
//			if (paymentEntity == null) {
//				return;
//			}
//
//			String orderId = paymentEntity.optString("order_id", "");
//			String paymentId = paymentEntity.optString("id", "");
//
//			if (orderId.isBlank() || paymentId.isBlank()) {
//				return;
//			}
//
//			OnlinePayment payment = paymentRepository.findByRazorpayOrderId(orderId).orElse(null);
//
//			if (payment == null) {
//				// The order may not have reached the local database yet.
//				return;
//			}
//
//			// Do not downgrade an already confirmed payment.
//			if (payment.getStatus() == PaymentStatus.REFUNDED || payment.getStatus() == PaymentStatus.PAID) {
//				return;
//			}
//
//			payment.setRazorpayPaymentId(paymentId);
//			payment.setUpdatedAt(LocalDateTime.now());
//
//			if ("payment.captured".equals(eventName)) {
//				payment.setStatus(PaymentStatus.PAID);
//
//				Shipment shipment = shipmentRepository.findById(payment.getShipmentId()).orElse(null);
//
//				if (shipment != null) {
//					shipment.setPaymentStatus(PaymentStatus.PAID);
//					shipment.setUpdatedAt(LocalDateTime.now());
//					shipmentRepository.save(shipment);
//				}
//			} else {
//				payment.setStatus(PaymentStatus.FAILED);
//			}
//
//			paymentRepository.save(payment);
//			return;
//		}
//
//		if ("refund.processed".equals(eventName)) {
//			JSONObject refundWrapper = payload.optJSONObject("refund");
//			JSONObject refundEntity = refundWrapper == null ? null : refundWrapper.optJSONObject("entity");
//
//			if (refundEntity == null) {
//				return;
//			}
//
//			String paymentId = refundEntity.optString("payment_id", "");
//			String refundId = refundEntity.optString("id", "");
//
//			if (paymentId.isBlank()) {
//				return;
//			}
//
//			OnlinePayment payment = paymentRepository.findByRazorpayPaymentId(paymentId).orElse(null);
//
//			if (payment == null) {
//				return;
//			}
//
//			payment.setRazorpayRefundId(refundId);
//			payment.setStatus(PaymentStatus.REFUNDED);
//			payment.setUpdatedAt(LocalDateTime.now());
//			paymentRepository.save(payment);
//
//			Shipment shipment = shipmentRepository.findById(payment.getShipmentId()).orElse(null);
//
//			if (shipment != null) {
//				shipment.setPaymentStatus(PaymentStatus.REFUNDED);
//				shipment.setUpdatedAt(LocalDateTime.now());
//				shipmentRepository.save(shipment);
//			}
//		}
//	}
//}

package com.lovish.logistic.platform.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.entity.OnlinePayment;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.enums.PaymentStatus;
import com.lovish.logistic.platform.enums.RefundStatus;
import com.lovish.logistic.platform.repository.OnlinePaymentRepository;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.razorpay.Utils;

@Service
public class RazorpayWebhookService {

	@Value("${razorpay.webhook-secret:}")
	private String webhookSecret;

	private final OnlinePaymentRepository paymentRepository;
	private final ShipmentRepository shipmentRepository;

	public RazorpayWebhookService(OnlinePaymentRepository paymentRepository, ShipmentRepository shipmentRepository) {
		this.paymentRepository = paymentRepository;
		this.shipmentRepository = shipmentRepository;
	}

	public void process(String body, String signature) throws Exception {

		if (webhookSecret == null || webhookSecret.isBlank()) {
			throw new IllegalStateException("Razorpay webhook secret is not configured");
		}

		if (body == null || body.isBlank() || signature == null || signature.isBlank()) {
			throw new IllegalArgumentException("Webhook body and signature are required");
		}

		// Always verify the original, unmodified request body first.
		try {
			if (!Utils.verifyWebhookSignature(body, signature, webhookSecret)) {
				throw new IllegalArgumentException("Invalid Razorpay webhook signature");
			}
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new IllegalArgumentException("Webhook signature verification failed", ex);
		}

		final JSONObject event;

		try {
			event = new JSONObject(body);
		} catch (JSONException ex) {
			throw new IllegalArgumentException("Invalid webhook JSON", ex);
		}

		String eventName = event.optString("event", "");
		JSONObject payload = event.optJSONObject("payload");

		if (eventName.isBlank() || payload == null) {
			throw new IllegalArgumentException("Webhook event or payload is missing");
		}

		switch (eventName) {
		case "payment.captured":
		case "payment.failed":
			processPaymentEvent(eventName, payload);
			break;

		case "refund.processed":
		case "refund.failed":
			processRefundEvent(payload);
			break;

		default:
			// Valid but unsupported event; acknowledge it.
			break;
		}
	}

	private void processPaymentEvent(String eventName, JSONObject payload) {

		JSONObject paymentWrapper = payload.optJSONObject("payment");
		JSONObject paymentEntity = paymentWrapper == null ? null : paymentWrapper.optJSONObject("entity");

		if (paymentEntity == null) {
			throw new IllegalArgumentException("Payment entity is missing");
		}

		String orderId = paymentEntity.optString("order_id", "");
		String paymentId = paymentEntity.optString("id", "");
		String currency = paymentEntity.optString("currency", "");
		String gatewayStatus = paymentEntity.optString("status", "");

		if (orderId.isBlank() || paymentId.isBlank()) {
			throw new IllegalArgumentException("Payment or order ID is missing");
		}

		OnlinePayment payment = paymentRepository.findByRazorpayOrderId(orderId).orElse(null);

		// Do not create local payment records for unknown orders.
		if (payment == null) {
			return;
		}

		// Duplicate or delayed events must not downgrade these states.
		if (payment.getStatus() == PaymentStatus.PAID || payment.getStatus() == PaymentStatus.REFUNDED) {
			return;
		}

		LocalDateTime now = LocalDateTime.now();

		if ("payment.captured".equals(eventName)) {

			long gatewayAmount = paymentEntity.optLong("amount", -1L);
			long expectedAmount = toPaise(payment.getAmount());

			if (gatewayAmount != expectedAmount) {
				throw new IllegalArgumentException("Captured payment amount does not match local order");
			}

			if (!"INR".equalsIgnoreCase(currency) || !"INR".equalsIgnoreCase(payment.getCurrency())) {
				throw new IllegalArgumentException("Captured payment currency does not match local order");
			}

			if (!orderId.equals(payment.getRazorpayOrderId()) || !"captured".equalsIgnoreCase(gatewayStatus)) {
				throw new IllegalArgumentException("Invalid captured payment details");
			}

			Shipment shipment = shipmentRepository.findById(payment.getShipmentId()).orElse(null);

			// Do not mark a payment paid if its shipment no longer exists.
			if (shipment == null) {
				throw new IllegalStateException("Shipment for payment was not found");
			}

			// Save payment only after validating the associated shipment.
			payment.setRazorpayPaymentId(paymentId);
			payment.setStatus(PaymentStatus.PAID);
			payment.setUpdatedAt(now);

			if (shipment.getPaymentStatus() != PaymentStatus.REFUNDED) {
				shipment.setPaymentStatus(PaymentStatus.PAID);
				shipment.setUpdatedAt(now);
				shipmentRepository.save(shipment);
			}
			if (payment.getRefundStatus() == null) {
				payment.setRefundStatus(RefundStatus.NONE);
			}

			if (payment.getRefundedAmount() == null) {
				payment.setRefundedAmount(BigDecimal.ZERO);
			}

			paymentRepository.save(payment);
			return;
		}

		if ("payment.failed".equals(eventName) && "failed".equalsIgnoreCase(gatewayStatus)
				&& payment.getStatus() == PaymentStatus.PENDING) {

			payment.setRazorpayPaymentId(paymentId);
			payment.setStatus(PaymentStatus.FAILED);
			payment.setUpdatedAt(now);
			paymentRepository.save(payment);
		}
	}

	private void processRefundEvent(JSONObject payload) {

		JSONObject refundWrapper = payload.optJSONObject("refund");
		JSONObject refundEntity = refundWrapper == null ? null : refundWrapper.optJSONObject("entity");

		if (refundEntity == null) {
			throw new IllegalArgumentException("Refund entity is missing");
		}

		String paymentId = refundEntity.optString("payment_id", "");
		String refundId = refundEntity.optString("id", "");
		String refundStatus = refundEntity.optString("status", "");

		if (paymentId.isBlank() || refundId.isBlank()) {
			throw new IllegalArgumentException("Refund or payment ID is missing");
		}

		OnlinePayment payment = paymentRepository.findByRazorpayPaymentId(paymentId).orElse(null);

		if (payment == null) {
			return;
		}

		String savedRefundId = payment.getRazorpayRefundId();

		if (savedRefundId == null || !savedRefundId.equals(refundId)) {
			return;
		}
		// Ignore duplicate or unrelated refund events.
		if (refundId.equals(payment.getRazorpayRefundId()) && (payment.getRefundStatus() == RefundStatus.PROCESSED
				|| payment.getRefundStatus() == RefundStatus.FAILED)) {
			return;
		}

		// This design supports full refunds only.
		if (payment.getStatus() != PaymentStatus.PAID || payment.getRefundStatus() != RefundStatus.PENDING) {
			return;
		}

		LocalDateTime now = LocalDateTime.now();

		if ("processed".equalsIgnoreCase(refundStatus)) {

			long gatewayRefundAmount = refundEntity.optLong("amount", -1L);
			long expectedRefundAmount = toPaise(payment.getAmount());

			if (gatewayRefundAmount != expectedRefundAmount) {
				throw new IllegalStateException("Refund amount does not match the full payment amount");
			}

			Shipment shipment = shipmentRepository.findById(payment.getShipmentId())
					.orElseThrow(() -> new IllegalStateException("Shipment for refund was not found"));

			payment.setRazorpayRefundId(refundId);
			payment.setRefundStatus(RefundStatus.PROCESSED);
			payment.setRefundedAmount(payment.getAmount());
			payment.setStatus(PaymentStatus.REFUNDED);
			payment.setUpdatedAt(now);

			shipment.setPaymentStatus(PaymentStatus.REFUNDED);
			shipment.setUpdatedAt(now);

			shipmentRepository.save(shipment);
			paymentRepository.save(payment);

		} else if ("failed".equalsIgnoreCase(refundStatus)) {

			payment.setRazorpayRefundId(refundId);
			payment.setRefundStatus(RefundStatus.FAILED);

			// Payment remains PAID because the refund did not succeed.
			payment.setStatus(PaymentStatus.PAID);
			payment.setRefundedAmount(BigDecimal.ZERO);
			payment.setUpdatedAt(now);

			paymentRepository.save(payment);
		}
	}

	private long toPaise(BigDecimal amount) {

		if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Payment amount must be positive");
		}

		try {
			return amount.setScale(2, RoundingMode.UNNECESSARY).movePointRight(2).longValueExact();
		} catch (ArithmeticException ex) {
			throw new IllegalArgumentException("Payment amount must have at most two decimal places", ex);
		}
	}
}
