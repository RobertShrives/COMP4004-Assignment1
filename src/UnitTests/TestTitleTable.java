package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.tables.TitleTable;

public class TestTitleTable {

	TitleTable titleTable1 = new TitleTable();
	
	@Test
	public void testCreateTitlePass() {
		assertEquals(true, titleTable1.createtitle("1111111111111", "Test Book"));
	}
	
	@Test
	public void testCreateTitleFail() {
		titleTable1.createtitle("1111111111111", "Test Book");
		assertEquals(false, titleTable1.createtitle("1111111111111", "Test Book"));
	}
	
	@Test
	public void testLookupStringPass() {
		titleTable1.createtitle("1111111111111", "Test Book");
		assertEquals(true, titleTable1.lookup("1111111111111"));
	}
	
	@Test
	public void testLookupStringFail() {
		assertEquals(false, titleTable1.lookup("1111111111111"));
	}

}
