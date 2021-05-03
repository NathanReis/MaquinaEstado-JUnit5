package com.nathanreis.maquinaestado_junit5.statemachine;

import com.nathanreis.maquinaestado_junit5.config.Config;
import com.nathanreis.maquinaestado_junit5.storage.Storage;
import com.nathanreis.maquinaestado_junit5.validation.AnimeValidation;
import java.util.ArrayList;
import java.util.Scanner;

public class InputAmountTotalEpisodesState implements IStateMachine {
    @Override
    public boolean execute() {
        System.out.println("");
        System.out.println("Informe o total de episódios:");
        
        boolean exit = false;
        
        int amountTotalEpisodes = 0;
        
        Scanner scanner = new Scanner(System.in);
        String amountTotalEpisodesStr = scanner.nextLine();

        if (amountTotalEpisodesStr.matches("^\\d*$")) {
            amountTotalEpisodes = Integer.parseInt(amountTotalEpisodesStr);
        }
        
        ArrayList<String> errorsAmountTotalEpisodes = AnimeValidation.getErrorsAmountTotalEpisodes(amountTotalEpisodes);
        
        if (errorsAmountTotalEpisodes.isEmpty()) {
            Storage
                .getInstance()
                .getAnime()
                .setAmountTotalEpisodes(amountTotalEpisodes);

            Config.getInstance().setNextStateMachine(
                EnumStateMachine.INPUT_AMOUNT_SEASONS.getSateMachine()
            );
        } else {
            for (String error : errorsAmountTotalEpisodes) {
                System.out.println(error);
            }
        }
        
        return exit;
    }
}
