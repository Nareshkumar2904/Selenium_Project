package Properties;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.WelcomePage;

public class learning_POM_class {
	@Test
	public void learningPOM() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");

		WelcomePage page = new WelcomePage(driver);
		page.getLoginLink().click();
		page.getLoginLink().click();
		driver.quit();

//		WebElement element = driver.findElement(By.linkText("Log in"));
//		element.click();
//		element.click();

	}

}
