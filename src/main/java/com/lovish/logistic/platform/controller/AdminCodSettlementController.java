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

import com.lovish.logistic.platform.dto.AdminCodSettlementDto;
import com.lovish.logistic.platform.dto.CodSettlementRequestDto;
import com.lovish.logistic.platform.service.AdminCodSettlementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/cod-settlements")
@PreAuthorize("hasRole('ADMIN')")
public class AdminCodSettlementController {

	private final AdminCodSettlementService settlementService;

	public AdminCodSettlementController(AdminCodSettlementService settlementService) {
		this.settlementService = settlementService;
	}

	@GetMapping("/pending")
	public ResponseEntity<List<AdminCodSettlementDto>> getPendingSettlements() {
		return ResponseEntity.ok(settlementService.getPendingSettlements());
	}

	@PatchMapping("/{shipmentId}/settle")
	public ResponseEntity<AdminCodSettlementDto> settleCod(@PathVariable String shipmentId,
			@Valid @RequestBody CodSettlementRequestDto request) {

		return ResponseEntity.ok(settlementService.settleCod(shipmentId, request));
	}
}