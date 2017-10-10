package AcceptanceTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.LibClient;
import server.network.LibServer;
import utilities.Config;

public class TestAddTitle {
	
	private static LibServer server = new LibServer(Config.DEFAULT_PORT);
	
	@BeforeClass
	public static void beforeClass() {
	server.start();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testAddTitleSuccess() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Create title");
		server.handle(client1.getID(), "'123456789985,gud book'");
	}
	
	@Test
	public void testAddTitleExists() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Create title");
		server.handle(client1.getID(), "9781442668584,Harry Potter");
	}
	
	@Test
	public void testAddTitleWrongFormatSuccess() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Create title");
		server.handle(client1.getID(), "777788899,wrong");
		server.handle(client1.getID(), "Create title");
		server.handle(client1.getID(), "'123333789985,gudder book'");
	}
	
	@Test
	public void testAddTitleWrongFormatExists() {
		LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client1.getID(), "Hello");
		server.handle(client1.getID(), "Clerk");
		server.handle(client1.getID(), "admin");
		server.handle(client1.getID(), "Create title");
		server.handle(client1.getID(), "777788899,wrong");
		server.handle(client1.getID(), "Create title");
		server.handle(client1.getID(), "9781442668584,Harry Potter");
	}


}
