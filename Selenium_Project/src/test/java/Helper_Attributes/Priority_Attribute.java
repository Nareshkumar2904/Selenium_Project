package Helper_Attributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority_Attribute {

	@Test(priority = 2)
	public void loginTest() {
		Reporter.log("User Logged in Successfully....", true);
	}

	@Test(priority = 1)
	public void registerTest() {
		Reporter.log("User Registered in Successfully....", true);
	}

	@Test(priority = 3)
	public void shoppingTest() {
		Reporter.log("User Purchased Product is Added Successfully....", true);
	}
}
