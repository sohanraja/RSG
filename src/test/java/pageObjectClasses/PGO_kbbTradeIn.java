package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraryClasses.FuncitonLibrary;

public class PGO_kbbTradeIn extends FuncitonLibrary {
	
	private static WebElement element = null;
	private static List<WebElement> elements=null;
	public static FuncitonLibrary libs = new FuncitonLibrary();
//	Below are the POs for kbbTradeIn functionality

	public static WebElement btn_next_valueTradeIn_continue (WebDriver driver)
	{
		try{	element = driver.findElement(By.xpath("//*[@class='col-xs-4 col-sm-4 next-button']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("btn_next_valueTradeIn_continue");
		}
		return element;
	}
	public static WebElement btn_enterVehicleInfo (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//button[text()='Enter Vehicle Info']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("btn_enterVehicleInfo");
		}return element;
	}
	public static WebElement img_kbbBlueLogo (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//img[@src='/content/dam/shop_ford/en_us/buy/logos/kbb_blue.png']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("img_kbbBlueLogo");
		}return element;
	}
	public static WebElement img_kbbBlueLogoCndVl (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='viewThree kbbBkgLt']/div/img"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("img_kbbBlueLogoCndVl");
		}return element;
	}
	public static WebElement img_kbbBlueLogoTrdSmmry (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='viewFour kbbBkgLt']/div/img"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("img_kbbBlueLogoTrdSmmry");
		}return element;
	}
	
	public static WebElement txt_kbbcndvalsubhdng1 (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='kbb-container clearfix']/h4[1]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_kbbcndvalsubhdng1");
		}return element;
	}
	public static WebElement txt_kbbcndvalsubhdng2 (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='kbb-container clearfix']/h4[2]"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_kbbcndvalsubhdng2");
		}return element;
	}
	public static WebElement a1_suplink (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='kbb-container clearfix']/h4[2]/a"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("a1_suplink");
		}return element;
	}
	
	public static WebElement lbl_kbbMileage (WebDriver driver, String  label)
	{
			try{ element = driver.findElement(By.xpath("//label [@for='"+label+"']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("lbl_kbbMileage");
		}return element;
	}
	
	public static WebElement txt_kbbMileageErr (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div [@class='kbb-input']/p[1]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_kbbMileageErr");
		}return element;
	}
	public static WebElement txt_kbbZipErr (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div [@class='finalSpacer kbb-input']/p[1]"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_kbbZipErr");
		}return element;
	}
	public static WebElement wizTab_kbbBreadCrumb (WebDriver driver, int  bc)
	{
			try{ element = driver.findElement(By.xpath("//div[@class ='kbbBreadcrumb']/ul/li['"+bc+"']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("wizTab_kbbBreadCrumb");
		}return element;
	}
	
	
	public static WebElement txt_change (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//span[@class='change-trade-in']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_change");
		}return element;
	}
	public static WebElement txt_delete (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//span[@class='delete-trade-in']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_delete");
		}return element;
	}
	public static WebElement txt_kbbYearSelect (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//select[@id ='kbbYearSelect']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_kbbYearSelect");
		}return element;
	}
	public static WebElement txt_kbbMakeSelect (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//select[@id ='kbbMakeSelect']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_kbbMakeSelect");
		}return element;
	}
	public static WebElement txt_kbbModelSelect (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//select[@id ='kbbModelSelect']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_kbbModelSelect");
		}return element;
	}
	public static WebElement txt_kbbTrimSelect (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//select[@id ='kbbTrimSelect']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_kbbTrimSelect");
		}return element;
	}
	public static WebElement txt_kbbMileageInput (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//input[@id ='kbbMileageInput']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_kbbMileageInput");
		}return element;
	}
	public static WebElement txt_kbbZipInput (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//input[@id ='kbbZipInput']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_kbbZipInput");
		}return element;
	}
	public static WebElement btn_vehicleInfo_Continue (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//a[@class='btn btn-dre nextTab hidden-sm hidden-xs pull-right ng-binding']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("btn_vehicleInfo_Continue");
		}return element;
	}
	//add option page
	public static WebElement txt_vehicleInfo_secondaryHead (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//h3[@class='secondaryHead ng-binding']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_vehicleInfo_secondaryHead");
		}return element;
	}
	public static WebElement txt_addOptionslftClmn (WebDriver driver,int i)
	{
			try{ element = driver.findElement(By.xpath("//div[@class ='viewTwo kbbBkgLt']/div[3]//div/div/div[1]/div["+i+"]/div/h4"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_addOptionslftClmn");
		}return element;
	}
	public static WebElement txt_addOptionsRghtClmn (WebDriver driver, int i)
	{
			try{ element = driver.findElement(By.xpath("//div[@class ='viewTwo kbbBkgLt']/div[3]//div/div/div[2]/div["+i+"]/div/h4"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_addOptionsRghtClmn");
		}return element;
	}

	public static WebElement txt_addOptionsdsclm1Zipcd  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/p/strong"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_addOptionsdsclm1Zipcd");
		}return element;
	}
	public static WebElement txt_addOptionsdsclm2Zipcd  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p/strong"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_addOptionsdsclm2Zipcd");
		}return element;
	}

	public static WebElement txt_addOptionsdsclm1  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/p"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_addOptionsdsclm1");
		}return element;
	}
	public static WebElement txt_addOptionsdsclm2  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_addOptionsdsclm2");
		}return element;
	}
	public static WebElement chxbox_safetyAndSecurity (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//span[contains(text(),'Parking Sensors')]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("chxbox_safetyAndSecurity");
		}return element;
	}
	public static WebElement radio_exteriorColor (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//span[contains(text(),'Black')]"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("radio_exteriorColor");
		}return element;
	}

	public static WebElement txt_TradeInSmmrydsclm1  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//*[@id='kbbCustomDisc']"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_TradeInSmmrydsclm1");
		}return element;
	}
	public static WebElement txt_TradeInSmmrydsclm2  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[1]/div[4]/div/ul/li[2]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_TradeInSmmrydsclm2");
		}return element;
	}
	public static WebElement txt_TradeInSmmrydsclm3  (WebDriver driver, int i)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[1]/div[4]/p["+i+"]"));
	libs.HighlightElement(driver, element);
	}catch(Exception e){		
		System.out.println("txt_TradeInSmmrydsclm3");
		} return element;
	}
	public static WebElement txt_TradeInSmmrydsclm6  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[1]/div[4]/p[1]/span"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txt_TradeInSmmrydsclm6");
		}return element;
	}public static WebElement txt_TradeInSmmrydsclm7  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/p"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_TradeInSmmrydsclm7");
				}return element;
	}
	public static WebElement txt_TradeInSmmrydsclm8  (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_TradeInSmmrydsclm8");
				}return element;
	}
	public static WebElement radio_exterior (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//span[contains(text(),'Running Boards')]"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("radio_exterior");
				}return element;
	}
	public static WebElement radio_wheelsAndTires (WebDriver driver)
	{
			try{ element = driver.findElement(By.xpath("//span[contains(text(),'Oversized Premium Wheels')]"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("radio_wheelsAndTires");
				}return element;
	}
	public static WebElement btn_addOptions_continue (WebDriver driver)
	{
		try{
		
		switch(applicationname){
		
		case "RSG": 		element = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
							break;
		case "CTP":			element = driver.findElement(By.xpath("//A[@class='btn btn-dre nextTab hidden-sm hidden-xs pull-right ng-binding'][text()='Continue']"));
							break;
						
	}
		
		
		
		
		//element = driver.findElement(By.xpath("//a[@class='btn btn-dre nextTab hidden-sm hidden-xs pull-right ng-binding']"));   
		//element = driver.findElement(By.xpath("//a[@class ='btn btn-dre nextTab visible-sm visible-xs pull-right']"));
	libs.HighlightElement(driver, element);
		}catch(Exception e){		
			System.out.println("btn_addOptions_continue");
			}return element;
	}
	//Trade in Vehicle conditions page
	public static WebElement txt_chooseAcondition_Heading (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//h4[@class='col-xs-5']"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_chooseAcondition_Heading");
				}return element;
	}
	public static WebElement txt_kellyTradeInPriceRange_Heading (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//h4 [@class='col-xs-7 text-right']"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_kellyTradeInPriceRange_Heading");
				}return element;
	}
	public static WebElement txt_vehicleCondition (WebDriver driver, int i)
	{
			try{element = driver.findElement(By.xpath("//div[@class='conditions ng-scope']/accordion/div/div["+i+"]/div[1]/h4/a/div/div[1]/div[1]/span"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_vehicleCondition");
				}return element;
	}
	public static WebElement radio_vehicleCondition (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='conditions ng-scope']/accordion/div/div[1]/div[1]/h4/a/div/div[1]/div[1]/div[@class='radio']/label"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("radio_vehicleCondition");
				}return element;
	}
	public static WebElement txt_vehicleConditionline2 (WebDriver driver, int i)
	{
			try{element = driver.findElement(By.xpath("//div[@class='conditions ng-scope']/accordion/div/div["+i+"]/div[1]/h4/a/div/div[2]/div/div[1]/p"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_vehicleConditionline2");
				}return element;
	}
	public static WebElement txt_vehicleConditionline3 (WebDriver driver, int i)
	{
			try{element = driver.findElement(By.xpath("//div[@class='conditions ng-scope']/accordion/div/div["+i+"]/div[1]/h4/a/div/div[2]/div/div[2]/p"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_vehicleConditionline3");
				}return element;
	}
	
	public static WebElement txt_kbbTrdinRange (WebDriver driver, int i)
	{
			try{element = driver.findElement(By.xpath("//div[@class='conditions ng-scope']/accordion/div/div["+i+"]/div[1]/h4/a/div/div[1]/div[2]/p"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_kbbTrdinRange");
				}return element;
	}
	
	
//	public static WebElement accordion_vehicleCondition (WebDriver driver)
//	{
//			element = driver.findElement(By.xpath("//p[contains(text(),'23% of all cars valued by Kelley Blue Book®')]"));
//	libs.HighlightElement(driver, element); return element;
//	}
//	public static WebElement radio_vehicleCondition (WebDriver driver)
//	{
//			element = driver.findElement(By.xpath("(//div[@class='radio'])[last()-5]"));
//	libs.HighlightElement(driver, element); return element;
//	}
	public static WebElement accordion_vehicleCondition1 (WebDriver driver,int i)
	{
			try{element = driver.findElement(By.xpath("//div[@class='conditions ng-scope']/accordion/div/div["+i+"]/div[1]/h4/a/div/div[2]/div/div[1]/p"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("accordion_vehicleCondition1");
				}return element;
	}
	public static WebElement href_chngVhcl(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='viewThree kbbBkgLt']/div[2]/div/h3/span/span[1]"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("href_chngVhcl");
				}return element;
	}
	public static WebElement href_chngVhclTrdInSmmry(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='viewFour kbbBkgLt']/div[2]/h3/span/span[1]"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("href_chngVhclTrdInSmmry");
		}return element;
	}
	public static WebElement txt_vhclcndDtl(WebDriver driver,int i, int j)
	{
			try{element = driver.findElement(By.xpath("//div[@class='conditions ng-scope']/accordion/div/div["+i+"]/div[2]/div/div/ul/li["+j+"]/p"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_vhclcndDtl");
				}return element;
	}
	public static WebElement txtEntrOwnVal(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("	//div[@class='col-xs-11']/ul/li[1]"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txtEntrOwnVal");
				}return element;
	}
	public static WebElement txtkbbResponseTotal(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("	//div[@class='row kbbResponseTotal']/h3/div[1]/p"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txtkbbResponseTotal");
				}return element;
	}
	
	
	public static WebElement txtkbbResponseTotalAskPrc(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("	//div[@class='row kbbResponseTotal askingPrice']/h3/div[1]"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txtkbbResponseTotalAskPrc");
				}return element;
	}
	
	public static WebElement txtEntrOwnValDsclmr(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='col-xs-11']/ul/li[1]/sup"));
	libs.HighlightElement(driver, element); 
	}catch(Exception e){		
		System.out.println("txtEntrOwnValDsclmr");
		}
			return element;
	}
	public static WebElement txtEntrExp(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='col-xs-11']/ul/li[3]/p"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txtEntrExp");
				}return element;
	}
	public static WebElement txtEntrExpDsclmr(WebDriver driver)
	{
		try{
			switch(applicationname){
			
			case "RSG": 			element = driver.findElement(By.xpath("//div[@class='col-xs-11']/ul/li[3]/p/sup"));
								break;
			case "CTP":			element = driver.findElement(By.xpath("(//SUP[text()='26'][text()='26'])[position()=1]"));
								break;
							
		}
			
			
	libs.HighlightElement(driver, element);
		}catch(Exception e){		
			System.out.println("txtEntrExpDsclmr");
			}return element;
	}
	
	public static WebElement txt_subBottomDsclmr(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[1]/div[3]/p"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_subBottomDsclmr");
				}return element;
	}
	public static WebElement txt_subBottomDsclmr1(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/p"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_subBottomDsclmr1");
				}return element;
	}
	
	public static WebElement txt_subBottomDsclmr2(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_subBottomDsclmr2");
				}return element;
	}
	public static WebElement txt_subBottomDsclmrSup(WebDriver driver, int i)
	{
		try{	
			switch(applicationname){
			
			case "RSG": 		element = element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p/sup["+i+"]"));
								break;
			case "CTP":			element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p/a["+i+"]"));
								break;
							
		}
			
	libs.HighlightElement(driver, element);
		}catch(Exception e){		
			System.out.println("txt_subBottomDsclmrSup");
			}return element;
	}
	
//	public static WebElement txt_supHdr(WebDriver driver, int i)
//	{
//			element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p/div["+i+"]/h3"));
//	libs.HighlightElement(driver, element); return element;
//	}
	public static WebElement txt_supHdr(WebDriver driver)
	{
		try{
			switch(applicationname){
			
			case "RSG": 		element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p/div/h3"));
								break;
			case "CTP":			element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p/a/sup[1]"));
								break;
							
		}
			
	libs.HighlightElement(driver, element); 
		}catch(Exception e){		
			System.out.println("txt_supHdr");
			}return element;
	}
	public static WebElement btn_nextpayment(WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//a[contains(text(),'Next: Payment')]"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("btn_nextpayment");
				}return element;
	}
	
	public static WebElement txt_supHdrDtl(WebDriver driver)
	{
			try{
				switch(applicationname){
			
			case "RSG": 		element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p/div/div[2]/div[2]/p"));
								break;
			case "CTP":			element = driver.findElement(By.xpath("//div[@class='subBottomDisclaimer section']/section/div[3]/div/p/a/sup[2]"));
								break;
							
		}
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_supHdrDtl");
				}return element;
	}
	
	
	public static WebElement chxbox_ownPrice (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//input[@name='customCondition']"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("chxbox_ownPrice");
				}return element;
	}
	public static WebElement txt_KellyEffectiveDates (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//p[@class='ng-binding' and contains(.,' Effective dates')]"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_KellyEffectiveDates");
				}return element;
	}
	
	public static WebElement txt_vehicleOwnValue (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//input[@id ='customPrice']"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_vehicleOwnValue");
				}return element;
	}
	public static WebElement  txt_vehicleConditionExplain (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//textarea[@class= 'ng-pristine ng-valid']"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_vehicleConditionExplain");
				}return element;
	}
	public static WebElement btn_vehicleCondition_continue (WebDriver driver)
	{
		try{element = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
			//element = driver.findElement(By.xpath("//a[@class ='btn btn-dre nextTab visible-sm visible-xs pull-right']"));
			//element = driver.findElement(By.xpath("btn btn-dre nextTab hidden-sm hidden-xs pull-right ng-binding"));
	libs.HighlightElement(driver, element); 
		}catch(Exception e){		
			System.out.println("btn_vehicleCondition_continue");
			}return element;
	}
	public static WebElement txt_kbbResponseMilage (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//input[@name ='kbbResponseMilage']"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_kbbResponseMilage");
				}return element;
	}
	public static WebElement txt_kbbResponseCondition (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//select[@name ='kbbResponseCondition']"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_kbbResponseCondition");
				}return element;
	}
	public static WebElement icon_kbbResponseCondition (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//a[@data-original-title='Kelley Blue Book® Condition Definitions']"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("icon_kbbResponseCondition");
				}return element;
	}
	public static WebElement txt_kbbResponseCondition_title (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//h3[@class ='popover-title']"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_kbbResponseCondition_title");
				}return element;
	}
	public static WebElement txt_kbbTradeInValue (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='col-md-3 col-sm-12 text-right ng-binding']"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_kbbTradeInValue");
				}return element;
	}
	
	public static WebElement txt_kbbCustomDisc (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//*[@id='kbbCustomDisc']"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("txt_kbbCustomDisc");
				}return element;
	}
	public static WebElement txt_kbbStandardDisc (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//p[@class='ng-binding' and contains(.,' Edition')]"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_kbbStandardDisc");
				}return element;
	}
	
	public static WebElement btn_next_Payment_continue (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//a[contains(text(),'Next: Payment')]"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("btn_next_Payment_continue");
				}return element;
	}
	public static WebElement txt_kbbResponseTotal (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div [@class='row kbbResponseTotal']/h3/div[2]"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_kbbResponseTotal");
				}return element;
	}
	
	public static WebElement txt_kbbResponseTotalAskPrc (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div [@class='row kbbResponseTotal askingPrice']/h3/div[2]"));
	libs.HighlightElement(driver, element);
			}catch(Exception e){		
				System.out.println("txt_kbbResponseTotalAskPrc");
				}return element;
	}
	
			public static WebElement btn_SkipKBB (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//button[@class='btn btn-default introSkip']"));
	libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("btn_SkipKBB");
				}return element;
	}
			public static WebElement img_KBBlogo (WebDriver driver)
	{
			//element = driver.findElement(By.xpath("//*[@id='usedCarTradeInLocation']"));
			try{element = driver.findElement(By.xpath("//*[@id='usedCarTradeInLocation_marketMeterCanvas']"));	
				
			libs.HighlightElement(driver, element); 
			}catch(Exception e){		
				System.out.println("img_KBBlogo");
				}return element;
	}
	// Trade in summary KBB widget elements
			public static WebElement txt_kbbWidget (WebDriver driver)
			{
					try{element = driver.findElement(By.xpath("//*[@id='kbbWidget']"));			
			libs.HighlightElement(driver, element); 
					}catch(Exception e){		
						System.out.println("txt_kbbWidget");
						}return element;
			}	
			public static WebElement txt_kbbWidgetHdng (WebDriver driver)
			{
					try{element = driver.findElement(By.xpath("//*[@id='usedCarTradeInLocation']/div[4]/div/div[2]/div[2]/div[1]/p[1]"));			
			libs.HighlightElement(driver, element);
					}catch(Exception e){		
						System.out.println("txt_kbbWidgetHdng");
						}return element;
			}	
			public static WebElement txt_kbbWidgetHdng1 (WebDriver driver)
			{
					try{element = driver.findElement(By.xpath("//*[@id='usedCarTradeInLocation']/div[4]/div/div[2]/div[2]/div[1]/p[2]"));			
			libs.HighlightElement(driver, element);
					}catch(Exception e){		
						System.out.println("txt_kbbWidgetHdng1");
						}return element;
			}	
			public static WebElement txt_kbbWidgetHdnga (WebDriver driver,int i, int j)
			{
					try{element = driver.findElement(By.xpath("//*[@id='usedCarTradeInLocation']/div[4]/div/div[2]/div[2]/div["+i+"]/div[2]/p["+j+"]"));			
			libs.HighlightElement(driver, element);
					}catch(Exception e){		
						System.out.println("txt_kbbWidgetHdnga");
						}return element;
			}	
			public static List<WebElement> txt_kbbWidgetHdngb (WebDriver driver, int i)
			{
			try{	List<WebElement> elements = driver.findElements(By.xpath("//*[@id='usedCarTradeInLocation']/div[4]/div/div[2]/div[2]/div["+i+"]/div[2]/ul/li"));			
			}catch(Exception e){		
				System.out.println("txt_kbbWidgetHdngb");
				}return elements;
			}	
			public static WebElement txt_kbbWidgetHdngbDtl (WebDriver driver, int i,int j)
			{
				try{element = driver.findElement(By.xpath("//*[@id='usedCarTradeInLocation']/div[4]/div/div[2]/div[2]/div["+i+"]/div[2]/ul/li["+j+"]"));			
			libs.HighlightElement(driver, element);
				}catch(Exception e){		
					System.out.println("txt_kbbWidgetHdngbDtl");
					}return element;
			}
			public static WebElement txt_kbbWidgetHdngc (WebDriver driver)
			{
					try{element = driver.findElement(By.xpath("//*[@id='usedCarTradeInLocation']/div[4]/div/div[2]/div[2]/div[11]/p[2]"));			
			libs.HighlightElement(driver, element);
					}catch(Exception e){		
						System.out.println("txt_kbbWidgetHdngc");
						}return element;
			}	
			public static WebElement close_kbbWidget (WebDriver driver)
			{
					try{element = driver.findElement(By.xpath("//*[@id='usedCarTradeInLocation']/div[4]/div/div[1]"));			
			libs.HighlightElement(driver, element); 
					}catch(Exception e){		
						System.out.println("close_kbbWidget");
						}return element;
			}	
			
			public static WebElement icon_KBBtxtHdngBld(WebDriver driver)
			{
					try{element = driver.findElement(By.xpath("//a[@ class='conditioniBall dreicon icon-uniE630']"));			
			libs.HighlightElement(driver, element);
					}catch(Exception e){		
						System.out.println("icon_KBBtxtHdngBld");
						}return element;
			}
			public static WebElement icon_KBBtxthdng(WebDriver driver,int i)
			{
					try{element = driver.findElement(By.xpath("//div[@class='conditions']/accordion/div/div["+i+"]/div[1]/h4/a/div/div[1]/div[1]/span"));			
			libs.HighlightElement(driver, element); 
					}catch(Exception e){		
						System.out.println("icon_KBBtxthdng");
						}return element;
			}
			public static WebElement icon_KBBtxthdngdtl(WebDriver driver,int i, int j)
			{
					try{element = driver.findElement(By.xpath("//div[@class='conditions']/accordion/div/div["+i+"]/div[1]/h4/a/div/div[2]/div[1]/div["+j+"]/p"));			
			libs.HighlightElement(driver, element);
					}catch(Exception e){		
						System.out.println("icon_KBBtxthdngdtl");
						}return element;
			}
			
			public static WebElement KBBTradeInTab (WebDriver driver)
			{
				try{WebDriverWait wait=new WebDriverWait(driver,5);
				WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='single-tab trade-in active']")));
			   libs.HighlightElement(driver, element);	libs.HighlightElement(driver, element);
				}catch(Exception e){		
					System.out.println("KBBTradeInTab");
					}return element;
			}	
			public static WebElement KbbVerification(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//ul[@class='tab-list']/li[@class='single-tab trade-in active']/a[@class='tab2 trade-in']"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("KbbVerification");
					}return element;
			} 
			
			public static WebElement Kbbradiobutton(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("(//div[@class='radio']//label)[position()=24]"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("Kbbradiobutton");
					}return element;
			} 
			
			public static WebElement kbbHomePageHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class='viewEntry kbbBkgDk']//h2"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbHomePageHeader");
					}return element;
			}
			
			public static WebElement kbbVehicleInfoPageHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class='topData text-center']//h2"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbVehicleInfoPageHeader");
					}return element;
			}
			public static WebElement kbbAddOptionPageHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class='viewTwo kbbBkgLt']//h2"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbAddOptionPageHeader");
					}return element;
			}
			public static WebElement kbbConditionValuePageHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class='span12']//h2"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbConditionValuePageHeader");
					}return element;
			}
			public static WebElement kbbSummaryPageHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class='viewFour kbbBkgLt']//h2"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbSummaryPageHeader");
					}return element;
			}
			public static WebElement kbbSummaryPageSubHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class='viewFour kbbBkgLt']//h3"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbSummaryPageSubHeader");
					}return element;
			}
			public static WebElement kbbConditionValuePageSubHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class='span12']//h3"));	
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbConditionValuePageSubHeader");
					}return element;
			}
			public static WebElement kbbHomePageSubHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class='sub-head']"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbHomePageHeader");
					}return element;
			}
			public static WebElement kbbHomePageFooter(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'subBottomDisclaimer section']//div[@class = 'row']//p[@class = 'ng-binding']"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbHomePageFooter");
					}return element;
			}
			public static WebElement kbbConditionValuePageCommonFooter(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//section[@class= 'container-fluid mainText ng-scope']//div[@class = 'row']//p[@class = 'ng-binding']"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbHomePageHeader");
					}return element;
			}
			
			public static WebElement kbbVehicelInfoPageSubHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//h5[@class = 'ng-binding']"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbHomePageHeader");
					}return element;
			}
			public static WebElement kbbTradeInPageHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'viewTwo kbbBkgLt']//h3"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbHomePageHeader");
					}return element;
			}
			public static WebElement kbbAddOptionPageSubHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'viewTwo kbbBkgLt']//h4"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbAddOptionPageSubHeader");
					}return element;
			}
			
			public static WebElement kbbTradeInPageSubHeader(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//h4"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbHomePageHeader");
					}return element;
			}
			public static WebElement kbbTradeInSummaryPageFooter(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'kbb-container conditions-disclaimer row']"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbTradeInSummaryPageFooter");
					}return element;
			}
			
			public static WebElement kbbConditionValuePageFooter(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'subBottomDisclaimer section']//div[@class = 'kbb-container conditions-disclaimer row']//p"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbConditionValueyPageFooter");
					}return element;
			}
			public static List<WebElement> arw_radioarrow (WebDriver driver)
			{
			try{	elements = driver.findElements(By.xpath("//i[contains(@class , 'dreicon bold-font heavy-font icon-uni')]"));			
			}catch(Exception e){		
				System.out.println("arw_radioarrow");
				}return elements;
			}
			
			public static List<WebElement> txt_radiodesc (WebDriver driver)
			{
			try{	 elements = driver.findElements(By.xpath("//div[@class = 'panel-group']//div[@class = 'kbb-container clearfix ng-scope']"));			
			}catch(Exception e){		
				System.out.println("txt_radiodesc");
				}return elements;
			}
			public static WebElement kbbChooseConditiontxt(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//h4[contains(@class, 'choose-condition-text')]"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbChooseConditiontxt");
					}return element;
			}
			public static WebElement kbbtxt(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//h4[contains(@class, 'text-right value-range-text')]"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbtxt");
					}return element;
			}
			public static WebElement kbbVehicleChoosed(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'kbb-container clearfix']//p"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbVehicleChoosed");
					}return element;
			}
			public static WebElement kbbEnterOwnDealOption(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'row custom-no-margin']//h4"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbEnterOwnDealOption");
					}return element;
			}
			
			public static WebElement kbbEnterOwnDealOptionCheckBox(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//span[@class = 'checkbox-wrapper']"));			
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbEnterOwnDealOptionCheckBox");
					}return element;
			}
			
			public static WebElement kbbEnterOwnValueTxtBox(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//input[@id = 'customPrice']"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbEnterOwnValueTxtBox");
					}return element;
			}
			public static WebElement kbbSummaryPageImg(WebDriver driver)
			{
				
				try{element = driver.findElement(By.xpath("//canvas[@id='usedCarTradeInLocation_marketMeterCanvas']"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbSummaryPageImg");
					}return element;
			}
			public static WebElement kbbSummaryPageMileage(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'summary-info kbbResponseList']//div[@class ='row']//p"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbSummaryPageMileage");
					}return element;
			}
			public static WebElement kbbSummaryPageMileageValue(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'summary-info kbbResponseList']//div[@class ='row']//b"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbSummaryPageMileageValue");
					}return element;
			}
			public static WebElement kbbSummaryPagecondition(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'summary-info kbbResponseList']//div[@class ='row ng-scope']//p"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbSummaryPagecondition");
					}return element;
			}
			public static WebElement kbbSummaryPageconditionValue(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath(""));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbSummaryPageconditionValue");
					}return element;
			}
			public static WebElement kbbResponseTotalTxt(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'row kbbResponseTotal ng-scope']//p"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbResponseTotalTxt");
					}return element;
			}
			public static WebElement kbbResponseTotalTxtValue(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'row kbbResponseTotal ng-scope']//div[contains(@class , 'text-right ng-binding')]"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbResponseTotalTxtValue");
					}return element;
			}
			public static WebElement kbbSummaryPageparticipatingDealer(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath(""));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("kbbSummaryPageparticipatingDealer");
					}return element;
			}
			
			public static WebElement link_Change(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'viewFour kbbBkgLt']//span[@class = 'change-trade-in']"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("link_Change");
					}return element;
			}
			
			public static WebElement link_Delete(WebDriver driver)
			{
				try{element = driver.findElement(By.xpath("//div[@class = 'viewFour kbbBkgLt']//span[@class = 'delete-trade-in']"));
				libs.HighlightElement(driver, element); 
				}catch(Exception e){		
					System.out.println("link_Delete");
					}return element;
			}
			
			
}
