package com.nathanreis.maquinaestado_junit5.storage;

import com.nathanreis.maquinaestado_junit5.model.AnimeModel;

public class Storage {
    private static Storage instance;
    
    private AnimeModel anime;
    
    private Storage() {}
    
    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        
        return instance;
    }
    
    public void save(AnimeModel anime) {
        this.anime = anime;
    }
    
    public AnimeModel getAnime() {
        return this.anime;
    }
    
    public void delete() {
        this.anime = null;
    }
}
