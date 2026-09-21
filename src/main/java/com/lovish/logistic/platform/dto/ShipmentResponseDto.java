package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lovish.logistic.platform.enums.ShipmentStatus;

import com.lovish.logistic.platform.enums.*;

public class ShipmentResponseDto {

	private String id;
	private String trackingNumber;
	private String customerId;

	private AddressDto senderAddress;
	private AddressDto receiverAddress;
	private PackageDetailsDto packageDetails;

	private Priority priority;
	private BigDecimal cost;
	private ShipmentStatus status;

	private String assignedDeliveryAgentId;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public ShipmentResponseDto() {
		super();
	}

	public ShipmentResponseDto(String id, String trackingNumber, String customerId, AddressDto senderAddress,
			AddressDto receiverAddress, PackageDetailsDto packageDetails, Priority priority, BigDecimal cost,
			ShipmentStatus status, String assignedDeliveryAgentId, LocalDateTime createdAt, LocalDateTime updatedAt) {
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
		this.assignedDeliveryAgentId = assignedDeliveryAgentId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public AddressDto getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(AddressDto senderAddress) {
		this.senderAddress = senderAddress;
	}

	public AddressDto getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(AddressDto receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public PackageDetailsDto getPackageDetails() {
		return packageDetails;
	}

	public void setPackageDetails(PackageDetailsDto packageDetails) {
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

}
