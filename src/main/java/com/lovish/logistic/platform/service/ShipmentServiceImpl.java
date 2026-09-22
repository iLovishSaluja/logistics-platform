package com.lovish.logistic.platform.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.PriceEstimateRequestDto;
import com.lovish.logistic.platform.dto.PriceEstimateResponseDto;
import com.lovish.logistic.platform.dto.ShipmentCreateRequestDto;
import com.lovish.logistic.platform.dto.ShipmentResponseDto;
import com.lovish.logistic.platform.dto.ShipmentSummaryDto;
import com.lovish.logistic.platform.dto.ShipmentTrackingResponseDto;
import com.lovish.logistic.platform.dto.ShipmentUpdateRequestDto;
import com.lovish.logistic.platform.dto.TrackingHistoryDto;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.TrackingHistory;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.ShipmentStatus;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.exception.UnauthorizedException;
import com.lovish.logistic.platform.mapper.ShipmentMapper;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class ShipmentServiceImpl implements ShipmentService {

	private final ShipmentRepository shipmentRepository;
	private final ShipmentMapper shipmentMapper;
	private final UserRepository userRepository;
	private final PricingService pricingService;
	private final ShipmentStatusService shipmentStatusService;

	public ShipmentServiceImpl(ShipmentRepository shipmentRepository, ShipmentMapper shipmentMapper,
			UserRepository userRepository, PricingService pricingService, ShipmentStatusService shipmentStatusService) {
		super();
		this.shipmentRepository = shipmentRepository;
		this.shipmentMapper = shipmentMapper;
		this.userRepository = userRepository;
		this.pricingService = pricingService;
		this.shipmentStatusService = shipmentStatusService;
	}

	@Override
	public ShipmentResponseDto createShipment(ShipmentCreateRequestDto request) {

		Shipment shipment = shipmentMapper.toEntity(request);
		String customerId = getCurrentUserId();

		shipment.setTrackingNumber(generateTrackingNumber());
		shipment.setCustomerId(customerId);
		shipment.setStatus(ShipmentStatus.CREATED);
		addTrackingEvent(shipment, ShipmentStatus.CREATED, shipment.getSenderAddress().getCity(), "Shipment created",
				customerId, null);

		BigDecimal cost = pricingService.calculatePrice(request.getPackageDetails().getWeight(),
				request.getDistanceKm(), request.getPriority(), request.isCod());

		shipment.setCost(cost);

		LocalDateTime now = LocalDateTime.now();

		shipment.setCreatedAt(now);
		shipment.setUpdatedAt(now);

		Shipment savedShipment = shipmentRepository.save(shipment);

		return shipmentMapper.toResponseDto(savedShipment);
	}

	@Override
	public ShipmentResponseDto getShipmentById(String id) {

		Shipment shipment = shipmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));

		return shipmentMapper.toResponseDto(shipment);
	}

	@Override
	public ShipmentResponseDto getShipmentByTrackingNumber(String trackingNumber) {

		Shipment shipment = shipmentRepository.findByTrackingNumberIgnoreCase(trackingNumber).orElseThrow(
				() -> new ResourceNotFoundException("Shipment not found with tracking number: " + trackingNumber));

		return shipmentMapper.toResponseDto(shipment);
	}

	@Override
	public List<ShipmentSummaryDto> getMyShipments() {

		String customerId = getCurrentUserId();

		List<Shipment> shipments = shipmentRepository.findByCustomerId(customerId);

		return shipments.stream().map(shipmentMapper::toSummaryDto).toList();
	}

	@Override
	public ShipmentResponseDto updateShipment(String id, ShipmentUpdateRequestDto request) {

		Shipment shipment = shipmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));

		String currentUserId = getCurrentUserId();

		if (!shipment.getCustomerId().equals(currentUserId)) {

			throw new UnauthorizedException("You are not authorized to update this shipment");
		}

		if (shipment.getStatus() != ShipmentStatus.CREATED && shipment.getStatus() != ShipmentStatus.CONFIRMED) {

			throw new BadRequestException("Shipment cannot be updated after pickup");
		}

		shipmentMapper.updateEntity(shipment, request);

		shipment.setUpdatedAt(LocalDateTime.now());

		Shipment updatedShipment = shipmentRepository.save(shipment);

		return shipmentMapper.toResponseDto(updatedShipment);
	}

	@Override
	public ShipmentResponseDto cancelShipment(String id) {

		Shipment shipment = shipmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + id));

		String currentUserId = getCurrentUserId();

		if (!shipment.getCustomerId().equals(currentUserId)) {
			throw new UnauthorizedException("You are not authorized to cancel this shipment");
		}

		if (shipment.getStatus() != ShipmentStatus.CREATED && shipment.getStatus() != ShipmentStatus.CONFIRMED) {

			throw new BadRequestException("Shipment cannot be cancelled after pickup");
		}

		shipment.setStatus(ShipmentStatus.CANCELLED);

		addTrackingEvent(shipment, ShipmentStatus.CANCELLED, shipment.getSenderAddress().getCity(),
				"Shipment cancelled", currentUserId, null);

		shipment.setUpdatedAt(LocalDateTime.now());

		Shipment cancelledShipment = shipmentRepository.save(shipment);

		return shipmentMapper.toResponseDto(cancelledShipment);
	}

	private void addTrackingEvent(Shipment shipment, ShipmentStatus status, String location, String description,
			String performedBy, String notes) {

		TrackingHistory trackingHistory = new TrackingHistory();

		trackingHistory.setStatus(status);
		trackingHistory.setTimestamp(LocalDateTime.now());
		trackingHistory.setLocation(location);
		trackingHistory.setDescription(description);
		trackingHistory.setPerformedBy(performedBy);
		trackingHistory.setNotes(notes);

		if (shipment.getTrackingHistory() == null) {
			shipment.setTrackingHistory(new java.util.ArrayList<>());
		}

		shipment.getTrackingHistory().add(trackingHistory);
	}

	private String generateTrackingNumber() {

		return "TRK-" + UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
	}

	private String getCurrentUserId() {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Authenticated user not found"));

		return user.getId();
	}

	@Override
	public PriceEstimateResponseDto estimatePrice(PriceEstimateRequestDto request) {

		BigDecimal estimatedPrice = pricingService.calculatePrice(request.getWeight(), request.getDistanceKm(),
				request.getPriority(), request.isCod());

		return new PriceEstimateResponseDto(estimatedPrice);
	}

	@Override
	public ShipmentTrackingResponseDto getTrackingHistory(String trackingNumber) {

		Shipment shipment = shipmentRepository.findByTrackingNumberIgnoreCase(trackingNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

		List<TrackingHistoryDto> trackingHistory = shipmentMapper
				.toTrackingHistoryDtoList(shipment.getTrackingHistory());

		return new ShipmentTrackingResponseDto(shipment.getTrackingNumber(), shipment.getStatus(), trackingHistory);
	}

	@Override
	public ShipmentResponseDto updateShipmentStatus(String shipmentId, ShipmentStatus newStatus) {

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id: " + shipmentId));

		ShipmentStatus currentStatus = shipment.getStatus();

		boolean validTransition = shipmentStatusService.isValidTransition(currentStatus, newStatus);

		if (!validTransition) {
			throw new BadRequestException(
					"Invalid shipment status transition from " + currentStatus + " to " + newStatus);
		}

		shipment.setStatus(newStatus);

		String currentUserId = getCurrentUserId();

		addTrackingEvent(shipment, newStatus, shipment.getSenderAddress().getCity(),
				"Shipment status changed from " + currentStatus + " to " + newStatus, currentUserId, null);

		shipment.setUpdatedAt(LocalDateTime.now());

		Shipment updatedShipment = shipmentRepository.save(shipment);

		return shipmentMapper.toResponseDto(updatedShipment);
	}
}