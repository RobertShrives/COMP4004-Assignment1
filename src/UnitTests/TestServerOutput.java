package UnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import server.logic.handler.model.ServerOutput;

public class TestServerOutput {
	
	ServerOutput sOut = new ServerOutput("Test", 0);
	ServerOutput sOut2;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testServerOutputConstructorPass() {
		assertNotNull(sOut);
	}
	
	@Test
	public void testServerOutputConstructorFail() {
		assertNull(sOut2);
	}
	
	@Test
	public void testGetOutputPass() {
		assertEquals("Test", sOut.getOutput());
	}
	
	@Test
	public void testGetOutputfail() {
		assertNotEquals("Fail", sOut.getOutput());
	}
	
	@Test
	public void testSetOutputPass() {
		sOut.setOutput("NewMessage");
		assertEquals("NewMessage", sOut.getOutput());
	}
	
	@Test
	public void testSetOutputFail() {
		assertNotEquals("NotNewMessage", sOut.getOutput());
	}

}
