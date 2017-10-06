package UnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import server.logic.tables.UserTable;

public class TestUserTable {
	
	
	@Test
	public void testCreateUserPass() {
		assertEquals(true, UserTable.getInstance().createuser("newEmail@gmail.com", "Pass"));
	}
	
	@Test
	public void testCreateUserFail() {
		UserTable.getInstance().createuser("robshrives@gmail.com", "Pass");
		assertEquals(false,UserTable.getInstance().createuser("robshrives@gmail.com", "Pass"));
	}
	
	@Test
	public void testLookupIntPass() {
		assertEquals(true,UserTable.getInstance().lookup(2));
	}
	
	@Test
	public void testLookupIntFail() {
		assertEquals(false, UserTable.getInstance().lookup(20));
	}
	
	@Test
	public void testGetUserTablePass() {
		UserTable.getInstance().createuser("test2@hotmail.com", "Pass");
		assertEquals(8, UserTable.getInstance().getUserTable().size());
	}
	
	@Test
	public void testGetUserTableFail() {
		assertNotEquals(9, UserTable.getInstance().getUserTable().size());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
