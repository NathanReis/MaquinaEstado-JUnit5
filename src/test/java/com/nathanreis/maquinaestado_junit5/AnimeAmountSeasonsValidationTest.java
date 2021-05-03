package com.nathanreis.maquinaestado_junit5;

import com.nathanreis.maquinaestado_junit5.validation.AnimeValidation;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnimeAmountSeasonsValidationTest {
    @Test
    @DisplayName("Test the minimum values of seasons")
    public void testMinimumSeasons() {
        int amountSeasons = 0;
        
        ArrayList<String> errors = AnimeValidation.getErrorsAmountSeasons(amountSeasons);
        
        int amountErrorsExpect = 1;
        
        assertEquals(amountErrorsExpect, errors.size());
        assertTrue(errors.contains("Mínimo é 1"));
        
        amountSeasons = 1;
        
        errors = AnimeValidation.getErrorsAmountSeasons(amountSeasons);
        
        amountErrorsExpect = 0;
        
        assertEquals(amountErrorsExpect, errors.size());
    }
    
    @Test
    @DisplayName("Test the maximum values of seasons")
    public void testMaximumEpisodes() {
        int amountSeasons = 101;
        
        ArrayList<String> errors = AnimeValidation.getErrorsAmountSeasons(amountSeasons);
        
        int amountErrorsExpect = 1;
        
        assertEquals(amountErrorsExpect, errors.size());
        assertTrue(errors.contains("Máximo é 100"));
        
        amountSeasons = 100;
        
        errors = AnimeValidation.getErrorsAmountSeasons(amountSeasons);
        
        amountErrorsExpect = 0;
        
        assertEquals(amountErrorsExpect, errors.size());
    }
}
