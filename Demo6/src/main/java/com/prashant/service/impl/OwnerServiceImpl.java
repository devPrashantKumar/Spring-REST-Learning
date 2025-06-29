package com.prashant.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prashant.dto.OwnerDTO;
import com.prashant.exception.OwnerNotFoundException;
import com.prashant.exception.ValidationException;
import com.prashant.repository.OwnerRepository;
import com.prashant.service.OwnerService;
import com.prashant.util.OwnerMapper;

import lombok.RequiredArgsConstructor;

/**
 * @author prashant
 */
@RequiredArgsConstructor
@Service
public class OwnerServiceImpl implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final OwnerMapper ownerMapper;
	@Value("${owner.not.found}")
	private String ownerNotFound;
	@Value("${date.range.invalid}")
	private String dateRangeInvalid;
	@Value("${city.is.null}")
	private String cityIsNull;
	@Value("${state.is.null}")
	private String stateIsNull;
	
	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		return ownerRepository.findById(ownerId)
				.map(ownerMapper::ownerToOwnerDTO)
				.orElseThrow(() -> new OwnerNotFoundException(String.format(ownerNotFound, ownerId)));
	}
	
	@Override
	public List<OwnerDTO> findByAllOwnersByPetDateOfBirthBetween(LocalDate startDate, LocalDate endDate)
			throws ValidationException {
		if (startDate.isAfter(endDate)) {
			throw new ValidationException(String.format(dateRangeInvalid, startDate, endDate));
		} else {
			return ownerRepository.findAllOwnersByPetDateOfBirthRange(startDate, endDate)
					.stream()
					.map(ownerMapper::ownerToOwnerDTO)
					.toList();
		}
	}
	
	@Override
	public List<OwnerDTO> findAllOwnersByCityAndState(String city, String state) throws ValidationException {
		if (Objects.isNull(city)) {
			throw new ValidationException(cityIsNull);
		} else if (Objects.isNull(state)) {
			throw new ValidationException(stateIsNull);
		} else {
		return ownerRepository.findByCityAndState(city, state)
				.stream()
				.map(ownerMapper::ownerToOwnerDTO)
				.toList();
		}
	}

}
