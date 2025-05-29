package Helper_Attributes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThreadPoolSize_Attribute {

	@Test(invocationCount = 3, threadPoolSize = 3)
	public void loginToDWSTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");

		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("naresh006@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Crocodile@123");
		driver.findElement(By.id("RememberMe")).click();
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.textToBe(By.className("account"), "naresh006@gmail.com"));
			Reporter.log("PASS - User Logged in Successfully.....", true);
		} catch (Exception e) {
			Reporter.log("FAIL - Error message displayed....", true);
		} finally {
			driver.quit();
		}
	}
}
