package com.lovish.logistic.platform.service;

import java.math.BigDecimal;

import com.lovish.logistic.platform.enums.Priority;

public interface PricingService {

	BigDecimal calculatePrice(Double weight, Double distanceKm, Priority priority, boolean cod);
}