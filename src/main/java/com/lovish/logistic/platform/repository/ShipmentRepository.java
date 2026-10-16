package com.lovish.logistic.platform.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lovish.logistic.platform.entity.Shipment;
import com.lovish.logistic.platform.enums.CodCollectionStatus;
import com.lovish.logistic.platform.enums.PaymentMethod;
import com.lovish.logistic.platform.enums.ShipmentStatus;

@Repository
public interface ShipmentRepository extends MongoRepository<Shipment, String> {

	Optional<Shipment> findByTrackingNumberIgnoreCase(String trackingNumber);

	boolean existsByTrackingNumberIgnoreCase(String trackingNumber);

	List<Shipment> findByCustomerId(String customerId);

	List<Shipment> findByAssignedDeliveryAgentId(String deliveryAgentId);

	List<Shipment> findByStatus(ShipmentStatus status);

	List<Shipment> findByAssignedDeliveryAgentIdAndStatusIn(String deliveryAgentId,
			Collection<ShipmentStatus> statuses);

	long countByAssignedDeliveryAgentId(String deliveryAgentId);

	long countByAssignedDeliveryAgentIdAndStatus(String deliveryAgentId, ShipmentStatus status);

	long countByAssignedDeliveryAgentIdAndStatusIn(String deliveryAgentId, Collection<ShipmentStatus> statuses);

	List<Shipment> findByAssignedDeliveryAgentIdAndPaymentMethod(String assignedDeliveryAgentId,
			PaymentMethod paymentMethod);

	List<Shipment> findByPaymentMethodAndCodCollectionStatus(PaymentMethod paymentMethod,
			CodCollectionStatus codCollectionStatus);

	List<Shipment> findByPaymentMethod(PaymentMethod paymentMethod);

}