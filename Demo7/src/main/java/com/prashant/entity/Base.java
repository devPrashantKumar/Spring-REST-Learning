package com.prashant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * @author prashant
 */
@Getter 
@MappedSuperclass 
public abstract class Base { 

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id; 

}
