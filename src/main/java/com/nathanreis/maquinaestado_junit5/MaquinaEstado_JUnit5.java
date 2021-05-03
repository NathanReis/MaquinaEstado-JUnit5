package com.nathanreis.maquinaestado_junit5;

import com.nathanreis.maquinaestado_junit5.config.Config;
import com.nathanreis.maquinaestado_junit5.statemachine.EnumStateMachine;

public class MaquinaEstado_JUnit5 {
    public static void main(String[] args) {
        boolean exit = false;
        
        Config.getInstance().setNextStateMachine(
            EnumStateMachine.ASK_GENRE.getSateMachine()
        );
        
        while (!exit) {
            exit = Config.getInstance().getNextStateMachine().execute();
        }
    }
}
