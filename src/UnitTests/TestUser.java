package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.model.User;

public class TestUser {

	User u1 = new User(0,"robshrives@gmail.com", "OldPass");
	User u2;
	
	@Test
	public void testUserConstructorPass() {
		assertNotNull(u1);
	}
	
	@Test
	public void testUserConstructorFail() {
		assertNull(u2);
	}
	
	@Test
	public void testGetUserIdPass() {
		assertEquals(0, u1.getUserid());
	}
	
	@Test
	public void testGetUserIdFail() {
		assertNotEquals(1, u1.getUserid());
	}
	
	@Test
	public void testSetUserIdPass() {
		u1.setUserid(5);
		assertEquals(5, u1.getUserid());
	}
	
	@Test
	public void testSetUserIdFail() {
		u1.setUserid(5);
		assertNotEquals(10, u1.getUserid());
	}

}
