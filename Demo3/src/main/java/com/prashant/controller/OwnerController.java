package com.prashant.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.dto.OwnerDTO;
import com.prashant.dto.UpdatePetDTO;
import com.prashant.exception.OwnerNotFoundException;
import com.prashant.service.OwnerService;

import lombok.RequiredArgsConstructor;

/**
 * @author prashant
 */
@RequiredArgsConstructor
@RequestMapping("/owners")
@RestController
public class OwnerController {
	
	private final OwnerService ownerService;
	
	@PostMapping
	public ResponseEntity<Integer> saveOwner(@RequestBody OwnerDTO ownerDTO) {
		Integer ownerId = ownerService.saveOwner(ownerDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(ownerId);
	}

	@PutMapping
	public ResponseEntity<Void> updateOwner(@RequestBody OwnerDTO ownerDTO) {
		try {
			ownerService.updateOwner(ownerDTO.getId(), ownerDTO);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (OwnerNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PatchMapping
	public ResponseEntity<Void> updatePetDetails(@RequestBody UpdatePetDTO updatePetDTO) {
		try {
			ownerService.updatePetDetails(updatePetDTO.getId(), updatePetDTO.getName());
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (OwnerNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping
	public ResponseEntity<List<OwnerDTO>> findAllOwners() {
		List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
		return ResponseEntity.status(HttpStatus.OK).body(ownerDTOList);
	}

}
