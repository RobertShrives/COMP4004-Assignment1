package UnitTests;

import static org.junit.Assert.*;
import server.logic.handler.model.Output;
import server.logic.tables.FeeTable;
import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;
import utilities.Config;
import org.junit.AfterClass;
import org.junit.Test;

import server.logic.handler.OutputHandler;

public class TestOutputHandler {

	OutputHandler outHandler = new OutputHandler();
	OutputHandler outHandler2;
	
	@Test
	public void testCreateOutputHandlerPass() {
		assertNotNull(outHandler);
	}
	
	@Test
	public void testCreateOutputHandlerFail() {
		assertNull(outHandler2);
	}

}
