package com.FDMF.data;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.FDMF.model.Pet;

public interface PetRepository extends PagingAndSortingRepository<Pet, Long> {
	
    @Override
    Optional<Pet> findById(Long id);

    List<Pet> findByName(String name);

    @Query("SELECT p FROM Pet p WHERE p.name LIKE %:name%")
    List<Pet> findByNameContaining(@Param("name") String name);

    @Query("SELECT p FROM Pet p ORDER BY p.fechaNac DESC")
    List<Pet> findTop20YoungestPets();

    @Query("SELECT p FROM Pet p")
    Page<Pet> findAllPets(Pageable pageable);
}