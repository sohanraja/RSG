package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import libraryClasses.FuncitonLibrary;

public class PGO_vehicleFlyOut extends FuncitonLibrary{
	private static WebElement element = null;
	private static List<WebElement> element1 = null;
//	Below are the POs for vehicleFlyOut functionality
	
	public static WebElement slct_lnkText (WebDriver driver, String lnkName)
	{
			element = driver.findElement(By.linkText(lnkName));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement img_delete (WebDriver driver)
	{
			element = driver.findElement(By.xpath("//a[@class='dreicon icon-uniE67F']"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_viewSavedDeals (WebDriver driver)
	{
			element = driver.findElement(By.xpath("//a[contains(text(),'View All Saved Vehicles')]"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_locationCd(WebDriver driver)
	{
			element = driver.findElement(By.xpath("//input[@maxlength='5']"));
	libs.HighlightElement(driver, element);	return element;
	}	
	public static WebElement btn_continue(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[text()='Continue']"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement slct_text(WebDriver driver, String txtVal)
	{
		element = driver.findElement(By.xpath("//div[contains(text(),'"+txtVal+"')]"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement slct_href(WebDriver driver, String hrefVal)
	{
		element = driver.findElement(By.xpath("//a[contains(@href, 'vin="+hrefVal+"')]"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement btn_conf(WebDriver driver, String btnName)
	{
		element = driver.findElement(By.xpath("//button[text()='"+btnName+"']"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement img_vehicleFlyOut(WebDriver driver)
	{try{
		element = driver.findElement(By.xpath("//div[@class='saved-vehicles-icon']/span[@class='icon-image']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){
		System.out.println("img_vehicleFlyout"+PGO_vehicleCards.class.getEnclosingMethod().getName());
	}
	return element;
	}
	
	public static WebElement lnk_addNwVhcle(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='col-xs-8 text-left vehicle-info']"));
	libs.HighlightElement(driver, element);	return element;	
	}
	
	public static WebElement img_closeDialog(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("div[class = 'modal-dialog'] span[class = 'icon-close']"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement img_ihover(WebDriver driver, String sectionNm, int rownum)
	{
		element = driver.findElement(By.cssSelector("div[class = '"+sectionNm+"'] div:nth-of-type("+rownum+") a[class = 'dreicon icon-uniE630']"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement suplnk_vehDtls(WebDriver driver, String sectionNm, int rownum)
	{
		element = driver.findElement(By.cssSelector("div[class = '"+sectionNm+"'] div:nth-of-type("+rownum+") sup"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement img_KBB(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("div[class = 'kbb-link col-xs-12 show'] a"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement img_close(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("button[class = 'close']"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement img_chat(WebDriver driver)
	{
		element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[3]/p[2]/span[1]"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement pricing_dtls(WebDriver driver,int rownum)
	{
		element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div["+rownum+"]/p[2]"));
	libs.HighlightElement(driver, element);	return element;	
	}

	public static WebElement pricingSummaryDtls(WebDriver driver, int rowNum)
	{
		element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div["+rowNum+"]/p[2]"));
												
		libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement Return_to_Search_Results(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//A[@class='backtoresults']|//A[@class='logo']"));
												
		libs.HighlightElement(driver, element);	return element;	
	}
	public static List<WebElement> saved_vechicles (WebDriver driver)
	{
			  element1 = driver.findElements(By.xpath("//div[@class='vehicle-vin']//span[2]"));
			  return element1;
	}
	public static WebElement SelectDelarprice(WebDriver driver,String Vinnumber)
	{
		element = driver.findElement(By.xpath("(//a[contains(@href,'"+Vinnumber+"')][contains(@title,'See Dealer Price')])[position()=1]|(//a[contains(@href,'"+Vinnumber+"')][contains(@title,'Build My Offer')])[position()=1]"));
												
		libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement Total_saved_vechicle(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//SPAN[@class='icon-number ng-binding']"));
												
		libs.HighlightElement(driver, element);	return element;	
	}
	public static List<WebElement> saved_vechicles_vinnumber (WebDriver driver)
	{
			  element1 = driver.findElements(By.xpath("//p[@class='vin ng-binding']"));
			  return element1;
	}
	public static WebElement saved_vechicles_viewDetails (WebDriver driver,int position)
	{
		element = driver.findElement(By.xpath("(//p[@class='link ng-scope'])[position()="+position+"]"));
			  libs.HighlightElement(driver, element);	return element;	
	}
	public static List<WebElement> saved_vechicles_delete (WebDriver driver)
	{
			  element1 = driver.findElements(By.xpath("//p[@class='delete']"));
			  return element1;
	}
	public static WebElement saved_vechicles_delete_pop_Yes (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[@ng-click='close(true)']"));
			  libs.HighlightElement(driver, element);	return element;	
	}
	
	public static WebElement txt_ReadyShopToGo(WebDriver driver)
	{
		try
		{element = driver.findElement(By.xpath("//p[@class='saved-vehicles-label hidden-sm hidden-xs']"));
			  libs.HighlightElement(driver, element);}catch(Exception e){
				System.out.println("txt_ReadyShopToGo");
			  }
		  return element;	
	}
	public static WebElement Img_Addnewvehicle (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='col-xs-4 text-center']//span[contains(@class,'dreicon icon-uni')]"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
//    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("Img_Addnewvehicle");
     	}
	return element;
	
	}
}
