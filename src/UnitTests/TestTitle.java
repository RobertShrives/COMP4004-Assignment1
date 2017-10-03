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
	
	@Test
	public void testSetISBNPass() {
		t1.setISBN("2222222222222");
		assertEquals("2222222222222", t1.getISBN());
	}
	
	@Test
	public void testSetISBNFail() {
		t1.setISBN("1111111111111");
		assertNotEquals("2222222222222", t1.getISBN());
	}
	
	@Test
	public void testGetBooktitlePass() {
		assertEquals("Test Book", t1.getBooktitle());
	}
	
	@Test
	public void testGetBooktitleFail() {
		assertNotEquals("Fail Book", t1.getBooktitle());
	}
	
	@Test
	public void testSetBooktitlePass() {
		t1.setBooktitle("New title");
		assertEquals("New title", t1.getBooktitle());
	}
	
	@Test
	public void testSetBooktitleFail() {
		t1.setBooktitle("New title");
		assertNotEquals("Test Book", t1.getBooktitle());
	}
	
	@Test
	public void testToStringPass() {
		assertEquals("["+ t1.getISBN() +","+ t1.getBooktitle() +"]", t1.toString());
	}
	
	@Test
	public void testToStringFail () {
		assertNotEquals("Fail", t1.toString());
	}
}
