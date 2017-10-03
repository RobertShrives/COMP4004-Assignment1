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
	
	@Test
	public void testgetISBNPass() {
		assertEquals("1111111111111", item1.getISBN());
	}
	
	@Test
	public void testgetISBNFail() {
		assertNotEquals("3333333333333", item1.getItemid());
	}
	
	@Test
	public void testSetISBNPass() {
		item1.setISBN("3333333333333");
		assertEquals("3333333333333", item1.getISBN());
	}
	
	@Test
	public void testSetISBNFail() {
		item1.setISBN("2222222222222");
		assertNotEquals("3333333333333", item1.getItemid());
	}
	
	@Test
	public void testGetCopynumberPass() {
		assertEquals("1", item1.getCopynumber());
	}
	
	@Test
	public void testGetCopynumberFail() {
		assertNotEquals("2", item1.getCopynumber());
	}
	
	@Test
	public void testSetCopynumberPass() {
		item1.setCopynumber("5");
		assertEquals("5", item1.getCopynumber());
	}
	
	@Test
	public void testSetCopynumberFail() {
		item1.setCopynumber("3");
		assertNotEquals("5", item1.getCopynumber());
	}

}
