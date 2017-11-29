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
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilityClasses.*;
public class creditForm extends rsg_DriverClass{
//	WebDriver driver = getDriver();
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	ExcelUtilityClass data = new ExcelUtilityClass();
//	ScreenShot getscrnSht = new ScreenShot();
//	ExtentReports report;
//	ExtentTest test;
	WebDriverWait wait = new WebDriverWait(driver,10);
	FuncitonLibrary libs = new FuncitonLibrary();
	Actions actions = new Actions(driver);
	JavascriptExecutor jse=(JavascriptExecutor) driver;	
	creditApp creditApp=new creditApp();
	int drw1;
	public void  creditForm_run(int dRw) throws Exception
	{
		try
		{
		String runVal = data.getExcelData(dRw,"ApplyCreDit", "reviewAndSend");
		System.out.println(runVal);
			switch(runVal){
			case "Yes":
				invokeReport("Verify Credit Form ",dRw);
				if(ValidationStatus.equalsIgnoreCase("Yes")){
				applyfrCredit(dRw);
				creditApp(dRw);
				click_continue(dRw);
				creditReview(dRw);
				creditApp.creditAppDealSubmition(dRw);
				tearReport();
				}
				else
				{
					applyfrCredit(dRw);
					maincreditApp(dRw);
					tearReport();
					
				}
				break;
			case "No":
				System.out.println("'creditForm' testcase is not executed.");
				data.writeToExcel("Not Executed", dRw, 23, 4);
				break;
			}
		}
		catch(Exception e)
		 {
			  Count++;
			tearReport();
		}
	}

	public void applyfrCredit(int dRw) throws Exception
	{
		String scrnshtPthNm=scrnshtPth+"applyfrCredit"+libs.timestamp1()+".jpg";
		try
		{	
			//libs.clickOnButton(PGO_reviewAndSend.btn_applyForCredit(driver), "Apply for credit & send to dealer");
		
			try{
			//f(PGO_reviewAndSend.btn_applyForCredit(driver).isDisplayed()){
				//actions.moveToElement(PGO_reviewAndSend.btn_applyForCredit(driver)).doubleClick().build().perform();
//				libs.clickOnButton(PGO_reviewAndSend.btn_applyForCredit(driver), "Apply for credit & send to dealer");
			
			
			
			}catch(Exception creditapp){
				System.out.println("apply for credit already clicked");
			}
			test.log(LogStatus.PASS, "Click on 'Apply for credit & send to dealer' button ", "Apply for credit button has been  clicked ");
//			Thread.sleep(3000);
		}
		catch(Exception applyfrCredit)
		 {
			Count++;
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL, applyfrCredit.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		}
	}
	
	public void creditApp(int dRw) throws Exception
		{
			//String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
			String scrnshtPthNm=scrnshtPth+"creditApp"+libs.timestamp1()+".jpg";
			try
			{
			Boolean dis=PGO_creditForm.overlayImg(driver).isDisplayed();
			System.out.println(dis);
			if(dis==true)
			{
			test.log(LogStatus.PASS, "Ford Image is displayed in Credit Apply overlay");
			}
			else
			{
			 getscrnSht.getscreenshot(driver, scrnshtPthNm);
			 test.log(LogStatus.FAIL, "Ford Image is not displayed in Credit Apply overlay",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
			String acth=PGO_creditForm.overlayHeading(driver).getText();
			String exph=data.getStrExcelData(dRw, 29, 4);
			libs.assertionHandling(acth, exph, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS, "Overlay Heading is verified successfully" );
			String actt=PGO_creditForm.overlayText(driver).getText();
			String expt=data.getStrExcelData(dRw,30, 4);
			libs.assertionHandling(actt, expt, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS, "Overlay Text is verified successfully" );
			String poption=data.getStrExcelData(dRw,3, 3);
			test.log(LogStatus.INFO,"Payment option selected"+" "+poption);
			if(poption.equals("Cash"))
			{
				String actapphead=PGO_creditForm.payHead(driver).getText();
				test.log(LogStatus.INFO,actapphead);
				 int s=PGO_creditForm.payOptions(driver).size();
				 for(int i=0;i<s;i++)
				 {
					test.log(LogStatus.INFO,PGO_creditForm.payOptions(driver).get(i).getText());
				 }
				 String actahead=PGO_creditForm.aHead(driver).getText();
				 test.log(LogStatus.INFO,actahead);
				 int q=PGO_creditForm.aOptions(driver).size();
				 for(int i=0;i<q;i++)
				 {
					test.log(LogStatus.INFO,PGO_creditForm.aOptions(driver).get(i).getText());
				 }
				}
				else
			{
					String actapphead=PGO_creditForm.appHead(driver).getText();
					test.log(LogStatus.INFO,actapphead);
					 int s=PGO_creditForm.appOptions(driver).size();
					 for(int i=0;i<s;i++)
					 {
						test.log(LogStatus.INFO,PGO_creditForm.appOptions(driver).get(i).getText()); 
					 }
			}
			if(poption.equals("Cash"))
				{
				 String pType = data.getStrExcelData(dRw, 31,4);
				  int s=PGO_creditForm.payOptions(driver).size();
				 for(int i=0;i<s;i++)
				 {
					String ptype1=PGO_creditForm.payOptions(driver).get(i).getText(); 
					if(ptype1.equals(pType))
					{
						PGO_creditForm.payOptions(driver).get(i).click();
						test.log(LogStatus.INFO,ptype1+"Payment selected and clicked successfully");
					}
					else
					{
						System.out.println("Choose Different option");
					}
					
				 }
				 String aType = data.getStrExcelData(dRw, 32, 4);
				  int q=PGO_creditForm.aOptions(driver).size();
				 for(int j=0;j<q;j++)
				 {
					String atype1=PGO_creditForm.aOptions(driver).get(j).getText(); 
					if(atype1.equals(aType))
					{
						PGO_creditForm.aOptions(driver).get(j).click();
						test.log(LogStatus.INFO,atype1+"Application type selected and clicked successfully");
					}
					else
					{
					  System.out.println("Choose Different option");
					}
				 }
				}
				else
				{
					String aType = data.getStrExcelData(dRw, 32, 4);
					 int q=PGO_creditForm.aOptions(driver).size();
					 for(int j=0;j<q;j++)
					 {
						String atype1=PGO_creditForm.aOptions(driver).get(j).getText(); 
						if(atype1.equals(aType))
						{
							PGO_creditForm.aOptions(driver).get(j).click();
							test.log(LogStatus.INFO,atype1+"Application type selected and clicked successfully");
						}
						else
						{
						  System.out.println("Choose Different option");
						}
				}
				}
			
		}catch(Exception option)
			 {
			  Count++;
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL, option.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		}
			
		}
	public void maincreditApp(int dRw) throws Exception
	{
		String scrnshtPthNm=scrnshtPth+"CreditForm"+libs.timestamp1()+".jpg";
		try {
		String poption=data.getExcelData(dRw,"Payment Type","PaymentCalculator");
		String ButtonName=data.getExcelData(dRw,"ApplicationType","CreditForm");
//		if(poption.equalsIgnoreCase("Cash")){
			libs.clickOnButton(PGO_creditForm.Btn_CreditapplicatonBuy(driver,ButtonName), ButtonName);
			test.log(LogStatus.PASS, "Click on '"+ButtonName+"' in credit application", ButtonName+" has been clicked");
//			Thread.sleep(2000);
			try{
			if(PGO_creditForm.Btn_CreditapplicatonBuy(driver,ButtonName).isDisplayed())
			{
			libs.clickOnButton(PGO_creditForm.Btn_CreditapplicatonBuy(driver,poption), poption);}
			test.log(LogStatus.PASS, "Click on '"+poption+"' in credit application", poption+" has been clicked");
		}catch(Exception e){
			
		}
//		{libs.clickOnButton(PGO_creditForm.Btn_Creditapplicaton(driver,ButtonName), ButtonName);
//		test.log(LogStatus.PASS, "Click on '"+ButtonName+"' in credit application", ButtonName+" has been clicked");
//			
//		}
		maincreditContactInfo(dRw);
		maincreditPersonalInfo(dRw);
		maincreditIncomeInfo(dRw);
		creditReview(dRw);
//		creditApp.creditAppDealSubmition(dRw);
//		
		
		
		
		
		
		
		
		
		}catch(Exception Creditapp){
			Count++;
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL, "isse in credit form",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		}
		
				//data.getStrExcelData(dRw,3, 3);
//		test.log(LogStatus.INFO,"Payment option selected"+" "+poption);
		if("Cash".equals("Cash"))
		{
			libs.waitToClick(driver, PGO_creditForm.buyOptions(driver),10);
			test.log(LogStatus.INFO,"Payment option clicked"+" "+PGO_creditForm.buyOptions(driver).getText());
			String aType = data.getStrExcelData(dRw, 32, 4);
			test.log(LogStatus.INFO,"Application type selected"+" "+aType);
			int q=PGO_creditForm.aOptions(driver).size();
			 for(int j=0;j<q;j++)
			 {
				String atype1=PGO_creditForm.aOptions(driver).get(j).getText(); 
				if(atype1.equals(aType))
				{
					PGO_creditForm.aOptions(driver).get(j).click();
					test.log(LogStatus.INFO,atype1+"Application type selected and clicked successfully");
					test.log(LogStatus.INFO, "To fill in the Credit Application details");
					maincreditContactInfo(dRw);
					maincreditPersonalInfo(dRw);
					maincreditIncomeInfo(dRw);
					creditReview(dRw);
				}
				else
				{
				  System.out.println("Choose Different option");
				}
			 }
			}
		else
		{
			System.out.println("Stsrts");
			String payment=data.getExcelData(dRw,"Result","PaymentCalculator");
			System.out.println(payment);
			if(payment.equals("Not Executed"))
			{
				Thread.sleep(5000);
				libs.waitToClick(driver, PGO_creditForm.buyOptions(driver),10);
				test.log(LogStatus.INFO,"Payment option clicked"+" "+PGO_creditForm.buyOptions(driver).getText());	
				String aType = data.getStrExcelData(dRw, 32, 4);
				System.out.println(aType);
				int q=PGO_creditForm.aOptions(driver).size();
				 for(int j=0;j<q;j++)
				 {
					String atype1=PGO_creditForm.aOptions(driver).get(j).getText(); 
					System.out.println(atype1);
					if(atype1.equals(aType))
					{
						Thread.sleep(5000);
						libs.waitToClick(driver, PGO_creditForm.aOptions(driver).get(j),10);
						test.log(LogStatus.INFO,atype1+"Application type selected and clicked successfully");
						maincreditContactInfo(dRw);
						maincreditPersonalInfo(dRw);
						maincreditIncomeInfo(dRw);
						creditReview(dRw);
			        }
					else
					{
					  System.out.println("Choose Different option");
					}
				 }
			}
			else
			{
			String aType = data.getStrExcelData(dRw, 32, 4);
			int q=PGO_creditForm.aOptions(driver).size();
			 for(int j=0;j<q;j++)
			 {
				String atype1=PGO_creditForm.aOptions(driver).get(j).getText(); 
				if(atype1.equals(aType))
				{
					PGO_creditForm.aOptions(driver).get(j).click();
					test.log(LogStatus.INFO,atype1+"Application type selected and clicked successfully");
					maincreditContactInfo(dRw);
					maincreditPersonalInfo(dRw);
					maincreditIncomeInfo(dRw);
					creditReview(dRw);
				}
				else
				{
				  System.out.println("Choose Different option");
				}
			 }
			}
		}
		
	}
	public void click_continue(int dRw) throws Exception
	{
		//String scrnshtPth = data.getStrExcelData(dRw, 1, 3);
		String scrnshtPthNm=scrnshtPth+"click_continue"+libs.timestamp1()+".jpg";
        try
        {
		PGO_creditForm.donotapply_button(driver).click();
		test.log(LogStatus.PASS,"Do not apply for credit button clicked successfully");
		String option=data.getStrExcelData(dRw, 110, 4);
		if(option.equals("Yes, don't apply."))
		{
	     PGO_creditForm.buttons1(driver).click();
	     test.log(LogStatus.PASS,"Yes, don't apply button clicked successfully");
	     applyfrCredit(dRw);
	     creditApp(dRw);
		}
		else if(option.equals("No. Submit my application."))
		{
		  PGO_creditForm.buttons2(driver).click();
		  test.log(LogStatus.PASS,"No Submit my application button clicked successfully");
		}
		else
		{
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL,"Option selected wrong",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));	
		}
		String text=data.getStrExcelData(dRw, 32, 4);
		if(text.equals("Individual"))
		{
			test.log(LogStatus.INFO,"Application type selected - Individual");
			creditContactInfo(dRw);
			actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
			libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
			creditPersonalInfo(dRw);
			actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
			libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
			creditIncomeInfo(dRw);
			actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
			libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
		}
		else
		{
			test.log(LogStatus.INFO,"Application type selected - Joint");
			creditContactInfo(dRw);
			jointcreditContactInfo(dRw);
			actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
			libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
			creditPersonalInfo(dRw);
			jointcreditPersonalInfo(dRw);
			actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
			libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
			creditIncomeInfo(dRw);
			jointcreditIncomeInfo(dRw);
			actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
			libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
			
		}
		}
		catch(Exception click_continue)
        {
			  Count++;
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL, click_continue.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		}
	}
	public void maincreditContactInfo(int dRw)throws Exception 
	{
		test.log(LogStatus.INFO,"Primary Applicant Details");
		String ccFirstName = data.getStrExcelData(dRw, 1, 4);
		String ccLastName = data.getStrExcelData(dRw, 2, 4);
		String ccStrAdd = data.getStrExcelData(dRw, 3, 4);
		String ccPriAppCity = data.getStrExcelData(dRw, 4, 4);
		String ccPriAppState = data.getStrExcelData(dRw, 5, 4);
		String ccPriAppZip = data.getStrExcelData(dRw, 6, 4);
		String ccPriAppPhone = data.getStrExcelData(dRw, 7, 4);
		String ccPriAppEmail = data.getStrExcelData(dRw, 8, 4);
		String ccPriAppEmailConfirm = data.getStrExcelData(dRw, 9, 4);
		PGO_creditForm.txt_priFirstName(driver).clear();
		PGO_creditForm.txt_priFirstName(driver).sendKeys(ccFirstName);
		PGO_creditForm.txt_priLastName(driver).clear();
		PGO_creditForm.txt_priLastName(driver).sendKeys(ccLastName);
		PGO_creditForm.txt_ccStrAdd(driver).clear();
		PGO_creditForm.txt_ccStrAdd(driver).sendKeys(ccStrAdd);
		PGO_creditForm.txt_ccPriAppCity(driver).clear();
		PGO_creditForm.txt_ccPriAppCity(driver).sendKeys(ccPriAppCity);
		PGO_creditForm.txt_ccPriAppState(driver).sendKeys(ccPriAppState);
		PGO_creditForm.txt_ccPriAppZip(driver).clear();
		PGO_creditForm.txt_ccPriAppZip(driver).sendKeys(ccPriAppZip);
		PGO_creditForm.txt_ccPriAppPhone(driver).clear();
		PGO_creditForm.txt_ccPriAppPhone(driver).sendKeys(ccPriAppPhone);
		PGO_creditForm.txt_ccPriAppEmail(driver).clear();
		PGO_creditForm.txt_ccPriAppEmail(driver).sendKeys(ccPriAppEmail );
		PGO_creditForm.txt_ccPriAppEmailConfirm(driver).clear();
		PGO_creditForm.txt_ccPriAppEmailConfirm(driver).sendKeys(ccPriAppEmailConfirm);
		test.log(LogStatus.PASS,"Primary Applicant Details are entered and captured successfully");
		actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
		libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
		test.log(LogStatus.PASS,"Continue button clicked successfully in Contact Info page");
	}
	public void creditContactInfo(int dRw)throws Exception 

	{
		//String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
		String scrnshtPthNm=scrnshtPth+"click_continue"+libs.timestamp1()+".jpg";
		String ccFirstName = data.getStrExcelData(dRw, 1, 4);
		String ccLastName = data.getStrExcelData(dRw, 2, 4);
		String ccStrAdd = data.getStrExcelData(dRw, 3, 4);
		String ccPriAppCity = data.getStrExcelData(dRw, 4, 4);
		String ccPriAppState = data.getStrExcelData(dRw, 5, 4);
		String ccPriAppZip = data.getStrExcelData(dRw, 6, 4);
		String ccPriAppPhone = data.getStrExcelData(dRw, 7, 4);
		String ccPriAppEmail = data.getStrExcelData(dRw, 8, 4);
		String ccPriAppEmailConfirm = data.getStrExcelData(dRw, 9, 4);
		//Ford credit contact information page
		try{
			
			int s=PGO_creditForm.infoOptions(driver).size();
			test.log(LogStatus.INFO,"Sections Available");
			 for(int i=0;i<s;i++)
			 {
				test.log(LogStatus.INFO,PGO_creditForm.infoOptions(driver).get(i).getText());
			 }
			Boolean dis=PGO_creditForm.infoOptions1(driver).isEnabled();
			if(dis==true)
			{
			  test.log(LogStatus.PASS,"Contact Information section is enabled");
			}
			else
			{
			 getscrnSht.getscreenshot(driver, scrnshtPthNm);	
			 test.log(LogStatus.FAIL,"Contact Information section is not enabled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
			String acthe=PGO_creditForm.papplicant(driver).getText(); 
			String exphe=data.getStrExcelData(dRw,33,4);
			libs.assertionHandling(acthe, exphe, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Primary applicant in Contact Information section verified successfully");
			Boolean disp=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
			if(disp==false)
			{
				test.log(LogStatus.PASS,"Continue button is not enabled as the primary applicant contact details are not completely filled");
			}
			else
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);	
				test.log(LogStatus.FAIL,"Continue button is enabled though the primary applicant contact details are not completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
			}
			PGO_creditForm.txt_priFirstName(driver).sendKeys(ccFirstName);
			PGO_creditForm.txt_priLastName(driver).sendKeys(ccLastName);
			PGO_creditForm.txt_ccStrAdd(driver).sendKeys(ccStrAdd);
			PGO_creditForm.txt_ccPriAppCity(driver).sendKeys(ccPriAppCity);
			PGO_creditForm.txt_ccPriAppState(driver).sendKeys(ccPriAppState);
			PGO_creditForm.txt_ccPriAppZip(driver).sendKeys(ccPriAppZip);
			PGO_creditForm.txt_ccPriAppPhone(driver).sendKeys(ccPriAppPhone);
			PGO_creditForm.txt_ccPriAppEmail(driver).sendKeys(ccPriAppEmail );
			PGO_creditForm.txt_ccPriAppEmailConfirm(driver).sendKeys(ccPriAppEmailConfirm);
			try
			{
			String text=data.getStrExcelData(dRw, 32, 4);
			if(text.equals("Individual"))
			{
			Boolean dis1=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
			if(dis1==false)
			{
				test.log(LogStatus.PASS,"Continue button enabled as the primary applicant contact details are completely filled");
			}
			else
			{	getscrnSht.getscreenshot(driver, scrnshtPthNm);
				test.log(LogStatus.FAIL,"Continue button not enabled though the primary applicant contact details are completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			}
			else
			{
				Boolean dis1=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dis1==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as joint applicant details are not filled");
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though the joint applicant details are not filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );				}
					}
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.txt_priFirstName(driver).clear();
				String val = data.getStrExcelData(dRw, 34+i, 4);
				PGO_creditForm.txt_priFirstName(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Firstname entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though First name enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.txt_priFirstName(driver).clear();
				PGO_creditForm.txt_priFirstName(driver).sendKeys(ccFirstName);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.txt_priLastName(driver).clear();
				String val = data.getStrExcelData(dRw, 34+i, 4);
				PGO_creditForm.txt_priLastName(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Lastname entered is invalid");
					
				}
				else
				{	getscrnSht.getscreenshot(driver, scrnshtPthNm);
					test.log(LogStatus.FAIL,"Continue button enabled though Lastname enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.txt_priLastName(driver).clear();
				PGO_creditForm.txt_priLastName(driver).sendKeys(ccLastName);
			}
			for(int i=0;i<1;i++)
			{
				PGO_creditForm.txt_ccStrAdd(driver).clear();
				String val = data.getStrExcelData(dRw, 39+i, 4);
				PGO_creditForm.txt_ccStrAdd(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as address entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though address enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.txt_ccStrAdd(driver).clear();
				PGO_creditForm.txt_ccStrAdd(driver).sendKeys(ccStrAdd);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.txt_ccPriAppCity(driver).clear();
				String val = data.getStrExcelData(dRw, 40+i, 4);
				PGO_creditForm.txt_ccPriAppCity(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as city entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though city enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.txt_ccPriAppCity(driver).clear();
				PGO_creditForm.txt_ccPriAppCity(driver).sendKeys(ccPriAppCity);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.txt_ccPriAppZip(driver).clear();
				String val = data.getStrExcelData(dRw, 43+i, 4);
				PGO_creditForm.txt_ccPriAppZip(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as zipcode entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though zipcode enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.txt_ccPriAppZip(driver).clear();
				PGO_creditForm.txt_ccPriAppZip(driver).sendKeys(ccPriAppZip);
			}
			for(int i=0;i<5;i++)
			{
				PGO_creditForm.txt_ccPriAppPhone(driver).clear();
				String val = data.getStrExcelData(dRw, 46+i, 4);
				PGO_creditForm.txt_ccPriAppPhone(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Phonenumber entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though Phonenumber enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.txt_ccPriAppPhone(driver).clear();
				PGO_creditForm.txt_ccPriAppPhone(driver).sendKeys(ccPriAppPhone);
			}
			for(int i=0;i<5;i++)
			{
				PGO_creditForm.txt_ccPriAppEmail(driver).clear();
				String val = data.getStrExcelData(dRw, 51+i, 4);
				PGO_creditForm.txt_ccPriAppEmail(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as email entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though email enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.txt_ccPriAppEmail(driver).clear();
				PGO_creditForm.txt_ccPriAppEmail(driver).sendKeys(ccPriAppEmail);
			}
			for(int i=0;i<6;i++)
			{
				PGO_creditForm.txt_ccPriAppEmailConfirm(driver).clear();
				String val = data.getStrExcelData(dRw, 51+i, 4);
				PGO_creditForm.txt_ccPriAppEmailConfirm(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as confirmation email entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though confirmation email enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccPriAppEmailConfirm(driver).clear();
				PGO_creditForm.txt_ccPriAppEmailConfirm(driver).sendKeys(ccPriAppEmailConfirm);
				Select select=new Select(PGO_creditForm.txt_ccPriAppState(driver));
				List<WebElement> allOptions = select.getOptions();
				test.log(LogStatus.INFO,"List of options available in State");
				  for(WebElement w:allOptions)
				  {
					test.log(LogStatus.INFO, w.getText());
				  }
				  
			
			}catch(Exception creditContactInfoException)
		 {
				  Count++;
				getscrnSht.getscreenshot(driver, scrnshtPthNm);
				test.log(LogStatus.FAIL, creditContactInfoException.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
				
			}
	}
	public void jointcreditContactInfo(int dRw)throws Exception 

	{
		String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
		String scrnshtPthNm=scrnshtPth+"Credit form failed"+libs.timestamp1()+".jpg";
		String ccFirstName = data.getStrExcelData(dRw, 57, 4);
		String ccLastName = data.getStrExcelData(dRw, 58, 4);
		String ccStrAdd = data.getStrExcelData(dRw, 59, 4);
		String ccPriAppCity = data.getStrExcelData(dRw, 60, 4);
		String ccPriAppState = data.getStrExcelData(dRw, 61, 4);
		String ccPriAppZip = data.getStrExcelData(dRw, 62, 4);
		String ccPriAppPhone = data.getStrExcelData(dRw, 63, 4);
		String ccPriAppEmail = data.getStrExcelData(dRw, 64, 4);
		String ccPriAppEmailConfirm = data.getStrExcelData(dRw, 65, 4);
		String ccPriApprelation = data.getStrExcelData(dRw, 66, 4);
		
		try{
			String acthe=PGO_creditForm.jointAppHeading(driver).getText(); 
			System.out.println(acthe);
			String exphe=data.getStrExcelData(dRw,67,4);
			libs.assertionHandling(acthe, exphe, test,driver,scrnshtPthNm);
			System.out.println("Joint Applicant in Contact Information section verified");
			Boolean disp=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
			if(disp==false)
			{
				test.log(LogStatus.PASS,"Continue button is not enabled as the Joint applicant contact details are not completely filled");
			}
			else
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);	
				test.log(LogStatus.FAIL,"Continue button is enabled though the Joint applicant contact details are not completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_creditForm.joint_txt_Firstname(driver));
			PGO_creditForm.joint_txt_Firstname(driver).sendKeys(ccFirstName);
			PGO_creditForm.joint_txt_Lastname(driver).sendKeys(ccLastName);
			PGO_creditForm.joint_txt_Streetaddress(driver).sendKeys(ccStrAdd);
			PGO_creditForm.joint_txt_city(driver).sendKeys(ccPriAppCity);
			PGO_creditForm.jointState(driver).sendKeys(ccPriAppState);
			PGO_creditForm.joint_txt_zipcode(driver).sendKeys(ccPriAppZip);
			PGO_creditForm.joint_txt_phone(driver).sendKeys(ccPriAppPhone);
			PGO_creditForm.joint_txt_email(driver).sendKeys(ccPriAppEmail );
			PGO_creditForm.joint_txt_emailconfirm(driver).sendKeys(ccPriAppEmailConfirm);
			Thread.sleep(2000);
		if(ccPriApprelation.equals("Other"))
			{
				actions.moveToElement(PGO_creditForm.jointRelation(driver)).build().perform();
				PGO_creditForm.jointRelation(driver).sendKeys(ccPriApprelation);
				for(int i=0;i<3;i++)
				{	
					PGO_creditForm.Others(driver).clear();
					String val = data.getStrExcelData(dRw, 102+i, 4);
					actions.moveToElement(PGO_creditForm.Others(driver)).build().perform();
					PGO_creditForm.Others(driver).sendKeys(val);
					Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
					System.out.println(dispp3);
					if(dispp3==false)
					{
						test.log(LogStatus.PASS,"Continue button not enabled as others details of relationship to primary applicant entered is invalid");
						
					}
					else
					{
						getscrnSht.getscreenshot(driver, scrnshtPthNm);	
						test.log(LogStatus.FAIL,"Continue button enabled though others details of relationship to primary applicant enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					}	
				}
				    PGO_creditForm.Others(driver).clear();
					actions.moveToElement(PGO_creditForm.Others(driver)).build().perform();
					String othersval = data.getStrExcelData(dRw, 109, 4);
					PGO_creditForm.Others(driver).sendKeys(othersval);
			}
				else
				{
					actions.moveToElement(PGO_creditForm.jointRelation(driver)).build().perform();
					PGO_creditForm.jointRelation(driver).sendKeys(ccPriApprelation);
				}
		
		
			
			Boolean dis1=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
			if(dis1==false)
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);	
				test.log(LogStatus.FAIL,"Continue button not enabled though Joint applicant contact details are completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			else
			{
				test.log(LogStatus.PASS,"Continue button enabled as the Joint applicant contact details are completely filled");
			}
			
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.joint_txt_Firstname(driver).clear();
				String val = data.getStrExcelData(dRw, 34+i, 4);
				PGO_creditForm.joint_txt_Firstname(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Firstname entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though First name enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_Firstname(driver).clear();
				PGO_creditForm.joint_txt_Firstname(driver).sendKeys(ccFirstName);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.joint_txt_Lastname(driver).clear();
				String val = data.getStrExcelData(dRw, 34+i, 4);
				PGO_creditForm.joint_txt_Lastname(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Lastname entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though Lastname enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_Lastname(driver).clear();
				PGO_creditForm.joint_txt_Lastname(driver).sendKeys(ccLastName);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.joint_txt_Streetaddress(driver).clear();
				String val = data.getStrExcelData(dRw, 37+i, 4);
				PGO_creditForm.joint_txt_Streetaddress(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as address entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);
					test.log(LogStatus.FAIL,"Continue button enabled though address enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_Streetaddress(driver).clear();
				PGO_creditForm.joint_txt_Streetaddress(driver).sendKeys(ccStrAdd);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.joint_txt_city(driver).clear();
				String val = data.getStrExcelData(dRw, 40+i, 4);
				PGO_creditForm.joint_txt_city(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as city entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);
					test.log(LogStatus.FAIL,"Continue button enabled though city enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_city(driver).clear();
				PGO_creditForm.joint_txt_city(driver).sendKeys(ccPriAppCity);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.joint_txt_zipcode(driver).clear();
				String val = data.getStrExcelData(dRw, 43+i, 4);
				PGO_creditForm.joint_txt_zipcode(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as zipcode entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though zipcode enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_zipcode(driver).clear();
				PGO_creditForm.joint_txt_zipcode(driver).sendKeys(ccPriAppZip);
			}
			for(int i=0;i<5;i++)
			{
				PGO_creditForm.joint_txt_phone(driver).clear();
				String val = data.getStrExcelData(dRw, 46+i, 4);
				PGO_creditForm.joint_txt_phone(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Phonenumber entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though Phonenumber enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_phone(driver).clear();
				PGO_creditForm.joint_txt_phone(driver).sendKeys(ccPriAppPhone);
			}
			for(int i=0;i<5;i++)
			{
				PGO_creditForm.joint_txt_email(driver).clear();
				String val = data.getStrExcelData(dRw, 51+i, 4);
				PGO_creditForm.joint_txt_email(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as email entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);
					test.log(LogStatus.FAIL,"Continue button enabled though email enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_email(driver).clear();
				PGO_creditForm.joint_txt_email(driver).sendKeys(ccPriAppEmail);
			}
			for(int i=0;i<6;i++)
			{
				PGO_creditForm.joint_txt_emailconfirm(driver).clear();
				String val = data.getStrExcelData(dRw, 51+i, 4);
				PGO_creditForm.joint_txt_emailconfirm(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as confirmation email entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though confirmation email enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.joint_txt_emailconfirm(driver).clear();
				PGO_creditForm.joint_txt_emailconfirm(driver).sendKeys(ccPriAppEmailConfirm);
			
			Select select=new Select(PGO_creditForm.jointRelation(driver));
			List<WebElement> allOptions = select.getOptions();
			test.log(LogStatus.INFO,"List of options available in Relationship to Primary Applicant");
			  for(WebElement w:allOptions)
			  {
				test.log(LogStatus.INFO, w.getText());
			  }
			  }
			catch(Exception creditContactInfoException)
		 {
				  Count++;
				getscrnSht.getscreenshot(driver, scrnshtPthNm);
				test.log(LogStatus.FAIL, creditContactInfoException.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
				
			}
	}
	public void maincreditPersonalInfo(int dRw) throws Exception
	{
		test.log(LogStatus.INFO,"Personal info section loads successfully");
		String ccDob = data.getStrExcelData(dRw, 10, 4);
		String ccSsn = data.getStrExcelData(dRw, 11, 4);
		String ccResSt = data.getStrExcelData(dRw, 12, 4);
		String ccResYr = data.getStrExcelData(dRw, 13, 4);
		String ccResMths = data.getStrExcelData(dRw, 14, 4);
		PGO_creditForm.txt_ccDob(driver).clear();
		PGO_creditForm.txt_ccDob(driver).sendKeys(ccDob);
		PGO_creditForm.txt_ccSsn(driver).clear();
		PGO_creditForm.txt_ccSsn(driver).sendKeys(ccSsn);
		PGO_creditForm.txt_ccResSt(driver).sendKeys(ccResSt);
		PGO_creditForm.txt_ccResYr(driver).clear();
		PGO_creditForm.txt_ccResYr(driver).sendKeys(ccResYr);
		PGO_creditForm.txt_ccResMths(driver).clear();
		PGO_creditForm.txt_ccResMths(driver).sendKeys(ccResMths);
		test.log(LogStatus.PASS,"Personal info entered and captured successfully");
		actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
		libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
		test.log(LogStatus.PASS,"Continue button clicked successfully in Personal Info section");
	}
	
	public void creditPersonalInfo(int dRw)throws Exception 
	{
		String ccDob = data.getStrExcelData(dRw, 10, 4);
		String ccSsn = data.getStrExcelData(dRw, 11, 4);
		String ccResSt = data.getStrExcelData(dRw, 12, 4);
		String ccResYr = data.getStrExcelData(dRw, 13, 4);
		String ccResMths = data.getStrExcelData(dRw, 14, 4);
		//String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
		String scrnshtPthNm=scrnshtPth+"Creditform tab failed"+libs.timestamp1()+".jpg";
		try
		{
		// Credit form Personal information
			Boolean dis=PGO_creditForm.infoOptions2(driver).isEnabled();
			System.out.println(dis);
			if(dis==true)
			{
			  test.log(LogStatus.PASS,"Personal Information section is enabled");
			}
			else
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);
			  test.log(LogStatus.FAIL,"Personal Information section is not enabled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			Boolean disp=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
			System.out.println(disp);
			if(disp==true)
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);	
			    test.log(LogStatus.FAIL, "Continue button enabled though primary applicant Personal contact details are not completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			 }
			else
			{
			    test.log(LogStatus.PASS, "Continue button not enabled as Primary applicant Personal contact details are not completely filled");	
			}
			PGO_creditForm.txt_ccDob(driver).sendKeys(ccDob);
			PGO_creditForm.txt_ccSsn(driver).sendKeys(ccSsn);
			PGO_creditForm.txt_ccResYr(driver).sendKeys(ccResYr);
			PGO_creditForm.txt_ccResMths(driver).sendKeys(ccResMths);
			if(ccResSt.trim().contains("Owns home outright"))
			{
				PGO_creditForm.txt_ccResSt(driver).sendKeys(ccResSt);	
				System.out.println("Keys sent");
			}
			else
			{
				PGO_creditForm.txt_ccResSt(driver).sendKeys(ccResSt);
				for(int i=0;i<3;i++)
				{
					PGO_creditForm.monthlyMortgage(driver).clear();
					String val = data.getStrExcelData(dRw, 105+i, 4);
					PGO_creditForm.monthlyMortgage(driver).sendKeys(val);
					Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
					if(dispp3==false)
					{
						test.log(LogStatus.PASS, "Continue button not enabled as Monthly Mortgage or Rent entered is invalid");
					
					}
					else
					{
						getscrnSht.getscreenshot(driver, scrnshtPthNm);	
						test.log(LogStatus.FAIL, "Continue button enabled though Monthly Mortgage or Rent enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					}	
			}
				PGO_creditForm.monthlyMortgage(driver).clear();
				String ccmomrent=data.getStrExcelData(dRw, 108, 4);
				PGO_creditForm.monthlyMortgage(driver).sendKeys(ccmomrent);
			}
				System.out.println("Credit PERSONAL INFORMATION CAPTURED");
				String text=data.getStrExcelData(dRw, 32, 4);
				System.out.println(text);
				if(text.equals("Individual"))
				{
				Boolean dis1=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dis1==true)
				{
					test.log(LogStatus.PASS,"Continue button enabled as the primary applicant personal details are completely filled");
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button not enabled though the primary personal contact details are completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
				}
				}
				else
				{
					Boolean dis1=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
					if(dis1==false)
					{
						test.log(LogStatus.PASS,"Continue button not enabled as joint applicant personal details are not filled");
					}
					else
					{
						getscrnSht.getscreenshot(driver, scrnshtPthNm);	
						test.log(LogStatus.FAIL,"Continue button enabled though the joint applicant personal details are not filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					}
						}
			for(int i=0;i<7;i++)
			{
				PGO_creditForm.txt_ccDob(driver).clear();
				String val = data.getStrExcelData(dRw, 68+i, 4);
				PGO_creditForm.txt_ccDob(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS, "Continue button not enabled as Date of birth entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "Continue button enabled though Date of birth enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				
			
				PGO_creditForm.txt_ccDob(driver).clear();
				PGO_creditForm.txt_ccDob(driver).sendKeys(ccDob);
			
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.txt_ccSsn(driver).clear();
				String val = data.getStrExcelData(dRw, 76+i, 4);
				PGO_creditForm.txt_ccSsn(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS, "Continue button not enabled as social security number entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "Continue button enabled though social security number enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccSsn(driver).clear();
				PGO_creditForm.txt_ccSsn(driver).sendKeys(ccSsn);
			
			
			for(int i=0;i<4;i++)
			{
				PGO_creditForm.txt_ccResYr(driver).clear();
				String val = data.getStrExcelData(dRw, 79+i, 4);
				PGO_creditForm.txt_ccResYr(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS, "Continue button not enabled as Year entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "Continue button enabled though Year entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccResYr(driver).clear();
				PGO_creditForm.txt_ccResYr(driver).sendKeys(ccResYr);
			
			for(int i=0;i<5;i++)
			{
				PGO_creditForm.txt_ccResMths(driver).clear();
				String val = data.getStrExcelData(dRw, 79+i, 4);
				PGO_creditForm.txt_ccResMths(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS, "Continue button not enabled as Month entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "Continue button enabled though Month entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccResMths(driver).clear();
				PGO_creditForm.txt_ccResMths(driver).sendKeys(ccResMths);
			
			
			
			
		}catch(Exception creditPersonalInfoException)
		 {
			  Count++;
			
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL, creditPersonalInfoException.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
	}
	public void jointcreditPersonalInfo(int dRw)throws Exception 
	{
		String ccDob = data.getStrExcelData(dRw, 84, 4);
		String ccSsn = data.getStrExcelData(dRw, 85, 4);
		String ccResSt = data.getStrExcelData(dRw, 86, 4);
		String ccResYr = data.getStrExcelData(dRw, 87, 4);
		String ccResMths = data.getStrExcelData(dRw, 88, 4);
		String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
		String scrnshtPthNm=scrnshtPth+"Creditform tab failed"+libs.timestamp1()+".jpg";
		try
		{
			Boolean disp=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
			System.out.println(disp);
			if(disp==true)
			{
			  test.log(LogStatus.PASS, "Continue button enabled though Joint applicant Personal details are not completely filled");
			 }
			else
			{
			  getscrnSht.getscreenshot(driver, scrnshtPthNm);	
			  test.log(LogStatus.FAIL, "Continue button not enabled as Joint applicant Personal details are not completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );	
			}
			PGO_creditForm.joint_txt_ccDob(driver).sendKeys(ccDob);
			PGO_creditForm.joint_txt_ccSsn(driver).sendKeys(ccSsn);
			PGO_creditForm.joint_txt_ccResYr(driver).sendKeys(ccResYr);
			PGO_creditForm.joint_txt_ccResMths(driver).sendKeys(ccResMths);
			if(ccResSt.equals("Owns home outright"))
			{
				PGO_creditForm.joint_txt_ccResSt(driver).sendKeys(ccResSt);	
			}
			else
			{
				PGO_creditForm.joint_txt_ccResSt(driver).sendKeys(ccResSt);
				for(int i=0;i<3;i++)
				{
					PGO_creditForm.jointmonthlyMortgage(driver).clear();
					String val = data.getStrExcelData(dRw, 105+i, 4);
					PGO_creditForm.jointmonthlyMortgage(driver).sendKeys(val);
					Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
					if(dispp3==false)
					{
						test.log(LogStatus.PASS, "Continue button not enabled as Monthly Mortgage or Rent entered is invalid");
					
					}
					else
					{
						getscrnSht.getscreenshot(driver, scrnshtPthNm);	
						test.log(LogStatus.FAIL, "Continue button enabled though Monthly Mortgage or Rent enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					}	
			}
				PGO_creditForm.jointmonthlyMortgage(driver).clear();
				String ccmomrent=data.getStrExcelData(dRw, 108, 4);
				PGO_creditForm.jointmonthlyMortgage(driver).sendKeys(ccmomrent);
			System.out.println("Credit PERSONAL INFORMATION CAPTURED");
			Boolean disp1=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
			if(disp1==true)
			     {
				   test.log(LogStatus.PASS, "Continue button enabled as Joint applicant personal details are completely filled");
				 }
				else
				{
				   getscrnSht.getscreenshot(driver, scrnshtPthNm);	
				   test.log(LogStatus.FAIL, "Continue button not enabled though the Joint applicant personal details are completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );	
				}
			for(int i=0;i<8;i++)
			{
				PGO_creditForm.joint_txt_ccDob(driver).clear();
				String val = data.getStrExcelData(dRw, 68+i, 4);
				PGO_creditForm.joint_txt_ccDob(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS, "Continue button not enabled as Date of birth entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "Continue button enabled though Date of birth enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_ccDob(driver).clear();
				String val1 = data.getStrExcelData(dRw, 74, 4);
				PGO_creditForm.joint_txt_ccDob(driver).sendKeys(val1);
				Boolean dispalert=PGO_creditForm.dobAlert(driver).isDisplayed();
				if(dispalert==true)
				{
					
					test.log(LogStatus.PASS, "You are not eligible to apply for credit as have not reached the age of majority in your state or conform to state legal requirements to apply error message displayed.");
					PGO_creditForm.dobAlert(driver).click();
					test.log(LogStatus.INFO,PGO_creditForm.dobAlertText(driver).getText());
					PGO_creditForm.dobAlertClose(driver).click();
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "You are not eligible to apply for credit as have not reached the age of majority in your state or conform to state legal requirements to apply error message not displayed",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
				}
				PGO_creditForm.joint_txt_ccDob(driver).clear();
				PGO_creditForm.joint_txt_ccDob(driver).sendKeys(ccDob);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.joint_txt_ccSsn(driver).clear();
				String val = data.getStrExcelData(dRw, 76+i, 4);
				PGO_creditForm.joint_txt_ccSsn(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS, "Continue button not enabled as social security number entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "Continue button enabled though social security number enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_ccSsn(driver).clear();
				PGO_creditForm.joint_txt_ccSsn(driver).sendKeys(ccSsn);
			}
			for(int i=0;i<3;i++)
			{
				PGO_creditForm.joint_txt_ccResYr(driver).clear();
				String val = data.getStrExcelData(dRw, 79+i, 4);
				PGO_creditForm.joint_txt_ccResYr(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS, "Continue button not enabled as Year entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "Continue button enabled though Year entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_ccResYr(driver).clear();
				PGO_creditForm.joint_txt_ccResYr(driver).sendKeys(ccResYr);
			}
			for(int i=0;i<4;i++)
			{
				PGO_creditForm.joint_txt_ccResMths(driver).clear();
				String val = data.getStrExcelData(dRw, 79+i, 4);
				PGO_creditForm.joint_txt_ccResMths(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS, "Continue button not enabled as Month entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL, "Continue button enabled though Month entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
				PGO_creditForm.joint_txt_ccResMths(driver).clear();
				PGO_creditForm.joint_txt_ccResMths(driver).sendKeys(ccResMths);
			}
			}
			
			
		}catch(Exception creditPersonalInfoException)
		 {
			  Count++;
			
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL,creditPersonalInfoException.getMessage(),test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		}
	}
    public void maincreditIncomeInfo(int dRw) throws Exception
    {
    	test.log(LogStatus.INFO,"Income & Employment status section loads successfully");
    	String ccEmpSts = data.getStrExcelData(dRw, 15, 4);
		String ccEmployer = data.getStrExcelData(dRw, 16, 4);
		String ccOccu = data.getStrExcelData(dRw, 17, 4);
		String ccEmpYrs = data.getStrExcelData(dRw, 18, 4);
		String ccEmpMths = data.getStrExcelData(dRw, 19, 4);
		String ccWrkPhone = data.getStrExcelData(dRw, 20, 4);
		String ccGrossIncome = data.getStrExcelData(dRw, 21, 4);
		PGO_creditForm.txt_ccEmpSts(driver).sendKeys(ccEmpSts);
		PGO_creditForm.txt_ccEmployer(driver).sendKeys(ccEmployer);
		PGO_creditForm.txt_ccOccu(driver).sendKeys(ccOccu);
		PGO_creditForm.txt_ccEmpYrs(driver).sendKeys(ccEmpYrs);
		PGO_creditForm.txt_ccEmpMths(driver).sendKeys(ccEmpMths);
		PGO_creditForm.txt_ccWrkPhone(driver).sendKeys(ccWrkPhone);
		PGO_creditForm.txt_ccGrossIncome(driver).sendKeys(ccGrossIncome);
		test.log(LogStatus.PASS,"Income & Employment information entered and captured successfully");
		actions.moveToElement(PGO_creditForm.btn_creditContactBtn(driver)).build().perform();
		libs.waitToClick(driver, PGO_creditForm.btn_creditContactBtn(driver), 40);
		test.log(LogStatus.PASS,"Continue button clicked successfully in Income & Employment section");
    }
	//Income and employment
	public void creditIncomeInfo(int dRw)throws Exception {
		String ccEmpSts = data.getStrExcelData(dRw, 15, 4);
		String ccEmployer = data.getStrExcelData(dRw, 16, 4);
		String ccOccu = data.getStrExcelData(dRw, 17, 4);
		String ccEmpYrs = data.getStrExcelData(dRw, 18, 4);
		String ccEmpMths = data.getStrExcelData(dRw, 19, 4);
		String ccWrkPhone = data.getStrExcelData(dRw, 20, 4);
		String ccGrossIncome = data.getStrExcelData(dRw, 21, 4);
		
		String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
		String scrnshtPthNm=scrnshtPth+"Creditform tab failed"+libs.timestamp1()+".jpg";
		try{
			System.out.println("Fields available in Income & Employment Section");
			test.log(LogStatus.INFO,"Fields available in Income & Employment Section");
			int a=PGO_creditForm.emplymentLabels(driver).size();
			for(int i=0;i<a;i++)
			{
				test.log(LogStatus.INFO,PGO_creditForm.emplymentLabels(driver).get(i).getText());
			}
			int b=PGO_creditForm.emplymentLabels1(driver).size();
			for(int i=0;i<b;i++)
			{
				test.log(LogStatus.INFO,PGO_creditForm.emplymentLabels1(driver).get(i).getText());
			}
			Select select=new Select(PGO_creditForm.jobType(driver));
			List<WebElement> allOptions = select.getOptions();
			  test.log(LogStatus.INFO,"List of options available in Employee Status List Box");
			  for(WebElement w:allOptions)
			  {
				test.log(LogStatus.INFO, w.getText());
			  }
			Boolean condis=  PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
			if(condis==false)
			{
			    test.log(LogStatus.PASS,"Continue button not enabled as the Income and Employment details are not completely filled");
			}
			else
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);	
			    test.log(LogStatus.FAIL,"Continue button enabled though Income and Employment details are not completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			PGO_creditForm.txt_ccEmpSts(driver).sendKeys(ccEmpSts);
			PGO_creditForm.txt_ccEmployer(driver).sendKeys(ccEmployer);
			PGO_creditForm.txt_ccOccu(driver).sendKeys(ccOccu);
			PGO_creditForm.txt_ccEmpYrs(driver).sendKeys(ccEmpYrs);
			PGO_creditForm.txt_ccEmpMths(driver).sendKeys(ccEmpMths);
			Thread.sleep(1000);
			PGO_creditForm.txt_ccWrkPhone(driver).sendKeys(ccWrkPhone);
			PGO_creditForm.txt_ccGrossIncome(driver).sendKeys(ccGrossIncome);
			test.log(LogStatus.INFO,"Credit Income and employment Information captured");
			String text=data.getStrExcelData(dRw, 32, 4);
			if(text.equals("Individual"))
			{
			Boolean dis1=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
			if(dis1==true)
			{
				test.log(LogStatus.PASS,"Continue button enabled as the primary applicant Income & Employment details are completely filled");
			}
			else
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);	
				test.log(LogStatus.FAIL,"Continue button not enabled though the primary applicant Income & Employment details are completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			}
			else
			{
				Boolean dis1=PGO_creditForm.btn_creditContactBtn(driver).isEnabled();
				if(dis1==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as joint applicant Income & Employment details are not filled");
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though the joint applicant Income & Employment details are not filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
				}
					}
			for(int i=0;i<3;i++)
			{
				PGO_creditForm.txt_ccEmployer(driver).clear();
				String val = data.getStrExcelData(dRw, 89+i, 4);
				PGO_creditForm.txt_ccEmployer(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as employer details entered is invalid");
				
				}
				else
				{
					System.out.println("Failed");
//					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
//					test.log(LogStatus.FAIL,"Continue button enabled though employer details enetered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccEmployer(driver).clear();
				PGO_creditForm.txt_ccEmployer(driver).sendKeys(ccEmployer);
			
			for(int i=0;i<3;i++)
			{
				PGO_creditForm.txt_ccOccu(driver).clear();
				String val = data.getStrExcelData(dRw, 92+i, 4);
				PGO_creditForm.txt_ccOccu(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as occupation entered is invalid");
				
				}
				else
				{
					System.out.println("Failed");
//					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
//					test.log(LogStatus.FAIL,"Continue button enabled though occupation entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccOccu(driver).clear();
				PGO_creditForm.txt_ccOccu(driver).sendKeys(ccOccu);
			
			for(int i=0;i<3;i++)
			{
				PGO_creditForm.txt_ccEmpYrs(driver).clear();
				String val = data.getStrExcelData(dRw, 79+i, 4);
				PGO_creditForm.txt_ccEmpYrs(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Year entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though Year entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccEmpYrs(driver).clear();
				PGO_creditForm.txt_ccEmpYrs(driver).sendKeys(ccEmpYrs);
			
			for(int i=0;i<4;i++)
			{
				PGO_creditForm.txt_ccEmpMths(driver).clear();
				String val = data.getStrExcelData(dRw, 79+i, 4);
				PGO_creditForm.txt_ccEmpMths(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Month entered is invalid");
				
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though Month entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccEmpMths(driver).clear();
				PGO_creditForm.txt_ccEmpMths(driver).sendKeys(ccEmpMths);
			
			for(int i=0;i<5;i++)
			{
				PGO_creditForm.txt_ccWrkPhone(driver).clear();
				String val = data.getStrExcelData(dRw, 46+i, 4);
				PGO_creditForm.txt_ccWrkPhone(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Phonenumber entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though Phonenumber entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
					
				}
			}
				PGO_creditForm.txt_ccWrkPhone(driver).clear();
				PGO_creditForm.txt_ccWrkPhone(driver).sendKeys(ccWrkPhone);
			
			for(int i=0;i<3;i++)
			{
				PGO_creditForm.txt_ccGrossIncome(driver).clear();
				String val = data.getStrExcelData(dRw, 34+i, 4);
				PGO_creditForm.txt_ccGrossIncome(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					test.log(LogStatus.PASS,"Continue button not enabled as Gross Income entered is invalid");
					
				}
				else
				{
					getscrnSht.getscreenshot(driver, scrnshtPthNm);	
					test.log(LogStatus.FAIL,"Continue button enabled though Gross Income entered is invalid",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
				}
			}
				PGO_creditForm.txt_ccGrossIncome(driver).clear();
				PGO_creditForm.txt_ccGrossIncome(driver).sendKeys(ccGrossIncome);
			}
			
		
		catch(Exception creditIncomeInfoException)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL, creditIncomeInfoException.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
	}
	public void jointcreditIncomeInfo(int dRw)throws Exception {
		String ccEmpSts = data.getStrExcelData(dRw, 95, 4);
		String ccEmployer = data.getStrExcelData(dRw, 96, 4);
		String ccOccu = data.getStrExcelData(dRw, 97, 4);
		String ccEmpYrs = data.getStrExcelData(dRw, 98, 4);
		String ccEmpMths = data.getStrExcelData(dRw, 99, 4);
		String ccWrkPhone = data.getStrExcelData(dRw, 100, 4);
		String ccGrossIncome = data.getStrExcelData(dRw, 101, 4);
		String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
		String scrnshtPthNm=scrnshtPth+"Creditform tab failed"+libs.timestamp1()+".jpg";
		try{
			
			Boolean condis=  PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
			if(condis==true)
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);	
			    test.log(LogStatus.FAIL,"Continue button enabled though the Income and Employment details are not completely filled");
			}
			else
			{
				test.log(LogStatus.PASS,"Continue button not enabled as Income and Employment details are not completely filled",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			PGO_creditForm.joint_txt_ccEmpSts(driver).sendKeys(ccEmpSts);
			PGO_creditForm.joint_txt_ccEmployer(driver).sendKeys(ccEmployer);
			PGO_creditForm.joint_txt_ccOccu(driver).sendKeys(ccOccu);
			PGO_creditForm.joint_txt_ccEmpYrs(driver).sendKeys(ccEmpYrs);
			PGO_creditForm.joint_txt_ccEmpMths(driver).sendKeys(ccEmpMths);
			Thread.sleep(1000);
			PGO_creditForm.joint_txt_ccWrkPhone(driver).sendKeys(ccWrkPhone);
			PGO_creditForm.joint_txt_ccGrossIncome(driver).sendKeys(ccGrossIncome);
			System.out.println("Credit Income and employment Information captured");
			Boolean condis1=  PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
			if(condis1==true)
			{
			    test.log(LogStatus.PASS,"Continue button enabled as Income and Employment details are completely filled");
			}
			else
			{
				getscrnSht.getscreenshot(driver, scrnshtPthNm);	
				 test.log(LogStatus.FAIL,"Continue button not enabled though the Income and Employment details are completely filled");
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.joint_txt_ccEmployer(driver).clear();
				String val = data.getStrExcelData(dRw, 89+i, 4);
				PGO_creditForm.joint_txt_ccEmployer(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					System.out.println("Continue button not enabled as employer details entered is invalid");
				
				}
				else
				{
					System.out.println("Continue button enabled thoughemployer details enetered is invalid");
					
				}
				PGO_creditForm.joint_txt_ccEmployer(driver).clear();
				PGO_creditForm.joint_txt_ccEmployer(driver).sendKeys(ccEmployer);
			}
			for(int i=0;i<2;i++)
			{
				PGO_creditForm.joint_txt_ccOccu(driver).clear();
				String val = data.getStrExcelData(dRw, 92+i, 4);
				PGO_creditForm.joint_txt_ccOccu(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					System.out.println("Continue button not enabled as occupation entered is invalid");
				
				}
				else
				{
					System.out.println("Continue button enabled though occupation entered is invalid");
					
				}
				PGO_creditForm.joint_txt_ccOccu(driver).clear();
				PGO_creditForm.joint_txt_ccOccu(driver).sendKeys(ccOccu);
			}
			for(int i=0;i<3;i++)
			{
				PGO_creditForm.joint_txt_ccEmpYrs(driver).clear();
				String val = data.getStrExcelData(dRw, 79+i, 4);
				PGO_creditForm.joint_txt_ccEmpYrs(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					System.out.println("Continue button not enabled as Year entered is invalid");
				
				}
				else
				{
					System.out.println("Continue button enabled though Year entered is invalid");
					
				}
				PGO_creditForm.joint_txt_ccEmpYrs(driver).clear();
				PGO_creditForm.joint_txt_ccEmpYrs(driver).sendKeys(ccEmpYrs);
			}
			for(int i=0;i<4;i++)
			{
				PGO_creditForm.joint_txt_ccEmpMths(driver).clear();
				String val = data.getStrExcelData(dRw, 79+i, 4);
				PGO_creditForm.joint_txt_ccEmpMths(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					System.out.println("Continue button not enabled as Month entered is invalid");
				
				}
				else
				{
					System.out.println("Continue button enabled though Month entered is invalid");
					
				}
				PGO_creditForm.joint_txt_ccEmpMths(driver).clear();
				PGO_creditForm.joint_txt_ccEmpMths(driver).sendKeys(ccEmpMths);
			}
			for(int i=0;i<5;i++)
			{
				PGO_creditForm.joint_txt_ccWrkPhone(driver).clear();
				String val = data.getStrExcelData(dRw, 46+i, 4);
				PGO_creditForm.joint_txt_ccWrkPhone(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					System.out.println("Continue button not enabled as Phonenumber entered is invalid");
					
				}
				else
				{
					System.out.println("Continue button enabled though Phonenumber entered is invalid");
					
				}
				PGO_creditForm.joint_txt_ccWrkPhone(driver).clear();
				PGO_creditForm.joint_txt_ccWrkPhone(driver).sendKeys(ccWrkPhone);
			}
			for(int i=0;i<3;i++)
			{
				PGO_creditForm.joint_txt_ccGrossIncome(driver).clear();
				String val = data.getStrExcelData(dRw, 34+i, 4);
				PGO_creditForm.joint_txt_ccGrossIncome(driver).sendKeys(val);
				Boolean dispp3=PGO_creditForm.btn_creditPersContinue(driver).isEnabled();
				if(dispp3==false)
				{
					System.out.println("Continue button not enabled as Gross Income entered is invalid");
					
				}
				else
				{
					System.out.println("Continue button enabled though Gross Income entered is invalid");
					
				}
				PGO_creditForm.joint_txt_ccGrossIncome(driver).clear();
				PGO_creditForm.joint_txt_ccGrossIncome(driver).sendKeys(ccGrossIncome);
			}
			
		}
		catch(Exception creditIncomeInfoException)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL, creditIncomeInfoException.getMessage(), test.addScreenCapture(Screenpathforreport(scrnshtPthNm)));
		}
	}
			
			
				
				  
			

	//-----------Form review and submit
	public void creditReview(int dRw)throws Exception {
		//String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
		try{
			for (int i=1; i<=3; i++)
			{
				test.log(LogStatus.INFO,"Review and Submit page loads successfully");
				System.out.println("Starts");
				int Row_count = driver.findElements(By.xpath("//div [@class='col-xs-12']/section[1]/table["+i+"]/tbody/tr")).size();
				System.out.println("Number Of Rows = "+Row_count);
				test.log(LogStatus.INFO, "Number Of Rows = "+Row_count);
				//Get number of columns In table.
				int Col_count = driver.findElements(By.xpath("//div [@class='col-xs-12']/section[1]/table["+i+"]/tbody/tr[1]/td")).size();
				System.out.println("Number Of Columns = "+Col_count);
				test.log(LogStatus.INFO, "Number Of Columns = "+Col_count);
				//Used for loop for number of rows.
				for (int j=1; j<=Row_count; j++)
				{
					//Used for loop for number of columns.
					for(int k=1; k<=Col_count; k++)
					{
						String Table_data = driver.findElement(By.xpath("//div [@class='col-xs-12']/section[1]/table["+i+"]/tbody/tr["+j+"]/td["+k+"]")).getText();
						System.out.print(Table_data +" "); 
						test.log(LogStatus.INFO, Table_data +" ");
	
					} 
					System.out.println("");
				}
				System.out.println("Table "+i+" data is captured");
				test.log(LogStatus.INFO, "Table "+i+" data is captured");
				test.log(LogStatus.INFO,"Contact, Personal and Income & Employment status information verified in Review and Submit page");
				
			}	
				WebElement nwDisclmer = PGO_creditForm.txt_nwDisclmer(driver);
	//			WebElement footer = driver.findElement(By.linkText("Click here for Ford Credit Privacy Statement"));
				wait.until(ExpectedConditions.elementToBeClickable(nwDisclmer));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nwDisclmer);
				WebElement nwDisclaimer1 = PGO_creditForm.txt_nwDisclmer1(driver);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nwDisclaimer1);
				WebElement chkbx_accept_btn = PGO_creditForm.chkbx_accept_btn(driver);
				actions.moveToElement(chkbx_accept_btn).build().perform();
				libs.waitToClick(driver, chkbx_accept_btn, 10);		
				test.log(LogStatus.INFO, "Terms and conditions accepted ");
				System.out.println("Terms and conditions accepted ");
				WebElement btn_submit = PGO_creditForm.btn_fnlsubmit(driver);
//				Assert.assertTrue(btn_submit.isEnabled());
				libs.waitToClick(driver, btn_submit, 10);
				test.log(LogStatus.INFO, "Credit form submitted ");
				System.out.println("Credit form submitted ");
				Thread.sleep(5000);
				//wait.until(ExpectedConditions.elementToBeSelected(By.xpath("/html/body/div[6]/div/div/button/span")));
				//Assert.assertTrue(driver.findElement(By.xpath(("/html/body/div[6]/div/div/button/span"))).isDisplayed());
				System.out.println("'creditForm' testcase is passed.");
				data.writeToExcel("Passed", dRw, 23, 4);
				test.log(LogStatus.PASS,"'creditForm' testcase is passed.") ;
		}catch(Exception creditReviewException)
		 {
			  Count++;
				System.out.println("'creditForm' testcase is failed.");
				data.writeToExcel("Failed", dRw, 23, 4);
				getscrnSht.getscreenshot(driver, scrnshtPth+"creditReview_Failed.jpg");
				test.log(LogStatus.FAIL,creditReviewException.getMessage(),test.addScreenCapture(scrnshtPth +"creditReview_Failed.jpg") );
		}
		
	}


	@AfterTest
	public void tearReport(){
	report.endTest(test);
	report.flush();
	}

}
