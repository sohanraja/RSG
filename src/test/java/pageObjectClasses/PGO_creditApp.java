package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libraryClasses.FuncitonLibrary;

public class PGO_creditApp {
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	public static FuncitonLibrary libs = new FuncitonLibrary();
	//	Below are the POs for reviewAndSend functionality
	
	public static WebElement txt_creditAppHdr(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//h1[@data-ng-bind-html='getHeader()']"));
		libs.HighlightElement(driver, element); return element;
	}	
	
	public static WebElement hyprlnk_prvcyPlcy(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//a[@ href='https://credit.ford.com/privacy']"));
		libs.HighlightElement(driver, element); return element;
	}
	
	
	public static WebElement btn_prntMyDeal(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[@data-ng-click='viewAndPrintDeal()']"));
		libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement txt_crdtAppDlrNm(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[@class='modal-body text-center']/section[@class='contactDealer']/div[@class='row']/div[1]"));
		libs.HighlightElement(driver, element); return element;
	}	
	
	public static WebElement txt_crdtAppDlrphn(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[@class='modal-body text-center']/section[@class='contactDealer']/div[@class='row']/div[2]/a"));
		libs.HighlightElement(driver, element); return element;
	}	
	public static List<WebElement> txt_crdtAppDlrAdd1(WebDriver driver)
	{
		elements =  driver.findElements(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[@class='modal-body text-center']/section[@class='contactDealer']/div[@class='row']/div[2]/p"));
		return elements;
	}	
	public static WebElement mapicon(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[@class='modal-body text-center']/section[@class='contactDealer']/div[@class='row']/div[3]/div/i[1]"));
		libs.HighlightElement(driver, element); return element;
	}	
	public static WebElement mapicon1(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[@class='modal-body text-center']/section[@class='contactDealer']/div[@class='row']/div[3]/div/p"));
		libs.HighlightElement(driver, element); return element;
	}
	public static WebElement mapiconclose(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[@class='modal-body text-center']/section[@class='contactDealer']/div[@class='row']/div[3]/div/i[2]"));
		libs.HighlightElement(driver, element); return element;
	}
	public static WebElement map(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[@class='modal-body text-center']/section[@class='contactDealer']/div[@data-ng-show='showMap']/div[2]/a/img"));
		libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_crdtApptstDrvDt(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[2]/section[@class='testDrive ng-scope']/div/div[1]/b"));
		libs.HighlightElement(driver, element); return element;
	}	
	public static WebElement txt_crdtApptstDrvTm(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div/div/div[2]/section[@class='testDrive ng-scope']/div/div[2]/b"));
		libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_PrvcyPlcyHdng(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//*[@id='content_accordion_item_1_box']/div/div/div/table/tbody/tr[1]/td[1]/p"));
		libs.HighlightElement(driver, element); return element;
	}
	
	public static WebElement txt_DealSentDate(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@id='dealStatus']//p[@class='sent-date ng-binding']"));
		libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_DealNumber(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@id='dealStatus']//p[2]//strong"));
		libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_Vinnumber(WebDriver driver)
	{
		element = driver.findElement(By.xpath("(//table[@class='details ruled ng-scope']//tr//td)[position()=1]"));
		libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_DealerAddress(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@id='dealerInformationBlock']//address"));
		libs.HighlightElement(driver, element); return element;
	}
	public static WebElement txt_DealNumberForWithCreditApp(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@id='dealStatus']//p[3]//strong"));
		libs.HighlightElement(driver, element); return element;
	}
}
