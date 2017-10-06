package UnitTests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import server.logic.model.Loan;
import server.logic.tables.FeeTable;
import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;

public class TestFeeTable {
	
	Timestamp stamp = new Timestamp(System.currentTimeMillis());
	Date date = new Date(stamp.getDateTime());
	Calendar myCalendar = new GregorianCalendar(2014, 2, 11);
	Date myDate = myCalendar.getTime();

	@Test
	public void testLookupPass(){
		assertEquals(false, FeeTable.getInstance().lookup(0));
	}
	

	@Test
	public void testLookupFail(){
		assertEquals(true, FeeTable.getInstance().lookup(2));
	}
	
	@Test
	public void testApplyFeePass(){
		UserTable.getInstance().createuser("newestEmail@gmail.com", "Pass");
		TitleTable.getInstance().createtitle("9781442112939","test");
		ItemTable.getInstance().createitem("9781442112939");
		List<Loan> loanList=LoanTable.getInstance().getLoanTable();
		LoanTable.getInstance().createloan(5, "9781442112939", "1", myDate);
		FeeTable.getInstance().applyfee(5, new Date().getTime()-loanList.get(0).getDate().getTime());
		assertEquals( 2 ,FeeTable.getInstance().getFeeTable().size());
	}

	@Test
	public void testApplyFeeFail(){
		UserTable.getInstance().createuser("Email@gmail.com", "Pass");
		TitleTable.getInstance().createtitle("9781442112938","test");
		ItemTable.getInstance().createitem("9781442112938");
		List<Loan> loanList=LoanTable.getInstance().getLoanTable();
		LoanTable.getInstance().createloan(5, "9781442112938", "1", myDate);
		FeeTable.getInstance().applyfee(5, new Date().getTime()-loanList.get(0).getDate().getTime());
		assertNotEquals(1 ,FeeTable.getInstance().getFeeTable().size());
	}	

	@Test
	public void testGetFeeTablePass(){
		UserTable.getInstance().createuser("newestEmail@gmail.com", "Pass");
		TitleTable.getInstance().createtitle("9781442112932","test");
		ItemTable.getInstance().createitem("9781442112932");
		List<Loan> loanList=LoanTable.getInstance().getLoanTable();
		LoanTable.getInstance().createloan(5, "9781442112932", "1", myDate);
		FeeTable.getInstance().applyfee(5, new Date().getTime()-loanList.get(0).getDate().getTime());

		assertEquals( 2 ,FeeTable.getInstance().getFeeTable().size());
	}
	
	@Test
	public void testGetFeeTableFail(){
		UserTable.getInstance().createuser("notEmail@gmail.com", "Pass");
		TitleTable.getInstance().createtitle("9781442111932","test11");
		ItemTable.getInstance().createitem("9781442111932");
		List<Loan> loanList1=LoanTable.getInstance().getLoanTable();
		LoanTable.getInstance().createloan(5, "9781442111932", "1", myDate);
		FeeTable.getInstance().applyfee(5, new Date().getTime()-loanList1.get(0).getDate().getTime());
		
		assertNotEquals( 1,FeeTable.getInstance().getFeeTable().size());
	}
	
	@Test
	public void testLookupFeePass(){
		assertEquals(5, FeeTable.getInstance().lookupfee(0));
		
	}
	
	@Test
	public void testLookupFeeFail(){
		assertNotEquals(4, FeeTable.getInstance().lookupfee(0));
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
