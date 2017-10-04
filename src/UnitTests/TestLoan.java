package UnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import server.logic.model.Loan;

public class TestLoan {

	Date date1 = new Date();
	Loan loan1 = new Loan(0,"1111111111111", "1", date1, "0");
	Loan loan2;
	

	@Test
	public void testLoanConstructorPass() {
		assertNotNull(loan1);
	}
	
	@Test
	public void testLoanConstructorFail() {
		assertNull(loan2);
	}
	
	@Test
	public void testGetUserIdPass() {
		assertEquals(0, loan1.getUserid());
	}
	
	@Test
	public void testGetUserIdFail() {
		assertNotEquals(1, loan1.getUserid());
	}
	
	@Test
	public void testSetUseridPass() {
		loan1.setUserid(3);
		assertEquals(3, loan1.getUserid());
	}
	
	@Test
	public void testSetUseridFail() {
		loan1.setUserid(3);
		assertNotEquals(1, loan1.getUserid());
	}
	
	@Test
	public void testGetISBNPass() {
		assertEquals("1111111111111", loan1.getIsbn());
	}
	
	@Test
	public void testGetISBNFail() {
		assertNotEquals("2222222222222", loan1.getIsbn());
	}
	
	@Test
	public void testSetISBNPass() {
		loan1.setIsbn("2222222222222");
		assertEquals("2222222222222", loan1.getIsbn());
	}
	
	@Test
	public void testSetISBNFail() {
		loan1.setIsbn("1111111111111");
		assertNotEquals("2222222222222", loan1.getIsbn());
	}
	
	@Test
	public void testGetCopynumberPass() {
		assertEquals("1", loan1.getCopynumber());
	}
	
	@Test
	public void testGetCopynumberFail() {
		assertNotEquals("2", loan1.getCopynumber());
	}

}
