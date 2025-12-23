package com.example.tacocloud.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "taco_order")
public class TacoOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "Delivery name is required.")
    private String deliveryName;

    @NotBlank(message = "Street is required.")
    private String deliveryStreet;

    @NotBlank(message = "City is required.")
    private String deliveryCity;

    @NotBlank(message = "State is required.")
    private String deliveryState;

    @NotBlank(message = "Zip code is required.")
    private String deliveryZip;

    @CreditCardNumber(message = "Please enter a valid credit card number.")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/([0-9]{2})$",
            message = "Expiration must be in MM/YY format")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV.")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos =  new ArrayList<>();

    public void addTaco(Taco taco){

        tacos.add(taco);
    }
}

