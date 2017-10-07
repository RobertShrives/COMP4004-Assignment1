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
	
	@Test
	public void testIsIntegerPass() {
		assertEquals(true, outHandler.isInteger("4258741268741"));
	}
	
	@Test
	public void testIsIntegerFail() {
		assertEquals(false, outHandler.isInteger("425868741"));
	}
	
	@Test
	public void testCreateTitleSuccess() {
		assertEquals("Success!", outHandler.createTitle("4258741268741, BeetleJuice").getOutput());
	}
	
	@Test
	public void testCreateTitleAlreadyExists() {
		assertEquals("The Title Already Exists!", outHandler.createTitle("4258741268741, BeetleJuice").getOutput());
	}
	
	@Test
	public void testCreateTitleUserWrongFormat() {
		assertEquals("Your input should in this format:'ISBN,title',ISBN should be a 13-digit number", outHandler.createTitle("42587412dscsd741, B").getOutput());
	}
	
	@Test
	public void testCreateItemSuccess() {
		assertEquals("Success!", outHandler.createItem("4258741268741").getOutput());
	}
	
	@Test
	public void testCreateItemDoesntExist() {
		assertEquals("The Title Does Not Exists!", outHandler.createItem("4258741268742").getOutput());
	}
	
	@Test
	public void testCreateItemWrongFormat() {
		assertEquals("Your input should in this format:'ISBN',ISBN should be a 13-digit number", outHandler.createItem("1").getOutput());
	}
	
	@Test
	public void testDeleteUserSuccess() {
		assertEquals("Success!", outHandler.deleteUser("Alice@carleton.ca").getOutput());
	}
	
	@Test
	public void testDeleteUserDoesntExist() {
		assertEquals("The User Does Not Exist!", outHandler.deleteUser("Alice@carleton.ca").getOutput());
	}
	
	@Test
	public void testDeleteUserWrongFormat() {
		assertEquals("Your input should in this format:'useremail'", outHandler.deleteUser("1").getOutput());
	}
}
