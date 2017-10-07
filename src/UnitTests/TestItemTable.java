package UnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;

public class TestItemTable {

	
	@Test
	public void testCreateItemTablePass() {
		TitleTable.getInstance().createtitle("9781442","test");
		assertEquals(true, ItemTable.getInstance().createitem("9781442"));
	}
	
	@Test
	public void testCreateItemTableFail() {
		assertEquals(false, ItemTable.getInstance().createitem("11111111111111"));
	}
	
	@Test
	public void testLookupStringPass() {
		TitleTable.getInstance().createtitle("9781443","test");
		ItemTable.getInstance().createitem("9781443");
		assertEquals(true, ItemTable.getInstance().lookup("9781443","1"));
	}
	
	@Test
	public void testLookupStringFail(){
		TitleTable.getInstance().createtitle("9781444","test");
		ItemTable.getInstance().createitem("9781444");
		assertEquals(false, ItemTable.getInstance().lookup("9781444","2"));
		
	}
	
	@Test
	public void testGetItemTablePass() {
		TitleTable.getInstance().createtitle("9781442","test");
		ItemTable.getInstance().createitem("9781442");
		//assertEquals(5, ItemTable.getInstance().getItemTable().size());
	}
	
	@Test
	public void testGetItemTableFail() {
		assertNotEquals(10, ItemTable.getInstance().getItemTable().size());
	}
	
	
	@Test
	public void testDeleteItemSuccessPass() {
		TitleTable.getInstance().createtitle("7894563214563","item delete test");
		ItemTable.getInstance().createitem("7894563214563");
		assertEquals("success", ItemTable.getInstance().delete("7894563214563", "1"));
	}
	
	@Test
	public void testDeleteItemSuccessFail() {
		assertNotEquals("success", ItemTable.getInstance().delete("7894563214563", "0"));
	}
	
	//all test
	@Test
	public void testDeleteItemActiveLoanExistsPass() {
		TitleTable.getInstance().createtitle("7894563214564","item delete test");
		ItemTable.getInstance().createitem("7894563214564");
		UserTable.getInstance().createuser("Joe@email.com", "string2");
		LoanTable.getInstance().createloan(4, "7894563214564", "1", new Date());
		assertEquals("Active Loan Exists", ItemTable.getInstance().delete("7894563214564", "1"));
	}
	
	@Test
	public void testDeleteItemActiveLoanExistsFail() {
		TitleTable.getInstance().createtitle("7894563214564","item delete test");
		ItemTable.getInstance().createitem("7894563214564");
		UserTable.getInstance().createuser("Joe@email.com", "string2");
		LoanTable.getInstance().createloan(4, "7894563214564", "1", new Date());
		
		assertNotEquals("success", ItemTable.getInstance().delete("7894563214564", "1"));
	}
	
	@Test
	public void testDeleteItemDoesntExistPass() {
		assertEquals("The Item Does Not Exist", ItemTable.getInstance().delete("7894563214888", "1"));
	}
	
	@Test
	public void testDeleteItemDoesntExistFail() {
		assertNotEquals("success", ItemTable.getInstance().delete("7894563214888", "1"));
	}
	
	@Test
	public void testDeleteAll() {
		TitleTable.getInstance().createtitle("7894563288888","item deleteAll test");
		ItemTable.getInstance().createitem("7894563288888");
		ItemTable.getInstance().createitem("7894563288888");
		ItemTable.getInstance().createitem("7894563288888");
		ItemTable.getInstance().createitem("7894563288888");
		ItemTable.getInstance().deleteAll("7894563288888");
		ItemTable.getInstance().lookup("9781442668584", "1");
		assertEquals(false, ItemTable.getInstance().lookup("7894563288888", "1"));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
