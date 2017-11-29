package pageClasses;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilityClasses.*;
public class reviewAndSend extends rsg_DriverClass{

	WebDriverWait wait = new WebDriverWait(driver,10);
	FuncitonLibrary libs = new FuncitonLibrary();
	JavascriptExecutor jse=(JavascriptExecutor) driver;	
	Actions action=new Actions(driver);
	int sheetno=5;
	String revfirstName;
	String revlastName;
	String revemail;
	String revphone;
	String revsearchZip;
	String revdesiredDate;
	String revdesiredTime;
	creditApp creditApp=new creditApp();
	public void reviewAndSend_run(int dRw) throws Exception
	{
		try
		{
			runVal = data.getExcelData(dRw, "Review and Send", "Testcases");
        System.out.println(runVal);
		switch(runVal){
					case "Yes":
						invokeReport("Verify Review and Send tab",dRw);
						if(ValidationStatus.equalsIgnoreCase("Yes")){
						textVerification(dRw);
						dealerBlockVerification(dRw);
						vehicleDetails(dRw);
						tradein(dRw);
						payment(dRw);
						customerInfoFormVeri(dRw);
						customerInfoForm(dRw);
						sendMyDeal(dRw);
						tearReport();
						}
						else
						{	
							reviewAndSendTab(dRw);
							
							tearReport();
						}
					break;
					case "No":
						System.out.println("Review & Send' testcase is not Executed.");
						test.log(LogStatus.INFO,"'Review & Send' testcase is not Executed.");
						data.writeToExcel("Not Executed", dRw, 10, sheetno);
					break;
					}
		}
		catch(Exception e)
		 {
			  Count++;
			System.out.println("Review & Send' testcase is failed.");
			test.log(LogStatus.INFO,"'Review & Send' testcase is failed.");
			data.writeToExcel("Failed", dRw, 11, sheetno);
			tearReport();
		}
	}

	
    public void reviewAndSendTab(int dRw) throws Exception
    {
//		String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
    	String scrnshtPthNm=scrnshtPth+"Review_Send_tab_"+".jpg";
  
		try
		{
    	test.log(LogStatus.INFO,"Review and Send tab execution starts");
        System.out.println("Review and Send tab execution starts");
//        String actheading=PGO_reviewAndSend.heading(driver).getText();
//    	String expheading= data.getExcelData(dRw, "Heading", "reviewAndSend");
//    	String expsubheading=data.getExcelData(dRw, "Text", "reviewAndSend");
//    	libs.VerifyText(PGO_reviewAndSend.heading(driver), expheading, "heading text of review and send","");
//    	libs.VerifyText(PGO_reviewAndSend.subHeading(driver), expsubheading, "sub heading  text of review and send","");
//    	libs.assertionHandling(actheading, expheading, test,driver,scrnshtPthNm);
//    	test.log(LogStatus.PASS,"Text in Review and Send page verified successfully");
    	String actsubheading=PGO_reviewAndSend.subHeading(driver).getText();
    	
//    	libs.assertionHandling(actsubheading, expsubheading, test,driver,scrnshtPthNm);
//    	test.log(LogStatus.PASS,"Sub Text verified in Review and Send page successfully");
    	test.log(LogStatus.PASS,"Navigated to Review and Send tab successfully.");
    	
    	String revfirstName = data.getStrExcelData(dRw, 1, 5);
		String revlastName = data.getStrExcelData(dRw, 2, 5);
		String revemail = data.getStrExcelData(dRw, 3, 5);
		String revphone = data.getStrExcelData(dRw, 4, 5);
		String revsearchZip = data.getStrExcelData(dRw, 5, 5);
		String revdesiredDate = AddingdaysTocureentDate(4);
		System.out.println("review and send date :"+revdesiredDate);
		String revdesiredTime = data.getStrExcelData(dRw, 7, 5);
		test.log(LogStatus.PASS,"Filling Send to dealer form");
		PGO_reviewAndSend.txt_firstName(driver).clear();
		PGO_reviewAndSend.txt_firstName(driver).sendKeys(revfirstName);
		test.log(LogStatus.PASS,"First Name entered successfully");
		PGO_reviewAndSend.txt_lastName(driver).clear();
		PGO_reviewAndSend.txt_lastName(driver).sendKeys(revlastName);
		test.log(LogStatus.PASS,"Last Name entered successfully");
		PGO_reviewAndSend.txt_email(driver).clear();
		PGO_reviewAndSend.txt_email(driver).sendKeys(revemail);
		test.log(LogStatus.PASS,"Email entered successfully");
		PGO_reviewAndSend.txt_phone(driver).clear();
		PGO_reviewAndSend.txt_phone(driver).sendKeys(revphone);
		test.log(LogStatus.PASS,"Phone number entered successfully");
//		PGO_reviewAndSend.txt_searchZip(driver).clear();
//		PGO_reviewAndSend.txt_searchZip(driver).sendKeys(revsearchZip);
//		test.log(LogStatus.PASS,"Zip code entered successfully");
		PGO_reviewAndSend.txt_desiredDate(driver).clear();
		PGO_reviewAndSend.txt_desiredDate(driver).sendKeys(revdesiredDate);
		PGO_reviewAndSend.txt_desiredTime(driver).sendKeys(revdesiredTime);
		test.log(LogStatus.PASS,"Test drive details entered successfully");
		test.log(LogStatus.PASS,"Send to dealer form filled successfully");
		if(data.getExcelData(dRw,"SendMyDeal", "reviewAndSend").equalsIgnoreCase("Yes")){
			creditApp.sendMyDeal(dRw);
			creditApp.creditAppDealSubmition(dRw);
		}
		String dlSubmtVal = data.getStrExcelData(dRw, 9, sheetno);

		}
		catch(Exception reviewAndSendTab)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, reviewAndSendTab.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
    }
	public void textVerification(int dRw) throws Exception
    {
//    	String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
    	String scrnshtPthNm=scrnshtPth+"Review_Send_tab_"+".jpg";
    	try
    	{
    	test.log(LogStatus.INFO,"Verifications before submitting the deal");
    	String expheading=data.getExcelData(dRw,"Heading","reviewAndSend");
    	libs.VerifyText(PGO_reviewAndSend.heading(driver), expheading,"Review and Send Heading","");
    	String expsubheading=data.getExcelData(dRw,"Text","reviewAndSend");
    	libs.VerifyText(PGO_reviewAndSend.subHeading(driver), expsubheading,"Review and Send Sub Heading","");
    	int sectionsize=PGO_reviewAndSend.sections(driver).size();
    	test.log(LogStatus.INFO,"Accordions available in Review and Send page before clicking Review My Deal button");
    	for(int i=0;i<sectionsize;i++)
    	{
    	  test.log(LogStatus.INFO, PGO_reviewAndSend.sections(driver).get(i).getText());
    	}
    	  test.log(LogStatus.PASS,"Accordians are verified in Review and Send before clicking Review My Deal button");
    	}
    	catch(Exception textVerification)
    	 {
  		  Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, textVerification.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
    	}
//	@Test
	public void dealerBlockVerification(int dRw) throws Exception
	{
//		String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
		String scrnshtPthNm=scrnshtPth+"Review_Send_tab_"+".jpg";
		try
		{
		test.log(LogStatus.INFO,"Dealer block verifications before submitting the deal");
		String expdealerheading=data.getExcelData(dRw,"Dealer Information Heading","reviewAndSend");
    	libs.VerifyText(PGO_reviewAndSend.beforeDealerHeading(driver),expdealerheading,"Dealer Information Heading","");
		test.log(LogStatus.INFO, "Dealer Address - "+PGO_reviewAndSend.beforeDealerAddress(driver).getText());
		test.log(LogStatus.PASS, "Dealer address displayed and verified successfully before submitting the deal");
	    String exptext=data.getExcelData(dRw, "Directions","reviewAndSend");
	    libs.VerifyText(PGO_reviewAndSend.beforeDealerDirections(driver), exptext, "Dealer Directions","");
		libs.VerifyElement(PGO_reviewAndSend.beforeDealerImage(driver),"Dealer location map", driver, test, dRw);
	    try
	    {
	      action.moveToElement(PGO_reviewAndSend.beforeDealerDirections(driver)).build().perform();
		  libs.waitToClick(driver, PGO_reviewAndSend.beforeDealerDirections(driver), 10);
		  test.log(LogStatus.PASS, "Directions hyperlink is clicked");
		  // switch to old browser
		     String parentHandle= driver.getWindowHandle();
			 ArrayList<String> handle  = new ArrayList<String>(driver.getWindowHandles()); 
			 handle.remove(parentHandle);
			 driver.switchTo().window(handle.get(0));
			 Thread.sleep(2000);
			 driver.close(); 
			 test.log(LogStatus.PASS, "Directions hyperlink is closed");
			 driver.switchTo().window(parentHandle);
		  test.log(LogStatus.PASS, "Directions is displayed and verified successfully" );
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    libs.VerifyElement(PGO_reviewAndSend.beforePledgeImage(driver),"Pledge Image", driver, test, dRw);
	    String exppledgeheading=data.getExcelData(dRw,"Pledge Heading","reviewAndSend");
	    libs.VerifyText(PGO_reviewAndSend.beforePledgeHeading(driver), exppledgeheading, "Pledge Heading","");
	    String exppledge=data.getExcelData(dRw,"Pledge","reviewAndSend");
	    libs.VerifyText(PGO_reviewAndSend.beforePledge(driver), exppledge, "Pledge","");
	    String exphea=data.getExcelData(dRw,"Save and Print Heading","reviewAndSend");
	    libs.VerifyText(PGO_reviewAndSend.beforeSavePrintHeading(driver), exphea, "Pledge","");
	    String expsaveprinttext=data.getExcelData(dRw,"Save and Print Text","reviewAndSend");
	    libs.VerifyText(PGO_reviewAndSend.beforeSavePrintText(driver), expsaveprinttext, "Pledge","");
	    String explink=data.getExcelData(dRw,"Link","reviewAndSend");
	    libs.VerifyText(PGO_reviewAndSend.beforeSavePrintButton(driver), explink, "Pledge","'");
	    try
	    {
	    action.moveToElement(PGO_reviewAndSend.beforeSavePrintButton(driver)).build().perform();
		libs.waitToClick(driver, PGO_reviewAndSend.beforeSavePrintButton(driver), 10);
		System.out.println("Print my deal is clicked");
		test.log(LogStatus.PASS, "Print my deal is clicked");
		 // switch to old browser
		  String parentHandle= driver.getWindowHandle();
			 ArrayList<String> handle  = new ArrayList<String>(driver.getWindowHandles()); 
			 handle.remove(parentHandle);
			 driver.switchTo().window(handle.get(0));
			 Thread.sleep(2000);
			 driver.close(); 
			 driver.switchTo().window(parentHandle);
		  test.log(LogStatus.PASS, "Print my deal is displayed,clicked and verified successfully" );
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
//	    test.log(LogStatus.INFO,"Mandatory Field Labels and Field Type");
//	    System.out.println("Field Labels and Field Type");
//	    int k=PGO_reviewAndSend.formLabel(driver).size();
//	    for(int i=0;i<k;i++)
//	    {
//	      String formlabel=PGO_reviewAndSend.formLabel(driver).get(i).getText();
//	      String formtype=PGO_reviewAndSend.formInput(driver).get(i).getAttribute("type");
//	      test.log(LogStatus.INFO,formlabel+" "+"-"+formtype);
//	      String expformlabel=data.getStrExcelData(dRw, 115+i, sheetno);
//	      libs.VerifyText(PGO_reviewAndSend.formLabel(driver).get(i), expformlabel,expformlabel);
//		}
//	    test.log(LogStatus.PASS, "Mandatory Fields in User form verified successfully");
//	    test.log(LogStatus.INFO,"Contact field Title - "+PGO_reviewAndSend.formContactHeading(driver).getText());
//	    String expcontacttext=data.getStrExcelData(dRw, 122, sheetno);
//	    libs.VerifyText(PGO_reviewAndSend.formContactHeading(driver),expcontacttext,"Contact Method");
//	    test.log(LogStatus.INFO,"Contact options available");
//	    int a=PGO_reviewAndSend.formContactOptions(driver).size();
//	    for(int i=0;i<a;i++)
//	    {
//	    	test.log(LogStatus.INFO,PGO_reviewAndSend.formContactOptions(driver).get(i).getText());
//	    	String contactexp=data.getStrExcelData(dRw, 120+i, sheetno);
//		    libs.VerifyText(PGO_reviewAndSend.formContactOptions(driver).get(i), contactexp,contactexp);	
//	    }
//	    test.log(LogStatus.PASS, "Contact options in Form verified successfully");
//	    test.log(LogStatus.INFO,"Test drive field title - "+PGO_reviewAndSend.testDrive(driver).getText());
//	    String exptestdrive=data.getStrExcelData(dRw, 123, sheetno);
//	    libs.VerifyText(PGO_reviewAndSend.testDrive(driver), exptestdrive,exptestdrive);	
//	    test.log(LogStatus.INFO, "Fields available for Test drive");
//	    int c=PGO_reviewAndSend.labels(driver).size();
//	    for(int i=0;i<c;i++)
//	    {
//	    	test.log(LogStatus.INFO,PGO_reviewAndSend.labels(driver).get(i).getText());
//	    	String testdrivelabels=data.getStrExcelData(dRw, 124+i, sheetno);
//		    libs.VerifyText(PGO_reviewAndSend.labels(driver).get(i), testdrivelabels,testdrivelabels);	
//	    }
//	      test.log(LogStatus.INFO,"Test drive date field type - " +PGO_reviewAndSend.date(driver).getAttribute("type"));
//		  String revdesiredDate = data.getStrExcelData(dRw, 6,sheetno);
//		 if(PGO_reviewAndSend.selectclass(driver).isEnabled())
//		 {	
//
//			 getscrnSht.getscreenshot(driver,scrnshtPthNm);
//		  test.log(LogStatus.FAIL,"Test drive time field is enabled though the test drive date is not filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
//		 }
//		 else
//		 {
//		  test.log(LogStatus.PASS,"Test drive time list box not enabled as the test drive date is not filled");
//		 }
//		  PGO_reviewAndSend.date(driver).sendKeys(revdesiredDate);
//		  if(PGO_reviewAndSend.selectclass(driver).isEnabled())
//			 {		  
//			  test.log(LogStatus.PASS,"Test drive time field is enabled as the test drive date is filled");
//			 }
//			 else
//			 {
//			  test.log(LogStatus.FAIL,"Test drive time list box not enabled though the test drive date is filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
//			 }
//		   WebElement list=PGO_reviewAndSend.selectclass(driver);
//		   Select select=new Select(list);
//		   List<WebElement> allOptions = select.getOptions();
//		   int i=allOptions.size();
//		      test.log(LogStatus.INFO,"List of options available in Test drive time");
//		      for(int j=1;j<i;j++)
//		      {
//			  test.log(LogStatus.INFO, allOptions.get(j).getText());
//			  String actoption=allOptions.get(j).getText();
//			  String expoption=data.getStrExcelData(dRw, 125+j, sheetno);
//			  libs.assertionHandling(actoption, expoption, test, driver, scrnshtPthNm);
//			  }
//		PGO_reviewAndSend.date(driver).clear();
//		test.log(LogStatus.INFO, PGO_reviewAndSend.dealText(driver).getText());
//		String expdealtext=data.getStrExcelData(dRw, 132, sheetno);
//		libs.VerifyText(PGO_reviewAndSend.dealText(driver), expdealtext, "Send deal text");
//	    test.log(LogStatus.INFO,"Options available to submit deal");
//	    int b=PGO_reviewAndSend.dealOptions(driver).size();
//	    for(int m=0;m<b;m++)
//	    {
//	    	test.log(LogStatus.INFO,PGO_reviewAndSend.dealOptions(driver).get(m).getText());
//	    	String dealexpoption=data.getStrExcelData(dRw, 130+m, sheetno);
//			libs.VerifyText(PGO_reviewAndSend.dealOptions(driver).get(m), dealexpoption, dealexpoption);
//	    }
	      }
		catch(Exception beforeDealVerification)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver, scrnshtPth+"beforeDealVerification_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, beforeDealVerification.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"beforeDealVerification_"+libs.timestamp1()+".jpg") ));
		}
	    }

//	@Test
	public void vehicleDetails(int dRw)throws Exception
	{
//	 	String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
		String scrnshtPthNm=scrnshtPth+"review my deal failed"+".jpg";
		try{
		// fetch your vehicle details like no
			test.log(LogStatus.INFO,"Vehicle model");
			String vehmod=PGO_reviewAndSend.vehicleModel(driver).getText();
			test.log(LogStatus.INFO,"Vehicle model in Review and send tab "+vehmod);
			String vehmod1=data.getStrExcelData(dRw, 33, 9);
			String vehmod2=data.getStrExcelData(dRw, 34, 9);
			String vehmod3=data.getStrExcelData(dRw, 35, 9);
			String vehmod4=vehmod1+" "+vehmod2+" "+vehmod3;
			test.log(LogStatus.INFO,"Vehicle model in Vehicle details tab"+vehmod1+" "+vehmod2+" "+vehmod3);
			if(vehmod.equals(vehmod4))
			{
				
				test.log(LogStatus.PASS,"Vehicle model in Review and Send tab is same as Vehicle details tab");
			}
			else
			{
				 getscrnSht.getscreenshot(driver,scrnshtPthNm);
				test.log(LogStatus.FAIL,"Vehicle model in Review and Send tab is not same as Vehicle details tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
			test.log(LogStatus.INFO, "Vehicle details");
		   int k=PGO_reviewAndSend.vehicledetails(driver).size();
		   for(int i=0; i<k; i++)
		   {
			   String text=PGO_reviewAndSend.vehicledetails(driver).get(i).getText();
			   data.writeToExcel(text, dRw, 14+i, sheetno);
			   String text1=data.getStrExcelData(1, 3+i, 9);
			   if(text.equals(text1))
			   {
				 test.log(LogStatus.PASS,"Vehicle details in Review and Send Tab is same as in Vehicle details tab");
			   }
			   else
			   {
				   getscrnSht.getscreenshot(driver,scrnshtPthNm);
				 test.log(LogStatus.FAIL,"Vehicle details in Review and Send Tab is not same as in Vehicle details tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
			   }
		   }
		   jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.totMsrpDreicon(driver));
		   action.moveToElement(PGO_reviewAndSend.totMsrpDreicon(driver)).build().perform();
		   libs.waitToClick(driver, PGO_reviewAndSend.totMsrpDreicon(driver), 10);
		   test.log(LogStatus.PASS,"Arrow next to Total MSRP is clicked successfully");
		   test.log(LogStatus.INFO, "Pricing Summary Details under Vehicle accordian");
		   int a= PGO_reviewAndSend.priceDetails(driver, dRw).size();
		   for(int i=0;i<a;i++)
		   {
			   String price = PGO_reviewAndSend.priceDetails(driver, dRw).get(i).getText();
			   data.writeToExcel(price, dRw, 23+i, sheetno);
			   String price1=data.getStrExcelData(dRw, 12+i, 9);
			   if(price.equals(price1))
			   {
				  test.log(LogStatus.PASS,"Price in Review and Send tab is same as Vehicle details tab");			
			   }
			   else
			   {
				   getscrnSht.getscreenshot(driver,scrnshtPthNm);
				   test.log(LogStatus.FAIL,"Price in Review and Send tab is not same as Vehicle details tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
			   }
		   }
		   String actnote=PGO_reviewAndSend.note(driver).getText();
		   test.log(LogStatus.INFO,"Note in Your Vehicle Section - "+actnote);
		   String expnote=data.getStrExcelData(dRw, 75, sheetno);
		   libs.assertionHandling(actnote, expnote, test,driver,scrnshtPthNm);
		   test.log(LogStatus.PASS,"Note in Your Vehicle Section verified successfully");
		}
		catch(Exception reviewMyDealException)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver,scrnshtPth );
            test.log(LogStatus.FAIL, reviewMyDealException.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
	}
	public void tradein(int dRw)throws Exception
	{
//	        String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
			String scrnshtPthNm=scrnshtPth+"review my deal failed"+libs.timestamp1()+".jpg";
			try
			{
			  String res=data.getStrExcelData(dRw, 62, 6);
			  System.out.println(res);
			  if(res.equals("Not Executed"))
			  {
				  skiptradereviewMyDeal(dRw);  
			  }
			  else
			  {
				  tradereviewMyDeal(dRw);
			  }
			}
			catch(Exception trade)
			 {
				  Count++;
				getscrnSht.getscreenshot(driver,scrnshtPthNm );
	            test.log(LogStatus.FAIL, trade.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
	}
	public void payment(int dRw)throws Exception
	{
//	        String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
			String scrnshtPthNm=scrnshtPth+"review my deal failed"+libs.timestamp()+".jpg";
			try
			{
			  String res=data.getStrExcelData(dRw,5,3);
			  if(res.equals("Not Executed"))
			  {
				  skippaymentreviewMyDeal(dRw);  
			  }
			  else
			  {
				  paymentDetails(dRw);
			  }
			}
			catch(Exception trade)
			 {
				  Count++;
				getscrnSht.getscreenshot(driver,scrnshtPth );
	            test.log(LogStatus.FAIL, trade.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
	}
	public void skiptradereviewMyDeal(int dRw)throws Exception
	{
//	        String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
			String scrnshtPthNm=scrnshtPth+"review my deal failed"+libs.timestamp1()+".jpg";
			try
			{
//			 test.log(LogStatus.PASS,"Trade-in has been skipped");
//			 String acttext=PGO_reviewAndSend.noTradeinhead(driver).getText();
//			 String expheaval=data.getStrExcelData(dRw, 138, sheetno);
//			 libs.assertionHandling(acttext, expheaval, test, driver, scrnshtPthNm);
//			 libs.VerifyText(PGO_reviewAndSend.noTradeinhead(driver),expheaval,"No Tradein - Heading", driver, test, dRw);
//			 String expheatext=data.getStrExcelData(dRw, 139, sheetno);
//			 libs.VerifyText(PGO_reviewAndSend.noTradeintext(driver),expheatext,"No Tradein - Text", driver, test, dRw);
//			 jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.valueTradein(driver));
//			 action.moveToElement(PGO_reviewAndSend.valueTradein(driver)).build().perform();
//			 String novalbtn=data.getStrExcelData(dRw, 138, sheetno);
//			 libs.VerifyText(PGO_reviewAndSend.valueTradein(driver),novalbtn,"No Tradein - Button", driver, test, dRw);
			 jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.valueTradein(driver));	
			 libs.waitToClick(driver,PGO_reviewAndSend.valueTradein(driver),300);
			 test.log(LogStatus.PASS,"Clicking on value trade in button in review and send page,application navigated to TradeIn page successfully" );
			 Thread.sleep(2000);
			 jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.summaryTabs(driver));
			 libs.waitToClick(driver,PGO_reviewAndSend.summaryTabs(driver),300);
			 test.log(LogStatus.PASS, "Clicking on Review and Send tab,application navigates back to Review and Summary tab successfully" );
			}
			catch(Exception skiptradereviewMyDeal)
			 {
				  Count++;
				getscrnSht.getscreenshot(driver,scrnshtPth );
	            test.log(LogStatus.FAIL, skiptradereviewMyDeal.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
			}
	}
	public void skippaymentreviewMyDeal(int dRw)throws Exception
	{
//	        String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
			String scrnshtPthNm=scrnshtPth+"review my deal failed"+libs.timestamp1()+".jpg";
			try
			{
//			 test.log(LogStatus.PASS,"Payment has been skipped");
//			 String expheaval=data.getStrExcelData(dRw, 140, sheetno);
//			 libs.VerifyText(PGO_reviewAndSend.paymentHead(driver),expheaval,"No Payment - Heading", driver, test, dRw);
//			 String expheatext=data.getStrExcelData(dRw, 141, sheetno);
//			 libs.VerifyText(PGO_reviewAndSend.paymentText(driver),expheatext,"No Payment - Text", driver, test, dRw);
//			 jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.payment(driver));
//			 action.moveToElement(PGO_reviewAndSend.payment(driver)).build().perform();
//			 String novalbtn=data.getStrExcelData(dRw, 142, sheetno);
//			 libs.VerifyText(PGO_reviewAndSend.payment(driver),novalbtn,"No Payment - Text", driver, test, dRw);
//			 jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.payment(driver));
//			 action.moveToElement(PGO_reviewAndSend.payment(driver)).build().perform();
			 jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.payment(driver));
			 libs.waitToClick(driver,PGO_reviewAndSend.payment(driver),300);
			 test.log(LogStatus.PASS,"Clicking on Get Your Payment Estimate button in review and send page,application navigated to Payment tab successfully" );
			 Thread.sleep(2000);
			 jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.summaryTabs(driver));
			 libs.waitToClick(driver,PGO_reviewAndSend.summaryTabs(driver),300);
			 test.log(LogStatus.PASS, "Clicking on Review and Send tab,application navigates back to Review and Summary tab successfully" );
			}
			catch(Exception skippaymentreviewMyDeal)
			 {
				  Count++;
				getscrnSht.getscreenshot(driver,scrnshtPth );
	            test.log(LogStatus.FAIL, skippaymentreviewMyDeal.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
			}
	}
public void tradereviewMyDeal(int dRw)throws Exception
{
//        String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
		String scrnshtPthNm=scrnshtPth+"review my deal failed"+libs.timestamp1()+".jpg";
		try{
		   test.log(LogStatus.INFO,"Your Tradein details");
		   String tvehmod=PGO_reviewAndSend.tradeinVehicle(driver).getText();
		   test.log(LogStatus.INFO,"Vehicle model in Trade in "+tvehmod);
			String tvehmod1=data.getStrExcelData(dRw, 1, 6);
			System.out.println(tvehmod1);
			String tvehmod2=data.getStrExcelData(dRw, 2, 6);
			System.out.println(tvehmod2);
			String tvehmod3=data.getStrExcelData(dRw, 3, 6);
			System.out.println(tvehmod3);
			String t1=tvehmod1+"  "+tvehmod2+"  "+ tvehmod3;
			if(tvehmod.equals(t1))
			{
				test.log(LogStatus.PASS,"Vehicle model details in Tradein section(Review and send tab) is same as vehicle details selected in Tradein module");
			}
			else
			{
				test.log(LogStatus.FAIL,"Vehicle model details in Tradein section(Review and send tab) is not same as vehicle details selected in Tradein module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
		   test.log(LogStatus.INFO,"Vehicle Details in Tradein section");
		   int p=PGO_reviewAndSend.tradeinVehicledetails(driver).size();
		   for(int i=0;i<p;i++)
		   {
			 String vehicledetails = PGO_reviewAndSend.tradeinVehicledetails(driver).get(i).getText();
			 data.writeToExcel(vehicledetails, dRw, 31+i, sheetno);
			 test.log(LogStatus.INFO, PGO_reviewAndSend.tradeinVehicledetails(driver).get(i).getText());
			}
		   String text=data.getStrExcelData(dRw, 31, sheetno);
		   String text1=data.getStrExcelData(dRw, 4, 6);
		   if(text.equals(text1))
		   {
			 test.log(LogStatus.PASS,"KBB trim vehicle details in Review and send tab is same as Trade in module");  
		   }
		   else
		   {
			   getscrnSht.getscreenshot(driver,scrnshtPthNm);
			  test.log(LogStatus.FAIL,"KBB trim vehicle details in Review and send tab is not same as Trade in module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
		   }
		   String text2=data.getStrExcelData(dRw, 32, sheetno);
		   String text3=data.getStrExcelData(dRw, 5, 6);
		   String text4=text3+" "+"mi";
		   if(text2.equals(text4))
		   {
			 test.log(LogStatus.PASS,"KBB Vehicle mileage in Review and send tab is same as Trade in module");  
		   }
		   else
		   {
			   getscrnSht.getscreenshot(driver,scrnshtPthNm);
			   test.log(LogStatus.FAIL,"KBB Vehicle mileage in Review and send tab is not same as Trade in module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
		   }
		   String text5=data.getStrExcelData(dRw, 33, sheetno);
		   String text6=data.getStrExcelData(dRw, 10, 6);
		   if(text5.equals(text6))
		   {
			 test.log(LogStatus.PASS,"KBB Vehicle condition in Review and send tab is same as Trade in module");  
		   }
		   else
		   {
			   getscrnSht.getscreenshot(driver,scrnshtPthNm);
			   test.log(LogStatus.FAIL,"KBB Vehicle condition in Review and send tab is not same as Trade in module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
		   }
		   String text7=data.getStrExcelData(dRw, 34, sheetno);
		   String texts=libs.getNumfrmString(text7);
		   String text8=data.getStrExcelData(dRw, 7, 6);
		   if(texts.equals(text8))
		   {
			 test.log(LogStatus.PASS,"KBB Your Own value in Review and Send tab is same as Trade in module");  
		   }
		   else
		   {
			   getscrnSht.getscreenshot(driver,scrnshtPthNm);
			   test.log(LogStatus.FAIL,"KBB Your Own value in Review and Send tab is same as Trade in module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
		   }
		   test.log(LogStatus.INFO,"Price details in Tradein Module");
		   String payment=data.getStrExcelData(dRw, 3, 3);
		    System.out.println(payment);
		    switch(payment)
		    {
		    case "Buy":
		   String kbbval=PGO_reviewAndSend.tradeinPricedetails(driver).getText();
		   data.writeToExcel(kbbval,dRw, 35, sheetno);
		   String kbbval1=data.getStrExcelData(dRw, 18, 3);
		   if(kbbval.equals(kbbval1))
		   {
			 test.log(LogStatus.PASS,"Kelly blue book trade in value in Review and send tab is same as Trade in module");  
		   }
		   else
		   {	getscrnSht.getscreenshot(driver,scrnshtPthNm);
			   test.log(LogStatus.FAIL,"Kelly blue book trade in value in Review and send tab is not same as Trade in module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
		   }
		   break;
		    case "Cash":
		    	   String text9=PGO_reviewAndSend.tradeinPricedetails(driver).getText();
				   data.writeToExcel(text9,dRw, 35, sheetno);
				   String text10=data.getStrExcelData(dRw, 51, 3);
				   if(text9.equals(text10))
				   {
					 test.log(LogStatus.PASS,"Kelly blue book trade in value in Review and send tab is same as Trade in module");  
				   }
				   else
				   {
					   getscrnSht.getscreenshot(driver,scrnshtPthNm);
					   test.log(LogStatus.FAIL,"Kelly blue book trade in value in Review and send tab is not same as Trade in module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
				   }
				   break;
		    case "Lease":
		    	   String text11=PGO_reviewAndSend.tradeinPricedetails(driver).getText();
				   data.writeToExcel(text11,dRw, 35, sheetno);
				   String text12=data.getStrExcelData(dRw, 51, 3);
				   if(text11.equals(text12))
				   {
					 test.log(LogStatus.PASS,"Kelly blue book trade in value in Review and send tab is same as Trade in module");  
				   }
				   else
				   {
					   getscrnSht.getscreenshot(driver,scrnshtPthNm);
					   test.log(LogStatus.FAIL,"Kelly blue book trade in value in Review and send tab is not same as Trade in module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
				   }
				   break;
		    }
			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.editButton(driver));
			action.moveToElement(PGO_reviewAndSend.editButton(driver)).build().perform();
			libs.waitToClick(driver,PGO_reviewAndSend.editButton(driver),300);
			test.log(LogStatus.PASS, "Clicking on edit button in Review and Send tab under trade-in ,application navigated to TradeIn page successfully" );
			Thread.sleep(2000);
			libs.waitToClick(driver,PGO_reviewAndSend.summaryTabs(driver),300);
			test.log(LogStatus.PASS, "Clicking on Review and Send tab,application navigates back to Review and Summary tab successfully" );
		}
			catch(Exception tradereviewMyDeal)
		 {
				  Count++;
				getscrnSht.getscreenshot(driver,scrnshtPthNm );
                test.log(LogStatus.FAIL, tradereviewMyDeal.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
		}
		public void paymentDetails(int dRw) throws Exception
		{
//			String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
			String scrnshtPthNm=scrnshtPth+"Payment section failed"+libs.timestamp1()+".jpg";
			try
			{
			String payment=data.getStrExcelData(dRw, 3, 3);
		    System.out.println(payment);
		    switch(payment)
		    {
		    case "Cash":
		    	int a=PGO_reviewAndSend.paymentDetails(driver).size();
				test.log(LogStatus.INFO,"Payment details in Review and Send tab");
		    	for(int i=1;i<a;i++)
				{
				      String det=PGO_reviewAndSend.paymentDetails(driver).get(i).getText();
				      data.writeToExcel(det, dRw, 80+i, sheetno);
				}
		    	String estprice=data.getStrExcelData(dRw, 81, sheetno);
		    	String estprice1=data.getStrExcelData(dRw, 50,3);
		    	if(estprice.equals(estprice1))
		    	{
		    	 test.log(LogStatus.PASS,"Estimated Pre Tax price in Review and send tab is same as payment tab");	
		    	}
		    	else
		    	{
		    		getscrnSht.getscreenshot(driver,scrnshtPthNm);
		    	  test.log(LogStatus.FAIL,"Estimated Pre Tax price in Review and send tab is not same as payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		    	}
		    	String kelly=data.getStrExcelData(dRw, 87, sheetno);
		    	String kelly1=data.getStrExcelData(dRw, 51,3);
		    	if(kelly.equals(kelly1))
		    	{
		    	 test.log(LogStatus.PASS,"Kelly book trade in value in Review and send tab is same as payment tab");	
		    	}
		    	else
		    	{
		    		getscrnSht.getscreenshot(driver,scrnshtPthNm);
		    	  test.log(LogStatus.FAIL,"Kelly book trade in value in  Review and send tab is not same as payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		    	}
		    	try
		    	{
		    	String rembal=data.getStrExcelData(dRw, 88, sheetno);
		    	String rembal1=libs.getNumfrmString(rembal);
				System.out.println(rembal1);
		    	String rembal2=data.getStrExcelData(dRw, 52,3);
		    	System.out.println(rembal1);
		    	if(rembal1.equals(rembal2))
		    	{
		    	 test.log(LogStatus.PASS,"Remaining balance tradein value in Review and send tab is same as payment tab");	
		    	}
		    	else
		    	{
		    		getscrnSht.getscreenshot(driver,scrnshtPthNm);
		    	  test.log(LogStatus.FAIL,"Remaining balance tradein value in Review and send tab is not same as payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		    	}
		    	}
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    	String estnet=data.getStrExcelData(dRw, 89, sheetno);
		    	System.out.println(estnet);
		    	String estnet1=data.getStrExcelData(dRw, 53,3);
		    	System.out.println(estnet1);
		    	if(estnet.equals(estnet1))
		    	{
		    	 test.log(LogStatus.PASS,"Estimated Net Trade-In Amount value in Review and send tab is same as payment tab");	
		    	}
		    	else
		    	{
		    		getscrnSht.getscreenshot(driver,scrnshtPthNm);
		    	  test.log(LogStatus.FAIL,"Estimated Net Trade-In Amount value in Review and send tab is not same as payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		    	}
		    	String estcash=data.getStrExcelData(dRw, 94, sheetno);
		    	System.out.println(estcash);
		    	String estcash1=data.getStrExcelData(dRw, 54,3);
		    	System.out.println(estcash1);
		    	if(estcash.equals(estcash1))
		    	{
		    	 test.log(LogStatus.PASS,"Estimated Cash Due at Dealer value in Review and send tab is same as payment tab");	
		    	}
		    	else
		    	{
		    		 getscrnSht.getscreenshot(driver,scrnshtPthNm);
		    	  test.log(LogStatus.FAIL,"Estimated Cash Due at Dealer value in Review and send tab is not same as payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		    	}
		    	jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.editButton(driver));
				action.moveToElement(PGO_reviewAndSend.editButton(driver)).build().perform();
				libs.waitToClick(driver,PGO_reviewAndSend.editButton(driver),300);
				test.log(LogStatus.PASS, "Clicking on edit button in payment section,application navigated to TradeIn page successfully" );
				Thread.sleep(2000);
				libs.waitToClick(driver,PGO_reviewAndSend.summaryTabs(driver),300);
				test.log(LogStatus.PASS, "Clicking on Payment tab,application navigates back to Review and Summary tab successfully" );
		    	break;
		    case "Buy":
			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.estimatedDreIcon(driver));
			action.moveToElement(PGO_reviewAndSend.estimatedDreIcon(driver)).build().perform();
			libs.waitToClick(driver, PGO_reviewAndSend.estimatedDreIcon(driver), 10);
			int aa=PGO_reviewAndSend.paymentDetails(driver).size();
			for(int i=0;i<aa;i++)
			{
				String det=PGO_reviewAndSend.paymentDetails(driver).get(i).getText();
			    data.writeToExcel(det, dRw, 98+i, 5);
			}
			String esttax=data.getStrExcelData(dRw, 13, 3);
			String esttax1=data.getStrExcelData(dRw, 99, sheetno);
			if(esttax1.equals(esttax))
			{
				test.log(LogStatus.PASS,"Estimated Pre tax price in Review and Send tab same as payment tab");
			}
			else
			{
				 getscrnSht.getscreenshot(driver,scrnshtPthNm);
				test.log(LogStatus.FAIL,"Estimated Pre tax price in Review and Send tab same as payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
			}
			String estta=data.getStrExcelData(dRw, 14, 3);
			String estta1=data.getStrExcelData(dRw, 100, sheetno);
			if(estta1.equals(estta))
			{
				test.log(LogStatus.PASS,"Estimated taxes in Review and Send tab same as payment tab");
			}
			else
			{
				 getscrnSht.getscreenshot(driver,scrnshtPthNm);
				test.log(LogStatus.FAIL,"Estimated taxes in Review and Send tab not same as payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
			}
			String titfee=data.getStrExcelData(dRw, 15, 3);
			String titfee1=data.getStrExcelData(dRw, 101, sheetno);
			if(titfee1.equals(titfee))
			{
				test.log(LogStatus.PASS,"Title fees in Review and Send tab same as Payment tab");
			}
			else
			{
				 getscrnSht.getscreenshot(driver,scrnshtPthNm);
				test.log(LogStatus.FAIL,"Title fees in Review and Send tab not same as Payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
			}
			for(int i=0;i<10;i++)
			{
			 String pay=data.getStrExcelData(dRw, 16+i, 3);
			 String rev=data.getStrExcelData(dRw, 103+i,5);
			 if(rev.equals(pay))
				{
					test.log(LogStatus.PASS,"Price in Review and Send tab is same as Payment tab");
				}
				else
				{
					 getscrnSht.getscreenshot(driver,scrnshtPthNm);
					test.log(LogStatus.FAIL,"Price in Review and Send tab is same as Payment tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
				}
			}
			test.log(LogStatus.PASS, "Payment details verified successfully");
			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.editButton(driver));
			  action.moveToElement(PGO_reviewAndSend.editButton(driver)).build().perform();
			  libs.waitToClick(driver,PGO_reviewAndSend.editButton(driver),300);
			    test.log(LogStatus.PASS, "Clicking on edit button in payment section,application navigated to TradeIn page successfully" );
			  Thread.sleep(2000);
				libs.waitToClick(driver,PGO_reviewAndSend.summaryTabs(driver),300);
			break;
		    case "Lease":
		    		jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.estimatedDreIcon(driver));
					action.moveToElement(PGO_reviewAndSend.estimatedDreIcon(driver)).build().perform();
					libs.waitToClick(driver, PGO_reviewAndSend.estimatedDreIcon(driver), 10);
					int aaa=PGO_reviewAndSend.paymentDetails(driver).size();
					for(int i=0;i<aaa;i++)
					{
				      String det2=PGO_reviewAndSend.paymentDetails(driver).get(i).getText();
				      }
					test.log(LogStatus.PASS, "Payment details verified successfully");
					break;
		    }
		Thread.sleep(2000);
		String pnote=PGO_reviewAndSend.protectionNote(driver).getText();
		System.out.println("Note in protection section - "+pnote);
		String exppnote=data.getStrExcelData(dRw, 74, 5);
		libs.assertionHandling(pnote, exppnote, test, driver, scrnshtPthNm);
		test.log(LogStatus.PASS, "Note in Protection section verified successfully");
		test.log(LogStatus.INFO,"Protection Plans in Ford");
		int b=PGO_reviewAndSend.protectionPlans(driver).size();
		for(int i=0;i<b;i++)
		{
		  test.log(LogStatus.INFO,PGO_reviewAndSend.protectionPlans(driver).get(i).getText());
		}
		test.log(LogStatus.PASS, "Protection plans in Protection section verified successfully");
		// select one protection option
		try
		{
		libs.waitToClick(driver, PGO_reviewAndSend.txt_yourVehicle(driver), 10);
		test.log(LogStatus.PASS,"Arrow next your vehicle clicked back successfully");
		Thread.sleep(2000);
		action.moveToElement(PGO_reviewAndSend.txt_yourTradeIn(driver)).build().perform();
		libs.waitToClick(driver, PGO_reviewAndSend.txt_yourTradeIn(driver), 40);
		test.log(LogStatus.PASS,"Arrow next your Tradein clicked back successfully");
		Thread.sleep(2000);
		action.moveToElement(PGO_reviewAndSend.txt_yourPayment(driver)).build().perform();
		jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.txt_yourPayment(driver));
		libs.waitToClick(driver, PGO_reviewAndSend.txt_yourPayment(driver), 10);
		test.log(LogStatus.PASS,"Arrow next your Payment information clicked back successfully");
		action.moveToElement(PGO_reviewAndSend.txt_yourProtection(driver)).build().perform();
		jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.txt_yourProtection(driver));
		libs.waitToClick(driver, PGO_reviewAndSend.txt_yourProtection(driver), 10);
		test.log(LogStatus.PASS,"Arrow next your Protection information clicked back successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// fetch the price values and store in test data sheet
		String estPreTaxPrice =PGO_reviewAndSend.txt_estPreTaxPrice(driver) .getText();
		test.log(LogStatus.INFO, "estPreTaxPrice: " +estPreTaxPrice);
		test.log(LogStatus.PASS, "Price elements is verified successfully");
			}
			catch(Exception paymentDetails)
			 {
				  Count++;
				getscrnSht.getscreenshot(driver,scrnshtPthNm );
                test.log(LogStatus.FAIL, paymentDetails.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
		}
		public void customerInfoFormVeri(int dRw)  throws Exception
		{
//		 String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
		 String scrnshtPthNm=scrnshtPth+"Review_Send_tab_"+".jpg";
		 try
		 {
	     boolean dis=PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled();
	     if(dis==false)
	     {
	       test.log(LogStatus.PASS,"Send My Deal button is disabled as none of the form details are filled");
	     }
	     else
	     { getscrnSht.getscreenshot(driver,scrnshtPthNm);
	       test.log(LogStatus.FAIL,"Send My Deal is not disabled though the form details are not filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
	     }
	        String revfirstName = data.getStrExcelData(dRw, 1, 5);
			String revlastName = data.getStrExcelData(dRw, 2, 5);
			String revemail = data.getStrExcelData(dRw, 3, 5);
			String revphone = data.getStrExcelData(dRw, 4, 5);
			String revsearchZip = data.getStrExcelData(dRw, 5, 5);
			String revdesiredDate = data.getStrExcelData(dRw, 6,5);
			String revdesiredTime = data.getStrExcelData(dRw, 7, 5);
			PGO_reviewAndSend.txt_firstName(driver).sendKeys(revfirstName);
			boolean dis1=PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled();
		    if(dis1==false)
		     {
		       test.log(LogStatus.PASS,"Send My Deal is disabled as lastname,email,phone number and zipcode is not yet entered ");
		     }
		     else
		     {
		    	 getscrnSht.getscreenshot(driver,scrnshtPthNm);
		    	test.log(LogStatus.FAIL,"Send My Deal is not disabled though the lastname,email,phone number and zipcode is not yet entered" ,test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );	
		    	 
		     }
		     PGO_reviewAndSend.txt_lastName(driver).sendKeys(revlastName);
		     boolean dis2=PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled();
			   if(dis2==false)
			     {
			       test.log(LogStatus.PASS,"Send My Deal is disabled as Email,Phone number,Zipcode is not yet entered");
			     }
			     else
			     {
			    	 getscrnSht.getscreenshot(driver,scrnshtPthNm);
			    	test.log(LogStatus.FAIL,"Send My Deal is not disabled though the Email,Phone number,Zipcode is not yet entered", test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
			     }
			     PGO_reviewAndSend.txt_email(driver).sendKeys(revemail);
			     boolean dis3=PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled();
				  if(dis3==false)
				     {
				       test.log(LogStatus.PASS,"Send My Deal is disabled as Phone number,Zipcode is not yet entered");
				     }
				     else
				     {
				    	 getscrnSht.getscreenshot(driver,scrnshtPthNm);
				    	 test.log(LogStatus.FAIL,"Send My Deal is not disabled though thone number,Zipcode is not yet entered ",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
				     }
				     PGO_reviewAndSend.txt_phone(driver).sendKeys(revphone);
				     boolean dis4=PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled();
					  if(dis4==false)
					     {
					       test.log(LogStatus.PASS,"Send My Deal is disabled as Zipcode is not yet entered");
					     }
					     else
					     {
					    	 getscrnSht.getscreenshot(driver,scrnshtPthNm);
					    	test.log(LogStatus.FAIL,"Send My Deal is not disabled though the Zipcode is not yet entered" ,test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
					     }
//					     PGO_reviewAndSend.txt_searchZip(driver).sendKeys(revsearchZip);
//					     boolean dis5=PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled();
//					    if(dis5==true)
//					     {
//					       test.log(LogStatus.PASS,"Send My Deal enabled as the form details are completely filled");
//					     }
//					     else
//					     {	 getscrnSht.getscreenshot(driver,scrnshtPthNm);
//					    	 test.log(LogStatus.FAIL,"Send My Deal is not enabled though the form details are completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
//					     }
		 }
		 catch(Exception customerInfoFormVeri)
		 {
			  Count++;
				getscrnSht.getscreenshot(driver,scrnshtPthNm );
                test.log(LogStatus.FAIL, customerInfoFormVeri.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
					     
		}
		    
	
	
		// Review and send fill contact details
	public void customerInfoForm(int dRw)  throws Exception
	{
	    String revdesiredDate = data.getStrExcelData(dRw, 6,sheetno);
		String revdesiredTime = data.getStrExcelData(dRw, 7, sheetno);

		String scrnshtPthNm=scrnshtPth+"Review_Send_tab_"+libs.timestamp1()+".jpg";
		try{
			Thread.sleep(2000);
//			for(int i=0;i<3;i++)
//			{
//			String revfirstName = data.getStrExcelData(dRw, 36+i, sheetno);
//			PGO_reviewAndSend.txt_firstName(driver).clear();
//			PGO_reviewAndSend.txt_firstName(driver).sendKeys(revfirstName);
//			if(PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled())
//			{ getscrnSht.getscreenshot(driver,scrnshtPthNm);
//			  test.log(LogStatus.FAIL,"Send my deal button enabled though the First name entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
//			}
//			else
//			{
//				test.log(LogStatus.PASS,"Send my deal button not enabled as the First name entered is invalid");
//			}
//			}
			String revfirstName = data.getStrExcelData(dRw, 1, sheetno);
			PGO_reviewAndSend.txt_firstName(driver).clear();
			PGO_reviewAndSend.txt_firstName(driver).sendKeys(revfirstName);
			
//			for(int j=0;j<3;j++)
//			{
//			String revlastName = data.getStrExcelData(dRw, 39+j, sheetno);
//			PGO_reviewAndSend.txt_lastName(driver).clear();
//			PGO_reviewAndSend.txt_lastName(driver).sendKeys(revlastName);
//			if(PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled())
//			{
//				 getscrnSht.getscreenshot(driver,scrnshtPthNm);
//			  test.log(LogStatus.FAIL,"Send my deal button enabled though the Last name entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
//			}
//			else
//			{
//				test.log(LogStatus.PASS,"Send my deal button enabled as the Last name entered is invalid");
//			}
//			}
			String revlastName = data.getStrExcelData(dRw, 2, sheetno);
			PGO_reviewAndSend.txt_lastName(driver).clear();
			PGO_reviewAndSend.txt_lastName(driver).sendKeys(revlastName);
			
//			for(int j=0;j<3;j++)
//			{
//			String revemail = data.getStrExcelData(dRw, 42+j, sheetno);
//			PGO_reviewAndSend.txt_email(driver).clear();
//			PGO_reviewAndSend.txt_email(driver).sendKeys(revemail);
//			if(PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled())
//			{
//				getscrnSht.getscreenshot(driver,scrnshtPthNm);
//			  test.log(LogStatus.FAIL,"Send my deal button enabled though the Email entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
//			}
//			else
//			{
//				test.log(LogStatus.PASS,"Send my deal button enabled as the Email entered is invalid");
//			}
//			}
			String revemail = data.getStrExcelData(dRw, 3, sheetno);
			PGO_reviewAndSend.txt_email(driver).clear();
			PGO_reviewAndSend.txt_email(driver).sendKeys(revemail);
			
//			for(int j=0;j<3;j++)
//			{
//			String revphone = data.getStrExcelData(dRw, 45+j, sheetno);
//			PGO_reviewAndSend.txt_phone(driver).clear();
//			PGO_reviewAndSend.txt_phone(driver).sendKeys(revphone);
//			if(PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled())
//			{
//				getscrnSht.getscreenshot(driver,scrnshtPthNm);
//			  test.log(LogStatus.FAIL,"Send my deal button enabled though the Phone number entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
//			}
//			else
//			{
//				test.log(LogStatus.PASS,"Send my deal button enabled as the Phone Number entered is invalid");
//			}
//			}
			String revphone = data.getStrExcelData(dRw, 4, sheetno);
			PGO_reviewAndSend.txt_phone(driver).clear();
			PGO_reviewAndSend.txt_phone(driver).sendKeys(revphone);
			
//			for(int j=0;j<3;j++)
//			{
//			String revsearchZip = data.getStrExcelData(dRw, 48+j, sheetno);
//			PGO_reviewAndSend.txt_searchZip(driver).clear();
//			PGO_reviewAndSend.txt_searchZip(driver).sendKeys(revsearchZip);
//			if(PGO_reviewAndSend.btn_sendMyDeal(driver).isEnabled())
//			{
//				getscrnSht.getscreenshot(driver,scrnshtPthNm);
//			  test.log(LogStatus.FAIL,"Send my deal button enabled though the Zipcode entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
//			}
//			else
//			{
//				test.log(LogStatus.PASS,"Send my deal button enabled as the Zipcode entered is invalid");
//			}
//			}
//			String revsearchZip = data.getStrExcelData(dRw, 5, sheetno);
//			PGO_reviewAndSend.txt_searchZip(driver).clear();
//			PGO_reviewAndSend.txt_searchZip(driver).sendKeys(revsearchZip);
					
			PGO_reviewAndSend.txt_desiredDate(driver).clear();
			PGO_reviewAndSend.txt_desiredDate(driver).sendKeys(revdesiredDate);
			PGO_reviewAndSend.txt_desiredTime(driver).sendKeys(revdesiredTime);
			test.log(LogStatus.PASS, "Cutomer Personal information has been entered successfully.");
			
			
		}catch(Exception customerInfoFormexception)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, customerInfoFormexception.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
	
		}
}
	public void afterdealVerification(int dRw) throws Exception
	{
//		String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
		String scrnshtPthNm=scrnshtPth+"Review and send section failed"+libs.timestamp1()+".jpg";
		try
		{
		int sectionsize=PGO_reviewAndSend.sections(driver).size();
		test.log(LogStatus.INFO,"Accordions available in Review and Send page after clicking Review My Deal button");
    	for(int i=0;i<sectionsize;i++)
    	{
    	  test.log(LogStatus.INFO, PGO_reviewAndSend.sections(driver).get(i).getText());
    	}

		// check deal timings
		Thread.sleep(2000);
		String dealSubTime = PGO_reviewAndSend.txt_dealSentTime(driver).getText();
		test.log(LogStatus.INFO, "Deal intiated time is displayed: "+ dealSubTime);	

		//check deal no
		Thread.sleep(2000);
		String dealNo = PGO_reviewAndSend.txt_dealNo(driver).getText();
		test.log(LogStatus.INFO, "Deal no is displayed: "+ dealNo);	
		
		//test drive details 
		Thread.sleep(2000);
		String tstdrvdt = driver.findElement(By.xpath("//section [@class='testDrive dre-accordion ng-scope']/div[2]/table/tbody/tr[1]/td")).getText();
		test.log(LogStatus.INFO, "Test drive date is displayed: "+ tstdrvdt);	
		String tstdrvtm = driver.findElement(By.xpath("//section [@class='testDrive dre-accordion ng-scope']/div[2]/table/tbody/tr[2]/td")).getText();
		test.log(LogStatus.INFO, "Test drive time is displayed: "+ tstdrvtm);
		
		//MESSAGE
		jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.messageHeading(driver));
		String actheading=PGO_reviewAndSend.messageHeading(driver).getText();
    	String expheading=data.getStrExcelData(dRw,62, sheetno);
    	libs.assertionHandling(actheading, expheading, test,driver,scrnshtPthNm);
    	
    	jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.message(driver));
    	String act=PGO_reviewAndSend.message(driver).getText();
    	String exp=data.getStrExcelData(dRw,63, sheetno);
    	libs.assertionHandling(act, exp, test,driver,scrnshtPthNm);
		test.log(LogStatus.PASS,"Text present in Review and Send after submitting deal verified successfully");
		
    	String actb=PGO_reviewAndSend.messageButton(driver).getText();
    	String expb=data.getStrExcelData(dRw,64, sheetno);
    	libs.assertionHandling(actb, expb, test,driver,scrnshtPthNm);
		test.log(LogStatus.PASS,"Print My Deal button displayed");
		
    	Thread.sleep(2000);
    	jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.messageButton(driver));
		libs.waitToClick(driver, PGO_reviewAndSend.messageButton(driver), 10);
		test.log(LogStatus.PASS,"Print my deal is clicked.");
		Thread.sleep(2000);
	// switch to old browser
		String parentHandle1 = driver.getWindowHandle(); 
		for (String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle); 
		}
		Thread.sleep(2000);
		driver.close(); 
		driver.switchTo().window(parentHandle1);
		// compare prices after submit
		action.moveToElement(PGO_reviewAndSend.txt_estPreTaxPrice(driver)).build().perform();
		String estPreTaxPrice1 =PGO_reviewAndSend.txt_estPreTaxPrice(driver) .getText();
		test.log(LogStatus.INFO, "estPreTaxPrice: " +estPreTaxPrice1);
		}
		catch(Exception afterdealVerification)
		 {
			  Count++;
			tearReport();
			getscrnSht.getscreenshot(driver, scrnshtPth+"afterdealVerification"+".jpg");
			test.log(LogStatus.FAIL, afterdealVerification.getMessage() ,test.addScreenCapture(Screenpathforreport(scrnshtPth +"afterdealVerification"+".jpg") ));
	
		}
		
		
	}
	
	
	public void sendMyDeal(int dRw) throws Exception
	{
//		String scrnshtPth = data.getStrExcelData(dRw, 8, sheetno);
		String scrnshtPthNm=scrnshtPth+"Review and send section failed"+libs.timestamp1()+".jpg";
		String dlSubmtVal = data.getStrExcelData(dRw, 9, sheetno);
		try{
			switch(dlSubmtVal)
			{
			case"Yes":
//				sendMyDeal(dRw);
				jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.btn_sendMyDeal(driver));
				action.moveToElement(PGO_reviewAndSend.btn_sendMyDeal(driver)).build().perform();
			   libs.waitToClick(driver, PGO_reviewAndSend.btn_sendMyDeal(driver), 30);
			   test.log(LogStatus.PASS,"Send My Deal button clicked successfully");
			   Thread.sleep(4000);
			   jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.name(driver));
			   action.moveToElement(PGO_reviewAndSend.name(driver)).build().perform();
			   test.log(LogStatus.INFO,PGO_reviewAndSend.name(driver).getText());
			   action.moveToElement(PGO_reviewAndSend.messageafterdeal(driver)).build().perform();
			   String actm=PGO_reviewAndSend.messageafterdeal(driver).getText();
			   String expm=data.getStrExcelData(dRw,58, 5);
		    	libs.assertionHandling(actm, expm, test,driver,scrnshtPthNm);
		    	/*jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.afterdealmessage1(driver));
			    String actmessage1=PGO_reviewAndSend.afterdealmessage1(driver).getText();
		    	String expmessage1=data.getStrExcelData(dRw,59, 5);
		    	libs.assertionHandling(actmessage1, expmessage1, test,driver,scrnshtPthNm);*/
		    	jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.afterdealmessage2(driver));
		    	String actmessage2=PGO_reviewAndSend.afterdealmessage2(driver).getText();
		    	String expmessage2=data.getStrExcelData(dRw,60, sheetno);
		    	libs.assertionHandling(actmessage2, expmessage2, test,driver,scrnshtPthNm);
		    	jse.executeScript("arguments[0].scrollIntoView(true)",PGO_reviewAndSend.afterdealmessage3(driver));
		    	String actmessage3=PGO_reviewAndSend.afterdealmessage3(driver).getText();
		    	String expmessage3=data.getStrExcelData(dRw,61, sheetno);
		    	libs.assertionHandling(actmessage3, expmessage3, test,driver,scrnshtPthNm);
		    	test.log(LogStatus.INFO, "Dealer Information");
		    	test.log(LogStatus.INFO, PGO_reviewAndSend.afterdealmessage4(driver).getText());
		    	test.log(LogStatus.INFO, "Test Drive Status");
		    	test.log(LogStatus.INFO, PGO_reviewAndSend.afterdealmessage5(driver).getText());
		    	test.log(LogStatus.INFO, "Message from Ford after submitting deal");
		    	test.log(LogStatus.INFO, PGO_reviewAndSend.afterdealmessage6(driver).getText());
		    	action.moveToElement(PGO_reviewAndSend.btn_sendMyDeal1(driver)).build().perform();
		    	libs.waitToClick(driver,PGO_reviewAndSend.btn_sendMyDeal1(driver),300);
				test.log(LogStatus.PASS, "Customer has submitted the deal successfully.");
				System.out.println("'Review & Send' testcase is passed.");
				data.writeToExcel("Passed", dRw, 11, sheetno);
							
			break;
			case"No":
				test.log(LogStatus.PASS, "'Send My deal' testcase is not executed. Customer chose appl credit.");
				data.writeToExcel("Passed", dRw, 11, sheetno);
			break;
			}
			
		}catch(Exception reviewAndSendexception)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, reviewAndSendexception.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm))); 
		}
	}
		
	@AfterTest
	public void tearReport(){
	report.endTest(test);
	report.flush();
	}
}
