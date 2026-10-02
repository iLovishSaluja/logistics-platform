package com.lovish.logistic.platform.service;

public interface HubStaffService {

	void assignHubOperator(String hubId, String userId);

	void assignDeliveryAgent(String hubId, String userId);
}