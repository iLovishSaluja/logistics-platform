package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;

public class AgentPerformanceStatsDto {

	private long totalAssigned;
	private long totalDelivered;
	private long totalFailedDeliveryAttempts;
	private long activeShipments;
	private BigDecimal successRate;

	public long getTotalAssigned() {
		return totalAssigned;
	}

	public void setTotalAssigned(long totalAssigned) {
		this.totalAssigned = totalAssigned;
	}

	public long getTotalDelivered() {
		return totalDelivered;
	}

	public void setTotalDelivered(long totalDelivered) {
		this.totalDelivered = totalDelivered;
	}

	public long getTotalFailedDeliveryAttempts() {
		return totalFailedDeliveryAttempts;
	}

	public void setTotalFailedDeliveryAttempts(long totalFailedDeliveryAttempts) {
		this.totalFailedDeliveryAttempts = totalFailedDeliveryAttempts;
	}

	public long getActiveShipments() {
		return activeShipments;
	}

	public void setActiveShipments(long activeShipments) {
		this.activeShipments = activeShipments;
	}

	public BigDecimal getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(BigDecimal successRate) {
		this.successRate = successRate;
	}
}