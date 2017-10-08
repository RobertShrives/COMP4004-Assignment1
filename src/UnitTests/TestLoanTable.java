package UnitTests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.AfterClass;
import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import server.logic.tables.FeeTable;
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

	Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
	Date myDate = myCalendar.getTime();
	Timestamp stamp = new Timestamp(System.currentTimeMillis());
	Date date = new Date(stamp.getDateTime());

	@Test
	public void testCreateLoanTableSuccessPass() {
		TitleTable.getInstance().createtitle("9781442","test");
		ItemTable.getInstance().createitem("9781442");
		assertEquals("success", LoanTable.getInstance().createloan(2, "9781442", "1", date));
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
		TitleTable.getInstance().createtitle("7895485632154","test5");
		ItemTable.getInstance().createitem("7895485632154");
		assertEquals("Outstanding Fee Exists", LoanTable.getInstance().createloan(7, "7895485632154", "1", date));
	}
	
	@Test
	public void testCreateLoanTableOfeeFail() {
		assertNotEquals("success", LoanTable.getInstance().createloan(7, "9781442616899", "1", date));
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
		assertNotNull(LoanTable.getInstance().getLoanTable().size());
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
	
	@Test
	public void testCheckUserPass(){
		assertEquals(false, LoanTable.getInstance().checkUser(5));	
	}
	
	@Test
	public void testCheckUserFail(){
		assertEquals(true, LoanTable.getInstance().checkUser(0));	
	}
	
	@Test
	public void testCheckLoanDblStringPass(){
		assertEquals(false, LoanTable.getInstance().checkLoan("9781442668584","1"));	
	}
	
	@Test
	public void testCheckLoanDblStringFail(){
		assertEquals(true, LoanTable.getInstance().checkLoan("9781442112000","0"));	
	}
	
	public void testCheckLoanSingleStringPass(){
		assertEquals(false, LoanTable.getInstance().checkLoan("9781442112000"));	
	}
	
	@Test
	public void testCheckLoanSingleStringFail(){
		assertEquals(true, LoanTable.getInstance().checkLoan("9781442112000","0"));	
	}
	
	@Test
	public void testRenewalSuccessPass(){
		UserTable.getInstance().createuser("loantableEmail@gmail.com", "Pass");
		TitleTable.getInstance().createtitle("9781342112939","loantitle");
		ItemTable.getInstance().createitem("9781342112939");
		LoanTable.getInstance().createloan(3, "9781342112939", "1", myDate);
		ItemTable.getInstance().getItemTable();
		TitleTable.getInstance().getTitleTable();
		LoanTable.getInstance().renewal(5, "9781342112939", "1", myDate);
		LoanTable.getInstance().renewal(5, "9781342112939", "1", myDate);
		assertEquals("success", LoanTable.getInstance().renewal(3, "9781442111000", "1", myDate));	
		
	}
	
	@Test
	public void testMaxItemsPass(){
		assertEquals("The Maximun Number of Items is Reached", LoanTable.getInstance().renewal(1, "9781342112939", "1", myDate));	
		
	}
	
	@Test
	public void testMaxItemsFail(){
		assertNotEquals("Outstanding Fee Exists", LoanTable.getInstance().renewal(1, "9781442111444", "1", myDate));	
		
	}
	
	@Test
	public void testRenewExceededPass(){
		LoanTable.getInstance().renewal(3, "9781442111000", "1", myDate);
		assertEquals("Renewed Item More Than Once for the Same Loan", LoanTable.getInstance().renewal(3, "9781442111000", "1", myDate));	
		
	}
	
	@Test
	public void testRenewExceededFail(){
		LoanTable.getInstance().renewal(3, "9781442111000", "1", myDate);
		assertNotEquals("The Maximun Number of Items is Reached", LoanTable.getInstance().renewal(3, "9781442111000", "1", myDate));		
	}
	
	@Test
	public void testRenewDoesntExistPass(){
		assertEquals("The loan does not exist", LoanTable.getInstance().renewal(2, "9781442111000", "1", myDate));		
	}
	
	@Test
	public void testRenewDoesntExistFail(){
		assertNotEquals("Outstanding Fee Exists", LoanTable.getInstance().renewal(2, "9781442111000", "1", myDate));		
	}
	
	@Test
	public void testRenewOustandingFeePass(){
		FeeTable.getInstance().getFeeTable();
		assertEquals("Outstanding Fee Exists", LoanTable.getInstance().renewal(7, "9781442111000", "1", myDate));		
	}
	
	@Test
	public void testRenewOustandingFeeFail(){
		assertNotEquals("fail", LoanTable.getInstance().renewal(0, "9781442111000", "1", myDate));		
	}
	
	@Test
	public void testReturnItemSuccessPass(){
		UserTable.getInstance().createuser("testPerson@gmail.com", "pword");
		TitleTable.getInstance().createtitle("9781777112939","loantitle2");
		ItemTable.getInstance().createitem("9781777112939");
		LoanTable.getInstance().createloan(6, "9781777112939", "1", new Date());
		assertEquals("success", LoanTable.getInstance().returnItem(6, "9781777112939", "1", new Date()));		
	}
	
	@Test
	public void testReturnItemSuccessFail(){
		assertNotEquals("success", LoanTable.getInstance().returnItem(6, "9781777112939", "1", new Date()));		
	}
	
	@Test
	public void testReturnLoanDoesntExistPass(){
		assertEquals("The Loan Does Not Exist", LoanTable.getInstance().returnItem(7, "9781777112939", "1", new Date()));		
	}
	
	@Test
	public void testReturnLoanDoesntExistfail(){
		assertNotEquals("Fail text", LoanTable.getInstance().returnItem(7, "9781777112939", "1", new Date()));		
	}
	
	@Test
	public void testReturnApplyFeePass(){
		UserTable.getInstance().createuser("Parsons@gmail.com", "pord");
		TitleTable.getInstance().createtitle("9222777112939","loantitle2");
		ItemTable.getInstance().createitem("9222777112939");
		LoanTable.getInstance().createloan(7, "9222777112939", "1", myDate);
		LoanTable.getInstance().returnItem(7, "9222777112939", "1", new Date());
		assertEquals(false, FeeTable.getInstance().lookup(7));
	}
	
	@Test
	public void testReturnApplyFail(){
		assertNotEquals(5,FeeTable.getInstance().getFeeTable().size());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
