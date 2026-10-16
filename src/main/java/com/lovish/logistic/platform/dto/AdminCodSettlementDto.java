package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.CodSettlementStatus;

public class AdminCodSettlementDto {

	private String shipmentId;
	private String trackingNumber;
	private BigDecimal expectedCodAmount;
	private BigDecimal collectedAmount;
	private CodCollectionStatus codCollectionStatus;
	private CodSettlementStatus codSettlementStatus;
	private LocalDateTime collectedAt;
	private LocalDateTime settledAt;
	private String collectedByAgentId;
	private String settledByAdminId;
	private String notes;

	public AdminCodSettlementDto() {
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

	public String getCollectedByAgentId() {
		return collectedByAgentId;
	}

	public void setCollectedByAgentId(String collectedByAgentId) {
		this.collectedByAgentId = collectedByAgentId;
	}

	public String getSettledByAdminId() {
		return settledByAdminId;
	}

	public void setSettledByAdminId(String settledByAdminId) {
		this.settledByAdminId = settledByAdminId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}