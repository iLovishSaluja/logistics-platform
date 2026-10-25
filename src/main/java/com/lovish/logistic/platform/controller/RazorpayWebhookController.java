
package com.lovish.logistic.platform.controller;

import com.lovish.logistic.platform.service.RazorpayWebhookService;
import com.razorpay.RazorpayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks/razorpay")
public class RazorpayWebhookController {

	private final RazorpayWebhookService webhookService;

	public RazorpayWebhookController(RazorpayWebhookService webhookService) {
		this.webhookService = webhookService;
	}

	@PostMapping
	public ResponseEntity<String> receiveWebhook(@RequestBody(required = false) String body,
			@RequestHeader(name = "X-Razorpay-Signature", required = false) String signature) {

		try {
			webhookService.process(body, signature);
			return ResponseEntity.ok("Webhook processed");

		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body("Invalid webhook signature or payload");

		} catch (IllegalStateException ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Webhook configuration error");

		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Webhook processing failed");
		}
	}
}
