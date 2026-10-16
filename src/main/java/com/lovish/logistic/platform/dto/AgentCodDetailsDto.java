package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;

import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.PaymentMethod;

public class AgentCodDetailsDto {

	private String shipmentId;
	private String trackingNumber;
	private PaymentMethod paymentMethod;
	private BigDecimal codAmount;
	private CodCollectionStatus codCollectionStatus;

	public AgentCodDetailsDto() {
	}

	public AgentCodDetailsDto(String shipmentId, String trackingNumber, PaymentMethod paymentMethod,
			BigDecimal codAmount, CodCollectionStatus codCollectionStatus) {
		this.shipmentId = shipmentId;
		this.trackingNumber = trackingNumber;
		this.paymentMethod = paymentMethod;
		this.codAmount = codAmount;
		this.codCollectionStatus = codCollectionStatus;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getCodAmount() {
		return codAmount;
	}

	public void setCodAmount(BigDecimal codAmount) {
		this.codAmount = codAmount;
	}

	public CodCollectionStatus getCodCollectionStatus() {
		return codCollectionStatus;
	}

	public void setCodCollectionStatus(CodCollectionStatus codCollectionStatus) {
		this.codCollectionStatus = codCollectionStatus;
	}
}
