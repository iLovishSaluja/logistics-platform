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

import com.lovish.logistic.platform.dto.AgentCodDetailsDto;
import com.lovish.logistic.platform.dto.AgentPerformanceStatsDto;
import com.lovish.logistic.platform.dto.CodCollectionRequestDto;
import com.lovish.logistic.platform.dto.CodCollectionResponseDto;
import com.lovish.logistic.platform.dto.DeliveryOtpVerificationRequestDto;
import com.lovish.logistic.platform.dto.FailedDeliveryRequestDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.service.AgentPerformanceService;
import com.lovish.logistic.platform.service.DeliveryAgentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/delivery")
@PreAuthorize("hasRole('DELIVERY_AGENT')")
public class DeliveryAgentController {

	private final DeliveryAgentService deliveryAgentService;
	private final AgentPerformanceService agentPerformanceService;

	public DeliveryAgentController(DeliveryAgentService deliveryAgentService,
			AgentPerformanceService agentPerformanceService) {
		super();
		this.deliveryAgentService = deliveryAgentService;
		this.agentPerformanceService = agentPerformanceService;
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

	@PatchMapping("/shipments/{shipmentId}/deliver")
	@PreAuthorize("hasRole('DELIVERY_AGENT')")
	public ResponseEntity<Void> markDelivered(@PathVariable String shipmentId,
			@Valid @RequestBody DeliveryOtpVerificationRequestDto request) {

		deliveryAgentService.markDelivered(shipmentId, request.getOtp());

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/shipments/{shipmentId}/failed-delivery")
	public ResponseEntity<Void> markFailedDelivery(@PathVariable String shipmentId,
			@Valid @RequestBody FailedDeliveryRequestDto request) {

		deliveryAgentService.markFailedDelivery(shipmentId, request);

		return ResponseEntity.ok().build();
	}

	@GetMapping("/statistics")
	public ResponseEntity<AgentPerformanceStatsDto> getPerformanceStatistics() {

		AgentPerformanceStatsDto response = agentPerformanceService.getCurrentAgentPerformance();

		return ResponseEntity.ok(response);
	}

	@GetMapping("/shipments/cod")
	public ResponseEntity<List<AgentCodDetailsDto>> getAssignedCodShipments() {

		return ResponseEntity.ok(deliveryAgentService.getAssignedCodShipments());
	}

	@PatchMapping("/shipments/{shipmentId}/cod-collection")
	public ResponseEntity<CodCollectionResponseDto> collectCod(@PathVariable String shipmentId,
			@Valid @RequestBody CodCollectionRequestDto request) {

		return ResponseEntity.ok(deliveryAgentService.collectCod(shipmentId, request));
	}
}