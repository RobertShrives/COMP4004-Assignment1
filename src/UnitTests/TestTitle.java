package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.model.Title;

public class TestTitle {
	Title t1 = new Title("1111111111111", "Test Book");
	Title t2;
	
	@Test
	public void testTitleConstructorPass() {
		assertNotNull(t1);
	}
	
	@Test
	public void testTitleConstructorFail() {
		assertNull(t2);
	}
	
	@Test
	public void testGetISBNPass() {
		assertEquals("1111111111111", t1.getISBN());
	}
	
	@Test
	public void testGetISBNFail() {
		assertNotEquals("2222222222222", t1.getISBN());
	}
}
