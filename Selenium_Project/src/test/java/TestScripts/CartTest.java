package TestScripts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import Generic_Utilities.BaseTest;

public class CartTest extends BaseTest {

	@Test(priority = 1, groups = {"sanity","regression"})
	public void addToCart() throws Exception {
		driver.findElement(By.name("q")).sendKeys("smartphone", Keys.ENTER);
		driver.findElement(By.linkText("Smartphone")).click();
		driver.findElement(By.xpath(
				"//h1[contains(text(),'Smartphone')]/ancestor::div[@class='overview']/descendant::input[@value='Add to cart']"))
				.click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File desc1 = new File("src/test/resources/Cart/addToCart.png");
		FileHandler.copy(src1, desc1);
	}

	@Test(priority = 2,groups = {"sanity","regression"})
	public void updateCart() throws Exception {
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		WebElement element = driver.findElement(By.xpath("//input[@class='qty-input']"));
		element.clear();
		element.sendKeys("3");
		driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src3 = ts.getScreenshotAs(OutputType.FILE);
		File desc3 = new File("src/test/resources/Cart/updateCart.png");
		FileHandler.copy(src3, desc3);
	}

	@Test(priority = 3,groups = "sanity")
	public void removeFromCart() throws Exception {
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src4 = ts.getScreenshotAs(OutputType.FILE);
		File desc4 = new File("src/test/resources/Cart/removeFromCart.png");
		FileHandler.copy(src4, desc4);
	}

}
