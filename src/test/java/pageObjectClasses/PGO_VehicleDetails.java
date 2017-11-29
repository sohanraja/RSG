package pageObjectClasses;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraryClasses.FuncitonLibrary;
public class PGO_VehicleDetails extends FuncitonLibrary {
	private static WebElement element = null;
  
    private static List<WebElement> elements;
	
//	Below are the POs for vehicleFlyOut functionality
	
	public static WebElement slct_lnkText (WebDriver driver, String lnkName)
	{
	element = 	driver.findElement(By.xpath("//div[@class='all-saved-vehicles']//a|(//a[@data-ng-click='nextTab()'])[position()=1]"));
	libs.HighlightElement(driver, element);	return element;
	}
//public static WebElement slct_lnkText (WebDriver driver,String linktext)
//{
////		element = driver.findElement(By.xpath("(//div[@class='col-xs-4 col-sm-4 next-button']//a[@data-ng-click='nextTab()'])[position()=1]"));
//	element = 	driver.findElement(By.linkText(linktext));
//
//	libs.HighlightElement(driver, element);	return element;
//	}
	public static WebElement img_delete (WebDriver driver)
	{
			element = driver.findElement(By.xpath("//a[@class='dreicon icon-uniE67F']"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement popup_close (WebDriver driver)
	{
			element = driver.findElement(By.xpath("//div[@id='welcomeMessageOverlay']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/button[@class='close']"));
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
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement lnk_addNwVhcle(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[1]/a/div[1]/span"));
	libs.HighlightElement(driver, element);	return element;	
	}
	
	public static WebElement img_closeDialog(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("div[class = 'modal-dialog'] span[class = 'icon-close']"));
	libs.HighlightElement(driver, element);	return element;	
	}
//	public static WebElement img_ihover(WebDriver driver, String sectionNm, int rownum)
//	{
//		element = driver.findElement(By.cssSelector("div[class = '"+sectionNm+"'] div:nth-of-type("+rownum+")  p.col-xs-7.col-sm-6 span:nth-child("+rownum+")"));
//	libs.HighlightElement(driver, element);	return element;	
//	}
//	public static WebElement suplnk_vehDtls(WebDriver driver, String sectionNm, int rownum)
//	{
//		element = driver.findElement(By.cssSelector("div[class = '"+sectionNm+"'] div:nth-of-type("+rownum+") sup"));
//	libs.HighlightElement(driver, element);	return element;	
//	}
	public static WebElement img_KBB(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("div[class = 'kbb-link col-xs-12 show'] a"));
	libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement img_close(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("button[class = 'close"));
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
	public static WebElement pricingSummaryHeading(WebDriver driver)
    {
	   WebDriverWait wait=new WebDriverWait(driver,2);	
       WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='intro-summary row']")));
    libs.HighlightElement(driver, element);	return element;
    } 
	public static WebElement dreicon(WebDriver driver)
    {
	   WebDriverWait wait=new WebDriverWait(driver,2);		
	   WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[contains(@class,'dreicon icon-uni')][contains(@data-ng-class,'totalMsrp')]")));
    	libs.HighlightElement(driver, element);	return element;
    } 
	public static List<WebElement> pricingSummaryElements(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);		
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/p[@class='col-xs-4 col-sm-4 text-right ng-binding']")));
	return elements;
	}
	public static WebElement preestimatedTax(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='summary-info']/div[@class='row grey-bar']/p[@class='col-xs-4 col-sm-4 text-right']/b")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement dreicon1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[contains(@class,'dreicon icon-uniE')][contains(@data-ng-class,'totalMsrp')]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement estimatedTaxPriceText(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='price-desc']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement kellyblueBook(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='kbb-link col-xs-12 show']/img[@class='kbb-icon']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement kellyblueBookButton(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-kbb']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> kellyblueTitle(WebDriver driver)
	{
	    WebDriverWait wait=new WebDriverWait(driver,2);
	    List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='kbb-overlay-body']/div/div/h3/span")));
	    return elements;
	}
	public static WebElement kellyblueVin(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body text-center']/div[@class='kbb-overlay-body']/div/div/div[@class='vin']/p")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement kellybluecanvas(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='iframe']/iframe")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement kellyblueClose(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement pricepledgeIcon(WebDriver driver)
	{
		 WebDriverWait wait=new WebDriverWait(driver,2);
		 WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='our-pledge row grey-bar']/div/img")));
		libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement pricepledgeHeading(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
	    WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='our-pledge row grey-bar']/div/h2")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement pricepledgedes(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='our-pledge row grey-bar']/div/div")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement vehicleDetailsTab (WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='single-tab vehicle-details active']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement vehicleTitle(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='intro-vehicle row']/h2")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static List<WebElement> vehicleModel(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2); 
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicle-title']/p")));
		return elements;
	}
	public static WebElement dealerDetail(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='intro-vehicle row']/div[@class='dealer-info']")));
	   libs.HighlightElement(driver, element);		return element;
	}
	public static WebElement vinDetail(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vehicle-info']/div/p[@class='col-xs-7 col-sm-6 vinNumber ng-binding']")));
	   libs.HighlightElement(driver, element);		return element;
	}
	public static List<WebElement> vehicledetails(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicle-info']/div/p[2]")));
		return elements;
	}
	public static List<WebElement> vehicledetailsLabel(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicle-info']/div/p[1]")));
		return elements;
	}
	public static WebElement windowSticker(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='detail-footer row']/p[1]/a[1]/span")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement detailFooter1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='detail-footer row']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement pricingsummaryFooter(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement pricingsummaryFooterdre(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[@ng-hide='isBuy() || isLease()']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement pricingsummaryFooterdre1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		
		
	  
	   switch(applicationname){
		
		case "RSG": 		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[4]/div/div[1]/div[2]/div[1]/div[4]/p[3]/span")));
							break;
		case "CTP":			
							element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//SPAN[@class='dreicon icon-uniE680'])[7]")));
			
							break;
						
	}
	   libs.HighlightElement(driver, element);		return element;	
		
	   
	}
	public static List<WebElement> msrpelements2(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		List <WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='popup popover-container']/div[@class='dealer-incentive border-bottom']/div")));
		return elements;
	}
	public static WebElement estimatedpretax(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='estimates border-bottom']/div[@class='row']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static List<WebElement> msrpelements4(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		List <WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='estimates border-bottom']/div[@data-ng-show='isCash()']/div")));
		return elements;
	}
	public static WebElement pricingsummaryFooterdre2(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary']/div[@class='your-price-mobile col-xs-12 col-sm-10 col-md-4']/h4/span[@class='dreicon icon-uniE67E']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement nextButton(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next: Value Your Trade-In")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement img_ihover(WebDriver driver, String sectionNm, int rownum)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);	
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class = '"+sectionNm+"'] div:nth-of-type("+rownum+")  p.col-xs-7.col-sm-6 span:nth-child("+rownum+")")));
	   libs.HighlightElement(driver, element);		return element;		
	}
	public static WebElement suplnk_vehDtls(WebDriver driver, String sectionNm, int rownum)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div[class = '"+sectionNm+"'] div:nth-of-type("+rownum+") sup")));
	   libs.HighlightElement(driver, element);		return element;		
	}
	public static WebElement skipTradeIn(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default introSkip']")));
	   libs.HighlightElement(driver, element);		return element;		
	}
	public static WebElement pricingSummary(WebDriver driver)
    {
	   WebDriverWait wait=new WebDriverWait(driver,90);	
       WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='intro-summary row']")));
      libs.HighlightElement(driver, element);		return element;	
    }
	public static List<WebElement> msrpElements(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);		
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicleDetail section']/div/div[2]/div[@class='pricingSummary']/div/div[2]/div/p[2]")));
		return elements;
	}
	public static WebElement pricedesc(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='price-desc']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement kellyblue(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//img[@class='kbb-icon']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement pricepledge(WebDriver driver)
	{
		 WebDriverWait wait=new WebDriverWait(driver,90);
		 WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='our-pledge row grey-bar']/div/img")));
		libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement vehicleHeading(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='intro-vehicle row']/h2")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static List<WebElement> vehicletitle(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,90); 
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicle-title']/p")));
		return elements;
	}
	public static WebElement detailFooter(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='detail-footer row']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static List<WebElement> msrpElements1(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		List <WebElement> elements=driver.findElements(By.xpath("//div[@id='vdp-price-summary']//tr//td[@class='ng-binding']"));
		return elements;
	}
	public static List<WebElement> msrpElementsLabel(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		List <WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='vdp-price-summary']//tr//th")));
		return elements;
	}
	public static WebElement pricedesc1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='price-desc']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> footermsrpelements1(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		List <WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='popup popover-container']/div/div")));
		return elements;
	}
	public static List<WebElement> footermsrpelements2(WebDriver driver,int dRw)
	{
		elements=driver.findElements(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[2]/div/div/p[2]"));
		return elements;
	}
	public static List<WebElement> footermsrpelements3(WebDriver driver,int dRw)
	{
		elements=driver.findElements(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[2]/div[3]/div[8]/div/p[2]"));
		return elements;
	}

	public static WebElement btn_nexvalueyourtradein (WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("(//a[@data-ng-click='nextTab()'])[position()=1]"));
	libs.HighlightElement(driver, element);	return element;
	}

	public static WebElement txt_YourVechicleHeading (WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//div[@class='intro-vehicle row']"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> txt_yourVechicleLabel(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		List <WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='vdp-vehicle-info']//div[@class='vehicle-info']//p[1]")));
		return elements;
	}
	public static List<WebElement> txt_yourVechicleValue(WebDriver driver,int dRw)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		List <WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='vdp-vehicle-info']//div[@class='vehicle-info']//p[2]")));
		return elements;
	}
	public static WebElement btn_deleteDeal(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("(//span[@class='vehicle-delete'])[position()=1]"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement btn_deleteDeal_Cancel(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//button[@class='btn btn-default']"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement lnk_VieWindowSticker(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//a[@data-ng-click='windowSticker($event)']"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement lnk_VieWindowSticker_PDF(WebDriver driver)
	{
		try{
			element = 	driver.findElement(By.id("plugin"));
			libs.HighlightElement(driver, element);	
		}catch(Exception e){		
			System.out.println("lnk_VieWindowSticker_PDF");
			}
			return element;
	
	}
	public static WebElement txt_BottomText(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("(//p[@class='ng-binding'])[position()=11]"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_YourEstimatedPretax(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//div[@class='price-desc']"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_KellyBlue(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//div[@id='vdp-price-advisor-w-cta']//p"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement img_KellyBlue(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//img[@class='kbb-icon']"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement img_ourpladge(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//img[@class='icon']"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement txt_ourpladge_Heading(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//div[@class='our-pledge row grey-bar']//h2"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement txt_ourpladge_Desc(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//div[@class='pledge-description']//p"));
	libs.HighlightElement(driver, element);	return element;
	}

	public static WebElement Btn_comparePrice(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//button[@class='btn btn-kbb']"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement Btn_comparePrice_close(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//button[@class='close']"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement txt_YourPricingSummary(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//div[@class='intro-summary row']//h2"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_Zipcode(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("(//span[@class='zip-code-input']//input)[position()=1]"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement lnk_Mapview(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//p[@class='dealer-info']"));
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement lnk_Mapview_Close(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("//div[@data-ng-click='close()']"));
	libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement error_Zipcode(WebDriver driver)
	{
	element = 	driver.findElement(By.xpath("(//p[@data-ng-if='zipCodeError'])[position()=1]"));
	libs.HighlightElement(driver, element);	return element;
	}
}
