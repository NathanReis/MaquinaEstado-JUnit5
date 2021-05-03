package com.nathanreis.maquinaestado_junit5.statemachine;

import com.nathanreis.maquinaestado_junit5.config.Config;
import java.util.Scanner;

public class WelcomeState implements IStateMachine {
    @Override
    public boolean execute() {
        System.out.println("");
        System.out.println("Youkoso " + Config.getInstance().getGenre() + " :D");
        System.out.println("Você só consegue armazenar um Anime, ou seja, sempre que salvar um novo, o anterior será sobrescrito");
        System.out.println("O que você deseja fazer:");
        System.out.println("1 - Salvar");
        System.out.println("2 - Visualizar");
        System.out.println("3 - Excluir");
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
                Config.getInstance().setNextStateMachine(
                    EnumStateMachine.INPUT_NAME.getSateMachine()
                );
                break;
                
            case 2:
                Config.getInstance().setNextStateMachine(
                    EnumStateMachine.VIEW.getSateMachine()
                );
                break;
                
            case 3:
                Config.getInstance().setNextStateMachine(
                    EnumStateMachine.CONFIRM_DELETE.getSateMachine()
                );
                break;
        }
        
        return exit;
    }
}
