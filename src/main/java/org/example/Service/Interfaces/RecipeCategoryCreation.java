package org.example.Service.Interfaces;

import org.example.Model.Entity.RecipeCategory;
import org.springframework.transaction.annotation.Transactional;

public interface RecipeCategoryCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeCategory saveAndCreate(String category);
}
