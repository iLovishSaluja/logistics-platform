package com.lovish.logistic.platform.service;

import com.lovish.logistic.platform.dto.PricingConfigRequestDto;
import com.lovish.logistic.platform.dto.PricingConfigResponseDto;

public interface PricingConfigService {

	PricingConfigResponseDto createPricingConfig(PricingConfigRequestDto request);

	PricingConfigResponseDto getActivePricingConfig();
}