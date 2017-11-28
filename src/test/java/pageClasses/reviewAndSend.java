package pageClasses;
import org.testng.annotations.AfterTest;
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.LogStatus;
public class reviewAndSend extends rsg_DriverClass
{
	FuncitonLibrary libs = new FuncitonLibrary();
	VehicleDetails vehicledetails=new VehicleDetails();
	creditForm creditForm=new creditForm();
	public void reviewAndSend_run(int dRw) throws Exception
	{
		try
		{
		  invokeReport("Verify Review and Send Tab",dRw);
		  test.log(LogStatus.INFO, "Review and Send Tab", "Review and Send Tab execution starts..");
		  if(ValidationStatus.equalsIgnoreCase("Yes"))
		  {
		   AllvalidationForReviewandsendpage(dRw);
		  }
		  else
		  {
		   reviewAndSendTab(dRw);
		  }
		}
		catch(Exception e)
		{
			Count++;
			System.out.println("Review & Send testcase is failed.");
			test.log(LogStatus.FAIL,"Review & Send testcase is failed.");
			data.writeExceldata(dRw,"Result","reviewAndSend","Failed");	
		}
		tearReport();
	}
	public void  AllvalidationForReviewandsendpage(int dRw) throws Exception
	{
	try
	{	
		libs.componenttHeading("Submit Billboard Text Verification");
		libs.VerifyText(PGO_reviewAndSend.heading(driver), data.getExcelData(1,"Heading","reviewAndSend"),"Review and Send Heading","");
    	libs.VerifyText(PGO_reviewAndSend.subHeading(driver), data.getExcelData(1,"Text","reviewAndSend"),"Review and Send Sub Heading","");
    	libs.componenttHeading("Dealer Location Map");
    	vehicledetails.delearMap();
  		dealerInformationBlock(dRw); 
  		saveAndPrint(dRw);
		vehicleDetails(dRw,2);
        tradein(dRw,2);
	    payment(dRw);
        libs.componenttHeading("Protection Plans Verification");
        libs.VerifyText(PGO_reviewAndSend.protectionNote(driver), PGO_reviewAndSend.protectionNote(driver).getText(), "protectionnote", "");	
		test.log(LogStatus.INFO,"Protection Plans in Ford");
		int plans=PGO_reviewAndSend.protectionPlans(driver).size();
		for(int i=0;i<plans;i++)
		{
		  test.log(LogStatus.INFO,PGO_reviewAndSend.protectionPlans(driver).get(i).getText());
		}
		reviewAndSendTab(dRw);
		}
	catch(Exception Exception)
	 {
		 Count++;
		 getscrnSht.getscreenshot(driver,scrnshtPthNm );
         test.log(LogStatus.FAIL, "Script has stopped in Vehicle Details page", test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
       }
    tearReport();
	}
	public void dealerInformationBlock(int dRw) throws Exception
	{
		String scrnshtPthNm=scrnshtPth+"Dealer_Information_Block_Failed"+".jpg";
		try
		{
		libs.componenttHeading("Dealer Information Verification");	
		libs.VerifyText(PGO_reviewAndSend.dealerInformationHeading(driver),data.getExcelData(1,"Dealer Information Heading","reviewAndSend"),"dealerInformationHeading","");
		test.log(LogStatus.INFO, "Dealer Details");
		test.log(LogStatus.INFO, PGO_reviewAndSend.dealerAddress(driver).getText());
	    libs.VerifyText(PGO_reviewAndSend.directions(driver), data.getExcelData(1, "Directions","reviewAndSend"), "directions","");
		libs.VerifyElement(PGO_reviewAndSend.dealerlocationMap(driver),"DealerLocationMap", driver, test, dRw);
		int iframecount=0;
	  	String  parentHandle = null;
	  	libs.clickOnButton(PGO_reviewAndSend.directions(driver), "directions");
	  	try
	  	{
	  	  parentHandle = driver.getWindowHandle(); 
	  	  for (String winHandle : driver.getWindowHandles())
	  	  {
	  		driver.switchTo().window(winHandle); 
	  		iframecount++;
	  	  }
	  	  test.log(LogStatus.PASS, "Directions link is Clicked","Directions link is Opened in a new Window");
	  	  if(iframecount==2)
	  	  {
	  	  driver.close(); 
	  	  }
	  	  driver.switchTo().window(parentHandle); 
	  	  }
	  	  catch(Exception E)
	  	  {
	  	   driver.close(); 
	  	   driver.switchTo().window(parentHandle); 
	  	  }
	  	test.log(LogStatus.PASS, "Directions link is Closed","Directions link is Closed" );
	  	libs.componenttHeading("Our Pledge to Clear Pricing Verification");	
	    libs.VerifyElement(PGO_reviewAndSend.pledgeIcon(driver),"PledgeIcon", driver, test, dRw);
	    libs.VerifyText(PGO_reviewAndSend.pledgeHeading(driver), data.getExcelData(1,"Pledge Heading","reviewAndSend"), "pledgeHeading","");
	    libs.VerifyText(PGO_reviewAndSend.pledge(driver), data.getExcelData(1,"Pledge","reviewAndSend"), "pledge","");
		}
	    catch(Exception dealerInformationBlock)
		{
			Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm);
			test.log(LogStatus.FAIL, dealerInformationBlock.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm) ));
		}
	   }
		public void saveAndPrint(int dRw) throws Exception
		{
		String scrnshtPthNm=scrnshtPth+"saveAndPrint_Section_Failed"+".jpg";
		try
		{
		libs.componenttHeading("Save and Print Section Verification");			 
		libs.VerifyText(PGO_reviewAndSend.savePrintHeading(driver), data.getExcelData(1,"Save and Print Heading","reviewAndSend"), "savePrintHeading","");
	    libs.VerifyText(PGO_reviewAndSend.savePrintText(driver), data.getExcelData(1,"Save and Print Text","reviewAndSend"), "savePrintText","");
	    libs.VerifyText(PGO_reviewAndSend.printMyDealLink(driver), data.getExcelData(1,"Link","reviewAndSend"), "printMyDealLink","'");
	    int iframecount1=0;
	  	String  parentHandle1 = null;
	  	libs.clickOnButton(PGO_reviewAndSend.printMyDealLink(driver), "printMyDealLink");
	  	try
	  	{
	  	  parentHandle1 = driver.getWindowHandle(); 
	  	  for (String winHandle : driver.getWindowHandles())
	  	  {
	  		driver.switchTo().window(winHandle); 
	  		iframecount1++;
	  	  }
	  	  test.log(LogStatus.PASS, "Print My Deal hyperlink is clicked","Print Certificate PDF opened in a new Window");
	  	  if(iframecount1==2)
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
		test.log(LogStatus.PASS, "Print My Deal hyperlink is Closed","Print Certificate PDF Closed" );
		}
		catch(Exception saveAndPrint)
		{
			Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm);
			test.log(LogStatus.FAIL, saveAndPrint.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm) ));
		}
	}
	public void vehicleDetails(int dRw,int position)throws Exception
	{
	 String scrnshtPthNm=scrnshtPth+"Vehicle_Details_Failed"+".jpg";
	 try
	 {
		 libs.componenttHeading("Vehicle Details Accordion");	
		 test.log(LogStatus.INFO,"Vehicle Model"+"  "+"-"+PGO_reviewAndSend.vehicleModel(driver,position).getText());
		 libs.VerifyText(PGO_reviewAndSend.vehicleModel(driver,position), data.getExcelData(dRw,"VehicleName", "SearchVehicle"), "vehicleModel", "");
		 test.log(LogStatus.INFO, "Vehicle Details");
		 int labelsize=PGO_reviewAndSend.vehicleLabels(driver,position).size();
		 for(int i=0; i<labelsize; i++)
		 {
		    String vehiclelabel=PGO_reviewAndSend.vehicleLabels(driver,position).get(i).getText();
		    test.log(LogStatus.INFO,vehiclelabel+" "+"-"+ PGO_reviewAndSend.vehicleDetails(driver,position).get(i).getText());
		    libs.VerifyText(PGO_reviewAndSend.vehicleDetails(driver,position).get(i), data.getExcelData(dRw,vehiclelabel,"Vehicle Details"), "vehicleDetails","");
		 }
		 libs.clickOnButton(PGO_reviewAndSend.totMsrpDreicon(driver,position),"totMsrpDreicon");
		 test.log(LogStatus.PASS,"CTA adjacent to Total MSRP is clicked and expanded successfully");
		 test.log(LogStatus.INFO, "Pricing Summary Details under Vehicle accordian");
		 int pricedetails= PGO_reviewAndSend.priceDetailsLabels(driver,position).size();
		  for(int i=0;i<pricedetails;i++)
		  {
			  if(i==4)
			  {
				  test.log(LogStatus.INFO, PGO_reviewAndSend.priceDetailsLabels(driver,position).get(i).getText());
				  System.out.println(PGO_reviewAndSend.priceDetailsLabels(driver,position).get(i).getText().replaceAll("[\\D]", ""));
				  System.out.println(data.getExcelData(dRw,"DifferencefromTotalMSRP","Vehicle Details"));
				  libs.VerifyPartialText(PGO_reviewAndSend.priceDetailsLabels(driver,position).get(i),data.getExcelData(dRw,"DifferencefromTotalMSRP","Vehicle Details"),"priceDetails","Yes");
				  continue;
			  }
			  String pricelabel = PGO_reviewAndSend.priceDetailsLabels(driver,position).get(i).getText();
			  test.log(LogStatus.INFO, PGO_reviewAndSend.priceDetailsLabels(driver,position).get(i).getText());
			  System.out.println(PGO_reviewAndSend.priceDetailsLabels(driver,position).get(i).getText().replaceAll("[\\D]", ""));
			  System.out.println(data.getExcelData(dRw,pricelabel.replaceAll("[^A-Za-z]", "").trim(),"Vehicle Details"));
			  libs.VerifyPartialText(PGO_reviewAndSend.priceDetailsLabels(driver,position).get(i), data.getExcelData(dRw,pricelabel.replaceAll("[^A-Za-z]", "").trim(),"Vehicle Details"), "priceDetails","Yes");
			 }
		  libs.VerifyText(PGO_reviewAndSend.txt_Vehicleaccordion(driver,position), data.getExcelData(dRw,"Text in Vehicle Accordion","reviewAndSend"), "txt_Vehicleaccordion","");
		  }
		catch(Exception vehicleDetails)
		{
			Count++;
			getscrnSht.getscreenshot(driver,scrnshtPth );
            test.log(LogStatus.FAIL, vehicleDetails.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
	}
	public void tradein(int dRw,int position)throws Exception
	{
			String scrnshtPthNm=scrnshtPth+"Tradein_Details_Failed"+libs.timestamp1()+".jpg";
			libs.componenttHeading("Trade-In Accordion");
			try
			{
			 String tradeinval=data.getExcelData(dRw,"Result","KBBTradeIn");
			 if(tradeinval.equals("Not Executed"))
			 {
			   test.log(LogStatus.INFO,"Your Tradein Skipped");	 
			   libs.VerifyText(PGO_reviewAndSend.skipTradeinHeading(driver), data.getExcelData(dRw,"Skip Tradein Heading","reviewAndSend"), "skipTradeinHeading", "");
			   libs.VerifyText(PGO_reviewAndSend.skipTradeinText(driver), data.getExcelData(dRw,"Skip Tradein Text","reviewAndSend"), "skipTradeinText", "");
			 }
			 else
			 {
			    test.log(LogStatus.INFO,"Your Tradein Accordion");
				test.log(LogStatus.INFO,"Trade-In Vehicle Model -"+PGO_reviewAndSend.tradeinVehicleModel(driver,position).getText());
				System.out.println(PGO_reviewAndSend.tradeinVehicleModel(driver,position).getText());
				String expected=data.getExcelData(dRw,"kbbYearSelect","KBBTradeIn")+"  "+data.getExcelData(dRw,"kbbMakeSelect","KBBTradeIn")+"  "+data.getExcelData(dRw,"kbbModelSelect","KBBTradeIn");
				System.out.println(expected);
				libs.VerifyText(PGO_reviewAndSend.tradeinVehicleModel(driver,position), expected, "tradeinVehicleModel", "");
				test.log(LogStatus.INFO,"Trade-In Details");
				int labelsize=PGO_reviewAndSend.tradeinVehicleDetailsLabel(driver,position).size();
				for(int i=0;i<labelsize;i++)
				{
				  String vehiclelabel = PGO_reviewAndSend.tradeinVehicleDetailsLabel(driver,position).get(i).getText().replaceAll("[^A-Za-z]", "").trim();
				  System.out.println(vehiclelabel);
				  System.out.println(data.getExcelData(dRw,vehiclelabel.replaceAll("[^A-Za-z]", "").trim(),"KBBTradeIn"));
				  if(i == 0 || i == 2 )
				  {
				    System.out.println(PGO_reviewAndSend.tradeinVehicleDetails(driver,position).get(i).getText().trim());
				    test.log(LogStatus.INFO,PGO_reviewAndSend.tradeinVehicleDetails(driver,position).get(i).getText().trim());
				    libs.VerifyText(PGO_reviewAndSend.tradeinVehicleDetails(driver,position).get(i), data.getExcelData(dRw,vehiclelabel.replaceAll("[^A-Za-z]", "").trim(),"KBBTradeIn"), "KBBTradeIn","");
				  }
				  else
				  {
					System.out.println(PGO_reviewAndSend.tradeinVehicleDetails(driver,position).get(i).getText().replaceAll("[\\D]", "").trim());
					test.log(LogStatus.INFO,PGO_reviewAndSend.tradeinVehicleDetails(driver,position).get(i).getText().trim());
					libs.VerifyText(PGO_reviewAndSend.tradeinVehicleDetails(driver,position).get(i), data.getExcelData(dRw,vehiclelabel.replaceAll("[^A-Za-z]", "").trim(),"KBBTradeIn"), "KBBTradeIn","Yes");  
				  }
				 }  
				
				}
			}
			catch(Exception tradein)
			{
				Count++;
				getscrnSht.getscreenshot(driver,scrnshtPthNm );
	            test.log(LogStatus.FAIL, tradein.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
	}
	public void payment(int dRw)throws Exception
	{
			String scrnshtPthNm=scrnshtPth+"Payment_Failed"+libs.timestamp()+".jpg";
			int PaymentValue=0;
			try
			{
			 String paymentval=data.getExcelData(dRw,"Result","PaymentCalculator");
			 if(paymentval.equals("Not Executed"))
			 {
			   libs.VerifyText(PGO_reviewAndSend.skipPaymentHeading(driver), data.getExcelData(dRw,"Skip Payment Heading","reviewAndSend"), "skipPaymentHeading", "");
			   libs.VerifyText(PGO_reviewAndSend.skipPaymentText(driver), data.getExcelData(dRw,"Skip Payment Text","reviewAndSend"), "skipPaymentText", "");  
			 }
			 else
			 {				 
				libs.clickOnButton(PGO_reviewAndSend.estimatedTaxesDreicon(driver),"totMsrpDreicon");
				test.log(LogStatus.PASS,"CTA adjacent to Estimated taxes & Fees total is clicked and expanded successfully");
				int paymentTabValueNumber=PGO_reviewAndSend.paymentTab_Lables(driver).size();
				System.out.println(paymentTabValueNumber);
				 //Payment Tab Label =PTL
				  for(int PTL=0;PTL<paymentTabValueNumber;PTL++)
				  {
					  if(PGO_reviewAndSend.paymentTab_Lables(driver).get(PTL).getText().isEmpty())
					  continue;
					  String paymentlabel= PGO_reviewAndSend.paymentTab_Lables(driver).get(PTL).getText().replaceAll("[^A-Za-z]", "").trim();
					  System.out.println(paymentlabel);
					  String Expected=data.getExcelData(dRw,paymentlabel.replaceAll("[^A-Za-z]", "").trim(),"PaymentCalculator");
					  System.out.println(Expected);
					  			 				 
					 if(PaymentValue == 7 || PaymentValue == 9 || PaymentValue == 13) {
						 PaymentValue=PaymentValue+1; 
					 }
					 System.out.println(PGO_reviewAndSend.paymentTab_Values(driver).get(PaymentValue).getText().replaceAll("[\\D]", ""));
//					 String paymentvalues= PGO_reviewAndSend.paymentTab_Values(driver).get(PaymentValue).getText();
					 libs.VerifyText(PGO_reviewAndSend.paymentTab_Values(driver).get(PaymentValue), Expected, paymentlabel, "Yes");
					 PaymentValue++;
				}
				}
			}
			catch(Exception payment)
			{
			   Count++;
			   getscrnSht.getscreenshot(driver,scrnshtPth );
	           test.log(LogStatus.FAIL, payment.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
	}
		public void reviewAndSendTab(int dRw) throws Exception
	    {
	     String scrnshtPthNm=scrnshtPth+"Review_Send_tab_Failed"+".jpg";
	     libs.componenttHeading("Send to Dealer Form");
	     try
		{
	    	String firstName = data.getExcelData(dRw,"FirstName","reviewAndSend");
			String lastName = data.getExcelData(dRw,"LastName","reviewAndSend");
			String email = data.getExcelData(dRw,"EmailAddress","reviewAndSend");
			String phone = data.getExcelData(dRw,"PrimaryPhoneNumber","reviewAndSend");
			test.log(LogStatus.INFO,"Filling Send to dealer form");
			libs.enterValueIntoTextField(PGO_reviewAndSend.txt_firstName(driver),"txt_firstName",firstName);
			libs.enterValueIntoTextField(PGO_reviewAndSend.txt_lastName(driver),"txt_lastName",lastName);
			libs.enterValueIntoTextField(PGO_reviewAndSend.txt_email(driver),"txt_email",email);
			libs.enterValueIntoTextField(PGO_reviewAndSend.txt_phone(driver),"txt_phone",phone);
			test.log(LogStatus.PASS,"Send to dealer form filled successfully");
			if(data.getExcelData(dRw,"SendMyDeal","reviewAndSend").equalsIgnoreCase("Yes"))
			{
				libs.clickOnButton(PGO_reviewAndSend.btn_sendMyDeal(driver), "Send My Dealer");	
				dealSubmissionOverlay(dRw);
				afterdealSubmission(dRw);
			}
			else
			{
				tearReport();
				creditForm.creditForm_run(dRw);
			}
		}
			catch(Exception reviewAndSendTab)
			{
				 Count++;
				getscrnSht.getscreenshot(driver,scrnshtPthNm );
	            test.log(LogStatus.FAIL, reviewAndSendTab.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
	    }	
	public void dealSubmissionOverlay(int dRw) throws Exception	
	{
	String scrnshtPthNm=scrnshtPth+"dealSubmissionOverlay_Failed"+libs.timestamp1()+".jpg";	
	libs.componenttHeading("Verfication of overlay once deal submission");
	try
 	{
	  test.log(LogStatus.INFO,libs.gettingText(PGO_reviewAndSend.dealSubmissionHeading(driver),"dealSubmissionHeading"));
	  libs.VerifyText(PGO_reviewAndSend.dealSubmissionText(driver),data.getExcelData(1,"Congrats Message","reviewAndSend"),"dealSubmissionText","");
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
	   test.log(LogStatus.PASS, "View and Print My Deal ", "View and Print My Deal is clicked");	
	   if(iframecount==2)
	   {
		 Thread.sleep(2000);   
		 driver.close();
	   }
	   driver.switchTo().window(parentHandle1); 
	   }
	   catch(Exception E)
	  {
		driver.close(); 
		driver.switchTo().window(parentHandle1); 
	  }
 	}
	  catch(Exception dealSubmissionOverlay)
	{
		Count++;
		getscrnSht.getscreenshot(driver,scrnshtPth );
        test.log(LogStatus.FAIL, dealSubmissionOverlay.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
	}
	}
	
	/**
	 * --------------------------------Method------------------------------
	 * Method Name: < afterdealSubmission > 
	 * Description: <This method will do all the Verification once deal is submitted in Review and Send page>
	 * Author: <Chandra Reddy K > 
	 * Created Date: < 09/28/2017 > 
	 * Modified By and On: <Nagendra >
	 * Modified Comments: < >
	 * --------------------------------------------------------------------
	 *  
	 */
	public void afterdealSubmission(int dRw) throws Exception
	{
      String scrnshtPthNm=scrnshtPth+"Review and send section failed"+libs.timestamp1()+".jpg";
	  try
	  {
		libs.componenttHeading("Review and Send Tab Verification once deal is submitted");  
		test.log(LogStatus.INFO, "Deal Sent time: "+ PGO_reviewAndSend.txt_dealSentTime(driver).getText());	
		test.log(LogStatus.INFO, "Deal Number: "+ PGO_reviewAndSend.txt_dealNo(driver).getText());
		libs.VerifyText(PGO_reviewAndSend.afterdealMessageheading(driver),data.getExcelData(dRw,"Message 3","reviewAndSend"),"afterdealMessageheading","");
		dealerInformationBlock(dRw);
		libs.componenttHeading("Dealer Contact Details");  
		libs.VerifyElement(PGO_creditApp.img_contact(driver),"img_contact", driver, test, dRw);
		libs.VerifyText(PGO_creditApp.heading_contact(driver),data.getExcelData(dRw,"Your Contact Information","reviewAndSend"),"afterdealMessageheading","");
		test.log(LogStatus.INFO, "Dealer Contact Details", PGO_creditApp.txt_crdtAppDlrNm(driver).getText());
		test.log(LogStatus.INFO,PGO_creditApp.txt_crdtAppDlrNm(driver).getText());
		vehicleDetails(dRw,1);
        tradein(dRw,1);
		//payment(dRw);
        libs.VerifyText(PGO_reviewAndSend.protectionNote(driver), PGO_reviewAndSend.protectionNote(driver).getText(), "protectionnote", "");	
		test.log(LogStatus.INFO,"Protection Plans in Ford");
		int plans=PGO_reviewAndSend.protectionPlans(driver).size();
		for(int i=0;i<plans;i++)
		{
		  test.log(LogStatus.INFO,PGO_reviewAndSend.protectionPlans(driver).get(i).getText());
		}
	    libs.VerifyText(PGO_reviewAndSend.afterdealSubmissionText(driver), data.getExcelData(dRw,"Message 2","reviewAndSend"), "afterdealSubmissionText", "");	
		System.out.println(data.getExcelData(dRw,"Message 2","reviewAndSend"));
		int iframecount=0;
	  	String  parentHandle = null;
	  	libs.clickOnButton(PGO_reviewAndSend.afterdealPrintbutton(driver), "afterdealPrintbutton");
	  	try
	  	{
	  	  parentHandle = driver.getWindowHandle(); 
	  	  for (String winHandle : driver.getWindowHandles())
	  	  {
	  		driver.switchTo().window(winHandle); 
	  		iframecount++;
	  	  }
	  	  test.log(LogStatus.PASS, "View & Print my deal is clicked");
	  	  if(iframecount==2)
	  	  {
	  	  driver.close(); 
	  	  }
	  	  driver.switchTo().window(parentHandle); 
	  	}
	  	catch(Exception E)
	  	{
		  driver.close(); 
		  driver.switchTo().window(parentHandle); 
		  }
		  
	  	if(ValidationStatus.equalsIgnoreCase("Yes"))
	  	{
	  	try {
			System.out.println("Clicked on the after deal validation code");
		  	clickOnButton(PGO_reviewAndSend.clickonSavedVehicleIcon(driver), "clickonSavedVehicleIcon");
		  	Thread.sleep(500);
		  	clickOnButton(PGO_reviewAndSend.lnk_AllSavedVehicle(driver), "lnk_AllSavedVehicle");
		  	vehicleCards vCards = new vehicleCards();
		  	vCards.ValidatVehicleCardAfterDealSubmission(dRw);
	  		}catch(Exception VehicleCardException){
			getscrnSht.getscreenshot(driver, scrnshtPth+"Vehicle_Card_After_DealSubmitted_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, VehicleCardException.getMessage(),test.addScreenCapture(scrnshtPth +"Vehicle_Card_After_DealSubmitted"+libs.timestamp1()+".jpg") );		
			data.writeExceldata(dRw,"Result", "Vehicle_Card_After_DealSubmitted","Failed");
	  		}
	  	}
	  	test.log(LogStatus.PASS, "After deal submission,Print my deal is displayed,clicked and verified successfully" );
		System.out.println("Review & Send testcase is Passed.");
		test.log(LogStatus.PASS,"Review & Send testcase is Passed.");
		data.writeExceldata(dRw,"Result","reviewAndSend","Passed");
	  }
		catch(Exception afterdealSubmission)
		{
		  Count++;
		  tearReport();
		  getscrnSht.getscreenshot(driver,scrnshtPthNm);
		  test.log(LogStatus.FAIL, afterdealSubmission.getMessage() ,test.addScreenCapture(Screenpathforreport(scrnshtPth +"afterdealVerification"+".jpg") ));
	    }
	}
	@AfterTest
	public void tearReport(){
	report.endTest(test);
	report.flush();
	}
}



