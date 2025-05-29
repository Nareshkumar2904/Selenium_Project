package Helper_Attributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class First_TestNG_Class {

	@Test
	public void loginTest() {
		Reporter.log("User Logged in Successfully....", true);
	}

	@Test
	public void registerTest() {
		Reporter.log("User Registered in Successfully....", true);
	}

	@Test
	public void shoppingTest() {
		Reporter.log("User Purchased Product is Added Successfully....", true);
	}
}
