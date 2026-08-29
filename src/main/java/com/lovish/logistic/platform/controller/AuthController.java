package com.lovish.logistic.platform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovish.logistic.platform.dto.AuthResponseDto;
import com.lovish.logistic.platform.dto.LoginRequestDto;
import com.lovish.logistic.platform.dto.RegisterRequestDto;
import com.lovish.logistic.platform.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(dto));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto dto) {
		return ResponseEntity.status(HttpStatus.OK).body(authService.login(dto));
	}

}
