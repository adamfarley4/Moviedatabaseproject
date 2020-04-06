package com.CSCE247;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
public class DataLoader extends DataConstants{

    public static ArrayList<Users> loadAccount() {
        ArrayList<Users> Account = new ArrayList<Users>();

        try {
            FileReader reader = new FileReader(UserFileName);
            JSONParser parser = new JSONParser();
            JSONArray AccountJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < AccountJSON.size(); i++) {
                JSONObject UsersJSON = (JSONObject)AccountJSON.get(i);
                String username = (String)UsersJSON.get(UserUsername);
                String password = (String)UsersJSON.get(UserPassword);
                String firstname = (String)UsersJSON.get(UserFirstName);
                String lastname = (String)UsersJSON.get(UserLastName);
                String creditcard = (String)UsersJSON.get(UserccNum);
                Boolean employee = (Boolean)UsersJSON.get(UserEmployee);

                Account.add(new Users(username, password, firstname, lastname, creditcard, employee));
            }

            return Account;

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
        //load movies
        public static ArrayList<Movietitles> loadMoviedatabase() {
            ArrayList<Movietitles> Moviedatabase = new ArrayList<Movietitles>();

            try {
                FileReader reader = new FileReader(MovieFileName);
                JSONParser parser = new JSONParser();
                JSONArray AccountJSON = (JSONArray)new JSONParser().parse(reader);

                for(int i=0; i < AccountJSON.size(); i++) {
                    JSONObject UsersJSON = (JSONObject)AccountJSON.get(i);
                    String name = (String)UsersJSON.get(MovieName);
                    String cost = (String)UsersJSON.get(Cost);
                    String showtimes = (String)UsersJSON.get(Showtimes);
                    String ratings = (String)UsersJSON.get(Ratings);
                    String reviews = (String)UsersJSON.get(Reviews);
                    
                    Moviedatabase.add(new Movietitles(name, cost, showtimes, ratings, reviews));
                }

                return Moviedatabase;

            }

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    //load plays
    public static ArrayList<Playtitles> loadPlaydatabase() {
        ArrayList<Playtitles> Playdatabase = new ArrayList<Playtitles>();

        try {
            FileReader reader = new FileReader(PlayFileName);
            JSONParser parser = new JSONParser();
            JSONArray PlaydatabaseJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < PlaydatabaseJSON.size(); i++) {
                JSONObject UsersJSON = (JSONObject)PlaydatabaseJSON.get(i);
                String name = (String)UsersJSON.get(PlayName);
                String cost = (String)UsersJSON.get(Cost);
                String showtimes = (String)UsersJSON.get(Showtimes);
                String ratings = (String)UsersJSON.get(Ratings);
                String reviews = (String)UsersJSON.get(Reviews);
                Playdatabase.add(new Playtitles(name, cost, showtimes, ratings, reviews));
            }

            return Playdatabase;

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public static ArrayList<Theaternames> loadTheaterdatabase() {
        ArrayList<Theaternames> Theaterdatabase = new ArrayList<Theaternames>();

        try {
            FileReader reader = new FileReader(TheaterFileName);
            JSONParser parser = new JSONParser();
            JSONArray TheaterdatabaseJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < TheaterdatabaseJSON.size(); i++) {
                JSONObject UsersJSON = (JSONObject)TheaterdatabaseJSON.get(i);
                String name = (String)UsersJSON.get(TheaterName);
                Theaterdatabase.add(new Theaternames(name));
            }

            return Theaterdatabase;

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
