package com.lovish.logistic.platform.service;

import com.lovish.logistic.platform.dto.AuthResponseDto;
import com.lovish.logistic.platform.dto.LoginRequestDto;
import com.lovish.logistic.platform.dto.RegisterRequestDto;

public interface AuthService {

	AuthResponseDto register(RegisterRequestDto request);

	AuthResponseDto login(LoginRequestDto request);
}
