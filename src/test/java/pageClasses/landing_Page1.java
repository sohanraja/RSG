//package pageClasses;
//
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Cookie;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import libraryClasses.*;
//import pageObjectClasses.*;
//
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//import utilityClasses.*;
//
//
//
//public class landing_Page1 extends rsg_DriverClass{
////	WebDriver driver = getDriver();
////	ExcelUtilityClass data = new ExcelUtilityClass();
////	ScreenShot getscrnSht = new ScreenShot();
////	ExtentReports report;
////	ExtentTest test;
//	WebDriverWait wait = new WebDriverWait(driver,6);
//	FuncitonLibrary libs = new FuncitonLibrary();
//	Actions actions = new Actions(driver);
//
//	@BeforeTest
//	public void invokeReport() {
//		report = ExtentReportManager.invokeExtentReport();
//		test = report.startTest("Verify landingPage");
//
//	}
//	@Test
////	
////	public void run() throws Exception{
////		hwItWrks_run(1) ;
////		
////	}
//	public void hwItWrks_run(int dRw) throws Exception
//	{
//		String runVal = data.getStrExcelData(1, 2, 1);
//		System.out.println(runVal);
//		
//			switch(runVal){
//			case "Yes":
//					invokeReport();
//					billBrdHmPg(dRw);
//					pledgePricing(dRw);
//					chooseVehicle(dRw);
//					searchInventory(dRw);
//					tearReport();
//			break;
//			case "No":
//				System.out.println("This testcase will not be executed");
//				data.writeToExcel("Not Eecuted", dRw, 5, 2);
//			break;
//		}
//		
//	}
//	
//
////	@Test
//	public void billBrdHmPg(int dRw) throws Exception
//	{			
//		String url	= data.getStrExcelData(1, 1, 0);
//		String scrnshtPth = data.getStrExcelData(dRw, 5, 2);
//		String lpHeaderExp	= data.getStrExcelData(dRw, 6, 2);
//		String lpSubHeadlineExp	= data.getStrExcelData(dRw, 7, 2);
//		String arrbigHeadingExp	= data.getStrExcelData(dRw, 8, 2);
//		String bigSubHeadingExp	= data.getStrExcelData(dRw, 9, 2);
//		String rsgOverlay	= data.getStrExcelData(dRw, 16, 2);
//		String vinNum = data.getStrExcelData(dRw, 3, 2);
//		String scrnshtPthNm=scrnshtPth+"billBrdHmPg_Failed_"+libs.timestamp()+".jpg";
//		try{
//		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
//		driver.get("http://www.ford.com/shared/redirectlogic/frdq3a9er7gt2.html");
////		driver.get("https://wwwdev.shopus.ford.com/buy");
////		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("brianbetts");
////		Thread.sleep(2000);
////		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("vfrZsFpE");
////		driver.findElement(By.xpath("//*[@id='login']/button")).click();
////		Thread.sleep(3000);
//		//set cookie
//		Thread.sleep(5000);  
//		System.out.println("cookie begin 1");
//        Cookie ck1 = new Cookie("cdrenProfile_qa","kcFbMfzYtBwNmgu/1Vp9eg==-JS8nPjKz5JJXEMFWTAlQSh5MCV5ePucx4aee3tpuSvPCEU6we4v/iPS5vw66dySJwab0qgzA+7nhSotQazUyOv/JtZ2A1I7VzP9S8v2NTEU=");    
//        Cookie ck2 = new Cookie("Content-Type","[application/json]");
//       // Cookie ck3 = new Cookie("Origin=","https://wwwqa.shop.ford.com");
//        System.out.println("cookie begin 2");
//        Cookie ck4 = new Cookie("IPE126147","IPE126147");
//        System.out.println("cookie begin 3");
//        Cookie ck5 = new Cookie("login-token","IPE126147f5f561de-cd79-40bc-9200-b5f7ec2684e3%3a7da274f8-bb8e-4c82-8517-4a912ba8a872_df7732e88bfa61d4%3acrx.default");
//        System.out.println("cookie begin 4");
//        Cookie ck6 = new Cookie("ipe_s","61dadf82-0863-fe91-128d-9dd9df4c92d1");
//        System.out.println("cookie begin 5");
//        Cookie ck7 = new Cookie("aam_uuid","87785406383351579603593876386818552117");
//        Cookie ck8 = new Cookie("cdrprofileid","136ECA72-6364-C37A-EC73-7279EC737279");
//        Cookie ck9 = new Cookie("accessToken","Qg5g2bV2aysjaWcG%2FvrmIQ%3D%3D");
//        Cookie ck10 = new Cookie("dre_hasDeal","true");
//        Cookie ck11 = new Cookie("IDE","AHWqTUk3y0sIOUFQkSsPuwFN0hmx4RNMUHgF2QU5m-NZcn6Oin7UVvQXUQ");
//        Cookie ck12 = new Cookie("RDQ3TEMP","a3r5htirty39n8tp1");
//        Cookie ck13 = new Cookie("s_suite","nosuitefmcfvngdev");
//        Cookie ck14 = new Cookie("profilecreationstatus","1");
//        System.out.println("cookie begin 6");
//        driver.manage().addCookie(ck1);
//        System.out.println("cookie begin 7");
//        driver.manage().addCookie(ck2);
//        System.out.println("cookie begin 8");
//        //driver.manage().addCookie(ck3);
//        System.out.println("cookie begin 9");
//        driver.manage().addCookie(ck4);
//        System.out.println("cookie begin 10");
//        driver.manage().addCookie(ck5);
//        System.out.println("cookie begin 11");
//        driver.manage().addCookie(ck6);
//        System.out.println("cookie begin 12");
//        driver.manage().addCookie(ck7);
//        System.out.println("cookie begin 13");
//        driver.manage().addCookie(ck8);
//        System.out.println("cookie begin 14");
//        driver.manage().addCookie(ck9);
//        driver.manage().addCookie(ck10);
//        driver.manage().addCookie(ck11);
//        driver.manage().addCookie(ck12);
//        driver.manage().addCookie(ck13);
//        driver.manage().addCookie(ck14);
//        System.out.println("cookie begin 15");
//        System.out.println("cookie added");
//       Thread.sleep(5000);
//     //fetch cookie
//		  Set <Cookie> cookies =driver.manage().getCookies();
//       System.out.println("size of cookies : "+cookies.size());
//       
//       for(Cookie cookie:cookies){
//       	System.out.println(cookie.getName()+" :Name: "+cookie.getValue()) ;
//       }
//		Thread.sleep(5000);
//       String DEVurl = "https://wwwdev.shopus.ford.com/buy/deal-details?vin="+vinNum+"&pacode=02058#/0/vehicle-details";
//		System.out.println(DEVurl);
//		Thread.sleep(2000);
//		driver.get(DEVurl);
//		
//		}
//		catch(Exception billBrdHmPgException)
//		{
//			
//			getscrnSht.getscreenshot(driver,scrnshtPthNm );
//			test.log(LogStatus.FAIL, billBrdHmPgException.getMessage(), test.addScreenCapture(scrnshtPthNm) );
//		}
//
//
//	}
//
//	
//	
//	public void pledgePricing(int dRw) throws Exception{
//		String scrnshtPth = data.getStrExcelData(dRw, 4, 2);
//		// Our Pledge to Clear Pricing
//		try{
//			String pledgePricing =PGO_landing_page.txt_pledgePricing(driver).getText();
//			test.log(LogStatus.INFO,"Pledge heading is : "+pledgePricing);
//			System.out.println("Pledge heading : "+pledgePricing);
//
//
//			//Pledge Pricing Image
//			Assert.assertTrue(PGO_landing_page.img_pledgePricing(driver).isDisplayed());
//			test.log(LogStatus.PASS, "Pledge pricing image is displayed" );
//			}
//		catch(Exception pledgePricingException){
//			System.out.println(pledgePricingException.getMessage());
//			getscrnSht.getscreenshot(driver, scrnshtPth +"pledgePricing_Failed_"+libs.timestamp()+".jpg");
//			test.log(LogStatus.FAIL, pledgePricingException.getMessage(), test.addScreenCapture(scrnshtPth +"pledgePricing_Failed_"+libs.timestamp()+".jpg") );
//		}
//
//	}
//
//
//	
//	//	Click on Choose vehicle
//	@SuppressWarnings("unused")
//	
//	public void chooseVehicle(int dRw) throws Exception
//	{	
//		String scrnshtPth = data.getStrExcelData(dRw, 5, 2);
//		String locationCd = data.getStrExcelData(dRw, 2, 2);
//		String zipCdErrExp = data.getStrExcelData(dRw, 12, 2);
//		String InvldZipCd = data.getStrExcelData(dRw, 13, 2);
//		String spclChrZipCd = data.getStrExcelData(dRw, 14, 2);
//		String dgts4ZipCd = data.getStrExcelData(dRw, 15, 2);
//		String zipCdcntntExp =data.getStrExcelData(dRw, 17, 2);
//		String scrnshtPthNm=scrnshtPth+"chooseVehicle_Failed_"+libs.timestamp()+".jpg";
//		
//		System.out.println("Zip code content text expected: "+zipCdcntntExp);
//		
//		libs.fluentWait(driver,  PGO_landing_page.slct_lnkText(driver));
//		Assert.assertTrue(PGO_landing_page.slct_lnkText(driver).isDisplayed());
//		try{
//			libs.waitToClick(driver, PGO_landing_page.slct_lnkText(driver), 5);
//			test.log(LogStatus.PASS, "Choose Vehicle button clicked" );
//			// validate zip code text
//			Thread.sleep(1000);
//			String zipCdcntnt = PGO_landing_page.txt_zipCdcntnt(driver).getText();
//			System.out.println("Zip code content text : "+zipCdcntnt);
////			Assert.assertEquals(zipCdcntnt, zipCdcntntExp);
//			libs.assertionHandling(zipCdcntnt, zipCdcntntExp, test,driver,scrnshtPthNm);
//			test.log(LogStatus.PASS,"Zip code content text : "+zipCdcntnt);
//			System.out.println("Zip code content text : "+zipCdcntnt);
//				
//			Thread.sleep(1000);
//			PGO_landing_page.txt_locationCd(driver).clear();
//			boolean contn=  PGO_landing_page.btn_continue(driver).isEnabled();
//			System.out.println("Zip code blank continue button enabled : " +contn  );
//			Assert.assertFalse(contn);
//			test.log(LogStatus.PASS, "Zip code blank continue button disabled" );
//
//			//zip code -special characters error message
//			Thread.sleep(2000);
//			PGO_landing_page.txt_locationCd(driver).sendKeys(spclChrZipCd);
//			boolean contn1=  PGO_landing_page.btn_continue(driver).isEnabled();
//			System.out.println("Zip code blank continue button enabled : " +contn1  );
//			Assert.assertFalse(contn);
//			test.log(LogStatus.PASS, "Invalid zip code special characters continue button disabled" );
//			System.out.println("Invalid zip code special characters continue button disabled ");
//
//			//zip code -four digits error message
//			Thread.sleep(2000);
//			PGO_landing_page.txt_locationCd(driver).sendKeys(dgts4ZipCd);
//			boolean contn2=  PGO_landing_page.btn_continue(driver).isEnabled();
//			System.out.println("Zip code blank continue button enabled : " +contn2 );
//			Assert.assertFalse(contn);
//			test.log(LogStatus.PASS, "Invalid zip code four digits continue button disabled" );
//			System.out.println("Invalid zip code four digits continue button disabled ");
//
//			//Invalid zip code error message
//			PGO_landing_page.txt_locationCd(driver).clear();
//			PGO_landing_page.txt_locationCd(driver).sendKeys(InvldZipCd);
//			libs.waitToClick(driver, PGO_landing_page.btn_continue(driver), 10);
//			WebElement valText  = driver.findElement(By.cssSelector("body > div.modal.fade.ng-scope.in > div > div > form > div.modal-body > div > p.error.text-danger"));
//			String zipCdErr =PGO_landing_page.txt_zipCdErr(driver).getText();
//			Assert.assertEquals(zipCdErr, zipCdErrExp);
//			libs.assertionHandling(zipCdErr, zipCdErrExp, test, driver,scrnshtPthNm);
//			test.log(LogStatus.PASS,"Invalid zip code error message : "+zipCdErr);
//			System.out.println("Invalid zip code error message : "+zipCdErr);
//			// valid zip code
//			Thread.sleep(2000);
//			Assert.assertTrue(valText.isDisplayed());
//			test.log(LogStatus.PASS, "Application has validated the invalid 'Dealer' code and error message is displayed." );
//			Thread.sleep(2000);
//			System.out.println("Clear bad dealer code and enter valid one.");
//			Thread.sleep(2000);
//			PGO_landing_page.txt_locationCd(driver).clear();
//			Thread.sleep(2000);
//			PGO_landing_page.txt_locationCd(driver).sendKeys(locationCd);
//			libs.waitToClick(driver, PGO_landing_page.btn_continue(driver), 10);
//			test.log(LogStatus.PASS, "Application invoked successfully and navigated to Vehicle search Inventory" );
//		}
//		catch(AssertionError e){
//		System.out.println(e.getMessage());
//		getscrnSht.getscreenshot(driver, scrnshtPth+ "chooseVehicle_Failed_"+libs.timestamp()+".jpg");
//		test.log(LogStatus.FAIL, e.getMessage(), test.addScreenCapture(scrnshtPth +"chooseVehicle_Failed_"+libs.timestamp()+".jpg") );
//		}
//		
//		catch(Exception chooseVehicleException){
//			System.out.println(chooseVehicleException.getMessage());
//			getscrnSht.getscreenshot(driver, scrnshtPthNm);
//			test.log(LogStatus.FAIL, chooseVehicleException.getMessage(), test.addScreenCapture(scrnshtPthNm) );
//		}
//
//	}
//
//	public void searchInventory(int dRw)throws Exception {
//
//		String scrnshtPth = data.getStrExcelData(dRw, 5, 2);
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		String scrnshtPthNm=scrnshtPth+"searchInventory_Failed_"+libs.timestamp()+".jpg";
//		//		select brand car
//		String vehicleName = data.getStrExcelData(dRw, 4, 2);
//		String vinNum = data.getStrExcelData(dRw, 3, 2);
//		//test.log(LogStatus.INFO, "User is on Cars page" );
//		//PGO_searchInventoryNG.slct_text(driver, vehicleName).click();
//		actions.moveToElement(PGO_landing_page.slct_text(driver, vehicleName)).build().perform();
//		libs.waitToClick(driver, PGO_landing_page.slct_text(driver, vehicleName), 10);
//		//
//
//		try{
//			wait.until(ExpectedConditions.elementToBeClickable(PGO_landing_page.img_closeDialog(driver)));
//			PGO_landing_page.img_closeDialog(driver).click();
//
//		}catch(Exception exception)
//		{
//			System.out.println("Failed");
//
//		}
//
//		System.out.println("pop up after");
//		System.out.println(vinNum);
//
//
//		try{
//			actions.moveToElement( PGO_landing_page.slct_href(driver, vinNum)).build().perform();
//			libs.fluentWait(driver, PGO_landing_page.slct_href(driver, vinNum));
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PGO_landing_page.slct_href(driver, vinNum));
//			boolean vin_display=PGO_landing_page.slct_href(driver, vinNum).isDisplayed();
//			boolean vin_Enabled = PGO_landing_page.slct_href(driver, vinNum).isEnabled();
//			System.out.println("vin_display:"+vin_display);
//			System.out.println("vin_Enabled:"+vin_Enabled);
//			if (vin_display==true && vin_Enabled==true)
//			{
//				// fetch the vehicle title details
//				String vehicle_model =PGO_landing_page.txt_vehicle_model(driver,vinNum).getText();
//				System.out.println("vehicle_model:"+vehicle_model);
//
//				//validate color of text
//				//String colorString1 = PGO_landing_page.txt_vehicle_model(driver,vinNum).getCssValue("color");
//				String colorString1 = driver.findElement(By.xpath(".//*[@id='searchResults']/div[3]/div[2]/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]/h4/a/span[2]")).getCssValue("color");
//
//
//				String colorString2 = PGO_landing_page.txt_vehicle_model(driver,vinNum).getCssValue("border-color");
//				String colorString3 = PGO_landing_page.txt_vehicle_model(driver,vinNum).getCssValue("font-family");
//				String colorString4 = PGO_landing_page.txt_vehicle_model(driver,vinNum).getCssValue("padding");
//				String colorString5 = PGO_landing_page.txt_vehicle_model(driver,vinNum).getCssValue("font-size");
//
//				System.out.println("colorString1:"+colorString1);
//				System.out.println("colorString2:"+colorString2);
//				System.out.println("colorString3:"+colorString3);
//				System.out.println("colorString4:"+colorString4);
//				System.out.println("colorString5:"+colorString5);
//				String[] arrColor = colorString1 .split("rgba");
//				System.out.println("RGB values:"+arrColor[1]);
//			//	Assert.assertTrue(arrColor[1].equals("(52, 186, 20, 1)"));
//				System.out.println( "DRE eligible VINs-Vehicle model year will display as green text");
//				test.log(LogStatus.PASS, "	DRE eligible VINs-Vehicle model year will display as green text");
//
//				//fetch cookie
//				  Set <Cookie> cookies =driver.manage().getCookies();
//		            System.out.println("size of cookies : "+cookies.size());
//		            
//		            for(Cookie cookie:cookies){
//		            	System.out.println(cookie.getName()+" :Name: "+cookie.getValue()) ;
//		            }
//				Thread.sleep(5000);
//				
//				
//				String QAurl = driver.getCurrentUrl();
//				System.out.println(QAurl);
//				String DEVurl = "https://wwwdev.shopus.ford.com/buy/deal-details?vin="+vinNum+"&pacode=02058#/0/vehicle-details";
//				System.out.println(DEVurl);
//				Thread.sleep(2000);
//				driver.get(DEVurl);
//			  //libs.waitToClick(driver, PGO_vehicleFlyOut.slct_lnkText(driver, "Vehicle Details"),60);
//				data.writeToExcel("Passed", dRw, 5, 2);
//				test.log(LogStatus.PASS, "User is on Cars page" );
//				
//				try{
//					wait.until(ExpectedConditions.elementToBeClickable(PGO_landing_page.img_closeDialog(driver)));
//					PGO_landing_page.img_closeDialog(driver).click();
//
//				}catch(Exception exception)
//				{
//					System.out.println("Failed");
//
//				}
//				
//				Thread.sleep(1000);
//				driver.navigate().back();
//			}
//		}
//		catch(Exception fontcolorException){
//			getscrnSht.getscreenshot(driver, scrnshtPth +"fontcolorException_Failed_"+libs.timestamp()+".jpg");
//			test.log(LogStatus.FAIL, fontcolorException.getMessage(), test.addScreenCapture(scrnshtPth +"searchInventory_Failed_"+libs.timestamp()+".jpg") );
//		}
//		try
//		{
//			libs.waitToClick(driver, PGO_landing_page.slct_href(driver, vinNum), 10);
//			libs.waitToClick(driver, PGO_landing_page.slct_lnkTextVhcl(driver, "Vehicle Details"),60);
//			data.writeToExcel("Passed", dRw, 1, 2);
//			test.log(LogStatus.PASS, "User is on Cars page" );	
//		}
//		catch(Exception searchInventoryException){
//			data.writeToExcel("Failed", dRw, 1, 2);
//			getscrnSht.getscreenshot(driver, scrnshtPth +"searchInventory_Failed_"+libs.timestamp()+".jpg");
//			test.log(LogStatus.FAIL, searchInventoryException.getMessage(), test.addScreenCapture(scrnshtPth +"searchInventory_Failed_"+libs.timestamp()+".jpg") );
//		}
//	}
//
//	
////	@AfterTest
//	public void tearReport(){
//	report.endTest(test);
//	report.flush();
//	}
//
//
//}
