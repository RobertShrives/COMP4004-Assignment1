package UnitTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import server.logic.handler.model.Output;

public class TestOutput {

	Output out = new Output("hello", 0);
	Output dummy;
	
	@Test
	public void testOutputConstructorPass() {
		assertNotNull(out);
	}
	
	@Test
	public void testOutputConstructorFail() {
		assertNull(dummy);
	}
	
	@Test
	public void testGetOutput() {
		assertNotNull(out.getOutput());
	}
	
	@Test
	public void testSetOutput() {
		out.setOutput("setting output");
		assertEquals("setting output", out.getOutput());
	}
	
	@Test
	public void testGetState() {
		assertEquals(0, out.getState());
	}

}
