package com.nathanreis.maquinaestado_junit5.config;

public enum EnumGenre {
    MALE("Ojisan"),
    FEMALE("Obasan"),
    NONE("");
    
    private final String genre;
    
    EnumGenre(String genre) {
        this.genre = genre;
    }
    
    public String getGenre() {
        return this.genre;
    }
}
