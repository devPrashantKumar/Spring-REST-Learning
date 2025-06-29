package com.prashant.dto;

import com.prashant.enums.Gender;
import com.prashant.enums.PetType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author prashant
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "category")
@JsonSubTypes({ @Type(value = DomesticPetDTO.class, name = "Domestic"),
		@Type(value = WildPetDTO.class, name = "Wild") })
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Setter
@Getter
public abstract class PetDTO {

	@EqualsAndHashCode.Include
	private int id;
	@Size(max = 255, message = "{pet.name.length}")
	@NotBlank(message = "{pet.name.required}")
	private String name;
	@NotNull(message = "{pet.gender.required}")
	private Gender gender;
	@NotNull(message = "{pet.type.required}")
	private PetType type;
	private OwnerDTO ownerDTO;

}
