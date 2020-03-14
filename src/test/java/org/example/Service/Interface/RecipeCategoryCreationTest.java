package org.example.Service.Interface;

import org.example.Data.RecipeCategoryRepository;

import org.example.Model.Entity.RecipeCategory;
import org.example.Service.Interfaces.RecipeCategoryCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeCategoryCreationTest {

    @Autowired
    private RecipeCategoryCreation testCategoryCreation;

    @Autowired
    private RecipeCategoryRepository categoryRepository;

    @Test
    public void check_if_category_is_saved_and_created(){
        RecipeCategory result = testCategoryCreation.saveAndCreate("testCategory");

        assertNotNull(result);
        assertEquals(result, categoryRepository.findByCategory("testCategory").get());
    }

    /**
     * Add test to check if existing category doesn't get saved and created.
     */
}
