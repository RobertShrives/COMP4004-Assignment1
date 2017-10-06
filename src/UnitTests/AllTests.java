package UnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFee.class, TestFeeTable.class, TestItem.class, TestItemTable.class, TestLoan.class,
		TestLoanTable.class, TestTitle.class, TestTitleTable.class, TestUser.class, TestUserTable.class })
public class AllTests {

}
