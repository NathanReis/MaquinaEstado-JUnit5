package com.nathanreis.maquinaestado_junit5;

import com.nathanreis.maquinaestado_junit5.validation.AnimeValidation;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnimeNameValidationTest {
    @Test
    @DisplayName("Test an empty name")
    public void testEmptyName() {
        String name = "";
        
        ArrayList<String> errors = AnimeValidation.getErrorsName(name);
        
        int amountErrorsExpect = 1;
        
        assertEquals(amountErrorsExpect, errors.size());
        assertTrue(errors.contains("Obrigatório"));
    }
    
    @Test
    @DisplayName("Test a very long name")
    public void testVeryLongName() {
        String name = "012345678901234567890123456789012345678901234567890";
        
        ArrayList<String> errors = AnimeValidation.getErrorsName(name);
        
        int amountErrorsExpect = 1;
        
        assertEquals(amountErrorsExpect, errors.size());
        assertTrue(errors.contains("Ultrapassou 50 caracteres"));
    }
    
    @Test
    @DisplayName("Test a valid name")
    public void testValidName() {
        String name = "Akame Ga Kill";
        
        ArrayList<String> errors = AnimeValidation.getErrorsName(name);
        
        int amountErrorsExpect = 0;
        
        assertEquals(amountErrorsExpect, errors.size());
    }
}
