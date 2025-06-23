package com.prashant.repository;

/**
 * @author prashant
 */
public interface OwnerRepository {

	String save();

	String find();

	String updateOwner();
	
	String updatePetDetails();

	String delete();

	String findAll();

}
