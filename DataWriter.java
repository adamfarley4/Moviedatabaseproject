package com.CSCE247;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    //saving account
    public static void saveAccount() {
        ArrayList<Users> friends = Account.getAccount();
        JSONArray jsonFriends = new JSONArray();

        //creating all the json objects
        for (int i = 0; i < friends.size(); i++) {
            jsonFriends.add(getUsersJSON(friends.get(i)));
        }

        //Write JSON file
        try (FileWriter file = new FileWriter(UserFileName)) {

            file.write(jsonFriends.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUsersJSON(Users users) {
        JSONObject UsersDetails = new JSONObject();
        UsersDetails.put(UserUsername, users.getUsername());
        UsersDetails.put(UserPassword, users.getPassword());
        UsersDetails.put(UserFirstName, users.getFirstname());
        UsersDetails.put(UserLastName, users.getLastname());
        UsersDetails.put(UserccNum, users.getCreditcard());
        UsersDetails.put(UserEmployee, users.getEmployee());

        return UsersDetails;
    }

    //saving movie
    public static void saveMoviedatabase() {
        ArrayList<Movietitles> friends = Moviedatabase.getMoviedatabase();
        JSONArray jsonFriends = new JSONArray();

        //creating all the json objects
        for (int i = 0; i < friends.size(); i++) {
            jsonFriends.add(getMovietitlesJSON(friends.get(i)));
        }

        //Write JSON file
        try (FileWriter file = new FileWriter(MovieFileName)) {

            file.write(jsonFriends.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getMovietitlesJSON(Movietitles movietitles) {
        JSONObject MovietitlesDetails = new JSONObject();
        MovietitlesDetails.put(MovieName, movietitles.getName());
        MovietitlesDetails.put(Cost, movietitles.getCost());
        MovietitlesDetails.put(Showtimes, movietitles.getShowtimes());
        MovietitlesDetails.put(Ratings, movietitles.getRatings());
        MovietitlesDetails.put(Reviews, movietitles.getReviews());

        return MovietitlesDetails;
    }
    //saving plays
    public static void savePlaydatabase() {
        ArrayList<Playtitles> friends = Playdatabase.getPlaydatabase();
        JSONArray jsonFriends = new JSONArray();

        //creating all the json objects
        for (int i = 0; i < friends.size(); i++) {
            jsonFriends.add(getPlaytitlesJSON(friends.get(i)));
        }

        //Write JSON file
        try (FileWriter file = new FileWriter(PlayFileName)) {

            file.write(jsonFriends.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getPlaytitlesJSON(Playtitles playtitles) {
        JSONObject PlaytitlesDetails = new JSONObject();
        PlaytitlesDetails.put(PlayName, playtitles.getName());
        PlaytitlesDetails.put(Cost, playtitles.getCost());
        PlaytitlesDetails.put(Showtimes, playtitles.getShowtimes());
        PlaytitlesDetails.put(Ratings, playtitles.getRatings());
        PlaytitlesDetails.put(Reviews, playtitles.getReviews());

        return PlaytitlesDetails;
    }
    //saving theaters
    public static void saveTheaterdatabase() {
        ArrayList<Theaternames> friends = Theaterdatabase.getTheaterdatabase();
        JSONArray jsonFriends = new JSONArray();

        //creating all the json objects
        for (int i = 0; i < friends.size(); i++) {
            jsonFriends.add(getTheatertitlesJSON(friends.get(i)));
        }

        //Write JSON file
        try (FileWriter file = new FileWriter(TheaterFileName)) {

            file.write(jsonFriends.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static JSONObject getTheatertitlesJSON(Theaternames theaternames) {
        JSONObject TheatertitlesDetails = new JSONObject();
        TheatertitlesDetails.put(TheaterName, theaternames.getName());

        return TheatertitlesDetails;
    }
}