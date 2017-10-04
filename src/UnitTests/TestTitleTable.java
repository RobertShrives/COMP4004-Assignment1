package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.tables.TitleTable;

public class TestTitleTable {

	TitleTable t1 = new TitleTable();
	
	@Test
	public void testCreateTitlePass() {
		assertEquals(true, t1.createtitle("1111111111111", "Test Book"));
	}
	
	@Test
	public void testCreateTitleFail() {
		t1.createtitle("1111111111111", "Test Book");
		assertEquals(false, t1.createtitle("1111111111111", "Test Book"));
	}

}
