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
		try
		{
		
	element = 	driver.findElement(By.xpath("//div[@class='all-saved-vehicles']//a|(//a[@data-ng-click='nextTab()'])[position()=1]"));
	libs.HighlightElement(driver, element);	}catch(Exception e)	{
		System.out.println("slct_lnkText");
		}
		return element;
	}

	public static WebElement img_delete (WebDriver driver)
	{ try{
			element = driver.findElement(By.xpath("//a[@class='dreicon icon-uniE67F']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("img_delete"); 		}	
	return element;
	}
	
	public static WebElement popup_close (WebDriver driver)
	{ try{
			element = driver.findElement(By.xpath("//div[@id='welcomeMessageOverlay']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-header']/button[@class='close']"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e)		{ 
		System.out.println("popup_close"); 		}	
	
	return element;	}
	
	public static WebElement txt_viewSavedDeals (WebDriver driver)
	{ try{
			element = driver.findElement(By.xpath("//a[contains(text(),'View All Saved Vehicles')]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_viewSavedDeals"); 		}		return element;	}
	public static WebElement txt_locationCd(WebDriver driver)
	{ try{
			element = driver.findElement(By.xpath("//input[@maxlength='5']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_locationCd"); 		}		return element;	}	
	public static WebElement btn_continue(WebDriver driver)
	{ try{
		element = driver.findElement(By.xpath("//button[text()='Continue']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("btn_continue"); 		}		return element;	}
	
	public static WebElement slct_text(WebDriver driver, String txtVal)
	{ try{
		element = driver.findElement(By.xpath("//div[contains(text(),'"+txtVal+"')]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("slct_lnkText"); 		}		return element;	}
	
	public static WebElement slct_href(WebDriver driver, String hrefVal)
	{ try{
		element = driver.findElement(By.xpath("//a[contains(@href, 'vin="+hrefVal+"')]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("slct_href"); 		}		return element;	}
	public static WebElement btn_conf(WebDriver driver, String btnName)
	{ try{
		element = driver.findElement(By.xpath("//button[text()='"+btnName+"']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("btn_conf"); 		}		return element;	}
	public static WebElement img_vehicleFlyOut(WebDriver driver)
	{ try{
		element = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("img_vehicleFlyOut"); 		}		return element;	}
	
	public static WebElement lnk_addNwVhcle(WebDriver driver)
	{ try{
		element = driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[1]/a/div[1]/span"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e)		{ 		System.out.println("lnk_addNwVhcle"); 		}		return element;	}
	
	public static WebElement img_closeDialog(WebDriver driver)
	{ try{
		element = driver.findElement(By.cssSelector("div[class = 'modal-dialog'] span[class = 'icon-close']"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e)		{ 		System.out.println("img_closeDialog"); 		}		return element;	}
	public static WebElement img_KBB(WebDriver driver)
	{ try{
		element = driver.findElement(By.cssSelector("div[class = 'kbb-link col-xs-12 show'] a"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e)		{ 		System.out.println("img_KBB"); 		}		return element;	}
	public static WebElement img_close(WebDriver driver)
	{ try{
		element = driver.findElement(By.cssSelector("button[class = 'close"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e)		{ 		System.out.println("img_close"); 		}		return element;	}
	public static WebElement img_chat(WebDriver driver)
	{ try{
		element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div[3]/p[2]/span[1]"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e)		{ 		System.out.println("img_chat"); 		}		return element;	}
	public static WebElement pricing_dtls(WebDriver driver,int rownum)
	{ try{
		element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div["+rownum+"]/p[2]"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e)		{ 		System.out.println("pricing_dtls"); 		}		return element;	}

	public static WebElement pricingSummaryDtls(WebDriver driver, int rowNum)
	{ try{
		element = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div["+rowNum+"]/p[2]"));
												
		libs.HighlightElement(driver, element);	
	}catch(Exception e)		{ 		System.out.println("pricingSummaryDtls"); 		}		return element;	}
	public static WebElement pricingSummaryHeading(WebDriver driver)
    { try{
	   	
        element=driver.findElement(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='intro-summary row']"));
    libs.HighlightElement(driver, element);
    }catch(Exception e)		{ 		System.out.println("pricingSummaryHeading"); 		}		return element;	} 
	public static WebElement dreicon(WebDriver driver)
    { try{
	  		
	   element=driver.findElement(By.xpath("//SPAN[contains(@class,'dreicon icon-uni')][contains(@data-ng-class,'totalMsrp')]"));
    	libs.HighlightElement(driver, element);
    }catch(Exception e)		{ 	
    	System.out.println("dreicon"); 		}	
    return element;	} 
	public static List<WebElement> pricingSummaryElements(WebDriver driver,int dRw)
	{ try{
			
	 elements=driver.findElements(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/p[@class='col-xs-4 col-sm-4 text-right ng-binding']"));
	
	}catch(Exception e)		{ 		System.out.println("pricingSummaryElements"); 		}		return elements;	}
	public static WebElement preestimatedTax(WebDriver driver)
	{ try{
				
	 element=driver.findElement(By.xpath("//div[@class='summary-info']/div[@class='row grey-bar']/p[@class='col-xs-4 col-sm-4 text-right']/b"));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("preestimatedTax"); 		}		return element;	}
	public static WebElement dreicon1(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		 element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[contains(@class,'dreicon icon-uniE')][contains(@data-ng-class,'totalMsrp')]")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("dreicon1"); 		}		return element;	}
	public static WebElement estimatedTaxPriceText(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='price-desc']")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("estimatedTaxPriceText"); 		}		return element;	}
	public static WebElement kellyblueBook(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='kbb-link col-xs-12 show']/img[@class='kbb-icon']")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("kellyblueBook"); 		}		return element;	}
	public static WebElement kellyblueBookButton(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-kbb']")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("kellyblueBookButton"); 		}		return element;	}
	public static List<WebElement> kellyblueTitle(WebDriver driver)
	{ try{
	    WebDriverWait wait=new WebDriverWait(driver,2);
	    List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='kbb-overlay-body']/div/div/h3/span")));
	  
	}catch(Exception e)		{ 		System.out.println("kellyblueTitle"); 		}		  return elements;	}
	public static WebElement kellyblueVin(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body text-center']/div[@class='kbb-overlay-body']/div/div/div[@class='vin']/p")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("kellyblueVin"); 		}		return element;	}
	public static WebElement kellybluecanvas(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='iframe']/iframe")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("slct_lnkText"); 		}		return element;	}
	public static WebElement kellyblueClose(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='close']")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("kellyblueClose"); 		}		return element;	}
	public static WebElement pricepledgeIcon(WebDriver driver)
	{ try{
		 WebDriverWait wait=new WebDriverWait(driver,2);
		 element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='our-pledge row grey-bar']/div/img")));
		libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("pricepledgeIcon"); 		}		return element;	}
	public static WebElement pricepledgeHeading(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
	    element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='our-pledge row grey-bar']/div/h2")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("pricepledgeHeading"); 		}		return element;	}
	public static WebElement pricepledgedes(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='our-pledge row grey-bar']/div/div")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("pricepledgedes"); 		}		return element;	}
	public static WebElement vehicleDetailsTab (WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='single-tab vehicle-details active']")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("vehicleDetailsTab"); 		}		return element;	}
	public static WebElement vehicleTitle(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='intro-vehicle row']/h2")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("vehicleTitle"); 		}		return element;	}
	public static List<WebElement> vehicleModel(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2); 
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicle-title']/p")));
		
	}catch(Exception e)		{ 		System.out.println("vehicleModel"); 		}		return elements;}
	public static WebElement dealerDetail(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='intro-vehicle row']/div[@class='dealer-info']")));
	   libs.HighlightElement(driver, element);		return element;
	}catch(Exception e)		{ 		System.out.println("dealerDetail"); 		}		return element;	}
	public static WebElement vinDetail(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vehicle-info']/div/p[@class='col-xs-7 col-sm-6 vinNumber ng-binding']")));
	   libs.HighlightElement(driver, element);		return element;
	}catch(Exception e)		{ 		System.out.println("vinDetail"); 		}		return element;	}
	public static List<WebElement> vehicledetails(WebDriver driver,int dRw)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicle-info']/div/p[2]")));
	
	}catch(Exception e)		{ 		System.out.println("vehicledetails"); 		}		return elements;}
	public static List<WebElement> vehicledetailsLabel(WebDriver driver,int dRw)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicle-info']/div/p[1]")));
	
	}catch(Exception e)		{ 		System.out.println("vehicledetailsLabel"); 		}		return elements;}
	public static WebElement windowSticker(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='detail-footer row']/p[1]/a[1]/span")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("windowSticker"); 		}		return element;	}
	public static WebElement detailFooter1(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='detail-footer row']")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("detailFooter1"); 		}		return element;	}
	public static WebElement pricingsummaryFooter(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary']")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("pricingsummaryFooter"); 		}		return element;	}
	public static WebElement pricingsummaryFooterdre(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//SPAN[@ng-hide='isBuy() || isLease()']")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("pricingsummaryFooterdre"); 		}		return element;	}
	
	
	public static List<WebElement> msrpelements2(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='popup popover-container']/div[@class='dealer-incentive border-bottom']/div")));
		
	}catch(Exception e)		{ 		System.out.println("msrpelements2"); 		}		return elements;	}
	public static WebElement estimatedpretax(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='estimates border-bottom']/div[@class='row']")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("estimatedpretax"); 		}		return element;	}
	public static List<WebElement> msrpelements4(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='estimates border-bottom']/div[@data-ng-show='isCash()']/div")));
		
	}catch(Exception e)		{ 		System.out.println("msrpelements4"); 		}		return elements;	}
	public static WebElement pricingsummaryFooterdre2(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary']/div[@class='your-price-mobile col-xs-12 col-sm-10 col-md-4']/h4/span[@class='dreicon icon-uniE67E']")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("pricingsummaryFooterdre2"); 		}		return element;	}
	public static WebElement nextButton(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Next: Value Your Trade-In")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("nextButton"); 		}		return element;	}
	public static WebElement img_ihover(WebDriver driver, String sectionNm, int rownum)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);	
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class = '"+sectionNm+"'] div:nth-of-type("+rownum+")  p.col-xs-7.col-sm-6 span:nth-child("+rownum+")")));
	   libs.HighlightElement(driver, element);		return element;		
	}catch(Exception e)		{ 		System.out.println("img_ihover"); 		}		return element;	}
	public static WebElement suplnk_vehDtls(WebDriver driver, String sectionNm, int rownum)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("div[class = '"+sectionNm+"'] div:nth-of-type("+rownum+") sup")));
	   libs.HighlightElement(driver, element);		return element;		
	}catch(Exception e)		{ 		System.out.println("suplnk_vehDtls"); 		}		return element;	}
	public static WebElement skipTradeIn(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,2);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default introSkip']")));
	   libs.HighlightElement(driver, element);		return element;		
	}catch(Exception e)		{ 		System.out.println("skipTradeIn"); 		}		return element;	}
	public static WebElement pricingSummary(WebDriver driver)
    { 
	 try{
	   WebDriverWait wait=new WebDriverWait(driver,90);	
       element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='intro-summary row']//h2")));
      libs.HighlightElement(driver, element);
      }
	 catch(Exception e)	
	 { 		System.out.println("pricingSummary"); 		
	 }		
	 return element;	}
	public static List<WebElement> msrpElements(WebDriver driver,int dRw)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);		
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicleDetail section']/div/div[2]/div[@class='pricingSummary']/div/div[2]/div/p[2]")));
		
	}catch(Exception e)		{ 		System.out.println("msrpElements"); 		}		return elements;	}
	public static WebElement pricedesc(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='price-desc']")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("pricedesc"); 		}		return element;	}
	public static WebElement kellyblue(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//img[@class='kbb-icon']")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("kellyblue"); 		}		return element;	}
	public static WebElement pricepledge(WebDriver driver)
	{ try{
		 WebDriverWait wait=new WebDriverWait(driver,90);
		 element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary-container ng-scope']/div[@class='our-pledge row grey-bar']/div/img")));
		libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("pricepledge"); 		}		return element;	}
	public static WebElement vehicleHeading(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='intro-vehicle row']/h2")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("vehicleHeading"); 		}		return element;	}
	public static List<WebElement> vehicletitle(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90); 
		List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='vehicle-title']/p")));
		
	}catch(Exception e)		{ 		System.out.println("vehicletitle"); 		}		return elements;}
	public static WebElement detailFooter(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='vin-detail-container ng-scope']/div[@class='detail-footer row']")));
	   libs.HighlightElement(driver, element);		return element;	
	}catch(Exception e)		{ 		System.out.println("detailFooter"); 		}		return element;	}
	public static List<WebElement> msrpElements1(WebDriver driver,int dRw)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		 elements=driver.findElements(By.xpath("//div[@id='vdp-price-summary']//tr//td[@class='ng-binding']"));
		
	}catch(Exception e)		{ 	
		System.out.println("msrpElements1"); 		}	
	return elements;	}
	public static List<WebElement> msrpElementsLabel(WebDriver driver,int dRw)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='vdp-price-summary']//tr//th")));
		return elements;
	}catch(Exception e)		{ 		System.out.println("msrpElementsLabel"); 		}		return elements;}
	public static WebElement pricedesc1(WebDriver driver)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='price-desc']")));
		libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("pricedesc1"); 		}		return element;	}
	public static List<WebElement> footermsrpelements1(WebDriver driver,int dRw)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='popup popover-container']/div/div")));
		
	}catch(Exception e)		{ 		System.out.println("footermsrpelements1"); 		}		return elements;	}
	public static List<WebElement> footermsrpelements2(WebDriver driver,int dRw)
	{ try{
		elements=driver.findElements(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[2]/div/div/p[2]"));
		
	}catch(Exception e)		{ 		System.out.println("footermsrpelements2"); 		}		return elements;	}
	public static List<WebElement> footermsrpelements3(WebDriver driver,int dRw)
	{ try{
		elements=driver.findElements(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[2]/div[3]/div[8]/div/p[2]"));
		
	}catch(Exception e)		{ 		System.out.println("footermsrpelements3"); 		}		return elements;	}

	public static WebElement btn_nexvalueyourtradein (WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("(//a[@data-ng-click='nextTab()'])[position()=1]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("btn_nexvalueyourtradein"); 		}		return element;	}

	public static WebElement txt_YourVechicleHeading0 (WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@class='intro-vehicle row']//h2"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_YourVechicleHeading0"); 		}		return element;	}
	
	
	public static WebElement txt_YourVechicleHeading1 (WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@class='vehicle-title']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_YourVechicleHeading1"); 		}		return element;	}
	
	public static WebElement txt_YourVechicleHeading2 (WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@class='dealer-info']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_YourVechicleHeading2"); 		}		return element;	}
	
	
	
	public static List<WebElement> txt_yourVechicleLabel(WebDriver driver,int dRw)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='vdp-vehicle-info']//div[@class='vehicle-info']//p[1]")));
	
	}catch(Exception e)		{ 		System.out.println("txt_yourVechicleLabel"); 		}		return elements;	}
	public static List<WebElement> txt_yourVechicleValue(WebDriver driver,int dRw)
	{ try{
		WebDriverWait wait=new WebDriverWait(driver,90);
		elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='vdp-vehicle-info']//div[@class='vehicle-info']//p[2]")));
		
	}catch(Exception e)		{ 		System.out.println("txt_yourVechicleValue"); 		}		return elements;	}
	public static WebElement btn_deleteDeal(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("(//span[@class='vehicle-delete'])[position()=1]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("btn_deleteDeal"); 		}		return element;	}
	public static WebElement btn_deleteDeal_Cancel(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//button[@class='btn btn-default']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("btn_deleteDeal_Cancel"); 		}		return element;	}
	public static WebElement lnk_VieWindowSticker(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//a[@data-ng-click='windowSticker($event)']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("lnk_VieWindowSticker"); 		}		return element;	}
	public static WebElement lnk_VieWindowSticker_PDF(WebDriver driver)
	{ try{
			element = 	driver.findElement(By.id("plugin"));
			libs.HighlightElement(driver, element);	
		}catch(Exception e){
			System.out.println("lnk_VieWindowSticker_PDF");
			}
			return element;
	
	}
	public static WebElement txt_BottomText(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("(//p[@class='ng-binding'])[position()=11]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_BottomText"); 		}		return element;	}
	public static WebElement txt_YourEstimatedPretax(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@class='price-desc']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_YourEstimatedPretax"); 		}		return element;	}
	public static WebElement txt_KellyBlue(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@id='vdp-price-advisor-w-cta']//p"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_KellyBlue"); 		}		return element;	}
	public static WebElement img_KellyBlue(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//img[@class='kbb-icon']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("img_KellyBlue"); 		}		return element;	}
	
	public static WebElement img_ourpledge(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//img[@class='icon']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("img_ourpledge"); 		}		return element;	}
	
	public static WebElement txt_ourpledge_Heading(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@class='our-pledge row grey-bar']//h2"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_ourpledge_Heading"); 		}		return element;	}
	
	public static WebElement txt_ourpledge_Desc(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@class='pledge-description']//p"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_ourpledge_Desc"); 		}		return element;	}

	public static WebElement Btn_comparePrice(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//button[@class='btn btn-kbb']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("Btn_comparePrice"); 		}		return element;	}
	
	public static WebElement Btn_comparePrice_close(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//button[@class='close']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("Btn_comparePrice_close"); 		}		return element;	}
	
	public static WebElement txt_YourPricingSummary(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@class='intro-summary row']//h2"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_YourPricingSummary"); 		}		return element;	}
	public static WebElement txt_Zipcode(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("(//span[@class='zip-code-input']//input)[position()=1]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("txt_Zipcode"); 		}		return element;	}
	public static WebElement lnk_Mapview(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//p[@class='dealer-info']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("lnk_Mapview"); 		}		return element;	}
	public static WebElement lnk_Mapview_Close(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("//div[@data-ng-click='close()']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("lnk_Mapview_Close"); 		}		return element;	}
	
	public static WebElement error_Zipcode(WebDriver driver)
	{ try{
	element = 	driver.findElement(By.xpath("(//p[@data-ng-if='zipCodeError'])[position()=1]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("error_Zipcode"); 		}		return element;	}
}
