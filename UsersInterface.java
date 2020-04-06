package com.CSCE247;

import java.util.*;
import java.util.Scanner;
import java.io.*;

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
        Boolean isLogged = null;
        Users current = new Users(null,null,null,null,null,null);
        Theaternames cTheater = new Theaternames(null);
        Movietitles cMovie = new Movietitles(null,null,null,null,null);
        Playtitles cPlay = new Playtitles(null,null,null,null,null);
        String cSeat;
        String cRating;
        String cReview;
        
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
        		System.exit(0);
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
        	System.exit(0);
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
        	if(cTheater.getName() == null) {
        		System.out.println("Theater not found. System shutting down...");
        		System.exit(0);
        	}
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
                	if(cMovie.getName() == null) {
                		System.out.println("Movie not found. System shutting down...");
                		System.exit(0);
                	}
                	else {
                		System.out.println("Pick a seat: ");
                		cTheater.printSeats();
                		cSeat = scanner.nextLine();
                		movieTicketPrinter(current, isLogged, cMovie, cSeat, cTheater);
                		System.out.println("Purchase succesful! Printing ticket..");
                		String rChoice = getField("Would you like to leave a review? (Y or N)");
                		if (rChoice.equals("n")) {
                        	System.out.println("Thank you for your patronage!");
                        }
                        else if(rChoice.equals("y")) {
                        	cRating = getField("Please rate the movie 0-5 stars (example: ***)") +", ";
                        	cReview = getField("Please leave a comment about the movie") +", ";
                        	addMovieRating(cMovie, cRating, cReview);
                        }
                        else
                        	System.out.println("Invalid input! System shutting down...");
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
                	if(cPlay.getName() == null) {
                		System.out.println("Play not found. System shutting down...");
                		System.exit(0);
                	}
                	else {
                		System.out.println("Pick a seat: ");
                		cTheater.printSeats();
                		cSeat = scanner.nextLine();
                		playTicketPrinter(current, isLogged, cPlay, cSeat, cTheater);
                		System.out.println("Purchase succesful! Printing ticket..");
                		String rChoice = getField("Would you like to leave a review? (Y or N)");
                		if (rChoice.equals("n")) {
                        	System.out.println("Thank you for your patronage!");
                        }
                        else if(rChoice.equals("y")) {
                        	cRating = getField("Please rate the play 0-5 stars (example: ***)") +", ";
                        	cReview = getField("Please leave a comment about the play") +", ";
                        	addPlayRating(cPlay, cRating, cReview);
                        }
                        else
                        	System.out.println("Invalid input! System shutting down...");
                		break;
                	}
                	break;
                }
        	}
        	break;
        	
        case 2:
        	if(current.getEmployee() == false) {
        		System.out.println("User is not an employee. System shutting down...");
        		System.exit(0);
        	}
        	else
        		System.out.println("Employee access granted.");
        	
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
            	String mtimes = getField("Showtimes (seperate each showtime by ,)");

                movieDatabase.addMovietitles(mname, mprice, mtimes, " ", " ");
                System.out.println(mname +" added!");
            	break;
            	
            case 2:
            	System.out.println("Adding new play...");
        		String pname = getField("Name");
            	String pprice = getField("Price");
            	String ptimes = getField("Showtimes (seperate each show time by ,)");

                playDatabase.addPlaytitles(pname, pprice, ptimes, " ", " ");
                System.out.println(pname +" added!");
            	break;
            }
        	break;
        }
        System.exit(0);
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
    
    public void addPlayRating(Playtitles play, String rating, String review) {
    	String temp1 = play.getRatings();
    	String temp2 = play.getReviews();
    	play.setRatings(temp1 += rating);
    	play.setReviews(temp2 += review);
    	System.out.println("Rating and review set successfully!");
    	DataWriter.savePlaydatabase();
    }
    
    public void addMovieRating(Movietitles movie, String rating, String review) {
    	String temp1 = movie.getRatings();
    	String temp2 = movie.getReviews();
    	movie.setRatings(temp1 += rating);
    	movie.setReviews(temp2 += review);
    	System.out.println("Rating and review set successfully!");
    	DataWriter.saveMoviedatabase();
    }
    
    public void movieTicketPrinter(Users user, Boolean log, Movietitles movie, String seat, Theaternames theater) {
    	String ccNum;
    	String name;
    	String title = movie.getName();
    	String theaterName = theater.getName();
    	
    	if(log == true) {
    		name = user.getFirstname() +" " +user.getLastname();
    		ccNum = user.getCreditcard();
    	}
    	else {
    		name = "guest";
    		System.out.println("Enter a creditcard number for the purchase: ");
    		ccNum = scanner.nextLine();
    	}
    	
    	try (FileWriter file = new FileWriter("src/com/CSCE247/" +title +".txt")) {

            file.write("****************************************************************\n"
            		+ "																	\n"
            		+ "																   	\n"
            		+ "		Name: "+name+"		Creditcard #: " +ccNum +"\n"
            		+ "																   	\n"
            		+ "		Movie: "+title+"		Theater: "+theaterName+"\n"
            		+ "																   	\n"
            		+ "		Seat: "+seat+"												\n"
            		+ "																  	\n"
            		+ "																	\n"
            		+ "																   	\n"
            		+ " 					|  || |||  | ||||  ||						\n"
            		+ "					|  || |||  | ||||  ||		   					\n"
            		+ " 					|  || |||  | ||||  ||						\n"
            		+ "					|  || |||  | ||||  ||		   					\n"
            		+ " 																\n"
            		+ "*****************************************************************");
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    public void playTicketPrinter(Users user, Boolean log, Playtitles play, String seat, Theaternames theater) {
    	String name;
    	String ccNum = user.getCreditcard();
    	String title = play.getName();
    	String theaterName = theater.getName();
    	
    	if(log == true) {
    		name = user.getFirstname() +" " +user.getLastname();
    		ccNum = user.getCreditcard();
    	}
    	else {
    		name = "guest";
    		System.out.println("Enter a creditcard number for the purchase: ");
    		ccNum = scanner.nextLine();
    	}
    	
    	try (FileWriter file = new FileWriter("src/com/CSCE247/" +title +".txt")) {

            file.write("****************************************************************\n"
            		+ "																	\n"
            		+ "																   	\n"
            		+ "		Name: "+name+"		Creditcard #: " +ccNum +"\n"
            		+ "																   	\n"
            		+ "		Play: "+title+"	Theater: "+theaterName+"\n"
            		+ "																   	\n"
            		+ "		Seat: "+seat+"												\n"
            		+ "																  	\n"
            		+ "																	\n"
            		+ "																   	\n"
            		+ " 					|  || |||  | ||||  ||						\n"
            		+ "					|  || |||  | ||||  ||		   					\n"
            		+ " 					|  || |||  | ||||  ||						\n"
            		+ "					|  || |||  | ||||  ||		   					\n"
            		+ " 																\n"
            		+ "*****************************************************************");
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

    public void displayMoviedatabase() {
        ArrayList<Movietitles> friends = Moviedatabase.getMoviedatabase();

        for(Movietitles movies : friends) {
            System.out.println(movies.getName() + " $" + movies.getCost() +" Showtimes: " +movies.getShowtimes());
        }
    }
    public void displayPlaydatabase() {
        ArrayList<Playtitles> friends = Playdatabase.getPlaydatabase();

        for(Playtitles playtitles : friends) {
            System.out.println(playtitles.getName() + " $" + playtitles.getCost() +" Showtimes: " +playtitles.getShowtimes());
        }
    }
    public void displayTheaterdatabase() {
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

