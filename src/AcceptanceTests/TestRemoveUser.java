package AcceptanceTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.LibClient;
import server.network.LibServer;
import utilities.Config;

public class TestRemoveUser {

private static LibServer server = new LibServer(Config.DEFAULT_PORT);
	
	@BeforeClass
	public static void beforeClass() {
	server.start();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testRemoveUserDoesntExists() {
	LibClient client3 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
	server.handle(client3.getID(), "Hello");
	server.handle(client3.getID(), "Clerk");
	server.handle(client3.getID(), "admin");
	server.handle(client3.getID(), "Delete User");
	server.handle(client3.getID(), "r@carleton.ca");
	//server.remove(client1.getID());
	}
	
	@Test
	public void testRemoveUserOutStandingFees() {
	LibClient client3 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
	server.handle(client3.getID(), "Hello");
	server.handle(client3.getID(), "Clerk");
	server.handle(client3.getID(), "admin");
	server.handle(client3.getID(), "Delete User");
	server.handle(client3.getID(), "Rob@carleton.ca");
	//server.remove(client1.getID());
	}
	
	@Test
	public void testRemoveUserSuccess() {
	LibClient client3 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
	server.handle(client3.getID(), "Hello");
	server.handle(client3.getID(), "Clerk");
	server.handle(client3.getID(), "admin");
	server.handle(client3.getID(), "Delete User");
	server.handle(client3.getID(), "Alice@carleton.ca");
	//server.remove(client1.getID());
	}
	
	@Test
	public void testRemoveUserActiveLoan() {
	LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
	server.handle(client1.getID(), "Hello");
	server.handle(client1.getID(), "Clerk");
	server.handle(client1.getID(), "admin");
	server.handle(client1.getID(), "Delete User");
	server.handle(client1.getID(), "Gail@carleton.ca");
	//server.remove(client1.getID());
	}

}
