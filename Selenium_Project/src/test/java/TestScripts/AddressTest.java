package TestScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_Utilities.BaseTest;

public class AddressTest extends BaseTest {

	@Test(priority = 1, groups = "sanity")
	public void addAddress() throws Exception {

		driver.findElement(By.linkText("naresh006@gmail.com")).click();
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//input[@value='Add new']")).click();
		driver.findElement(By.id("Address_FirstName")).sendKeys("John");
		driver.findElement(By.id("Address_LastName")).sendKeys("Wick");
		driver.findElement(By.id("Address_Email")).sendKeys("johnwick@gmail.com");
		driver.findElement(By.id("Address_Company")).sendKeys("xyz private limited");
		WebElement country = driver.findElement(By.id("Address_CountryId"));
		Select select = new Select(country);
		select.selectByValue("1");
		driver.findElement(By.id("Address_City")).sendKeys("Los Angeles");
		driver.findElement(By.id("Address_Address1")).sendKeys("8th Street");
		driver.findElement(By.id("Address_Address2")).sendKeys("USA");
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("000524");
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys("08056970458");
		driver.findElement(By.id("Address_FaxNumber")).sendKeys("586485");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		driver.findElement(By.linkText("Addresses")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File desc1 = new File("src/test/resources/Address/addAddress.png");
		FileHandler.copy(src1, desc1);

	}

	@Test(priority = 2,groups = {"sanity","regression"})
	public void updateAddress() throws Exception {
		driver.findElement(By.linkText("naresh006@gmail.com")).click();
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath(
				"//strong[contains(text(),'John Wick')]/ancestor::div[@class='section address-item']/descendant::input[@value='Edit']"))
				.click();
		WebElement element = driver.findElement(By.id("Address_Company"));
		element.clear();
		element.sendKeys("abc private limited");
		WebElement element2 = driver.findElement(By.id("Address_PhoneNumber"));
		element2.clear();
		element2.sendKeys("0898485965");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		driver.findElement(By.linkText("Addresses")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File desc1 = new File("src/test/resources/Address/updateAddress.png");
		FileHandler.copy(src1, desc1);

	}

	@Test(priority = 3, groups = "sanity")
	public void removeAddress() throws Exception {
		driver.findElement(By.linkText("naresh006@gmail.com")).click();
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath(
				"//strong[contains(text(),'John Wick')]/ancestor::div[@class='section address-item']/descendant::input[@value='Delete']"))
				.click();
		driver.switchTo().alert().accept();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File desc1 = new File("src/test/resources/Address/removeAddress.png");
		FileHandler.copy(src1, desc1);

	}
}
