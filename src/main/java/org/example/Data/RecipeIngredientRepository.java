package org.example.Data;

import org.example.Model.Entity.Ingredient;
import org.example.Model.Entity.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {
    Optional<RecipeIngredient> findByIngredient(Ingredient ingredient);
}
