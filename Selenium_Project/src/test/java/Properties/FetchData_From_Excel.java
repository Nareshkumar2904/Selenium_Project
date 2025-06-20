package Properties;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Utilities.File_Utilities;

public class FetchData_From_Excel{
	@Test
	public void registerTest() throws Exception{
		// Create Java Representation Object of External file
		FileInputStream fis = new FileInputStream("./src/test/resources/DWS.xlsx");

		// Open workbook in readmode
		Workbook wb = WorkbookFactory.create(fis);

		// Go to sheet by name
		Sheet sheet = wb.getSheet("DWS");

		// GO to tthe specific row by index
		Row row = sheet.getRow(1);

		// Go to the specific cell by index
		Cell cell = row.getCell(0);

		// Fetch the data from the cell
		String gender = cell.toString();
		String firstName = row.getCell(1).getStringCellValue();
		String lastName = File_Utilities.getDataFromExcel("DWS", 1, 2);
		String email = File_Utilities.getDataFromExcel("DWS", 1, 3);
		String pwd = File_Utilities.getDataFromExcel("DWS", 1, 4);
		String cpwd = File_Utilities.getDataFromExcel("DWS", 1, 5);

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
	
