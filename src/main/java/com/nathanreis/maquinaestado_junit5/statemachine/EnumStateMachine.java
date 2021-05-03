package com.nathanreis.maquinaestado_junit5.statemachine;

public enum EnumStateMachine {
    ASK_GENRE(new AskGenreState()),
    WELCOME(new WelcomeState()),
    INPUT_NAME(new InputNameState()),
    INPUT_AMOUNT_TOTAL_EPISODES(new InputAmountTotalEpisodesState()),
    INPUT_AMOUNT_SEASONS(new InputAmountSeasonsState()),
    VIEW(new ViewState()),
    CONFIRM_DELETE(new ConfirmDeleteState());
    
    private final IStateMachine stateMachine;
    
    EnumStateMachine(IStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    
    public IStateMachine getSateMachine() {
        return this.stateMachine;
    }
}
