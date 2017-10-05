package UnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;

/**
 * @author robsh
 *
 */
/**
 * @author robsh
 *
 */
/**
 * @author robsh
 *
 */
/**
 * @author robsh
 *
 */
public class TestLoanTable {
	Timestamp stamp = new Timestamp(System.currentTimeMillis());
	Date date = new Date(stamp.getDateTime());

	@Test
	public void testCreateLoanTableSuccessPass() {
		TitleTable.getInstance().createtitle("9781442","test");
		ItemTable.getInstance().createitem("9781442");
		assertEquals("success", LoanTable.getInstance().createloan(4, "9781442", "1", date));
	}
	
	@Test
	public void testCreateLoanTableSuccessFail() {
		TitleTable.getInstance().createtitle("9781443","test");
		ItemTable.getInstance().createitem("9781443");
		assertNotEquals("The Item is Not Available", LoanTable.getInstance().createloan(4, "9781443", "1", date));
	}
	
	@Test
	public void testCreateLoanTableMaxPass() {
		TitleTable.getInstance().createtitle("9781446","test");
		ItemTable.getInstance().createitem("9781446");
		TitleTable.getInstance().createtitle("9781447","test1");
		ItemTable.getInstance().createitem("9781447");
		TitleTable.getInstance().createtitle("9781448","test2");
		ItemTable.getInstance().createitem("9781448");
		TitleTable.getInstance().createtitle("9781449","test3");
		ItemTable.getInstance().createitem("9781449");
		LoanTable.getInstance().createloan(4, "9781446", "1", date);
		LoanTable.getInstance().createloan(4, "9781447", "1", date);	
		assertEquals("The Maximun Number of Items is Reached", LoanTable.getInstance().createloan(4, "9781448", "1", date));
	}
	
	
	@Test
	public void testCreateLoanTableMaxFail() {
		TitleTable.getInstance().createtitle("9781446","test5");
		ItemTable.getInstance().createitem("9781446");
		TitleTable.getInstance().createtitle("9781447","test6");
		ItemTable.getInstance().createitem("9781447");
		TitleTable.getInstance().createtitle("9781448","test7");
		ItemTable.getInstance().createitem("9781448");
		TitleTable.getInstance().createtitle("9781449","test8");
		ItemTable.getInstance().createitem("9781449");
		LoanTable.getInstance().createloan(4, "9781446", "1", date);
		LoanTable.getInstance().createloan(4, "9781447", "1", date);	
		assertNotEquals("success", LoanTable.getInstance().createloan(4, "9781448", "1", date));
	}
	
	@Test
	public void testCreateLoanTableOfeePass() {
		assertEquals("Outstanding Fee Exists", LoanTable.getInstance().createloan(0, "9781442616899", "1", date));
	}
	
	@Test
	public void testCreateLoanTableOfeeFail() {
		assertNotEquals("success", LoanTable.getInstance().createloan(0, "9781442616899", "1", date));
	}
	
	@Test
	public void testCreateLoanTableNAPass() {
		TitleTable.getInstance().createtitle("9781442111111","test");
		ItemTable.getInstance().createitem("9781442111111");
		LoanTable.getInstance().createloan(1, "9781442111111", "1", date);
		LoanTable.getInstance().createloan(2, "9781442111111", "1", date);
		assertEquals("The Item is Not Available", (LoanTable.getInstance().createloan(0, "9781442111111", "1", date)));
		
	}
	
	@Test
	public void testCreateLoanTableNAFail() {
		TitleTable.getInstance().createtitle("9781442111111","test");
		ItemTable.getInstance().createitem("9781442111111");
		LoanTable.getInstance().createloan(1, "9781442111111", "1", date);
		LoanTable.getInstance().createloan(2, "9781442111111", "1", date);
		assertNotEquals("success", (LoanTable.getInstance().createloan(0, "9781442111111", "1", date)));
		
	}
	
	@Test
	public void testLookupPass(){
		TitleTable.getInstance().createtitle("9781442111333","test");
		ItemTable.getInstance().createitem("9781442111333");
		LoanTable.getInstance().createloan(1, "9781442111333", "1", date);
		LoanTable.getInstance().getLoanTable();
		assertEquals(false, LoanTable.getInstance().lookup(4, "9781443", "1"));
		
	}
	
	@Test
	public void testLookupFail(){
		TitleTable.getInstance().createtitle("9781442111333","test");
		ItemTable.getInstance().createitem("9781442111333");
		LoanTable.getInstance().createloan(1, "9781442111333", "1", date);
		LoanTable.getInstance().getLoanTable();
		assertEquals(true, LoanTable.getInstance().lookup(4, "9781442111333", "0"));
		
	}

}
