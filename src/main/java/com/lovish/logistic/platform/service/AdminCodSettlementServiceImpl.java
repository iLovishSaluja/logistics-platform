package com.lovish.logistic.platform.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.AdminCodSettlementDto;
import com.lovish.logistic.platform.dto.CodSettlementRequestDto;
import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.CodSettlementStatus;
import com.lovish.logistic.platform.enums.PaymentMethod;
import com.lovish.logistic.platform.enums.Role;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.repository.ShipmentRepository;
import com.lovish.logistic.platform.repository.UserRepository;
import com.lovish.logistic.platform.service.AdminCodSettlementService;

@Service
public class AdminCodSettlementServiceImpl implements AdminCodSettlementService {

	private final ShipmentRepository shipmentRepository;
	private final UserRepository userRepository;

	public AdminCodSettlementServiceImpl(ShipmentRepository shipmentRepository, UserRepository userRepository) {
		this.shipmentRepository = shipmentRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<AdminCodSettlementDto> getPendingSettlements() {

		return shipmentRepository
				.findByPaymentMethodAndCodCollectionStatus(PaymentMethod.COD, CodCollectionStatus.COLLECTED).stream()
				.filter(shipment -> shipment.getCodSettlementStatus() == null
						|| shipment.getCodSettlementStatus() == CodSettlementStatus.PENDING)
				.map(this::toDto).toList();
	}

	@Override
	public AdminCodSettlementDto settleCod(String shipmentId, CodSettlementRequestDto request) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User admin = userRepository.findByUsername(username)
				.orElseThrow(() -> new ResourceNotFoundException("Current user not found"));

		if (admin.getRole() != Role.ADMIN) {
			throw new BadRequestException("Only administrators can settle COD");
		}

		Shipment shipment = shipmentRepository.findById(shipmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

		if (shipment.getPaymentMethod() != PaymentMethod.COD) {
			throw new BadRequestException("Settlement is allowed only for COD shipments");
		}

		if (shipment.getCodCollectionStatus() != CodCollectionStatus.COLLECTED) {
			throw new BadRequestException("COD must be collected before settlement");
		}

		if (shipment.getCodSettlementStatus() == CodSettlementStatus.SETTLED) {
			throw new BadRequestException("COD settlement has already been processed");
		}

		BigDecimal expected = shipment.getCodAmount();
		BigDecimal collected = shipment.getCodCollectedAmount();

		if (expected == null || collected == null || expected.signum() <= 0 || collected.compareTo(expected) != 0) {
			throw new BadRequestException("Expected COD amount and collected amount do not match");
		}

		shipment.setCodSettlementStatus(CodSettlementStatus.SETTLED);
		shipment.setCodSettledAt(LocalDateTime.now());
		shipment.setCodSettledByAdminId(admin.getId());
		shipment.setCodSettlementNotes(request == null ? null : request.getNotes());

		Shipment saved = shipmentRepository.save(shipment);

		return toDto(saved);
	}

	private AdminCodSettlementDto toDto(Shipment shipment) {

		AdminCodSettlementDto dto = new AdminCodSettlementDto();

		dto.setShipmentId(shipment.getId());
		dto.setTrackingNumber(shipment.getTrackingNumber());
		dto.setExpectedCodAmount(shipment.getCodAmount());
		dto.setCollectedAmount(shipment.getCodCollectedAmount());
		dto.setCodCollectionStatus(shipment.getCodCollectionStatus());
		dto.setCodSettlementStatus(shipment.getCodSettlementStatus() == null ? CodSettlementStatus.PENDING
				: shipment.getCodSettlementStatus());
		dto.setCollectedAt(shipment.getCodCollectedAt());
		dto.setSettledAt(shipment.getCodSettledAt());
		dto.setCollectedByAgentId(shipment.getCodCollectedByAgentId());
		dto.setSettledByAdminId(shipment.getCodSettledByAdminId());
		dto.setNotes(shipment.getCodSettlementNotes());

		return dto;
	}
}