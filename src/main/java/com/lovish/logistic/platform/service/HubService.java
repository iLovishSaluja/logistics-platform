package com.lovish.logistic.platform.service;

import java.util.List;

import com.lovish.logistic.platform.dto.HubCreateRequestDto;
import com.lovish.logistic.platform.dto.HubResponseDto;

public interface HubService {

	HubResponseDto createHub(HubCreateRequestDto request);

	List<HubResponseDto> getAllHubs();

	HubResponseDto getHubById(String hubId);

	HubResponseDto updateHub(String hubId, HubCreateRequestDto request);

	void deactivateHub(String hubId);
}