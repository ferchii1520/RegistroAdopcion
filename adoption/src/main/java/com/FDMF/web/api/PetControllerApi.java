package com.FDMF.web.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.FDMF.data.PetRepository;
import com.FDMF.model.Pet;

@RestController
@RequestMapping(path = "/api/pets", produces = "application/json")
public class PetControllerApi {

	@Autowired
    private PetRepository petRepo;

	//Buscar todos los pets
    @GetMapping
    public Iterable<Pet> findAllPets() {
        return petRepo.findAll();
    }
    
    //Buscar los pets por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> petById(@PathVariable("id") Long id) {
        Optional<Pet> optPet = petRepo.findById(id);
        if (optPet.isPresent()) {
            return new ResponseEntity<>(optPet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Buscar los pets por Nombre
    @GetMapping("/name/{name}")
    public List<Pet> petsByName(@PathVariable("name") String name) {
        return petRepo.findByNameContaining(name);
    }

    //Crear un nuevo pet
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Pet createPet(@RequestBody Pet pet) {
        return petRepo.save(pet);
    }

    
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Pet updatePet(@RequestBody Pet pet) {
        return petRepo.save(pet);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable("id") Long id) {
        Optional<Pet> optPet = petRepo.findById(id);
        if (optPet.isPresent()) {
            petRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/youngest")
    public List<Pet> getYoungestPets() {
        return petRepo.findTop20YoungestPets();
    }

    @GetMapping("/page")
    public Page<Pet> getPetsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return petRepo.findAllPets(pageable);
    }
    
}