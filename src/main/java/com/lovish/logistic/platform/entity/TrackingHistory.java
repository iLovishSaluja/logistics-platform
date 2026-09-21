package com.lovish.logistic.platform.entity;

import java.time.LocalDateTime;

import com.lovish.logistic.platform.enums.ShipmentStatus;

public class TrackingHistory {

	private ShipmentStatus status;

	private LocalDateTime timestamp;

	private String location;

	private String description;

	private String performedBy;

	private String notes;

	public TrackingHistory() {
		super();
	}

	public TrackingHistory(ShipmentStatus status, LocalDateTime timestamp, String location, String description,
			String performedBy, String notes) {

		super();

		this.status = status;
		this.timestamp = timestamp;
		this.location = location;
		this.description = description;
		this.performedBy = performedBy;
		this.notes = notes;
	}

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}