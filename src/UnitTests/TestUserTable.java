package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.tables.UserTable;

public class TestUserTable {
	
	UserTable ut1 = new UserTable();
	
	@Test
	public void testCreateUserPass() {
		assertEquals(true, ut1.createuser("robshrives@gmail.com", "Pass"));
	}
	
	@Test
	public void testCreateUserFail() {
		ut1.createuser("robshrives@gmail.com", "Pass");
		assertEquals(false, ut1.createuser("robshrives@gmail.com", "Pass"));
	}

}
