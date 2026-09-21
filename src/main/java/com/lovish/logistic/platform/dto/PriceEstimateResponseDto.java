package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;

public class PriceEstimateResponseDto {

	private BigDecimal estimatedPrice;

	public PriceEstimateResponseDto() {
		super();
	}

	public PriceEstimateResponseDto(BigDecimal estimatedPrice) {
		super();
		this.estimatedPrice = estimatedPrice;
	}

	public BigDecimal getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(BigDecimal estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}
}