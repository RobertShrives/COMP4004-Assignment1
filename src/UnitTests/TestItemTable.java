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
		assertEquals(5, ItemTable.getInstance().getItemTable().size());
	}
	
	@Test
	public void testGetItemTableFail() {
		assertNotEquals(10, ItemTable.getInstance().getItemTable().size());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testDeleteItemSuccessPass() {
		TitleTable.getInstance().createtitle("7894563214563","item delete test");
		ItemTable.getInstance().createitem("7894563214563");
		assertEquals("success", ItemTable.getInstance().delete("7894563214563", "1"));
	}
	
	@Test
	public void testDeleteItemSuccessFail() {
		System.out.println(ItemTable.getInstance().getItemTable());
		assertNotEquals("success", ItemTable.getInstance().delete("7894563214563", "0"));
	}
	
	//all test
	@Test
	public void testDeleteItemActiveLoanExistsPass() {
		System.out.println(TitleTable.getInstance().createtitle("7894563214564","item delete test"));
		System.out.println(ItemTable.getInstance().createitem("7894563214564"));
		System.out.println(UserTable.getInstance().createuser("Joe@email.com", "string2"));
		System.out.println(LoanTable.getInstance().createloan(4, "7894563214564", "1", new Date()));
		System.out.println(ItemTable.getInstance().getItemTable());
		System.out.println(UserTable.getInstance().getUserTable());
		assertEquals("Active Loan Exists", ItemTable.getInstance().delete("7894563214564", "1"));
		System.out.println(ItemTable.getInstance().getItemTable());
	}
	
	@Test
	public void testDeleteItemActiveLoanExistsFail() {
		System.out.println(TitleTable.getInstance().createtitle("7894563214564","item delete test"));
		System.out.println(ItemTable.getInstance().createitem("7894563214564"));
		System.out.println(UserTable.getInstance().createuser("Joe@email.com", "string2"));
		System.out.println(LoanTable.getInstance().createloan(4, "7894563214564", "1", new Date()));
		System.out.println(ItemTable.getInstance().getItemTable());
		System.out.println(UserTable.getInstance().getUserTable());
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
	
	//Delete all

}
