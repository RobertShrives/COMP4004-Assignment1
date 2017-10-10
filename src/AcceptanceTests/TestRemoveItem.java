package AcceptanceTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.LibClient;
import server.network.LibServer;
import utilities.Config;

public class TestRemoveItem {
	
	private static LibServer server = new LibServer(Config.DEFAULT_PORT);
	
	@BeforeClass
	public static void beforeClass() {
		server.start();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testRemoveItemDoesntExists() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Delete Item");
		server.handle(client1.getID(), "1111142668584,1");
		//server.remove(client1.getID());
	}
	
	@Test
	public void testRemoveItemSuccess() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Delete Item");
		server.handle(client1.getID(), "9781611687910,1");
		//server.remove(client1.getID());
	}
	
	@Test
	public void testRemoveItemActiveLoan() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Delete Item");
		server.handle(client1.getID(), "9781442668584,1");
		//server.remove(client1.getID());
	}

}
