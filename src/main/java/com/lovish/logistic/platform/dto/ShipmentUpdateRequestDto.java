package com.lovish.logistic.platform.dto;

import com.lovish.logistic.platform.enums.Priority;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class ShipmentUpdateRequestDto {

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

	public ShipmentUpdateRequestDto() {
		super();
	}

	public ShipmentUpdateRequestDto(AddressDto senderAddress, AddressDto receiverAddress,
			PackageDetailsDto packageDetails, Priority priority) {

		super();

		this.senderAddress = senderAddress;
		this.receiverAddress = receiverAddress;
		this.packageDetails = packageDetails;
		this.priority = priority;
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
}
