package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.entity.Hub;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.TrackingHistory;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.AssignmentAction;
import com.lovish.logistic.platform.enums.AssignmentStatus;
import com.lovish.logistic.platform.enums.Role;
import com.lovish.logistic.platform.enums.ShipmentStatus;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.exception.UnauthorizedException;
import com.lovish.logistic.platform.repository.HubRepository;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class HubOperatorServiceImpl implements HubOperatorService {

	private final ShipmentRepository shipmentRepository;
	private final UserRepository userRepository;
	private final HubRepository hubRepository;
	private final AssignmentHistoryService assignmentHistoryService;
	private final DeliveryAttemptService deliveryAttemptService;
	private final ShipmentStatusService shipmentStatusService;

	public HubOperatorServiceImpl(ShipmentRepository shipmentRepository, UserRepository userRepository,
			HubRepository hubRepository, AssignmentHistoryService assignmentHistoryService,
			DeliveryAttemptService deliveryAttemptService, ShipmentStatusService shipmentStatusService) {
		super();
		this.shipmentRepository = shipmentRepository;
		this.userRepository = userRepository;
		this.hubRepository = hubRepository;
		this.assignmentHistoryService = assignmentHistoryService;
		this.deliveryAttemptService = deliveryAttemptService;
		this.shipmentStatusService = shipmentStatusService;
	}

	@Override
	public void assignShipment(String shipmentId, String deliveryAgentId) {

		// 1. Get currently logged-in user
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User hubOperator = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		// 2. Verify logged-in user is a Hub Operator
		if (hubOperator.getRole() != Role.HUB_OPERATOR) {
			throw new UnauthorizedException("Only a Hub Operator can perform this operation");
		}

		// 3. Verify Hub Operator is assigned to a Hub
		if (hubOperator.getHubId() == null) {
			throw new BadRequestException("Hub Operator is not assigned to any hub");
		}

		// 4. Get Hub
		Hub hub = hubRepository.findById(hubOperator.getHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubOperator.getHubId()));

		// 5. Verify Hub is active
		if (!hub.isActive()) {
			throw new BadRequestException("Cannot operate from an inactive hub");
		}

		// 6. Get Shipment
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		// 7. Verify shipment belongs to this Hub
		if (shipment.getCurrentHubId() == null) {
			throw new BadRequestException("Shipment is not assigned to any hub");
		}

		if (!shipment.getCurrentHubId().equals(hub.getId())) {
			throw new UnauthorizedException("You are not authorized to operate this shipment");
		}

		if (deliveryAgentId == null || deliveryAgentId.isBlank()) {
			throw new BadRequestException("Delivery agent ID is required");
		}

		String normalizedDeliveryAgentId = deliveryAgentId.trim();

		// 8. Get Delivery Agent
		User deliveryAgent = userRepository.findById(normalizedDeliveryAgentId).orElseThrow(
				() -> new ResourceNotFoundException("Delivery agent not found with id: " + normalizedDeliveryAgentId));
		// 9. Verify selected user is a Delivery Agent
		if (deliveryAgent.getRole() != Role.DELIVERY_AGENT) {
			throw new BadRequestException("Selected user is not a delivery agent");
		}

		// 10. Verify Delivery Agent belongs to same Hub
		if (deliveryAgent.getHubId() == null || !deliveryAgent.getHubId().equals(hub.getId())) {

			throw new BadRequestException("Delivery agent does not belong to your hub");
		}

		// 11. Shipment must not already have an active assignment
		if (shipment.getAssignedDeliveryAgentId() != null) {
			throw new BadRequestException("Shipment is already assigned to a delivery agent");
		}

		// 12. Shipment must be assignable
		if (shipment.getStatus() != ShipmentStatus.CREATED && shipment.getStatus() != ShipmentStatus.CONFIRMED) {

			throw new BadRequestException("Shipment cannot be assigned in its current status: " + shipment.getStatus());
		}

		// 13. Assign shipment
		shipment.setAssignedDeliveryAgentId(normalizedDeliveryAgentId);
		shipment.setAssignmentStatus(AssignmentStatus.PENDING);
		shipment.setUpdatedAt(LocalDateTime.now());

		shipmentRepository.save(shipment);

		assignmentHistoryService.recordAssignment(shipment.getId(), normalizedDeliveryAgentId, null,
				hubOperator.getId(), AssignmentAction.ASSIGNED, hub.getId(), null, null);
	}

	@Override
	public void reassignShipment(String shipmentId, String deliveryAgentId) {

		// 1. Get currently logged-in user
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User hubOperator = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		// 2. Verify logged-in user is a Hub Operator
		if (hubOperator.getRole() != Role.HUB_OPERATOR) {
			throw new UnauthorizedException("Only a Hub Operator can perform this operation");
		}

		// 3. Verify Hub Operator is assigned to a Hub
		if (hubOperator.getHubId() == null) {
			throw new BadRequestException("Hub Operator is not assigned to any hub");
		}

		// 4. Get Hub
		Hub hub = hubRepository.findById(hubOperator.getHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubOperator.getHubId()));

		// 5. Verify Hub is active
		if (!hub.isActive()) {
			throw new BadRequestException("Cannot operate from an inactive hub");
		}

		// 6. Get Shipment
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		// 7. Verify shipment belongs to this Hub
		if (shipment.getCurrentHubId() == null) {
			throw new BadRequestException("Shipment is not assigned to any hub");
		}

		if (!shipment.getCurrentHubId().equals(hub.getId())) {
			throw new UnauthorizedException("You are not authorized to operate this shipment");
		}

		// 8. Validate new Delivery Agent ID
		if (deliveryAgentId == null || deliveryAgentId.isBlank()) {
			throw new BadRequestException("Delivery agent ID is required");
		}

		String normalizedDeliveryAgentId = deliveryAgentId.trim();

		// 9. Get new Delivery Agent
		User deliveryAgent = userRepository.findById(normalizedDeliveryAgentId).orElseThrow(
				() -> new ResourceNotFoundException("Delivery agent not found with id: " + normalizedDeliveryAgentId));

		// 10. Verify selected user is a Delivery Agent
		if (deliveryAgent.getRole() != Role.DELIVERY_AGENT) {
			throw new BadRequestException("Selected user is not a delivery agent");
		}

		// 11. Verify new Delivery Agent belongs to same Hub
		if (deliveryAgent.getHubId() == null || !deliveryAgent.getHubId().equals(hub.getId())) {

			throw new BadRequestException("Delivery agent does not belong to your hub");
		}

		// 12. Shipment must already have an assignment
		if (shipment.getAssignedDeliveryAgentId() == null) {
			throw new BadRequestException("Shipment is not currently assigned to any delivery agent");
		}

		// 13. Prevent reassignment to the same agent
		if (shipment.getAssignedDeliveryAgentId().equals(normalizedDeliveryAgentId)) {
			throw new BadRequestException("Shipment is already assigned to this delivery agent");
		}

		// 14. Shipment must be in a valid reassignment state
		if (shipment.getStatus() != ShipmentStatus.CREATED && shipment.getStatus() != ShipmentStatus.CONFIRMED
				&& shipment.getStatus() != ShipmentStatus.FAILED_DELIVERY) {

			throw new BadRequestException(
					"Shipment cannot be reassigned in its current status: " + shipment.getStatus());
		}

		// 15. Assign to the new Delivery Agent
		String previousDeliveryAgentId = shipment.getAssignedDeliveryAgentId();

		shipment.setAssignedDeliveryAgentId(normalizedDeliveryAgentId);
		shipment.setAssignmentStatus(AssignmentStatus.PENDING);
		shipment.setUpdatedAt(LocalDateTime.now());

		shipmentRepository.save(shipment);

		assignmentHistoryService.recordAssignment(shipment.getId(), normalizedDeliveryAgentId, previousDeliveryAgentId,
				hubOperator.getId(), AssignmentAction.REASSIGNED, hub.getId(), null, null);
	}

	@Override
	public void retryShipment(String shipmentId, String deliveryAgentId) {

		// 1. Get currently logged-in user
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User hubOperator = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		// 2. Verify logged-in user is a Hub Operator
		if (hubOperator.getRole() != Role.HUB_OPERATOR) {
			throw new UnauthorizedException("Only a Hub Operator can perform this operation");
		}

		// 3. Verify Hub Operator is assigned to a Hub
		if (hubOperator.getHubId() == null) {
			throw new BadRequestException("Hub Operator is not assigned to any hub");
		}

		// 4. Get Hub
		Hub hub = hubRepository.findById(hubOperator.getHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubOperator.getHubId()));

		// 5. Verify Hub is active
		if (!hub.isActive()) {
			throw new BadRequestException("Cannot operate from an inactive hub");
		}

		// 6. Get Shipment
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		// 7. Verify shipment belongs to this Hub
		if (shipment.getCurrentHubId() == null) {
			throw new BadRequestException("Shipment is not assigned to any hub");
		}

		if (!shipment.getCurrentHubId().equals(hub.getId())) {
			throw new UnauthorizedException("You are not authorized to operate this shipment");
		}

		// 8. Shipment must be in FAILED_DELIVERY state
		if (shipment.getStatus() != ShipmentStatus.FAILED_DELIVERY) {
			throw new BadRequestException("Shipment can only be retried after a failed delivery");
		}

		// 9. Check actual delivery attempts
		long attemptCount = deliveryAttemptService.getAttemptCount(shipmentId);

		if (attemptCount >= 2) {
			throw new BadRequestException("Maximum delivery attempts reached. Shipment must be picked up from the hub");
		}

		// 10. Validate Delivery Agent ID
		if (deliveryAgentId == null || deliveryAgentId.isBlank()) {
			throw new BadRequestException("Delivery agent ID is required");
		}

		String normalizedDeliveryAgentId = deliveryAgentId.trim();

		// 11. Get Delivery Agent
		User deliveryAgent = userRepository.findById(normalizedDeliveryAgentId).orElseThrow(
				() -> new ResourceNotFoundException("Delivery agent not found with id: " + normalizedDeliveryAgentId));

		// 12. Verify selected user is a Delivery Agent
		if (deliveryAgent.getRole() != Role.DELIVERY_AGENT) {
			throw new BadRequestException("Selected user is not a delivery agent");
		}

		// 13. Verify Delivery Agent belongs to same Hub
		if (deliveryAgent.getHubId() == null || !deliveryAgent.getHubId().equals(hub.getId())) {

			throw new BadRequestException("Delivery agent does not belong to your hub");
		}

		// 14. Assign shipment for retry
		String previousDeliveryAgentId = shipment.getAssignedDeliveryAgentId();

		shipment.setAssignedDeliveryAgentId(normalizedDeliveryAgentId);
		shipment.setAssignmentStatus(AssignmentStatus.PENDING);
		shipment.setUpdatedAt(LocalDateTime.now());

		shipmentRepository.save(shipment);

		// 15. Record retry assignment
		assignmentHistoryService.recordAssignment(shipment.getId(), normalizedDeliveryAgentId, previousDeliveryAgentId,
				hubOperator.getId(), AssignmentAction.REASSIGNED, hub.getId(), "Delivery retry after failed attempt",
				"Retry attempt " + (attemptCount + 1) + " assigned");
	}

	@Override
	public void markPickupFromHub(String shipmentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User hubOperator = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		if (hubOperator.getRole() != Role.HUB_OPERATOR) {
			throw new UnauthorizedException("Only a Hub Operator can perform this operation");
		}

		if (hubOperator.getHubId() == null) {
			throw new BadRequestException("Hub Operator is not assigned to any hub");
		}

		Hub hub = hubRepository.findById(hubOperator.getHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubOperator.getHubId()));

		if (!hub.isActive()) {
			throw new BadRequestException("Cannot operate from an inactive hub");
		}

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getCurrentHubId() == null) {
			throw new BadRequestException("Shipment is not assigned to any hub");
		}

		if (!shipment.getCurrentHubId().equals(hub.getId())) {
			throw new UnauthorizedException("You are not authorized to operate this shipment");
		}

		if (shipment.getStatus() != ShipmentStatus.FAILED_DELIVERY) {
			throw new BadRequestException("Shipment can only be moved to pickup from hub after failed delivery");
		}

		long attemptCount = deliveryAttemptService.getAttemptCount(shipmentId);

		if (attemptCount != 2) {
			throw new BadRequestException("Shipment must have exactly 2 failed delivery attempts");
		}

		if (!shipmentStatusService.isValidTransition(shipment.getStatus(), ShipmentStatus.PICKUP_FROM_HUB)) {

			throw new BadRequestException("Invalid shipment status transition");
		}

		LocalDateTime now = LocalDateTime.now();

		shipment.setStatus(ShipmentStatus.PICKUP_FROM_HUB);

		// No active delivery assignment after maximum attempts
		shipment.setAssignedDeliveryAgentId(null);
		shipment.setAssignmentStatus(null);

		TrackingHistory trackingHistory = new TrackingHistory();

		trackingHistory.setStatus(ShipmentStatus.PICKUP_FROM_HUB);
		trackingHistory.setTimestamp(now);
		trackingHistory.setPerformedBy(hubOperator.getId());
		trackingHistory.setDescription("Maximum delivery attempts reached. Shipment available for pickup from hub");
		trackingHistory.setNotes("Shipment can now be collected from the designated hub");

		if (shipment.getTrackingHistory() == null) {
			shipment.setTrackingHistory(new ArrayList<>());
		}

		shipment.getTrackingHistory().add(trackingHistory);

		shipment.setUpdatedAt(now);

		shipmentRepository.save(shipment);
	}

	@Override
	public void toggleAutomaticAssignment(boolean enabled) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User hubOperator = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current hub operator not found"));

		Hub hub = hubRepository.findById(hubOperator.getHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Hub assigned to hub operator not found"));

		if (!hub.isActive()) {
			throw new BadRequestException("Cannot change automatic assignment for an inactive hub");
		}

		hub.setAutomaticAssignmentEnabled(enabled);
		hub.setUpdatedAt(LocalDateTime.now());

		hubRepository.save(hub);
	}

	@Override
	public void receiveShipment(String shipmentId) {

		// 1. Get currently logged-in user
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User hubOperator = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		// 2. Verify logged-in user is a Hub Operator
		if (hubOperator.getRole() != Role.HUB_OPERATOR) {
			throw new UnauthorizedException("Only a Hub Operator can perform this operation");
		}

		// 3. Verify Hub Operator is assigned to a Hub
		if (hubOperator.getHubId() == null || hubOperator.getHubId().isBlank()) {
			throw new BadRequestException("Hub Operator is not assigned to any hub");
		}

		// 4. Get Hub
		Hub hub = hubRepository.findById(hubOperator.getHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubOperator.getHubId()));

		// 5. Verify Hub is active
		if (!hub.isActive()) {
			throw new BadRequestException("Cannot operate from an inactive hub");
		}

		// 6. Get Shipment
		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		// 7. Verify shipment has a current hub
		if (shipment.getCurrentHubId() == null || shipment.getCurrentHubId().isBlank()) {
			throw new BadRequestException("Shipment is not currently assigned to any hub");
		}

		// 8. Verify shipment currently belongs to this Hub
		if (!shipment.getCurrentHubId().equals(hub.getId())) {
			throw new UnauthorizedException("You are not authorized to receive this shipment at this hub");
		}

		// 9. Shipment must be in transit
		if (shipment.getStatus() != ShipmentStatus.IN_TRANSIT) {
			throw new BadRequestException("Only shipments in transit can be received at a hub");
		}

		// 10. Verify destination hub exists on the shipment
		if (shipment.getDestinationHubId() == null || shipment.getDestinationHubId().isBlank()) {
			throw new BadRequestException("Shipment does not have a destination hub");
		}

		// 11. Verify this Hub is the shipment's destination Hub
		if (!shipment.getDestinationHubId().equals(hub.getId())) {
			throw new BadRequestException(
					"Shipment cannot be received at this hub because it is not the destination hub");
		}

		// 12. Shipment should not have an active delivery-agent assignment
		if (shipment.getAssignedDeliveryAgentId() != null) {
			throw new BadRequestException("Shipment still has an active delivery-agent assignment");
		}

		// 13. Record shipment receipt
		LocalDateTime now = LocalDateTime.now();

		TrackingHistory trackingHistory = new TrackingHistory();

		trackingHistory.setStatus(ShipmentStatus.IN_TRANSIT);
		trackingHistory.setTimestamp(now);
		trackingHistory.setLocation(hub.getAddress().getCity());
		trackingHistory.setPerformedBy(hubOperator.getId());
		trackingHistory.setDescription("Shipment received and scanned at destination hub");
		trackingHistory.setNotes("Shipment received by Hub Operator");

		if (shipment.getTrackingHistory() == null) {
			shipment.setTrackingHistory(new ArrayList<>());
		}

		shipment.getTrackingHistory().add(trackingHistory);

		// 14. Update current hub
		shipment.setCurrentHubId(hub.getId());

		// 15. Update timestamp
		shipment.setUpdatedAt(now);

		// 16. Save shipment
		shipmentRepository.save(shipment);
	}

	@Override
	public void dispatchShipment(String shipmentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User hubOperator = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current hub operator not found"));

		if (hubOperator.getRole() != Role.HUB_OPERATOR) {
			throw new BadRequestException("Only hub operators can dispatch shipments");
		}

		if (hubOperator.getHubId() == null) {
			throw new BadRequestException("Hub operator is not assigned to any hub");
		}

		Hub hub = hubRepository.findById(hubOperator.getHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Hub assigned to hub operator not found"));

		if (!hub.isActive()) {
			throw new BadRequestException("Cannot dispatch shipment from an inactive hub");
		}

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

		if (shipment.getCurrentHubId() == null) {
			throw new BadRequestException("Shipment is not currently associated with a hub");
		}

		if (!hub.getId().equals(shipment.getCurrentHubId())) {
			throw new BadRequestException("Shipment does not belong to your hub");
		}

		if (shipment.getDestinationHubId() == null) {
			throw new BadRequestException("Shipment destination hub is not configured");
		}

		if (hub.getId().equals(shipment.getDestinationHubId())) {
			throw new BadRequestException("Shipment is already at its destination hub");
		}

		if (shipment.getStatus() != ShipmentStatus.IN_TRANSIT) {
			throw new BadRequestException("Only in-transit shipments can be dispatched");
		}

		addTrackingEvent(shipment, ShipmentStatus.IN_TRANSIT, hub.getAddress().getCity(),
				"Shipment dispatched from hub", username, "Shipment dispatched towards destination hub");

		shipment.setUpdatedAt(LocalDateTime.now());

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
}