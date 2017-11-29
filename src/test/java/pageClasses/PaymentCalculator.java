package pageClasses;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import libraryClasses.FuncitonLibrary;
import pageClasses.rsg_DriverClass;
import pageObjectClasses.PGO_PaymentCalculator;
import pageObjectClasses.PGO_SpecialOffers;
import pageObjectClasses.PGO_VehicleDetails;
import pageObjectClasses.PGO_reviewAndSend;
import utilityClasses.ExcelUtilityClass;
import utilityClasses.ExtentReportManager;
import utilityClasses.ScreenShot;
public class PaymentCalculator extends rsg_DriverClass
{

	WebDriverWait wait = new WebDriverWait(driver, 120);
	FuncitonLibrary libs = new FuncitonLibrary();
	JavascriptExecutor jse=(JavascriptExecutor) driver;	
	Actions action=new Actions(driver);
	int sheetno=3;

	public void PaymentCalculator_run(int dRw) throws Exception
	{
		try
		{
		invokeReport("Verify Payment Calculator",dRw);
		String runVal = data.getExcelData(dRw,"Payment Calculator","Testcases");
		String option= data.getExcelData(dRw,"Payment Type","PaymentCalculator");
		Thread.sleep(3000);
		libs.clickOnButton(PGO_PaymentCalculator.btn_next_Payment_continue(driver), "btn_next_Payment_continue");
		test.log(LogStatus.INFO, "Click on '"+option+"' in credit application", option+" has been clicked");
		AllValidationForPayment();
		Thread.sleep(5000);
		libs.clickOnButton(PGO_PaymentCalculator.txt_paymentType(driver,option), option);
		
		Thread.sleep(4000);
		 libs.clickOnButton(PGO_SpecialOffers.btn_SpecialOffers(driver), "Next: Special Offers");
			Thread.sleep(4000);
			libs.clickOnButton(PGO_reviewAndSend.btn_reviewAndSend(driver),"btn_reviewAndSend");
			test.log(LogStatus.INFO, "Payment verification completed and click on Review and Send button" );
	    	test.log(LogStatus.PASS,  "'Payment tab' testcase is passed.");
			data.writeToExcel("PASSED", dRw, 5, sheetno);
	    	test.log(LogStatus.PASS, "Review and Send tab page loads successfully" );
			tearReport();
			
		
		
//		switch(runVal){
//				case "Yes":
//					 invokeReport("Verify Payment Calculator",dRw);
//					 if(ValidationStatus.equalsIgnoreCase("Yes")){
//					 payment(dRw);
//					 paymentIntro(dRw);
//					 pmntSlctTyp(dRw);
//					 libs.clickOnButton(PGO_SpecialOffers.btn_SpecialOffers(driver), "Next: Special Offers");
//						Thread.sleep(4000);
//						libs.clickOnButton(PGO_reviewAndSend.btn_reviewAndSend(driver),"btn_reviewAndSend");
//						test.log(LogStatus.INFO, "Payment verification completed and click on Review and Send button" );
//				    	test.log(LogStatus.PASS,  "'Payment tab' testcase is passed.");
//						data.writeToExcel("PASSED", dRw, 5, sheetno);
//				    	test.log(LogStatus.PASS, "Review and Send tab page loads successfully" );
//						tearReport();
////				switch(option)
////				{
////				case"Buy":
////					 buy(dRw);
////					 break;
////				case "Lease":
////					  lease(dRw);
////					  break;
////				case "Cash":
////					  cash(dRw);
////					  break;
////				} 
//					 }
//					 else {
//							paymentMainmtd(dRw);
//							libs.clickOnButton(PGO_SpecialOffers.btn_SpecialOffers(driver), "Next: Special Offers");
//							Thread.sleep(4000);
//							libs.clickOnButton(PGO_reviewAndSend.btn_reviewAndSend(driver),"btn_reviewAndSend");
//							test.log(LogStatus.INFO, "Payment verification completed and click on Review and Send button" );
//					    	test.log(LogStatus.PASS,  "'Payment tab' testcase is passed.");
//							data.writeToExcel("PASSED", dRw, 5, sheetno);
//					    	test.log(LogStatus.PASS, "Review and Send tab page loads successfully" );
//							tearReport();
//						}
//					break;
//					case "No":
//						invokeReport("Verify Payment Calculator",dRw);
//					    skipPaymntal(dRw);
//					    tearReport();
//					    break;
//				}
		}
		catch(Exception PaymentCalculator)
		 {
			  Count++;
//			String scrnshtPth = data.getStrExcelData(dRw, 4, sheetno);
			System.out.println("'Payment tab' testcase is failed.");
			test.log(LogStatus.FAIL,  "'Payment tab' testcase is failed.");
			data.writeExceldata(dRw, "Result","PaymentCalculator","Failed");
			getscrnSht.getscreenshot(driver, scrnshtPth+"Payment tab_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL,  PaymentCalculator.getMessage(),test.addScreenCapture(Screenpathforreport( scrnshtPth+"Payment tab_Failed_"+libs.timestamp1()+".jpg")) );
			tearReport();
			
		}
	}
	/**
	 * --------------------------------Method------------------------------
	 * Method Name: < AllValidationForPayment > 
	 * Description: <This method will validate all the major components in payment page>
	 * Author: <Chandra Reddy K > 
	 * Created Date: < 09/27/2017 > 
	 * Modified By and On: < >
	 * Modified Comments: < >
	 * --------------------------------------------------------------------
	 * @throws Exception 
	 */
	
	public void AllValidationForPayment() throws Exception{
		if(ValidationStatus.equalsIgnoreCase("Yes")){
		libs.GlobalHeadingBar();
		libs.tabList("Vehicle Details Page");
		libs.VerifyText(PGO_PaymentCalculator.paymentHeading(driver), data.getExcelData(1,"Payment Heading","PaymentCalculator"),"Payment Intro - Heading Text","");
		libs.VerifyText(PGO_PaymentCalculator.paymentInline(driver), data.getExcelData(1,"Payment Inline Text","PaymentCalculator"),"Payment Intro - Inline Text","");
		libs.Pagedisclaimers("Vehicle Details",3);
		  //bottom text
		libs.componenttHeading("bottom text");
		libs.VerifyText(PGO_VehicleDetails.txt_BottomText(driver), data.getExcelData(1, "Bottom_Text", "Vehicle Details"), "txt_BottomText", "");
		}
				 
	 }
		
	
	public void skipPaymntal(int dRw) throws Exception
	{
		String trdval=data.getExcelData(dRw, "KBB Trade In", "Testcases");
		System.out.println(trdval);
		if(trdval.equals("Yes"))
		{
		libs.waitToClick(driver, PGO_PaymentCalculator.btn_next_Payment_continue(driver), 10);
		test.log(LogStatus.INFO, "Trade in condition & value - continue done - next payment clicked" );
		test.log(LogStatus.INFO, "Payment Intro Page loads successfully..." );
		}
		else
		{
			test.log(LogStatus.INFO, "Payment Intro Page loads successfully..." );
		}
		test.log(LogStatus.INFO,"Clicking on Skip Payment option");
		jse.executeScript("arguments[0].scrollIntoView(true)",PGO_PaymentCalculator.btn_SkipPaymntCal(driver));
		libs.waitToClick(driver, PGO_PaymentCalculator.btn_SkipPaymntCal(driver),10);
		test.log(LogStatus.INFO, "'Payment Calculator' testcase is not Executed.");
	    System.out.println("'Payment Calculator' testcase is not Executed.");
	    data.writeToExcel("Not Executed", dRw, 5, sheetno);
	    }
	public void paymentMainmtd(int dRw) throws Exception
	{
		try{String trdval=data.getExcelData(dRw, "KBB Trade In", "Testcases");
		System.out.println(trdval);
		if(trdval.equals("Yes"))
		{
		System.out.println("Pay Starts");
		test.log(LogStatus.INFO, "Payment tab execution starts.." );
		libs.clickOnButton(PGO_PaymentCalculator.btn_next_Payment_continue(driver), "btn_next_Payment_continue");
//		libs.waitToClick(driver, PGO_PaymentCalculator.btn_next_Payment_continue(driver), 10);
		test.log(LogStatus.INFO, "Trade in condition & value - continue done - next payment clicked" );
		test.log(LogStatus.INFO, "Payment Intro Page loads successfully..." );
		Thread.sleep(1000);
		libs.Disclosers();
		libs.Pagedisclaimers("PaymentCalculator",2);
		}else
		{
			System.out.println("Pay Starts");
			test.log(LogStatus.INFO, "Payment tab execution starts.." );
			test.log(LogStatus.INFO, "Payment Intro Page loads successfully..." );
		}
		paymentIntro(dRw);
		pmntSlctTyp(dRw);
		Thread.sleep(1000);
		libs.clickOnButton(PGO_PaymentCalculator.dreicon(driver), "dreicon");
		libs.Disclosers();
		libs.Pagedisclaimers("PaymentCalculator",22);
//		if(applicationname.contains("INT")) {
			
//	    	libs.waitToClick(driver, PGO_reviewAndSend.btn_reviewAndSend(driver), 50);
//		}else{
//		action.moveToElement(PGO_reviewAndSend.btn_reviewAndSend(driver)).build().perform();
//    	libs.waitToClick(driver, PGO_reviewAndSend.btn_reviewAndSend(driver), 50);//
		}catch(Exception e){
			scrnshtPthNm=scrnshtPthNm+"paymenttab.jpg";
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, "", test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
    	
	}
	public void buy(int dRw) throws Exception
	{
      buyPaymentVerification(dRw);
	  buypricingSummary(dRw);
	  buypaymentCal(dRw);
	  buyverification(dRw);
	  calVerifications(dRw);
	  creditBox(dRw);
	  buyFooter(dRw);
      tearReport();
	 }
    public void lease(int dRw) throws Exception
   {
    leasepaymentVerfication(dRw);
	leasePricingSummary(dRw);
	leasepaymentCal(dRw);
	leaseVerification(dRw);
	leasecreditBox(dRw);
	leaseFooter(dRw);
	tearReport();
	}
public void cash(int dRw) throws Exception
   {
	cashPaymentVerification(dRw);
	pricingSummary(dRw);
	paymentCal(dRw);
	verification(dRw);
	calVerifications(dRw);
	footerVerification(dRw);
	tearReport();
   }   
public void payment(int dRw) throws Exception
{
	String res=data.getExcelData(dRw,"Result","KBBTradeIn");
   //    String scrnshtPth = data.getStrExcelData(dRw, 4, sheetno);
    try
    {
	if(res.equals("Not Executed"))
	{
		test.log(LogStatus.PASS, "User navigated to 'Payment Calculator' page successfully." );
		test.log(LogStatus.INFO, "Payment tab test execution starts.." );
	}
	else
	{
		libs.waitToClick(driver, PGO_PaymentCalculator.btn_next_Payment_continue(driver), 10);
		test.log(LogStatus.INFO, "Trade in condition & value - continue done - next payment clicked" );
		wait.until(ExpectedConditions.elementToBeClickable(PGO_PaymentCalculator.lnk_lnkText(driver, "Disclosures")));
		test.log(LogStatus.PASS, "User navigated to 'Payment Calculator' page successfully." );
		test.log(LogStatus.INFO, "Payment tab test execution starts.." );
	}
    }
    catch(Exception payment)
    {
		  Count++;
		getscrnSht.getscreenshot(driver, scrnshtPth+"payment"+".jpg");
		test.log(LogStatus.FAIL, payment.getMessage(),test.addScreenCapture(Screenpathforreport(Screenpathforreport(scrnshtPth+"payment"+".jpg"))));
    }
}
	public void paymentIntro(int dRw) throws Exception
	{
//		String scrnshtPth = data.getStrExcelData(dRw, 4, sheetno);
		String scrnshtPthNm=scrnshtPth+"Payment tab failed"+".jpg";
		try{
		    String paymenttabact=PGO_PaymentCalculator.paymentVerification(driver).getText();
			String paymenttabexp=data.getExcelData(dRw,"Payment Verification","PaymentCalculator");
			if(paymenttabact.equals(paymenttabexp))
			{
			 test.log(LogStatus.PASS, "User navigated to Payment Introduction page" );
			}
			else
			{
			 getscrnSht.getscreenshot(driver,scrnshtPthNm );
			 test.log(LogStatus.FAIL, "User not navigated to Payment Introduction page",test.addScreenCapture(Screenpathforreport(scrnshtPth +"paymentIntro_Failed_"+libs.timestamp()+".jpg") ));	
			}
			String exph=data.getExcelData(dRw,"Payment Heading","PaymentCalculator");
			libs.VerifyText(PGO_PaymentCalculator.paymentHeading(driver), exph,"Payment Intro - Heading Text","");
			String expt=data.getExcelData(dRw,"Payment Inline Text","PaymentCalculator");
			libs.VerifyText(PGO_PaymentCalculator.paymentInline(driver), expt,"Payment Intro - Inline Text","");
			int a=PGO_PaymentCalculator.paymentOptions(driver).size();
			test.log(LogStatus.INFO, "Various payment options available in Ford");
			for(int i=0;i<a;i++)
			{
			 test.log(LogStatus.INFO,PGO_PaymentCalculator.paymentOptions(driver).get(i).getText() );
			}
			}
			catch(Exception paymentIntro)
		 {
				  Count++;
				getscrnSht.getscreenshot(driver, scrnshtPth+"paymentIntro_Failed_"+libs.timestamp()+".jpg");
				test.log(LogStatus.FAIL, paymentIntro.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"paymentIntro_Failed_"+libs.timestamp()+".jpg") ));
			}
		}
		
	public void pmntSlctTyp(int dRw) throws Exception
	{
		//String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
		String pType = data.getExcelData(dRw,"Payment Type","PaymentCalculator");
		pType=pType.toLowerCase();
		try
		{
			libs.VerifyElement(PGO_PaymentCalculator.lnk_lnkText(driver, pType),"Buy Option",driver,test,dRw);
//			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_PaymentCalculator.lnk_lnkText(driver, pType));
//			actions.moveToElement(PGO_PaymentCalculator.lnk_lnkText(driver, pType)).doubleClick().build().perform();
			libs.clickOnButton(PGO_PaymentCalculator.lnk_lnkText(driver, pType),pType );
		
//			PGO_PaymentCalculator.lnk_lnkText(driver, pType).click();
			test.log(LogStatus.PASS, "User has selected "+pType+" as payment option successfully" );
			}
		catch(Exception pmntSlctTypException)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver, scrnshtPth+"pmntSlctTyp_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, pmntSlctTypException.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"pmntSlctTyp_Failed_"+libs.timestamp1()+".jpg") ));
		}
		}
	public void buyPaymentVerification(int dRw) throws Exception
	{
//		String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
		String scrnshtPthNm=scrnshtPth+"Payment tab failed"+libs.timestamp()+".jpg";
		try
		{
	    String expb=data.getExcelData(dRw,"Payment Type","PaymentCalculator");		
		libs.VerifyText(PGO_PaymentCalculator.option(driver),expb,"Buy Payment Option","");	
		String exptext=data.getExcelData(dRw,"InlineText","PaymentCalculator");
		libs.VerifyText(PGO_PaymentCalculator.option(driver),exptext,"Buy Payment Option","");
		}
		catch(Exception buyPaymentVerification)
		 {
		  Count++;
		  getscrnSht.getscreenshot(driver, scrnshtPth+"buyPaymentVerification_Failed_"+libs.timestamp1()+".jpg");
		  test.log(LogStatus.FAIL, buyPaymentVerification.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
	}
	 public void buypricingSummary(int dRw) throws Exception
	 {
	 
//		 String scrnshtPth = data.getStrExcelData(dRw, 4, 3); 
		 String scrnshtPthNm=scrnshtPth+"Payment tab failed"+libs.timestamp()+".jpg";
		 try{
		String exphe=data.getExcelData(dRw,"Step1 Heading","PaymentCalculator");
		libs.VerifyText(PGO_PaymentCalculator.step1Heading(driver), exphe, "Step 1 Heading","");
		jse.executeScript("arguments[0].scrollIntoView(true)",PGO_PaymentCalculator.dreicon(driver));
		libs.waitToClick(driver,PGO_PaymentCalculator.dreicon(driver),300);
		test.log(LogStatus.PASS, "Total MSRP dre icon clicked successfully" );
		test.log(LogStatus.PASS, "Estimated taxes dre icon clicked successfully" );
		//ps - pricing stack elements, psssize - size of pricing stack elements
		int psssize=PGO_PaymentCalculator.buyPricingStack(driver).size();
		System.out.println(psssize);
		for(int ps=0;ps<psssize;ps++)
		{
			if(PGO_PaymentCalculator.buyPricingStackHeading(driver).get(ps).getText().isEmpty())
		    {
		      System.out.println("Element Not Present");	
		    }
		    else
		    {
//		      String priceLabel=PGO_PaymentCalculator.buyPricingStackHeading(driver).get(ps).getText();
//		      System.out.println(priceLabel);
		      String priceVal=PGO_PaymentCalculator.buyPricingStackValues(driver).get(ps).getText();
		      System.out.println(priceVal);
		    }
		}
		   for(int i=0;i<8;i++)
		{
			String text=data.getStrExcelData(dRw, 6+i, 3);
			System.out.println(text);
			String text1=data.getStrExcelData(dRw, 12+i, 9);
			System.out.println(text1);
			if(text.equals(text1))
			{
			    System.out.println("Pricevalues in Payment tab is same as Vehicle details tab");
				test.log(LogStatus.PASS,"Pricevalues in Payment tab is same as Vehicle details tab");	
			}
			else
			{
			     System.out.println("Pricevalues in Payment tab is not same as Vehicle details tab");
			     getscrnSht.getscreenshot(driver,scrnshtPthNm );
				 test.log(LogStatus.FAIL,"Pricevalues in Payment tab is not same as Vehicle details tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
			}
		}
			String rembal=PGO_PaymentCalculator.balanceTradein(driver).getAttribute("value");
		    System.out.println("Balance"+rembal);
			data.writeExceldata(dRw,"Output_Buy_Remaining Balance on Trade-In","PaymentCalculator","rembal");
			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_PaymentCalculator.downPaymentTextbox(driver));
			String downval=PGO_PaymentCalculator.downPaymentTextbox(driver).getAttribute("value");
		    System.out.println("Down payment" +downval);
			data.writeExceldata(dRw,"Output_Buy_Down Payment","PaymentCalculator","downval");
			test.log(LogStatus.PASS, "Buy option Pricing values verified successfully" );
		}
		catch(Exception buypricingSummary)
		 {
		  Count++;
		  getscrnSht.getscreenshot(driver, scrnshtPth+"buypricingSummary_Failed_"+libs.timestamp1()+".jpg");
		  test.log(LogStatus.FAIL, buypricingSummary.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"buypricingSummarymethod_Failed_"+libs.timestamp1()+".jpg")) );
		}
	 }
	 public void buypaymentCal(int dRw) throws Exception
	  {
//		 String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
		  String scrnshtPthNm=scrnshtPth+"Payment section failed"+libs.timestamp1()+".jpg";
		 try{
		  String totalmsrp=PGO_PaymentCalculator.buytotalMSRP(driver).getText();
		  String totalmsrp1=libs.getNumfrmString(totalmsrp);
		  int totalmsrp2=libs.stringToInt(totalmsrp1);
		  test.log(LogStatus.INFO,"Total Msrp - "+totalmsrp2);
		  String basemsrp=PGO_PaymentCalculator.buybaseMSRP(driver).getText();
		  String basemsrp1=libs.getNumfrmString(basemsrp);
		  int basemsrp2=libs.stringToInt(basemsrp1);
		  test.log(LogStatus.INFO,"Base MSRP - "+basemsrp2);
		  String totaloptions=PGO_PaymentCalculator.buytotalOptions(driver).getText();
		  String totaloptions1=libs.getNumfrmString(totaloptions);
		  int totaloptions2=libs.stringToInt(totaloptions1);
		  test.log(LogStatus.INFO,"Total of options - "+totaloptions2);
		  String descharg=PGO_PaymentCalculator.buydestdelcharges(driver).getText();
		  String descharg1=libs.getNumfrmString(descharg);
		  int descharg2=libs.stringToInt(descharg1);
		  test.log(LogStatus.INFO,"Destination and Delivery Charges - "+descharg2);
		  int sum=basemsrp2+totaloptions2+descharg2;
		  test.log(LogStatus.INFO,"Sum of Base MSRP,Total of options and Destination and delivery charges - "+sum);
		  if(totalmsrp2==sum)
		  {
			test.log(LogStatus.PASS, "Total MSRP is sum of Base MSRP,total of options and destination and delivery charges" );
		  }
		  else
		  {
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
			test.log(LogStatus.FAIL, "Total MSRP is not sum of Base MSRP,total of options and destination and delivery charges",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );  
		  }
		  String diffmsrp=PGO_PaymentCalculator.buydiffermsrp(driver).getText();
		  String diffmsrp1=libs.getNumfrmString(diffmsrp);
		  int diffmsrp2=libs.stringToInt(diffmsrp1);
		  test.log(LogStatus.INFO,"Difference from Total MSRP - "+diffmsrp2);
		  String dealprice=PGO_PaymentCalculator.buydealerprice(driver).getText();
		  String dealprice1=libs.getNumfrmString(dealprice);
		  int dealprice2=libs.stringToInt(dealprice1);
		  test.log(LogStatus.INFO,"Dealer Selling Price - "+dealprice2);
		  int diff=totalmsrp2-dealprice2;
		  test.log(LogStatus.INFO,"Difference between Total MSRP and Dealer Selling Price - "+diff);
		  if(diffmsrp2==diff)
		  {
			test.log(LogStatus.PASS, "Difference from total MSRP is difference between Total MSRP and dealer selling price" );
		  }
		  else
		  {
			 getscrnSht.getscreenshot(driver,scrnshtPthNm );
			 test.log(LogStatus.FAIL, "Difference from total MSRP is difference between Total MSRP and dealer selling price",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );  
		  }
		  String esttaxx=PGO_PaymentCalculator.buyestimatedTax(driver).getText();
		  String esttaxx1=libs.getNumfrmString(esttaxx);
		  int esttaxx2=libs.stringToInt(esttaxx1);
		  test.log(LogStatus.INFO,"Estimated Tax - "+esttaxx2);
		  String titfee=PGO_PaymentCalculator.buytitleFee(driver).getText();
		  String titfee1=libs.getNumfrmString(titfee);
		  int titfee2=libs.stringToInt(titfee1);
		  test.log(LogStatus.INFO,"Title Fee - "+titfee2);
		  String docfee=PGO_PaymentCalculator.buydocumentationFee(driver).getText();
		  String docfee1=libs.getNumfrmString(docfee);
		  int docfee2=libs.stringToInt(docfee1);
		  test.log(LogStatus.INFO,"Documentation Fee - "+docfee2);
		  String totfee=PGO_PaymentCalculator.buytotalTax(driver).getText();
		  String totfee1=libs.getNumfrmString(totfee);
		  int totfee2=libs.stringToInt(totfee1);
		  test.log(LogStatus.INFO,"Total Taxes and Total Fee - "+totfee2);
		  if(totfee2==esttaxx2+titfee2+docfee2)
		  {
			test.log(LogStatus.PASS, "Estimated taxes & Fees Total is sum of Estimated tax,title fee and documentation fee" );
		  }
		  else
		  {
			getscrnSht.getscreenshot(driver,scrnshtPthNm );  
			test.log(LogStatus.FAIL, "Estimated taxes & Fees Total is not sum of Estimated tax,title fee and documentation fee",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );  
		  }
		  String esttaxp=PGO_PaymentCalculator.buyEst(driver).getText();
		  String esttaxp1=libs.getNumfrmString(esttaxp);
		  int esttaxp2=libs.stringToInt(esttaxp1);
		  test.log(LogStatus.INFO,"Pre estimated Tax Price "+esttaxp2);
		  Boolean a=PGO_PaymentCalculator.availableCentives(driver).isDisplayed();
		  if(a==true)
		  {
		    String avlbal=PGO_PaymentCalculator.availableCentives(driver).getText();
		    System.out.println(avlbal);
		    String avlbal1=libs.getNumfrmString(avlbal);
		    System.out.println(avlbal1);
		  	int avlbal2=libs.stringToInt(avlbal1);
		  	System.out.println(avlbal2);
		  	test.log(LogStatus.INFO,"Available Incentives - "+avlbal2);
		  	int taxprice=dealprice2-avlbal2;
		  	System.out.println(taxprice);
		  	test.log(LogStatus.INFO,"Difference between Dealer selling price and Available incentives - "+taxprice);
		  	if(esttaxp2==taxprice)
		  	{
		  	 System.out.println("Estimated pre tax price is difference between dealer selling price and available incentives");
		  	 test.log(LogStatus.PASS,"Estimated pre tax price is difference between dealer selling price and available incentives");
		  	}
		  	else
		  	{
		  	  System.out.println("Estimated pre tax price is not the difference between dealer selling price and available incentives");
		  	  getscrnSht.getscreenshot(driver,scrnshtPthNm );  
		  	  test.log(LogStatus.FAIL,"Estimated pre tax price is not the difference between dealer selling price and available incentives",test.addScreenCapture(Screenpathforreport(scrnshtPthNm))); 
		  	}
		      }
		     else
		     {
		  	int taxprice=dealprice2;
		  	if(esttaxp2==taxprice)
		  	{
		  	  System.out.println("If there is no available incentives, then Dealer selling price is equal to estimated pre tax price");
		  	  test.log(LogStatus.PASS,"If there is no available incentives, then Dealer selling price is equal to estimated pre tax price");
		  	}
		      else
		  	{
		  	  System.out.println("If there is no available incentives, then Dealer selling price is equal to estimated pre tax price");
		  	  getscrnSht.getscreenshot(driver,scrnshtPthNm ); 
		  	  test.log(LogStatus.FAIL,"If there is no available incentives, then Dealer selling price is equal to estimated pre tax price",test.addScreenCapture(Screenpathforreport(scrnshtPthNm))); 
		  	}
		       }  
			   
		  }
		  catch(Exception buypaymentCal)
		 {
			  Count++;
		  getscrnSht.getscreenshot(driver, scrnshtPthNm);
		  test.log(LogStatus.FAIL, buypaymentCal.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"buypaymentCalmethod_Failed_"+libs.timestamp1()+".jpg")) );
		}
		   }
	 public void buyverification(int dRw) throws Exception
	 {
//		String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
		String scrnshtPthNm=scrnshtPth+"Payment section failed"+".jpg";
		try
		{
		String downval=PGO_PaymentCalculator.downPaymentTextbox(driver).getAttribute("value");
		int downval1=libs.stringToInt(downval);
		test.log(LogStatus.INFO,"Value in down payment text box "+downval1);
		String dealerprice=PGO_PaymentCalculator.dealerSellingPrice(driver).getText();
		String dealerprice1=libs.getNumfrmString(dealerprice);
		int dealerprice3=libs.stringToInt(dealerprice1);
		test.log(LogStatus.INFO,"Dealer selling price - "+dealerprice3);
		int downval2=((dealerprice3*10)/100);
		if(downval1==downval2)
		  {
			test.log(LogStatus.PASS, "Downpayment value is 10% of dealer selling price" );
		  }
		  else
		  {
			getscrnSht.getscreenshot(driver, scrnshtPthNm);  
			test.log(LogStatus.FAIL, "Downpayment value is not 10% of dealer selling price",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );  
		  }
		PGO_PaymentCalculator.downPaymentTextbox(driver).clear();
		String a=data.getStrExcelData(1,61,3);
		PGO_PaymentCalculator.downPaymentTextbox(driver).sendKeys(a);
		String val=PGO_PaymentCalculator.downPaymentTextbox(driver).getAttribute("value");
		test.log(LogStatus.INFO,"Value in downpayment text box "+val);
		test.log(LogStatus.PASS, "Down payment text box accepts numeric values" );
		PGO_PaymentCalculator.downPaymentTextbox(driver).clear();
		String b=data.getStrExcelData(1,62,3);
		PGO_PaymentCalculator.downPaymentTextbox(driver).sendKeys(b);
		String val1=PGO_PaymentCalculator.downPaymentTextbox(driver).getAttribute("value");
		test.log(LogStatus.INFO,"Value in downpayment text box "+val1);
		action.moveToElement(PGO_PaymentCalculator.dreicon(driver)).build().perform();
		libs.waitToClick(driver,PGO_PaymentCalculator.dreicon(driver),300);
		String val2=PGO_PaymentCalculator.downPaymentTextbox(driver).getAttribute("value");
		test.log(LogStatus.INFO,"Value in downpayment text box "+val2);
		if(val2.equals(a))
		{
		test.log(LogStatus.PASS, "Down payment text box does not accept negative values" );
		}
		else
		{
			getscrnSht.getscreenshot(driver, scrnshtPthNm); 
			test.log(LogStatus.FAIL,"Down payment text box allows negative values",test.addScreenCapture(Screenpathforreport(scrnshtPthNm )));
		}
		String c=PGO_PaymentCalculator.kellyTradeinValue(driver).getText();
		test.log(LogStatus.INFO,"Kelly blue book trade in value "+c);
		if(c.equals("$0"))
		{
	      test.log(LogStatus.PASS, "TradeIn skipped - Kelly blue book Trade In value is $0 - verified successfully" );	
		}
		else
		{
		  test.log(LogStatus.PASS, "Trade in evaluation is completed, not skipped and verified successfully" );
		  String text=PGO_PaymentCalculator.kellyTradeinValue(driver).getText();
		  System.out.println(text);
		  String text1=data.getStrExcelData(dRw, 13, 6);
		  System.out.println(text1);
		  if(text.equals(text1))
		  {
			  System.out.println("Kelly blue book trade in value in Payment tab is same as Trade in tab");
			  test.log(LogStatus.PASS, "Kelly blue book trade in value in Payment tab is same as Trade in tab" );
		  }
		  else
		  {
			  System.out.println("Kelly blue book trade in value in Payment tab is not same as Trade in tab");
			  getscrnSht.getscreenshot(driver, scrnshtPthNm); 
			  test.log(LogStatus.FAIL,"Kelly blue book trade in value in Payment tab is not same as Trade in tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		  }
		}
		PGO_PaymentCalculator.downPaymentTextbox(driver).clear();
		String d=data.getStrExcelData(1,63,3);
		PGO_PaymentCalculator.downPaymentTextbox(driver).sendKeys(d);
		String va=PGO_PaymentCalculator.downPaymentTextbox(driver).getAttribute("value");
		test.log(LogStatus.INFO,"Value in down payment textbox "+va);
		Boolean dis=PGO_PaymentCalculator.balanceTradein(driver).isEnabled();
		test.log(LogStatus.INFO,"Remaining balance trade in text box enabled "+dis);
		if(dis==false)
		{
			test.log(LogStatus.PASS, "Tradein skipped,so Remaining balance trade in text box is disabled" );
            		
		}
		else
		{
			test.log(LogStatus.PASS, "Tradein evaluation is completed,so Remaining balance trade in text box is enabled" );
			PGO_PaymentCalculator.balanceTradein(driver).clear();
			String p=data.getStrExcelData(1,81,3);
			PGO_PaymentCalculator.balanceTradein(driver).sendKeys(p);
			action.moveToElement(PGO_PaymentCalculator.dreicon1(driver)).build().perform();
		    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon1(driver),300);
			String v1=PGO_PaymentCalculator.balanceTradein(driver).getAttribute("value");
			String v2=data.getStrExcelData(1,82,3);
			if(v1.equals(v2))
			{
			 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept negative values" );
			}
			else
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm); 	
			 test.log(LogStatus.FAIL, "Remaining balance trade in text box accepts negative values",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			PGO_PaymentCalculator.balanceTradein(driver).clear();
			String q=data.getStrExcelData(1,83,3);
			PGO_PaymentCalculator.balanceTradein(driver).sendKeys(q);
			action.moveToElement(PGO_PaymentCalculator.dreicon(driver)).build().perform();
		    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon(driver),300);
			String v3=PGO_PaymentCalculator.balanceTradein(driver).getAttribute("value");
			String v4=data.getStrExcelData(1,84,3);
			if(v3.equals(v4))
			{
			 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept alphabets" );
			}
			else
			{
			 getscrnSht.getscreenshot(driver, scrnshtPthNm); 	
			 test.log(LogStatus.FAIL, "Remaining balance trade in text box does accepts alphabets",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			PGO_PaymentCalculator.balanceTradein(driver).clear();
			String r=data.getStrExcelData(1,85,3);
			PGO_PaymentCalculator.balanceTradein(driver).sendKeys(r);
			action.moveToElement(PGO_PaymentCalculator.dreicon1(driver)).build().perform();
		    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon1(driver),300);
			String v5=PGO_PaymentCalculator.balanceTradein(driver).getAttribute("value");
			String v6=data.getStrExcelData(1,86,3);
			if(v5.equals(v6))
			{
			 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept decimal values" );
			}
			else
			{
			 getscrnSht.getscreenshot(driver, scrnshtPthNm); 	
			 test.log(LogStatus.FAIL, "Remaining balance trade in text box does accepts decimal values",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			PGO_PaymentCalculator.balanceTradein(driver).clear();
			String ex=data.getStrExcelData(1,87,3);
			PGO_PaymentCalculator.balanceTradein(driver).sendKeys(ex);
			action.moveToElement(PGO_PaymentCalculator.dreicon(driver)).build().perform();
		    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon(driver),300);
			String p5=PGO_PaymentCalculator.balanceTradein(driver).getAttribute("value");
			String p6=data.getStrExcelData(1,84,3);
			if(p5.equals(p6))
			{
			 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept special characters" );
			}
			else
			{
			 getscrnSht.getscreenshot(driver, scrnshtPthNm); 	
			 test.log(LogStatus.FAIL, "Remaining balance trade in text box accepts special characters",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			}
		action.moveToElement(PGO_PaymentCalculator.dreicon(driver)).build().perform();
	    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon(driver),300);
		String va2=PGO_PaymentCalculator.downPaymentTextbox(driver).getAttribute("value");
		if(va2.equals("0"))
		{
		
		test.log(LogStatus.PASS, "Down payment text box does not allow alpha numeric values" );
		}
		else
		{
		getscrnSht.getscreenshot(driver, scrnshtPthNm); 	
		test.log(LogStatus.FAIL, "Down payment text box allows alpha numeric values",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );	
		}
		PGO_PaymentCalculator.downPaymentTextbox(driver).clear();
		String e=data.getStrExcelData(1,64,3);
		PGO_PaymentCalculator.downPaymentTextbox(driver).sendKeys(e);
		action.moveToElement(PGO_PaymentCalculator.editButton(driver)).build().perform();
		libs.waitToClick(driver,PGO_PaymentCalculator.editButton(driver),300);
		test.log(LogStatus.PASS, "Clicking on edit button,application navigated to TradeIn page successfully" );
		libs.waitToClick(driver,PGO_PaymentCalculator.paymentTabs(driver),300);
		test.log(LogStatus.PASS, "Clicking on Payment tab,application navigates back to Payment tab successfully" );
		String vaa1=PGO_PaymentCalculator.downPaymentTextbox(driver).getAttribute("value");
		String vaa2=data.getStrExcelData(1,65,3);
		if(vaa1.equals(vaa2))
		{
			test.log(LogStatus.PASS, "Downpayment text box does not allow decimal values" );
		}
		else
		{
			getscrnSht.getscreenshot(driver, scrnshtPthNm); 
			test.log(LogStatus.FAIL, "Downpayment text allows decimal values",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		}
		PGO_PaymentCalculator.downPaymentTextbox(driver).clear();
		PGO_PaymentCalculator.downPaymentTextbox(driver).sendKeys(downval);
		PGO_PaymentCalculator.balanceTradein(driver).clear();
		}
		catch(Exception buyverification)
		 {
		  Count++;
		  getscrnSht.getscreenshot(driver, scrnshtPthNm);
		  test.log(LogStatus.FAIL, buyverification.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm) ));
		}
	}
	public void calVerifications(int dRw) throws Exception
	{
//	   String scrnshtPth = data.getStrExcelData(dRw, 4, 3); 
		String scrnshtPthNm=scrnshtPth+"Payment section failed"+libs.timestamp1()+".jpg";
		try
	{
		  Boolean disp=PGO_PaymentCalculator.buyalertIcon(driver).isDisplayed();
		  if(disp==true)
		  {
		   System.out.println("You appear to owe more than the value of your trade-in.");
		   test.log(LogStatus.INFO, "You appear to owe more than the value of your trade-in." );
		   PGO_PaymentCalculator.buyalertIcon(driver).click();
		   System.out.println(PGO_PaymentCalculator.buyalertHeading(driver).getText());
		   System.out.println(PGO_PaymentCalculator.buyalertText(driver).getText());
		   PGO_PaymentCalculator.buyalertClose(driver).click();
		   }
		else
		 {
		    System.out.println("You don't appear to owe more than the value of your trade-in.");
			test.log(LogStatus.INFO, "You don't appear to owe more than the value of your trade-in." );
			String rembal=PGO_PaymentCalculator.balanceTradein(driver).getAttribute("value");
		    System.out.println(rembal);
		 }
		 Boolean disp1=PGO_PaymentCalculator.downalertIcon(driver).isDisplayed();
		  if(disp1==true)
		  {
		   System.out.println("Due to your Down Payment being too high for this vehicle at this time, we are unable to calculate payment options.");
		   test.log(LogStatus.INFO, "Due to your Down Payment being too high for this vehicle at this time, we are unable to calculate payment options." );
		   PGO_PaymentCalculator.downalertText(driver).click();
		   System.out.println(PGO_PaymentCalculator.downalertText(driver).getText());
		   PGO_PaymentCalculator.downalertClose(driver).click();
		   }
		else
		 {
		    System.out.println("Down payment not high");
			test.log(LogStatus.INFO, "Down payment not high" );
		 }
		 //Calculating Net Estimated Tradein amount:
		  String text=PGO_PaymentCalculator.kellyTradeinValue(driver).getText();
		  System.out.println(text);
		  String text1=libs.getNumfrmString(text);
		  System.out.println(text1);
		  int text2=libs.stringToInt(text1);
		  System.out.println(text2);
		  String rembal=PGO_PaymentCalculator.balanceTradein(driver).getText();
		  System.out.println(rembal);
		  String rembal1=libs.getNumfrmString(rembal);
		  System.out.println(rembal1);
		  int rembal2=libs.stringToInt(rembal1);
		  System.out.println(rembal2);
		  String estnetamt=data.getStrExcelData(dRw,20,3);
		  System.out.println(estnetamt);
		  String estnetamt1=libs.getNumfrmString(estnetamt);
		  System.out.println(estnetamt1);
		  int estnetamt2=libs.stringToInt(estnetamt1);
		  System.out.println(estnetamt2);
		  int estnetamt3=text2-rembal2;
		  System.out.println(estnetamt3);
		  if(estnetamt2==estnetamt3)
		  {
		    System.out.println("Estimated net trade-in amount is difference between Kelly blue book trade in value and Remaining balance trade in if any");
			test.log(LogStatus.PASS, "Estimated net trade-in amount is difference between Kelly blue book trade in value and Remaining balance trade in if any" );
		  }
		  else
		  {
		   System.out.println("Estimated net trade-in amount is not the difference between Kelly blue book trade in value and Remaining balance trade in if any");
		   getscrnSht.getscreenshot(driver,scrnshtPthNm);
			test.log(LogStatus.FAIL, "Estimated net trade-in amount is not the difference between Kelly blue book trade in value and Remaining balance trade in if any" );
		  }
		  }
	 catch(Exception calVerifications)
		 {
		  Count++;
	   getscrnSht.getscreenshot(driver,scrnshtPthNm);
	   test.log(LogStatus.FAIL, calVerifications.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
	 }
	}
		public void creditBox(int dRw) throws Exception
		{
//		String scrnshtPth = data.getStrExcelData(dRw, 4, 3); 
		String scrnshtPthNm=scrnshtPth+"Payment section failed"+libs.timestamp1()+".jpg";
		try{
			String exphea=data.getExcelData(dRw,"Step 2: Heading","PaymentCalculator");
			libs.VerifyText(PGO_PaymentCalculator.step2Heading(driver),exphea,"Step 2 Title","");
			String expincenrate=data.getExcelData(dRw,"Incentive Rate","PaymentCalculator");
			libs.VerifyText(PGO_PaymentCalculator.incentivesHeader(driver),expincenrate,"Incentive Rate Title","");
			String expuserrate=data.getExcelData(dRw,"User Rate","PaymentCalculator");
			libs.VerifyText(PGO_PaymentCalculator.userratesHeader(driver),expuserrate,"User Rate Title","");
		    test.log(LogStatus.PASS, "Credit section titles verified successfully" );
		    test.log(LogStatus.INFO,"Incentive Rate Credit Box details");
		    int incentives=PGO_PaymentCalculator.incentives(driver).size();
		    test.log(LogStatus.INFO,"Number of Incentive Rate Credit Box - "+" "+incentives);
		    for(int i=0;i<incentives;i++)
			  {
				test.log(LogStatus.INFO,PGO_PaymentCalculator.incentives(driver).get(i).getText());
			  }
		    test.log(LogStatus.INFO,"User Rate Credit Box details");
    	    int rates=PGO_PaymentCalculator.rates(driver).size();
    	    test.log(LogStatus.INFO,"Number of User Rate Credit Box - "+" "+rates);
		    for(int i=0;i<rates;i++)
		    {
			test.log(LogStatus.INFO,PGO_PaymentCalculator.rates(driver).get(i).getText());
		     }
		
			test.log(LogStatus.PASS, "Credit box details verified successfully");
		}			
		catch(Exception creditBox)
		 {
			  Count++;
		  getscrnSht.getscreenshot(driver, scrnshtPth+"creditBoxmethod_Failed_"+libs.timestamp1()+".jpg");
		  test.log(LogStatus.FAIL, creditBox.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"creditBoxmethod_Failed_"+libs.timestamp1()+".jpg") ));
		}
		}
		public void buyFooter(int dRw) throws Exception
		{
//		    String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
			String scrnshtPthNm=scrnshtPth+"Payment tab failed"+libs.timestamp1()+".jpg";
			try{
				 Thread.sleep(15000);
//			test.log(LogStatus.INFO,PGO_PaymentCalculator.estimatedpretaxFooter(driver).getText());
//			test.log(LogStatus.PASS, "Estimated PreTax price in the footer verified successfully" );
//			test.log(LogStatus.INFO,PGO_PaymentCalculator.estimatedamtFooter(driver).getText());
//			test.log(LogStatus.PASS, "Estimated amount financed in the footer verified succesfully" );
//			test.log(LogStatus.INFO,PGO_PaymentCalculator.estimatedmonFooter(driver).getText());
//			test.log(LogStatus.PASS, "Estimated monthly amount verified successfully" );
//			String distext=PGO_PaymentCalculator.buydisclaimerFooter(driver).getText();
//			test.log(LogStatus.INFO,"Disclaimer text in footer - "+distext);
//			String exptext=data.getStrExcelData(dRw, 60, 3);
//			libs.assertionHandling(distext, exptext, test, driver, scrnshtPthNm);
//			test.log(LogStatus.PASS,"Disclaimer text in footer verified successfully");
			action.moveToElement(PGO_reviewAndSend.btn_reviewAndSend(driver)).build().perform();
	    	libs.waitToClick(driver, PGO_reviewAndSend.btn_reviewAndSend(driver), 50);
	    	test.log(LogStatus.INFO, "Payment verification completed and click on Review and Send button" );
			System.out.println(" 'Payment tab' testcase is passed.");
		    data.writeToExcel("Passed", dRw, 5, 3);
			test.log(LogStatus.PASS,"'Payment tab' testcase is passed.") ;
			}
			catch(Exception buyFooter)
			 {
				  Count++;
		  getscrnSht.getscreenshot(driver, scrnshtPth+"buyFootermethod_Failed_"+libs.timestamp1()+".jpg");
		  test.log(LogStatus.FAIL, buyFooter.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"buyFootermethod_Failed_"+libs.timestamp1()+".jpg") ));
		}
			
		}

		public void buyPymtEntrOwnApr(int dRw) throws Exception
		{
//			String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
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
                buypricingSummary(dRw);
			}			
			catch(Exception buyPymtEntrOwnApr)
			 {
				  Count++;
			  getscrnSht.getscreenshot(driver, scrnshtPth+"buyPymtEntrOwnApr_Failed_"+libs.timestamp1()+".jpg");
			  test.log(LogStatus.FAIL, buyPymtEntrOwnApr.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"buyPymtEntrOwnApr_Failed_"+libs.timestamp1()+".jpg") ));
			}			
		}
		public void leasepaymentVerfication(int dRw) throws Exception
	  {
//		  String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
		  String scrnshtPthNm=scrnshtPth+"Payment details tab failed"+libs.timestamp1()+".jpg";
		  String actb=PGO_PaymentCalculator.option(driver).getText(); 
		  test.log(LogStatus.INFO, "Option selected - "+actb );
		  String ectb=data.getStrExcelData(dRw,3,3);
		  libs.assertionHandling(actb, ectb, test,driver,scrnshtPthNm);
	      test.log(LogStatus.PASS, "Lease option is highlighted and verified successfully" );
	      String actpaytext=PGO_PaymentCalculator.leasepaymentInlinetext(driver).getText();
	      test.log(LogStatus.INFO,"Actual Lease Payment Inline Text "+actpaytext);
	      String exppaytext=data.getStrExcelData(dRw, 57,3);
	      libs.assertionHandling(actpaytext, exppaytext, test,driver,scrnshtPthNm);
		  test.log(LogStatus.PASS, "Lease Payment - Inline text verified" );
	  }
	  public void leasePricingSummary(int dRw) throws Exception
	  {
//		  String scrnshtPth = data.getStrExcelData(dRw, 4, 3); 
		  String scrnshtPthNm=scrnshtPth+"Payment details tab failed"+libs.timestamp1()+".jpg";
		  String acthe=PGO_PaymentCalculator.leasestep1Heading(driver).getText(); 
		  test.log(LogStatus.INFO,"Actual Step 1 title - "+acthe);
		  String exphe=data.getStrExcelData(dRw,58, 3);
		  libs.assertionHandling(acthe, exphe, test,driver,scrnshtPthNm);
		  test.log(LogStatus.PASS, "Downpayment - Step1 title is verified" );
	      action.moveToElement(PGO_PaymentCalculator.leasedreIcon(driver)).build().perform();
		  libs.waitToClick(driver,PGO_PaymentCalculator.leasedreIcon(driver),300);
		  test.log(LogStatus.PASS, "Total MSRP dre icon clicked successfully" );
		  jse.executeScript("arguments[0].scrollIntoView(true)",PGO_PaymentCalculator.leasedreIcon1(driver));
		  action.moveToElement(PGO_PaymentCalculator.leasedreIcon1(driver)).build().perform();
		  libs.waitToClick(driver,PGO_PaymentCalculator.leasedreIcon1(driver),400);
		  test.log(LogStatus.PASS, "Estimated taxes dre icon clicked successfully" );
		  int elem1=PGO_PaymentCalculator.leasedownPayment(driver).size();
		  for(int b=0;b<elem1;b++)
			  {
				String text=PGO_PaymentCalculator.leasedownPayment(driver).get(b).getText();
				data.writeToExcel(text, dRw, 26+b, 3);
			  }
			test.log(LogStatus.PASS, "Pricing values verified and printed in excel successfully" );
	  }
	  public void leasepaymentCal(int dRw) throws Exception
	  {
		  String totalmsrp=PGO_PaymentCalculator.leasetotalMSRP(driver).getText();
		  String totalmsrp1=libs.getNumfrmString(totalmsrp);
		  int totalmsrp2=libs.stringToInt(totalmsrp1);
		  test.log(LogStatus.INFO,"Total MSRPvalue is "+totalmsrp2);
		  String basemsrp=PGO_PaymentCalculator.leasebaseMSRP(driver).getText();
		  String basemsrp1=libs.getNumfrmString(basemsrp);
		  int basemsrp2=libs.stringToInt(basemsrp1);
		  test.log(LogStatus.INFO,"Base MSRP value is "+basemsrp2);
		  String totaloptions=PGO_PaymentCalculator.leasetotalOptions(driver).getText();
		  String totaloptions1=libs.getNumfrmString(totaloptions);
		  int totaloptions2=libs.stringToInt(totaloptions1);
		  test.log(LogStatus.INFO,"Total of options is "+totaloptions2);
		  String descharg=PGO_PaymentCalculator.leasedestdelcharges(driver).getText();
		  String descharg1=libs.getNumfrmString(descharg);
		  int descharg2=libs.stringToInt(descharg1);
		  test.log(LogStatus.INFO,"Destination and delivery charges "+descharg2);
		  int sum=basemsrp2+totaloptions2+descharg2;
		  test.log(LogStatus.INFO,"Sum of Base MSRP,Total of options and Destination and deliver charges is "+sum);
		  if(totalmsrp2==sum)
		  {
			test.log(LogStatus.PASS, "Total MSRP is sum of Base MSRP,total of options and destination and delivery charges");
		  }
		  else
		  {
			test.log(LogStatus.FAIL, "Total MSRP is not sum of Base MSRP,total of options and destination and delivery charges");  
		  }
		  String diffmsrp=PGO_PaymentCalculator.leasediffermsrp(driver).getText();
		  String diffmsrp1=libs.getNumfrmString(diffmsrp);
		  int diffmsrp2=libs.stringToInt(diffmsrp1);
		  test.log(LogStatus.INFO,"Difference from Total MSRP is "+diffmsrp2);
		  String dealprice=PGO_PaymentCalculator.leasedealerprice(driver).getText();
		  String dealprice1=libs.getNumfrmString(dealprice);
		  int dealprice2=libs.stringToInt(dealprice1);
		  test.log(LogStatus.INFO,"Dealer Selling Price is "+dealprice2);
		  int diff=totalmsrp2-dealprice2;
		  if(diffmsrp2==diff)
		  {
			 test.log(LogStatus.PASS,"Difference from total MSRP is difference between Total MSRP and dealer selling price");
		  }
		  else
		  {
			 test.log(LogStatus.FAIL,"Difference from total MSRP is not the difference between Total MSRP and dealer selling price");
		  }
		  String esttaxx=PGO_PaymentCalculator.leaseestimatedTax(driver).getText();
		  String esttaxx1=libs.getNumfrmString(esttaxx);
		  int esttaxx2=libs.stringToInt(esttaxx1);
		  test.log(LogStatus.INFO,"Estimated Tax "+esttaxx2);
		  String titfee=PGO_PaymentCalculator.leasetitleFee(driver).getText();
		  String titfee1=libs.getNumfrmString(titfee);
		  int titfee2=libs.stringToInt(titfee1);
		  test.log(LogStatus.INFO,"Title Fee "+titfee2);
		  String docfee=PGO_PaymentCalculator.leasedocumentationFee(driver).getText();
		  String docfee1=libs.getNumfrmString(docfee);
		  int docfee2=libs.stringToInt(docfee1);
		  test.log(LogStatus.INFO,"Documentation Fee "+docfee2);
		  String acfee=PGO_PaymentCalculator.leaseacquiFee(driver).getText();
		  String acfee1=libs.getNumfrmString(acfee);
		  int acfee2=libs.stringToInt(acfee1);
		  test.log(LogStatus.INFO,"Acquisition Fee "+acfee2);
		  String totfee=PGO_PaymentCalculator.leasetotalTax(driver).getText();
		  String totfee1=libs.getNumfrmString(totfee);
		  int totfee2=libs.stringToInt(totfee1);
		  test.log(LogStatus.INFO,"Total Fees "+totfee2);
		  if(totfee2==esttaxx2+titfee2+docfee2+acfee2)
		  {
			 test.log(LogStatus.PASS,"Estimated taxes & Fees Total is sum of Estimated tax,title fee and documentation fee");
		  }
		  else
		  {
			 test.log(LogStatus.FAIL,"Estimated taxes & Fees Total is not sum of Estimated tax,title fee and documentation fee");  
		  }
		 
	  }
	  public void leaseVerification(int dRw) throws Exception
	  {
//		    String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
			String scrnshtPthNm=scrnshtPth+"Payment section failed"+libs.timestamp()+".jpg";
		    test.log(LogStatus.INFO,PGO_PaymentCalculator.leasepreestimatedTax(driver).getText());
			test.log(LogStatus.PASS, "Preestimated tax verified successfully" );
			test.log(LogStatus.INFO,PGO_PaymentCalculator.leasedealerSellingPrice(driver).getText());
			test.log(LogStatus.PASS, "Dealer selling price verified successfully" );
			String downval=PGO_PaymentCalculator.leasedownPaymentTextbox(driver).getAttribute("value");
			int downval1=libs.stringToInt(downval);
			test.log(LogStatus.INFO,"Value in down payment text box "+downval1);
			String dealerprice=PGO_PaymentCalculator.leasedealerSellingPrice(driver).getText();
			String dealerprice1=libs.getNumfrmString(dealerprice);
			int dealerprice3=libs.stringToInt(dealerprice1);
			test.log(LogStatus.INFO,"Dealer selling price - "+dealerprice3);
			int downval2=((dealerprice3*10)/100);
			if(downval1==downval2)
			  {
				test.log(LogStatus.PASS, "Downpayment value is 10% of dealer selling price" );
			  }
			  else
			  {
				 test.log(LogStatus.FAIL, "Downpayment value is not 10% of dealer selling price",test.addScreenCapture(scrnshtPthNm) );  
			  }
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).clear();
			String a=data.getStrExcelData(1,61,3);
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).sendKeys(a);
			String val=PGO_PaymentCalculator.leasedownPaymentTextbox(driver).getAttribute("value");
			test.log(LogStatus.PASS, "Down payment text box accepts numeric values" );
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).clear();
			String b=data.getStrExcelData(1,62,3);
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).sendKeys(b);
			String val1=PGO_PaymentCalculator.leasedownPaymentTextbox(driver).getAttribute("value");
			action.moveToElement(PGO_PaymentCalculator.leasedreIcon(driver)).build().perform();
			libs.waitToClick(driver,PGO_PaymentCalculator.leasedreIcon(driver),300);
			String val2=PGO_PaymentCalculator.leasedownPaymentTextbox(driver).getAttribute("value");
			if(val2.equals(a))
			{
			test.log(LogStatus.PASS, "Down payment text box does not accept negative values" );
			}
			else
			{
			test.log(LogStatus.FAIL, "Down payment text box accepts negative values" );
			}
			test.log(LogStatus.INFO,PGO_PaymentCalculator.leasekellyTradein(driver).getText());
			test.log(LogStatus.PASS, "Kelly blue book TradeIn verified successfully" );
			String c=PGO_PaymentCalculator.leasekellyTradeinValue(driver).getText();
			if(c.equals("$0"))
			{
		      test.log(LogStatus.PASS, "TradeIn skipped - Kelly blue book Trade In value is $0 - verified successfully" );	
			}
			else
			{
			  test.log(LogStatus.PASS, "Trade in evaluation is completed, not skipped and verified successfully" );	
			}
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).clear();
			String d=data.getStrExcelData(1,63,3);
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).sendKeys(d);
			String va=PGO_PaymentCalculator.leasedownPaymentTextbox(driver).getAttribute("value");
			Boolean dis=PGO_PaymentCalculator.leasebalanceTradein(driver).isEnabled();
			test.log(LogStatus.INFO,"Remaining balance on Tradein is enabled -  "+dis);
			if(dis==false)
			{
				test.log(LogStatus.PASS, "Tradein skipped,so Remaining balance trade in text box is disabled" );	
			}
			else
			{
				test.log(LogStatus.PASS, "Tradein evaluation is completed,so Remaining balance trade in text box is enabled" );
				PGO_PaymentCalculator.leasebalanceTradein(driver).clear();
				String p=data.getStrExcelData(1,81,3);
				PGO_PaymentCalculator.leasebalanceTradein(driver).sendKeys(p);
				action.moveToElement(PGO_PaymentCalculator.dreicon1(driver)).build().perform();
			    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon1(driver),300);
				String v1=PGO_PaymentCalculator.leasebalanceTradein(driver).getAttribute("value");
				String v2=data.getStrExcelData(1,82,3);
				if(v1.equals(v2))
				{
				 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept negative values" );
				}
				else
				{
				 test.log(LogStatus.FAIL, "Remaining balance trade in text box accepts negative values" );
				}
				PGO_PaymentCalculator.leasebalanceTradein(driver).clear();
				String q=data.getStrExcelData(1,83,3);
				PGO_PaymentCalculator.leasebalanceTradein(driver).sendKeys(q);
				action.moveToElement(PGO_PaymentCalculator.dreicon(driver)).build().perform();
			    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon(driver),300);
				String v3=PGO_PaymentCalculator.leasebalanceTradein(driver).getAttribute("value");
				String v4=data.getStrExcelData(1,84,3);
				if(v3.equals(v4))
				{
				 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept alphabets" );
				}
				else
				{
				 test.log(LogStatus.FAIL, "Remaining balance trade in text box does accepts alphabets" );
				}
				PGO_PaymentCalculator.leasebalanceTradein(driver).clear();
				String r=data.getStrExcelData(1,85,3);
				PGO_PaymentCalculator.leasebalanceTradein(driver).sendKeys(r);
				action.moveToElement(PGO_PaymentCalculator.dreicon1(driver)).build().perform();
			    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon1(driver),300);
				String v5=PGO_PaymentCalculator.leasebalanceTradein(driver).getAttribute("value");
				String v6=data.getStrExcelData(1,86,3);
				if(v5.equals(v6))
				{
				 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept decimal values" );
				}
				else
				{
				 test.log(LogStatus.FAIL, "Remaining balance trade in text box does accepts decimal values" );
				}
				PGO_PaymentCalculator.leasebalanceTradein(driver).clear();
				String ex=data.getStrExcelData(1,87,3);
				PGO_PaymentCalculator.leasebalanceTradein(driver).sendKeys(ex);
				action.moveToElement(PGO_PaymentCalculator.dreicon(driver)).build().perform();
			    libs.waitToClick(driver,PGO_PaymentCalculator.dreicon(driver),300);
				String p5=PGO_PaymentCalculator.leasebalanceTradein(driver).getAttribute("value");
				String p6=data.getStrExcelData(1,84,3);
				if(p5.equals(p6))
				{
				 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept special characters" );
				}
				else
				{
				 test.log(LogStatus.FAIL, "Remaining balance trade in text box accepts special characters" );
				}
			}
			action.moveToElement(PGO_PaymentCalculator.leasedreIcon1(driver)).build().perform();
			libs.waitToClick(driver,PGO_PaymentCalculator.leasedreIcon1(driver),300);
			String va2=PGO_PaymentCalculator.leasedownPaymentTextbox(driver).getAttribute("value");
			if(va2.equals("0"))
			{
			test.log(LogStatus.PASS, "Down payment text box does not allow alpha numeric values" );
			}
			else
			{
			test.log(LogStatus.FAIL, "Down payment text box allows alpha numeric values" );	
			}
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).clear();
			String e=data.getStrExcelData(1,64,3);
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).sendKeys(e);
			action.moveToElement(PGO_PaymentCalculator.editButton(driver)).build().perform();
			libs.waitToClick(driver,PGO_PaymentCalculator.editButton(driver),300);
			test.log(LogStatus.PASS, "Clicking on edit button,application navigated to TradeIn page successfully" );
			libs.waitToClick(driver,PGO_PaymentCalculator.paymentTabs(driver),300);
			test.log(LogStatus.PASS, "Clicking on Payment tab,application navigates back to Payment tab successfully" );
			String vaa1=PGO_PaymentCalculator.leasedownPaymentTextbox(driver).getAttribute("value");
			String vaa2=data.getStrExcelData(1,65,3);
			if(vaa1.equals(vaa2))
			{
				test.log(LogStatus.PASS, "Downpayment text box does not allow decimal values" );
			}
			else
			{
				test.log(LogStatus.FAIL, "Downpayment text allows decimal values" );
			}
			test.log(LogStatus.INFO,PGO_PaymentCalculator.leaseestimatedAdCapAmount(driver).getText());
			test.log(LogStatus.PASS, "Estimated Adjusted Capitalized Cost is verified successfully" );
			test.log(LogStatus.INFO,PGO_PaymentCalculator.leaseestimatedMonthlyPayment(driver).getText());
			test.log(LogStatus.PASS, "Estimated Monthly Payment is verified successfully" );
			test.log(LogStatus.INFO,PGO_PaymentCalculator.leaseTerm(driver).getText());
			test.log(LogStatus.PASS, "Term for lease is verified successfully" );
			test.log(LogStatus.INFO,PGO_PaymentCalculator.estimatedAmtSign(driver).getText());
			test.log(LogStatus.PASS, "Estimated Amount Due at Signing is verified successfully" );
			test.log(LogStatus.INFO,PGO_PaymentCalculator.leaseAnnualMileage(driver).getText());
			test.log(LogStatus.PASS, "Annual Mileage is verified successfully" );
			PGO_PaymentCalculator.leasedownPaymentTextbox(driver).sendKeys(downval);
			PGO_PaymentCalculator.leasebalanceTradein(driver).clear();
	  }
	        public void leasecreditBox(int dRw) throws Exception
	        {
//	          String scrnshtPth = data.getStrExcelData(dRw, 4, 3);	
	          String scrnshtPthNm=scrnshtPth+"Payment section failed"+libs.timestamp1()+".jpg";
	          String acthea=PGO_PaymentCalculator.leasestep2Heading(driver).getText();
	          test.log(LogStatus.INFO, "Actual Heading is "+acthea);
	  		  String exphea=data.getStrExcelData(dRw,59,3);
	  		  libs.assertionHandling(acthea, exphea, test,driver,scrnshtPthNm);
	  		  test.log(LogStatus.PASS, "Downpayment - Step2 title is verified" );	
			  WebElement list=PGO_PaymentCalculator.annualMileage(driver);
			  Select select=new Select(list);
			  test.log(LogStatus.INFO, "First selected option in Annual Mileage list box - " +select.getFirstSelectedOption());
			  test.log(LogStatus.PASS, "Annual Mileage is a list box and default value is verified successfully" );
			  test.log(LogStatus.INFO,"Credit box details before changing Annual Mileage");
			  int e=PGO_PaymentCalculator.creditBoxes(driver).size();
				for(int i=0;i<e;i++)
				{
				 test.log(LogStatus.INFO,PGO_PaymentCalculator.creditBoxes(driver).get(i).getText());
				 }
			  test.log(LogStatus.PASS, "Credit box details before changing Annual Mileage is verified successfully" );
		  	  String v=data.getStrExcelData(1,66, 3);
			  select.selectByVisibleText(v);
			  test.log(LogStatus.PASS, "Annual Mileage is selected from the list successfully" );
			  List<WebElement> allOptions = select.getOptions();
			  test.log(LogStatus.INFO,"List of options available in Annual Mileage List Box");
			  for(WebElement w:allOptions)
			  {
				test.log(LogStatus.INFO, w.getText());
			  }
			test.log(LogStatus.PASS, "List of all options available verified successfully" );
			test.log(LogStatus.INFO,"Credit Box details after changing Annual Mileage");
			int f=PGO_PaymentCalculator.creditBoxes(driver).size();
			for(int i=0;i<f;i++)
			{
			  test.log(LogStatus.INFO, PGO_PaymentCalculator.creditBoxes(driver).get(i).getText());
			 }
			test.log(LogStatus.PASS, "Credit box details are verified successfully" );
			  }
	        public void leaseFooter(int dRw) throws Exception
	        {
//	        	String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
	        	String scrnshtPthNm=scrnshtPth+"Payment section failed"+libs.timestamp1()+".jpg";
	        	try
	        	{
	        	test.log(LogStatus.INFO,PGO_PaymentCalculator.leaseFooter1(driver).getText());
	        	test.log(LogStatus.PASS, "Your Estimated Pre Tax price is verified successfully" );
	        	test.log(LogStatus.INFO,PGO_PaymentCalculator.leaseFooter2(driver).getText());
	        	test.log(LogStatus.PASS, "Estimated Adjusted Capitalized cost verified successfully" );
	        	test.log(LogStatus.INFO,PGO_PaymentCalculator.leaseFooter3(driver).getText());
	        	test.log(LogStatus.PASS, "Your lease payment verified successfully" );
			  	String distext=PGO_PaymentCalculator.leasedisclaimerFooter(driver).getText();
				test.log(LogStatus.INFO,"Disclaimer - "+distext);
				String exptext=data.getStrExcelData(dRw, 60, 3);
				libs.assertionHandling(distext, exptext, test, driver, scrnshtPthNm);
				System.out.println(" 'Payment tab' testcase is passed.");
			    data.writeToExcel("Passed", dRw, 5, 3);
				test.log(LogStatus.PASS,"'Payment tab' testcase is passed.") ;
	        	}
	        	catch(Exception leaseFooter)
	        	 {
	      		  Count++;
				  getscrnSht.getscreenshot(driver, scrnshtPth+"leaseFooterFailed_"+libs.timestamp1()+".jpg");
				  test.log(LogStatus.FAIL, leaseFooter.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"leaseFooter_Failed_"+libs.timestamp1()+".jpg") ));
				}
	        }

	  public void cashPaymentVerification(int dRw) throws Exception
	  {
		  try
		  {
//		  String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
		  String scrnshtPthNm=scrnshtPth+"Cash Payment Verification failed"+".jpg";
		  String expoption=data.getStrExcelData(dRw, 3, 3);
		  libs.VerifyText(PGO_PaymentCalculator.option(driver), expoption, "Cash Payment Option","");
		  String exppaytext=data.getStrExcelData(dRw,57,3);
		  libs.VerifyText(PGO_PaymentCalculator.cashpaymentInlinetext(driver), exppaytext, "Cash Payment Inline Text","");
		  }
		  catch(Exception cashPaymentVerification)
		  {
			  Count++;
			  String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
			  getscrnSht.getscreenshot(driver, scrnshtPth+"paymentIntro_Failed_"+libs.timestamp()+".jpg");
			  test.log(LogStatus.FAIL, cashPaymentVerification.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"cashPaymentVerification_Failed_"+".jpg") ));
			}
	  }
	  public void pricingSummary(int dRw) throws Exception
	  {
          //String scrnshtPth = data.getStrExcelData(dRw, 8, 5);
          String scrnshtPthNm=scrnshtPth+"Cash Payment pricing summary failed"+".jpg";
		  try
		  {
		  PGO_PaymentCalculator.cashDreIcon(driver).click();
		  test.log(LogStatus.PASS, "Total MSRP dre icon clicked and expanded successfully" );
		  int a=PGO_PaymentCalculator.priceElements(driver, dRw).size();
		  for(int i=0;i<a;i++)
		  {
			String text=PGO_PaymentCalculator.priceElements(driver, dRw).get(i).getText();
			data.writeToExcel(text, dRw, 43+i, 3);
		  }
		  for(int i=0;i<8;i++)
			{
				String text=data.getStrExcelData(dRw, 43+i, 3);
				System.out.println(text);
				String text1=data.getStrExcelData(dRw, 12+i, 9);
				System.out.println(text1);
				if(text.equals(text1))
				{
					test.log(LogStatus.PASS,"Pricevalues in Payment tab is same as Vehicle details tab");	
				}
				else
				{
					test.log(LogStatus.FAIL,"Pricevalues in Payment tab is not same as Vehicle details tab",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
				}
			}
		  test.log(LogStatus.PASS, "Pricing summary elements are verified and printed in excel successfully" );
		  }
		  catch(Exception pricingSummary)
		  {
			  Count++;
				getscrnSht.getscreenshot(driver, scrnshtPth+"pricingSummary_Failed_"+libs.timestamp()+".jpg");
				test.log(LogStatus.FAIL, pricingSummary.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"pricingSummary_"+".jpg") ));
			}
		  
	  }
	  public void paymentCal(int dRw) throws Exception
	  {
//		  String scrnshtPth = data.getStrExcelData(dRw, 8, 5);
		  String scrnshtPthNm=scrnshtPth+"Payment section failed_"+libs.timestamp1()+".jpg";
		  try
		  {
		  String totalmsrp=PGO_PaymentCalculator.cashtotalMSRP(driver).getText();
		  String totalmsrp1=libs.getNumfrmString(totalmsrp);
		  int totalmsrp2=libs.stringToInt(totalmsrp1);
		  test.log(LogStatus.INFO, "Total MSRP - "+totalmsrp2 );
		  String basemsrp=PGO_PaymentCalculator.cashbaseMSRP(driver).getText();
		  String basemsrp1=libs.getNumfrmString(basemsrp);
		  int basemsrp2=libs.stringToInt(basemsrp1);
		  test.log(LogStatus.INFO, "Base MSRP - "+basemsrp2 );
		  String totaloptions=PGO_PaymentCalculator.cashtotalOptions(driver).getText();
		  String totaloptions1=libs.getNumfrmString(totaloptions);
		  int totaloptions2=libs.stringToInt(totaloptions1);
		  test.log(LogStatus.INFO, "Total of options - "+totaloptions2 );
		  String descharg=PGO_PaymentCalculator.cashdestdelcharges(driver).getText();
		  String descharg1=libs.getNumfrmString(descharg);
		  int descharg2=libs.stringToInt(descharg1);
		  test.log(LogStatus.INFO, "Destination and delivery charges - "+descharg2 );
		  int sum=basemsrp2+totaloptions2+descharg2;
		  test.log(LogStatus.INFO,"Sum of Base MSRP, Total of options and destination and delivery charges is "+sum );
		  if(totalmsrp2==sum)
		   {
			test.log(LogStatus.PASS, "Total MSRP is sum of Base MSRP,total of options and destination and delivery charges");
		  }
		  else
		  {
			  getscrnSht.getscreenshot(driver,scrnshtPthNm);
			test.log(LogStatus.FAIL, "Total MSRP is not sum of Base MSRP,total of options and destination and delivery charges",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
		  }
		  String diffmsrp=PGO_PaymentCalculator.cashdiffermsrp(driver).getText();
		  String diffmsrp1=libs.getNumfrmString(diffmsrp);
		  int diffmsrp2=libs.stringToInt(diffmsrp1);
		  test.log(LogStatus.INFO,"Difference from Total MSRP - "+diffmsrp2 );
		  System.out.println(diffmsrp2);
		  String dealprice=PGO_PaymentCalculator.cashdealerprice(driver).getText();
		  String dealprice1=libs.getNumfrmString(dealprice);
		  int dealprice2=libs.stringToInt(dealprice1);
		  test.log(LogStatus.INFO,"Dealer selling price - "+dealprice2 );
		  int diff=totalmsrp2-dealprice2;
		  System.out.println(diff);
		  test.log(LogStatus.INFO,"Difference between total MSRP and dealer selling price  "+diff );
		  if(diffmsrp2==diff)
		  {
			test.log(LogStatus.PASS,"Difference from total MSRP is difference between Total MSRP and dealer selling price");
			System.out.println("tot pass");
		  }
		  else
		  {
			 test.log(LogStatus.FAIL,"Difference from total MSRP is not the difference between Total MSRP and dealer selling price",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			 System.out.println("tot fail");
		  }
		  String esttaxx=PGO_PaymentCalculator.cashEstimatedPrice(driver).getText();
		  String esttaxx1=libs.getNumfrmString(esttaxx);
		  int esttaxx2=libs.stringToInt(esttaxx1);
		  test.log(LogStatus.INFO,"Estimated pre tax price - "+esttaxx2 );
		  Boolean a=PGO_PaymentCalculator.cashAvalbalance(driver).isDisplayed();
		  if(a==true)
		  {
		  String avlbal=PGO_PaymentCalculator.cashAvalbalance(driver).getText();
		  String avlbal1=libs.getNumfrmString(avlbal);
		  int avlbal2=libs.stringToInt(avlbal1);
		  test.log(LogStatus.INFO,"Available Incentives - "+avlbal2);
		  int taxprice=dealprice2-avlbal2;
		  test.log(LogStatus.INFO,"Difference between Dealer selling price and Available incentives - "+taxprice);
			  if(esttaxx2==taxprice)
			  {
				test.log(LogStatus.PASS,"Estimated pre tax price is difference between dealer selling price and available incentives");
			  }
			  else
			  {
				  getscrnSht.getscreenshot(driver,scrnshtPthNm);
			    test.log(LogStatus.FAIL,"Estimated pre tax price is not the difference between dealer selling price and available incentives",test.addScreenCapture(Screenpathforreport(scrnshtPthNm))); 
			  }
		  }
		  else
		  {
		  int taxprice=dealprice2;
		  if(esttaxx2==taxprice)
		  {
			 test.log(LogStatus.PASS,"There is no available incentives, so Dealer selling price is equal to estimated pre tax price");
		  }
		  else
		  {
			  getscrnSht.getscreenshot(driver,scrnshtPthNm);
		     test.log(LogStatus.FAIL,"There is no available incentives but Dealer selling price is not equal to estimated pre tax price",test.addScreenCapture(Screenpathforreport(scrnshtPthNm))); 
		  }
		  }
		  String kelly=PGO_PaymentCalculator.cashkellyblue(driver).getText();
		  String kelly1=libs.getNumfrmString(kelly);
		  int kelly2=libs.stringToInt(kelly1);
		  test.log(LogStatus.INFO,"Kelly blue book trade in value - "+kelly2);
		  if(kelly2==0)
		  {
	       test.log(LogStatus.PASS, "TradeIn skipped - Kelly blue book Trade In value is $0 - verified successfully" );	
		  }
		  else
		{
		   test.log(LogStatus.PASS, "Trade in evaluation is completed, not skipped and verified successfully" );
		   String text=data.getStrExcelData(dRw, 51, 3);
		   String text3=data.getStrExcelData(dRw, 13, 6);
		   if(text.equals(text3))
		   {
			   test.log(LogStatus.PASS,"Kelly blue book trade in value in payment tab is same as Tradein module"); 
		   }
		   else
		   {
			   getscrnSht.getscreenshot(driver,scrnshtPthNm);
			   test.log(LogStatus.FAIL,"Kelly blue book trade in value in payment tab is not same as Tradein module",test.addScreenCapture(Screenpathforreport(scrnshtPthNm))); 
		   }
		}
		  String netamt=PGO_PaymentCalculator.cashtradein(driver).getText();
		  String netamt1=libs.getNumfrmString(netamt);
		  int netamt2=libs.stringToInt(netamt1);
		  test.log(LogStatus.INFO,"Estimated net trade in amount - "+netamt2);
          if(PGO_PaymentCalculator.cashrembal(driver).getAttribute("value").isEmpty())
		  {
			test.log(LogStatus.PASS, "Remaining balance on trade-In blank");
			String text=data.getStrExcelData(dRw, 51, 3);
			String text1=libs.getNumfrmString(text);
			int text2=libs.stringToInt(text1);
			int differ=text2;
			if(differ>esttaxx2)
			{
			 if(netamt2==0)
			 {
				 test.log(LogStatus.PASS,"Estimated net tradein amount is greater than Estimated Pretax price, so the value set to zero");
				 Boolean disp=PGO_PaymentCalculator.cashAlertIcon(driver).isDisplayed();
				  if(disp==true)
				  {
					test.log(LogStatus.INFO,"You appear to owe more than the value of your trade-in.");
				    PGO_PaymentCalculator.cashAlertIcon(driver).click();
				    test.log(LogStatus.PASS,"Alert next to Estimated net tradein clicked successfully");
				    test.log(LogStatus.INFO,"Heading part of the Alert"+" "+PGO_PaymentCalculator.cashalertHeading(driver).getText());
				    test.log(LogStatus.INFO,"Alert Message"+" "+PGO_PaymentCalculator.cashalertText(driver).getText());
				    PGO_PaymentCalculator.cashalertClose(driver).click();
				    test.log(LogStatus.PASS,"Alert closed successfully");
				  }
				  else
				  {
					  getscrnSht.getscreenshot(driver,scrnshtPthNm);
					  test.log(LogStatus.FAIL,"You owe more than the value of your trade-in but alert is not displayed",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
				  }
			 }
			 else
			 {
				 getscrnSht.getscreenshot(driver,scrnshtPthNm);
				 test.log(LogStatus.FAIL,"Estimated net tradein amount is greater than Estimated Pretax price, but value is not set to zero",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			 }
			}
			else
			{
				if(netamt2==differ)
				{
					test.log(LogStatus.PASS,"Estimated net tradein amount is difference between Kelly blue book value and Remaining balance on trade in");
				}
				else
				{
					getscrnSht.getscreenshot(driver,scrnshtPthNm);
					test.log(LogStatus.FAIL,"Estimated net tradein amount is not the difference between Kelly blue book value and Remaining balance on trade in",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
				}
			}
		  }
		  else
		  {
			  getscrnSht.getscreenshot(driver,scrnshtPthNm);
			  test.log(LogStatus.FAIL, "User added a trade-in but Remaining balance on trade-In is not blank and editable",test.addScreenCapture(Screenpathforreport(scrnshtPthNm))); 
		  }
		  String estc=PGO_PaymentCalculator.cashestimatedcash(driver).getText();
		  String estc1=libs.getNumfrmString(estc);
		  int estc2=libs.stringToInt(estc1);
		  test.log(LogStatus.INFO,"Estimated cash due at dealer - "+estc2);
		  int di=esttaxx2-netamt2;
		  test.log(LogStatus.INFO,"Estimated pre tax price minus estimated net trade in amount -"+di);
		  if(estc2==di)
		  {
			  test.log(LogStatus.PASS,"Estimated cash due at dealer comprised of Estimated pre tax price minus estimated net trade in amount");  
		  }
		  else
		  {
			  getscrnSht.getscreenshot(driver,scrnshtPthNm);
			  test.log(LogStatus.FAIL,"Estimated cash due at dealer not comprised of Estimated pre tax price minus estimated net trade in amount",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));  
		  }
		  jse.executeScript("arguments[0].scrollIntoView(true)",PGO_PaymentCalculator.cashDreIcon1(driver));
		  action.moveToElement(PGO_PaymentCalculator.cashDreIcon1(driver)).build().perform();
		  libs.waitToClick(driver,PGO_PaymentCalculator.cashDreIcon1(driver),400);
		  test.log(LogStatus.PASS, "Arrow next to Total MSRP clicked back and collapsed successfully" );
	  }
		  catch(Exception paymentCal)
		  {
			  Count++;
				getscrnSht.getscreenshot(driver, scrnshtPth+"paymentCal_Failed_"+libs.timestamp1()+".jpg");
				test.log(LogStatus.FAIL, paymentCal.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"paymentCal"+libs.timestamp()+".jpg")));
			}  
	  }
	  //Cash payment mode verification
	  public void verification(int dRw) throws Exception
	  {
		  String scrnshtPth = data.getStrExcelData(dRw, 8, 5);
		  try
		  {
		  Boolean dis=PGO_PaymentCalculator.cashrembal(driver).isEnabled();
		  test.log(LogStatus.INFO,"Remaining balance Tradein amount is enabled - "+dis);
		  if(dis==false)
			{
			 test.log(LogStatus.PASS, "Tradein skipped,so Remaining balance trade in text box is disabled" );
			 String rembalance="$0";
			 data.writeToExcel(rembalance, dRw, 52, 3);
			}
			else
			{
				test.log(LogStatus.PASS, "Tradein evaluation is completed,so Remaining balance trade in text box is enabled" );
				PGO_PaymentCalculator.cashrembal(driver).clear();
				String p=data.getStrExcelData(dRw,81,3);
				PGO_PaymentCalculator.cashrembal(driver).sendKeys(p);
				action.moveToElement(PGO_PaymentCalculator.cashDreIcon(driver)).build().perform();
			    libs.waitToClick(driver,PGO_PaymentCalculator.cashDreIcon(driver),300);
				String v1=PGO_PaymentCalculator.cashrembal(driver).getAttribute("value");
				String v2=data.getStrExcelData(dRw,82,3);
				data.writeToExcel(v1, dRw, 52, 3);
				System.out.println("written");
				if(v1.equals(v2))
				{
				 test.log(LogStatus.PASS, "Remaining balance trade in text box does not accept negative values" );
				}
				else
				{
					
				 test.log(LogStatus.FAIL, "Remaining balance trade in text box accepts negative values" );
				}
				
				  
			}	  
				  
				
		  jse.executeScript("arguments[0].scrollIntoView(true)",PGO_PaymentCalculator.editButton(driver));
		  action.moveToElement(PGO_PaymentCalculator.editButton(driver)).build().perform();
		  libs.waitToClick(driver,PGO_PaymentCalculator.editButton(driver),300);
		  test.log(LogStatus.PASS, "Clicking on edit button,application navigated to TradeIn page successfully" );
		  Thread.sleep(5000);
		  libs.waitToClick(driver,PGO_PaymentCalculator.paymentTabs(driver),300);
		  test.log(LogStatus.PASS, "Clicking on Payment tab,application navigates back to Payment tab successfully" );
		  String netamt=PGO_PaymentCalculator.cashtradein(driver).getText();
		  data.writeToExcel(netamt, dRw, 53, 3);
			System.out.println(netamt);
		  test.log(LogStatus.INFO,"Estimated net trade in amount - "+netamt);
		  String estc=PGO_PaymentCalculator.cashestimatedcash(driver).getText();
		    System.out.println(estc);
		  data.writeToExcel(estc, dRw, 54, 3);
			test.log(LogStatus.INFO,"Estimated cash due at dealer - "+estc);
		  }
		  catch(Exception verification)
		  {
			  Count++;
				getscrnSht.getscreenshot(driver, scrnshtPth+"verification_Failed_"+".jpg");
				test.log(LogStatus.FAIL, verification.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"verification"+".jpg")));
	  }
	  }
	  
	  public void footerVerification(int dRw) throws Exception
	  {
//		  String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
		  String scrnshtPthNm=scrnshtPth+"Payment section failed"+libs.timestamp1()+".jpg";
		  try
		  {
		  test.log(LogStatus.INFO,PGO_PaymentCalculator.footer1(driver).getText());
		  test.log(LogStatus.INFO,PGO_PaymentCalculator.footer2(driver).getText());
		  PGO_PaymentCalculator.footer4(driver).click();
		  test.log(LogStatus.PASS, "Estimated cash due at dealer dre icon in footer is clicked successfully" );
		  PGO_PaymentCalculator.footer5(driver).click();
		  test.log(LogStatus.PASS, "Total MSRP dre icon clicked successfully" );
		  String actdisclaimer=PGO_PaymentCalculator.disclaimerFooter(driver).getText();
		  test.log(LogStatus.INFO,"Actual disclaimer - "+actdisclaimer );
		  String expdisclaimer=data.getStrExcelData(1,60,3);
		  libs.assertionHandling(actdisclaimer, expdisclaimer, test, driver, scrnshtPthNm);
		  test.log(LogStatus.PASS, "Disclaimer below is verified successfully" );
		  System.out.println(" 'Payment tab' testcase is passed.");
		  data.writeToExcel("Passed", dRw, 5, 3);
		  test.log(LogStatus.PASS,"'Payment tab' testcase is passed.") ;
		  }
		  catch(Exception footerVerification)
		  {
			  Count++;
				getscrnSht.getscreenshot(driver, scrnshtPth+"footerVerification_Failed_"+libs.timestamp()+".jpg");
				test.log(LogStatus.FAIL, footerVerification.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPth +"footerVerification_"+libs.timestamp()+".jpg") ));
			}
	  }
	 
	}

