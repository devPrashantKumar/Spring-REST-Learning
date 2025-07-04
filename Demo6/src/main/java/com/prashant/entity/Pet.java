package com.prashant.entity;

import com.prashant.enums.Gender;
import com.prashant.enums.PetType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author prashant
 */
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pet_table")
@Entity
public abstract class Pet extends Base {

	@Column(name = "name", nullable = false)
	private String name;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "type", nullable = false)
	private PetType type;
	@OneToOne(mappedBy = "pet")
	private Owner owner;

}
