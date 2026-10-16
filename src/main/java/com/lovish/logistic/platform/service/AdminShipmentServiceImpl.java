package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.ShipmentResponseDto;
import com.lovish.logistic.platform.entity.Hub;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.AssignmentAction;
import com.lovish.logistic.platform.enums.AssignmentStatus;
import com.lovish.logistic.platform.enums.Role;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.mapper.ShipmentMapper;
import com.lovish.logistic.platform.repository.HubRepository;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class AdminShipmentServiceImpl implements AdminShipmentService {

	private final ShipmentRepository shipmentRepository;
	private final UserRepository userRepository;
	private final HubRepository hubRepository;
	private final AssignmentHistoryService assignmentHistoryService;
	private final ShipmentMapper shipmentMapper;

	public AdminShipmentServiceImpl(ShipmentRepository shipmentRepository, UserRepository userRepository,
			HubRepository hubRepository, AssignmentHistoryService assignmentHistoryService,
			ShipmentMapper shipmentMapper) {

		this.shipmentRepository = shipmentRepository;
		this.userRepository = userRepository;
		this.hubRepository = hubRepository;
		this.assignmentHistoryService = assignmentHistoryService;
		this.shipmentMapper = shipmentMapper;
	}

	@Override
	public ShipmentResponseDto emergencyAssignShipment(String shipmentId, String deliveryAgentId) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User admin = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current admin not found"));

		if (admin.getRole() != Role.ADMIN) {
			throw new AccessDeniedException("Only an admin can perform emergency assignment");
		}

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getCurrentHubId() == null || shipment.getCurrentHubId().isBlank()) {

			throw new BadRequestException("Shipment is not assigned to any hub");
		}

		Hub currentHub = hubRepository.findById(shipment.getCurrentHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Current hub not found"));

		if (!currentHub.isActive()) {
			throw new BadRequestException("Shipment's current hub is inactive");
		}

		User deliveryAgent = userRepository.findById(deliveryAgentId).orElseThrow(
				() -> new ResourceNotFoundException("Delivery agent not found with id: " + deliveryAgentId));

		if (deliveryAgent.getRole() != Role.DELIVERY_AGENT) {
			throw new BadRequestException("Selected user is not a delivery agent");
		}

		if (!deliveryAgent.isEnabled()) {
			throw new BadRequestException("Selected delivery agent is disabled");
		}

		if (deliveryAgent.getHubId() == null || !deliveryAgent.getHubId().equals(shipment.getCurrentHubId())) {

			throw new BadRequestException("Delivery agent does not belong to the shipment's current hub");
		}

		String previousDeliveryAgentId = shipment.getAssignedDeliveryAgentId();

		shipment.setAssignedDeliveryAgentId(deliveryAgent.getId());
		shipment.setAssignmentStatus(AssignmentStatus.PENDING);

		LocalDateTime now = LocalDateTime.now();
		shipment.setUpdatedAt(now);

		Shipment savedShipment = shipmentRepository.save(shipment);

		assignmentHistoryService.recordAssignment(shipment.getId(), deliveryAgent.getId(), previousDeliveryAgentId,
				admin.getId(), AssignmentAction.EMERGENCY_ASSIGNED, shipment.getCurrentHubId(),
				"Emergency assignment performed by admin",
				previousDeliveryAgentId == null ? "No previous delivery agent was assigned"
						: "Previous delivery agent: " + previousDeliveryAgentId);

		return shipmentMapper.toResponseDto(savedShipment);
	}
}