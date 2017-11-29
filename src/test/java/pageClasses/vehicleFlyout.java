package pageClasses;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import libraryClasses.*;
import pageObjectClasses.PGO_VehicleDetails;
import pageObjectClasses.PGO_landing_page;
import pageObjectClasses.PGO_vehicleFlyOut;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilityClasses.*;
public class vehicleFlyout extends rsg_DriverClass{

	FuncitonLibrary libs = new FuncitonLibrary();
	WebDriverWait wait = new WebDriverWait(driver,10);
	Actions actions = new Actions(driver);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	


	public void vehFlyOut_run(int dRw) throws Exception
	{
		String runVal =data.getExcelData(dRw,"Vehicle Flyout","Testcases");
		System.out.println(runVal);
				switch(runVal){
				     case "Yes":
					 invokeReport("Verify VehicleFlyOut",dRw);
					 vehFlyOut(dRw);
					 tearReport();
					 break;
				case "No":
					 System.out.println("'Vehicle Flyout' testcase is not executed.");
					 data.writeExceldata(dRw,"Result", "Vehicle Flyout","Not Executed");
					
					 break;
				}
		}

	public void vehFlyOut(int dRw)throws Exception {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String scrnshtPthNm=scrnshtPth+"Vehicle_Flyout"+".jpg";
		int Totalsavednumber=Integer.parseInt(data.getExcelData(dRw, "Adding_Vehicle_Count", "Vehicle Flyout"));
		int savedvch;
		String vinumber=null;
		try
		{
			libs.clickOnButton(PGO_vehicleFlyOut.img_vehicleFlyOut(driver),"img_vehicleFlyOut");

		test.log(LogStatus.INFO,"Vehicle Flyout iamge is displayed and clicked successfully" );
		libs.VerifyText(PGO_vehicleFlyOut.txt_ReadyShopToGo(driver), data.getExcelData(dRw,"Txt_Ready_Shop","Vehicle Flyout"), "txt_ReadyShopToGo", "");

		libs.VerifyText(PGO_vehicleFlyOut.txt_viewSavedDeals(driver), data.getExcelData(dRw,"Txt_View_All_Saved_Vechicle","Vehicle Flyout"), "Txt_View_All_Saved_Vechicle", "");
		libs.VerifyText(PGO_vehicleFlyOut.lnk_addNwVhcle(driver), data.getExcelData(dRw,"Txt_Add_New_Vehicle","Vehicle Flyout"), "Txt_Add_New_Vehicle", "");
		libs.IMGValidation(PGO_vehicleFlyOut.Img_Addnewvehicle(driver), "verify the add new vechicle image", "Add new vechicle image is dispalyed", "Img_Addnewvehicle");
		libs.clickOnButton(PGO_vehicleFlyOut.img_vehicleFlyOut(driver),"img_vehicleFlyOut");
		System.out.println("'Vehicle Flyout' testcase is passed.");
		test.log(LogStatus.PASS,"'Vehicle Flyout' testcase is passed.") ;
		}catch(Exception vehFlyOutException)
		{
			System.out.println("'Vehicle Flyout' testcase is failed.");
			data.writeExceldata(dRw,"Result", "Vehicle Flyout","Fail");
			getscrnSht.getscreenshot(driver,scrnshtPthNm);
			test.log(LogStatus.FAIL, vehFlyOutException.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
	}

	void unexpctedpopup()
	{
		try{
			if(PGO_landing_page.img_closeDialog(driver).isDisplayed()) {
			PGO_landing_page.img_closeDialog(driver).click(); }

		}catch(Exception exception)
		{
			System.out.println("unexpected pop up not opended");	
		}
	}
}
