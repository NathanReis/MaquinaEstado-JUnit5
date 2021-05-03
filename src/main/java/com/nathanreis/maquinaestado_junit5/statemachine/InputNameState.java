package com.nathanreis.maquinaestado_junit5.statemachine;

import com.nathanreis.maquinaestado_junit5.config.Config;
import com.nathanreis.maquinaestado_junit5.model.AnimeModel;
import com.nathanreis.maquinaestado_junit5.storage.Storage;
import com.nathanreis.maquinaestado_junit5.validation.AnimeValidation;
import java.util.ArrayList;
import java.util.Scanner;

public class InputNameState implements IStateMachine {
    @Override
    public boolean execute() {
        System.out.println("");
        System.out.println("Informe o nome:");
        
        boolean exit = false;
        
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        
        ArrayList<String> errorsName = AnimeValidation.getErrorsName(name);
        
        if (errorsName.isEmpty()) {
            AnimeModel anime = new AnimeModel();
            anime.setName(name);

            Storage.getInstance().save(anime);

            Config.getInstance().setNextStateMachine(
                EnumStateMachine.INPUT_AMOUNT_TOTAL_EPISODES.getSateMachine()
            );
        } else {
            for (String error : errorsName) {
                System.out.println(error);
            }
        }
        
        return exit;
    }
}
