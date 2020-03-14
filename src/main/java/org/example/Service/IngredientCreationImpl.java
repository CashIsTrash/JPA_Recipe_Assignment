package org.example.Service;

import org.example.Data.IngredientRepository;
import org.example.Model.Entity.Ingredient;
import org.example.Service.Interfaces.IngredientCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngredientCreationImpl implements IngredientCreation {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientCreationImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient createAndSave(String ingredientName) {

        if(ingredientName == null){
            throw new RuntimeException("You have to enter an ingredient");
        }

        if(ingredientRepository.findByIngredientNameIgnoreCase(ingredientName).isPresent()){
            throw new RuntimeException("This ingredient already exist");
        }


        Ingredient ingredient = new Ingredient(ingredientName);
        return ingredientRepository.save(ingredient);
    }
}
