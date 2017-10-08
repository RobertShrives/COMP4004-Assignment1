package UnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import server.logic.handler.model.Client;
import server.network.ServerThread;

public class TestClient {
	ServerThread client;
	Client client1 = new Client(client,1);
	Client client2;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testClientConstructorPass() {
		assertNotNull(client1);
	}
	
	@Test
	public void testClientConstructorFail() {
		assertNull(client2);
	}
	
	@Test
	public void testGetStatePass() {
		assertEquals(1, client1.getState());
	}
	
	@Test
	public void testGetStateFail() {
		assertNotEquals(2, client1.getState());
	}

	@Test
	public void testSetClientPass() {
		client1.setState(2);
		assertEquals(2, client1.getState());
	}
	
	@Test
	public void testSetClientFail() {
		client1.setState(2);
		assertNotEquals(1, client1.getState());
	}
	
}
