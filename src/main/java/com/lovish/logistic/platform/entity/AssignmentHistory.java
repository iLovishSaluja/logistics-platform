package com.lovish.logistic.platform.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lovish.logistic.platform.enums.AssignmentAction;

@Document(collection = "assignment_history")
public class AssignmentHistory {

	@Id
	private String id;

	private String shipmentId;

	private String deliveryAgentId;

	private String previousDeliveryAgentId;

	private String performedBy;

	private AssignmentAction action;

	private String hubId;

	private LocalDateTime timestamp;

	private String reason;

	private String notes;

	public AssignmentHistory() {
		super();
	}

	public AssignmentHistory(String id, String shipmentId, String deliveryAgentId, String previousDeliveryAgentId,
			String performedBy, AssignmentAction action, String hubId, LocalDateTime timestamp, String reason,
			String notes) {

		super();
		this.id = id;
		this.shipmentId = shipmentId;
		this.deliveryAgentId = deliveryAgentId;
		this.previousDeliveryAgentId = previousDeliveryAgentId;
		this.performedBy = performedBy;
		this.action = action;
		this.hubId = hubId;
		this.timestamp = timestamp;
		this.reason = reason;
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

	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}

	public void setDeliveryAgentId(String deliveryAgentId) {
		this.deliveryAgentId = deliveryAgentId;
	}

	public String getPreviousDeliveryAgentId() {
		return previousDeliveryAgentId;
	}

	public void setPreviousDeliveryAgentId(String previousDeliveryAgentId) {
		this.previousDeliveryAgentId = previousDeliveryAgentId;
	}

	public String getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	public AssignmentAction getAction() {
		return action;
	}

	public void setAction(AssignmentAction action) {
		this.action = action;
	}

	public String getHubId() {
		return hubId;
	}

	public void setHubId(String hubId) {
		this.hubId = hubId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}