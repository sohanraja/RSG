package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libraryClasses.FuncitonLibrary;

public class PGO_questionsTab {
	private static WebElement element = null;
	public static  FuncitonLibrary libs = new FuncitonLibrary();
	private static List<WebElement> element1 = null;
//	Below are the POs for vehicleFlyOut functionality
	
	public static WebElement img_questions (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//span[@class='dreicon icon-uniE635 question-icon']"));
	        libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("img_questions");
		}
		return element;
	}
	public static WebElement title_questions (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//h4[@class='modal-title']"));
	        libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("title_questions");
		}
		return element;
	}
	public static WebElement txt_dealerName (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[@class='col-md-4']//h4"));
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_dealerName");
		}return element;
	}
	public static WebElement txt_dealerContactNo (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[@class='col-md-4']//a"));
	        libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_dealerContactNo");
		}
		return element;
	}
	public static WebElement txt_dealerAddressStreet1 (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("(//div[@class='col-md-4']//p)[position()=1]"));
	libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_dealerAddressStreet1");
		}
		return element;
	}
	public static WebElement txt_dealerAddressStreet2 (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("(//div[@class='col-md-4']//p)[position()=2]"));
	        libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_dealerAddressStreet2");
		}
		return element;
	}
	public static WebElement txt_dealerShopOpen (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("(//div[@class='col-md-4']//p)[position()=3]"));
	libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_dealerShopOpen");
		}
		return element;
	}
	public static WebElement img_DNmapOpen (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("(//div[@class='col-md-4']//p)[position()=4]"));
	libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("img_DNmapOpen");
		}
		return element;
	}
	public static WebElement img_viewMapOpen (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[@class='col-md-4']/div[@class='mapIcon']/i[1]"));
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("img_viewMapOpen");
		}
		return element;
	}
	public static WebElement img_viewMapClose (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[@class='col-md-4']/div[@class='mapIcon']/i[2]"));
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("img_viewMapClose");
		}
		return element;
	}
	public static WebElement img_mapDisplayed (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[@class='mapContainer col-sm-8']//img[@class='img-responsive']"));
	        libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("img_mapDisplayed");
		}
		return element;
	}
	public static WebElement txt_generalQuestions (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath("//div[contains(@data-ng-click, 'General Questions')]"));
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_generalQuestions");
		}
		return element;
	}
	public static WebElement txt_testdrive (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[contains(@data-ng-click, 'Test Drive')]"));
	libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_testdrive");
		}return element;
	}
	public static WebElement txt_tradeIn (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[contains(@data-ng-click, 'Trade-In')]"));
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_tradeIn");
		}return element;
	}
	public static WebElement txt_financing (WebDriver driver)
	{
		try
		{
			element =  driver.findElement(By.xpath("//div[contains(@data-ng-click, 'Financing')]"));
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_financing");
		}
		return element;
	}
	public static WebElement txt_creditApplic (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[contains(@data-ng-click, 'Credit Application')]"));
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_creditApplic");
		}return element;
	}
	public static WebElement img_closeQuestionsTab (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//button[@class='close']"));
	libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("img_closeQuestionsTab");
		}return element;
	}
	public static WebElement txt_faqhdng(WebDriver driver,int i)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[@class='modal fade contact-us-overlay ng-scope in']/div/div/div[2]/div/div[2]/accordion/div/div["+i+"]/div[1]/h4/a/div/p"));			
	libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_faqhdng");
		}
		return element;
	}
	public static WebElement txt_faqhdngDtl(WebDriver driver,int i,int j)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[@class='modal fade contact-us-overlay ng-scope in']/div/div/div[2]/div/div[2]/accordion/div/div["+i+"]/div[2]/div/div/p["+j+"]"));			
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_faqhdngDtl");
		}
		return element;
	}
	
	public static List<WebElement> Question_disclimers (WebDriver driver)
	{
		try
		{
			  element1 = driver.findElements(By.xpath("//i[contains(@class,'text-right dreicon  icon-uni')]"));
			  
		}
		catch(Exception e)
		{
			System.out.println("txt_faqhdngDtl");
		}
		return element1;
	}
	
	public static List<WebElement> Question_qstabs (WebDriver driver)
	{
		try
		{
			  element1 = driver.findElements(By.xpath("//div[contains(@data-ng-click,'track')]"));
			  
		}
		catch(Exception e)
		{
			System.out.println("txt_faqhdngDtl");
		}
		return element1;
	
	}
	public static List<WebElement> Question_tatalqs (WebDriver driver)
	{
		try
		{
			  element1 = driver.findElements(By.xpath("//div[@class='panel-collapse collapse in']//div[@class='questions section']"));
			  
		}
		catch(Exception e)
		{
			System.out.println("Question_tatalqs");
		}
		return element1;
		
	}
	public static WebElement questions_Close (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//div[@id='contactUsOverlay']//span[@class='icon-close']"));
	libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_faqhdngDtl");
		}return element;
	}
}
