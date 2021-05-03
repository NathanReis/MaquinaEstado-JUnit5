package com.nathanreis.maquinaestado_junit5.model;

public class AnimeModel {
    private String name;
    private int amountTotalEpisodes;
    private int amountSeasons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountTotalEpisodes() {
        return amountTotalEpisodes;
    }

    public void setAmountTotalEpisodes(int amountTotalEpisodes) {
        this.amountTotalEpisodes = amountTotalEpisodes;
    }

    public int getAmountSeasons() {
        return amountSeasons;
    }

    public void setAmountSeasons(int amountSeasons) {
        this.amountSeasons = amountSeasons;
    }
}
