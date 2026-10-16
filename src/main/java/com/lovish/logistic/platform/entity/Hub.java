package com.lovish.logistic.platform.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hubs")
public class Hub {

	@Id
	private String id;

	private String name;

	private String code;

	private Address address;

	private boolean active;

	private boolean automaticAssignmentEnabled;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAutomaticAssignmentEnabled() {
		return automaticAssignmentEnabled;
	}

	public void setAutomaticAssignmentEnabled(boolean automaticAssignmentEnabled) {
		this.automaticAssignmentEnabled = automaticAssignmentEnabled;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}