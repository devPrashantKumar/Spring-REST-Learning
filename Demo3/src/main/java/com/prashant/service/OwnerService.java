package com.prashant.service;

import java.util.List;

import com.prashant.dto.OwnerDTO;
import com.prashant.exception.OwnerNotFoundException;

/**
 * @author prashant
 */
public interface OwnerService {

	Integer saveOwner(OwnerDTO ownerDTO);

	void updateOwner(int ownerId, OwnerDTO ownerDTO) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

	List<OwnerDTO> findAllOwners();

}
