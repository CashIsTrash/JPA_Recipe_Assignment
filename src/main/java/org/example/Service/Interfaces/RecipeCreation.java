package org.example.Service.Interfaces;

import org.example.Model.Entity.Recipe;
import org.example.Model.Entity.RecipeCategory;
import org.example.Model.Entity.RecipeIngredient;
import org.example.Model.Entity.RecipeInstruction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecipeCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    Recipe saveAndCreate(String recipeName, List<RecipeIngredient> recipeIngredientList, RecipeInstruction instruction, List<RecipeCategory> recipeCategoryList);
}
