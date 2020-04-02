package com.CSCE247;

import java.util.ArrayList;
import java.util.Scanner;

public class UsersInterface {
    private Scanner scanner;

    public UsersInterface() {
        scanner = new Scanner(System.in);
    }

    public void play() {
        Account account = Account.getInstance();
        Moviedatabase moviedatabase = Moviedatabase.getInstance();
        Playdatabase playdatabase = Playdatabase.getInstance();
        Theaterdatabase theaterdatabase = Theaterdatabase.getInstance();
        System.out.println("***** Your current Users *******");
        displayAccount();
        System.out.println("***** Your current movies ******");
        displayMoviedatabase();
        System.out.println("***** Your current plays ******");
        displayPlaydatabase();
        System.out.println("***** Your current theaters ******");
        displayTheaterdatabase();

        //add user
        while(addUsers()) {
            String firstname = getField("First Name");
            String lastname = getField("Last Name");
            String creditcard = getField("Credit Card");

            account.addUsers(firstname, lastname, creditcard);
        }
        //add movies
        while(addMovietitles()){
            String moviename = getField("Movie name");
            String cost = getField("The Cost");

            moviedatabase.addMovietitles(moviename,cost);
        }
        //add plays
        while(addPlaytitles()){
            String playname = getField("Play name");
            String cost = getField("The Cost");

            playdatabase.addPlaytitles(playname,cost);
        }
        //add theaters
        while(addTheaternames()){
            String theatername = getField("Theater name");

            Theaterdatabase.addTheaternames(theatername);
        }

        System.out.println("***** Your updated list of Users *******");
        displayAccount();
        System.out.println("***** Your updated list of movies ******");
        displayMoviedatabase();
        System.out.println("***** Your updated list of plays ******");
        displayPlaydatabase();
        System.out.println("***** Your updated list of theaters*****");
        displayTheaterdatabase();
        System.out.println("\nHave a good day!");
    }

    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    private boolean addUsers() {
        System.out.print("Would you like to add a User? (Y or N): ");
        String input = scanner.nextLine();
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }
    private boolean addMovietitles(){
        System.out.print("Would you like to add a Movie? (Y or N): ");
        String input = scanner.nextLine();
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }
    private boolean addPlaytitles(){
        System.out.print("Would you like to add a Play? (Y or N): ");
        String input = scanner.nextLine();
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }
    private boolean addTheaternames(){
        System.out.print("Would you like to add a Theater? (Y or N): ");
        String input = scanner.nextLine();
        if(input.toLowerCase().trim().equals("y")) return true;
        return false;
    }


    public void displayAccount() {
        Account account = Account.getInstance();
        ArrayList<Users> friends = account.getAccount();

        for(Users user : friends) {
            System.out.println(user.getFirstname() + " " + user.getLastname() + ": " + user.getCreditcard());
        }
    }
    public void displayMoviedatabase() {
        Moviedatabase moviedatabase = Moviedatabase.getInstance();
        ArrayList<Movietitles> friends = Moviedatabase.getMoviedatabase();

        for(Movietitles movies : friends) {
            System.out.println(movies.getName() + " $" + movies.getCost());
        }
    }
    public void displayPlaydatabase() {
        Playdatabase playdatabase = Playdatabase.getInstance();
        ArrayList<Playtitles> friends = Playdatabase.getPlaydatabase();

        for(Playtitles playtitles : friends) {
            System.out.println(playtitles.getName() + " $" + playtitles.getCost());
        }
    }
    public void displayTheaterdatabase() {
        Theaterdatabase theaterdatabase = Theaterdatabase.getInstance();
        ArrayList<Theaternames> friends = Theaterdatabase.getTheaterdatabase();

        for(Theaternames theaternames : friends) {
            System.out.println(theaternames.getName());
        }
    }

    public static void main(String[] args) {
        UsersInterface pi = new UsersInterface();
        pi.play();
    }

}

