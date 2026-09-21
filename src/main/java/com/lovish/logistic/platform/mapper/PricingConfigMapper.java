package com.lovish.logistic.platform.mapper;

import org.springframework.stereotype.Component;

import com.lovish.logistic.platform.dto.PricingConfigRequestDto;
import com.lovish.logistic.platform.dto.PricingConfigResponseDto;
import com.lovish.logistic.platform.entity.PricingConfig;

@Component
public class PricingConfigMapper {

	public PricingConfig toEntity(PricingConfigRequestDto dto) {

		PricingConfig pricingConfig = new PricingConfig();

		pricingConfig.setBaseCharge(dto.getBaseCharge());
		pricingConfig.setPerKgRate(dto.getPerKgRate());
		pricingConfig.setPerKmRate(dto.getPerKmRate());

		pricingConfig.setStandardMultiplier(dto.getStandardMultiplier());

		pricingConfig.setExpressMultiplier(dto.getExpressMultiplier());

		pricingConfig.setUrgentMultiplier(dto.getUrgentMultiplier());

		pricingConfig.setCodHandlingFee(dto.getCodHandlingFee());

		return pricingConfig;
	}

	public PricingConfigResponseDto toResponseDto(PricingConfig pricingConfig) {

		return new PricingConfigResponseDto(pricingConfig.getId(), pricingConfig.getBaseCharge(),
				pricingConfig.getPerKgRate(), pricingConfig.getPerKmRate(), pricingConfig.getStandardMultiplier(),
				pricingConfig.getExpressMultiplier(), pricingConfig.getUrgentMultiplier(),
				pricingConfig.getCodHandlingFee(), pricingConfig.isActive(), pricingConfig.getCreatedAt(),
				pricingConfig.getUpdatedAt());
	}
}