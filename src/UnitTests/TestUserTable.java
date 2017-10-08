package UnitTests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import server.logic.model.Loan;
import server.logic.tables.FeeTable;
import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;

public class TestUserTable {
	

	Timestamp stamp = new Timestamp(System.currentTimeMillis());
	Date date = new Date(stamp.getDateTime());
	Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
	Date myDate = myCalendar.getTime();
	
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
		assertNotNull(UserTable.getInstance().getUserTable().size());
	}
	
	@Test
	public void testGetUserTableFail() {
		assertNotEquals(9, UserTable.getInstance().getUserTable().size());
	}
	
	@Test
	public void testDeletePass() {
		assertEquals("success" , UserTable.getInstance().delete(6));
	}
	
	@Test
	public void testDeleteFail() {
		assertNotEquals("Outstanding Fee Exists" , UserTable.getInstance().delete(4));
	}
	
	@Test
	public void testLookupPass() {
		assertEquals(0 , UserTable.getInstance().lookup("Rob@carleton.ca"));
	}
	
	@Test
	public void testLookupFail() {
		assertNotEquals(3 , UserTable.getInstance().lookup("Rob@carleton.ca"));
	}
	
	@Test
	public void testCheckUserPass() {
		assertEquals(0 , UserTable.getInstance().checkUser("Rob@carleton.ca", "Rob"));
	}
	
	@Test
	public void testCheckUserFail() {
		assertNotEquals(1 , UserTable.getInstance().checkUser("Rob@carleton.ca", "Rob"));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
