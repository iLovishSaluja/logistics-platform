package com.lovish.logistic.platform.service;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.enums.ShipmentStatus;

@Service
public class ShipmentStatusServiceImpl implements ShipmentStatusService {

	private final Map<ShipmentStatus, Set<ShipmentStatus>> allowedTransitions = new EnumMap<>(ShipmentStatus.class);

	public ShipmentStatusServiceImpl() {

		allowedTransitions.put(ShipmentStatus.CREATED, EnumSet.of(ShipmentStatus.CONFIRMED, ShipmentStatus.CANCELLED));

		allowedTransitions.put(ShipmentStatus.CONFIRMED, EnumSet.of(ShipmentStatus.PICKED_UP));

		allowedTransitions.put(ShipmentStatus.PICKED_UP, EnumSet.of(ShipmentStatus.IN_TRANSIT));

		allowedTransitions.put(ShipmentStatus.IN_TRANSIT, EnumSet.of(ShipmentStatus.OUT_FOR_DELIVERY));

		allowedTransitions.put(ShipmentStatus.OUT_FOR_DELIVERY,
				EnumSet.of(ShipmentStatus.DELIVERED, ShipmentStatus.FAILED_DELIVERY));

		allowedTransitions.put(ShipmentStatus.FAILED_DELIVERY,
				EnumSet.of(ShipmentStatus.OUT_FOR_DELIVERY, ShipmentStatus.RETURNED));

		allowedTransitions.put(ShipmentStatus.DELIVERED, EnumSet.noneOf(ShipmentStatus.class));

		allowedTransitions.put(ShipmentStatus.CANCELLED, EnumSet.noneOf(ShipmentStatus.class));

		allowedTransitions.put(ShipmentStatus.RETURNED, EnumSet.noneOf(ShipmentStatus.class));
	}

	@Override
	public boolean isValidTransition(ShipmentStatus currentStatus, ShipmentStatus newStatus) {

		if (currentStatus == null || newStatus == null) {
			return false;
		}

		Set<ShipmentStatus> allowedStatuses = allowedTransitions.get(currentStatus);

		if (allowedStatuses == null) {
			return false;
		}

		return allowedStatuses.contains(newStatus);
	}
}