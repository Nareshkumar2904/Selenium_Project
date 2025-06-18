package Properties;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.File_Utilities;
import Generic_Utilities.WebDriver_Utilities;

public class Practice_File_Utilties_Of_Flipkart {

	@DataProvider
	public static String[][] flipkartData() {
		String[][] data = File_Utilities.getMultipleDataFromExcel("FlipkartProducts");
		return data;

	}

	@Test(dataProvider = "flipkartData")
	public static void flipkartSearchProduct(String data) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");

		driver.findElement(By.name("q")).sendKeys(data, Keys.ENTER);
		WebDriver_Utilities.takeScreenShot(driver);
		driver.quit();

	}

}
