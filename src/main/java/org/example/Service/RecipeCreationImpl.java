package org.example.Service;

import org.example.Data.RecipeRepository;
import org.example.Model.Entity.Recipe;
import org.example.Model.Entity.RecipeCategory;
import org.example.Model.Entity.RecipeIngredient;
import org.example.Model.Entity.RecipeInstruction;
import org.example.Service.Interfaces.RecipeCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class RecipeCreationImpl implements RecipeCreation {

    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeCreationImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe saveAndCreate(String recipeName, List<RecipeIngredient> recipeIngredientList, RecipeInstruction instruction, List<RecipeCategory> recipeCategoryList) {
        if(hasNull(recipeName, recipeIngredientList, instruction, recipeCategoryList)){
            throw new RuntimeException("One or many parameters is null");
        }

        if(recipeRepository.findByRecipeName(recipeName).isPresent()){
            throw new RuntimeException("This recipe already exists");
        }

        Recipe recipe = new Recipe(recipeName, recipeIngredientList, instruction, recipeCategoryList);
        return recipeRepository.save(recipe);
    }

    public static boolean hasNull(Object...objects){
        return Arrays.stream(objects)
                .anyMatch(o -> Objects.isNull(o));
    }
}
