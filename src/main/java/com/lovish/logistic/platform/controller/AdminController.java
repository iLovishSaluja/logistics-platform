package com.lovish.logistic.platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.service.DeliveryAgentService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private final DeliveryAgentService deliveryAgentService;

	public AdminController(DeliveryAgentService deliveryAgentService) {

		this.deliveryAgentService = deliveryAgentService;
	}

	@PatchMapping("/shipments/{shipmentId}/assign")
	public ResponseEntity<Void> assignShipment(@PathVariable String shipmentId, @RequestParam String deliveryAgentId) {

		deliveryAgentService.assignShipment(shipmentId, deliveryAgentId);

		return ResponseEntity.ok().build();
	}
}