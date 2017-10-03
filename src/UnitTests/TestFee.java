package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import server.logic.model.Fee;

public class TestFee {
	
	Fee f1 = new Fee(0, 30);
	Fee f2;
	
	@Test
	public void testFeeConstructorPass() {
		assertNotNull(f1);
	}
	
	@Test
	public void testFeeConstructorFail() {
		assertNull(f2);
	}

}
