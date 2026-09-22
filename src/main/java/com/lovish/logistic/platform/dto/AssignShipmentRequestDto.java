package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.NotBlank;

public class AssignShipmentRequestDto {

	@NotBlank(message = "Delivery agent ID is required")
	private String deliveryAgentId;

	public AssignShipmentRequestDto() {
		super();
	}

	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}

	public void setDeliveryAgentId(String deliveryAgentId) {
		this.deliveryAgentId = deliveryAgentId;
	}
}