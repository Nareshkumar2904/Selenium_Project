package Helper_Attributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled_Attribute {

	@Test
	public void loginTest() {
		Reporter.log("User Logged in Successfully....", true);
	}

	@Test(enabled = false)
	public void registerTest() {
		Reporter.log("User Registered in Successfully....", true);
	}

	@Test(dependsOnMethods = { "loginTest" })
	public void shoppingTest() {
		Reporter.log("User Purchased Product is Added Successfully....", true);
	}
}
