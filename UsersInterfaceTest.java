package com.CSCE247;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;
import java.util.ArrayList;
import static org.junit.Assert.*;
import java.util.Scanner;
public class UsersInterfaceTest {
    Scanner s = new Scanner(System.in);
    @Test
    public void play() throws Exception {

        }
    //testing all adding features of play
    @Test
    public void addPlayReview() throws Exception {
        UsersInterface ui = new UsersInterface();
        Playdatabase playdatabase = Playdatabase.getInstance();
        ArrayList<Playtitles> plays =  playdatabase.getPlaydatabase();
        Playtitles play = plays.get(0);
        ui.addPlayRating(play, "***", "good show");
        String review = play.getReviews();
        assertEquals("good show", review);
    }
    @Test
    public void addPlayRating() throws Exception {
        UsersInterface ui = new UsersInterface();
        Playdatabase playdatabase = Playdatabase.getInstance();
        ArrayList<Playtitles> plays =  playdatabase.getPlaydatabase();
        Playtitles play = plays.get(0);
        ui.addPlayRating(play, "***", "good show");
        String rating = play.getRatings();
        assertEquals("***", rating);
    }
    @Test
    public void addPlayShowtime() throws Exception {
        UsersInterface ui = new UsersInterface();
        Playdatabase playdatabase = Playdatabase.getInstance();
        ArrayList<Playtitles> plays =  playdatabase.getPlaydatabase();
        Playtitles play = plays.get(0);
        String showtimes = "5:30";
        play.setShowtimes(showtimes);
        String showtimeplay = play.getShowtimes();
        assertEquals("5:30", showtimeplay);
    }
    @Test
    public void addPlayCost() throws Exception {
        UsersInterface ui = new UsersInterface();
        Playdatabase playdatabase = Playdatabase.getInstance();
        ArrayList<Playtitles> plays =  playdatabase.getPlaydatabase();
        Playtitles play = plays.get(0);
        String cost = "15";
        play.setCost(cost);
        String costofplay = play.getCost();
        assertEquals("15", costofplay);
    }

    //testing all adding features of Movie
    @Test
    public void addMovieRating() {
        UsersInterface ui = new UsersInterface();
        Moviedatabase moviedatabase = Moviedatabase.getInstance();
        ArrayList<Movietitles> movies =  moviedatabase.getMoviedatabase();
        Movietitles movie = movies.get(0);
        ui.addMovieRating(movie, "****", "good show");
        String rating = movie.getRatings();
        assertEquals("****", rating);
    }
    @Test
    public void addMovieCost() {
        UsersInterface ui = new UsersInterface();
        Moviedatabase moviedatabase = Moviedatabase.getInstance();
        ArrayList<Movietitles> movies =  moviedatabase.getMoviedatabase();
        Movietitles movie = movies.get(0);
        String cost = "15";
        movie.setCost(cost);
        String costofmovie = movie.getCost();
        assertEquals("15", costofmovie);
    }
    @Test
    public void addMovieReview() {
        UsersInterface ui = new UsersInterface();
        Moviedatabase moviedatabase = Moviedatabase.getInstance();
        ArrayList<Movietitles> movies =  moviedatabase.getMoviedatabase();
        Movietitles movie = movies.get(0);
        ui.addMovieRating(movie, "****", "good show");
        String review = movie.getReviews();
        assertEquals("good show", review);
    }
    @Test
    public void addMovieShowtime() {
        UsersInterface ui = new UsersInterface();
        Moviedatabase moviedatabase = Moviedatabase.getInstance();
        ArrayList<Movietitles> movies =  moviedatabase.getMoviedatabase();
        Movietitles movie = movies.get(0);
        String showtimes = "5:30";
        movie.setShowtimes(showtimes);
        String showtimemovie = movie.getShowtimes();
        assertEquals("5:30", showtimemovie);
    }

    @Test
    public void movieTicketPrinter() {
        //not testable
    }

    @Test
    public void playTicketPrinter() {
        //not testable
    }

    @Test
    public void displayMoviedatabase() {
        //not testable

    }

    @Test
    public void displayPlaydatabase() {
        //not testable
    }

    @Test
    public void displayTheaterdatabase() {
        //not testable
    }

    @Test
    public void main() {
    }
}