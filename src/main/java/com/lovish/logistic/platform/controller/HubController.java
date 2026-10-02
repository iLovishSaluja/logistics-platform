package com.lovish.logistic.platform.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.HubCreateRequestDto;
import com.lovish.logistic.platform.dto.HubResponseDto;
import com.lovish.logistic.platform.service.HubService;
import com.lovish.logistic.platform.service.HubStaffService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/hubs")
@Validated
public class HubController {

	private final HubService hubService;
	private final HubStaffService hubStaffService;

	public HubController(HubService hubService, HubStaffService hubStaffService) {
		super();
		this.hubService = hubService;
		this.hubStaffService = hubStaffService;
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HubResponseDto> createHub(@Valid @RequestBody HubCreateRequestDto request) {

		HubResponseDto response = hubService.createHub(request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<HubResponseDto>> getAllHubs() {

		return ResponseEntity.ok(hubService.getAllHubs());
	}

	@GetMapping("/{hubId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HubResponseDto> getHubById(@PathVariable String hubId) {

		return ResponseEntity.ok(hubService.getHubById(hubId));
	}

	@PutMapping("/{hubId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HubResponseDto> updateHub(@PathVariable String hubId,
			@Valid @RequestBody HubCreateRequestDto request) {

		return ResponseEntity.ok(hubService.updateHub(hubId, request));
	}

	@PatchMapping("/{hubId}/deactivate")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> deactivateHub(@PathVariable String hubId) {

		hubService.deactivateHub(hubId);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{hubId}/operators/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> assignHubOperator(@PathVariable String hubId, @PathVariable String userId) {

		hubStaffService.assignHubOperator(hubId, userId);

		return ResponseEntity.noContent().build();
	}

	@PatchMapping("/{hubId}/agents/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Void> assignDeliveryAgent(@PathVariable String hubId, @PathVariable String userId) {

		hubStaffService.assignDeliveryAgent(hubId, userId);

		return ResponseEntity.noContent().build();
	}

}