package com.lovish.logistic.platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.AssignShipmentRequestDto;
import com.lovish.logistic.platform.service.DeliveryAgentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private final DeliveryAgentService deliveryAgentService;

	public AdminController(DeliveryAgentService deliveryAgentService) {

		this.deliveryAgentService = deliveryAgentService;
	}

	@PostMapping("/shipments/{shipmentId}/assign")
	public ResponseEntity<Void> assignShipment(@PathVariable String shipmentId,
			@Valid @RequestBody AssignShipmentRequestDto request) {

		deliveryAgentService.assignShipment(shipmentId, request.getDeliveryAgentId());

		return ResponseEntity.ok().build();
	}
}