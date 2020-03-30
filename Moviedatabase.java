package com.CSCE247;

import java.util.ArrayList;

public class Moviedatabase {
    private static Moviedatabase moviedatabase = null;
    private static ArrayList<Movietitles> movieList = new ArrayList<Movietitles>();

    private Moviedatabase() {
        movieList = DataLoader.loadMoviedatabase();
    }

    public static Moviedatabase getInstance() {
        if(moviedatabase == null) {
            moviedatabase = new Moviedatabase();
        }

        return moviedatabase;
    }

    public static ArrayList<Movietitles> getMoviedatabase() {
        return movieList;
    }

    public void addMovietitles(String name, String cost) {
        movieList.add(new Movietitles(name, cost));
        DataWriter.saveMoviedatabase();
    }
}

