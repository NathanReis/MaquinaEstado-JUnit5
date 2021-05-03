package com.nathanreis.maquinaestado_junit5.validation;

import java.util.ArrayList;

public class AnimeValidation {
    public static ArrayList<String> getErrorsName(String name) {
        ArrayList<String> errors = new ArrayList<>();
        
        if (name.isBlank()) {
            errors.add("Obrigatório");
        } else {
            if (name.length() > 50) {
                errors.add("Ultrapassou 50 caracteres");
            }
        }
        
        return errors;
    }
    
    public static ArrayList<String> getErrorsAmountTotalEpisodes(int amountTotalEpisodes) {
        ArrayList<String> errors = new ArrayList<>();
        
        if (amountTotalEpisodes < 1) {
            errors.add("Mínimo é 1");
        } else if (amountTotalEpisodes > 2500) {
            errors.add("Máximo é 2500");
        }
        
        return errors;
    }
    
    public static ArrayList<String> getErrorsAmountSeasons(int amountSeasons) {
        ArrayList<String> errors = new ArrayList<>();
        
        if (amountSeasons < 1) {
            errors.add("Mínimo é 1");
        } else if (amountSeasons > 100) {
            errors.add("Máximo é 100");
        }
        
        return errors;
    }
}
