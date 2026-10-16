package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lovish.logistic.platform.enums.AssignmentStatus;
import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.PaymentMethod;
import com.lovish.logistic.platform.enums.PaymentPayer;
import com.lovish.logistic.platform.enums.PaymentStatus;
import com.lovish.logistic.platform.enums.Priority;
import com.lovish.logistic.platform.enums.ShipmentStatus;
import com.lovish.logistic.platform.enums.ShipmentType;

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

	private String currentHubId;

	private String destinationHubId;

	private String assignedDeliveryAgentId;

	private AssignmentStatus assignmentStatus;

	private BigDecimal shippingCost;
	private BigDecimal codAmount;
	private PaymentMethod paymentMethod;
	private PaymentPayer paymentPayer;
	private ShipmentType shipmentType;
	private CodCollectionStatus codCollectionStatus;
	private PaymentStatus paymentStatus;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public ShipmentResponseDto() {
		super();
	}

	public ShipmentResponseDto(String id, String trackingNumber, String customerId, AddressDto senderAddress,
			AddressDto receiverAddress, PackageDetailsDto packageDetails, Priority priority, BigDecimal cost,
			ShipmentStatus status, String currentHubId, String destinationHubId, String assignedDeliveryAgentId,
			AssignmentStatus assignmentStatus, BigDecimal shippingCost, BigDecimal codAmount,
			PaymentMethod paymentMethod, PaymentPayer paymentPayer, ShipmentType shipmentType,
			CodCollectionStatus codCollectionStatus, PaymentStatus paymentStatus, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
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
		this.shippingCost = shippingCost;
		this.codAmount = codAmount;
		this.paymentMethod = paymentMethod;
		this.paymentPayer = paymentPayer;
		this.shipmentType = shipmentType;
		this.codCollectionStatus = codCollectionStatus;
		this.paymentStatus = paymentStatus;
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

	public String getCurrentHubId() {
		return currentHubId;
	}

	public void setCurrentHubId(String currentHubId) {
		this.currentHubId = currentHubId;
	}

	public AssignmentStatus getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public String getDestinationHubId() {
		return destinationHubId;
	}

	public void setDestinationHubId(String destinationHubId) {
		this.destinationHubId = destinationHubId;
	}

	public BigDecimal getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(BigDecimal shippingCost) {
		this.shippingCost = shippingCost;
	}

	public BigDecimal getCodAmount() {
		return codAmount;
	}

	public void setCodAmount(BigDecimal codAmount) {
		this.codAmount = codAmount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentPayer getPaymentPayer() {
		return paymentPayer;
	}

	public void setPaymentPayer(PaymentPayer paymentPayer) {
		this.paymentPayer = paymentPayer;
	}

	public ShipmentType getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(ShipmentType shipmentType) {
		this.shipmentType = shipmentType;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public CodCollectionStatus getCodCollectionStatus() {
		return codCollectionStatus;
	}

	public void setCodCollectionStatus(CodCollectionStatus codCollectionStatus) {
		this.codCollectionStatus = codCollectionStatus;
	}

}
