package com.lovish.logistic.platform.service;

import com.lovish.logistic.platform.enums.FailedDeliveryReason;

public interface DeliveryAttemptService {

	void recordFailedAttempt(String shipmentId, String deliveryAgentId, FailedDeliveryReason failureReason,
			String notes);

	long getAttemptCount(String shipmentId);
}