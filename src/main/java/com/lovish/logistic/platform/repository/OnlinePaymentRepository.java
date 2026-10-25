package com.lovish.logistic.platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lovish.logistic.platform.entity.OnlinePayment;

public interface OnlinePaymentRepository extends MongoRepository<OnlinePayment, String> {

	Optional<OnlinePayment> findFirstByShipmentIdAndCustomerIdOrderByCreatedAtDesc(String shipmentId,
			String customerId);

	Optional<OnlinePayment> findByRazorpayOrderId(String razorpayOrderId);

	Optional<OnlinePayment> findByRazorpayPaymentId(String razorpayPaymentId);

	List<OnlinePayment> findByCustomerIdOrderByCreatedAtDesc(String customerId);
	
	
}