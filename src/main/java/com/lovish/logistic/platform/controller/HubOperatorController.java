package com.lovish.logistic.platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.service.HubOperatorService;

@RestController
@RequestMapping("/api/hub")
public class HubOperatorController {

	private final HubOperatorService hubOperatorService;

	public HubOperatorController(HubOperatorService hubOperatorService) {
		super();
		this.hubOperatorService = hubOperatorService;
	}

	@PatchMapping("/shipments/{shipmentId}/assign")
	@PreAuthorize("hasAnyRole('HUB_OPERATOR', 'ADMIN')")
	public ResponseEntity<Void> assignShipment(@PathVariable String shipmentId, @RequestParam String deliveryAgentId) {

		hubOperatorService.assignShipment(shipmentId, deliveryAgentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/reassign")
	@PreAuthorize("hasAnyRole('HUB_OPERATOR', 'ADMIN')")
	public ResponseEntity<Void> reassignShipment(@PathVariable String shipmentId,
			@RequestParam String deliveryAgentId) {

		hubOperatorService.reassignShipment(shipmentId, deliveryAgentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/retry")
	@PreAuthorize("hasRole('HUB_OPERATOR')")
	public ResponseEntity<Void> retryShipment(@PathVariable String shipmentId, @RequestParam String deliveryAgentId) {

		hubOperatorService.retryShipment(shipmentId, deliveryAgentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/pickup-from-hub")
	@PreAuthorize("hasRole('HUB_OPERATOR')")
	public ResponseEntity<Void> markPickupFromHub(@PathVariable String shipmentId) {

		hubOperatorService.markPickupFromHub(shipmentId);

		return ResponseEntity.ok().build();
	}

}
