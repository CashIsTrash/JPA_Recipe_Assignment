package org.example.Service.Interfaces;

import org.example.Model.Entity.Ingredient;
import org.springframework.transaction.annotation.Transactional;

public interface IngredientCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    Ingredient createAndSave(String ingredientName);

}
