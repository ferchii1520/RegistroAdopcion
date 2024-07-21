package com.FDMF.data;

import org.springframework.data.repository.CrudRepository;

import com.FDMF.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
}
