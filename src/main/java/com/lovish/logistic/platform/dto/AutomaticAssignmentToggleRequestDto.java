package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.NotNull;

public class AutomaticAssignmentToggleRequestDto {

	@NotNull(message = "Automatic assignment enabled value is required")
	private Boolean enabled;

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}