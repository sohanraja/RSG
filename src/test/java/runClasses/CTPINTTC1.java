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


	@Test
	public void landing_Page() throws Exception
	{
		int dtaRwCnt = data.getRowCount(1);
		actions = new Actions(driver);
		
		System.out.println("row count : "+dtaRwCnt);

		scrnshtPth = System.getProperty("user.dir")+"\\Reports\\"+applicationname+"\\"+datestamp()+"\\Screenshots\\";
		System.out.println(dtaRwCnt);
		for(int dRw=1; dRw<=dtaRwCnt;dRw++){
			try{
				testsenarioname=data.getExcelData(dRw, "Testcase Name", "Testcases");
				testSenarioDesc=data.getExcelData(dRw, "Scenario Description", "Testcases");
				ValidationStatus=data.getExcelData(dRw, "ValidationStatus", "Testcases");
				NonFuncational=data.getExcelData(dRw, "Non Funcational", "Testcases");
				System.out.println("test case iteration : "+dRw);
				

				
				//Landing Page
				System.out.println("<<============Entering into Landing Page=======>>");
				landing_Page lp = new landing_Page();
				lp.hwItWrks_run(dRw);
				System.out.println("<<============Completed into Landing Page=======>>");
				//Chat Window
				chat chat = new chat();
				chat.chatWinVal_run(dRw);

				//Questions Window
				questionsTab qTab = new questionsTab();
				qTab.quesTabVal_run(dRw);
//
				System.out.println("<<============Entering into Vehicle Flyout Page=======>>");
				// 		Vehicle Flyout
				vehicleFlyout vfo =new vehicleFlyout();
				vfo.vehFlyOut_run(dRw);	
				System.out.println("<<============Completed into Vehicle Flyout Page=======>>");
				System.out.println("<<============Entering into vehicleCards Page=======>>");
										//Vehicle Cards
				vehicleCards vCards = new vehicleCards();
				vCards.vhclCrds_run(dRw);
				System.out.println("<<============Completed into vehicleCards Page=======>>");
//				//		Vehicle Details
				System.out.println("<<============Entering into VehicleDetails Page=======>>");
				VehicleDetails vehDtls = new VehicleDetails();
				vehDtls.gtVehicleDtls_run(dRw);
				System.out.println("<<============Completed into VehicleDetails Page=======>>");
				System.out.println("<<============Entering into kbbTradeIn Page=======>>");
				// 		KBB trade in 
				kbbTradeIn kbb =new kbbTradeIn();
				kbb.KbbTrdIn_run(dRw);
				System.out.println("<<============Completed kbbTradeIn Page=======>>");
				System.out.println("<<============Entering into PaymentCalculator Page=======>>");
				//		Payment Calculator
				PaymentCalculator pmntCal = new PaymentCalculator();
				pmntCal.PaymentCalculator_run(dRw);
				System.out.println("<<============Completed  PaymentCalculator Page=======>>");
				System.out.println("<<============Entering into reviewAndSend Page=======>>");
				// 		Review and send
				reviewAndSend revSend =new reviewAndSend();
				revSend.reviewAndSend_run(dRw);
				System.out.println("<<============Completed  reviewAndSend Page=======>>");
				System.out.println("<<============Entering into creditForm Page=======>>");
				// 		Credit form 	
				creditForm CreForm=new creditForm();
				CreForm.creditForm_run(dRw);
				System.out.println("<<============Completed  creditForm Page=======>>");
				System.out.println("<<============Entering into creditApp Page=======>>");
				//		Credit App
			creditApp CreApp=new creditApp();
				CreApp.creditApp_run(dRw);
				System.out.println("<<============Completed creditApp Page=======>>");

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


		}
		

	}

}
