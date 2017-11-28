package pageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;
import libraryClasses.FuncitonLibrary;
import pageClasses.rsg_DriverClass;
import pageObjectClasses.PGO_PaymentCalculator;
import pageObjectClasses.PGO_SpecialOffers;
import pageObjectClasses.PGO_VehicleDetails;
import pageObjectClasses.PGO_reviewAndSend;
public class PaymentCalculator extends rsg_DriverClass
{
	FuncitonLibrary libs = new FuncitonLibrary();
	Actions action=new Actions(driver);
	
	public void PaymentCalculator_run(int dRw) throws Exception
	{
		try
		{
		invokeReport("Verify Payment Calculator",dRw);
		String runVal = data.getExcelData(dRw,"Payment Calculator","Testcases");
		String option= data.getExcelData(dRw,"PaymentOption","PaymentCalculator");
		switch(runVal)
		{
		case "Yes":
			pay(dRw);
			if(ValidationStatus.equalsIgnoreCase("Yes"))
			{
				allValidationForPayment();
				libs.clickOnButton(PGO_PaymentCalculator.txt_paymentType(driver,option), option);
				allValidationForPaymentType(dRw,option);
				mvreviewandsend(dRw);
				test.log(LogStatus.PASS,"Payment Test case is passed");
				data.writeExceldata(dRw, "Result", "PaymentCalculator", "Passed");
			}
			else
			{
				libs.clickOnButton(PGO_PaymentCalculator.txt_paymentType(driver,option), option); 
				mvreviewandsend(dRw);
				test.log(LogStatus.PASS,"Payment Test case is passed");
				data.writeExceldata(dRw, "Result", "PaymentCalculator", "Passed");
				}
			break;
		case "No":
			pay(dRw);
			skipPaymntal(dRw);
			libs.clickOnButton(PGO_reviewAndSend.btn_reviewAndSend(driver),"btn_reviewAndSend");
			test.log(LogStatus.INFO,"Payment Calculator testcase will not be executed");
			data.writeExceldata(dRw,"Result","PaymentCalculator","Not Executed");
			break;
		}
		  tearReport();
		}
	     catch(Exception PaymentCalculator)
		 {
			PaymentCalculator.printStackTrace();
			Count++;
			test.log(LogStatus.FAIL,"Payment tab testcase is failed.");
			data.writeExceldata(dRw, "Result","PaymentCalculator","Failed");
			getscrnSht.getscreenshot(driver, scrnshtPth+"Payment tab_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL,  PaymentCalculator.getMessage(),test.addScreenCapture(Screenpathforreport( scrnshtPth+"Payment tab_Failed_"+libs.timestamp1()+".jpg")) );
			tearReport();
			
		}
	}
		
		
	/**
	 * --------------------------------Method------------------------------
	 * Method Name: < mvreviewandsend > 
	 * Description: <This method will navigate to Review and Send Page and then to Special Offers page>
	 * Author: <Mohana Priya Easwaran > 
	 * Created Date: < 20/11/2017 > 
	 * Modified By and On: < >
	 * Modified Comments: < >
	 * --------------------------------------------------------------------
	 */
		public void mvreviewandsend(int dRw)
		{
		 try
		 {
		 libs.clickOnButton(PGO_SpecialOffers.btn_SpecialOffers(driver), "Next: Special Offers");
		 test.log(LogStatus.PASS, "Special Offers page loads successfully" );
		 libs.clickOnButton(PGO_reviewAndSend.btn_reviewAndSend(driver),"btn_reviewAndSend");
		 test.log(LogStatus.PASS, "Review and Send tab page loads successfully" );
		 }
		 catch(Exception e)
		 {
			System.out.println("PGO_SpecialOffers.btn_SpecialOffers Failure");
		 }
		}
		
		/**
		 * --------------------------------Method------------------------------
		 * Method Name: < pay > 
		 * Description: <This method will navigate to Payment Introduction Page>
		 * Author: <Mohana Priya Easwaran > 
		 * Created Date: < 20/11/2017 > 
		 * Modified By and On: < >
		 * Modified Comments: < >
		 * --------------------------------------------------------------------
		 */
	public void pay(int dRw) throws Exception
	{
		try
		{
		String tradval=data.getExcelData(dRw, "KBB Trade In", "Testcases");
		if(tradval.equals("Yes"))
		{
			libs.clickOnButton(PGO_PaymentCalculator.btn_next_Payment_continue(driver), "btn_next_Payment_continue");
			test.log(LogStatus.PASS,  "Navigated to Payment Introduction Page");
		}
		else
		{
			test.log(LogStatus.PASS,  "Navigated to Payment Introduction Page");
		}
		}
		catch(Exception pay)
		{
			getscrnSht.getscreenshot(driver, scrnshtPth+"Payment tab_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL,  pay.getMessage(),test.addScreenCapture(Screenpathforreport( scrnshtPth+"Payment tab_Failed_"+libs.timestamp1()+".jpg")) );
		}
	}
	/**
	 * --------------------------------Method------------------------------
	 * Method Name: < allValidationForPayment > 
	 * Description: <This method will validate all the major components in payment page>
	 * Author: <Chandra Reddy K > 
	 * Created Date: < 09/27/2017 > 
	 * Modified By and On: < >
	 * Modified Comments: < >
	 * --------------------------------------------------------------------
	 * @throws Exception 
	 */
	
	public void allValidationForPayment() throws Exception{
		try{
		if(ValidationStatus.equalsIgnoreCase("Yes")){
			
		libs.GlobalHeadingBar();
		libs.tabList("Vehicle Details Page");
		libs.componenttHeading("Get Your Payment Estimate Text verification");
		libs.VerifyText(PGO_PaymentCalculator.paymentHeading(driver), data.getExcelData(1,"Payment Heading","PaymentCalculator"),"Payment Intro - Heading Text","");
		libs.VerifyText(PGO_PaymentCalculator.paymentInline(driver), data.getExcelData(1,"Payment Inline Text","PaymentCalculator"),"Payment Intro - Inline Text","");
		libs.Pagedisclaimers("PaymentCalculator",3);
		//bottom text
		libs.componenttHeading("Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.txt_BottomText(driver,14), data.getExcelData(1, "Bottom_Text", "Vehicle Details"), "txt_BottomText", "");
		}}catch(Exception e){
			scrnshtPthNm=scrnshtPthNm+"allValidationForPayment.jpg";
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, "allValidationForPayment", test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
				 
	 }
		
	/**
	 * --------------------------------Method------------------------------
	 * Method Name: < allValidationForPaymentType > 
	 * Description: <This method will validate all the major components in payment type page>
	 * Author: <Chandra Reddy K > 
	 * Created Date: < 09/28/2017 > 
	 * Modified By and On: <Mohana Priya Easwaran,22/11/2017 >
	 * Modified Comments: < >
	 * --------------------------------------------------------------------
	 * @throws Exception 
	 */
	
	public void allValidationForPaymentType(int dRw,String option) throws Exception{
		try {
		if(ValidationStatus.equalsIgnoreCase("Yes")){
		libs.GlobalHeadingBar();
		libs.tabList("Vehicle Details Page");
		switch(option)
		{
		case "Finance":
		//Text Verification
		libs.componenttHeading("Payment Inline Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.paymentInlinetext(driver,"buy"), data.getExcelData(1,"InlineText","PaymentCalculator"),"InlineText","");
		libs.componenttHeading("Step1 Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.txt_Step1Heading(driver,1), data.getExcelData(1,"Step1_Heading","PaymentCalculator"),"Step1 Heading","");
		libs.componenttHeading("Step2 Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.txt_Step2Heading(driver), data.getExcelData(1,"Step2_Heading","PaymentCalculator"),"Step1 Heading","");
		libs.componenttHeading("Your Ford Credit APR Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.txt_Incentive_Rate(driver), data.getExcelData(1,"Incentive_Rate","PaymentCalculator"),"txt_Incentive_Rate","");
		libs.componenttHeading("Enter Your Own Rate Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.txt_User_Rate(driver), data.getExcelData(1,"User_Rate","PaymentCalculator"),"txt_User_Rate","");
		libs.componenttHeading("Zip code Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.txt_Zip_Code(driver,"buy"), data.getExcelData(1,"Zip_Code_Txt","PaymentCalculator"),"Zip_Code_Txt","");
		libs.componenttHeading("duration months");
		libs.VerifyText(PGO_PaymentCalculator.EstmMonthlyPaymentMonts(driver), data.getExcelData(1, "EstmMonthlyPaymentMonts", "PaymentCalculator"), "EstmMonthlyPaymentMonts", "");
		String monthValue = PGO_PaymentCalculator.TermInMonths(driver).getText();
		monthValue = monthValue.split(" ")[1];
		libs.TextCompare(monthValue, data.getExcelData(1, "TermInMonths", "PaymentCalculator"), "TermInMonths", "monthValue");
		//dm (duration months
		for(int dm=0;dm<11;dm++){
		libs.VerifyText(PGO_PaymentCalculator.duration(driver).get(dm), data.getExcelData(1,"Months"+dm,"PaymentCalculator"),"duration","");
		libs.VerifyPartialText(PGO_PaymentCalculator.avaliableIncentives(driver).get(dm), "Available Incentives","Available Incentives","");
		}
		Paymentcalculator(dRw,option);
		libs.Pagedisclaimers("PaymentCalculator",22);
		break;
		case "Lease":
		libs.componenttHeading("Payment Inline Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.paymentInlinetext(driver,"lease"), data.getExcelData(1,"InlineText","PaymentCalculator"),"InlineText","");
		libs.componenttHeading("Step1 Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.txt_Step1Heading(driver,2), data.getExcelData(1,"Step1_Heading","PaymentCalculator"),"Step1 Heading","");
		libs.componenttHeading("Step2 Text Verification");
		libs.VerifyText(PGO_PaymentCalculator.txt_leaseStep2Heading(driver), data.getExcelData(1,"Step2_Heading","PaymentCalculator"),"Step1 Heading","");
		  //bottom text
		libs.componenttHeading("bottom Disclaimer text");
		libs.VerifyText(PGO_PaymentCalculator.txt_Bottom_Disclaimer(driver), data.getExcelData(1, "txt_Bottom_Disclaimer", "PaymentCalculator"), "txt_Bottom_Disclaimer", "");
		  //bottom text
		libs.componenttHeading("bottom text");
		libs.VerifyText(PGO_PaymentCalculator.txt_BottomText(driver,14),bottomtext, "txt_BottomText", "");
		//Lease
		libs.selectValueFromDropDown(PGO_PaymentCalculator.Annual_Mileage(driver), data.getExcelData(1,"Annual_Mileage","PaymentCalculator"), "Annual_Mileage",0);
		libs.componenttHeading(" Select Your Down Payment(Lease) value comapre and calculation");
		Paymentcalculator(dRw,"Lease");
		ValidateAnnualPaymentAndPaymentDatails(dRw);
		libs.VerifyText(PGO_PaymentCalculator.EstmMonthlyPaymentMonts(driver), data.getExcelData(1, "EstmMonthlyPaymentMonts", "PaymentCalculator"), "EstmMonthlyPaymentMonts", "");
		monthValue = PGO_PaymentCalculator.TermInMonths(driver).getText();
		monthValue = monthValue.split(" ")[1];
		libs.TextCompare(monthValue, data.getExcelData(1, "TermInMonths", "PaymentCalculator"), "TermInMonths", "monthValue");
		libs.Pagedisclaimers("PaymentCalculator",22);
		case "Cash":
		//Cash
		libs.componenttHeading("Cash  Validations");
		libs.componenttHeading("bottom Disclaimer text");
		libs.VerifyText(PGO_PaymentCalculator.txt_Bottom_Disclaimer(driver), data.getExcelData(1, "txt_Bottom_Disclaimer", "PaymentCalculator"), "txt_Bottom_Disclaimer", "");
		  //bottom text
		libs.componenttHeading("bottom text");
		libs.VerifyText(PGO_PaymentCalculator.txt_BottomText(driver,14),bottomtext, "txt_BottomText", "");
		Thread.sleep(2000);
		libs.VerifyText(PGO_PaymentCalculator.EstmMonthlyPaymentMonts(driver), data.getExcelData(1, "EstmMonthlyPaymentMonts", "PaymentCalculator"), "EstmMonthlyPaymentMonts", "");
		monthValue = PGO_PaymentCalculator.TermInMonths(driver).getText();
		monthValue = monthValue.split(" ")[1];
		libs.TextCompare(monthValue, data.getExcelData(1, "TermInMonths", "PaymentCalculator"), "TermInMonths", "monthValue");
		Paymentcalculator(dRw,"Cash");
		libs.Pagedisclaimers("PaymentCalculator",22);
		}
		}
		}catch(Exception e){
			scrnshtPthNm=scrnshtPthNm+"allValidationForPaymentType.jpg";
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, "allValidationForPaymentType", test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
				 
	 }
	public void Paymentcalculator(int dRw,String  option) throws Exception
	{
		try{
			String poption=data.getExcelData(dRw, "Payment Type", "Testcases");
			String Temp,LabelName,Value; 
			String Temp1[];
			int Temp2;
			int LowerEstimatedMonthlypayment;
			libs.clickOnButton(PGO_PaymentCalculator.dreicon(driver,6), "dreicon");
		 //Payment Calculator : PC
		 int paymentCalculationsize=PGO_PaymentCalculator.paymentCalculation(driver,poption).size();
		 for(int PC=0;PC<paymentCalculationsize;PC++ ){
			 if(PGO_PaymentCalculator.paymentCalculation(driver,poption).get(PC).getText().isEmpty())
			 continue;
			 Temp=PGO_PaymentCalculator.paymentCalculation(driver,poption).get(PC).getText();
			 System.out.println(Temp);
			 LabelName=libs.getStringFromAlphaNumaric(Temp,"string");
			 System.out.println(LabelName);
			 Temp1=Temp.split("\\s+");
			 System.out.println(Temp1);
			 data.addColumn(LabelName, "PaymentCalculator");
			 data.writeExceldata(dRw, LabelName, "PaymentCalculator", Temp1[Temp1.length]);
			 
		 }
		 //LowerEstimatedMonthlypayment; : LEMP
		 LowerEstimatedMonthlypayment=Integer.parseInt(PGO_PaymentCalculator.Estimated_Monthly_Payment(driver,option).get(0).getText());
		 for(int LEMP=1;LEMP<PGO_PaymentCalculator.Estimated_Monthly_Payment(driver,"buy").size();LEMP++){
			 Temp2=Integer.parseInt(libs.getStringFromAlphaNumaric(PGO_PaymentCalculator.Estimated_Monthly_Payment(driver,option).get(LEMP).getText(),"number"));
			 if (LowerEstimatedMonthlypayment >Temp2) {
				 LowerEstimatedMonthlypayment=Temp2;
		        }
		 }
		 libs.componenttHeading("Verify the Estimated Monthly Payment value");
		 libs.TextCompare(Integer.toString(LowerEstimatedMonthlypayment), data.getExcelData(1, "EstimatedMonthlyPayment", "PaymentCalculator"), "Verify the Estimated Monthly Payment value", "Estimated Monthly Payment value is dispalyed as per the calculation");
		
		//Comparison of Current Available Incentives
		 libs.clickOnButton(PGO_PaymentCalculator.tab_vehicleDetailsTab(driver), "tab_vehicleDetailsTab");
		 int ele=PGO_VehicleDetails.msrpElements1(driver,dRw).size();
		  for(int i=0;i<ele;i++)
		  {
			 String vehlabel= PGO_VehicleDetails.msrpElementsLabel(driver,dRw).get(i).getText();
			 String vehdet=PGO_VehicleDetails.msrpElements1(driver,dRw).get(i).getText();
			 test.log(LogStatus.INFO,vehlabel+" "+'-'+" "+vehdet);
			 System.out.println("column name : "+vehlabel.replaceAll("[^A-Za-z]", "").trim()+" value:"+vehdet.replaceAll("[\\D]", "").trim());
			 data.writeExceldata(dRw,vehlabel.replaceAll("[^A-Za-z]", "").trim(), "Vehicle Details",vehdet.replaceAll("[\\D]", "").trim());
		  }
		 libs.clickOnButton(PGO_PaymentCalculator.tab_payment(driver), "tab_payment"); 
		 libs.componenttHeading("Comparing pricing value with Vehicle Details page");
		 libs.TextCompare( data.getExcelData(dRw, "BaseMSRP", "PaymentCalculator"), data.getExcelData(1, "BaseMSRP", "Vehicle Details"),"Verify Base MSRP value ","Value has been displayed as expected");
		 libs.TextCompare( data.getExcelData(dRw, "TotalofOptions", "PaymentCalculator"), data.getExcelData(dRw, "TotalofOptions", "Vehicle Details"),"Verify Total of Options value ","Value has been displayed as expected");
		 libs.TextCompare( data.getExcelData(dRw, "DestinationandDeliveryCharges", "PaymentCalculator"), data.getExcelData(dRw, "DestinationandDeliveryCharges", "Vehicle Details"),"Verify Destination and Delivery Charges value ","Value has been displayed as expected");
		 libs.TextCompare( data.getExcelData(dRw, "TotalMSRP", "PaymentCalculator"), data.getExcelData(dRw, "TotalMSRP", "Vehicle Details"),"Verify Total MSRP ","Value has been displayed as expected");
		 libs.TextCompare( data.getExcelData(dRw, "DifferencefromTotalMSRP", "PaymentCalculator"), data.getExcelData(dRw, "DifferencefromTotalMSRP", "Vehicle Details"),"Verify Difference from Total MSRP value ","Value has been displayed as expected");
		 libs.TextCompare( data.getExcelData(dRw, "DealerSellingPrice", "PaymentCalculator"), data.getExcelData(dRw, "DealerSellingPrice", "Vehicle Details"),"Verify Dealer Selling Price value ","Value has been displayed as expected");
		 libs.TextCompare( data.getExcelData(dRw, "AvailableIncentives", "PaymentCalculator"), data.getExcelData(dRw, "AvailableIncentives", "Vehicle Details"),"Verify Available Incentives value ","Value has been displayed as expected");
		 libs.TextCompare( data.getExcelData(dRw, "EstimatedNetTradeInAmount", "PaymentCalculator"), data.getExcelData(dRw, "EstimatedNetTradeInAmount", "Vehicle Details"),"Verify Estimated Net Trade In Amount value ","Value has been displayed as expected");
		 libs.TextCompare( data.getExcelData(dRw, "YourEstimatedPreTaxPrice", "PaymentCalculator"), data.getExcelData(dRw, "YourEstimatedPreTaxPrice", "Vehicle Details"),"Verify Your Estimated Pre Tax Price value ","Value has been displayed as expected");
		 //Comparision of Total MSRP Value
		 int acttotalmsrp=libs.stringToInt(data.getExcelData(dRw,"TotalMSRP","PaymentCalculator"));
		 System.out.println(acttotalmsrp);
		 int exptotalmsrp=libs.stringToInt(data.getExcelData(dRw,"BaseMSRP","PaymentCalculator"))+libs.stringToInt(data.getExcelData(dRw,"TotalofOptions","PaymentCalculator"))+libs.stringToInt(data.getExcelData(dRw,"DestinationandDeliveryCharges","PaymentCalculator"));
		 System.out.println(exptotalmsrp);
		 if(acttotalmsrp==exptotalmsrp)
		 {
		   test.log(LogStatus.PASS,"Total MSRP is sum of Base MSRP,Total of Options and Destination and DeliveryCharges");
		 }
		else
		{
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL,"Total MSRP is sum of Base MSRP,Total of Options and Destination and DeliveryCharges",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
	    }
		 //Verification of High Trade-In
		 String tradeinval = data.getExcelData(dRw, "Tradeinhighval", "KBBTradeIn");
		 if(tradeinval.equals("Yes"))
		 {
			 libs.VerifyElement(PGO_PaymentCalculator.txt_downPaymentAlert(driver), "txt_hightradeinAlert", driver, test, dRw);
			 libs.VerifyText(PGO_PaymentCalculator.txt_downPaymentAlertTitle(driver), data.getExcelData(1, "EstimatedAlertTitle", "PaymentCalculator"), "txt_downPaymentAlertTitle", "");
			 libs.VerifyText(PGO_PaymentCalculator.txt_downPaymentAlertText(driver), data.getExcelData(1, "EstimatedAlertText", "PaymentCalculator"), "txt_downPaymentAlertText", "");
		 }
		 else
		 {
			 libs.VerifyElement(PGO_PaymentCalculator.txt_downPaymentAlert(driver), "txt_hightradeinAlert", driver, test, dRw);
		 }
		    //InValid Zipcode Verification
			libs.componenttHeading("Invalid Zip Code Verification");
			libs.enterValueIntoTextField(PGO_PaymentCalculator.txt_Zipcode(driver,poption), "txt_Zipcode", data.getExcelData(1, "ZipCode_Invalid", "Vehicle Details"));
			Thread.sleep(3000);
			libs.VerifyText(PGO_VehicleDetails.error_Zipcode(driver), data.getExcelData(1, "Zipcode_Msg", "Vehicle Details"), "error_Zipcode", "");
			libs.enterValueIntoTextField(PGO_PaymentCalculator.txt_Zipcode(driver,"buy"), "txt_Zipcode", data.getExcelData(1, "Dealer Code", "SearchVehicle"));

		 }catch(Exception e){
			scrnshtPthNm=scrnshtPthNm+"Payemntcalculation.jpg";
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, "Payemntcalculation", test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
		 
	}
	
	
	public void skipPaymntal(int dRw) throws Exception
	{
		libs.clickOnButton(PGO_PaymentCalculator.btn_SkipPaymntCal(driver), "btn_SkipPaymntCal");
		test.log(LogStatus.INFO, "Payment Calculator Testcase is not Executed.");
	    data.writeExceldata(dRw, "Result", "PaymentCalculator", "Not Executed");
	 }
	
	
    
  

 
	
	
	
	 
	 	
		public void buyPymtEntrOwnApr(int dRw) throws Exception
		{

			try
			{
				Thread.sleep(1000);
                // entry of values in input box APR
                action.moveToElement(driver.findElement(By.xpath("//input[@data-ng-change='trackUserRate(userRate)']")));
                String defaultval=driver.findElement(By.xpath("//input[@data-ng-change='trackUserRate(userRate)']")).getAttribute("value");
                System.out.println(defaultval);
                driver.findElement(By.xpath("//input[@data-ng-change='trackUserRate(userRate)']")).clear();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//input[@data-ng-change='trackUserRate(userRate)']")).sendKeys("15.00");
                Thread.sleep(15000);
                //buypricingSummary(dRw);
			}			
			catch(Exception buyPymtEntrOwnApr)
			 {
				  Count++;
			  getscrnSht.getscreenshot(driver, scrnshtPth+"buyPymtEntrOwnApr_Failed_"+libs.timestamp1()+".jpg");
			  test.log(LogStatus.FAIL, buyPymtEntrOwnApr.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"buyPymtEntrOwnApr_Failed_"+libs.timestamp1()+".jpg") ));
			}			
		}
		
	  
		/**
		 * --------------------------------Method------------------------------
		 * Method Name: < estimateCalculation > 
		 * Description: <This method will Enter values in down payment, remaining balance in trade in, enter your own rate and validate the same in payment page>
		 * Author: <Nagendra > 
		 * Created Date: < 11/21/2017 > 
		 * Modified By and On: < >
		 * Modified Comments: < >
		 * --------------------------------------------------------------------
		 *  
		 */
		
		public void estimateCalculation() throws Exception
		{
		try{
			String value =gettingText(PGO_PaymentCalculator.txt_EstimateKBBTradeInValue(driver), "EstimateKBBTradeInValue");
			Thread.sleep(2000);
			value = value.substring(1).replaceAll(",", "");
			int intValue = parseInt(value);
			enterValueIntoTextField(PGO_PaymentCalculator.txt_EstimateKBBTradeInInput(driver), "EstimateKBBTradeInInput", value);
			PGO_PaymentCalculator.txt_EstimateKBBTradeInInput(driver).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			estimateNetTradeINPopupValidation();
			value=String.valueOf(intValue+1);
			enterValueIntoTextField(PGO_PaymentCalculator.txt_EstimateKBBTradeInInput(driver), "EstimateKBBTradeInInput", value);
			PGO_PaymentCalculator.txt_EstimateKBBTradeInInput(driver).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			estimateNetTradeINPopupValidation();
			value=String.valueOf(intValue-1);
			enterValueIntoTextField(PGO_PaymentCalculator.txt_EstimateKBBTradeInInput(driver), "EstimateKBBTradeInInput", value);
			PGO_PaymentCalculator.txt_EstimateKBBTradeInInput(driver).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			try{
				if(PGO_PaymentCalculator.txt_EstimateKBBTradeInPopupHeader(driver).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Popup is displayed..!! Not matching with exepected");
				}
				else{
					test.log(LogStatus.PASS, "Popup is NOT displayed..!! Not matching with exepected");
				}
				}catch(Exception estimateCalculation)
				{
					test.log(LogStatus.PASS, "Popup is NOT displayed..!! Not matching with exepected");
				}
			
		}catch(Exception estimateCalculation)
		  {
			  getscrnSht.getscreenshot(driver, scrnshtPth+"estimateNetTradeIN"+libs.timestamp1()+".jpg");
			  test.log(LogStatus.FAIL, estimateCalculation.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"estimateCalculation_FAiled"+libs.timestamp1()+".jpg") )); 
		  }
		}
		
		/**
		 * --------------------------------Method------------------------------
		 * Method Name: < estimateNetTradeINPopupValidation > 
		 * Description: <This method will validate after Entering values in down payment(Greater than or equal to), remaining balance in trade in, validate the pop up for the same in payment page>
		 * Author: <Nagendra > 
		 * Created Date: < 11/21/2017 > 
		 * Modified By and On: < >
		 * Modified Comments: < >
		 * --------------------------------------------------------------------
		 *  
		 */
	  public void estimateNetTradeINPopupValidation() throws Exception
	  {
		  try{
			  String PopupHeader = data.getExcelData(1, "Estimate_KBBTradeIn_Popup_Header", "PaymentCalculator");
			  String PopupBody = data.getExcelData(1, "Estimate_KBBTradeIn_Popup_Body", "PaymentCalculator");
			  String ActualPopupHeader = gettingText(PGO_PaymentCalculator.txt_EstimateKBBTradeInPopupHeader(driver), "PopupHeader");
			  String ActualPopupBody = gettingText(PGO_PaymentCalculator.txt_EstimateKBBTradeInPopupBody(driver), "PopupBody");
			  System.out.println(PopupHeader+" >> "+ActualPopupHeader);
			  System.out.println(PopupBody+" >> "+ActualPopupBody);
			  if(PopupHeader.equalsIgnoreCase(ActualPopupHeader))
			  {
				  test.log(LogStatus.PASS,"Estimate KBB Trade In Pop up Header value is same as expected"+PopupHeader);
			  }else{
				  test.log(LogStatus.FAIL,"Estimate KBB Trade In Pop up Header value is not same as expected"+PopupHeader);
			  }
			  if(PopupBody.equalsIgnoreCase(ActualPopupBody))
			  {
				  test.log(LogStatus.PASS,"Estimate KBB Trade In Pop up Body value is same as expected");
			  }else{
				  test.log(LogStatus.FAIL,"Estimate KBB Trade In Pop up Body value is  not same as expected"+PopupHeader);
			  }
			  clickOnButton(PGO_PaymentCalculator.btn_EstimateKBBTradeInPopupClose(driver), "Close");
			  Thread.sleep(500);
		  }catch(Exception estimateNetTradeINPopupValidation)
		  {
			  getscrnSht.getscreenshot(driver, scrnshtPth+"estimateNetTradeIN"+libs.timestamp1()+".jpg");
			  test.log(LogStatus.FAIL, estimateNetTradeINPopupValidation.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"estimateNetTradeINPopupValidation_FAiled"+libs.timestamp1()+".jpg") )); 
		  }
	  }        
	  
	  public void ValidateAnnualPaymentAndPaymentDatails(int dRw) throws Exception
	  {
		  try{
			  selectValueFromDropDown(PGO_PaymentCalculator.Select_AnnualPayment(driver),"", "AnnualPayment", 2);
			  Thread.sleep(4000);
			  Paymentcalculator(dRw+1,"Lease");
			  String annualPayment = gettingText(PGO_PaymentCalculator.Select_AnnualPayment(driver),"annualPayment");
			  data.addColumn("Annual_Mileage", "PaymentCalculator");
			  data.writeExceldata(dRw, "Annual_Mileage", "PaymentCalculator",annualPayment );
			  VerifyText(PGO_PaymentCalculator.Select_AnnualPayment(driver), data.getExcelData(dRw, "Annual_Mileage", "PaymentCalculator"), "annualPayment", "");
			  int position = PGO_PaymentCalculator.monthlyPaymentsList(driver).size();
			  String monthlyPaymentValue = gettingText(PGO_PaymentCalculator.monthlyPayments(driver, position), "MonthyPaymentAmt");
			  monthlyPaymentValue = monthlyPaymentValue.substring(1).split("/")[0];
			  data.addColumn("monthlyPayment", "PaymentCalculator");
			  data.writeExceldata(dRw, "monthlyPayment", "PaymentCalculator",monthlyPaymentValue );
			  libs.TextCompare(monthlyPaymentValue, data.getExcelData(dRw, "EstimatedMonthlyPayment", "PaymentCalculator"), monthlyPaymentValue, "EstimatedMonthlyPayment");
			  int downPayment = stringToInt(data.getExcelData(dRw, "downPayment", "PaymentCalculator"));
			  int firstEstimatedMonthlyPayment = stringToInt(data.getExcelData(dRw, "firstEstimatedMonthlyPayment", "PaymentCalculator"));
			  int estimatedNetTradeInAmount = stringToInt(data.getExcelData(dRw, "estimatedNetTradeInAmount", "PaymentCalculator"));
			  int total = stringToInt(data.getExcelData(dRw, "total", "PaymentCalculator"));
			  int totalValue = downPayment+firstEstimatedMonthlyPayment+estimatedNetTradeInAmount;
			  if(total==totalValue)
			  {
				  test.log(LogStatus.PASS,"Estimated Amount Due at Signing value is same as expected");
			  }else{
				  test.log(LogStatus.FAIL,"Estimated Amount Due at Signing value is  not same as expected");
			  }
			  
			  
		  }catch(Exception estimateNetTradeINPopupValidation)
		  {
			  getscrnSht.getscreenshot(driver, scrnshtPth+"estimateNetTradeIN"+libs.timestamp1()+".jpg");
			  test.log(LogStatus.FAIL, estimateNetTradeINPopupValidation.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"estimateNetTradeINPopupValidation_FAiled"+libs.timestamp1()+".jpg") )); 
		  }
	  }
	  
	  
	  
	  
	  
	 
	}

