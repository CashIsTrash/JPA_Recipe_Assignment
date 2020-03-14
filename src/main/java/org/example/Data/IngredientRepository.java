package org.example.Data;

import org.example.Model.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    Optional<Ingredient> findByIngredientNameIgnoreCase(String ingredient);
    List<Ingredient> findByIngredientNameContainingIgnoreCase(String string);
}
