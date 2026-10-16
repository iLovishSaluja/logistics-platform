package com.lovish.logistic.platform.service;

import java.time.LocalDate;

import com.lovish.logistic.platform.dto.CodSettlementReportDto;

public interface CodSettlementReportService {

	CodSettlementReportDto getReport(LocalDate fromDate, LocalDate toDate, String deliveryAgentId);
}