package com.prashant.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prashant.dto.OwnerDTO;
import com.prashant.dto.UpdatePetDTO;
import com.prashant.exception.OwnerNotFoundException;
import com.prashant.exception.ValidationException;
import com.prashant.service.OwnerService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import lombok.RequiredArgsConstructor;

/**
 * @author prashant
 */
@Validated
@RequiredArgsConstructor
@RequestMapping("/owners")
@RestController
public class OwnerController {

	private final OwnerService ownerService;

	@PostMapping
	public ResponseEntity<Integer> saveOwner(@Valid @RequestBody OwnerDTO ownerDTO) {
		Integer ownerId = ownerService.saveOwner(ownerDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(ownerId);
	}

	@GetMapping("/{ownerId}")
	public ResponseEntity<OwnerDTO> findOwner(
			@PathVariable @Min(value = 1, message = "{owner.id.positive}") int ownerId) throws OwnerNotFoundException {
		OwnerDTO ownerDTO = ownerService.findOwner(ownerId);
		return ResponseEntity.status(HttpStatus.OK).body(ownerDTO);
	}

	@PatchMapping("/{ownerId}")
	public ResponseEntity<Void> updatePetDetails(
			@PathVariable @Min(value = 1, message = "{owner.id.positive}") int ownerId,
			@Valid @RequestBody UpdatePetDTO updatePetDTO) throws OwnerNotFoundException {
		ownerService.updatePetDetails(ownerId, updatePetDTO.getName());
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping("/{ownerId}")
	public ResponseEntity<Void> deleteOwner(@PathVariable @Min(value = 1, message = "{owner.id.positive}") int ownerId)
			throws OwnerNotFoundException {
		ownerService.deleteOwner(ownerId);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/pets/dob")
	public ResponseEntity<List<OwnerDTO>> getAllOwnersByPetDateOfBirthBetween(
			@RequestParam(defaultValue = "2010-01-01") @PastOrPresent(message = "{startDate.old}") LocalDate startDate,
			@RequestParam(defaultValue = "2014-12-01") @PastOrPresent(message = "{endDate.old}") LocalDate endDate)
			throws ValidationException {
		List<OwnerDTO> ownerDTOList = ownerService.findByAllOwnersByPetDateOfBirthBetween(startDate, endDate);
		return ResponseEntity.status(HttpStatus.OK).body(ownerDTOList);
	}

}
