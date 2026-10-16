package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;

import com.lovish.logistic.platform.enums.PaymentMethod;
import com.lovish.logistic.platform.enums.PaymentPayer;
import com.lovish.logistic.platform.enums.Priority;
import com.lovish.logistic.platform.enums.ShipmentType;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class ShipmentCreateRequestDto {

	@NotNull(message = "Sender address is required")
	@Valid
	private AddressDto senderAddress;

	@NotNull(message = "Receiver address is required")
	@Valid
	private AddressDto receiverAddress;

	@NotNull(message = "Package details are required")
	@Valid
	private PackageDetailsDto packageDetails;

	@NotNull(message = "Priority is required")
	private Priority priority;

	@NotNull(message = "Distance is required")
	@DecimalMin(value = "0.0", message = "Distance cannot be negative")
	private Double distanceKm;

	private boolean cod;

	@NotNull(message = "Payment method is required")
	private PaymentMethod paymentMethod;

	@NotNull(message = "Payment payer is required")
	private PaymentPayer paymentPayer;

	@DecimalMin(value = "0.0", message = "COD amount cannot be negative")
	private BigDecimal codAmount;
	
	@NotNull(message = "Shipment type is required")
	private ShipmentType shipmentType;

	public ShipmentCreateRequestDto() {
		super();
	}



	public ShipmentCreateRequestDto(@NotNull(message = "Sender address is required") @Valid AddressDto senderAddress,
			@NotNull(message = "Receiver address is required") @Valid AddressDto receiverAddress,
			@NotNull(message = "Package details are required") @Valid PackageDetailsDto packageDetails,
			@NotNull(message = "Priority is required") Priority priority,
			@NotNull(message = "Distance is required") @DecimalMin(value = "0.0", message = "Distance cannot be negative") Double distanceKm,
			boolean cod, @NotNull(message = "Payment method is required") PaymentMethod paymentMethod,
			@NotNull(message = "Payment payer is required") PaymentPayer paymentPayer,
			@DecimalMin(value = "0.0", message = "COD amount cannot be negative") BigDecimal codAmount,
			@NotNull(message = "Shipment type is required") ShipmentType shipmentType) {
		super();
		this.senderAddress = senderAddress;
		this.receiverAddress = receiverAddress;
		this.packageDetails = packageDetails;
		this.priority = priority;
		this.distanceKm = distanceKm;
		this.cod = cod;
		this.paymentMethod = paymentMethod;
		this.paymentPayer = paymentPayer;
		this.codAmount = codAmount;
		this.shipmentType = shipmentType;
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

	public Double getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(Double distanceKm) {
		this.distanceKm = distanceKm;
	}

	public boolean isCod() {
		return cod;
	}

	public void setCod(boolean cod) {
		this.cod = cod;
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

	public BigDecimal getCodAmount() {
		return codAmount;
	}

	public void setCodAmount(BigDecimal codAmount) {
		this.codAmount = codAmount;
	}



	public ShipmentType getShipmentType() {
		return shipmentType;
	}



	public void setShipmentType(ShipmentType shipmentType) {
		this.shipmentType = shipmentType;
	}

}
