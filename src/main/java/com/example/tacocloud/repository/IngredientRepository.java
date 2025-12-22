/*
 *
 * Repositories move domain objects to and from the database.
 * That's their responsibility.
 *
 * `save`
 * `findById`
 * `findAll`
 * `deleteById`
 * query objects
 *
 *
 * Models (entities) are the nouns: taco, ingredient, order, etc
 * Repositories  are the verbs: save a taco, find an order, delete an Ingredient; load all Tacos
 *
 * Domain-driven design (DDD): a repository acts like a collection of entities,
 * but backed by persistence;
 *
 */


package com.example.tacocloud.repository;

import com.example.tacocloud.domain.Ingredient;
import java.util.Optional;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}


