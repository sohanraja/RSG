package pageObjectClasses;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libraryClasses.FuncitonLibrary;

public class PGO_signIn extends FuncitonLibrary {
	private static WebElement element = null;
	private static List<WebElement> elements=null;
	
//	Below are the POs for chat functionality
	
	public static WebElement lnk_svdDlr(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[7]/a"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement lnk_sgnIn(WebDriver driver)
	{
		element =  driver.findElement(By.xpath("//li[@class='user']/a/span[2]"));
	libs.HighlightElement(driver, element);	return element;	
	}
	
	public static WebElement lnk_sgnIn1(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//li[@class='user open']/ul/li[3]/a"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement signbenefitsHead(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[3]/div[@class='clw-benefitsP-container']/h3"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement signbenefitsText(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[3]/div[@class='clw-benefitsP-container']/p"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement createAccount(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[3]/button"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement continueButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[3]/a[@class='clw-continue-link has-create-account']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement signinText(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/div[@class='header']/h2"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement socialSignin(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/h3[1]"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static List<WebElement>  socialElements(WebDriver driver)
	{
		elements = driver.findElements(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/div[@class='clw-social-list-wrapper']/ul/li/a"));
	   return elements;	
	}
	public static WebElement createYourAccount(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[2]/div[1]/h2"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement crAccSubhead(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[2]/h3"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement crAccpwdrules(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[2]/form/p"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement benProfileHead(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[3]/div[1]/h3"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement benProfileText(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[3]/div[1]/h3"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement almember(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[3]/div[2]"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement alreadymemSignin(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[3]/a[@class='clw-show-signin lt-margin']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement continuenosignin(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[3]/a[@class='clw-continue-link has-create-account']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement btnSubmit(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[2]/form/div[6]/button[@class='clw-signin']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement btnCancel(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='CLW_Main']/div/div/div[2]/form/div[6]/a"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement profileHeading(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[3]/div[1]/h3"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement profileText(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[3]/div[1]/p"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static List<WebElement>  signinFields(WebDriver driver)
	{
		elements = driver.findElements(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/form/label"));
		 return elements;	
	}
	public static WebElement firstname_txt(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='label_first_name']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement lastname_txt(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='label_last_name']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement email_txt(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='label_useremail']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement emailConfirmation_txt(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='label_useremail_confirm']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement password_txt(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='label_password']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement passwordConfirm_txt(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@id='label_password_confirm']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static List<WebElement> signinForm(WebDriver driver)
	{
		elements = driver.findElements(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/form/label"));
		 return elements;	
	}
	public static WebElement signinButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/form/div[4]/button[@class='clw-signin']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement forgotPassword(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/form/div[5]/div[2]/a"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement rememberMe(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/form/div[5]/div[1]/label"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement un_text(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/form/input[@id='clwUsername']"));
	  libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement pwd_text(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@id='CLW_Main']/div/div/div[2]/form/input[@id='clwPassword']"));
	  libs.HighlightElement(driver, element);	return element;	
	}

}
