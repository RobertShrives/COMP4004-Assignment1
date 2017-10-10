package AcceptanceTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.LibClient;
import server.network.LibServer;
import utilities.Config;

public class TestRemoveTitle {

	private static LibServer server = new LibServer(Config.DEFAULT_PORT);
	
	@BeforeClass
	public static void beforeClass() {
	server.start();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testRemoveTitleDoesntExist() {
		LibClient client2 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client2.getID(), "Hello");
		server.handle(client2.getID(), "Clerk");
		server.handle(client2.getID(), "admin");
		server.handle(client2.getID(), "Delete title");
		server.handle(client2.getID(), "1123456789985");
	}
	
	@Test
	public void testRemoveTitleSuccess() {
		LibClient client2 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client2.getID(), "Hello");
		server.handle(client2.getID(), "Clerk");
		server.handle(client2.getID(), "admin");
		server.handle(client2.getID(), "Delete title");
		server.handle(client2.getID(), "9781317594277");
	}
	
	@Test
	public void testRemoveTitleActiveLoan() {
		LibClient client2 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client2.getID(), "Hello");
		server.handle(client2.getID(), "Clerk");
		server.handle(client2.getID(), "admin");
		server.handle(client2.getID(), "Delete title");
		server.handle(client2.getID(), "9781442668584");
	}
	
	@Test
	public void testRemoveTitlebadInput() {
		LibClient client2 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client2.getID(), "Hello");
		server.handle(client2.getID(), "Clerk");
		server.handle(client2.getID(), "admin");
		server.handle(client2.getID(), "Delete title");
		server.handle(client2.getID(), "test");
	}
	
	

}
