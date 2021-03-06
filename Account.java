package com.CSCE247;
import java.util.ArrayList;

public class Account {
    private static Account account = null;
    private static ArrayList<Users> userList = new ArrayList<Users>();

    private Account() {
        userList = DataLoader.loadAccount();
    }

    public static Account getInstance() {
        if(account == null) {
            account = new Account();
        }

        return account;
    }

    public static ArrayList<Users> getAccount() {
        return userList;
    }

    public void addUsers(Users user) {
        userList.add(new Users(user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getCreditcard(), user.getEmployee()));
        DataWriter.saveAccount();
    }
    
}
