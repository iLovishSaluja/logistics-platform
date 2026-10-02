package com.lovish.logistic.platform.service;

import java.util.List;

import com.lovish.logistic.platform.dto.FailedDeliveryRequestDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;

public interface DeliveryAgentService {

	List<ShipmentSummaryDto> getAssignedShipments();

	void assignShipment(String shipmentId, String deliveryAgentId);

	void acceptAssignment(String shipmentId);

	void rejectAssignment(String shipmentId);

	void pickupShipment(String shipmentId);

	void markInTransit(String shipmentId);

	void markOutForDelivery(String shipmentId);

	void markDelivered(String shipmentId);

	void markFailedDelivery(String shipmentId, FailedDeliveryRequestDto request);
}