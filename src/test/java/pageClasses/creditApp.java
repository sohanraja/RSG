package pageClasses;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.LogStatus;
public class creditApp extends rsg_DriverClass
{
 FuncitonLibrary libs = new FuncitonLibrary();
 public void  creditApp_run(int dRw) throws Exception
 {
  try
	{
	  String runVal = data.getExcelData(dRw,"ApplyCreDit", "reviewAndSend");
	  switch(runVal)
	  {
	  case "Yes":
		invokeReport("Verify Credit APP ",dRw);
		creditAppOverlay(dRw);
		break;
		case "No":
		System.out.println("'creditForm' testcase is not executed.");
	    data.writeToExcel("Not Executed", dRw, 23, 4);
		break;
	   }
	    tearReport();
	}
		catch(Exception CreditApp)
		{
			CreditApp.printStackTrace();
			Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
			test.log(LogStatus.FAIL,"'Review & Send' testcase is failed as we are not able to submit deal with credit application.",test.addScreenCapture(scrnshtPthNm));
			data.writeExceldata(dRw,"Result", "CreditApp","Failed");
			tearReport();
		}
		}
 public void creditAppOverlay(int dRw) throws Exception
 {
	try
	{
	  String scrnshtPthNm=scrnshtPth+"creditAppOverlay"+libs.timestamp1()+".jpg";
	  test.log(LogStatus.INFO,libs.gettingText(PGO_reviewAndSend.dealSubmissionHeading(driver),"dealSubmissionHeading"));
	  int iframecount=0;
	  String  parentHandle1 = null;
	  libs.clickOnButton(PGO_reviewAndSend.viewandPrintmydeal(driver), "viewandPrintmydeal");
	  try 
	   {
		 parentHandle1 = driver.getWindowHandle(); 
		 for (String winHandle : driver.getWindowHandles())
		 {
		   driver.switchTo().window(winHandle); 
		   iframecount++;
		  }
		  test.log(LogStatus.PASS, "Verify View and Print My deal ", "View and Print My deal opened");	
		  if(iframecount==2)
		  {
			driver.close();
		  }
			driver.switchTo().window(parentHandle1); 
		  }
	      catch(Exception E)
		  {
			driver.close(); 
			driver.switchTo().window(parentHandle1); 
		  }
	      test.log(LogStatus.INFO, "Deal submitted date and time ", PGO_creditApp.txt_DealSentDate(driver).getText()); 
	 	  test.log(LogStatus.PASS, "Deal Number", PGO_creditApp.txt_DealNumber(driver).getText());
		  test.log(LogStatus.PASS, "Credit application Number:", PGO_creditApp.txt_DealNumberForWithCreditApp(driver).getText());
		  test.log(LogStatus.INFO, "Dealer Contact Details", PGO_creditApp.txt_crdtAppDlrNm(driver).getText());
		  Thread.sleep(2000);
		  String DealNumber=null;
		  DealNumber =PGO_creditApp.txt_DealNumber(driver).getText();
		  if(DealNumber.equals(null)||DealNumber.equals(""))
		  {
			test.log(LogStatus.FAIL, "Deal Number is not generated!!!", DealNumber);
		  }
		  data.writeExceldata(dRw,"Deal_Number", "Chat", DealNumber);
		  test.log(LogStatus.PASS, "Deal Number", DealNumber);
		  test.log(LogStatus.INFO, "Dealer INformation", DealNumber);
	      }
	      catch(Exception creditAppOverlay)
	      {
			Count++;
		    System.out.println("'creditApp' testcase is failed.");
		    data.writeExceldata(dRw,"Result", "CreditApp","Failed");
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL,"'Credit App' testcase is failed as we are not able to submit deal with credit application.",test.addScreenCapture(scrnshtPthNm));
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
				
				
			
		}
	
		
	}
	