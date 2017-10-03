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

}
