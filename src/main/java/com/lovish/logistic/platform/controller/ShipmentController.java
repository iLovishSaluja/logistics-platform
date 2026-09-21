package com.lovish.logistic.platform.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.PriceEstimateRequestDto;
import com.lovish.logistic.platform.dto.PriceEstimateResponseDto;
import com.lovish.logistic.platform.dto.ShipmentCreateRequestDto;
import com.lovish.logistic.platform.dto.ShipmentResponseDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.dto.ShipmentTrackingResponseDto;
import com.lovish.logistic.platform.dto.ShipmentUpdateRequestDto;
import com.lovish.logistic.platform.service.ShipmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

	private final ShipmentService shipmentService;

	public ShipmentController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}

	@PostMapping
	public ResponseEntity<ShipmentResponseDto> createShipment(@Valid @RequestBody ShipmentCreateRequestDto request) {

		ShipmentResponseDto response = shipmentService.createShipment(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShipmentResponseDto> getShipmentById(@PathVariable String id) {

		return ResponseEntity.ok(shipmentService.getShipmentById(id));
	}

	@GetMapping("/tracking/{trackingNumber}")
	public ResponseEntity<ShipmentResponseDto> getShipmentByTrackingNumber(@PathVariable String trackingNumber) {

		return ResponseEntity.ok(shipmentService.getShipmentByTrackingNumber(trackingNumber));
	}

	@GetMapping("/my")
	public ResponseEntity<List<ShipmentSummaryDto>> getMyShipments() {

		return ResponseEntity.ok(shipmentService.getMyShipments());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ShipmentResponseDto> updateShipment(@PathVariable String id,
			@Valid @RequestBody ShipmentUpdateRequestDto request) {

		return ResponseEntity.ok(shipmentService.updateShipment(id, request));
	}

	@PatchMapping("/{id}/cancel")
	public ResponseEntity<ShipmentResponseDto> cancelShipment(@PathVariable String id) {

		return ResponseEntity.ok(shipmentService.cancelShipment(id));
	}

	@PostMapping("/estimate")
	public ResponseEntity<PriceEstimateResponseDto> estimatePrice(@Valid @RequestBody PriceEstimateRequestDto request) {

		return ResponseEntity.ok(shipmentService.estimatePrice(request));
	}

	@GetMapping("/tracking/{trackingNumber}/history")
	public ResponseEntity<ShipmentTrackingResponseDto> getTrackingHistory(@PathVariable String trackingNumber) {

		ShipmentTrackingResponseDto response = shipmentService.getTrackingHistory(trackingNumber);

		return ResponseEntity.ok(response);
	}
}
