package com.lovish.logistic.platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.EmergencyAssignmentRequestDto;
import com.lovish.logistic.platform.dto.ShipmentResponseDto;
import com.lovish.logistic.platform.service.AdminShipmentService;
import com.lovish.logistic.platform.service.DeliveryAgentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	private final DeliveryAgentService deliveryAgentService;
	private final AdminShipmentService adminShipmentService;

	public AdminController(DeliveryAgentService deliveryAgentService, AdminShipmentService adminShipmentService) {

		this.deliveryAgentService = deliveryAgentService;
		this.adminShipmentService = adminShipmentService;
	}

	@PatchMapping("/shipments/{shipmentId}/assign")
	public ResponseEntity<Void> assignShipment(@PathVariable String shipmentId, @RequestParam String deliveryAgentId) {

		deliveryAgentService.assignShipment(shipmentId, deliveryAgentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/emergency-assign")
	public ResponseEntity<ShipmentResponseDto> emergencyAssignShipment(@PathVariable String shipmentId,
			@Valid @RequestBody EmergencyAssignmentRequestDto request) {

		ShipmentResponseDto response = adminShipmentService.emergencyAssignShipment(shipmentId,
				request.getDeliveryAgentId());

		return ResponseEntity.ok(response);
	}
}