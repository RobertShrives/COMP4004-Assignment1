package UnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import server.logic.tables.FeeTable;
import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;

public class TestFeeTable {
	Timestamp stamp = new Timestamp(System.currentTimeMillis());
	Date date = new Date(stamp.getDateTime());

	@Test
	public void testFeeTableConstructor() {
		UserTable.getInstance().createuser("newerEmail@gmail.com", "Pass");
		TitleTable.getInstance().createtitle("9781442112000","test");
		ItemTable.getInstance().createitem("9781442112000");
		LoanTable.getInstance().createloan(5, "9781442112000", "1", date);
		assertNotNull(FeeTable.getInstance());
	}
	
	
	@Test
	public void testLookupPass(){
		assertEquals(false, FeeTable.getInstance().lookup(0));
	}
	

	@Test
	public void testLookupFail(){
		assertEquals(true, FeeTable.getInstance().lookup(2));
	}
	

}
