package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.model.Fee;

public class TestFee {
	
	Fee f1 = new Fee(0, 30);
	Fee f2;
	
	@Test
	public void testFeeConstructorPass() {
		assertNotNull(f1);
	}
	
	@Test
	public void testFeeConstructorFail() {
		assertNull(f2);
	}
	
	@Test
	public void testGetUseridPass() {
		assertEquals(0, f1.getUserid());
	}
	
	@Test
	public void testGetUseridFail() {
		assertNotEquals(1, f1.getUserid());
	}
	
	@Test
	public void testSetUseridPass() {
		f1.setUserid(1);
		assertEquals(1, f1.getUserid());
	}
	
	@Test
	public void testSetUseridfail() {
		f1.setUserid(1);
		assertNotEquals(0, f1.getUserid());
	}
	
	@Test
	public void testGetFeePass() {
		assertEquals(30, f1.getFee());
	}
	
	@Test
	public void testGetFeeFail() {
		assertNotEquals(0, f1.getFee());
	}
	
	@Test
	public void testSetFeePass() {
		f1.setFee(10);
		assertEquals(10, f1.getFee());
	}
	
	@Test
	public void testSetFeeFail() {
		f1.setFee(10);
		assertNotEquals(30, f1.getFee());
	}
	
	@Test
	public void testToStringPass() {
		f1.setFee(10);
		assertEquals("["+f1.getUserid()+","+f1.getFee()+"]", f1.toString());
	}
	
	@Test
	public void testToStrinFail() {
		f1.setFee(10);
		assertNotEquals("Fail", f1.toString());
	}

}
