package com.FDMF.web.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.FDMF.data.OwnerRepository;
import com.FDMF.model.Owner;

@RestController
@RequestMapping(path = "/api/owners", produces = "application/json")
public class OwnerControllerApi {
	@Autowired
    private OwnerRepository ownerRepo;

    @GetMapping
    public Iterable<Owner> findAllOwners() {
        return ownerRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> ownerById(@PathVariable("id") Long id) {
        Optional<Owner> optOwner = ownerRepo.findById(id);
        if (optOwner.isPresent()) {
            return new ResponseEntity<>(optOwner.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepo.save(owner);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Owner updateOwner(@RequestBody Owner owner) {
        return ownerRepo.save(owner);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOwner(@PathVariable("id") Long id) {
        ownerRepo.deleteById(id);
    }
}