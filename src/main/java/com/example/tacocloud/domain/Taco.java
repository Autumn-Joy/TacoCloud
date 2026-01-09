package com.example.tacocloud.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "taco")
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, message = "Name must be at least 1 character long.")
    private String name;

    private Date createdAt =  new Date();

    @Size(min=1, message = "You must choose at least 1 ingredient.")

    @ManyToMany()
    @JoinTable(
            name = "taco_ingredient",
            joinColumns = @JoinColumn(name = "taco_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;


    @ManyToOne
    @JoinColumn(name = "taco_order_id", nullable = false)
    private TacoOrder tacoOrder;

    // remember LomBok generates the getters and setters already

    public void addIngredient(Ingredient ingredient) {

        this.ingredients.add(ingredient);
    }
}



