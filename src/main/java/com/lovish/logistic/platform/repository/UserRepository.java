package com.lovish.logistic.platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lovish.logistic.platform.entity.User;
import com.lovish.logistic.platform.enums.Role;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);

	Optional<User> findByEmailOrUsername(String email, String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

	List<User> findByRoleAndHubIdAndEnabledTrue(Role role, String hubId);
}
