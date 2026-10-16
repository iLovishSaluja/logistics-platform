package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.CodSettlementStatus;

public class CodSettlementReportItemDto {

	private String shipmentId;
	private String trackingNumber;
	private String deliveryAgentId;

	private BigDecimal expectedCodAmount;
	private BigDecimal collectedAmount;

	private CodCollectionStatus codCollectionStatus;
	private CodSettlementStatus codSettlementStatus;

	private LocalDateTime collectedAt;
	private LocalDateTime settledAt;

	public CodSettlementReportItemDto() {
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

	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}

	public void setDeliveryAgentId(String deliveryAgentId) {
		this.deliveryAgentId = deliveryAgentId;
	}

	public BigDecimal getExpectedCodAmount() {
		return expectedCodAmount;
	}

	public void setExpectedCodAmount(BigDecimal expectedCodAmount) {
		this.expectedCodAmount = expectedCodAmount;
	}

	public BigDecimal getCollectedAmount() {
		return collectedAmount;
	}

	public void setCollectedAmount(BigDecimal collectedAmount) {
		this.collectedAmount = collectedAmount;
	}

	public CodCollectionStatus getCodCollectionStatus() {
		return codCollectionStatus;
	}

	public void setCodCollectionStatus(CodCollectionStatus codCollectionStatus) {
		this.codCollectionStatus = codCollectionStatus;
	}

	public CodSettlementStatus getCodSettlementStatus() {
		return codSettlementStatus;
	}

	public void setCodSettlementStatus(CodSettlementStatus codSettlementStatus) {
		this.codSettlementStatus = codSettlementStatus;
	}

	public LocalDateTime getCollectedAt() {
		return collectedAt;
	}

	public void setCollectedAt(LocalDateTime collectedAt) {
		this.collectedAt = collectedAt;
	}

	public LocalDateTime getSettledAt() {
		return settledAt;
	}

	public void setSettledAt(LocalDateTime settledAt) {
		this.settledAt = settledAt;
	}
}