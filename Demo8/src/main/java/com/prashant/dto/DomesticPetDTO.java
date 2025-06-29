package com.prashant.dto;

import java.time.LocalDate;

import com.prashant.enums.Gender;
import com.prashant.enums.PetType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author prashant
 */
@NoArgsConstructor
@ToString(callSuper = true)
@Setter
@Getter 
public class DomesticPetDTO extends PetDTO {

	@PastOrPresent(message = "{pet.birth.date.old}")
	@NotNull(message = "{pet.birth.date.required}")
	private LocalDate birthDate;

	@Builder
	public DomesticPetDTO(int id, String name, Gender gender, PetType type, OwnerDTO ownerDTO, LocalDate birthDate) {
		super(id, name, gender, type, ownerDTO);
		this.birthDate = birthDate;
	}

}
