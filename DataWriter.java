package com.CSCE247;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{

    public static void saveAccount() {
        Account account = Account.getInstance();
        ArrayList<Users> friends = Account.getAccount();
        JSONArray jsonFriends = new JSONArray();

        //creating all the json objects
        for(int i=0; i < friends.size(); i++) {
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
        UsersDetails.put(UserFirstName, users.getFirstname());
        UsersDetails.put(UserLastName, users.getLastname());
        UsersDetails.put(UserccNum, users.getCreditcard());

        return UsersDetails;
    }
}
