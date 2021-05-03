package com.nathanreis.maquinaestado_junit5.statemachine;

import com.nathanreis.maquinaestado_junit5.config.Config;
import com.nathanreis.maquinaestado_junit5.storage.Storage;
import com.nathanreis.maquinaestado_junit5.validation.AnimeValidation;
import java.util.ArrayList;
import java.util.Scanner;

public class InputAmountSeasonsState implements IStateMachine {
    @Override
    public boolean execute() {
        System.out.println("");
        System.out.println("Informe o total de temporadas:");
        
        boolean exit = false;
        
        int amountSeasons = 0;
        
        Scanner scanner = new Scanner(System.in);
        String amountSeasonsStr = scanner.nextLine();

        if (amountSeasonsStr.matches("^\\d*$")) {
            amountSeasons = Integer.parseInt(amountSeasonsStr);
        }
        
        ArrayList<String> errorsAmountSeasons = AnimeValidation.getErrorsAmountSeasons(amountSeasons);
        
        if (errorsAmountSeasons.isEmpty()) {
            Storage
                .getInstance()
                .getAnime()
                .setAmountSeasons(amountSeasons);

            Config.getInstance().setNextStateMachine(
                EnumStateMachine.WELCOME.getSateMachine()
            );
        } else {
            for (String error : errorsAmountSeasons) {
                System.out.println(error);
            }
        }
        
        return exit;
    }
}
