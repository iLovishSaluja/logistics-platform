package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.FailedDeliveryRequestDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.TrackingHistory;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.AssignmentStatus;
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

	public DeliveryAgentServiceImpl(ShipmentRepository shipmentRepository, ShipmentMapper shipmentMapper,
			UserRepository userRepository, ShipmentStatusService shipmentStatusService,
			DeliveryAttemptService deliveryAttemptService) {
		super();
		this.shipmentRepository = shipmentRepository;
		this.shipmentMapper = shipmentMapper;
		this.userRepository = userRepository;
		this.shipmentStatusService = shipmentStatusService;
		this.deliveryAttemptService = deliveryAttemptService;
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

		ShipmentStatus currentStatus = shipment.getStatus();

		boolean validTransition = shipmentStatusService.isValidTransition(currentStatus,
				ShipmentStatus.OUT_FOR_DELIVERY);

		if (!validTransition) {

			throw new BadRequestException(
					"Shipment cannot be marked OUT_FOR_DELIVERY from its current status: " + currentStatus);
		}

		shipment.setStatus(ShipmentStatus.OUT_FOR_DELIVERY);

		shipment.setUpdatedAt(java.time.LocalDateTime.now());

		shipmentRepository.save(shipment);
	}

	@Override
	public void markDelivered(String shipmentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getAssignedDeliveryAgentId() == null) {
			throw new BadRequestException("Shipment is not assigned to any delivery agent");
		}

		if (!shipment.getAssignedDeliveryAgentId().equals(deliveryAgent.getId())) {

			throw new UnauthorizedException("You are not authorized to deliver this shipment");
		}

		if (shipment.getAssignmentStatus() != AssignmentStatus.ACCEPTED) {

			throw new BadRequestException("Shipment assignment must be ACCEPTED before delivery");
		}

		ShipmentStatus currentStatus = shipment.getStatus();

		boolean validTransition = shipmentStatusService.isValidTransition(currentStatus, ShipmentStatus.DELIVERED);

		if (!validTransition) {

			throw new BadRequestException("Shipment cannot be delivered from its current status: " + currentStatus);
		}

		shipment.setStatus(ShipmentStatus.DELIVERED);

		shipment.setUpdatedAt(java.time.LocalDateTime.now());

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
}