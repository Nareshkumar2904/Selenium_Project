package TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utilities.BaseTest;

public class AddressTest extends BaseTest {

	@Test
	public void addAddress() {

		driver.findElement(By.linkText("naresh006@gmail.com")).click();
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//input[@value='Addresses']")).click();
		driver.findElement(By.id("Address_FirstName")).sendKeys("John");
		driver.findElement(By.id("")).sendKeys("Wick");
	}

	@Test
	public void updateAddress() {

	}

	@Test
	public void removeAddress() {

	}
}
