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
		LibClient client3 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client3.getID(), "Hello");
		server.handle(client3.getID(), "Clerk");
		server.handle(client3.getID(), "admin");
		server.handle(client3.getID(), "Create User");
		server.handle(client3.getID(), "r@gmail,pass");
	}
	
	@Test
	public void  testAddUserDoesExist() {
		LibClient client3 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client3.getID(), "Hello");
		server.handle(client3.getID(), "Clerk");
		server.handle(client3.getID(), "admin");
		server.handle(client3.getID(), "Create User");
		server.handle(client3.getID(), "Rob@carleton.ca,Rob");
	}

}
