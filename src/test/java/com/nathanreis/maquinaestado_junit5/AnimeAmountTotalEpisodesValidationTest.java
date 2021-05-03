package com.nathanreis.maquinaestado_junit5;

import com.nathanreis.maquinaestado_junit5.validation.AnimeValidation;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnimeAmountTotalEpisodesValidationTest {
    @Test
    @DisplayName("Test the minimum values of episodes")
    public void testMinimumEpisodes() {
        int amountTotalEpisodes = 0;
        
        ArrayList<String> errors = AnimeValidation.getErrorsAmountTotalEpisodes(amountTotalEpisodes);
        
        int amountErrorsExpect = 1;
        
        assertEquals(amountErrorsExpect, errors.size());
        assertTrue(errors.contains("Mínimo é 1"));
        
        amountTotalEpisodes = 1;
        
        errors = AnimeValidation.getErrorsAmountTotalEpisodes(amountTotalEpisodes);
        
        amountErrorsExpect = 0;
        
        assertEquals(amountErrorsExpect, errors.size());
    }
    
    @Test
    @DisplayName("Test the maximum values of episodes")
    public void testMaximumEpisodes() {
        int amountTotalEpisodes = 2501;
        
        ArrayList<String> errors = AnimeValidation.getErrorsAmountTotalEpisodes(amountTotalEpisodes);
        
        int amountErrorsExpect = 1;
        
        assertEquals(amountErrorsExpect, errors.size());
        assertTrue(errors.contains("Máximo é 2500"));
        
        amountTotalEpisodes = 2500;
        
        errors = AnimeValidation.getErrorsAmountTotalEpisodes(amountTotalEpisodes);
        
        amountErrorsExpect = 0;
        
        assertEquals(amountErrorsExpect, errors.size());
    }
}
