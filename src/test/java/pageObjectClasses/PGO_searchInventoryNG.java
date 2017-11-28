package pageObjectClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libraryClasses.FuncitonLibrary;

public class PGO_searchInventoryNG extends FuncitonLibrary {
	private static WebElement element = null;
	
//	Below are the POs for Search Inventory functionality
	
	public static WebElement slct_text(WebDriver driver, String txtVal)
	{
		element = driver.findElement(By.xpath("//div[contains(text(),'"+txtVal+"')]"));
	libs.HighlightElement(driver, element);	return element;
	}

}
