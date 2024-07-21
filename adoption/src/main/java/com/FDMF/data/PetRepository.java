package com.FDMF.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.FDMF.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
	
	List<Pet> findByName(String name);
	
}