package Generic_Utilities;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utilities {

	public static void takeScreenShot(WebDriver driver) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"./src/test/resources/ScreenShots/DemoWebShop/DWS_" + Java_Utilities.getName() + ".png");
		FileHandler.copy(screenshotAs, destination);
	}

	public static void takeScreenShot(WebElement element) throws Exception {
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"./src/test/resources/FlipKart/flipkart_" + Java_Utilities.getName() + ".png");
		FileHandler.copy(screenshotAs, destination);
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments(0).scrollIntoView(true)", element);
	}

	public static void selectDropDown(WebElement dropDownElement, String option) {
		Select sel = new Select(dropDownElement);
		sel.selectByVisibleText(option);
	}

	public static void switchToWindowByTitle(WebDriver driver, String title) {
		String parentId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentId);
		for (String WindowHandle : allWindowId) {
			driver.switchTo().window(WindowHandle);
			if (driver.getTitle().contains(title)) {
				break;
			}
		}
	}

	public static void switchToWindowByUrl(WebDriver driver, String url) {
		String parentId = driver.getWindowHandle();
		Set<String> allWindowId = driver.getWindowHandles();
		allWindowId.remove(parentId);
		for (String WindowHandle : allWindowId) {
			driver.switchTo().window(WindowHandle);
			if (driver.getTitle().contains(url)) {
				break;
			}
		}
	}
}
