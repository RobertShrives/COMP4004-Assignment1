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
	
	@Test
	public void testCreateUserSuccess() {
		assertEquals("Success!", outHandler.createUser("robshrives@gmail.com, cheese").getOutput());
	}
	
	@Test
	public void testCreateUserAlreadyExists() {
		assertEquals("The User Already Exists!", outHandler.createUser("Jenny@carleton.ca, Jenny").getOutput());
	}
	
	@Test
	public void testCreateUserWrongFormat() {
		assertEquals("Your input should in this format:'username,password'", outHandler.createUser("mikes@gmail.com").getOutput());
	}
	

}
