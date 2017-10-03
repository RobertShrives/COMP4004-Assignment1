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
}
