package pageClasses;
import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilityClasses.*;
public class creditApp extends rsg_DriverClass{

		WebDriverWait wait = new WebDriverWait(driver,10);
		FuncitonLibrary libs = new FuncitonLibrary();
		Actions actions = new Actions(driver);

//		Credit application run method
		public void  creditApp_run(int dRw) throws Exception
		{
			try
			{
			String runVal = data.getExcelData(dRw,"ApplyCreDit", "reviewAndSend");
			System.out.println(runVal);
			switch(runVal){
				case "Yes":
					invokeReport("Verify Credit APP ",dRw);
					if (ValidationStatus.equalsIgnoreCase("Yes")){
					creditContactInfo(dRw);
					}else {
//						sendMyDeal(dRw);
						creditAppDealSubmition(dRw);
					}
		
					break;
				case "No":
					System.out.println("'creditApp' testcase is not executed.");
					data.writeToExcel("Not Executed", dRw, 24, 4);
					break;
				}
			tearReport();
			}
		catch(Exception CreditApp)
		{
			Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
			System.out.println("'Credit App' testcase is failed.");
			test.log(LogStatus.FAIL,"'Review & Send' testcase is failed as we are not able to submit deal with credit application.",test.addScreenCapture(scrnshtPthNm));
			data.writeExceldata(dRw,"Result", "CreditApp","Failed");
			tearReport();
		}
		}
		public void sendMyDeal(int dRw) throws Exception
		{
			String scrnshtPthNm=scrnshtPth+"sendMyDeal"+libs.timestamp1()+".jpg";
			try
			{	
				libs.clickOnButton(PGO_reviewAndSend.btn_sendMyDeal(driver), "Send My Dealer");
	
				
//				try{
//				if(PGO_reviewAndSend.btn_sendMyDeal(driver).isDisplayed()){
//					actions.moveToElement(PGO_reviewAndSend.btn_sendMyDeal(driver)).doubleClick().build().perform();
////					libs.clickOnButton(PGO_reviewAndSend.btn_sendMyDeal(driver), "Send My Dealer");
//				}}catch(Exception creditapp){
//					System.out.println("send my dealer button already clicked");
//				}
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Click on 'Send My Dealer' button ", "'Send My Dealer' button has been  clicked ");

			}
			catch(Exception applyfrCredit)
			 {
				Count++;
				getscrnSht.getscreenshot(driver, scrnshtPthNm);
				test.log(LogStatus.FAIL, applyfrCredit.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
		}
		public void creditAppDealSubmition(int dRw) throws Exception{
			try
			{
				  int iframecount=0;
				scrnshtPth=scrnshtPth+"Deal_PDF"+libs.timestamp1()+".jpg";
			String ccFirstName = data.getExcelData(dRw,"ApplicantFirstName", "CreditApp");
			String Vinnumber=data.getExcelData(dRw,"VehicleVin", "SearchVehicle");
			String parentHandle1 = null;
		    Thread.sleep(1000);
//		    libs.VerifyPartialText(PGO_creditApp.txt_creditAppHdr(driver), ccFirstName, "heading of the credit app");
		    libs.clickOnButton(PGO_creditApp.btn_prntMyDeal(driver), "print Mydeal");
		    test.log(LogStatus.PASS, "Click on View & Print My Deal ", "View & print My Deal button has been clicked");
		    	  
			Thread.sleep(1000);
			// switch to old browser
			try {
				parentHandle1 = driver.getWindowHandle(); 
				for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); 
			    iframecount++;
				}
				
				if(iframecount==2){
					getscrnSht.getscreenshot(driver, scrnshtPth);
					test.log(LogStatus.PASS,"View & print My Deal PDF has  been opened",test.addScreenCapture(scrnshtPth));
					System.out.println("Print my deal PDF has been opened ");
					driver.close(); }

			driver.switchTo().window(parentHandle1);}catch(Exception e){
				test.log(LogStatus.FAIL, "Verify the PDF window ", "View & print My Deal PDF has not been opened");
				driver.close(); 
				driver.switchTo().window(parentHandle1);
			}
//			libs.VerifyText(PGO_creditApp.txt_Vinnumber(driver), Vinnumber, "Vin number");
			test.log(LogStatus.INFO, "Deal submitted date and time ", PGO_creditApp.txt_DealSentDate(driver).getText());
			
			if(data.getExcelData(dRw,"ApplyCreDit", "reviewAndSend").equalsIgnoreCase("Yes")) {
				
				test.log(LogStatus.PASS, "Credit application Number:", PGO_creditApp.txt_DealNumberForWithCreditApp(driver).getText());
			}else{
			test.log(LogStatus.PASS, "Deal Number", PGO_creditApp.txt_DealNumber(driver).getText());
			}
//			data.addColumn("Deal_Number","Chat");
			Thread.sleep(2000);
			data.writeExceldata(dRw,"Deal_Number", "Chat", PGO_creditApp.txt_DealNumber(driver).getText());
			test.log(LogStatus.PASS, "Deal Number", PGO_creditApp.txt_DealNumber(driver).getText());
			test.log(LogStatus.INFO, "Dealer INformation", PGO_creditApp.txt_DealerAddress(driver).getText());
			libs.Disclosers();
			}catch(Exception e){
				  	Count++;
				  	scrnshtPth=scrnshtPth+"CreditApp_Failed_"+libs.timestamp1()+".jpg";
					System.out.println("'creditApp' testcase is failed.");
//					data.writeExceldata(dRw,"Result", "CreditApp","Failed");
					getscrnSht.getscreenshot(driver, scrnshtPth);
					test.log(LogStatus.FAIL,"'Review & Send' testcase is failed as we are not able to submit deal with credit application.",test.addScreenCapture(scrnshtPth));
				}
		}

		public void creditContactInfo(int dRw)throws Exception {
			try
			{
			String ccFirstName = data.getExcelData(dRw,"ApplicantFirstName", "CreditApp");
			String Vinnumber=data.getExcelData(dRw,"VehicleVin", "SearchVehicle");
			String parentHandle1 = null;
		    Thread.sleep(10000);
		    //libs.VerifyPartialText(PGO_creditApp.txt_creditAppHdr(driver), ccFirstName, "heading of the credit app","");
		    libs.clickOnButton(PGO_creditApp.btn_prntMyDeal(driver), "print Mydeal");
		    test.log(LogStatus.PASS, "Click on View & Print My Deal ", "View & print My Deal button has been clicked");
		    	  
			Thread.sleep(1000);
			// switch to old browser
			try {
				parentHandle1 = driver.getWindowHandle(); 
				for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); 
			   	System.out.println("Print my deal PDF has been opened ");
			    test.log(LogStatus.PASS, "Verify the PDF window ", "View & print My Deal PDF has been opened");

			}
			Thread.sleep(50000);
			driver.close(); 
			driver.switchTo().window(parentHandle1);}catch(Exception e){
				test.log(LogStatus.FAIL, "Verify the PDF window ", "View & print My Deal PDF has not been opened");
				driver.switchTo().window(parentHandle1);
			}
			libs.VerifyText(PGO_creditApp.txt_Vinnumber(driver), Vinnumber, "Vin number","");
			test.log(LogStatus.INFO, "Deal submitted date and time ", PGO_creditApp.txt_DealSentDate(driver).getText());
			test.log(LogStatus.PASS, "Deal Number", PGO_creditApp.txt_DealNumber(driver).getText());
			test.log(LogStatus.INFO, "Dealer INformation", PGO_creditApp.txt_DealerAddress(driver).getText());
		    
			for (int i=1; i<=2; i++)
			{
				//Used for loop for number of columns.
				for(int j=1; j<=2; j++)
				{
					String Table_data = driver.findElement(By.xpath("//div [@class='col-xs-12 col-md-6 col-md-push-3']/table[1]/tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.print(Table_data +" "); 
					test.log(LogStatus.INFO, Table_data +" ");
				} 
				System.out.println("");
			System.out.println("Table "+i+" data is captured");
			test.log(LogStatus.INFO, "Table "+i+" data is captured");
			}

				//Fetch dealer details
				String crdtAppDlrNm = PGO_creditApp.txt_crdtAppDlrNm(driver).getText();
				System.out.println("Dealer details is displayed: "+ crdtAppDlrNm);
				
				test.log(LogStatus.INFO, "Dealer details is displayed: "+ crdtAppDlrNm);
				
				// dealer contact no
				String crdtAppDlrphn = PGO_creditApp.txt_crdtAppDlrphn(driver).getText();
				System.out.println("Dealer phone no is displayed: "+ crdtAppDlrphn);
				test.log(LogStatus.INFO, "Dealer phone no is displayed: "+ crdtAppDlrphn);
				
				// dealer address
				try
				{
				int i=PGO_creditApp.txt_crdtAppDlrAdd1(driver).size();
				System.out.println(i);
				for(int j=0;j<i;j++)
				{
					test.log(LogStatus.INFO,PGO_creditApp.txt_crdtAppDlrAdd1(driver).get(j).getText());	
				}
				}
				catch(Exception e)
				{
				 e.printStackTrace();
				}
				
				System.out.println("Dealer address details displayed and verified successfully");
				test.log(LogStatus.INFO, "Dealer address details displayed and verified successfully");
				//map
				actions.moveToElement(PGO_creditApp.mapicon(driver)).build().perform();
				libs.waitToClick(driver, PGO_creditApp.mapicon(driver), 30);
				actions.moveToElement(PGO_creditApp.map(driver)).build().perform();
				Boolean disp=PGO_creditApp.map(driver).isDisplayed();
				if(disp==true)
				{
					test.log(LogStatus.PASS,"Dealer details visible in map");
				}
				else
				{
					test.log(LogStatus.FAIL,"Dealer details not visible in map");	
				}
				actions.moveToElement(PGO_creditApp.mapiconclose(driver)).build().perform();
				libs.waitToClick(driver, PGO_creditApp.mapiconclose(driver), 30);
				actions.moveToElement(PGO_creditApp.mapicon1(driver)).build().perform();
				libs.waitToClick(driver, PGO_creditApp.mapicon1(driver), 30);
				actions.moveToElement(PGO_creditApp.map(driver)).build().perform();
				Boolean disp1=PGO_creditApp.map(driver).isDisplayed();
				if(disp1==true)
				{
					test.log(LogStatus.PASS,"Dealer details visible in map");
				}
				else
				{
					test.log(LogStatus.PASS,"Dealer details not visible in map");	
				}
				actions.moveToElement(PGO_creditApp.mapiconclose(driver)).build().perform();
				libs.waitToClick(driver, PGO_creditApp.mapiconclose(driver), 30);
				// test drive details
				String crdtApptstDrvDt =PGO_creditApp.txt_crdtApptstDrvDt(driver).getText();
				Assert.assertTrue(PGO_creditApp.txt_crdtApptstDrvDt(driver).isDisplayed());
				System.out.println("Dealer test drive date details is displayed: "+ crdtApptstDrvDt);
				test.log(LogStatus.PASS, "Dealer test drive date details is displayed: "+ crdtApptstDrvDt);
				
				String crdtApptstDrvTm = PGO_creditApp.txt_crdtApptstDrvTm(driver).getText();
				System.out.println("Dealer test drive time details is displayed: "+ crdtApptstDrvTm);
				test.log(LogStatus.INFO, "Dealer test drive time details is displayed: "+ crdtApptstDrvTm);
				System.out.println("'creditApp' details is displayed.");
				data.writeToExcel("Passed", dRw, 24,4);
				test.log(LogStatus.PASS, "'creditApp' details is displayed." );
				test.log(LogStatus.PASS, "'creditApp' test case passed." );
			}
				catch(Exception creditAppException)
				 {
					  Count++;
					System.out.println("'creditApp' testcase is failed.");
					data.writeToExcel("Failed", dRw, 24, 4);
					getscrnSht.getscreenshot(driver, scrnshtPth+"CreditAppVal_Failed_"+libs.timestamp()+".jpg");
					test.log(LogStatus.FAIL,"'Review & Send' testcase is failed as we are not able to submit deal with credit application.",test.addScreenCapture(scrnshtPthNm));
					test.log(LogStatus.FAIL,creditAppException.getMessage(),test.addScreenCapture(scrnshtPth +"CreditAppVal_Failed_"+libs.timestamp()+".jpg") );
					tearReport();
				}
			}
						
			public void pvtPolicy(int dRw) throws Exception
			{
				String parentHandle= driver.getWindowHandle();
				//privacy policy of ford
				Thread.sleep(5000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PGO_creditApp.hyprlnk_prvcyPlcy(driver));
				PGO_creditApp.hyprlnk_prvcyPlcy(driver).click();
				 System.out.println(driver.getTitle());
				// switch to old browser
				 ArrayList<String> handle  = new ArrayList<String>(driver.getWindowHandles()); 
				 handle.remove(parentHandle);
				 driver.switchTo().window(handle.get(0));
//				for (String winHandle : driver.getWindowHandles()) {
//				    driver.switchTo().window(winHandle); 
				    System.out.println("print my deal 1 ");
				    System.out.println(driver.getTitle());
				    String PrvcyPlcyHdng = PGO_creditApp.txt_PrvcyPlcyHdng(driver).getText();
				    Assert.assertFalse(PrvcyPlcyHdng.isEmpty());
					System.out.println("Privacy Policy Heading is displayed: "+ PrvcyPlcyHdng);
					test.log(LogStatus.PASS, "Privacy Policy Heading is displayed: "+ PrvcyPlcyHdng);
					
//				}
				Thread.sleep(2000);
				driver.close(); 
				driver.switchTo().window(parentHandle);
//				//view and print my deal
				Thread.sleep(5000);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PGO_creditApp.btn_prntMyDeal(driver));
				PGO_creditApp.btn_prntMyDeal(driver).click();
				Thread.sleep(5000);
				// switch to old browser
				String parentHandle1 = driver.getWindowHandle(); 
				for (String winHandle : driver.getWindowHandles()) {
				    driver.switchTo().window(winHandle); 
				   	System.out.println("Print my deal window is opened ");
					test.log(LogStatus.PASS, "Print my deal window is opened ");	
				}
				Thread.sleep(50000);
				driver.close(); 
				driver.switchTo().window(parentHandle1);
				//				fetch 3 values from footer
				
				
				
			
		}
	
		
	}
	