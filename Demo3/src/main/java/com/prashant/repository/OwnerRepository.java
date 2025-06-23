package com.prashant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.entity.Owner;

/**
 * @author prashant
 */
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
