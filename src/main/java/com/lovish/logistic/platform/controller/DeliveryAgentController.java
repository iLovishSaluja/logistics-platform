package com.lovish.logistic.platform.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.FailedDeliveryRequestDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.service.DeliveryAgentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/delivery")
@PreAuthorize("hasRole('DELIVERY_AGENT')")
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

	@PatchMapping("/shipments/{shipmentId}/accept")
	public ResponseEntity<Void> acceptAssignment(@PathVariable String shipmentId) {

		deliveryAgentService.acceptAssignment(shipmentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/reject")
	public ResponseEntity<Void> rejectAssignment(@PathVariable String shipmentId) {

		deliveryAgentService.rejectAssignment(shipmentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/pickup")
	public ResponseEntity<Void> pickupShipment(@PathVariable String shipmentId) {

		deliveryAgentService.pickupShipment(shipmentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/in-transit")
	public ResponseEntity<Void> markInTransit(@PathVariable String shipmentId) {

		deliveryAgentService.markInTransit(shipmentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/out-for-delivery")
	public ResponseEntity<Void> markOutForDelivery(@PathVariable String shipmentId) {

		deliveryAgentService.markOutForDelivery(shipmentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/delivered")
	public ResponseEntity<Void> markDelivered(@PathVariable String shipmentId) {

		deliveryAgentService.markDelivered(shipmentId);

		return ResponseEntity.ok().build();
	}

	@PatchMapping("/shipments/{shipmentId}/failed-delivery")
	public ResponseEntity<Void> markFailedDelivery(@PathVariable String shipmentId,
			@Valid @RequestBody FailedDeliveryRequestDto request) {

		deliveryAgentService.markFailedDelivery(shipmentId, request);

		return ResponseEntity.ok().build();
	}
}