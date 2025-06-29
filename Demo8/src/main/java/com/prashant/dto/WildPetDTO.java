package com.prashant.dto;

import com.prashant.enums.Gender;
import com.prashant.enums.PetType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class WildPetDTO extends PetDTO {

	@Size(max = 255, message = "{pet.birth.place.length}")
	@NotBlank(message = "{pet.birth.place.required}")
	private String birthPlace;

	@Builder
	public WildPetDTO(int id, String name, Gender gender, PetType type, OwnerDTO ownerDTO, String birthPlace) {
		super(id, name, gender, type, ownerDTO);
		this.birthPlace = birthPlace;
	}

}
