package com.example.tacocloud.domain;

import lombok.Data;

@Data
public class IngredientRef {
    private final String ingredient;
}

/*
 *
 * what lombok generates:
 *
 *
 * public class IngredientRef {
    private final String ingredient;

    public IngredientRef(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredient() {
        return ingredient;
    }

    public boolean equals(Object o) { ... }
    public int hashCode() { ... }
    public String toString() { ... }
}

 *
 */