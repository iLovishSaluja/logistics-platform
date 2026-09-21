package com.lovish.logistic.platform.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lovish.logistic.platform.entity.PricingConfig;

@Repository
public interface PricingConfigRepository extends MongoRepository<PricingConfig, String> {

	Optional<PricingConfig> findByActiveTrue();
}