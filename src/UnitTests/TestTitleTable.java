package UnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;

public class TestTitleTable {

	
	@Test
	public void testCreateTitlePass() {
		assertEquals(true, TitleTable.getInstance().createtitle("1111111111111", "Test Book1"));
	}
	
	@Test
	public void testCreateTitleFail() {
		TitleTable.getInstance().createtitle("2222222222222", "Test Book2");
		assertEquals(false, TitleTable.getInstance().createtitle("2222222222222", "Test Book3"));
	}
	
	@Test
	public void testLookupStringPass() {
		assertEquals(true, TitleTable.getInstance().lookup("9781442668584"));
	}
	
	@Test
	public void testLookupStringFail() {
		assertEquals(false, TitleTable.getInstance().lookup("3333333333333"));
	}
	
	@Test
	public void testGetTitleTablePass() {
		TitleTable.getInstance().createtitle("4444444444444", "Test Book 4");
		assertNotNull(TitleTable.getInstance().getTitleTable().size());
	}
	
	@Test
	public void testGetTitleTablefail() {
		assertNotEquals(8, TitleTable.getInstance().getTitleTable().size());
	}
	
	@Test
	public void testDeleteSuccessPass() {
		TitleTable.getInstance().createtitle("7894563214563", "Test");
		assertEquals("success", TitleTable.getInstance().delete("7894563214563"));
	}
	
	@Test
	public void testDeleteSuccessFail() {
		TitleTable.getInstance().createtitle("7894563214563", "Test");
		assertNotEquals("Active Loan Exists", TitleTable.getInstance().delete("7894563214563"));
	}
	

	@Test
	public void testDeleteLoanExistsPass() {
		UserTable.getInstance().createuser("Joe@joe", "leto");
		TitleTable.getInstance().createtitle("7894563213563", "Test");
		ItemTable.getInstance().createitem("7894563213563");
		LoanTable.getInstance().createloan(2, "7894563213563", "1", new Date());
		assertEquals("Active Loan Exists", TitleTable.getInstance().delete("7894563213563"));
	}
	
	@Test
	public void testDeleteLoanExistsFail() {
		UserTable.getInstance().createuser("Joe@joe", "leto");
		TitleTable.getInstance().createtitle("7894563213563", "Test");
		ItemTable.getInstance().createitem("7894563213563");
		LoanTable.getInstance().createloan(5, "7894563213563", "1", new Date());
		assertNotEquals("The Title Does Not Exist", TitleTable.getInstance().delete("7894563213563"));
	}
	
	@Test
	public void testDeleteTitleDoesntExistsPass() {
		assertEquals("The Title Does Not Exist", TitleTable.getInstance().delete("111111111"));
	}
	
	@Test
	public void testDeleteTitleDoesntExistsFail() {
		assertNotEquals("success", TitleTable.getInstance().delete("111111111"));
	}
	
	@Test
	public void testSearchISBNPass() {
		assertEquals("Harry Potter", TitleTable.getInstance().searchISBN("9781442668584"));
	}
	
	@Test
	public void testSearchISBNFail() {
		assertNotEquals("Harry Pothead", TitleTable.getInstance().searchISBN("9781442668584"));
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	//delete function
	

}
