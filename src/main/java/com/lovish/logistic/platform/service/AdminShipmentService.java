package com.lovish.logistic.platform.service;

import com.lovish.logistic.platform.dto.ShipmentResponseDto;

public interface AdminShipmentService {

	ShipmentResponseDto emergencyAssignShipment(String shipmentId, String deliveryAgentId);
}