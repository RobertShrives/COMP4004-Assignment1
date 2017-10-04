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
	
	@Test
	public void testGetUserTablePass() {
		userTable1.createuser("test1@gmail.com", "Pass");
		userTable1.createuser("test2@hotmail.com", "Pass");
		assertEquals(2, userTable1.getUserTable().size());
	}
	
	@Test
	public void testGetUserTableFail() {
		userTable1.createuser("test1@gmail.com", "Pass");
		userTable1.createuser("test2@hotmail.com", "Pass");
		assertNotEquals(1, userTable1.getUserTable().size());
	}
	
	

}
