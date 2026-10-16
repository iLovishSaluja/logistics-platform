package com.lovish.logistic.platform.service;

public interface HubOperatorService {

	void assignShipment(String shipmentId, String deliveryAgentId);

	void reassignShipment(String shipmentId, String deliveryAgentId);

	void retryShipment(String shipmentId, String deliveryAgentId);

	void markPickupFromHub(String shipmentId);

	void toggleAutomaticAssignment(boolean enabled);

	void receiveShipment(String shipmentId);
	
	 void dispatchShipment(String shipmentId);

}