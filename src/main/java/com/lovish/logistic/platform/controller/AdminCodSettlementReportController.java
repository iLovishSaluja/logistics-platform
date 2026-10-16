package com.lovish.logistic.platform.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.CodSettlementReportDto;
import com.lovish.logistic.platform.service.CodSettlementReportService;

@RestController
@RequestMapping("/api/admin/cod-settlements")
@PreAuthorize("hasRole('ADMIN')")
public class AdminCodSettlementReportController {

	private final CodSettlementReportService reportService;

	public AdminCodSettlementReportController(CodSettlementReportService reportService) {
		this.reportService = reportService;
	}

	@GetMapping("/report")
	public ResponseEntity<CodSettlementReportDto> getReport(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,

			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,

			@RequestParam(required = false) String deliveryAgentId) {

		return ResponseEntity.ok(reportService.getReport(fromDate, toDate, deliveryAgentId));
	}
}