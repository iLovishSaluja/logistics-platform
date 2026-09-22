package com.lovish.logistic.platform.service;

import com.lovish.logistic.platform.enums.ShipmentStatus;

public interface ShipmentStatusService {

	boolean isValidTransition(ShipmentStatus currentStatus, ShipmentStatus newStatus);
}