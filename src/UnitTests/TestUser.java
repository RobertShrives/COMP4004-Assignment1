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

}
