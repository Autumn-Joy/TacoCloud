package com.example.tacocloud.dto;

import com.example.tacocloud.domain.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationFormDTO {
    // add fields for everything in registration.html

    private String username;
    private String password;
    private String email;

    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    // RegistrationFormDTO defines the toUser() method, called by RegistrationController
    // toUser() takes in a passwordEncoder instance from the RegistrationController
    // toUser() uses that param to encode the password and create a User instance

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                email, fullname, street, city, state, zip, phoneNumber);
    }
}
