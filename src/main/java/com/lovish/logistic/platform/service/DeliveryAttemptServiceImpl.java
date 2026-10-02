package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.entity.DeliveryAttempt;
import com.lovish.logistic.platform.enums.FailedDeliveryReason;
import com.lovish.logistic.platform.repository.DeliveryAttemptRepository;

@Service
public class DeliveryAttemptServiceImpl implements DeliveryAttemptService {

	private final DeliveryAttemptRepository deliveryAttemptRepository;

	public DeliveryAttemptServiceImpl(DeliveryAttemptRepository deliveryAttemptRepository) {
		super();
		this.deliveryAttemptRepository = deliveryAttemptRepository;
	}

	@Override
	public void recordFailedAttempt(String shipmentId, String deliveryAgentId, FailedDeliveryReason failureReason,
			String notes) {

		long existingAttempts = deliveryAttemptRepository.countByShipmentId(shipmentId);

		int attemptNumber = (int) existingAttempts + 1;

		DeliveryAttempt attempt = new DeliveryAttempt();

		attempt.setShipmentId(shipmentId);
		attempt.setAttemptNumber(attemptNumber);
		attempt.setDeliveryAgentId(deliveryAgentId);
		attempt.setAttemptedAt(LocalDateTime.now());
		attempt.setFailureReason(failureReason);
		attempt.setNotes(notes);

		deliveryAttemptRepository.save(attempt);
	}

	@Override
	public long getAttemptCount(String shipmentId) {
		return deliveryAttemptRepository.countByShipmentId(shipmentId);
	}
}