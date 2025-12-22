package com.example.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String home() {
        return "homePage"; // returns the view name
    }

}

// revisit section 2.5 for refactoring this controller to use `WebMvcConfigurer` instead

/*
 *
 *
 * By extending an existing configuration class,
 * you can avoid creating a new configuration class,
 * keeping your project artifact count down.
 *
 *
 * on the other hand
 * creating a new configuration class
 * for each kind of configuration (web, data, security, and so on),
 * can keep the application bootstrap configuration clean and simple.
 *
 *
 */

