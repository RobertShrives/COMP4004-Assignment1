package UnitTests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import server.logic.model.Loan;

public class TestLoan {
	
	
	DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Timestamp stamp = new Timestamp(System.currentTimeMillis());
	Date date = new Date(stamp.getDateTime());
	Date date1 = new Date(System.currentTimeMillis()+5*60*1000);
	Date date2;
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
	
	@Test
	public void testSetCopynumberPass() {
		loan1.setCopynumber("5");
		assertEquals("5", loan1.getCopynumber());
	}
	
	@Test
	public void testSetCopynumberFail() {
		loan1.setCopynumber("3");
		assertNotEquals("5", loan1.getCopynumber());
	}
	
	@Test
	public void testGetDatePass() {
		assertNotNull(loan1.getDate());
	}
	
	@Test
	public void testGetDateFail() {
		assertNull(date2);
	}
	
	@Test
	public void testSetDatePass() {
		loan1.setDate(date1);
		assertEquals(date1, loan1.getDate());
	}
	
	@Test
	public void testSetDateFail() {
		loan1.setDate(date);
		assertNotEquals(date1, loan1.getDate());
	}
	
	@Test
	public void testGetRenewstatePass() {
		assertEquals("0", loan1.getRenewstate());
	}
	
	@Test
	public void testGetRenewstateFail() {
		assertNotEquals("1", loan1.getRenewstate());
	}
	
	@Test
	public void testSetRenewstatePass() {
		loan1.setRenewstate("1");
		assertEquals("1", loan1.getRenewstate());
	}
	
	@Test
	public void testSetRenewstateFail() {
		loan1.setRenewstate("0");
		assertNotEquals("1", loan1.getRenewstate());
	}
	
	@Test
	public void testToStringPass() {
		assertEquals("["+loan1.getUserid()+","+loan1.getIsbn()+","+loan1.getCopynumber() +","+format1.format(loan1.getDate())+","+loan1.getRenewstate()+"]", loan1.toString());
	}
	
	@Test
	public void testToStringFail() {
		assertNotEquals("Fail", loan1.toString());
	}
}
