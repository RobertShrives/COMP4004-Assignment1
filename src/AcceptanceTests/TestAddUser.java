package AcceptanceTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.LibClient;
import server.network.LibServer;
import utilities.Config;

public class TestAddUser {
	private static LibServer server = new LibServer(Config.DEFAULT_PORT);
	@BeforeClass
	public static void beforeClass() {
	server.start();
	}
	
	@Test
	public void testAddUserDoesntExist() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Create User");
		server.handle(client1.getID(), "r@gmail,pass");
	}
	
	@Test
	public void  testAddUserDoesExist() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Create User");
		server.handle(client1.getID(), "Rob@carleton.ca,Rob");
	}

}
