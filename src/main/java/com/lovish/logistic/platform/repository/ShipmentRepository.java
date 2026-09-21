package com.lovish.logistic.platform.repository;

import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.enums.ShipmentStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends MongoRepository<Shipment, String> {

	Optional<Shipment> findByTrackingNumberIgnoreCase(String trackingNumber);

	boolean existsByTrackingNumberIgnoreCase(String trackingNumber);

	List<Shipment> findByCustomerId(String customerId);

	List<Shipment> findByAssignedDeliveryAgentId(String deliveryAgentId);

	List<Shipment> findByStatus(ShipmentStatus status);
}