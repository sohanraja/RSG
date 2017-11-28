package pageClasses;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.TextVerticalOverflow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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
public class vehicleCards extends rsg_DriverClass{

	WebDriverWait wait = new WebDriverWait(driver,40);
	FuncitonLibrary libs = new FuncitonLibrary();
	Actions actions = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
    int SheetNum =8;

	public void vhclCrds_run(int dRw) throws Exception
	{
		String runVal = data.getExcelData(dRw,"Vehicle Cards","Testcases");
		System.out.println(runVal);
		try{
		switch(runVal)
		{
				case "Yes":
					invokeReport("Verify vehicleCards",dRw);
					addVehicleCard(dRw);

					tearReport();
					break;
				case "No":
					System.out.println("'Vehicle Cards' testcase is not executed.");
					data.writeToExcel("Not Executed", dRw, 2, SheetNum);
					break;
				}
		}
		catch(Exception e)
		{
			tearReport();
		}
	}

	public void addVehicleCard(int dRw)throws Exception
	{

		String scrnshtPthNm=scrnshtPth+"Vehicle_Cards"+".jpg";
		
		try
		{
			try
			{
				clickOnButton(PGO_vehicleFlyOut.img_vehicleFlyOut(driver), "img_vehicleFlyOut");
				test.log(LogStatus.INFO, "Verify Flayout image", "Vehicle Flyout image is displayed and clicked successfully");
				clickOnButton(PGO_VehicleDetails.slct_lnkText(driver, "View All Saved Vehicles"), "View All Saved Vehicles");
		    if(PGO_vehicleCards.closePopup(driver).isDisplayed())
		    {
		    test.log(LogStatus.INFO,"No saved deals");
			PGO_VehicleDetails.popup_close(driver).click();
		    }		  
			}
			catch(Exception e)
			{
				test.log(LogStatus.INFO,"There are Saved deals");

			}

			String text=libs.gettingText(PGO_vehicleCards.vehIconno(driver),"vehIconno");
			test.log(LogStatus.INFO,"Number of saved vehicles"+" " +text);
			
			boolean addNewVehiclecard =PGO_vehicleCards.txt_addNewVehicle(driver).isDisplayed();
			test.log(LogStatus.INFO,"addNewVehiclecard is displayed: "+ libs.gettingText(PGO_vehicleCards.txt_addNewVehicle(driver),"txt_addNewVehicle"));
			if(text.equals("50"))
			{
			 if(addNewVehiclecard==false)
             {
            	 System.out.println("50 deals are saved so Add a New Vehicle card is not displayed");
 			     test.log(LogStatus.PASS,"50 deals are saved so Add a New Vehicle card is not displayed");
             }
			 else
			 {
				 System.out.println("Add a New Vehicle card is displayed though 50 deals are saved");
 			     test.log(LogStatus.FAIL,"Add a New Vehicle card is displayed though 50 deals are saved",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			 }
		   }
			else
			{
			// addNewVehicle_heading verification
			test.log(LogStatus.INFO,"Add new vehicle card is displayed");

			//Verify if add new vehicle icon displayed
			libs.IMGValidation(PGO_vehicleCards.img_addNewVehicle_icon(driver),"verify the add new vechicle image", "Add new vechicle image is dispalyed","Add New Vehicle icon");
						
			// Add new vehicle link verification
			libs.VerifyText(PGO_vehicleCards.img_addNewVehicle_link(driver),data.getExcelData(1,"addNewVehicle_link","VehicleCards"),"img_addNewVehicle_link","");
			
			// Search Inventory link verification
			libs.VerifyText(PGO_vehicleCards.img_searchInventory_link(driver),data.getExcelData(dRw,"searchInventory_link","VehicleCards"),"img_searchInventory_link","");
			clickOnButton(PGO_vehicleCards.img_searchInventory_link(driver), "img_searchInventory_link");
			Thread.sleep(1000);
			String showroomURL = driver.getCurrentUrl();
			String ExpectedContent = data.getExcelData(1, "Validate_Inventroy", "SearchVehicle");
	
			if(showroomURL.contains(ExpectedContent))
			{
				  test.log(LogStatus.PASS,"Verify the  text/Number("+ExpectedContent+")", "Text/Number has been verified successfully.");

				  
			  } else {

				  scrnshtPthNm=scrnshtPth+ExpectedContent+".jpg";
				  getscrnSht.getscreenshot(driver,scrnshtPthNm );
				  test.log(LogStatus.FAIL, "Verify the Text/Number("+ExpectedContent+")", "actual Text/Number does't matched with  expected text"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );


			  
			}
			searchInventoryNavigation(dRw);
			Thread.sleep(1000);
			String text1=libs.gettingText(PGO_vehicleCards.vehIconno(driver),"vehIconno");
			test.log(LogStatus.INFO,"Number of saved vehicles"+" " +text1);
			VerifyElement(PGO_vehicleFlyOut.Total_saved_vechicle(driver),"totalSavedVehicleCount",driver,test,dRw);
			}
		}
			catch(Exception addVehicleCard)
			{
				getscrnSht.getscreenshot(driver, scrnshtPth +"addVehicleCard"+".png");
				test.log(LogStatus.FAIL, addVehicleCard.getMessage(), test.addScreenCapture(scrnshtPth +"addVehicleCard"+".png") );
			}
	}
			//New Method
			public String  searchInventoryNavigation(int dRw) throws Exception
			{
				String parentwindow;
				String vinumber=data.getExcelData(dRw, "VinNumber", "VehicleCards");
				try
				{
					
					String vehicleName = data.getExcelData(dRw,"VehicleName","VehicleCards");
					
					String[] vehicleName1=vehicleName.split(" ");
					vehicleName=vehicleName1[1].toUpperCase();
					libs.clickOnButton(PGO_landing_page.slct_text(driver, vehicleName), vehicleName);
					test.log(LogStatus.INFO, "selected Vechicle Name: " +data.getExcelData(dRw,"VehicleName","VehicleCards"));
					Thread.sleep(1000);
					String inventroyURL = driver.getCurrentUrl();
					System.out.println(inventroyURL);
					String ExpectedContent = data.getExcelData(1, "Validate_Inventroy", "SearchVehicle");
					if(inventroyURL.contains(ExpectedContent))
					{
						  test.log(LogStatus.PASS,"Verify the  text/Number("+ExpectedContent+")", "Text/Number has been verified successfully.");

						  
					  } else {

						  scrnshtPthNm=scrnshtPth+ExpectedContent+".jpg";
						  getscrnSht.getscreenshot(driver,scrnshtPthNm );
						  test.log(LogStatus.FAIL, "Verify the Text/Number("+ExpectedContent+")", "actual Text/Number does't matched with  expected text"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );


					  
					}
					int totalVinNumbers=PGO_vehicleFlyOut.saved_vechicles(driver).size();
					test.log(LogStatus.INFO, "Total Vinumber in Search Inventory " +totalVinNumbers);
					clickOnButton(PGO_vehicleFlyOut.SelectDelarprice(driver,vinumber), "select dealer price for" +vinumber+")");
					if(applicationname.contains("RSGDEV")){

						driver.get("https://wwwdev.retail.ford.com/buy/deal-details?vin="+vinumber+"&pacode=02058#/0/vehicle-details");
					}
					if(applicationname.contains("RSGINT")){

						driver.get("https://wwwint.retail.ford.com/buy/deal-details?vin="+vinumber+"&pacode=02058#/0/vehicle-details");
					}
					if(applicationname.contains("RSGQA")){

						driver.get("https://wwwqa.shop.ford.com/buy/deal-details?vin="+vinumber+"&pacode=02058#/0/vehicle-details");
					}
					if(applicationname.contains("CTPQA")){

	 					driver.get("https://wwwqa.shop.lincoln.com/ctp/deal-details.html?pacode=10493&zip=07701&vin="+vinumber);
	 				}
					if(applicationname.contains("CTPINT")){

	 					driver.get("https://wwwint.retail.lincoln.com/ctp/deal-details.html?pacode=10493&zip=07701&vin="+vinumber);
	 				}
					}
			
			catch(Exception searchInventoryNavigation)
			{
			getscrnSht.getscreenshot(driver, scrnshtPth +"Addingvechilcefromserchinventory"+".png");
			test.log(LogStatus.FAIL, searchInventoryNavigation.getMessage(), test.addScreenCapture(scrnshtPth +"Addingvechilcefromserchinventory"+".png") );
	}
				return vinumber;
	}
	
/**
 * --------------------------------Method------------------------------
 * Method Name: < ValidatVehicleCardAfterDealSubmission > 
 * Description: <This method will Switch between vehicle and verify the correct set of data is populated for a car which has a deal submitted and which is not submitted from saved vehicle cards after deal is submitted.>
 * Author: <Nagendra T S > 
 * Created Date: < 11/16/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 * 
 */
	public void ValidatVehicleCardAfterDealSubmission(int dRw) throws Exception
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/d/YYYY");
		int totalVinNumbers=PGO_vehicleFlyOut.saved_vechicles_vinnumber(driver).size();
		VerifyText(PGO_vehicleFlyOut.Total_saved_vechicle(driver), String.valueOf(totalVinNumbers), "TotalSavedVehicle", "");
		String vinNum ;
		for(int i=1;i<=totalVinNumbers;i++)
		{
		try{
			vinNum = data.getExcelData(dRw,  "VehicleVin", "SearchVehicle");
			String VinNumber = gettingText(PGO_vehicleFlyOut.saved_vechicles_vinnumber(driver, i),"VinNumber");
			VinNumber = VinNumber.split(":")[1].trim();
			if(vinNum.equalsIgnoreCase(VinNumber))
			{
				String DealSubmittedDetails= gettingText(PGO_vehicleCards.txt_DealSubmittedDetails(driver, i),"DealSubmittedDetails");
				String DealSubmittedText = data.getExcelData(1,  "Deal_Submitted_Text", "VehicleCards");
				DealSubmittedText=DealSubmittedText.replaceAll("Date", formatter.format(date));
				System.out.println(DealSubmittedDetails+">>>"+DealSubmittedText);
				if(DealSubmittedDetails.equalsIgnoreCase(DealSubmittedText))
				{
					test.log(LogStatus.PASS, "Deal Submitted Details is displayed in the Vehicle card page " +DealSubmittedDetails);
					break;
				}
			}
			
			}catch(Exception e)
			{
				System.out.println("Error in ValidatVehicleCardAfterDealSubmission vehicle card page");
			}
		}
		try{
			if(totalVinNumbers==1)
			{
				addVehicleCard(dRw);
			
 				Thread.sleep(500);
 				clickOnButton(PGO_reviewAndSend.clickonSavedVehicleIcon(driver), "clickonSavedVehicleIcon");
 			  	Thread.sleep(500);
 			  	clickOnButton(PGO_reviewAndSend.lnk_AllSavedVehicle(driver), "lnk_AllSavedVehicle");
			}
		DeleteSavedItemAfterDealSubmission(dRw);
		clickOnButton(PGO_vehicleFlyOut.saved_vechicles_delete(driver, 1), "delete");
		Thread.sleep(2000);
		clickOnButton(PGO_vehicleFlyOut.saved_vechicles_delete_pop_Yes(driver), "Yes");
		Thread.sleep(2000);
	  	DeleteSavedItemAfterDealSubmission(dRw);
		}catch(Exception searchInventoryException)
		{
			getscrnSht.getscreenshot(driver, scrnshtPth +"searchInventory_Failed_"+libs.datestamp()+".jpg");
			test.log(LogStatus.FAIL, searchInventoryException.getMessage(), test.addScreenCapture(scrnshtPth +"searchInventory_Failed_"+libs.datestamp()+".jpg") );
		}
}
	/**
	 * --------------------------------Method------------------------------
	 * Method Name: < DeleteSavedItemAfterDealSubmission > 
	 * Description: <This method will Delete a car and then verify the deal count on vdp page and saved deals page.>
	 * Author: <Nagendra T S > 
	 * Created Date: < 11/17/2017 > 
	 * Modified By and On: < >
	 * Modified Comments: < >
	 * --------------------------------------------------------------------
	 * 
	 */
	public void DeleteSavedItemAfterDealSubmission(int dRw)
	{
		int SavedvehicleList=0;
		try {
			SavedvehicleList = Integer.parseInt(gettingText(PGO_vehicleFlyOut.Total_saved_vechicle(driver),""));
		
			int TotalsavedVechicles = PGO_vehicleFlyOut.saved_vechicles_vinnumber(driver).size();
			
			if(SavedvehicleList == TotalsavedVechicles)
			{
				test.log(LogStatus.PASS, "Saved Vehicle count is matching with the saved Vechicles in the Vehicle cards page ");
			}else
			{
				test.log(LogStatus.FAIL, "Saved Vehicle count is NOT matching with the saved Vechicles in the Vehicle cards page ");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
