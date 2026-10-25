package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;

public class CreateOnlinePaymentResponseDto {

	private String shipmentId;
	private String onlinePaymentId;
	private String razorpayOrderId;
	private String razorpayKeyId;
	private BigDecimal amount;
	private String currency;
	private String status;

	public CreateOnlinePaymentResponseDto() {
	}

	public CreateOnlinePaymentResponseDto(String shipmentId, String onlinePaymentId, String razorpayOrderId,
			String razorpayKeyId, BigDecimal amount, String currency, String status) {
		this.shipmentId = shipmentId;
		this.onlinePaymentId = onlinePaymentId;
		this.razorpayOrderId = razorpayOrderId;
		this.razorpayKeyId = razorpayKeyId;
		this.amount = amount;
		this.currency = currency;
		this.status = status;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public String getOnlinePaymentId() {
		return onlinePaymentId;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}

	public String getRazorpayKeyId() {
		return razorpayKeyId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public String getStatus() {
		return status;
	}
}