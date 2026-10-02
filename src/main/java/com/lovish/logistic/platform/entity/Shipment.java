package com.lovish.logistic.platform.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.lovish.logistic.platform.enums.AssignmentStatus;
import com.lovish.logistic.platform.enums.Priority;
import com.lovish.logistic.platform.enums.ShipmentStatus;

public class Shipment {

	private String id;
	private String trackingNumber;
	private String customerId;

	private Address senderAddress;
	private Address receiverAddress;
	private PackageDetails packageDetails;

	private Priority priority;
	private BigDecimal cost;
	private ShipmentStatus status;

	@Field(write = Field.Write.ALWAYS)
	private String currentHubId;

	@Field(write = Field.Write.ALWAYS)
	private String destinationHubId;

	@Field(write=Field.Write.ALWAYS)
	private String assignedDeliveryAgentId;

	@Field(write = Field.Write.ALWAYS)
	private AssignmentStatus assignmentStatus;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private List<TrackingHistory> trackingHistory;

	public Shipment() {
		super();
	}

	public Shipment(String id, String trackingNumber, String customerId, Address senderAddress, Address receiverAddress,
			PackageDetails packageDetails, Priority priority, BigDecimal cost, ShipmentStatus status,
			String currentHubId, String destinationHubId, String assignedDeliveryAgentId,
			AssignmentStatus assignmentStatus, LocalDateTime createdAt, LocalDateTime updatedAt,
			List<TrackingHistory> trackingHistory) {
		super();
		this.id = id;
		this.trackingNumber = trackingNumber;
		this.customerId = customerId;
		this.senderAddress = senderAddress;
		this.receiverAddress = receiverAddress;
		this.packageDetails = packageDetails;
		this.priority = priority;
		this.cost = cost;
		this.status = status;
		this.currentHubId = currentHubId;
		this.destinationHubId = destinationHubId;
		this.assignedDeliveryAgentId = assignedDeliveryAgentId;
		this.assignmentStatus = assignmentStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.trackingHistory = trackingHistory;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Address getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(Address senderAddress) {
		this.senderAddress = senderAddress;
	}

	public Address getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(Address receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public PackageDetails getPackageDetails() {
		return packageDetails;
	}

	public void setPackageDetails(PackageDetails packageDetails) {
		this.packageDetails = packageDetails;
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

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}

	public String getAssignedDeliveryAgentId() {
		return assignedDeliveryAgentId;
	}

	public void setAssignedDeliveryAgentId(String assignedDeliveryAgentId) {
		this.assignedDeliveryAgentId = assignedDeliveryAgentId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<TrackingHistory> getTrackingHistory() {
		return trackingHistory;
	}

	public void setTrackingHistory(List<TrackingHistory> trackingHistory) {
		this.trackingHistory = trackingHistory;
	}

	public AssignmentStatus getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public String getCurrentHubId() {
		return currentHubId;
	}

	public void setCurrentHubId(String currentHubId) {
		this.currentHubId = currentHubId;
	}

	public String getDestinationHubId() {
		return destinationHubId;
	}

	public void setDestinationHubId(String destinationHubId) {
		this.destinationHubId = destinationHubId;
	}

}
