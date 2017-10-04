package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.tables.UserTable;

public class TestUserTable {
	
	UserTable userTable1 = new UserTable();
	
	@Test
	public void testCreateUserPass() {
		assertEquals(true, userTable1.createuser("robshrives@gmail.com", "Pass"));
	}
	
	@Test
	public void testCreateUserFail() {
		userTable1.createuser("robshrives@gmail.com", "Pass");
		assertEquals(false, userTable1.createuser("robshrives@gmail.com", "Pass"));
	}
	
	@Test
	public void testLookupPass() {
		userTable1.createuser("robshrives@gmail.com", "Pass");
		assertEquals(true, userTable1.lookup(0));
	}
	
	@Test
	public void testLookupFail() {
		assertEquals(false, userTable1.lookup(0));
	}

}
