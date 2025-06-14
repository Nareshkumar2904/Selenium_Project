package Properties;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Data_Providers {
	public WebDriver driver;

	@DataProvider
	public String[][] loginData() {
		String[][] data = new String[2][2];
		data[0][0] = "nikhil29@gmail.com";
		data[0][1] = "nikhil123";
		data[1][0] = "naresh006@gmail.com";
		data[1][1] = "Crocodile@123";
		return data;
	}

	@Test(dataProvider = "loginData")
	public void loginToDWS(String email, String password) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		SoftAssert ast = new SoftAssert();
		ast.assertEquals(driver.getTitle(), "Demo Web Shop", "Welcome page Displayed");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='RememberMe']")).click();
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.linkText("Log out")).click();
		driver.quit();
	}
}
