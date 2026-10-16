package com.lovish.logistic.platform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.service.NotificationService;

@Service
public class MockNotificationService implements NotificationService {

	private static final Logger log = LoggerFactory.getLogger(MockNotificationService.class);

	@Override
	public void sendDeliveryOtp(String phoneNumber, String otp) {

		log.info("MOCK SMS | Delivery OTP sent to {} | OTP: {}", phoneNumber, otp);
	}
}