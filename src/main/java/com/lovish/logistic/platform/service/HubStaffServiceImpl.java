package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.entity.Hub;
import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.Role;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.repository.HubRepository;
import com.lovish.logistic.platform.repository.UserRepository;

@Service
public class HubStaffServiceImpl implements HubStaffService {

	private final HubRepository hubRepository;
	private final UserRepository userRepository;

	public HubStaffServiceImpl(HubRepository hubRepository, UserRepository userRepository) {

		this.hubRepository = hubRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void assignHubOperator(String hubId, String userId) {

		Hub hub = hubRepository.findById(hubId)
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubId));

		if (!hub.isActive()) {
			throw new BadRequestException("Cannot assign staff to an inactive hub");
		}

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

		if (user.getRole() != Role.HUB_OPERATOR) {
			throw new BadRequestException("Selected user is not a HUB_OPERATOR");
		}

		user.setHubId(hub.getId());
		user.setUpdatedAt(LocalDateTime.now());

		userRepository.save(user);
	}

	@Override
	public void assignDeliveryAgent(String hubId, String userId) {

		Hub hub = hubRepository.findById(hubId)
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubId));

		if (!hub.isActive()) {
			throw new BadRequestException("Cannot assign staff to an inactive hub");
		}

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

		if (user.getRole() != Role.DELIVERY_AGENT) {
			throw new BadRequestException("Selected user is not a DELIVERY_AGENT");
		}

		user.setHubId(hub.getId());
		user.setUpdatedAt(LocalDateTime.now());

		userRepository.save(user);
	}
}