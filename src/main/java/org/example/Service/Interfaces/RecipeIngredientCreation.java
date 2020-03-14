package org.example.Service.Interfaces;

import org.example.Model.Entity.Ingredient;
import org.example.Model.Entity.RecipeIngredient;
import org.example.Model.Measurement;
import org.springframework.transaction.annotation.Transactional;

public interface RecipeIngredientCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeIngredient createAndSave(Ingredient ingredient, Double amount, Measurement measurement);
}
