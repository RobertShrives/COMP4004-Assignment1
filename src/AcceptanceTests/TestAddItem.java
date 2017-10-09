package AcceptanceTests;

import static org.junit.Assert.*;

import java.net.Socket;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Test;

import client.ClientThread;
import client.LibClient;
import server.logic.handler.OutputHandler;
import server.logic.tables.ItemTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;
import server.network.LibServer;
import server.network.ServerThread;
import server.network.StartServer;
import utilities.Config;
import utilities.Trace;

public class TestAddItem {
	private Logger logger = Trace.getInstance().getLogger(this);

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testEx1() {
	}
	
	@Test
	public void testEx2() {
		OutputHandler outHandler = new OutputHandler();
		assertEquals("Success!", outHandler.createTitle("9781317598278,New title").getOutput());
		assertEquals("Success! You have added ISBN#:9781317598278 to the Library.", outHandler.createItem("9781317598278").getOutput());
		assertEquals("Success! You have added ISBN#:9781317598278 to the Library.", outHandler.createItem("9781317598278").getOutput());
		assertEquals("Success!", outHandler.createTitle("2281317598278,Newer title").getOutput());
		assertEquals("Success! You have added ISBN#:2281317598278 to the Library.", outHandler.createItem("2281317598278").getOutput());
		//System.out.println(ItemTable.getInstance().getItemTable());
		logger.info(String.format("Operation:Initialize ItemTable;ItemTable: %s", ItemTable.getInstance().getItemTable()));
		//assertEquals("Success!", outHandler.createItem("4258741268741").getOutput());
	}
	
}
