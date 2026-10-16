
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
				.orElseThrow(() -> new IllegalStateException("No active pricing config found"));

		BigDecimal cost = config.getBaseCharge();

		if (weight != null) {
			cost = cost.add(config.getPerKgRate().multiply(BigDecimal.valueOf(weight)));
		}

		if (distanceKm != null) {
			cost = cost.add(config.getPerKmRate().multiply(BigDecimal.valueOf(distanceKm)));
		}

		BigDecimal multiplier = switch (priority) {
		case STANDARD -> config.getStandardMultiplier();
		case EXPRESS -> config.getExpressMultiplier();
		case URGENT -> config.getUrgentMultiplier();
		};

		return cost.multiply(multiplier);
	}
}