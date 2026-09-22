package com.lovish.logistic.platform.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.service.DeliveryAgentService;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryAgentController {

	private final DeliveryAgentService deliveryAgentService;

	public DeliveryAgentController(DeliveryAgentService deliveryAgentService) {

		this.deliveryAgentService = deliveryAgentService;
	}

	@GetMapping("/shipments")
	public ResponseEntity<List<ShipmentSummaryDto>> getAssignedShipments() {

		List<ShipmentSummaryDto> shipments = deliveryAgentService.getAssignedShipments();

		return ResponseEntity.ok(shipments);
	}
}