package pageClasses;
import java.util.List;
import java.util.Set;

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
			searchInventoryNavigation(dRw);
			Thread.sleep(1000);
			String text1=libs.gettingText(PGO_vehicleCards.vehIconno(driver),"vehIconno");
			test.log(LogStatus.INFO,"Number of saved vehicles"+" " +text1);
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
					int totalVinNumbers=PGO_vehicleFlyOut.saved_vechicles(driver).size();
					test.log(LogStatus.INFO, "Total Vinumber in Search Inventory " +totalVinNumbers);
					clickOnButton(PGO_vehicleFlyOut.SelectDelarprice(driver,vinumber), "select delar price for" +vinumber+")");
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
	

}
