package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lovish.logistic.platform.enums.ShipmentStatus;

import com.lovish.logistic.platform.enums.*;

public class ShipmentSummaryDto {

	private String id;
	private String trackingNumber;
	private ShipmentStatus status;
	private Priority priority;
	private BigDecimal cost;
	private LocalDateTime createdAt;

	public ShipmentSummaryDto() {
		super();
	}

	public ShipmentSummaryDto(String id, String trackingNumber, ShipmentStatus status, Priority priority,
			BigDecimal cost, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.trackingNumber = trackingNumber;
		this.status = status;
		this.priority = priority;
		this.cost = cost;
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
