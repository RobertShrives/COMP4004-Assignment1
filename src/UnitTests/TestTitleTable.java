package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.tables.TitleTable;

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
		assertEquals(8, TitleTable.getInstance().getTitleTable().size());
	}
	
	@Test
	public void testGetTitleTablefail() {
		assertNotEquals(9, TitleTable.getInstance().getTitleTable().size());
	}
	
	//delete function

}
