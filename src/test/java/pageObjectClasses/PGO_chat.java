package pageObjectClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libraryClasses.FuncitonLibrary;

public class PGO_chat extends FuncitonLibrary {
	private static WebElement element = null;
	public static FuncitonLibrary libs = new FuncitonLibrary();
//	Below are the POs for chat functionality
	
	public static WebElement img_chatIcon(WebDriver driver)
	{
			element = driver.findElement(By.xpath("//span[@class = 'dreicon message-icon']|//A[@ng-click='messageModal()']"));

			libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_chatHeader(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
	libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement txt_chatConSts(WebDriver driver)
	
	{
		element = driver.findElement(By.xpath(".//*[@id='lblHeader']"));
	libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_ChatName(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='txtName']"));
	libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement btn_startChat(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='btnStartChat']"));
	libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement txt_chatLeaveMessage(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='lblLeaveMessage']"));
	libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement txt_chatNotLive(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='txtMessage']"));
	libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement txt_chatUserEmail(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='txtEmail']"));
	libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement img_chatLogo(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='imageLogo']"));
	libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement btn_chatSend1(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='btnMsgSend']"));
	return element;
	}
	public static WebElement btn_chatSend(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//span[@id='lblSend']"));
	return element;
	}
	public static WebElement txt_chatThankYou(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='lblMessageSent']"));
	libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_chat(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='txtChat']"));
	libs.HighlightElement(driver, element); return element;
	}	

}
