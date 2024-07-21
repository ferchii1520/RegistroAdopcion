package com.FDMF.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.FDMF.data.OwnerRepository;
import com.FDMF.model.Owner;

@Controller
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepo;

    @GetMapping("/addOwner")
    public String showOwnerForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "addOwner";
    }

    @PostMapping("/addOwner")
    public String addOwner(@ModelAttribute Owner owner) {
        ownerRepo.save(owner);
        return "redirect:/addPet";
    }
}