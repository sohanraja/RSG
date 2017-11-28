package pageClasses;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;
import pageClasses.rsg_DriverClass;
import pageObjectClasses.PGO_VehicleDetails;
public class VehicleDetails extends rsg_DriverClass
{
  JavascriptExecutor jse = (JavascriptExecutor)driver;
  Actions action=new Actions(driver);
  int sheetno=9;

  public void gtVehicleDtls_run(int dRw) throws Exception
	{   
	    try
	    {
	    String runVal = data.getExcelData(dRw, "Vehicle Details", "Testcases");
	    invokeReport("Verify Vehicle Details tab",dRw);
	    test.log(LogStatus.INFO, "Verify Vehicle Details Page ","Vehicle Details Page loads successfully");
		switch(runVal)
		{
		case "Yes":
			if(ValidationStatus.equalsIgnoreCase("Yes"))
			{
				AllvalidationForVechicleDetailspage(dRw);
			    mvToKBBTrade();
			}
			else
			{
			    mvToKBBTrade();
			    test.log(LogStatus.INFO,"Vehicle Details test case is Passed");
		        data.writeExceldata(dRw,"Result","Vehicle Details","Passed");
			}
			break;
		case "No":
			mvToKBBTrade();
			test.log(LogStatus.INFO,"Vehicle Details testcase will not be executed");
			data.writeExceldata(dRw,"Result","Vehicle Details","Not Executed");
			break;
		}
	     tearReport();
	}
	catch(Exception VehicledetailsTab)
	{
		Count++;
		String scrnshtPthNm=scrnshtPth+"Vehicle_details_tab_"+".jpg";
		data.writeExceldata(dRw,"Result","Vehicle Details","Failed");
		test.log(LogStatus.FAIL,"Vehicle details testcase is failed");
		getscrnSht.getscreenshot(driver,scrnshtPthNm );
        test.log(LogStatus.FAIL, VehicledetailsTab.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
        tearReport();
     }
     }
  
  public void  AllvalidationForVechicleDetailspage(int dRw) throws Exception
  {
	try
	{ 
	  String Expected_Pricing_Summary_Heading=data.getExcelData(1, "Expected Pricing Summary Heading", "Vehicle Details");
	  bottomtext=data.getExcelData(1, "Bottom_Text", "Vehicle Details");
	  String Zipcodeerrormsg=data.getExcelData(1, "Zipcode_Msg", "Vehicle Details");
	  String inValidZipcode=data.getExcelData(1, "ZipCode_Invalid", "Vehicle Details");
	  SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, YYYY");
	  bottomtext=bottomtext.replaceAll("Date", formatter.format(date));
	  String Kelly_Blue_txt=data.getExcelData(1, "Kelly_Blue_txt", "Vehicle Details");
	  String Price_Pledge_Heading=data.getExcelData(1, "Price Pledge Heading", "Vehicle Details");
	  String Price_Pledge=data.getExcelData(1, "Price Pledge", "Vehicle Details");
	  String locationCd = data.getExcelData(1, "Dealer Code", "SearchVehicle");
	  libs.GlobalHeadingBar();
	  
	  libs.componenttHeading("Delete Deal");
	  DeleteDeal(dRw);
	  
	  libs.componenttHeading("Delear Map");
	  delearMap();
	  libs.tabList("Vehicle Details Page");
	  
	  libs.componenttHeading("Pricing Summary");
	  pricingSummary(dRw);
	  test.log(LogStatus.INFO, "Pricing Summary details data has written into excel sheet" );
	  
	  libs.componenttHeading("Your Vehicle Text Verification");
	  libs.VerifyText(PGO_VehicleDetails.txt_YourVechicleHeading0(driver), data.getExcelData(1, "txt_YourVechicleHeading0", "Vehicle Details"), "txt_YourVechicleHeading","");
	  libs.VerifyPartialText(PGO_VehicleDetails.txt_YourVechicleHeading1(driver), data.getExcelData(1, "txt_YourVechicleHeading0", "Vehicle Details"), "txt_YourVechicleHeading","");
	  libs.VerifyText(PGO_VehicleDetails.txt_YourVechicleHeading2(driver), data.getExcelData(1, "txt_YourVechicleHeading0", "Vehicle Details"), "txt_YourVechicleHeading","");
	  yourVehicleTabReading(dRw);
	  test.log(LogStatus.INFO, "Section vinDetails data has written into excel sheet" );
	  
	  libs.componenttHeading("View window sticker");
	  ViewStickbar(dRw);
	

	  libs.componenttHeading("Zipcode Verification");
	  libs.enterValueIntoTextField(PGO_VehicleDetails.txt_Zipcode(driver), "txt_Zipcode", inValidZipcode);
	  Thread.sleep(3000);
	  libs.VerifyText(PGO_VehicleDetails.error_Zipcode(driver), Zipcodeerrormsg, "error_Zipcode", "");
	  libs.enterValueIntoTextField(PGO_VehicleDetails.txt_Zipcode(driver), "txt_Zipcode", locationCd);
	  // your pricing summary
	  libs.componenttHeading("Price and Estimated Pre-Tax price text verification");
	  libs.VerifyText(PGO_VehicleDetails.txt_YourPricingSummary(driver), Expected_Pricing_Summary_Heading, "txt_YourPricingSummary", "");
	  libs.VerifyText(PGO_VehicleDetails.txt_YourEstimatedPretax(driver), data.getExcelData(1, "Estimated Pre Tax Price Inline Text", "Vehicle Details"), "txt_YourEstimatedPretax", "");
	  //kelley blue
	  libs.componenttHeading("Kelly Blue Book Widget");
	  libs.IMGValidation(PGO_VehicleDetails.img_KellyBlue(driver), "Verify the Kelly blue image", "Kelly blue image has been displayed", "img_KellyBlue");
	  libs.VerifyText(PGO_VehicleDetails.txt_KellyBlue(driver), Kelly_Blue_txt, "txt_KellyBlue", "");
	  kellyBlueBook(dRw);
	  //our Pledge
	  libs.componenttHeading("Pricing Pledge Verification");
	  libs.IMGValidation(PGO_VehicleDetails.img_ourpledge(driver), "Verify Pledge image", "Our Pledge image has been displayed", "img_ourpledge");
	  libs.VerifyText(PGO_VehicleDetails.txt_ourpledge_Heading(driver), Price_Pledge_Heading, "txt_ourpledge_Heading", "");
	  libs.VerifyText(PGO_VehicleDetails.txt_ourpledge_Desc(driver), Price_Pledge, "txt_ourpledge_Desc", "");
	  //bottom text
	  libs.componenttHeading("Bottom text Verification");
	  libs.VerifyText(PGO_VehicleDetails.txt_BottomText(driver), bottomtext, "txt_BottomText", "");
	  comparePrice();
	  libs.Pagedisclaimers("Vehicle Details",10);
	  libs.Disclosers();
	  libs.GlobalBottomBar();
	  
	 }catch(Exception Exception  )
	  {
		  Count++;
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
          test.log(LogStatus.FAIL, "Script has stopped in Vehicle Details page", test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
  }
  }
  public void pricingSummary(int dRw) throws Exception
  {
	  test.log(LogStatus.INFO, "Vehicle Details tab execution starts..");
	  String scrnshtPthNm=scrnshtPth+"Vehicle_Details"+".jpg";
	  try
	  {
	  String exptitle=data.getExcelData(dRw, "Expected Pricing Summary Heading", "Vehicle Details");
	  //libs.VerifyText(PGO_VehicleDetails.pricingSummary(driver), exptitle,"Pricing Summary Heading","");
	  libs.clickOnButton(PGO_VehicleDetails.dreicon(driver), "dreicon");
	  test.log(LogStatus.PASS, "Total MSRP dre icon clicked and expanded successfully" );
	  int ele=PGO_VehicleDetails.msrpElements1(driver,dRw).size();
	  for(int i=0;i<ele;i++)
	  {
		 String vehlabel= PGO_VehicleDetails.msrpElementsLabel(driver,dRw).get(i).getText();
		 String vehdet=PGO_VehicleDetails.msrpElements1(driver,dRw).get(i).getText();
		 test.log(LogStatus.INFO,vehlabel+" "+'-'+" "+vehdet);
		 System.out.println("column name : "+vehlabel.replaceAll("[^A-Za-z]", "").trim()+" value:"+vehdet.replaceAll("[\\D]", "").trim());
		 data.writeExceldata(dRw,vehlabel.replaceAll("[^A-Za-z]", "").trim(), "Vehicle Details",vehdet.replaceAll("[\\D]", "").trim());
	  }
	  test.log(LogStatus.PASS, "Price summary details verified successfully" );
	  libs.clickOnButton(PGO_VehicleDetails.dreicon1(driver), "dreicon");
	  test.log(LogStatus.PASS, "Total MSRP dre icon clicked back successfully" ); 
	  }
	  catch(Exception pricingSummary )
	  {
		  Count++;
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
          test.log(LogStatus.FAIL, pricingSummary.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
  }
  }
  public void priceCal(int dRw) throws Exception
 {
	  String scrnshtPthNm=scrnshtPth+"Vehicle_details_Calculation"+".jpg";
	  try
	  {
	  int totalmsrp2=libs.stringToInt(data.getExcelData(dRw,"TotalMSRP","Vehicle Details"));
	  int basemsrp2=libs.stringToInt(data.getExcelData(dRw,"BaseMSRP","Vehicle Details"));
	  int totaloptions2=libs.stringToInt(data.getExcelData(dRw,"TotalofOptions","Vehicle Details"));
	  int descharg2=libs.stringToInt(data.getExcelData(dRw,"DestinationandDeliveryCharges","Vehicle Details"));
	  int sum=basemsrp2+totaloptions2+descharg2;
	  if(totalmsrp2==sum)
	  {
		test.log(LogStatus.PASS,"Total MSRP is Base MSRP plus total of options plus destination and delivery charges");
	  }
	 else
	 {
		getscrnSht.getscreenshot(driver, scrnshtPthNm);
		test.log(LogStatus.FAIL,"Total MSRP is not Base MSRP plus total of options plus destination and delivery charges",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
	  }
	  int diffmsrp2=libs.stringToInt(data.getExcelData(dRw,"DifferencefromTotalMSRP","Vehicle Details"));
	  int dealprice2=libs.stringToInt(data.getExcelData(dRw,"DealerSellingPrice","Vehicle Details"));
	  int diff=totalmsrp2-dealprice2;
	  if(diffmsrp2!=diff)

	  {
		test.log(LogStatus.PASS, "Difference from total MSRP is difference between the Total MSRP and dealer selling price" );
	  }
	  else
	  {
		  getscrnSht.getscreenshot(driver, scrnshtPthNm);
		  test.log(LogStatus.FAIL, "Difference from total MSRP is not the difference between Total MSRP and dealer selling price",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
	  }
	  int avalin2=libs.stringToInt(data.getExcelData(dRw,"CurrentAvailableIncentives","Vehicle Details"));
	  if(avalin2==0)
	  {
		  test.log(LogStatus.INFO,"There are currently no incentives available for the vehicle");
	  }
	  else
	  {
		  test.log(LogStatus.INFO,"Incentives available for the vehicle:"+avalin2);
	  }
	  int est2=libs.stringToInt(data.getExcelData(dRw,"YourEstimatedPreTaxPrice","Vehicle Details"));
	  int est3=dealprice2-avalin2;
	  if(est2==est3)
	  {
		test.log(LogStatus.PASS, "Estimated Pre Tax Price is comprised of Dealer Selling price and available incentives" );
	  }
	  else
	  {
		 getscrnSht.getscreenshot(driver, scrnshtPthNm);
	    test.log(LogStatus.FAIL, "Estimated Pre Tax Price is not comprised of Dealer Selling price and available incentives",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
	  }
	  }
	  catch(Exception priceCal )
	  {
		  Count++;
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
          test.log(LogStatus.FAIL, priceCal.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
  }
	}

  public void kellyBlueBook(int dRw) throws Exception
  { 

	  String scrnshtPthNm=scrnshtPth+"Vehicle_details_tab_"+".jpg";
	  try
	  {
	  libs.VerifyElement(PGO_VehicleDetails.kellyblue(driver),"Kelly Blue Book Image",driver,test, dRw);
	  libs.VerifyElement(PGO_VehicleDetails.kellyblueBookButton(driver),"Kelly Blue Book Image",driver,test, dRw);
	  libs.clickOnButton(PGO_VehicleDetails.kellyblueBookButton(driver),"kellyblueBookButton");
	  test.log(LogStatus.PASS, "Kelly blue book button clicked successfully" );
	  int elems=PGO_VehicleDetails.kellyblueTitle(driver).size();
	  test.log(LogStatus.INFO,"Vehicle model details inside Kelly blue book : ");
	  for(int m=0;m<elems;m++)
	  {
	   String text=	 PGO_VehicleDetails.kellyblueTitle(driver).get(m).getText();
	   data.writeToExcel(text,dRw, 36+m, sheetno);
	   test.log(LogStatus.INFO, PGO_VehicleDetails.kellyblueTitle(driver).get(m).getText() );
	  } 
	  String text=data.getExcelData(dRw, "Kelly blue book Vehicle Year", "Vehicle Details");
	  String text1=data.getExcelData(dRw, "Kelly blue book Vehicle Make", "Vehicle Details");
	  String text3=text+" "+text1;
	  String text4=data.getExcelData(dRw,"VehicleName","SearchVehicle");
	  if(text3.contains(text4))
	  {
		  test.log(LogStatus.PASS, "Vehicle model inside kelly blue book is same as selected vehicle" );
	  }
	  else
	  {
		  getscrnSht.getscreenshot(driver,scrnshtPthNm);
		  test.log(LogStatus.FAIL, "Vehicle model inside kelly blue book is not same as selected vehicle", test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
	  }
	  String expvinno=data.getExcelData(dRw,"VehicleVin","SearchVehicle");
	  String expvinno1="VIN: "+expvinno;
	  libs.VerifyText(PGO_VehicleDetails.kellyblueVin(driver), expvinno1,"Vin No Inside Kelly Book","");
	  test.log(LogStatus.INFO, "Kelly blue book VIN - "+PGO_VehicleDetails.kellyblueVin(driver).getText());
	  libs.VerifyElement(PGO_VehicleDetails.kellybluecanvas(driver),"Kelly Blue Book Canvas",driver,test,dRw);
	  PGO_VehicleDetails.kellyblueClose(driver).click();
	  test.log(LogStatus.PASS, "Kelly blue book closed successfully" );  
	   }
  catch(Exception kellyBlueBook)
  {
	  Count++;
	  getscrnSht.getscreenshot(driver,scrnshtPthNm );
      test.log(LogStatus.FAIL, kellyBlueBook.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
}
  }
  
  
  public void yourVehicleTabReading(int dRw) throws IOException
  {
	  int yourVechicleName=PGO_VehicleDetails.txt_yourVechicleLabel(driver,dRw).size();
	  for(int i=0;i<yourVechicleName;i++)
	  {
		 String vehlabel= PGO_VehicleDetails.txt_yourVechicleLabel(driver,dRw).get(i).getText();
		 String vehdet=PGO_VehicleDetails.txt_yourVechicleValue(driver,dRw).get(i).getText();
		 test.log(LogStatus.INFO,vehlabel+" "+'-'+" "+vehdet);

		 System.out.println("column name  "+vehlabel.replaceAll("[^A-Za-z]", "").trim()+" value:"+vehdet);
		 data.writeExceldata(dRw,vehlabel.replaceAll("[^A-Za-z]", "").trim(), "Vehicle Details",vehdet);
	  }
  }
  public  void DeleteDeal(int dRw) throws Exception{
	  libs.clickOnButton(PGO_VehicleDetails.btn_deleteDeal(driver), "btn_deleteDeal");
	  test.log(LogStatus.PASS, "Click on Delete Deal button", "delete deal button has been clicked");
	  libs.clickOnButton(PGO_VehicleDetails.btn_deleteDeal_Cancel(driver), "btn_deleteDeal_Cancel");
	  
  }
  public void ViewStickbar(int dRw) throws Exception{
	  int iframecount=0;
	  String  parentHandle1 = null;
	  libs.clickOnButton(PGO_VehicleDetails.lnk_VieWindowSticker(driver), "lnk_VieWindowSticker");
	  try {
	   parentHandle1 = driver.getWindowHandle(); 
	  for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); 
		    iframecount++;
	  }
		    	test.log(LogStatus.PASS, "Verify view window sticker ", "view window sticker has been opened");	
		    	if(iframecount==2){
		    	driver.close(); }
				driver.switchTo().window(parentHandle1); 
		  
	  
	  }catch(Exception E){
		  driver.close(); 
			driver.switchTo().window(parentHandle1); 
	  }
  }

  public void comparePrice() throws Exception
  {
	 libs.clickOnButton(PGO_VehicleDetails.Btn_comparePrice(driver), "Btn_comparePrice"); 
	 test.log(LogStatus.INFO, "Click on Compare Price ", "Compare price popup opended");
	 libs.clickOnButton(PGO_VehicleDetails.Btn_comparePrice_close(driver), "Btn_comparePrice_close"); 
  }
  
  public void delearMap() throws Exception
  {
	  libs.clickOnButton(PGO_VehicleDetails.lnk_Mapview(driver), "lnk_Mapview");
	  test.log(LogStatus.PASS, "Click on Delear Location Map ", "Dealer Location Map Opened");
	  libs.clickOnButton(PGO_VehicleDetails.lnk_Mapview_Close(driver), "lnk_Mapview_Close"); 
	  test.log(LogStatus.PASS, "Close Dealer Location map ", "Dealer Location Map Closed");
  }
  public void mvToKBBTrade() throws Exception
	{
	  Thread.sleep(4000);
	  clickOnButton(PGO_VehicleDetails.btn_nexvalueyourtradein(driver), "Next: Value Your Trade-In");
	
	   test.log(LogStatus.INFO,"Next: Value Your Trade-In button clicked and navigated to Trade-In page successfully");
	   if(PGO_VehicleDetails.btn_nexvalueyourtradein(driver).isDisplayed()){
		   clickOnButton(PGO_VehicleDetails.btn_nexvalueyourtradein(driver), "Next: Value Your Trade-In");  
	   }
	}


}