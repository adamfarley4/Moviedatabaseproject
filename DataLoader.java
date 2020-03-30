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
                String firstname = (String)UsersJSON.get(UserFirstName);
                String lastname = (String)UsersJSON.get(UserLastName);
                String creditcard = (String)UsersJSON.get(UserccNum);

                Account.add(new Users(firstname, lastname, creditcard));
            }

            return Account;

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
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
                    Moviedatabase.add(new Movietitles(name, cost));
                }

                return Moviedatabase;

            }

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
