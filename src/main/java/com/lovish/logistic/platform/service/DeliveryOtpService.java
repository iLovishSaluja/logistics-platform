package com.lovish.logistic.platform.service;

public interface DeliveryOtpService {

	String generateOtp();

	String hashOtp(String otp);

	boolean matches(String otp, String otpHash);
}