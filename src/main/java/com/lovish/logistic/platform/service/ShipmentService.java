package com.lovish.logistic.platform.service;

import java.util.List;

import com.lovish.logistic.platform.dto.PriceEstimateRequestDto;
import com.lovish.logistic.platform.dto.PriceEstimateResponseDto;
import com.lovish.logistic.platform.dto.ShipmentCreateRequestDto;
import com.lovish.logistic.platform.dto.ShipmentResponseDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.dto.ShipmentTrackingResponseDto;
import com.lovish.logistic.platform.dto.ShipmentUpdateRequestDto;

public interface ShipmentService {

	ShipmentResponseDto createShipment(ShipmentCreateRequestDto request);

	ShipmentResponseDto getShipmentById(String id);

	ShipmentResponseDto getShipmentByTrackingNumber(String trackingNumber);

	List<ShipmentSummaryDto> getMyShipments();

	ShipmentResponseDto updateShipment(String id, ShipmentUpdateRequestDto request);

	ShipmentResponseDto cancelShipment(String id);

	PriceEstimateResponseDto estimatePrice(PriceEstimateRequestDto request);
	
	ShipmentTrackingResponseDto getTrackingHistory(String trackingNumber);
}
