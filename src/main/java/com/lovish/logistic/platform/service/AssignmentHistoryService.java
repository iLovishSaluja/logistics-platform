package com.lovish.logistic.platform.service;

import com.lovish.logistic.platform.enums.AssignmentAction;

public interface AssignmentHistoryService {

	void recordAssignment(String shipmentId, String deliveryAgentId, String previousDeliveryAgentId, String performedBy,
			AssignmentAction action, String hubId, String reason, String notes);
}