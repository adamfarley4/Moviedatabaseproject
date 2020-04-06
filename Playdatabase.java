package com.CSCE247;

import java.util.ArrayList;

public class Playdatabase {
    private static Playdatabase playdatabase = null;
    private static ArrayList<Playtitles> playList = new ArrayList<Playtitles>();

    private Playdatabase() {
        playList = DataLoader.loadPlaydatabase();
    }

    public static Playdatabase getInstance() {
        if(playdatabase == null) {
            playdatabase = new Playdatabase();
        }

        return playdatabase;
    }

    public static ArrayList<Playtitles> getPlaydatabase() {
        return playList;
    }   

    public void addPlaytitles(String name, String cost, String showtimes, String ratings, String reviews) {
        playList.add(new Playtitles(name, cost, showtimes, ratings, reviews));
        DataWriter.savePlaydatabase();
    }
}
