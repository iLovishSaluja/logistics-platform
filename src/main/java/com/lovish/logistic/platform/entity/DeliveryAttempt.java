package com.lovish.logistic.platform.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lovish.logistic.platform.enums.FailedDeliveryReason;

@Document(collection = "delivery_attempts")
public class DeliveryAttempt {

	@Id
	private String id;

	private String shipmentId;

	private int attemptNumber;

	private String deliveryAgentId;

	private LocalDateTime attemptedAt;

	private FailedDeliveryReason failureReason;

	private String notes;

	public DeliveryAttempt() {
		super();
	}

	public DeliveryAttempt(String id, String shipmentId, int attemptNumber, String deliveryAgentId,
			LocalDateTime attemptedAt, FailedDeliveryReason failureReason, String notes) {

		super();
		this.id = id;
		this.shipmentId = shipmentId;
		this.attemptNumber = attemptNumber;
		this.deliveryAgentId = deliveryAgentId;
		this.attemptedAt = attemptedAt;
		this.failureReason = failureReason;
		this.notes = notes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public int getAttemptNumber() {
		return attemptNumber;
	}

	public void setAttemptNumber(int attemptNumber) {
		this.attemptNumber = attemptNumber;
	}

	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}

	public void setDeliveryAgentId(String deliveryAgentId) {
		this.deliveryAgentId = deliveryAgentId;
	}

	public LocalDateTime getAttemptedAt() {
		return attemptedAt;
	}

	public void setAttemptedAt(LocalDateTime attemptedAt) {
		this.attemptedAt = attemptedAt;
	}

	public FailedDeliveryReason getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(FailedDeliveryReason failureReason) {
		this.failureReason = failureReason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}