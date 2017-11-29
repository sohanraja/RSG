package runClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import libraryClasses.FuncitonLibrary;
import pageClasses.*;
import utilityClasses.ExcelUtilityClass;
import utilityClasses.ScreenShot;
public class CTPINTTC1 extends rsg_DriverClass{	
//	WebDriver driver;
//	ExcelUtilityClass data = new ExcelUtilityClass();
//	ScreenShot getscrnSht = new ScreenShot();
	
//	@BeforeClass
//	public  void chromekill() throws Exception
//	{
//		//		Runtime.getRuntime().exec("TASKKILL /IM chromedriver.exe /F");    // closing the IE.exe, ChromeDriver.exe process from the system
//		//        Runtime.getRuntime().exec("TASKKILL /IM chrome.exe /F");
//	}

	@Test
	public void landing_Page() throws Exception
	{
		int dtaRwCnt = data.getRowCount(1);
		actions = new Actions(driver);
		
		System.out.println("row count : "+dtaRwCnt);
//		String scrnshtPth = data.getStrExcelData(1, 5, 2);
		scrnshtPth = System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+datestamp()+"/Screenshots/";
		System.out.println(dtaRwCnt);
		for(int dRw=16; dRw<=16;dRw++){
			try{
				testsenarioname=data.getExcelData(dRw, "Testcase Name", "Testcases");
				testSenarioDesc=data.getExcelData(dRw, "Scenario Description", "Testcases");
				ValidationStatus=data.getExcelData(dRw, "ValidationStatus", "Testcases");
				NonFuncational=data.getExcelData(dRw, "Non Funcational", "Testcases");
				System.out.println("test case iteration : "+dRw);
				
//				//sign-in
//				signIn sign=new signIn();
//				sign.SignIn_run(dRw);
				
////				//		Landing Page
				landing_Page lp = new landing_Page();
				lp.hwItWrks_run(dRw);
//
				//Chat Window
				chat chat = new chat();
				chat.chatWinVal_run(dRw);

				//Questions Window
				questionsTab qTab = new questionsTab();
				qTab.quesTabVal_run(dRw);
//
//
//				// 		Vehicle Flyout
				vehicleFlyout vfo =new vehicleFlyout();
				vfo.vehFlyOut_run(dRw);	

//				//						Vehicle Cards
				vehicleCards vCards = new vehicleCards();
			vCards.vhclCrds_run(dRw);
////
////				//		Vehicle Details

				VehicleDetails vehDtls = new VehicleDetails();
				vehDtls.gtVehicleDtls_run(dRw);
////
////				// 		KBB trade in 
				kbbTradeIn kbb =new kbbTradeIn();
				kbb.KbbTrdIn_run(dRw);
////
////				//		Payment Calculator
				PaymentCalculator pmntCal = new PaymentCalculator();
				pmntCal.PaymentCalculator_run(dRw);
////
////				// 		Review and send
				reviewAndSend revSend =new reviewAndSend();
				revSend.reviewAndSend_run(dRw);
////
////				// 		Credit form 	
				creditForm CreForm=new creditForm();
				CreForm.creditForm_run(dRw);
////
////				//		Credit App
			creditApp CreApp=new creditApp();
				CreApp.creditApp_run(dRw);


			}catch(Exception exception)
			 {
				  Count++;
				System.out.println(exception.toString());
				getscrnSht.getscreenshot(driver, scrnshtPth+"testsenarion_"+dRw+".jpg");
				test.log(LogStatus.FAIL, "script failed in testsenarion"+dRw, test.addScreenCapture(Screenpathforreport(scrnshtPth+"testsenarion_"+dRw+".jpg")) );
			
			}
			libs.invokeReportTestSernarios(testsenarioname,testSenarioDesc);
			closeDriver();
			Brosweropen(browser_val);
//			if(data.getExcelData(dRw+1, "Execution", "Testcases").equalsIgnoreCase("No")) {
//				dRw=dtaRwCnt+1;
//			}
		}
		
//		tearReport();
//		testSenariostearsReport();
	}

}
