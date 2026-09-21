package com.lovish.logistic.platform.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.entity.PricingConfig;
import com.lovish.logistic.platform.enums.Priority;
import com.lovish.logistic.platform.repository.PricingConfigRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultPricingService implements PricingService {

	private final PricingConfigRepository pricingConfigRepository;

	public DefaultPricingService(PricingConfigRepository pricingConfigRepository) {
		super();
		this.pricingConfigRepository = pricingConfigRepository;
	}

	@Override
	public BigDecimal calculatePrice(Double weight, Double distanceKm, Priority priority, boolean cod) {

		PricingConfig config = pricingConfigRepository.findByActiveTrue()
				.orElseThrow(() -> new RuntimeException("No active pricing config found"));

		// base cost
		BigDecimal cost = config.getBaseCharge();

		// weight cost
		if (weight != null) {
			cost = cost.add(config.getPerKgRate().multiply(BigDecimal.valueOf(weight)));
		}

		// distance cost
		if (distanceKm != null) {
			cost = cost.add(config.getPerKmRate().multiply(BigDecimal.valueOf(distanceKm)));
		}

		// priority multiplier
		BigDecimal multiplier = switch (priority) {
		case STANDARD -> config.getStandardMultiplier();
		case EXPRESS -> config.getExpressMultiplier();
		case URGENT -> config.getUrgentMultiplier();
		};

		cost = cost.multiply(multiplier);

		// COD fee
		if (cod) {
			cost = cost.add(config.getCodHandlingFee());
		}

		return cost;
	}
}
