package com.lovish.logistic.platform.dto;

import com.lovish.logistic.platform.enums.Priority;

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

	public ShipmentCreateRequestDto() {
		super();
	}

	public ShipmentCreateRequestDto(@NotNull(message = "Sender address is required") @Valid AddressDto senderAddress,
			@NotNull(message = "Receiver address is required") @Valid AddressDto receiverAddress,
			@NotNull(message = "Package details are required") @Valid PackageDetailsDto packageDetails,
			@NotNull(message = "Priority is required") Priority priority,
			@NotNull(message = "Distance is required") @DecimalMin(value = "0.0", message = "Distance cannot be negative") Double distanceKm,
			boolean cod) {
		super();
		this.senderAddress = senderAddress;
		this.receiverAddress = receiverAddress;
		this.packageDetails = packageDetails;
		this.priority = priority;
		this.distanceKm = distanceKm;
		this.cod = cod;
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

}
