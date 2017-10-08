package UnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import server.logic.handler.InputHandler;

public class TestInputHandler {

	InputHandler iHandler = new InputHandler();
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testProcessInputWaitingState() {
		assertEquals("Who Are you?Clerk or User?",iHandler.processInput("", 0).getOutput());
	}
	
	@Test
	public void testProcessFinishWaitingStateClerk() {
		//System.out.println(iHandler.processInput("Clerk", 1).getOutput());
		assertEquals("Please Input The Password:",iHandler.processInput("Clerk", 1).getOutput());
	}
	
	@Test
	public void testProcessFinishWaitingStateUser() {
		//System.out.println(iHandler.processInput("User", 1).getOutput());
		assertEquals("Please Input Username and Password:'username,password'",iHandler.processInput("User", 1).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLogin() {
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item.",iHandler.processInput("admin", 14).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginCreateUser() {
		assertEquals("Please Input User Info:'username,password'",iHandler.processInput("create user", 2).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginCreateTitle() {
		assertEquals("Please Input Title Info:'ISBN,title'",iHandler.processInput("create title", 2).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginCreateitem() {
		assertEquals("Please Input Item Info:'ISBN'",iHandler.processInput("create item", 2).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginDeleteUser() {
		assertEquals("Please Input User Info:'useremail'",iHandler.processInput("delete user", 2).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginDeleteTitle() {
		assertEquals("Please Input Title Info:'ISBN'",iHandler.processInput("delete title", 2).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginDeleteItem() {
		assertEquals("Please Input Item Info:'ISBN,copynumber'",iHandler.processInput("delete item", 2).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginLogout() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 2).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginMainMenu() {
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item.",iHandler.processInput("main menu", 2).getOutput());
	}
	
	@Test
	public void testProcessInputClerkLoginOther() {
		assertEquals("Please select from the menu.Menu:Create User/Title/Item,Delete User/Title/Item.",iHandler.processInput("ha", 2).getOutput());
	}
	
	@Test
	public void testProcessInputUserBorrow() {
		assertEquals("Please Input User Info:'useremail,ISBN,copynumber'",iHandler.processInput("borrow", 3).getOutput());
	}
	
	@Test
	public void testProcessInputUserRenew() {
		assertEquals("Please Input Title Info:'useremail,ISBN,copynumber'",iHandler.processInput("renew", 3).getOutput());
	}
	
	@Test
	public void testProcessInputUserReturn() {
		assertEquals("Please Input Item Info:'useremail,ISBN,copynumber'",iHandler.processInput("return", 3).getOutput());
	}
	
	@Test
	public void testProcessInputUserPayFine() {
		assertEquals("Please Input User Info:'useremail'",iHandler.processInput("pay fine", 3).getOutput());
	}
	
	@Test
	public void testProcessInputUserLogout() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 3).getOutput());
	}
	
	@Test
	public void testProcessInputUserMainMenu() {
		assertEquals("Please select from the menu.Menu:Borrow,Renew,Return,Pay Fine.",iHandler.processInput(" ", 3).getOutput());
	}
	
	@Test
	public void testProcessInputCreateUser() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 4).getOutput());
	}
	
	@Test
	public void testProcessInputCreateUserMainMenu() {
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item.",iHandler.processInput("main menu", 4).getOutput());
	}
	
	@Test
	public void testProcessInputCreateTitle() {
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item.",iHandler.processInput("main menu", 5).getOutput());
	}
	
	@Test
	public void testProcessInputCreateTitleLogout() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 5).getOutput());
	}
	
	@Test
	public void testProcessInputCreateItem() {
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item.",iHandler.processInput("main menu", 6).getOutput());
	}
	
	@Test
	public void testProcessInputCreateItemLogout() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 6).getOutput());
	}
	
	@Test
	public void testProcessInputDeleteUser() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 7).getOutput());
	}
	
	@Test
	public void testProcessInputDeleteUserMainMenu() {
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item.",iHandler.processInput("main menu", 7).getOutput());
	}
	
	@Test
	public void testProcessInputDeleteTitle() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 8).getOutput());
	}
	
	@Test
	public void testProcessInputDeleteTitleMainMenu() {
		assertEquals("What can I do for you?Menu:Create User/Title/Item,Delete User/Title/Item.",iHandler.processInput("main menu", 8).getOutput());
	}
	
	@Test
	public void testProcessInputBorrow() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 10).getOutput());
	}
	
	@Test
	public void testProcessInputBorrowMainMenu() {
		assertEquals("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.",iHandler.processInput("main menu", 10).getOutput());
	}
	
	@Test
	public void testProcessInputRenew() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 11).getOutput());
	}
	
	@Test
	public void testProcessInputRenewMainMenu() {
		assertEquals("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.",iHandler.processInput("main menu", 11).getOutput());
	}
	
	@Test
	public void testProcessInputReturn() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 12).getOutput());
	}
	
	@Test
	public void testProcessInputReturnMainMenu() {
		assertEquals("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.",iHandler.processInput("main menu", 12).getOutput());
	}
	
	@Test
	public void testProcessInputPayFine() {
		assertEquals("Successfully Log Out!",iHandler.processInput("log out", 13).getOutput());
	}
	
	@Test
	public void testProcessInputPayFineMainMenu() {
		assertEquals("What can I do for you?Menu:Borrow,Renew,Return,Pay Fine.",iHandler.processInput("main menu", 13).getOutput());
	}
}
