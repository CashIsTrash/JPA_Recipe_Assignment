package org.example.Data;

import org.example.Model.Entity.RecipeInstruction;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, String> {
    Optional<RecipeInstruction> findByInstructions(String instruction);
}
