package Helper_Attributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOnMethods_Attributes {
	@Test(dependsOnMethods = "registerTest")
	public void loginTest() {
		Reporter.log("User Logged in Successfully....", true);
	}

	@Test
	public void registerTest() {
		Reporter.log("User Registered in Successfully....", true);
	}

	@Test(dependsOnMethods = { "registerTest", "loginTest" })
	public void shoppingTest() {
		Reporter.log("User Purchased Product is Added Successfully....", true);
	}
}
