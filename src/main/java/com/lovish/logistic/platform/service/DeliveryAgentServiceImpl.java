package com.lovish.logistic.platform.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.AgentCodDetailsDto;
import com.lovish.logistic.platform.dto.CodCollectionRequestDto;
import com.lovish.logistic.platform.dto.CodCollectionResponseDto;
import com.lovish.logistic.platform.dto.FailedDeliveryRequestDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.TrackingHistory;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.AssignmentStatus;
import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.PaymentMethod;
import com.lovish.logistic.platform.enums.Role;
import com.lovish.logistic.platform.enums.ShipmentStatus;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.exception.UnauthorizedException;
import com.lovish.logistic.platform.mapper.ShipmentMapper;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService {

	private final ShipmentRepository shipmentRepository;
	private final ShipmentMapper shipmentMapper;
	private final UserRepository userRepository;
	private final ShipmentStatusService shipmentStatusService;
	private final DeliveryAttemptService deliveryAttemptService;
	private final DeliveryOtpService deliveryOtpService;
	private final NotificationService notificationService;

	public DeliveryAgentServiceImpl(ShipmentRepository shipmentRepository, ShipmentMapper shipmentMapper,
			UserRepository userRepository, ShipmentStatusService shipmentStatusService,
			DeliveryAttemptService deliveryAttemptService, DeliveryOtpService deliveryOtpService,
			NotificationService notificationService) {
		super();
		this.shipmentRepository = shipmentRepository;
		this.shipmentMapper = shipmentMapper;
		this.userRepository = userRepository;
		this.shipmentStatusService = shipmentStatusService;
		this.deliveryAttemptService = deliveryAttemptService;
		this.deliveryOtpService = deliveryOtpService;
		this.notificationService = notificationService;
	}

	@Override
	public List<ShipmentSummaryDto> getAssignedShipments() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		String deliveryAgentId = user.getId();

		List<Shipment> shipments = shipmentRepository.findByAssignedDeliveryAgentId(deliveryAgentId);

		return shipments.stream().map(shipmentMapper::toSummaryDto).toList();
	}

	@Override
	public void assignShipment(String shipmentId, String deliveryAgentId) {

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		User deliveryAgent = userRepository.findById(deliveryAgentId).orElseThrow(
				() -> new ResourceNotFoundException("Delivery agent not found with id: " + deliveryAgentId));

		if (deliveryAgent.getRole() != com.lovish.logistic.platform.enums.Role.DELIVERY_AGENT) {
			throw new BadRequestException("Selected user is not a delivery agent");
		}

		if (shipment.getAssignedDeliveryAgentId() != null) {
			throw new BadRequestException("Shipment is already assigned to a delivery agent");
		}

		if (shipment.getStatus() != com.lovish.logistic.platform.enums.ShipmentStatus.CREATED
				&& shipment.getStatus() != com.lovish.logistic.platform.enums.ShipmentStatus.CONFIRMED) {

			throw new BadRequestException("Shipment cannot be assigned in its current status: " + shipment.getStatus());
		}

		shipment.setAssignedDeliveryAgentId(deliveryAgentId);
		shipment.setAssignmentStatus(AssignmentStatus.PENDING);
		shipment.setUpdatedAt(java.time.LocalDateTime.now());

		shipmentRepository.save(shipment);
	}

	@Override
	public void acceptAssignment(String shipmentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getAssignedDeliveryAgentId() == null) {
			throw new BadRequestException("Shipment is not assigned to any delivery agent");
		}

		if (!shipment.getAssignedDeliveryAgentId().equals(deliveryAgent.getId())) {

			throw new UnauthorizedException("You are not authorized to accept this assignment");
		}

		if (shipment.getAssignmentStatus() != AssignmentStatus.PENDING) {

			throw new BadRequestException(
					"Assignment cannot be accepted in its current status: " + shipment.getAssignmentStatus());
		}

		shipment.setAssignmentStatus(AssignmentStatus.ACCEPTED);

		shipment.setUpdatedAt(java.time.LocalDateTime.now());

		shipmentRepository.save(shipment);
	}

	@Override
	public void rejectAssignment(String shipmentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getAssignedDeliveryAgentId() == null) {
			throw new BadRequestException("Shipment is not assigned to any delivery agent");
		}

		if (!shipment.getAssignedDeliveryAgentId().equals(deliveryAgent.getId())) {

			throw new UnauthorizedException("You are not authorized to reject this assignment");
		}

		if (shipment.getAssignmentStatus() != AssignmentStatus.PENDING) {

			throw new BadRequestException(
					"Assignment cannot be rejected in its current status: " + shipment.getAssignmentStatus());
		}

		shipment.setAssignmentStatus(AssignmentStatus.REJECTED);

		shipment.setAssignedDeliveryAgentId(null);

		shipment.setUpdatedAt(java.time.LocalDateTime.now());

		shipmentRepository.save(shipment);
	}

	@Override
	public void pickupShipment(String shipmentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getAssignedDeliveryAgentId() == null) {
			throw new BadRequestException("Shipment is not assigned to any delivery agent");
		}

		if (!shipment.getAssignedDeliveryAgentId().equals(deliveryAgent.getId())) {

			throw new UnauthorizedException("You are not authorized to pick up this shipment");
		}

		if (shipment.getAssignmentStatus() != AssignmentStatus.ACCEPTED) {

			throw new BadRequestException("Shipment assignment must be ACCEPTED before pickup");
		}

		ShipmentStatus currentStatus = shipment.getStatus();

		boolean validTransition = shipmentStatusService.isValidTransition(currentStatus, ShipmentStatus.PICKED_UP);

		if (!validTransition) {
			throw new BadRequestException("Shipment cannot be picked up from its current status: " + currentStatus);
		}

		shipment.setStatus(ShipmentStatus.PICKED_UP);

		shipment.setUpdatedAt(java.time.LocalDateTime.now());

		shipmentRepository.save(shipment);
	}

	@Override
	public void markInTransit(String shipmentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getAssignedDeliveryAgentId() == null) {

			throw new BadRequestException("Shipment is not assigned to any delivery agent");
		}

		if (!shipment.getAssignedDeliveryAgentId().equals(deliveryAgent.getId())) {

			throw new UnauthorizedException("You are not authorized to update this shipment");
		}

		if (shipment.getAssignmentStatus() != AssignmentStatus.ACCEPTED) {

			throw new BadRequestException("Shipment assignment must be ACCEPTED before marking it in transit");
		}

		ShipmentStatus currentStatus = shipment.getStatus();

		boolean validTransition = shipmentStatusService.isValidTransition(currentStatus, ShipmentStatus.IN_TRANSIT);

		if (!validTransition) {

			throw new BadRequestException(
					"Shipment cannot be marked IN_TRANSIT from its current status: " + currentStatus);
		}

		shipment.setStatus(ShipmentStatus.IN_TRANSIT);

		shipment.setUpdatedAt(java.time.LocalDateTime.now());

		shipmentRepository.save(shipment);
	}

	@Override
	public void markOutForDelivery(String shipmentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getAssignedDeliveryAgentId() == null) {
			throw new BadRequestException("Shipment is not assigned to any delivery agent");
		}

		if (!shipment.getAssignedDeliveryAgentId().equals(deliveryAgent.getId())) {
			throw new UnauthorizedException("You are not authorized to update this shipment");
		}

		if (shipment.getAssignmentStatus() != AssignmentStatus.ACCEPTED) {
			throw new BadRequestException("Shipment assignment must be ACCEPTED before marking it out for delivery");
		}

		if (shipment.getStatus() != ShipmentStatus.IN_TRANSIT) {
			throw new BadRequestException("Shipment must be IN_TRANSIT before marking it OUT_FOR_DELIVERY");
		}

		ShipmentStatus currentStatus = shipment.getStatus();

		boolean validTransition = shipmentStatusService.isValidTransition(currentStatus,
				ShipmentStatus.OUT_FOR_DELIVERY);

		if (!validTransition) {
			throw new BadRequestException(
					"Shipment cannot be marked OUT_FOR_DELIVERY from its current status: " + currentStatus);
		}

		String otp = deliveryOtpService.generateOtp();

		shipment.setDeliveryOtpHash(deliveryOtpService.hashOtp(otp));

		shipment.setDeliveryOtpExpiresAt(LocalDateTime.now().plusMinutes(10));

		shipment.setDeliveryOtpVerified(false);

		String receiverPhone = shipment.getReceiverAddress().getPhoneNumber();

		notificationService.sendDeliveryOtp(receiverPhone, otp);

		shipment.setStatus(ShipmentStatus.OUT_FOR_DELIVERY);

		shipment.setUpdatedAt(LocalDateTime.now());

		shipmentRepository.save(shipment);
	}

	@Override
	public void markDelivered(String shipmentId, String otp) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current delivery agent not found"));

		if (deliveryAgent.getRole() != Role.DELIVERY_AGENT) {
			throw new BadRequestException("Only delivery agents can complete delivery");
		}

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

		if (!deliveryAgent.getId().equals(shipment.getAssignedDeliveryAgentId())) {

			throw new BadRequestException("You are not assigned to this shipment");
		}

		if (shipment.getAssignmentStatus() != AssignmentStatus.ACCEPTED) {

			throw new BadRequestException("Delivery assignment must be accepted first");
		}

		if (shipment.getStatus() != ShipmentStatus.OUT_FOR_DELIVERY) {

			throw new BadRequestException("Shipment must be out for delivery");
		}

		if (shipment.isDeliveryOtpVerified()) {

			throw new BadRequestException("Delivery OTP has already been verified");
		}

		if (shipment.getDeliveryOtpHash() == null || shipment.getDeliveryOtpExpiresAt() == null) {

			throw new BadRequestException("Delivery OTP is not available");
		}

		if (LocalDateTime.now().isAfter(shipment.getDeliveryOtpExpiresAt())) {

			throw new BadRequestException("Delivery OTP has expired");
		}

		if (!deliveryOtpService.matches(otp, shipment.getDeliveryOtpHash())) {

			throw new BadRequestException("Invalid delivery OTP");
		}

		shipment.setDeliveryOtpVerified(true);

		shipment.setStatus(ShipmentStatus.DELIVERED);

		shipment.setUpdatedAt(LocalDateTime.now());

		addTrackingEvent(shipment, ShipmentStatus.DELIVERED, shipment.getReceiverAddress().getCity(),
				"Shipment delivered successfully", deliveryAgent.getId(), "Delivery confirmed using OTP");

		shipmentRepository.save(shipment);
	}

	@Override
	public void markFailedDelivery(String shipmentId, FailedDeliveryRequestDto request) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getAssignedDeliveryAgentId() == null) {
			throw new BadRequestException("Shipment is not assigned to any delivery agent");
		}

		if (!shipment.getAssignedDeliveryAgentId().equals(deliveryAgent.getId())) {
			throw new UnauthorizedException("You are not authorized to update this shipment");
		}

		if (shipment.getAssignmentStatus() != AssignmentStatus.ACCEPTED) {
			throw new BadRequestException("Shipment assignment must be ACCEPTED before reporting failed delivery");
		}

		ShipmentStatus currentStatus = shipment.getStatus();

		if (!shipmentStatusService.isValidTransition(currentStatus, ShipmentStatus.FAILED_DELIVERY)) {

			throw new BadRequestException(
					"Delivery cannot be marked as failed from its current status: " + currentStatus);
		}

		long attemptCount = deliveryAttemptService.getAttemptCount(shipmentId);

		if (attemptCount >= 2) {
			throw new BadRequestException("Maximum delivery attempts have already been reached");
		}

		int currentAttemptNumber = (int) attemptCount + 1;

		LocalDateTime now = LocalDateTime.now();

		// Both the 1st and 2nd failed attempts result in FAILED_DELIVERY.
		shipment.setStatus(ShipmentStatus.FAILED_DELIVERY);

		TrackingHistory trackingHistory = new TrackingHistory();

		trackingHistory.setStatus(ShipmentStatus.FAILED_DELIVERY);
		trackingHistory.setTimestamp(now);
		trackingHistory.setPerformedBy(deliveryAgent.getId());

		if (currentAttemptNumber == 2) {

			trackingHistory
					.setDescription("Delivery failed - second attempt completed. Awaiting hub operator decision - "
							+ request.getReason());

		} else {

			trackingHistory.setDescription("Delivery failed - first attempt - " + request.getReason());
		}

		trackingHistory.setNotes(request.getNotes());

		if (shipment.getTrackingHistory() == null) {
			shipment.setTrackingHistory(new ArrayList<>());
		}

		shipment.getTrackingHistory().add(trackingHistory);

		deliveryAttemptService.recordFailedAttempt(shipment.getId(), deliveryAgent.getId(), request.getReason(),
				request.getNotes());

		shipment.setUpdatedAt(now);

		shipmentRepository.save(shipment);
	}

	private void addTrackingEvent(Shipment shipment, ShipmentStatus status, String location, String description,
			String performedBy, String notes) {

		TrackingHistory event = new TrackingHistory();

		event.setStatus(status);
		event.setTimestamp(LocalDateTime.now());
		event.setLocation(location);
		event.setDescription(description);
		event.setPerformedBy(performedBy);
		event.setNotes(notes);

		shipment.getTrackingHistory().add(event);
	}

	@Override
	public List<AgentCodDetailsDto> getAssignedCodShipments() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		if (deliveryAgent.getRole() != Role.DELIVERY_AGENT) {
			throw new UnauthorizedException("Only delivery agents can view assigned COD shipments");
		}

		String deliveryAgentId = deliveryAgent.getId();

		return shipmentRepository.findByAssignedDeliveryAgentIdAndPaymentMethod(deliveryAgentId, PaymentMethod.COD)
				.stream()
				.map(shipment -> new AgentCodDetailsDto(shipment.getId(), shipment.getTrackingNumber(),
						shipment.getPaymentMethod(), shipment.getCodAmount(), shipment.getCodCollectionStatus()))
				.toList();
	}

	@Override
	public CodCollectionResponseDto collectCod(String shipmentId, CodCollectionRequestDto request) {

		// Identify the authenticated agent from the security context.
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		if (deliveryAgent.getRole() != Role.DELIVERY_AGENT) {
			throw new UnauthorizedException("Only delivery agents can collect COD");
		}

		String deliveryAgentId = deliveryAgent.getId();

		// Find the shipment.
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

		// The agent must be assigned to this exact shipment.
		if (!deliveryAgentId.equals(shipment.getAssignedDeliveryAgentId())) {
			throw new UnauthorizedException("You are not assigned to this shipment");
		}

		// Only COD shipments can use this endpoint.
		if (shipment.getPaymentMethod() != PaymentMethod.COD) {
			throw new BadRequestException("COD collection is allowed only for COD shipments");
		}

		// Prevent duplicate collection.
		if (shipment.getCodCollectionStatus() != CodCollectionStatus.PENDING) {
			throw new BadRequestException("COD collection has already been processed");
		}

		BigDecimal expectedAmount = shipment.getCodAmount();
		BigDecimal actualAmount = request.getCollectedAmount();

		if (expectedAmount == null || expectedAmount.signum() <= 0) {
			throw new BadRequestException("Shipment has an invalid COD amount");
		}

		// This version requires exact payment; partial collection is not allowed.
		if (actualAmount == null || actualAmount.compareTo(expectedAmount) != 0) {
			throw new BadRequestException("Collected amount must equal the expected COD amount of " + expectedAmount);
		}

		// Record collection details.
		LocalDateTime collectedAt = LocalDateTime.now();

		shipment.setCodCollectedAmount(actualAmount);
		shipment.setCodCollectedAt(collectedAt);
		shipment.setCodCollectedByAgentId(deliveryAgentId);
		shipment.setCodCollectionNotes(request.getNotes());
		shipment.setCodCollectionStatus(CodCollectionStatus.COLLECTED);

		// Persist the updated shipment.
		Shipment savedShipment = shipmentRepository.save(shipment);

		return new CodCollectionResponseDto(savedShipment.getId(), savedShipment.getTrackingNumber(),
				savedShipment.getCodAmount(), savedShipment.getCodCollectedAmount(),
				savedShipment.getCodCollectionStatus(), savedShipment.getCodCollectedAt(),
				savedShipment.getCodCollectedByAgentId(), savedShipment.getCodCollectionNotes());
	}
}