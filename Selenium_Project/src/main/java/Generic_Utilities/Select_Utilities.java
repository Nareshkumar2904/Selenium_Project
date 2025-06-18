package Generic_Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Select_Utilities {

	public static void select(WebDriver driver) {
		WebElement country = driver.findElement(By.id("Address_CountryId"));
		Select select = new Select(country);
		select.selectByValue("41");
	}
}
