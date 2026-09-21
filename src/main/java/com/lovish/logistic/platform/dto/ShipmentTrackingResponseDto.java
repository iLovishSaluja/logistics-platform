package com.lovish.logistic.platform.dto;

import java.util.List;

import com.lovish.logistic.platform.enums.ShipmentStatus;

public class ShipmentTrackingResponseDto {

	private String trackingNumber;
	private ShipmentStatus status;
	private List<TrackingHistoryDto> trackingHistory;

	public ShipmentTrackingResponseDto() {
		super();
	}

	public ShipmentTrackingResponseDto(String trackingNumber, ShipmentStatus status,
			List<TrackingHistoryDto> trackingHistory) {
		super();
		this.trackingNumber = trackingNumber;
		this.status = status;
		this.trackingHistory = trackingHistory;
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

	public List<TrackingHistoryDto> getTrackingHistory() {
		return trackingHistory;
	}

	public void setTrackingHistory(List<TrackingHistoryDto> trackingHistory) {
		this.trackingHistory = trackingHistory;
	}
}