package Properties;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.File_Utilities;

public class FetchMultipleData_From_Excel {
	@DataProvider
	public String[][] registerData() throws Exception {

		FileInputStream fis = new FileInputStream("./src/test/resources/DWS.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("DWS");
		int rowNum = sheet.getPhysicalNumberOfRows();
		int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[rowNum - 1][cellNum];

		for (int i = 1; i < rowNum; i++) {
			for (int j = 0; j < cellNum; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
 
	@Test(dataProvider = "registerData")
	public void registerTest(String gender, String firstName, String lastName, String email, String pwd, String cpwd)
			throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(File_Utilities.getPropertyData("url"));
		driver.findElement(By.linkText("Register")).click();
		if (gender.equalsIgnoreCase("male")) {
			driver.findElement(By.id("gender-male")).click();
		} else {
			driver.findElement(By.id("gender-female")).click();
		}
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(cpwd);
		driver.findElement(By.id("register-button")).click();

		try {
			WebElement element = driver.findElement(By.linkText(email));
			if (element.isDisplayed()) {
				Reporter.log("User registered successfully......");
			}
		} catch (Exception e) {
			Reporter.log("The username is already registered");
			// TODO: handle exception
		} finally {
			driver.quit();
		}
	}

}
