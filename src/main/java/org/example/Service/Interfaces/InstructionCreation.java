package org.example.Service.Interfaces;

import org.example.Model.Entity.RecipeInstruction;
import org.springframework.transaction.annotation.Transactional;

public interface InstructionCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeInstruction createAndSave(String instructions);
}
