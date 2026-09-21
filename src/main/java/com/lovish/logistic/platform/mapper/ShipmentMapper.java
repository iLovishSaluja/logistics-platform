package com.lovish.logistic.platform.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lovish.logistic.platform.dto.AddressDto;
import com.lovish.logistic.platform.dto.PackageDetailsDto;
import com.lovish.logistic.platform.dto.ShipmentCreateRequestDto;
import com.lovish.logistic.platform.dto.ShipmentResponseDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.dto.ShipmentUpdateRequestDto;
import com.lovish.logistic.platform.dto.TrackingHistoryDto;
import com.lovish.logistic.platform.entity.Address;
import com.lovish.logistic.platform.entity.PackageDetails;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.TrackingHistory;

@Component
public class ShipmentMapper {

	public Shipment toEntity(ShipmentCreateRequestDto dto) {

		Shipment shipment = new Shipment();

		shipment.setSenderAddress(toAddress(dto.getSenderAddress()));
		shipment.setReceiverAddress(toAddress(dto.getReceiverAddress()));
		shipment.setPackageDetails(toPackageDetails(dto.getPackageDetails()));
		shipment.setPriority(dto.getPriority());

		return shipment;
	}

	public void updateEntity(Shipment shipment, ShipmentUpdateRequestDto dto) {

		shipment.setSenderAddress(toAddress(dto.getSenderAddress()));
		shipment.setReceiverAddress(toAddress(dto.getReceiverAddress()));
		shipment.setPackageDetails(toPackageDetails(dto.getPackageDetails()));
		shipment.setPriority(dto.getPriority());
	}

	public ShipmentResponseDto toResponseDto(Shipment shipment) {

		ShipmentResponseDto dto = new ShipmentResponseDto();

		dto.setId(shipment.getId());
		dto.setTrackingNumber(shipment.getTrackingNumber());
		dto.setCustomerId(shipment.getCustomerId());

		dto.setSenderAddress(toAddressDto(shipment.getSenderAddress()));

		dto.setReceiverAddress(toAddressDto(shipment.getReceiverAddress()));

		dto.setPackageDetails(toPackageDetailsDto(shipment.getPackageDetails()));

		dto.setPriority(shipment.getPriority());
		dto.setCost(shipment.getCost());
		dto.setStatus(shipment.getStatus());
		dto.setAssignedDeliveryAgentId(shipment.getAssignedDeliveryAgentId());

		dto.setCreatedAt(shipment.getCreatedAt());
		dto.setUpdatedAt(shipment.getUpdatedAt());

		return dto;
	}

	public ShipmentSummaryDto toSummaryDto(Shipment shipment) {

		ShipmentSummaryDto dto = new ShipmentSummaryDto();

		dto.setId(shipment.getId());
		dto.setTrackingNumber(shipment.getTrackingNumber());
		dto.setStatus(shipment.getStatus());
		dto.setPriority(shipment.getPriority());
		dto.setCost(shipment.getCost());
		dto.setCreatedAt(shipment.getCreatedAt());

		return dto;
	}

	public Address toAddress(AddressDto dto) {

		if (dto == null) {
			return null;
		}

		Address address = new Address();

		address.setFullName(dto.getFullName());
		address.setPhoneNumber(dto.getPhoneNumber());
		address.setAddressLine(dto.getAddressLine());
		address.setCity(dto.getCity());
		address.setState(dto.getState());
		address.setPostalCode(dto.getPostalCode());
		address.setCountry(dto.getCountry());

		return address;
	}

	public AddressDto toAddressDto(Address address) {

		if (address == null) {
			return null;
		}

		AddressDto dto = new AddressDto();

		dto.setFullName(address.getFullName());
		dto.setPhoneNumber(address.getPhoneNumber());
		dto.setAddressLine(address.getAddressLine());
		dto.setCity(address.getCity());
		dto.setState(address.getState());
		dto.setPostalCode(address.getPostalCode());
		dto.setCountry(address.getCountry());

		return dto;
	}

	public PackageDetails toPackageDetails(PackageDetailsDto dto) {

		if (dto == null) {
			return null;
		}

		PackageDetails packageDetails = new PackageDetails();

		packageDetails.setWeight(dto.getWeight());
		packageDetails.setLength(dto.getLength());
		packageDetails.setWidth(dto.getWidth());
		packageDetails.setHeight(dto.getHeight());
		packageDetails.setDescription(dto.getDescription());

		return packageDetails;
	}

	public PackageDetailsDto toPackageDetailsDto(PackageDetails packageDetails) {

		if (packageDetails == null) {
			return null;
		}

		PackageDetailsDto dto = new PackageDetailsDto();

		dto.setWeight(packageDetails.getWeight());
		dto.setLength(packageDetails.getLength());
		dto.setWidth(packageDetails.getWidth());
		dto.setHeight(packageDetails.getHeight());
		dto.setDescription(packageDetails.getDescription());

		return dto;
	}

	public TrackingHistoryDto toTrackingHistoryDto(TrackingHistory trackingHistory) {

		TrackingHistoryDto dto = new TrackingHistoryDto();

		dto.setStatus(trackingHistory.getStatus());
		dto.setTimestamp(trackingHistory.getTimestamp());
		dto.setLocation(trackingHistory.getLocation());
		dto.setDescription(trackingHistory.getDescription());
		dto.setPerformedBy(trackingHistory.getPerformedBy());

		return dto;
	}

	public List<TrackingHistoryDto> toTrackingHistoryDtoList(List<TrackingHistory> trackingHistoryList) {

		if (trackingHistoryList == null) {
			return List.of();
		}

		return trackingHistoryList.stream().map(this::toTrackingHistoryDto).toList();
	}

}
