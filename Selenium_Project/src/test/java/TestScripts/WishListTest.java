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

public class WishListTest extends BaseTest {

	@Test(priority = 1)
	public void addToWishList() throws Exception {
		driver.findElement(By.id("small-searchterms")).sendKeys("smartphone", Keys.ENTER);
		driver.findElement(By.linkText("Smartphone")).click();
		driver.findElement(By.xpath("//input[@value='Add to wishlist']")).click();
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc = new File("src/test/resources/Wishlist/AddToWishList.png");
		FileHandler.copy(src, desc);
	}

	@Test(priority = 2)
	public void updateWishList() throws Exception {
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		WebElement element = driver.findElement(By.xpath("//input[@class='qty-input']"));
		element.clear();
		element.sendKeys("3");
		driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File updateSrc = ts.getScreenshotAs(OutputType.FILE);
		File updateDesc = new File("src/test/resources/Wishlist/UpdateWishList.png");
		FileHandler.copy(updateSrc, updateDesc);
	}

	@Test(priority = 3)
	public void addToCartFromWishList() throws Exception {
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		driver.findElement(By.name("addtocart")).click();
		driver.findElement(By.name("updatecart")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src2 = ts.getScreenshotAs(OutputType.FILE);
		File desc2 = new File("src/test/resources/Wishlist/addToCartFromWishList.png");
		FileHandler.copy(src2, desc2);
	}

	@Test(priority = 4)
	public void removeWishList() throws Exception {
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		driver.findElement(By.xpath("//input[@value='Update wishlist']")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File removeSrc = ts.getScreenshotAs(OutputType.FILE);
		File removeDesc = new File("src/test/resources/Wishlist/removeFromWishlist.png");
		FileHandler.copy(removeSrc, removeDesc);
	}
}
