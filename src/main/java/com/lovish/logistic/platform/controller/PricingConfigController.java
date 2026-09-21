package com.lovish.logistic.platform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.PricingConfigRequestDto;
import com.lovish.logistic.platform.dto.PricingConfigResponseDto;
import com.lovish.logistic.platform.service.PricingConfigService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/pricing")
@Validated
public class PricingConfigController {

	private final PricingConfigService pricingConfigService;

	public PricingConfigController(PricingConfigService pricingConfigService) {

		this.pricingConfigService = pricingConfigService;
	}

	@PostMapping
	public ResponseEntity<PricingConfigResponseDto> createPricingConfig(
			@Valid @RequestBody PricingConfigRequestDto request) {

		PricingConfigResponseDto response = pricingConfigService.createPricingConfig(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/active")
	public ResponseEntity<PricingConfigResponseDto> getActivePricingConfig() {

		PricingConfigResponseDto response = pricingConfigService.getActivePricingConfig();

		return ResponseEntity.ok(response);
	}
}