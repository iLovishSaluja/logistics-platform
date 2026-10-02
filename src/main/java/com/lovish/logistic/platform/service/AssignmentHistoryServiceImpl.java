package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.entity.AssignmentHistory;
import com.lovish.logistic.platform.enums.AssignmentAction;
import com.lovish.logistic.platform.repository.AssignmentHistoryRepository;
import com.lovish.logistic.platform.service.AssignmentHistoryService;

@Service
public class AssignmentHistoryServiceImpl implements AssignmentHistoryService {

	private final AssignmentHistoryRepository assignmentHistoryRepository;

	public AssignmentHistoryServiceImpl(AssignmentHistoryRepository assignmentHistoryRepository) {
		super();
		this.assignmentHistoryRepository = assignmentHistoryRepository;
	}

	@Override
	public void recordAssignment(String shipmentId, String deliveryAgentId, String previousDeliveryAgentId,
			String performedBy, AssignmentAction action, String hubId, String reason, String notes) {

		AssignmentHistory history = new AssignmentHistory();

		history.setShipmentId(shipmentId);
		history.setDeliveryAgentId(deliveryAgentId);
		history.setPreviousDeliveryAgentId(previousDeliveryAgentId);
		history.setPerformedBy(performedBy);
		history.setAction(action);
		history.setHubId(hubId);
		history.setTimestamp(LocalDateTime.now());
		history.setReason(reason);
		history.setNotes(notes);

		assignmentHistoryRepository.save(history);
	}
}