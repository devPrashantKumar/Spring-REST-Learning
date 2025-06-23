package com.prashant.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prashant.exception.OwnerNotFoundException;
import com.prashant.repository.OwnerRepository;
import com.prashant.service.OwnerService;

import lombok.RequiredArgsConstructor;

/**
 * @author prashant
 */
@RequiredArgsConstructor
@Service
public class OwnerServiceImpl implements OwnerService {

	private final OwnerRepository ownerRepository;
	@Value("${owner.not.found}")
	private String ownerNotFound;
	private boolean toggle = true;

	@Override
	public String saveOwner() {
		return ownerRepository.save();
	}

	@Override
	public String findOwner() throws OwnerNotFoundException {
		if (toggle) {
			toggle = !toggle;
			return ownerRepository.find();
		} else {
			toggle = !toggle;
			throw new OwnerNotFoundException(ownerNotFound);
		}
	}
	
	@Override
	public String updateOwner() throws OwnerNotFoundException {
		if (toggle) {
			toggle = !toggle;
			return ownerRepository.updateOwner();
		} else {
			toggle = !toggle;
			throw new OwnerNotFoundException(ownerNotFound);
		}
	}

	@Override
	public String updatePetDetails() throws OwnerNotFoundException {
		if (toggle) {
			toggle = !toggle;
			return ownerRepository.updatePetDetails();
		} else {
			toggle = !toggle;
			throw new OwnerNotFoundException(ownerNotFound);
		}
	}

	@Override
	public String deleteOwner() throws OwnerNotFoundException {
		if (toggle) {
			toggle = !toggle;
			return ownerRepository.delete();
		} else {
			toggle = !toggle;
			throw new OwnerNotFoundException(ownerNotFound);
		}
	}

	@Override
	public String findAllOwners() {
		return ownerRepository.findAll();
	}

}
