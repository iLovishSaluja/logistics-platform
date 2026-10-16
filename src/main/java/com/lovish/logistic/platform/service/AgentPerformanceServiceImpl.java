package com.lovish.logistic.platform.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.AgentPerformanceStatsDto;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.Role;
import com.lovish.logistic.platform.enums.ShipmentStatus;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.repository.DeliveryAttemptRepository;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class AgentPerformanceServiceImpl implements AgentPerformanceService {

	private final UserRepository userRepository;
	private final ShipmentRepository shipmentRepository;
	private final DeliveryAttemptRepository deliveryAttemptRepository;

	public AgentPerformanceServiceImpl(UserRepository userRepository, ShipmentRepository shipmentRepository,
			DeliveryAttemptRepository deliveryAttemptRepository) {

		super();
		this.userRepository = userRepository;
		this.shipmentRepository = shipmentRepository;
		this.deliveryAttemptRepository = deliveryAttemptRepository;
	}

	@Override
	public AgentPerformanceStatsDto getCurrentAgentPerformance() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User deliveryAgent = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current delivery agent not found"));

		if (deliveryAgent.getRole() != Role.DELIVERY_AGENT) {
			throw new ResourceNotFoundException("Current user is not a delivery agent");
		}

		String deliveryAgentId = deliveryAgent.getId();

		long totalAssigned = shipmentRepository.countByAssignedDeliveryAgentId(deliveryAgentId);

		long totalDelivered = shipmentRepository.countByAssignedDeliveryAgentIdAndStatus(deliveryAgentId,
				ShipmentStatus.DELIVERED);

		long totalFailedDeliveryAttempts = deliveryAttemptRepository.countByDeliveryAgentId(deliveryAgentId);

		List<ShipmentStatus> activeStatuses = Arrays.asList(ShipmentStatus.CONFIRMED, ShipmentStatus.PICKED_UP,
				ShipmentStatus.IN_TRANSIT, ShipmentStatus.OUT_FOR_DELIVERY, ShipmentStatus.FAILED_DELIVERY);

		long activeShipments = shipmentRepository.countByAssignedDeliveryAgentIdAndStatusIn(deliveryAgentId,
				activeStatuses);

		BigDecimal successRate;

		if (totalAssigned == 0) {
			successRate = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		} else {
			successRate = BigDecimal.valueOf(totalDelivered).multiply(BigDecimal.valueOf(100))
					.divide(BigDecimal.valueOf(totalAssigned), 2, RoundingMode.HALF_UP);
		}

		AgentPerformanceStatsDto response = new AgentPerformanceStatsDto();

		response.setTotalAssigned(totalAssigned);
		response.setTotalDelivered(totalDelivered);
		response.setTotalFailedDeliveryAttempts(totalFailedDeliveryAttempts);
		response.setActiveShipments(activeShipments);
		response.setSuccessRate(successRate);

		return response;
	}
}