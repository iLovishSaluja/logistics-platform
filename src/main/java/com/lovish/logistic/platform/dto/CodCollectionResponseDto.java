package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lovish.logistic.platform.enums.CodCollectionStatus;

public class CodCollectionResponseDto {

	private String shipmentId;
	private String trackingNumber;
	private BigDecimal expectedCodAmount;
	private BigDecimal collectedAmount;
	private CodCollectionStatus codCollectionStatus;
	private LocalDateTime collectedAt;
	private String collectedByAgentId;
	private String notes;

	public CodCollectionResponseDto() {
	}

	public CodCollectionResponseDto(String shipmentId, String trackingNumber, BigDecimal expectedCodAmount,
			BigDecimal collectedAmount, CodCollectionStatus codCollectionStatus, LocalDateTime collectedAt,
			String collectedByAgentId, String notes) {

		this.shipmentId = shipmentId;
		this.trackingNumber = trackingNumber;
		this.expectedCodAmount = expectedCodAmount;
		this.collectedAmount = collectedAmount;
		this.codCollectionStatus = codCollectionStatus;
		this.collectedAt = collectedAt;
		this.collectedByAgentId = collectedByAgentId;
		this.notes = notes;
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

	public LocalDateTime getCollectedAt() {
		return collectedAt;
	}

	public void setCollectedAt(LocalDateTime collectedAt) {
		this.collectedAt = collectedAt;
	}

	public String getCollectedByAgentId() {
		return collectedByAgentId;
	}

	public void setCollectedByAgentId(String collectedByAgentId) {
		this.collectedByAgentId = collectedByAgentId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}