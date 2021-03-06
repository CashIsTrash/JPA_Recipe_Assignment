package org.example.Data;

import org.example.Model.Entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Optional<Recipe> findByRecipeName(String recipeName);

    List<Recipe> findByRecipeNameContainingIgnoreCase(String string);

    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeIngredientList recipeIngredient WHERE recipeIngredient.ingredient.ingredientName = :ingredientName")
    List<Recipe> findRecipeByIngredientNameIgnoreCase(@Param("ingredientName") String ingredientName);

    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeCategoryList recipeCategory WHERE recipeCategory.category = :category")
    List<Recipe> findRecipeByCategory(@Param("category") String category);

    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeCategoryList recipeCategory WHERE recipeCategory.category IN :categories")
    List<Recipe> findRecipeByCategories(@Param("categories") String...categories);

}
