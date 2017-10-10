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
		assertEquals("ISBN#: 4258741268741 " +"Book title: " +TitleTable.getInstance().searchISBN("4258741268741"), outHandler.createItem("4258741268741").getOutput());
	}
	
	@Test
	public void testCreateItemDoesntExist() {
		assertEquals("The Title Does Not Exists! Please add it to the library", outHandler.createItem("4258741268742").getOutput());
	}
	
	@Test
	public void testCreateItemWrongFormat() {
		assertEquals("Your input should in this format:'ISBN',ISBN should be a 13-digit number", outHandler.createItem("1").getOutput());
	}
	
	@Test
	public void testDeleteUserSuccess() {
		UserTable.getInstance().createuser("Tommy@carleton.ca", "bored");
		assertEquals("Success!", outHandler.deleteUser("Tommy@carleton.ca").getOutput());
	}
	
	@Test
	public void testDeleteUserDoesntExist() {
		assertEquals("The User Does Not Exist!", outHandler.deleteUser("tony@carleton.ca").getOutput());
	}
	
	@Test
	public void testDeleteUserWrongFormat() {
		assertEquals("Your input should in this format:'useremail'", outHandler.deleteUser("1").getOutput());
	}
	
	@Test
	public void testDeleteTitleSuccess() {
		assertEquals("Success!", outHandler.deleteTitle("9781442616899").getOutput());
	}

	@Test
	public void testDeleteTitleDoesntExist() {
		assertEquals("The Title Does Not Exist!", outHandler.deleteTitle("9781443336899").getOutput());
	}
	
	@Test
	public void testDeleteTitleWrongFormat() {
		assertEquals("Your input should in this format:'ISBN',ISBN should be a 13-digit number", outHandler.deleteTitle("1").getOutput());
	}
	
	@Test
	public void testIsNumberPass() {
		assertEquals(true, outHandler.isNumber("5"));
	}
	
	@Test
	public void testIsNumberFail() {
		assertEquals(false, outHandler.isNumber("hello"));
	}
	
	@Test
	public void testDeleteItemSuccess() {
		TitleTable.getInstance().createtitle("7894561236987", "delet bopok");
		ItemTable.getInstance().createitem("7894561236987");
		ItemTable.getInstance().getItemTable();
		assertEquals("Success!", outHandler.deleteItem("7894561236987,1").getOutput());
	}
	
	@Test
	public void testDeleteItemWrongFormat() {
		TitleTable.getInstance().createtitle("7894561236987", "delet bopok");
		ItemTable.getInstance().createitem("7894561236987");
		ItemTable.getInstance().getItemTable();
		assertEquals("Your input should in this format:'ISBN,copynumber',ISBN should be a 13-digit number" , outHandler.deleteItem("weqeqd").getOutput());
	}
	
	@Test
	public void testBorrowItemSuccess() {
		TitleTable.getInstance().createtitle("9894561236987", "delet bopok lawl");
		ItemTable.getInstance().createitem("9894561236987");
		UserTable.getInstance().createuser("Joeshmoe@mail.com", "knucklebreaker");
		assertEquals("Success!", outHandler.borrow("Joeshmoe@mail.com,9894561236987,1").getOutput());
	}
	
	@Test
	public void testBorrowItemDoesntExist() {
		assertEquals("The User Does Not Exist!", outHandler.borrow("22@mail.com,9894561236987,1").getOutput());
	}
	
	@Test
	public void testBorrowItemWrongFormat() {
		assertEquals("Your input should in this format:'useremail,ISBN,copynumber'", outHandler.borrow("cheese").getOutput());
	}
	
	@Test
	public void testRenewItemSuccess() {
		TitleTable.getInstance().createtitle("9894561236987", "delet bopok lawl");
		ItemTable.getInstance().createitem("9894561236987");
		UserTable.getInstance().createuser("Joeshmoe@mail.com", "knucklebreaker");
		assertEquals("Success!", outHandler.renew("Joeshmoe@mail.com,9894561236987,1").getOutput());
	}
	
	@Test
	public void testRenewUserDoesntExist() {
		assertEquals("The User Does Not Exist!", outHandler.renew("unity@mail.com,9894561236987,1").getOutput());
	}
	
	@Test
	public void testRenewWrongFormat() {
		assertEquals("Your input should in this format:'useremail,ISBN,copynumber'", outHandler.renew("11").getOutput());
	}
	
	@Test
	public void testReturnBookSuccess() {
		TitleTable.getInstance().createtitle("9894561236988", "delet bopok lawl");
		ItemTable.getInstance().createitem("9894561236988");
		UserTable.getInstance().createuser("Joeshmoe@mail.com", "knucklebreaker");
		LoanTable.getInstance().getLoanTable();
		outHandler.borrow("Joeshmoe@mail.com,9894561236988,1").getOutput();
		assertEquals("Success!", outHandler.returnBook("Joeshmoe@mail.com,9894561236988,1").getOutput());
	}
	
	@Test
	public void testReturnUserDoesntExist() {
		assertEquals("The User Does Not Exist!", outHandler.returnBook("4@mail.com,9894561236988,1").getOutput());
	}
	
	@Test
	public void testReturnWrongFormat() {
		assertEquals("Your input should in this format:'useremail,ISBN,copynumber'", outHandler.returnBook("1").getOutput());
	}
	
	@Test
	public void testPayFineSuccess() {
		assertEquals("Success!", outHandler.payFine("rob@carleton.ca").getOutput());
	}
	
	@Test
	public void testPayFineUserDoesntExist() {
		assertEquals("The User Does Not Exist!", outHandler.payFine("1@carleton.ca").getOutput());
	}
	
	@Test
	public void testCollectFineSuccess() {
		assertEquals("Success!", outHandler.collectFine("rob@carleton.ca").getOutput());
	}
	
	@Test
	public void testCollectFineDoesntExist() {
		assertEquals("The User Does Not Exist!", outHandler.payFine("1@carleton.ca").getOutput());
	}
	
	@Test
	public void testPayFineWrongFormat() {
		assertEquals("Your input should in this format:'useremail'", outHandler.payFine("11a").getOutput());
	}
	
	@Test
	public void testClerkLoginSuccess() {
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item,Monitor System,Collect Fine,Borrow Loancopy,Renew Loan,Return Loancopy.", outHandler.clerkLogin("admin").getOutput());
	}
	
	@Test
	public void testClerkLoginWrongPassword() {
		assertEquals("Wrong Password!Please Input The Password:", outHandler.clerkLogin("wrong pass").getOutput());
	}
	
	@Test
	public void testUserLoginSuccess() {
		assertEquals("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.", outHandler.userLogin("Joeshmoe@mail.com,knucklebreaker").getOutput());
	}
	
	@Test
	public void testUserLoginWrongPassword() {
		assertEquals("Wrong Password!Please Input Username and Password:'username,password'", outHandler.userLogin("Joeshmoe@mail.com, knucklebreaker").getOutput());
	}
	
	@Test
	public void testUserLoginUserDoesntExist() {
		assertEquals("The User Does Not Exist!Please The Username and Password:'username,password'", outHandler.userLogin("1@mail.com,knucklebreaker").getOutput());
	}
}
