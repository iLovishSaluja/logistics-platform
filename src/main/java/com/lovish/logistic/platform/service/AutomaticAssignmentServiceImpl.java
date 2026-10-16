package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.entity.Hub;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.AssignmentAction;
import com.lovish.logistic.platform.enums.AssignmentStatus;
import com.lovish.logistic.platform.enums.Role;
import com.lovish.logistic.platform.enums.ShipmentStatus;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.repository.HubRepository;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class AutomaticAssignmentServiceImpl implements AutomaticAssignmentService {

	private final ShipmentRepository shipmentRepository;
	private final UserRepository userRepository;
	private final HubRepository hubRepository;
	private final AssignmentHistoryService assignmentHistoryService;

	public AutomaticAssignmentServiceImpl(ShipmentRepository shipmentRepository, UserRepository userRepository,
			HubRepository hubRepository, AssignmentHistoryService assignmentHistoryService) {

		this.shipmentRepository = shipmentRepository;
		this.userRepository = userRepository;
		this.hubRepository = hubRepository;
		this.assignmentHistoryService = assignmentHistoryService;
	}

	@Override
	public void automaticallyAssignShipment(String shipmentId) {

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		if (shipment.getCurrentHubId() == null || shipment.getCurrentHubId().isBlank()) {

			throw new BadRequestException("Shipment is not assigned to any hub");
		}

		Hub hub = hubRepository.findById(shipment.getCurrentHubId())
				.orElseThrow(() -> new ResourceNotFoundException("Shipment's current hub not found"));

		if (!hub.isActive()) {
			throw new BadRequestException("Shipment's current hub is inactive");
		}

		if (!hub.isAutomaticAssignmentEnabled()) {
			return;
		}

		if (shipment.getAssignedDeliveryAgentId() != null) {
			return;
		}

		if (shipment.getStatus() != ShipmentStatus.CREATED && shipment.getStatus() != ShipmentStatus.CONFIRMED) {

			return;
		}

		List<User> eligibleAgents = userRepository.findByRoleAndHubIdAndEnabledTrue(Role.DELIVERY_AGENT,
				shipment.getCurrentHubId());

		if (eligibleAgents.isEmpty()) {
			return;
		}

		List<ShipmentStatus> activeStatuses = Arrays.asList(ShipmentStatus.CONFIRMED, ShipmentStatus.PICKED_UP,
				ShipmentStatus.IN_TRANSIT, ShipmentStatus.OUT_FOR_DELIVERY);

		User selectedAgent = eligibleAgents.stream().min(Comparator.comparingLong(agent -> shipmentRepository
				.findByAssignedDeliveryAgentIdAndStatusIn(agent.getId(), activeStatuses).size())).orElse(null);

		if (selectedAgent == null) {
			return;
		}

		LocalDateTime now = LocalDateTime.now();

		shipment.setAssignedDeliveryAgentId(selectedAgent.getId());

		shipment.setAssignmentStatus(AssignmentStatus.PENDING);

		shipment.setUpdatedAt(now);

		shipmentRepository.save(shipment);

		assignmentHistoryService.recordAssignment(shipment.getId(), selectedAgent.getId(), null, "SYSTEM",
				AssignmentAction.ASSIGNED, shipment.getCurrentHubId(), "Automatic assignment",
				"Shipment automatically assigned based on delivery agent workload");
	}
}