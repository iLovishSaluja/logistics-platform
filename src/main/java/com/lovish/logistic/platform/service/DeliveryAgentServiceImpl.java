package com.lovish.logistic.platform.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.mapper.ShipmentMapper;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService {

	private final ShipmentRepository shipmentRepository;
	private final ShipmentMapper shipmentMapper;
	private final UserRepository userRepository;

	public DeliveryAgentServiceImpl(ShipmentRepository shipmentRepository, ShipmentMapper shipmentMapper,
			UserRepository userRepository) {

		this.shipmentRepository = shipmentRepository;
		this.shipmentMapper = shipmentMapper;
		this.userRepository = userRepository;
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
		shipment.setUpdatedAt(java.time.LocalDateTime.now());

		shipmentRepository.save(shipment);
	}
}