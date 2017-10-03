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
	
	@Test
	public void testGetUsernamePass() {
		assertEquals("robshrives@gmail.com", u1.getUsername());
	}
	
	@Test
	public void testGetUsernameFail() {
		assertNotEquals("r_hrives@gmail.com", u1.getUsername());
	}
	
	@Test
	public void testSetUsernamePass() {
		u1.setUsername("robshrives@hotmail.com");
		assertEquals("robshrives@hotmail.com", u1.getUsername());
	}
	
	@Test
	public void testSetUsernameFail() {
		u1.setUsername("robshrives@hotmail.com");
		assertNotEquals("robshrives@gmail.com", u1.getUsername());
	}
	
	@Test
	public void testGetPasswordPass() {
		assertEquals("OldPass", u1.getPassword());
	}
	
	@Test
	public void testGetPasswordFail() {
		assertNotEquals("NewPass", u1.getPassword());
	}
	
	@Test
	public void testSetPasswordPass() {
		u1.setPassword("newPAss");
		assertEquals("newPAss", u1.getPassword());
	}
	
	@Test
	public void testSetPasswordFail() {
		u1.setPassword("newPAss");
		assertNotEquals("OldPass", u1.getPassword());
	}

}
