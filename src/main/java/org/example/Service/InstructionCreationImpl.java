package org.example.Service;

import org.example.Data.RecipeInstructionRepository;
import org.example.Model.Entity.RecipeInstruction;
import org.example.Service.Interfaces.InstructionCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InstructionCreationImpl implements InstructionCreation {

    private RecipeInstructionRepository instructionRepository;

    @Autowired
    public InstructionCreationImpl(RecipeInstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstruction createAndSave(String instructions) {
        if(instructions.isEmpty()){
            throw new RuntimeException("You have to enter a instruction");
        }

        if(instructionRepository.findByInstructions(instructions).isPresent()){
            throw new RuntimeException("This instruction already exists");
        }

        RecipeInstruction instruction = new RecipeInstruction(instructions);
        return instructionRepository.save(instruction);
    }
}
