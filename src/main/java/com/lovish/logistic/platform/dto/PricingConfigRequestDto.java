package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class PricingConfigRequestDto {

	@NotNull(message = "Base charge is required")
	@DecimalMin(value = "0.0", inclusive = true, message = "Base charge cannot be negative")
	private BigDecimal baseCharge;

	@NotNull(message = "Per kg rate is required")
	@DecimalMin(value = "0.0", inclusive = true, message = "Per kg rate cannot be negative")
	private BigDecimal perKgRate;

	@NotNull(message = "Per km rate is required")
	@DecimalMin(value = "0.0", inclusive = true, message = "Per km rate cannot be negative")
	private BigDecimal perKmRate;

	@NotNull(message = "Standard multiplier is required")
	@DecimalMin(value = "0.0", inclusive = false, message = "Standard multiplier must be greater than 0")
	private BigDecimal standardMultiplier;

	@NotNull(message = "Express multiplier is required")
	@DecimalMin(value = "0.0", inclusive = false, message = "Express multiplier must be greater than 0")
	private BigDecimal expressMultiplier;

	@NotNull(message = "Urgent multiplier is required")
	@DecimalMin(value = "0.0", inclusive = false, message = "Urgent multiplier must be greater than 0")
	private BigDecimal urgentMultiplier;

	@NotNull(message = "COD handling fee is required")
	@DecimalMin(value = "0.0", inclusive = true, message = "COD handling fee cannot be negative")
	private BigDecimal codHandlingFee;

	// Getters and setters

	public BigDecimal getBaseCharge() {
		return baseCharge;
	}

	public void setBaseCharge(BigDecimal baseCharge) {
		this.baseCharge = baseCharge;
	}

	public BigDecimal getPerKgRate() {
		return perKgRate;
	}

	public void setPerKgRate(BigDecimal perKgRate) {
		this.perKgRate = perKgRate;
	}

	public BigDecimal getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(BigDecimal perKmRate) {
		this.perKmRate = perKmRate;
	}

	public BigDecimal getStandardMultiplier() {
		return standardMultiplier;
	}

	public void setStandardMultiplier(BigDecimal standardMultiplier) {
		this.standardMultiplier = standardMultiplier;
	}

	public BigDecimal getExpressMultiplier() {
		return expressMultiplier;
	}

	public void setExpressMultiplier(BigDecimal expressMultiplier) {
		this.expressMultiplier = expressMultiplier;
	}

	public BigDecimal getUrgentMultiplier() {
		return urgentMultiplier;
	}

	public void setUrgentMultiplier(BigDecimal urgentMultiplier) {
		this.urgentMultiplier = urgentMultiplier;
	}

	public BigDecimal getCodHandlingFee() {
		return codHandlingFee;
	}

	public void setCodHandlingFee(BigDecimal codHandlingFee) {
		this.codHandlingFee = codHandlingFee;
	}
}