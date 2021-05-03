package com.nathanreis.maquinaestado_junit5.config;

import com.nathanreis.maquinaestado_junit5.statemachine.IStateMachine;

public class Config {
    private static Config instance;
    
    private String genre = "";
    private IStateMachine nextStateMachine;
    
    private Config() {}
    
    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        
        return instance;
    }
    
    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public IStateMachine getNextStateMachine() {
        return this.nextStateMachine;
    }
    
    public void setNextStateMachine(IStateMachine nextStateMachine) {
        this.nextStateMachine = nextStateMachine;
    }
}
