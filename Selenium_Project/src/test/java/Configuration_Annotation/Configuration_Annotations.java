package Configuration_Annotation;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Configuration_Annotations {

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("Execution Before Suite", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("Execution After Suite", true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("Execution Before Class", true);
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("Execution After Class", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("Execution Before Test", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("Execution After Test", true);
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Execution Before Method", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("Execution After Method", true);
	}

	@Test(priority = 2)
	public void LoginTest() {
		Reporter.log("User Logged in Successfully......", true);
	}

	@Test(priority = 1)
	public void registerTest() {
		Reporter.log("User Registered  Successfully......", true);
	}

	@Test(priority = 3)
	public void shoppingTest() {
		Reporter.log("User Purchased product added Successfully......", true);
	}
}
