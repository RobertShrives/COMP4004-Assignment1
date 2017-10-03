package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.model.Item;

public class TestItem {

	Item item1 = new Item(0, "1111111111111", "1");
	Item item2;

	@Test
	public void testItemCosntructorPass() {
		assertNotNull(item1);
	}
	
	@Test
	public void testItemCosntructorFail() {
		assertNull(item2);
	}
	
	@Test
	public void testGetItemidPass() {
		assertEquals(0, item1.getItemid());
	}
	
	@Test
	public void testGetItemidFail() {
		assertNotEquals(30, item1.getItemid());
	}
	
	@Test
	public void testSetItemidPass() {
		item1.setItemid(30);
		assertEquals(30, item1.getItemid());
	}
	
	@Test
	public void testSetItemidFail() {
		item1.setItemid(10);
		assertNotEquals(30, item1.getItemid());
	}

}
