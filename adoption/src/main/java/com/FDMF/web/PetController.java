package com.FDMF.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.FDMF.data.OwnerRepository;
import com.FDMF.data.PetRepository;
import com.FDMF.model.Pet;

@Controller

public class PetController {

	 @Autowired
	 private PetRepository petRepo;
	
	 @Autowired
	 private OwnerRepository ownerRepo;
	
	 @GetMapping("/addPet")
	 public String showPetForm(Model model) {
	     model.addAttribute("pet", new Pet()); 
	     model.addAttribute("owners", ownerRepo.findAll());
	     return "addPet";
	 }
	
	 @PostMapping("/addPet")
	 public String addPet(@ModelAttribute Pet pet) {
	     petRepo.save(pet);
	     return "redirect:/listPets";
	 }
	
	 @GetMapping("/listPets")
	 public String listPets(Model model) {
	     model.addAttribute("pets", petRepo.findAll());
	     return "listPets";
	 }
}