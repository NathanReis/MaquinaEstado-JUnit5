package com.nathanreis.maquinaestado_junit5.statemachine;

import com.nathanreis.maquinaestado_junit5.config.Config;
import com.nathanreis.maquinaestado_junit5.config.EnumGenre;
import java.util.Scanner;

public class AskGenreState implements IStateMachine {
    @Override
    public boolean execute() {
        System.out.println("");
        System.out.println("Informe seu sexo:");
        System.out.println("1 - Masculino");
        System.out.println("2 - Feminino");
        System.out.println("3 - Não quero informar");
        System.out.println("---");
        System.out.println("0 - Sair");
        
        boolean exit = false;
        
        int option = -1;
        
        Scanner scanner = new Scanner(System.in);
        String optionStr = scanner.nextLine();

        if (optionStr.matches("^\\d*$")) {
            option = Integer.parseInt(optionStr);
        }
        
        switch (option) {
            case 0:
                exit = true;
                break;
                
            case 1:
                Config.getInstance().setGenre(EnumGenre.MALE.getGenre());
                Config.getInstance().setNextStateMachine(
                    EnumStateMachine.WELCOME.getSateMachine()
                );
                break;
                
            case 2:
                Config.getInstance().setGenre(EnumGenre.FEMALE.getGenre());
                Config.getInstance().setNextStateMachine(
                    EnumStateMachine.WELCOME.getSateMachine()
                );
                break;
                
            case 3:
                Config.getInstance().setGenre(EnumGenre.NONE.getGenre());
                Config.getInstance().setNextStateMachine(
                    EnumStateMachine.WELCOME.getSateMachine()
                );
                break;
        }
        
        return exit;
    }
}
