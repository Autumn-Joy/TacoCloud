package com.example.tacocloud.controller;

import com.example.tacocloud.dto.RegistrationFormDTO;
import com.example.tacocloud.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    //get access to an instance of UserRepository and passwordEncoder

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    // define the constructor

    public RegistrationController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // what happens for a get request to /register?

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "registration";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("registrationForm") RegistrationFormDTO form) {
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
