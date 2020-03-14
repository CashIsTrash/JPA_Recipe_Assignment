package org.example.Service.Interface;

import org.example.Data.IngredientRepository;
import org.example.Model.Entity.Ingredient;
import org.example.Service.Interfaces.IngredientCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
public class IngredientCreationTest {

    @Autowired
    private IngredientCreation testObject;
    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void check_if_ingredient_is_saved_and_created(){
        Ingredient result = testObject.createAndSave("testIngredientName");

        assertNotNull(result);
        assertEquals(result, ingredientRepository.findByIngredientNameIgnoreCase("testIngredientName").get());
    }

}
