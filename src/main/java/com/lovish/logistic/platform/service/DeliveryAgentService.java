package com.lovish.logistic.platform.service;

import java.util.List;

import com.lovish.logistic.platform.dto.ShipmentSummaryDto;

public interface DeliveryAgentService {

	List<ShipmentSummaryDto> getAssignedShipments();

	void assignShipment(String shipmentId, String deliveryAgentId);

	void acceptAssignment(String shipmentId);
}