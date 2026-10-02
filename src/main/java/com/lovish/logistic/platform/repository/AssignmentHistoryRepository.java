package com.lovish.logistic.platform.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lovish.logistic.platform.entity.AssignmentHistory;

@Repository
public interface AssignmentHistoryRepository extends MongoRepository<AssignmentHistory, String> {

	List<AssignmentHistory> findByShipmentIdOrderByTimestampAsc(String shipmentId);
}