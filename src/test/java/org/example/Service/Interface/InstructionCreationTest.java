package org.example.Service.Interface;

import org.example.Data.RecipeInstructionRepository;
import org.example.Model.Entity.RecipeInstruction;
import org.example.Service.Interfaces.InstructionCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
public class InstructionCreationTest {

    @Autowired
    private InstructionCreation testCreateInstruction;
    @Autowired
    private RecipeInstructionRepository instructionRepository;

    @Test
    public void check_if_instruction_is_saved_and_created(){
        RecipeInstruction result = testCreateInstruction.createAndSave("testInstruction");

        assertNotNull(result);
        assertEquals(result, instructionRepository.findByInstructions("testInstruction").get());
    }

    /**
     * Add test to check if existing instruction doesn't get saved and created
     */
}
