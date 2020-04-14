import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertArrayEquals;


import java.util.*;
import java.io.*;

class DataReaderTest {

	@Test
	void testloadAccount() {
		ArrayList<Users> Account = new ArrayList<Users>();
		Account.add(new Users("Jack@1","123456","Jack","Smith","0094678","False"));
		ArrayList<Users> second = Account.getAccount();
		assertEquals("Jack@1",second.get(0).getUsername());
	}
	@Test
	void testloadMoviedatabase() {
		ArrayList<Users> Account = new ArrayList<Users>();
		Account.add(new Users("Frozon 2","12$","9:30","***","Very good"));
		ArrayList<Users> second = Account.getMoviedatabase();
		assertEquals("Frozon 2",second.get(0).getName());
	}
	@Test
	void testPlaydatabase() {
		ArrayList<Users> Account = new ArrayList<Users>();
		Account.add(new Users("Toy R us","21$","9:30","***","Very good"));
		ArrayList<Users> second = Account.getplaydatabase();
		assertEquals("Toy R us",second.get(0).getName());
	}
	@Test
	void testloadTheaterdatabase() {
		ArrayList<Users> Account = new ArrayList<Users>();
		Account.add(new Users("Regal"));
		ArrayList<Users> second = Account.getTheaterdatabase();
		assertEquals("Regal",second.get(0).getName());
	}
}
