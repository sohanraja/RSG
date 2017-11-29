package pageClasses;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.LogStatus;
public class landing_Page extends rsg_DriverClass
{
FuncitonLibrary libs = new FuncitonLibrary();
Actions actions = new Actions(driver);
public PGO_landing_page PGO_landing_page=new PGO_landing_page();
int SheetNum =2;
String runVal;
String url	;
String CookieURL;
String lpHeaderExp	;
String lpSubHeadlineExp	;
String buildhead;
String buildheadExp	;
String vinNum ;
String locationCd;
String pledgePricingExp;
String pledgedsclmrExp;
String SeeKelly;
String SeeKellyExp;
String zipCdcntntExp;
String dgts4ZipCd;
String Bottom_Year;
public void hwItWrks_run(int dRw) throws Exception
{
         runVal = data.getExcelData(dRw, "Search Vehicle", "Testcases");
	     url	= data.getExcelData(1, "Url", "UtilitySheet");
	     CookieURL=data.getExcelData(1, "Cookie_URL", "UtilitySheet");
		 vinNum = data.getExcelData(dRw,  "VehicleVin", "SearchVehicle");
		 locationCd = data.getExcelData(dRw, "Dealer Code", "SearchVehicle");
		try 
		{
		invokeReport("Verify landingPage",dRw);	
		switch(runVal)
		{
		case "Yes":
//			data.addColumn( "Amount_Calculator1","SearchVehicle");
			AllvalidationForLandingpage(dRw);
//			data.writeToExcel("PASSED", dRw, 5, SheetNum);
//		    billBrdHmPg(dRw);
//			libs.Iballs("EcoBoost");
			searchInventory(dRw);
			test.log(LogStatus.PASS, "Landing Page testcase executed successfully");
			data.writeExceldata(dRw, "Result", "SearchVehicle", "Passed");
			break;
		case "No":
			test.log(LogStatus.INFO, "Landing Page testcase will not be executed");
			data.writeExceldata(dRw, "Result", "SearchVehicle", "Not Executed");
			break;
		 }
		tearReport();
		} 
		catch(Exception E)
		{
			String scrnshtPthNm1="Test Scenario1\\Screenshots\\"+"landing_Failed_"+this.getClass().getSimpleName()+".jpg";
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
			data.writeExceldata(dRw, "Result", "SearchVehicle", "Failed");
            test.log(LogStatus.FAIL, "Failed in Landing page", test.addScreenCapture(scrnshtPthNm1));
        	tearReport();
		}
	}

	public void AllvalidationForLandingpage(int dRw) throws Exception
	{			
	 try
	 {
		libs.getUrlAsVariables(url);
		driver.get(CookieURL);
		driver.get(url);
		test.log(LogStatus.PASS, "Enter the URL", "Application invoked successfully");
		libs.UnexpectedPopup();
		System.out.println("ValidationStatus ::"+ValidationStatus);
		if(ValidationStatus.equalsIgnoreCase("Yes"))
		{
			lpHeaderExp	= data.getExcelData(1, "lpHeaderExp", "SearchVehicle");
			lpSubHeadlineExp	= data.getExcelData(1,"lpSubHeadlineExp", "SearchVehicle");
			buildhead	= data.getExcelData(1, "buildhead","SearchVehicle");
			buildheadExp	= data.getExcelData(1, "buildheadExp", "SearchVehicle");
			pledgePricingExp	= data.getExcelData(1, "pledgePricingExp", "SearchVehicle");
			pledgedsclmrExp	= data.getExcelData(1, "pledgedsclmrExp", "SearchVehicle");
			SeeKelly=data.getExcelData(1, "SeeKelly", "SearchVehicle");
			SeeKellyExp=data.getExcelData(1, "SeeKellyExp", "SearchVehicle");
			zipCdcntntExp=data.getExcelData(1, "zipCdcntntExp", "SearchVehicle");
			dgts4ZipCd=data.getExcelData(dRw, "dgts4ZipCd", "SearchVehicle");
			Bottom_Year=data.getExcelData(1, "Bottom_Year", "SearchVehicle");
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
     		libs.GlobalHeadingBar();
	    	libs.IMGValidation(PGO_landing_page.img_fordIcon(driver), "verify Ford img in Global header", "Ford Image has been displayed in Global Header", "img_fordIcon");
		    libs.VerifyTextwithAttribute(PGO_landing_page.txt_lpHeader(driver), lpHeaderExp, "txt_lpHeader","title");
		    libs.IMGValidation(PGO_landing_page.txt_glblHdr(driver), "verify the global header ", "Global Header has been displayed", "txt_glblHdr");
         	libs.VerifyText(PGO_landing_page.txt_lpSubHeadline(driver), lpSubHeadlineExp, "txt_lpSubHeadline","");
     		// Build your deal blue tab text and image 
	    	buildhead=buildhead+"\n"+buildheadExp;
		    libs.VerifyText(PGO_landing_page.txt_bigHeading(driver), buildhead, "txt_bigHeading","");
		    libs.IMGValidation(PGO_landing_page.img_BuildYourDeal(driver), "Verify the Build your deal Image", "Build your deal Image has been displayed", "img_BuildYourDeal");
		    // Bottom bar year validation
		    libs.GlobalBottomBar();
		    libs.VerifyText(PGO_landing_page.txt_BottomYear(driver), Bottom_Year, "txt_BottomYear", "");
		    libs.Pagedisclaimers("SearchVehicle",2);
		    libs.Disclosers();
		if(applicationname.contains("RSG"))
		{
		//pledge blue tab text and image 
		pledgePricingExp=pledgePricingExp+"\n"+pledgedsclmrExp;
		libs.VerifyText(PGO_landing_page.txt_pledgePricing(driver), pledgePricingExp, "txt_pledgePricing", "");
		libs.IMGValidation(PGO_landing_page.img_pledgePricing(driver), "Verify the Pledge Image", "Pledge image has been displayed", "img_pledgePricing");
		
		//see a kelley blue tab text and image 
		
		SeeKelly=SeeKelly+"\n"+SeeKellyExp;
		libs.VerifyText(PGO_landing_page.txt_Seekelly(driver), SeeKelly, "txt_Seekelly", "");
		libs.IMGValidation(PGO_landing_page.img_KelleyBule(driver), "Verify the Pledge Image", "Pledge image has been displayed", "img_KelleyBule");
		
		// zipce popup validation
		libs.clickOnButton(PGO_landing_page.slct_lnkText(driver), "Choose Vehicle");
		}
		PGO_landing_page.txt_locationCd(driver).clear();
		libs.enterValueIntoTextField(PGO_landing_page.txt_locationCd(driver), "zip code", dgts4ZipCd);
		Thread.sleep(1000);
		libs.clickOnButton(PGO_landing_page.btn_continue(driver), "serch vechile/continue");
		libs.VerifyText(PGO_landing_page.txt_errorMessage(driver),zipCdcntntExp, "Zipcode error message","");
		if(applicationname.contains("RSG")){
		libs.clickOnButton(PGO_landing_page.btn_ZipPopUpClose(driver), "Zip Code close ");
		}
		List<WebElement> icons = PGO_landing_page.img_icons(driver);
		for(int i =1; i<=icons.size();i++)
		{
			String imgiconsname=data.getExcelData(1, "img_icon"+i, "SearchVehicle");
			String imgNote=data.getExcelData(1, "img_Note"+i, "SearchVehicle");
			if(applicationname.contains("RSG"))
			{
				libs.IMGValidation(driver.findElement(By.xpath("(//figure//img)[position()="+i+"]|(//figure//img)[position()="+i+"]")), "Verify the "+imgiconsname+" image", imgiconsname+" image has been displayed", imgiconsname);
				libs.VerifyText(driver.findElement(By.xpath("(//div[@class='ctp-reveal-tile__container']//h5)[position()="+i+"]|(//figure//figcaption)[position()="+i+"]")), imgiconsname, imgiconsname,"");
				libs.VerifyText(driver.findElement(By.xpath("(//div[@class='ctp-reveal-tile__container']//p)[position()="+i+"]|(//figure//p)[position()="+i+"]")), imgNote, imgNote,"");
			}else //if(applicationname.contains("CTP"))
			{
				libs.IMGValidation(driver.findElement(By.xpath("(//figure|//div[@class='ctp-gallery ctp-gallery--collapsed ctp-gallery--1-4']//div[@class='ctp-gallery__item'])[position()="+i+"]")), "Verify the "+imgiconsname+" image", imgiconsname+" image has been displayed", imgiconsname);
				libs.clickOnButton(driver.findElement(By.xpath("(//figure|//div[@class='ctp-gallery ctp-gallery--collapsed ctp-gallery--1-4']//div[@class='ctp-gallery__item'])[position()="+i+"]")), "Click on image");
				libs.VerifyText(driver.findElement(By.xpath("(//figure|//div[@class='ctp-gallery ctp-gallery--collapsed ctp-gallery--1-4']//div[@class='ctp-gallery__item']//h5)[position()="+i+"]")), imgiconsname, imgiconsname,"");
				libs.VerifyText(driver.findElement(By.xpath("(//figure|//div[@class='ctp-gallery ctp-gallery--collapsed ctp-gallery--1-4']//div[@class='ctp-gallery__item']//p)[position()="+i+"]")), imgNote, imgNote,"");
			}
		}	
		}
		}
	 catch(Exception e)
	 {
	  getscrnSht.getscreenshot(driver, scrnshtPth +"BillbrdHmpg_Failed_"+libs.datestamp()+".jpg");
	  test.log(LogStatus.FAIL,"AllvalidationForLandingpage failed " ,test.addScreenCapture(scrnshtPth +"AllvalidationForLandingpage_Failed_"+libs.datestamp()+".jpg") );
	}
	}

	public void searchInventory(int dRw)throws Exception
	{
		try
		{
		String vehicleName = data.getExcelData(dRw, "VehicleName", "SearchVehicle");
		String vinNum = data.getExcelData(dRw,  "VehicleVin", "SearchVehicle");
		String[] vehicleName1=vehicleName.split(" ");
		vehicleName=vehicleName1[1].toUpperCase();
		
		libs.clickOnButton(PGO_landing_page.slct_lnkText(driver), "Choose Vehicle");
		Thread.sleep(3000);
		PGO_landing_page.txt_locationCd(driver).clear();
		libs.enterValueIntoTextField(PGO_landing_page.txt_locationCd(driver), "zip code", locationCd);
		
		libs.clickOnButton(PGO_landing_page.btn_continue(driver), "serch vechile/continue");
		test.log(LogStatus.PASS, "Application navigated to Showroom Page Successfully" );
		Thread.sleep(3000);
		libs.clickOnButton(PGO_landing_page.slct_text(driver, vehicleName), vehicleName);
		test.log(LogStatus.PASS, "Application navigated to Search Inventory Page Successfully" );

		Thread.sleep(5000);
		test.log(LogStatus.PASS,"Click on ("+vehicleName+" ) vehicle in Search Inventory Page", "Navigated to Vehicle Details Page successfully");
		try
		{
			if(PGO_landing_page.img_closeDialog(driver).isDisplayed())
			{
			PGO_landing_page.img_closeDialog(driver).click();
			}
		}
		catch(Exception exception)
		{
			System.out.println(exception.getMessage());	
		}
		try{
				Thread.sleep(1000);

				libs.clickOnButton(PGO_landing_page.btn_selectrprice(driver, vinNum), vinNum);
 				if(applicationname.contains("RSGINT")){

 					driver.get("https://wwwint.retail.ford.com/buy/deal-details?vin="+vinNum+"&pacode=02058#/0/vehicle-details");
 				}
 				if(applicationname.contains("RSGDEV")){

 					driver.get("https://wwwdev.retail.ford.com/buy/deal-details?vin="+vinNum+"&pacode=02058#/0/vehicle-details");
 				}
 				if(applicationname.contains("RSGQA")){

 					driver.get("https://wwwqa.shop.ford.com/buy/deal-details?vin="+vinNum+"&pacode=02058#/0/vehicle-details");
 				}
 				if(applicationname.contains("CTPQA")){

 					driver.get("https://wwwqa.shop.lincoln.com/ctp/deal-details.html?pacode=10493&zip=07701&vin="+vinNum);
 				}
 				if(applicationname.contains("CTPINT")){

 					driver.get("https://wwwint.retail.lincoln.com/ctp/deal-details.html?pacode=10493&zip=07701&vin="+vinNum);
 				}
		}
		catch(Exception fontcolorException)
		{
			getscrnSht.getscreenshot(driver, scrnshtPth +"fontcolorException_Failed_"+libs.datestamp()+".jpg");
			test.log(LogStatus.FAIL, fontcolorException.getMessage(), test.addScreenCapture(scrnshtPth +"searchInventory_Failed_"+libs.datestamp()+".jpg") );
		}
		}
		catch(Exception searchInventoryException)
		{
			getscrnSht.getscreenshot(driver, scrnshtPth +"searchInventory_Failed_"+libs.datestamp()+".jpg");
			test.log(LogStatus.FAIL, searchInventoryException.getMessage(), test.addScreenCapture(scrnshtPth +"searchInventory_Failed_"+libs.datestamp()+".jpg") );
		}
	}


}
