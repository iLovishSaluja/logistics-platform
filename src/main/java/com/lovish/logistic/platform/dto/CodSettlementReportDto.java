package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;
import java.util.List;

public class CodSettlementReportDto {

	private long totalCodShipments;
	private long totalCollectedShipments;
	private long totalSettledShipments;
	private long pendingSettlementShipments;

	private BigDecimal totalCodCollected = BigDecimal.ZERO;
	private BigDecimal totalCodSettled = BigDecimal.ZERO;
	private BigDecimal pendingSettlementAmount = BigDecimal.ZERO;

	private List<CodSettlementReportItemDto> shipments;

	public CodSettlementReportDto() {
	}

	public long getTotalCodShipments() {
		return totalCodShipments;
	}

	public void setTotalCodShipments(long totalCodShipments) {
		this.totalCodShipments = totalCodShipments;
	}

	public long getTotalCollectedShipments() {
		return totalCollectedShipments;
	}

	public void setTotalCollectedShipments(long totalCollectedShipments) {
		this.totalCollectedShipments = totalCollectedShipments;
	}

	public long getTotalSettledShipments() {
		return totalSettledShipments;
	}

	public void setTotalSettledShipments(long totalSettledShipments) {
		this.totalSettledShipments = totalSettledShipments;
	}

	public long getPendingSettlementShipments() {
		return pendingSettlementShipments;
	}

	public void setPendingSettlementShipments(long pendingSettlementShipments) {
		this.pendingSettlementShipments = pendingSettlementShipments;
	}

	public BigDecimal getTotalCodCollected() {
		return totalCodCollected;
	}

	public void setTotalCodCollected(BigDecimal totalCodCollected) {
		this.totalCodCollected = totalCodCollected;
	}

	public BigDecimal getTotalCodSettled() {
		return totalCodSettled;
	}

	public void setTotalCodSettled(BigDecimal totalCodSettled) {
		this.totalCodSettled = totalCodSettled;
	}

	public BigDecimal getPendingSettlementAmount() {
		return pendingSettlementAmount;
	}

	public void setPendingSettlementAmount(BigDecimal pendingSettlementAmount) {
		this.pendingSettlementAmount = pendingSettlementAmount;
	}

	public List<CodSettlementReportItemDto> getShipments() {
		return shipments;
	}

	public void setShipments(List<CodSettlementReportItemDto> shipments) {
		this.shipments = shipments;
	}
}