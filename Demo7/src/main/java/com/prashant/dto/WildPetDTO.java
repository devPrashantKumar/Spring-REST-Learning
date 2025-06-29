package com.prashant.dto;

import com.prashant.enums.Gender;
import com.prashant.enums.PetType;

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

	private String birthPlace;

	@Builder
	public WildPetDTO(int id, String name, Gender gender, PetType type, OwnerDTO ownerDTO, String birthPlace) {
		super(id, name, gender, type, ownerDTO);
		this.birthPlace = birthPlace;
	}

}
