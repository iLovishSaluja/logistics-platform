package com.lovish.logistic.platform.dto;

import com.lovish.logistic.platform.enums.AuthProvider;
import com.lovish.logistic.platform.enums.Role;

public class ProfileResponse {

	private String id;

	private String username;

	private String email;

	private Role role;

	private AuthProvider authProvider;

	private boolean enabled;

	public ProfileResponse() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public AuthProvider getAuthProvider() {
		return authProvider;
	}

	public void setAuthProvider(AuthProvider authProvider) {
		this.authProvider = authProvider;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}