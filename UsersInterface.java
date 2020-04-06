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
        Moviedatabase movieDatabase = Moviedatabase.getInstance();
        Playdatabase playDatabase = Playdatabase.getInstance();
        Theaterdatabase theaterDatabase = Theaterdatabase.getInstance();
        ArrayList<Users> friends = account.getAccount();
        ArrayList<Theaternames> theaters = theaterDatabase.getTheaterdatabase();
        ArrayList<Movietitles> movies = movieDatabase.getMoviedatabase();
        ArrayList<Playtitles> plays = playDatabase.getPlaydatabase();
        
        String logChoice;
        String existingAccount;
        String logUsername;
        String logPassword;
        Boolean isLogged;
        Users current = new Users(null,null,null,null,null,null);
        Theaternames cTheater = new Theaternames(null);
        Movietitles cMovie = new Movietitles(null,null);
        Playtitles cPlay = new Playtitles(null,null);
        String cSeat;
        
        System.out.println("Welcome to the show database!");
        logChoice = getField("Would you like to log in? (Y or N)");
        if (logChoice.equals("n")) {
        	System.out.println("Continuing as guest...");
        	isLogged = false;
        }
        else if(logChoice.equals("y")) {
        	existingAccount = getField("Do you have an existing account? (Y or N)");
        	if(existingAccount.equals("n")) {
        		System.out.println("Creating new account...");
        		String username = getField("Username");
            	String password = getField("Password");
                String firstname = getField("First Name");
                String lastname = getField("Last Name");
                String creditcard = getField("Credit Card");
                Boolean employee = getBooleanField("Employee? (Y or N)");

                current = new Users(username, password, firstname, lastname, creditcard, employee);
                account.addUsers(current);
        	}
        	else if(existingAccount.equals("y")) {
        		logUsername = getField("Please enter your Username");
        		logPassword = getField("Please enter your Password");
        		for(Users user: friends) {
        			if(user.getUsername().equals(logUsername) && user.getPassword().equals(logPassword)) {
        				current = user;
        				System.out.println("Login successful!");
        			}
        		}
        	}
        	else {
        		System.out.println("*ERROR*");
        	}
        	if(current.getUsername() == null) {
        		System.out.println("Account not found. Continuing as guest...");
            	isLogged = false;
        	}
        	else {
        		System.out.println("Welcome " +current.getFirstname() +"!");
        		isLogged = true;
        	}
        }
        else {
        	System.out.println("*ERROR*");
        }
        
        int switch1;
        int switch2;
        int switch3;
        
        System.out.println("Enter 1 to purchase a ticket or 2 to add a show (employees only).");
        switch1 = Integer.parseInt(scanner.nextLine());
        switch(switch1) {
        case 1:
        	System.out.println("List of available theaters: ");
        	displayTheaterdatabase();
        	System.out.println("Enter the name of the theater you would like to visit");
        	String cTheaterName = scanner.nextLine();
        	for(Theaternames theater: theaters)
    			if(theater.getName().equals(cTheaterName)) 
    				cTheater = theater;
        	if(cTheater.getName() == null)
        		System.out.println("Theater not found. System shutting down...");
        	else {
        		System.out.println("Enter 1 to see a movie or 2 to see a play.");
                switch2 = Integer.parseInt(scanner.nextLine());
                switch(switch2) {
                case 1:
                	System.out.println("List of available movies: ");
                	displayMoviedatabase();
                	System.out.println ("Enter the name of the movie you would like to see");
                	String cMovieName = scanner.nextLine();
                	for(Movietitles movie: movies) 
            			if(movie.getName().equals(cMovieName)) 
            				cMovie = movie;
                	if(cTheater.getName() == null)
                		System.out.println("Movie not found. System shutting down...");
                	else {
                		System.out.println("Pick a seat: ");
                		cTheater.printSeats();
                		cSeat = scanner.nextLine();
                		System.out.println("Purchase succesful! Printing ticket..");
                		break;
                	}
                	break;
                	
                case 2:
                	System.out.println("List of available plays: ");
                	displayPlaydatabase();
                	System.out.println("Enter the name of the play you would like to see");
                	String cPlayName = scanner.nextLine();
                	for(Playtitles play: plays) 
            			if(play.getName().equals(cPlayName)) 
            				cPlay = play;
                	if(cTheater.getName() == null)
                		System.out.println("Play not found. System shutting down...");
                	else {
                		System.out.println("Pick a seat: ");
                		cTheater.printSeats();
                		cSeat = scanner.nextLine();
                		System.out.println("Purchase succesful! Printing ticket..");
                		break;
                	}
                	break;
                }
        	}
        	break;
        	
        case 2:
        	cTheaterName = getField("Enter a new or existing theater for the show");
        	for(Theaternames theater: theaters)
    			if(theater.getName().equals(cTheaterName)) 
    				cTheater = theater;
        	if(cTheater.getName() == null) {
        		System.out.println("Theater not found. Adding theater...");
        		theaterDatabase.addTheaternames(cTheaterName);
        		cTheater = new Theaternames(cTheaterName);
        	}
        	else {
        		System.out.println("Theater found!");
        	}
        	System.out.println("Enter 1 to add a movie or 2 to add a play.");
        	switch3 = Integer.parseInt(scanner.nextLine());
        	switch(switch3) {
            case 1:
            	System.out.println("Adding new movie...");
        		String mname = getField("Name");
            	String mprice = getField("Price");

                movieDatabase.addMovietitles(mname, mprice);
                System.out.println(mname +" added!");
            	break;
            	
            case 2:
            	System.out.println("Adding new play...");
        		String pname = getField("Name");
            	String pprice = getField("Price");

                movieDatabase.addMovietitles(pname, pprice);
                System.out.println(pname +" added!");
            	break;
            }
        	break;
        }
        
    }

    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        String answer = scanner.nextLine();
        return answer;
    }
    
    private Boolean getBooleanField(String prompt) {
    	System.out.print(prompt + ": ");
    	String choice = scanner.nextLine();
    	if(choice.equals("y"))
    		return true;
    	else if(choice.equals("n"))
    		return false;
    	else
    		return null;
    }

    private Movietitles addMovietitles(){
    	System.out.println("Adding new movie...");
		String name = getField("Name");
    	String cost = getField("Cost");

        Movietitles newMovie = new Movietitles(name, cost);
        return newMovie;
    }

    private Playtitles addPlaytitles(){
    	System.out.println("Adding new Play...");
		String name = getField("Name");
    	String cost = getField("Cost");

        Playtitles newPlay = new Playtitles(name, cost);
        return newPlay;
    }
    
    private Theaternames addTheaternames(){
    	System.out.println("Adding new theater...");
		String name = getField("Name");

        Theaternames newTheater = new Theaternames(name);
        return newTheater;
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

