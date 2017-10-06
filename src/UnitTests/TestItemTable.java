package UnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import server.logic.tables.ItemTable;
import server.logic.tables.TitleTable;

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
		System.out.println(ItemTable.getInstance().getItemTable().size());
		assertEquals(5, ItemTable.getInstance().getItemTable().size());
	}
	
	@Test
	public void testGetItemTableFail() {
		assertNotEquals(10, ItemTable.getInstance().getItemTable().size());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	//Delete
	
	//Delete all

}
