package UnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;

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
		assertEquals(false, LoanTable.getInstance().lookup(1, "9781443", "1"));
		
	}
	
	@Test
	public void testLookupFail(){
		TitleTable.getInstance().createtitle("9781442111333","test");
		ItemTable.getInstance().createitem("9781442111333");
		LoanTable.getInstance().createloan(1, "9781442111333", "1", date);
		assertEquals(true, LoanTable.getInstance().lookup(4, "9781442111333", "0"));
	}
	

	@Test
	public void testCheckLimitExceededPass(){
		//loan 1
		TitleTable.getInstance().createtitle("9781442111444","test");
		ItemTable.getInstance().createitem("9781442111444");
		LoanTable.getInstance().createloan(1, "9781442111444", "1", date);
		//Loan 2
		TitleTable.getInstance().createtitle("9781442111555","test");
		ItemTable.getInstance().createitem("9781442111555");
		LoanTable.getInstance().createloan(1, "9781442111555", "1", date);
		//Loan 3
		TitleTable.getInstance().createtitle("9781442111666","test");
		ItemTable.getInstance().createitem("9781442111666");
		LoanTable.getInstance().createloan(1, "9781442111666", "1", date);
		assertEquals(false, LoanTable.getInstance(). checkLimit(1));	
	}
	
	@Test
	public void testCheckLimitExceededFail(){
		//loan 1
		TitleTable.getInstance().createtitle("9781442111999","test");
		ItemTable.getInstance().createitem("9781442111999");
		LoanTable.getInstance().createloan(5, "9781442111999", "1", date);
		//Loan 2
		TitleTable.getInstance().createtitle("9781442111000","test");
		ItemTable.getInstance().createitem("9781442111000");
		LoanTable.getInstance().createloan(3, "9781442111000", "1", date);
		assertEquals(true, LoanTable.getInstance(). checkLimit(1));	
	}
	
	@Test
	public void testGetLoanTablePass(){
		//create new user
		UserTable.getInstance().createuser("newerEmail@gmail.com", "Pass");
		TitleTable.getInstance().createtitle("9781442112000","test");
		ItemTable.getInstance().createitem("9781442112000");
		LoanTable.getInstance().createloan(5, "9781442112000", "1", date);
		assertEquals(5, LoanTable.getInstance().getLoanTable().size());
	}
	
	@Test
	public void testGetLoanTableFail(){
		//create new user
		UserTable.getInstance().createuser("newerEmail@gmail.com", "Pass");
		TitleTable.getInstance().createtitle("9781442112000","test");
		ItemTable.getInstance().createitem("9781442112000");
		LoanTable.getInstance().createloan(5, "9781442112000", "1", date);
		assertNotEquals(3, LoanTable.getInstance().getLoanTable().size());
	}
	
	@Test
	public void testLookLimitPass(){
		assertEquals(true, LoanTable.getInstance().looklimit(0));
		
	}
	
	@Test
	public void testLookLimitFail(){
		assertEquals(false, LoanTable.getInstance().looklimit(1));
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
