package com.lovish.logistic.platform.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.lovish.logistic.platform.dto.CreateOnlinePaymentResponseDto;
import com.lovish.logistic.platform.dto.OnlinePaymentResponseDto;
import com.lovish.logistic.platform.dto.RefundPaymentRequestDto;
import com.lovish.logistic.platform.dto.VerifyOnlinePaymentRequestDto;
import com.lovish.logistic.platform.service.OnlinePaymentService;

@RestController
@RequestMapping("/api")
public class OnlinePaymentController {

	private final OnlinePaymentService onlinePaymentService;

	public OnlinePaymentController(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	@PostMapping("/customer/payments/shipments/{shipmentId}/order")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('CUSTOMER')")
	public CreateOnlinePaymentResponseDto createOrder(@PathVariable String shipmentId) {

		return onlinePaymentService.createOrder(shipmentId);
	}

	@PostMapping("/customer/payments/verify")
	@PreAuthorize("hasRole('CUSTOMER')")
	public OnlinePaymentResponseDto verifyPayment(@Valid @RequestBody VerifyOnlinePaymentRequestDto request) {

		return onlinePaymentService.verifyPayment(request);
	}

	@GetMapping("/customer/payments/my")
	@PreAuthorize("hasRole('CUSTOMER')")
	public List<OnlinePaymentResponseDto> getMyPayments() {
		return onlinePaymentService.getMyPayments();
	}

	@PostMapping("/admin/payments/{paymentId}/refund")
	@PreAuthorize("hasRole('ADMIN')")
	public OnlinePaymentResponseDto refundPayment(@PathVariable String paymentId,
			@Valid @RequestBody RefundPaymentRequestDto request) {

		return onlinePaymentService.refundPayment(paymentId, request);
	}
}