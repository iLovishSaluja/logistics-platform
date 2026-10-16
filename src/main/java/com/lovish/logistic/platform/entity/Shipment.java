package com.lovish.logistic.platform.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.lovish.logistic.platform.enums.AssignmentStatus;
import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.CodSettlementStatus;
import com.lovish.logistic.platform.enums.PaymentMethod;
import com.lovish.logistic.platform.enums.PaymentPayer;
import com.lovish.logistic.platform.enums.PaymentStatus;
import com.lovish.logistic.platform.enums.Priority;
import com.lovish.logistic.platform.enums.ShipmentStatus;
import com.lovish.logistic.platform.enums.ShipmentType;

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

	@Field(write = Field.Write.ALWAYS)
	private String assignedDeliveryAgentId;

	@Field(write = Field.Write.ALWAYS)
	private AssignmentStatus assignmentStatus;

	private String deliveryOtpHash;

	private LocalDateTime deliveryOtpExpiresAt;

	private boolean deliveryOtpVerified;

	private BigDecimal shippingCost;

	private BigDecimal codAmount;

	private PaymentMethod paymentMethod;

	private PaymentStatus paymentStatus = PaymentStatus.PENDING;

	private PaymentPayer paymentPayer;

	private ShipmentType shipmentType;

	private BigDecimal codCollectedAmount;
	private LocalDateTime codCollectedAt;
	private String codCollectedByAgentId;
	private String codCollectionNotes;

	private CodSettlementStatus codSettlementStatus = CodSettlementStatus.NOT_APPLICABLE;

	private LocalDateTime codSettledAt;
	private String codSettledByAdminId;
	private String codSettlementNotes;

	private CodCollectionStatus codCollectionStatus = CodCollectionStatus.NOT_APPLICABLE;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private List<TrackingHistory> trackingHistory;

	public Shipment() {
		super();
	}

	public Shipment(String id, String trackingNumber, String customerId, Address senderAddress, Address receiverAddress,
			PackageDetails packageDetails, Priority priority, BigDecimal cost, ShipmentStatus status,
			String currentHubId, String destinationHubId, String assignedDeliveryAgentId,
			AssignmentStatus assignmentStatus, String deliveryOtpHash, LocalDateTime deliveryOtpExpiresAt,
			boolean deliveryOtpVerified, BigDecimal shippingCost, BigDecimal codAmount, PaymentMethod paymentMethod,
			PaymentStatus paymentStatus, PaymentPayer paymentPayer, ShipmentType shipmentType,
			BigDecimal codCollectedAmount, LocalDateTime codCollectedAt, String codCollectedByAgentId,
			String codCollectionNotes, CodSettlementStatus codSettlementStatus, LocalDateTime codSettledAt,
			String codSettledByAdminId, String codSettlementNotes, CodCollectionStatus codCollectionStatus,
			LocalDateTime createdAt, LocalDateTime updatedAt, List<TrackingHistory> trackingHistory) {
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
		this.deliveryOtpHash = deliveryOtpHash;
		this.deliveryOtpExpiresAt = deliveryOtpExpiresAt;
		this.deliveryOtpVerified = deliveryOtpVerified;
		this.shippingCost = shippingCost;
		this.codAmount = codAmount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.paymentPayer = paymentPayer;
		this.shipmentType = shipmentType;
		this.codCollectedAmount = codCollectedAmount;
		this.codCollectedAt = codCollectedAt;
		this.codCollectedByAgentId = codCollectedByAgentId;
		this.codCollectionNotes = codCollectionNotes;
		this.codSettlementStatus = codSettlementStatus;
		this.codSettledAt = codSettledAt;
		this.codSettledByAdminId = codSettledByAdminId;
		this.codSettlementNotes = codSettlementNotes;
		this.codCollectionStatus = codCollectionStatus;
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

	public String getDeliveryOtpHash() {
		return deliveryOtpHash;
	}

	public void setDeliveryOtpHash(String deliveryOtpHash) {
		this.deliveryOtpHash = deliveryOtpHash;
	}

	public LocalDateTime getDeliveryOtpExpiresAt() {
		return deliveryOtpExpiresAt;
	}

	public void setDeliveryOtpExpiresAt(LocalDateTime deliveryOtpExpiresAt) {
		this.deliveryOtpExpiresAt = deliveryOtpExpiresAt;
	}

	public boolean isDeliveryOtpVerified() {
		return deliveryOtpVerified;
	}

	public void setDeliveryOtpVerified(boolean deliveryOtpVerified) {
		this.deliveryOtpVerified = deliveryOtpVerified;
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

	public BigDecimal getCodCollectedAmount() {
		return codCollectedAmount;
	}

	public void setCodCollectedAmount(BigDecimal codCollectedAmount) {
		this.codCollectedAmount = codCollectedAmount;
	}

	public LocalDateTime getCodCollectedAt() {
		return codCollectedAt;
	}

	public void setCodCollectedAt(LocalDateTime codCollectedAt) {
		this.codCollectedAt = codCollectedAt;
	}

	public String getCodCollectedByAgentId() {
		return codCollectedByAgentId;
	}

	public void setCodCollectedByAgentId(String codCollectedByAgentId) {
		this.codCollectedByAgentId = codCollectedByAgentId;
	}

	public String getCodCollectionNotes() {
		return codCollectionNotes;
	}

	public void setCodCollectionNotes(String codCollectionNotes) {
		this.codCollectionNotes = codCollectionNotes;
	}

	public CodSettlementStatus getCodSettlementStatus() {
		return codSettlementStatus;
	}

	public void setCodSettlementStatus(CodSettlementStatus codSettlementStatus) {
		this.codSettlementStatus = codSettlementStatus;
	}

	public LocalDateTime getCodSettledAt() {
		return codSettledAt;
	}

	public void setCodSettledAt(LocalDateTime codSettledAt) {
		this.codSettledAt = codSettledAt;
	}

	public String getCodSettledByAdminId() {
		return codSettledByAdminId;
	}

	public void setCodSettledByAdminId(String codSettledByAdminId) {
		this.codSettledByAdminId = codSettledByAdminId;
	}

	public String getCodSettlementNotes() {
		return codSettlementNotes;
	}

	public void setCodSettlementNotes(String codSettlementNotes) {
		this.codSettlementNotes = codSettlementNotes;
	}
}
