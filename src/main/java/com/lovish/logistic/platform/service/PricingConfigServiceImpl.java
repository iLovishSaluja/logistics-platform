package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.PricingConfigRequestDto;
import com.lovish.logistic.platform.dto.PricingConfigResponseDto;
import com.lovish.logistic.platform.entity.PricingConfig;
import com.lovish.logistic.platform.mapper.PricingConfigMapper;
import com.lovish.logistic.platform.repository.PricingConfigRepository;

@Service
public class PricingConfigServiceImpl implements PricingConfigService {

	private final PricingConfigRepository pricingConfigRepository;
	private final PricingConfigMapper pricingConfigMapper;

	public PricingConfigServiceImpl(PricingConfigRepository pricingConfigRepository,
			PricingConfigMapper pricingConfigMapper) {

		this.pricingConfigRepository = pricingConfigRepository;
		this.pricingConfigMapper = pricingConfigMapper;
	}

	@Override
	public PricingConfigResponseDto createPricingConfig(PricingConfigRequestDto request) {

		/*
		 * Only one pricing configuration should be active at a time.
		 */
		pricingConfigRepository.findByActiveTrue().ifPresent(activeConfig -> {

			activeConfig.setActive(false);
			activeConfig.setUpdatedAt(LocalDateTime.now());

			pricingConfigRepository.save(activeConfig);
		});

		PricingConfig pricingConfig = pricingConfigMapper.toEntity(request);

		pricingConfig.setActive(true);

		LocalDateTime now = LocalDateTime.now();

		pricingConfig.setCreatedAt(now);
		pricingConfig.setUpdatedAt(now);

		PricingConfig savedConfig = pricingConfigRepository.save(pricingConfig);

		return pricingConfigMapper.toResponseDto(savedConfig);
	}

	@Override
	public PricingConfigResponseDto getActivePricingConfig() {

		PricingConfig pricingConfig = pricingConfigRepository.findByActiveTrue()
				.orElseThrow(() -> new RuntimeException("No active pricing configuration found"));

		return pricingConfigMapper.toResponseDto(pricingConfig);
	}
}