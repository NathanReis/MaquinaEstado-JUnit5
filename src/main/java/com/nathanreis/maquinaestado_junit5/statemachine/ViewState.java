package com.nathanreis.maquinaestado_junit5.statemachine;

import com.nathanreis.maquinaestado_junit5.config.Config;
import com.nathanreis.maquinaestado_junit5.model.AnimeModel;
import com.nathanreis.maquinaestado_junit5.storage.Storage;

public class ViewState implements IStateMachine {
    @Override
    public boolean execute() {
        System.out.println("");
        
        boolean exit = false;
        
        AnimeModel anime = Storage.getInstance().getAnime();
        
        if (anime == null) {
            System.out.println("Nenhum anime salvo :(");
        } else {
            System.out.println("Nome: " + anime.getName());
            System.out.println("Total de episódios: " + anime.getAmountTotalEpisodes());
            System.out.println("Total de temporadas: " + anime.getAmountSeasons());
        }
        
        Config.getInstance().setNextStateMachine(
            EnumStateMachine.WELCOME.getSateMachine()
        );
        
        return exit;
    }
}
