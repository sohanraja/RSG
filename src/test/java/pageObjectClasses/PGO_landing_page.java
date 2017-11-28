package pageObjectClasses;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import libraryClasses.FuncitonLibrary;

public class PGO_landing_page extends FuncitonLibrary {
	private static List<WebElement> element1 = null;
	private static WebElement element = null;
//	Below are the POs for Landing Page functionality
	//close of popup
	public static   FuncitonLibrary libs = new FuncitonLibrary();
	public WebElement btn_nopopup (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//img[@name='IPEClose']"));			
			libs.HighlightElement(driver, element);	
		}catch(Exception e){		
		System.out.println("btn_nopopup");
		}
		return element;
	}
	public WebElement img_fordIcon (WebDriver driver)
	{	
	
	try {element = driver.findElement(By.xpath("//I[@class='secondary-logo']|(//img[@alt='Ford Home'])[position()="+xpathvalue+"]"));

			libs.HighlightElement(driver, element);}catch(Exception e){		
			System.out.println("img_fordIcon");
			}
			return element;
	
	}
	
	public WebElement txt_glblHdr (WebDriver driver)
	{
		try{element = 	driver.findElement(By.xpath("//DIV[@class='row row1']|(//ul[@class='nav navbar-nav'])[position()="+xpathvalue+"]"));
						
			libs.HighlightElement(driver, element);	}catch(Exception e){		
				System.out.println("txt_glblHdr");
			}
			return element;
	}
	
	public static WebElement txt_lpHeader (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//p[@class='logo-container']//img"));

		libs.HighlightElement(driver, element);	}catch(Exception e){		
			System.out.println("txt_lpHeader");
			}
			return element;
		}
			

	public WebElement txt_lpSubHeadline (WebDriver driver)
	{
		try{	element = driver.findElement(By.xpath(".//div[@ class='subheadline']|//div[@class='subheadline']"));
			libs.HighlightElement(driver, element);}catch(Exception e){		
				System.out.println("txt_lpSubHeadline");
			}
			return element;
							

	}
	
	
	public List<WebElement> img_icons (WebDriver driver)
	{

		try{element1 = driver.findElements(By.xpath("//figure|//div[@class='ctp-gallery ctp-gallery--collapsed ctp-gallery--1-4']//div[@class='ctp-gallery__item']"));
	}catch(Exception e){		
		System.out.println("img_icons");
		}
		return element1;
	}

	public WebElement img_txt (WebDriver driver, int i)
	{
		try{	element = driver.findElement(By.xpath("//section[@ class='iconInfo']["+i+"]/figure/figcaption"));
		
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("img_txt");
		}
		return element;
	}
	public WebElement txt_bigHeading (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//div[@class='singleStaticText col-sm-6 right text-align-right']//h2|(//div[@class='singleStaticText col-sm-6 right text-align-right'])[1]"));
				
			
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_bigHeading");
		}
		return element;
	}
	
	public WebElement txt_bigHeadSup (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//span[@class='big-heading']/sup"));
				libs.HighlightElement(driver, element);	}catch(Exception e){		
					System.out.println("txt_bigHeadSup");
				}
				return element;
	}

	
	
	public WebElement txt_pledgePricing (WebDriver driver)
	{
		try{  element = driver.findElement(By.xpath("//div[@class='singleStaticText col-sm-6 right text-align-left']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_pledgePricing");
		}
		return element;
	}
	public WebElement txt_Seekelly (WebDriver driver)
	{
		try{  element = driver.findElement(By.xpath("(//div[@class='singleStaticText col-sm-6 right text-align-right'])[position()=2]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_pledgedsclmr");
		}
		return element;
	}
	
	public WebElement txt_disclosure (WebDriver driver)
	{
		try{	  element = driver.findElement(By.xpath("//SPAN[@class='ng-scope']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_disclosure");
		}
		return element;
	}
	public WebElement txt_disclosureHdr (WebDriver driver, int j)
	{
		try{  element = driver.findElement(By.xpath("//div[@class ='disclosures_list ng-scope']/ul[1]/li["+j+"]/p"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_disclosureHdr");
		}
		return element;
	}
	public WebElement txt_disclosureDtl (WebDriver driver, int j)
	{
		try{  element = driver.findElement(By.xpath("//div[@class ='disclosures_list ng-scope']/ul[1]/li["+j+"]/div/p"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_disclosureDtl");
		}
		return element;
	}
	
	public WebElement txt_BldYourDeal (WebDriver driver)
	{
		try{  element = driver.findElement(By.xpath("(//div[@class = 'singleStaticText col-sm-6 right text-align-right']//h1)[position()=1]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_BldYourDeal");
		}
		return element;
	}

	
	
	
	public WebElement txt_disclosureContent (WebDriver driver)
	{
		try{  element = driver.findElement(By.xpath("//div[@class='disclosures_list ng-scope']/ul[1]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_disclosureContent");
		}
		return element;
	}
	public List<WebElement> txt_suplinks (WebDriver driver)
	{
		try{  element1 = driver.findElements(By.cssSelector("div[class = 'intro-copy'] sup"));
	}catch(Exception e){		
		System.out.println("txt_suplinks");
		}
		return element1;
	}
	

	
	
	public WebElement img_pledgePricing (WebDriver driver)
	{
		try{  element = driver.findElement(By.xpath("//div[@class='desktop-view']//img"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("img_pledgePricing");
		}
		return element;
	}
	public WebElement img_BuildYourDeal (WebDriver driver)
	{
		try{  element = driver.findElement(By.xpath("//img[contains(@src,'48%20hours')]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("img_pledgePricing");
		}
		return element;
	}
	public WebElement img_KelleyBule (WebDriver driver)
	{
		try{  element = driver.findElement(By.xpath("//img[contains(@src,'RSG_HIW_kbb.png')]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("img_pledgePricing");
		}
		return element;
	}
	public static WebElement slct_text(WebDriver driver, String txtVal)
	{
		try{element =driver.findElement(By.xpath("(//div[@class='veh-year-desc-wrap']/strong[contains(text(),'"+txtVal.trim()+"')])[position()="+xpathvalue+"]") );

	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("slct_text");
		}
		return element;
	}
	public static WebElement img_UnexeptedcloseDialog(WebDriver driver)
	{
		try{element = driver.findElement(By.id("IPEClose125930"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("img_closeDialog");
		}
		return element;
	}
	public static WebElement img_closeDialog(WebDriver driver)
	{
		element = driver.findElement(By.cssSelector("div[class = 'modal-dialog'] span[class = 'icon-close']"));
	libs.HighlightElement(driver, element);	return element;	
	}

	public static WebElement slct_href(WebDriver driver, String hrefVal)
	{
		try{element = driver.findElement(By.xpath("//a[contains(@href, 'vin="+hrefVal+"')]"));
	libs.HighlightElement(driver, element);}catch(Exception e){		
		System.out.println("slct_href");
		}
		return element;
	}
	
	
	public WebElement txt_zipCdcntnt (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//input[@ng-model='zipCode.text']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_zipCdcntnt");
		}
		return element;
	}
	public WebElement slct_lnkText (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//BUTTON[@ng-click='chooseVehicle()']|//a[contains(text(),'Choose Vehicle')]"));
			
						
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("slct_lnkText");
		}
		return element;
	}

	public WebElement slct_lnkTextVhcl (WebDriver driver, String lnkName)
	{
		try{element = driver.findElement(By.linkText(lnkName));
	libs.HighlightElement(driver, element);}catch(Exception e){		
		System.out.println("slct_lnkTextVhcl");
		}
		return element;
	}
	public WebElement txt_zipCdErr (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//p[@ class='error text-danger']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_zipCdErr");
		}
		return element;
	}
	
	public WebElement txt_locationCd(WebDriver driver)
	{
		try{	element = driver.findElement(By.xpath("//input[@maxlength='5']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_locationCd");
		}
		return element;
	}	
	public WebElement btn_continue(WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("btn_continue");
		}
		return element;
	}
	public WebElement txt_vehicle_model(WebDriver driver, String hrefVal)
	{
		try{element = driver.findElement(By.xpath("//a[contains(@href, 'vin="+hrefVal+"')]/ancestor::div[@class='vehicle-card-container']/h4 [@class='vehicle-title']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_vehicle_model");
		}
		return element;
	}
	public WebElement txt_viewdtls(WebDriver driver, String hrefVal)
	{
		
		try{element = driver.findElement(By.xpath("/div[@class='vehicle-info']/div[@class='cell']/div[@class='grid-view-btns hidden-print']/a[contains(@href, 'vin="+hrefVal+"')]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_viewdtls");
		}
		return element;
	}
	public WebElement btn_selectrprice(WebDriver driver, String hrefVal)
	{
		try{element = driver.findElement(By.xpath("//a[contains(@href, 'vin="+hrefVal+"')]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("btn_selectrprice");
		}
		return element;
	}
	public WebElement txt_viewdtlsVIN(WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//div[@class='vehicle-vin']/span"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_viewdtlsVIN");
		}
		return element;
	}
	public WebElement txt_addtocompare(WebDriver driver, String hrefVal)
	{
		try{element = driver.findElement(By.xpath("//a[contains(@href, 'vin="+hrefVal+"')]/ancestor::div[@class='vehicle-card-container']/div [@class='vehicle-info']/div/div[6]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_addtocompare");
		}
		return element;
	}

	public WebElement txt_InvldZip(WebDriver driver)
	{
		try{element = driver.findElement(By.cssSelector("body > div.modal.fade.ng-scope.in > div > div > form > div.modal-body > div > p.error.text-danger"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e){		
		System.out.println("txt_InvldZip");
		}
		return element;
	}
	
	public WebElement Welcome_Close(WebDriver driver)
	{
		try{element = driver.findElement(By.id("IPEClose125930"));
	libs.HighlightElement(driver, element);	
	}catch(Exception e){		
		System.out.println("Welcome_Close");
		}
		return element;
	}
	// mobile verison web elements
	
	public WebElement btn_bars_mobile (WebDriver driver)
	{
		try{element = 	driver.findElement(By.xpath("(//span[@class='bars'])[position()=2]"));
			
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("btn_bars_mobile");
		}
		return element;
	}
	public List<WebElement> list_discloser_mobile (WebDriver driver)
	{
		try{  element1 = driver.findElements(By.xpath("//div[@class ='disclosuresContent']//li[@class='disclosure_item']//p"));
	}catch(Exception e){		
		System.out.println("list_discloser_mobile");
		}
		return element1;
	}
	public static WebElement Btn_Delete_Yes(WebDriver driver)
	{
		try{element = driver.findElement(By.cssSelector("(//button[@ng-click='close(true)'])[position()=2]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("Btn_Delete_Yes");
		}
		return element;
	}
	public static WebElement txt_CTP_ZipCode(WebDriver driver)
	{
		try{element = driver.findElement(By.id("siZipCode"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_CTP_ZipCode");
		}
		return element;
	}
	public static WebElement Btn_CTP_ZipCodePopupEnter(WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//div[@class='zip-search-btn']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("Btn_CTP_ZipCodePopupEnter");
		}
		return element;
	}
	public List<WebElement> LandingpageDiscloser (WebDriver driver)
	{
			 try{ element1 = driver.findElements(By.xpath("//div[@class ='disclosuresContent']//li[@class='disclosure_item']//p"));
			 		}catch(Exception e){		
			 			System.out.println("LandingpageDiscloser");
			 		}
			 return element1;
	}
	public static WebElement popup_close (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//button[@class='close']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
			System.out.println("popup_close");
		}
		return element;
	}
	public static WebElement txt_errorMessage(WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//p[@class='error']|//p[@class='error text-danger']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("txt_errorMessage");
		}
		return element;
	}
	public static WebElement btn_ZipPopUpClose(WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//div[@class='icon-close']"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("btn_ZipPopUpClose");
		}
		return element;
	}
	public static WebElement txt_BottomYear(WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//a[@class = 'copyright']|(//div[@class='col-sm-8 col-md-10']//ul//li)[position()=1]"));
	libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("btn_ZipPopUpClose");
		}
		return element;
	}
	public static WebElement btn_PreviousYear(WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//span[@class='veh-type-txt veh-year-btn'][contains(text(),'Previous')]"));
		libs.HighlightElement(driver, element);	}catch(Exception e){		
		System.out.println("btn_ZipPopUpClose");
		}
		return element;
	}
}
