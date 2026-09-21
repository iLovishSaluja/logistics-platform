package com.lovish.logistic.platform.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pricing_config")
public class PricingConfig {

	@Id
	private String id;

	private BigDecimal baseCharge;

	private BigDecimal perKgRate;

	private BigDecimal perKmRate;

	private BigDecimal standardMultiplier;

	private BigDecimal expressMultiplier;

	private BigDecimal urgentMultiplier;

	private BigDecimal codHandlingFee;

	private boolean active;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public PricingConfig() {
		super();
	}

	public PricingConfig(String id, BigDecimal baseCharge, BigDecimal perKgRate, BigDecimal perKmRate,
			BigDecimal standardMultiplier, BigDecimal expressMultiplier, BigDecimal urgentMultiplier,
			BigDecimal codHandlingFee, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {

		super();

		this.id = id;
		this.baseCharge = baseCharge;
		this.perKgRate = perKgRate;
		this.perKmRate = perKmRate;
		this.standardMultiplier = standardMultiplier;
		this.expressMultiplier = expressMultiplier;
		this.urgentMultiplier = urgentMultiplier;
		this.codHandlingFee = codHandlingFee;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}