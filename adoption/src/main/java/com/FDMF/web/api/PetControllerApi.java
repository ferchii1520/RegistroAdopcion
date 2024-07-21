package com.FDMF.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public Iterable<Pet> findAllPets() {
        return petRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> petById(@PathVariable("id") Long id) {
        Optional<Pet> optPet = petRepo.findById(id);
        if (optPet.isPresent()) {
            return new ResponseEntity<>(optPet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    public Iterable<Pet> petsByName(@RequestParam("name") String name) {
        return petRepo.findByName(name);
    }

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePet(@PathVariable("id") Long id) {
        petRepo.deleteById(id);
    }
}

