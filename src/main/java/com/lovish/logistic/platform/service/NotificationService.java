package com.lovish.logistic.platform.service;

public interface NotificationService {

	void sendDeliveryOtp(String phoneNumber, String otp);
}