package UnitTests;

import static org.junit.Assert.*;

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

}
