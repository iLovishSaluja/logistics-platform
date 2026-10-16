package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class DeliveryOtpVerificationRequestDto {

	@NotBlank(message = "Delivery OTP is required")
	@Pattern(regexp = "\\d{6}", message = "Delivery OTP must be exactly 6 digits")
	private String otp;

	public DeliveryOtpVerificationRequestDto() {

	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
}