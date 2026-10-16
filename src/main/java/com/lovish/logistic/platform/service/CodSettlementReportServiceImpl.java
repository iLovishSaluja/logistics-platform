package com.lovish.logistic.platform.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.CodSettlementReportDto;
import com.lovish.logistic.platform.dto.CodSettlementReportItemDto;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.CodSettlementStatus;
import com.lovish.logistic.platform.enums.PaymentMethod;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.repository.ShipmentRepository;

@Service
public class CodSettlementReportServiceImpl implements CodSettlementReportService {

	private final ShipmentRepository shipmentRepository;

	public CodSettlementReportServiceImpl(ShipmentRepository shipmentRepository) {
		this.shipmentRepository = shipmentRepository;
	}

	@Override
	public CodSettlementReportDto getReport(LocalDate fromDate, LocalDate toDate, String deliveryAgentId) {

		if (fromDate != null && toDate != null && fromDate.isAfter(toDate)) {
			throw new BadRequestException("fromDate cannot be after toDate");
		}

		LocalDateTime start = fromDate == null ? null : fromDate.atStartOfDay();

		LocalDateTime end = toDate == null ? null : toDate.plusDays(1).atStartOfDay();

		List<Shipment> shipments = shipmentRepository.findByPaymentMethod(PaymentMethod.COD).stream()
				.filter(shipment -> {
					LocalDateTime createdAt = shipment.getCreatedAt();

					if (start != null && (createdAt == null || createdAt.isBefore(start))) {
						return false;
					}

					if (end != null && (createdAt == null || !createdAt.isBefore(end))) {
						return false;
					}

					if (deliveryAgentId != null && !deliveryAgentId.isBlank()
							&& !deliveryAgentId.equals(shipment.getAssignedDeliveryAgentId())) {
						return false;
					}

					return true;
				}).toList();

		CodSettlementReportDto report = new CodSettlementReportDto();

		long collectedCount = 0;
		long settledCount = 0;
		long pendingSettlementCount = 0;

		BigDecimal totalCollected = BigDecimal.ZERO;
		BigDecimal totalSettled = BigDecimal.ZERO;
		BigDecimal pendingAmount = BigDecimal.ZERO;

		List<CodSettlementReportItemDto> items = new java.util.ArrayList<>();

		for (Shipment shipment : shipments) {

			CodCollectionStatus collectionStatus = shipment.getCodCollectionStatus();

			CodSettlementStatus settlementStatus = shipment.getCodSettlementStatus();

			BigDecimal collectedAmount = shipment.getCodCollectedAmount();

			if (collectionStatus == CodCollectionStatus.COLLECTED) {
				collectedCount++;

				if (collectedAmount != null) {
					totalCollected = totalCollected.add(collectedAmount);
				}

				if (settlementStatus == CodSettlementStatus.SETTLED) {
					settledCount++;

					if (collectedAmount != null) {
						totalSettled = totalSettled.add(collectedAmount);
					}
				} else {
					// Collected but not settled, including legacy records
					// whose settlement status has not been initialized.
					pendingSettlementCount++;

					if (collectedAmount != null) {
						pendingAmount = pendingAmount.add(collectedAmount);
					}
				}
			}

			items.add(toItemDto(shipment));
		}

		report.setTotalCodShipments(shipments.size());
		report.setTotalCollectedShipments(collectedCount);
		report.setTotalSettledShipments(settledCount);
		report.setPendingSettlementShipments(pendingSettlementCount);

		report.setTotalCodCollected(totalCollected);
		report.setTotalCodSettled(totalSettled);
		report.setPendingSettlementAmount(pendingAmount);

		report.setShipments(items);

		return report;
	}

	private CodSettlementReportItemDto toItemDto(Shipment shipment) {

		CodSettlementReportItemDto dto = new CodSettlementReportItemDto();

		dto.setShipmentId(shipment.getId());
		dto.setTrackingNumber(shipment.getTrackingNumber());
		dto.setDeliveryAgentId(shipment.getAssignedDeliveryAgentId());
		dto.setExpectedCodAmount(shipment.getCodAmount());
		dto.setCollectedAmount(shipment.getCodCollectedAmount());
		dto.setCodCollectionStatus(shipment.getCodCollectionStatus());
		dto.setCodSettlementStatus(shipment.getCodSettlementStatus());
		dto.setCollectedAt(shipment.getCodCollectedAt());
		dto.setSettledAt(shipment.getCodSettledAt());

		return dto;
	}
}
