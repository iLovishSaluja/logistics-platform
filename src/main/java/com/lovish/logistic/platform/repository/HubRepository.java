package com.lovish.logistic.platform.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lovish.logistic.platform.entity.Hub;

@Repository
public interface HubRepository extends MongoRepository<Hub, String> {

	Optional<Hub> findByCodeIgnoreCase(String code);

	boolean existsByCodeIgnoreCase(String code);
	
	Optional<Hub> findByActiveTrue();
	
    Optional<Hub> findByAddressCityIgnoreCaseAndActiveTrue(String city);
	
}