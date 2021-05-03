package com.nathanreis.maquinaestado_junit5.statemachine;

import com.nathanreis.maquinaestado_junit5.config.Config;
import com.nathanreis.maquinaestado_junit5.storage.Storage;
import java.util.Scanner;

public class ConfirmDeleteState implements IStateMachine {
    @Override
    public boolean execute() {
        System.out.println("");
        System.out.println("Você quer mesmo excluir?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        
        boolean exit = false;
        
        int option = -1;
        
        Scanner scanner = new Scanner(System.in);
        String optionStr = scanner.nextLine();

        if (optionStr.matches("^\\d*$")) {
            option = Integer.parseInt(optionStr);
        }
        
        switch (option) {
            case 1:
                Storage.getInstance().delete();
                break;
        }
        
        Config.getInstance().setNextStateMachine(
            EnumStateMachine.WELCOME.getSateMachine()
        );
        
        return exit;
    }
}
