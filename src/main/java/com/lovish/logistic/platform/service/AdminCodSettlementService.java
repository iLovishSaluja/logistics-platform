package com.lovish.logistic.platform.service;

import java.util.List;

import com.lovish.logistic.platform.dto.AdminCodSettlementDto;
import com.lovish.logistic.platform.dto.CodSettlementRequestDto;

public interface AdminCodSettlementService {

	List<AdminCodSettlementDto> getPendingSettlements();

	AdminCodSettlementDto settleCod(String shipmentId, CodSettlementRequestDto request);
}