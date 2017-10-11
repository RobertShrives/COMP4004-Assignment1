package AcceptanceTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.LibClient;
import server.network.LibServer;
import utilities.Config;

public class TestRenewLoan {

	private static LibServer server = new LibServer(Config.DEFAULT_PORT);
	
	@BeforeClass
	public static void beforeClass() {
	server.start();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testRenewLoanOutStandingFee() {
	LibClient client1 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
	server.handle(client1.getID(), "Hello");
	server.handle(client1.getID(), "Clerk");
	server.handle(client1.getID(), "admin");
	server.handle(client1.getID(), "renew loan");
	server.handle(client1.getID(), "rob@carleton.ca,1234567891230,1");
	}
	@Test
	public void testRenewLoanSuccess() {
		LibClient client4 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client4.getID(), "Hello");
		server.handle(client4.getID(), "Clerk");
		server.handle(client4.getID(), "admin");
		server.handle(client4.getID(), "renew loan");
		server.handle(client4.getID(), "Gail@carleton.ca,9781442668584,1");
	}
}
