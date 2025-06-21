package com.prashant.service;

import com.prashant.exception.OwnerNotFoundException;

/**
 * @author abhishekvermaa10
 */
public interface OwnerService {
	
	String saveOwner();

	String findOwner() throws OwnerNotFoundException;
	
	String updateOwner() throws OwnerNotFoundException;

	String updatePetDetails() throws OwnerNotFoundException;

	String deleteOwner() throws OwnerNotFoundException;

	String findAllOwners();
	
}
