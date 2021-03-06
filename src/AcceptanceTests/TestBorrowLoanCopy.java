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

public class TestBorrowLoanCopy {
	
	private static LibServer server = new LibServer(Config.DEFAULT_PORT);
	Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
	Date myDate = myCalendar.getTime();
	Timestamp stamp = new Timestamp(System.currentTimeMillis());
	Date date = new Date(stamp.getDateTime());

		@BeforeClass
		public static void beforeClass() {
		server.start();
		}
		
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}
		
		@Test
		public void testBorrowLoancopySuccess() {
		LibClient client4 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client4.getID(), "Hello");
		server.handle(client4.getID(), "Clerk");
		server.handle(client4.getID(), "admin");
		server.handle(client4.getID(), "borrow loancopy");
		server.handle(client4.getID(), "Gail@carleton.ca,9781442667181,1");
		}
		
		@Test
		public void testReturnLoancopyDoesntExists() {
		LibClient client4 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client4.getID(), "Hello");
		server.handle(client4.getID(), "Clerk");
		server.handle(client4.getID(), "admin");
		server.handle(client4.getID(), "borrow loancopy");
		server.handle(client4.getID(), "joe@carleton.ca,9781442667181,1");
		}

}
