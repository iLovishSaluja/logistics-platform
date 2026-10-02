package com.lovish.logistic.platform.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lovish.logistic.platform.dto.HubCreateRequestDto;
import com.lovish.logistic.platform.dto.HubResponseDto;
import com.lovish.logistic.platform.entity.Address;
import com.lovish.logistic.platform.entity.Hub;
import com.lovish.logistic.platform.exception.BadRequestException;
import com.lovish.logistic.platform.exception.ResourceNotFoundException;
import com.lovish.logistic.platform.repository.HubRepository;

@Service
public class HubServiceImpl implements HubService {

	private final HubRepository hubRepository;

	public HubServiceImpl(HubRepository hubRepository) {
		this.hubRepository = hubRepository;
	}

	@Override
	public HubResponseDto createHub(HubCreateRequestDto request) {

		if (hubRepository.existsByCodeIgnoreCase(request.getCode())) {
			throw new BadRequestException("Hub with code already exists: " + request.getCode());
		}

		LocalDateTime now = LocalDateTime.now();

		Hub hub = new Hub();

		hub.setName(request.getName());
		hub.setCode(request.getCode().trim().toUpperCase());
		hub.setAddress(toAddressEntity(request.getAddress()));
		hub.setActive(true);
		hub.setCreatedAt(now);
		hub.setUpdatedAt(now);

		Hub savedHub = hubRepository.save(hub);

		return toResponseDto(savedHub);
	}

	@Override
	public List<HubResponseDto> getAllHubs() {

		return hubRepository.findAll().stream().map(this::toResponseDto).toList();
	}

	@Override
	public HubResponseDto getHubById(String hubId) {

		Hub hub = hubRepository.findById(hubId)
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubId));

		return toResponseDto(hub);
	}

	@Override
	public HubResponseDto updateHub(String hubId, HubCreateRequestDto request) {

		Hub hub = hubRepository.findById(hubId)
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubId));

		String requestedCode = request.getCode().trim().toUpperCase();

		if (!hub.getCode().equalsIgnoreCase(requestedCode) && hubRepository.existsByCodeIgnoreCase(requestedCode)) {

			throw new BadRequestException("Hub with code already exists: " + requestedCode);
		}

		hub.setName(request.getName());
		hub.setCode(requestedCode);
		hub.setAddress(toAddressEntity(request.getAddress()));
		hub.setUpdatedAt(LocalDateTime.now());

		Hub updatedHub = hubRepository.save(hub);

		return toResponseDto(updatedHub);
	}

	@Override
	public void deactivateHub(String hubId) {

		Hub hub = hubRepository.findById(hubId)
				.orElseThrow(() -> new ResourceNotFoundException("Hub not found with id: " + hubId));

		if (!hub.isActive()) {
			throw new BadRequestException("Hub is already inactive");
		}

		hub.setActive(false);
		hub.setUpdatedAt(LocalDateTime.now());

		hubRepository.save(hub);
	}

	private Address toAddressEntity(com.lovish.logistic.platform.dto.AddressDto dto) {

		Address address = new Address();

		address.setFullName(dto.getFullName());
		address.setPhoneNumber(dto.getPhoneNumber());
		address.setAddressLine(dto.getAddressLine());
		address.setCity(dto.getCity());
		address.setState(dto.getState());
		address.setPostalCode(dto.getPostalCode());
		address.setCountry(dto.getCountry());

		return address;
	}

	private HubResponseDto toResponseDto(Hub hub) {

		HubResponseDto dto = new HubResponseDto();

		dto.setId(hub.getId());
		dto.setName(hub.getName());
		dto.setCode(hub.getCode());
		dto.setAddress(toAddressDto(hub.getAddress()));
		dto.setActive(hub.isActive());
		dto.setCreatedAt(hub.getCreatedAt());
		dto.setUpdatedAt(hub.getUpdatedAt());

		return dto;
	}

	private com.lovish.logistic.platform.dto.AddressDto toAddressDto(Address address) {

		if (address == null) {
			return null;
		}

		com.lovish.logistic.platform.dto.AddressDto dto = new com.lovish.logistic.platform.dto.AddressDto();

		dto.setFullName(address.getFullName());
		dto.setPhoneNumber(address.getPhoneNumber());
		dto.setAddressLine(address.getAddressLine());
		dto.setCity(address.getCity());
		dto.setState(address.getState());
		dto.setPostalCode(address.getPostalCode());
		dto.setCountry(address.getCountry());

		return dto;
	}
}