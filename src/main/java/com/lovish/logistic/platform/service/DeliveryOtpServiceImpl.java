package com.lovish.logistic.platform.service;

import java.security.SecureRandom;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DeliveryOtpServiceImpl implements DeliveryOtpService {

	private static final int OTP_MIN = 100000;
	private static final int OTP_MAX = 999999;

	private final SecureRandom secureRandom;
	private final PasswordEncoder passwordEncoder;

	public DeliveryOtpServiceImpl(PasswordEncoder passwordEncoder) {
		this.secureRandom = new SecureRandom();
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public String generateOtp() {

		int otp = secureRandom.nextInt(OTP_MAX - OTP_MIN + 1) + OTP_MIN;

		return String.valueOf(otp);
	}

	@Override
	public String hashOtp(String otp) {

		return passwordEncoder.encode(otp);
	}

	@Override
	public boolean matches(String otp, String otpHash) {

		if (otp == null || otpHash == null) {
			return false;
		}

		return passwordEncoder.matches(otp, otpHash);
	}
}