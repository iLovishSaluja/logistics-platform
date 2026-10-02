package com.lovish.logistic.platform.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lovish.logistic.platform.entity.DeliveryAttempt;

@Repository
public interface DeliveryAttemptRepository extends MongoRepository<DeliveryAttempt, String> {

	List<DeliveryAttempt> findByShipmentIdOrderByAttemptNumberAsc(String shipmentId);

	long countByShipmentId(String shipmentId);
}