package com.CSCE247;

import java.util.ArrayList;

public class Theaterdatabase {
    private static Theaterdatabase theaterdatabase = null;
    private static ArrayList<Theaternames> theaterList = new ArrayList<Theaternames>();

    private Theaterdatabase() {
        theaterList = DataLoader.loadTheaterdatabase();
    }

    public static Theaterdatabase getInstance() {
        if(theaterdatabase == null) {
            theaterdatabase = new Theaterdatabase();
        }

        return theaterdatabase;
    }

    public static ArrayList<Theaternames> getTheaterdatabase() {
        return theaterList;
    }

    public void addTheaternames(String name) {
        theaterList.add(new Theaternames(name));
        DataWriter.saveTheaterdatabase();
    }
}
