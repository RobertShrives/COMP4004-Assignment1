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

public class TestReturnLoanCopy {

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
	public void testReturnLoancopyDoesntExists() {
	LibClient client4 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
	server.handle(client4.getID(), "Hello");
	server.handle(client4.getID(), "Clerk");
	server.handle(client4.getID(), "admin");
	server.handle(client4.getID(), "return loancopy");
	server.handle(client4.getID(), "rob@carleton.ca,1234567891230,1");
	}
	
	@Test
	public void testReturnLoancopySuccess() {
		LibClient client4 = new LibClient(Config.DEFAULT_HOST, Config.DEFAULT_PORT);
		server.handle(client4.getID(), "Hello");
		server.handle(client4.getID(), "Clerk");
		server.handle(client4.getID(), "admin");
		server.handle(client4.getID(), "return loancopy");
		server.handle(client4.getID(), "Gail@carleton.ca,9781442668584,1");
	}

}
