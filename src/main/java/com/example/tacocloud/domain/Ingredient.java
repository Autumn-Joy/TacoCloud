package com.example.tacocloud.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "ingredient") // matches Postgres
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final String id;

    private final String name;

    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
