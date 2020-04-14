package com.CSCE247;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DataWriterTest {

	@Test
	void testSaveAccount() {
		Account account = Account.getInstance();
		Users bill = new Users("Bill", "Nye", "The", "Science", "Guy", true);
		account.addUsers(bill);
		assertTrue(DataLoader.loadAccount().contains(new Users("Bill", "Nye", "The", "Science", "Guy", true)));
	}
	
	@Test
	void testSaveMoviedatabase() {
		Moviedatabase md = Moviedatabase.getInstance();
		md.addMovietitles("Bill", "Nye", "The", "Science", "Guy");
		assertTrue(DataLoader.loadMoviedatabase().contains(new Movietitles("Bill", "Nye", "The", "Science", "Guy")));
	}
	
	@Test
	void testSavePlaydatabase() {
		Playdatabase pd = Playdatabase.getInstance();
		pd.addPlaytitles("Bill", "Nye", "The", "Science", "Guy");
		assertTrue(DataLoader.loadPlaydatabase().contains(new Playtitles("Bill", "Nye", "The", "Science", "Guy")));
	}
	
	@Test
	void testSaveTheaterdatabase() {
		Theaterdatabase td = Theaterdatabase.getInstance();
		td.addTheaternames("Bill");
		assertTrue(DataLoader.loadTheaterdatabase().contains(new Theaternames("Bill")));
	}

}
