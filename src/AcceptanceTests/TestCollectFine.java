package AcceptanceTests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import client.LibClient;
import server.network.LibServer;
import utilities.Config;

public class TestCollectFine {
	private static LibServer server = new LibServer(Config.DEFAULT_PORT);
	
		@BeforeClass
		public static void beforeClass() {
		server.start();
		}
		
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}
		
		@Test
		public void testcollectFineSuccess() {
			LibClient client6 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
			server.handle(client6.getID(), "Hello");
			server.handle(client6.getID(), "Clerk");
			server.handle(client6.getID(), "admin");
			server.handle(client6.getID(), "collect fine");
			server.handle(client6.getID(), "rob@carleton.ca");
		}
		
		@Test
		public void testcollectFineDoesntExist() {
			LibClient client5 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
			server.handle(client5.getID(), "Hello");
			server.handle(client5.getID(), "Clerk");
			server.handle(client5.getID(), "admin");
			server.handle(client5.getID(), "collect fine");
			server.handle(client5.getID(), "mike@carleton.ca");
		}
		

}
