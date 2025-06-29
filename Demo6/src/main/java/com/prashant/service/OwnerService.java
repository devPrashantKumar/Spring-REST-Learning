package com.prashant.service;

import java.time.LocalDate;
import java.util.List;

import com.prashant.dto.OwnerDTO;
import com.prashant.exception.OwnerNotFoundException;
import com.prashant.exception.ValidationException;

/**
 * @author prashant
 */
public interface OwnerService {

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	List<OwnerDTO> findByAllOwnersByPetDateOfBirthBetween(LocalDate startDate, LocalDate endDate)
			throws ValidationException;
	
	List<OwnerDTO> findAllOwnersByCityAndState(String city, String state) throws ValidationException;

}
