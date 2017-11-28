package pageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.LogStatus;
public class creditForm extends rsg_DriverClass
{
    WebDriverWait wait = new WebDriverWait(driver,10);
	FuncitonLibrary libs = new FuncitonLibrary();
	creditApp creditApp=new creditApp();
	public void  creditForm_run(int dRw) throws Exception
	{
		try
		{
		String runVal = data.getExcelData(dRw,"ApplyCreDit", "reviewAndSend");
		switch(runVal)
		{
			case "Yes":
				     invokeReport("Verify Credit Form ",dRw);
				     test.log(LogStatus.INFO, "Credit Form", "Credit Form execution starts..");
				     applyfrCredit(dRw);
					 creditApp(dRw);
					 tearReport();
				     break;
			case "No":
       			System.out.println("Credit Form testcase is not executed");
				data.writeExceldata(dRw, "Result - Form", "CreditForm", "Not Executed");
				test.log(LogStatus.INFO, "Credit Form testcase is not executed");
				break;
			}
		}
		catch(Exception e)
		 {
			e.printStackTrace();
			Count++;
			System.out.println("Credit Form testcase is failed");
			test.log(LogStatus.FAIL,"Credit Form testcase is failed");
			data.writeExceldata(dRw,"Result - Form","CreditForm","Failed");	
		}
	}

	public void applyfrCredit(int dRw) throws Exception
	{
	  String scrnshtPthNm=scrnshtPth+"applyfrCredit"+libs.timestamp1()+".jpg";
	  libs.componenttHeading("Deal Submission with Credit App");
	  try
	   {	
		 libs.clickOnButton(PGO_reviewAndSend.applyforCredit(driver), "Apply for credit & send to dealer");
		 test.log(LogStatus.PASS, "Credit Application Overlay Opens");
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
		String scrnshtPthNm=scrnshtPth+"Main Credit App"+libs.timestamp1()+".jpg";
		libs.componenttHeading("Credit Application Overlay");
		try {
		libs.VerifyElement(PGO_creditForm.creditOverlayImg(driver), "creditOverlayImg", driver, test, dRw);
		libs.VerifyText(PGO_creditForm.creditOverlayHeading(driver),data.getExcelData(1,"Overlay Heading", "CreditForm"),"creditOverlayHeading", "");
		libs.VerifyText(PGO_creditForm.creditOverlayText(driver),data.getExcelData(1,"OverlayText", "CreditForm"),"creditOverlayText", "");
		String ButtonName=data.getExcelData(dRw,"ApplicationType","CreditForm");
		libs.clickOnButton(PGO_creditForm.Btn_CreditapplicatonBuy(driver,ButtonName), ButtonName);
		test.log(LogStatus.PASS, "Click on '"+ButtonName+"' in credit application", ButtonName+" has been clicked");
		String poption=data.getExcelData(dRw,"Payment Type","PaymentCalculator");
		try
		{
		 if(poption.equals("Finance|Lease"))
		  {
			 test.log(LogStatus.PASS, "Payment option selected");
		  }
		 else
		 {
			 String alterpoption=data.getExcelData(dRw,"PaymentType","CreditForm"); 
			 libs.clickOnButton(PGO_creditForm.Btn_CreditapplicatonBuy(driver,alterpoption), alterpoption);
			 test.log(LogStatus.PASS, "Click on '"+alterpoption+"' in credit application", alterpoption+" has been clicked");
			 
		 }
		}
		catch(Exception e)
		{
		  e.printStackTrace();
	    }
		creditContactInfo(dRw);
		creditPersonalInfo(dRw);
		creditIncomeInfo(dRw);
		reviewAndSubmit(dRw);
		creditReview(dRw);
		}
		catch(Exception Creditapp)
		{
			Count++;
			getscrnSht.getscreenshot(driver, scrnshtPthNm);
			test.log(LogStatus.FAIL, "isse in credit form",test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		}
	}
		public void creditContactInfo(int dRw)throws Exception 
	{
		libs.componenttHeading("Primary Applicant Contact Information Details");
		libs.enterValueIntoTextField(PGO_creditForm.txt_priFirstName(driver), "txt_priFirstName", data.getExcelData(dRw, "FirstName", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_priLastName(driver), "txt_priLastName", data.getExcelData(dRw, "LastName", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccStrAdd(driver), "txt_ccStrAdd", data.getExcelData(dRw, "StreetAddress", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccPriAppCity(driver),"txt_ccPriAppCity", data.getExcelData(dRw, "City", "CreditForm"));
		libs.selectValueFromDropDown(PGO_creditForm.txt_ccPriAppState(driver), data.getExcelData(dRw,"State", "CreditForm"),"txt_ccPriAppState",0);
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccPriAppZip(driver), "txt_ccPriAppZip", data.getExcelData(dRw, "ZIPCode", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccPriAppPhone(driver), "txt_ccPriAppPhone", data.getExcelData(dRw, "PrimaryPhoneNumber", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccPriAppEmail(driver), "txt_ccPriAppEmail", data.getExcelData(dRw, "EmailAddress", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccPriAppEmailConfirm(driver), "txt_ccPriAppEmailConfirm", data.getExcelData(dRw, "Confirm Email Address", "CreditForm"));
		test.log(LogStatus.PASS,"Primary Applicant Contact Information Details captured successfully");
		String applicationtype=data.getExcelData(dRw,"ApplicationType","CreditForm");
		if(applicationtype.equals("Joint"))
		{
			libs.componenttHeading("Joint Applicant Contact Information Details");
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_priFirstName(driver), "joint_txt_priFirstName", data.getExcelData(dRw, "JointFirstName", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_priLastName(driver), "joint_txt_priLastName", data.getExcelData(dRw, "JointLastName", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccStrAdd(driver), "joint_txt_ccStrAdd", data.getExcelData(dRw, "JointStreetAddress", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccPriAppCity(driver),"joint_txt_ccPriAppCity", data.getExcelData(dRw, "JointCity", "CreditForm"));
			libs.selectValueFromDropDown(PGO_creditForm.joint_txt_ccPriAppState(driver), data.getExcelData(dRw,"JointState", "CreditForm"),"joint_txt_ccPriAppState",0);
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccPriAppZip(driver), "joint_txt_ccPriAppZip", data.getExcelData(dRw, "JointZIPCode", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccPriAppPhone(driver), "joint_txt_ccPriAppPhone", data.getExcelData(dRw, "JointPrimaryPhoneNumber", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccPriAppEmail(driver), "joint_txt_ccPriAppEmail", data.getExcelData(dRw, "JointEmailAddress", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccPriAppEmailConfirm(driver), "joint_txt_ccPriAppEmailConfirm", data.getExcelData(dRw, "JointConfirm Email Address", "CreditForm"));
			libs.selectValueFromDropDown(PGO_creditForm.joint_txt_ccrelationship(driver), data.getExcelData(dRw, "JointRelationshiptoPrimaryApplicant", "CreditForm"), "joint_txt_ccrelationship",0);
			test.log(LogStatus.PASS,"Joint Applicant Contact Information Details captured successfully");
		}
		libs.clickOnButton(PGO_creditForm.btn_creditContactBtn(driver), "btn_creditContactBtn");
		test.log(LogStatus.PASS,"Continue button clicked successfully in Contact Information page");
	}
	
	
	public void creditPersonalInfo(int dRw) throws Exception
	{
		libs.componenttHeading("Primary Applicant Personal Information Details");
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccDob(driver), "txt_ccDob", data.getExcelData(dRw, "DateofBirth", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccSsn(driver), "txt_ccSsn", data.getExcelData(dRw, "SocialSecurityNumber", "CreditForm"));
		libs.selectValueFromDropDown(PGO_creditForm.txt_ccResSt(driver), data.getExcelData(dRw, "ResidenceStatus", "CreditForm"), "txt_ccResSt",0);
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccResYr(driver), "txt_ccResYr", data.getExcelData(dRw, "How long have you lived at this address?(Years)", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccResMths(driver), "txt_ccResMths", data.getExcelData(dRw, "How long have you lived at this address?(Months)", "CreditForm"));
		test.log(LogStatus.PASS,"Primary Applicant Personal Information Details captured successfully");
		String applicationtype=data.getExcelData(dRw,"ApplicationType","CreditForm");
		if(applicationtype.equals("Joint"))
		{
			libs.componenttHeading("Joint Applicant Personal Information Details");
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccDob(driver), "joint_txt_ccDob", data.getExcelData(dRw, "JointDateofBirth", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccSsn(driver), "joint_txt_ccSsn", data.getExcelData(dRw, "JointSocialSecurityNumber", "CreditForm"));
			libs.selectValueFromDropDown(PGO_creditForm.joint_txt_ccResSt(driver), data.getExcelData(dRw,"JointResidenceStatus", "CreditForm"),"joint_txt_ccResSt",0);
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccResYr(driver), "joint_txt_ccResYr", data.getExcelData(dRw, "JointHow long have you lived at this address?(Years)", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccResMths(driver),"joint_txt_ccResMths", data.getExcelData(dRw, "JointHow long have you lived at this address?(Months)", "CreditForm"));
			test.log(LogStatus.PASS,"Joint Applicant Personal Information Details captured successfully");
		}
		libs.clickOnButton(PGO_creditForm.btn_creditContactBtn(driver), "btn_creditContactBtn");
		test.log(LogStatus.PASS,"Continue button clicked successfully in Personal Information Section");
	}
		
    public void creditIncomeInfo(int dRw) throws Exception
    {
    	libs.componenttHeading("Primary Applicant Income & Employment Information Details");
    	libs.selectValueFromDropDown(PGO_creditForm.txt_ccEmpSts(driver), data.getExcelData(dRw, "EmploymentStatus", "CreditForm"), "txt_ccEmpSts",0);
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccEmployer(driver), "txt_ccEmployer", data.getExcelData(dRw, "EmployerName", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccOccu(driver), "txt_ccOccu", data.getExcelData(dRw, "Occupation", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccEmpYrs(driver), "txt_ccEmpYrs", data.getExcelData(dRw, "How long have you worked there?(Years)", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccEmpMths(driver), "txt_ccEmpMths", data.getExcelData(dRw, "How long have you worked there?(Months)", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccWrkPhone(driver), "txt_ccWrkPhone", data.getExcelData(dRw, "WorkPhoneNumber", "CreditForm"));
		libs.enterValueIntoTextField(PGO_creditForm.txt_ccGrossIncome(driver), "txt_ccGrossIncome", data.getExcelData(dRw, "GrossAnnualIncome", "CreditForm"));
		test.log(LogStatus.PASS,"Primary Applicant Income & Employment Information Details captured successfully");
		String applicationtype=data.getExcelData(dRw,"ApplicationType","CreditForm");
		if(applicationtype.equals("Joint"))
		{
			libs.componenttHeading("Joint Applicant Income & Employment Information Details");
			libs.selectValueFromDropDown(PGO_creditForm.joint_txt_ccEmpSts(driver),data.getExcelData(dRw, "JointEmploymentStatus", "CreditForm"),"joint_txt_ccEmpSts",0);
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccEmployer(driver), "joint_txt_ccEmployer", data.getExcelData(dRw, "JointEmployerName", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccOccu(driver), "joint_txt_ccOccu", data.getExcelData(dRw, "JointOccupation", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccEmpYrs(driver), "joint_txt_ccEmpYrs", data.getExcelData(dRw, "JointHow long have you worked there?(Years)", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccEmpMths(driver), "joint_txt_ccEmpMths", data.getExcelData(dRw, "JointHow long have you worked there?(Months)", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccWrkPhone(driver), "joint_txt_ccWrkPhone", data.getExcelData(dRw, "JointWorkPhoneNumber", "CreditForm"));
			libs.enterValueIntoTextField(PGO_creditForm.joint_txt_ccGrossIncome(driver), "joint_txt_ccGrossIncome", data.getExcelData(dRw, "JointGrossAnnualIncome", "CreditForm"));
			test.log(LogStatus.PASS,"Joint Applicant Income & Employment Information Details captured successfully");
		}
		libs.clickOnButton(PGO_creditForm.btn_creditContactBtn(driver), "btn_creditContactBtn");
		test.log(LogStatus.PASS,"Continue button clicked successfully in Income & Employment section");
    }
	public void reviewAndSubmit(int dRw)throws Exception
    {
    	libs.componenttHeading("Comparision of Review and Submit Page Information - Individual");
    	String applicationtype=data.getExcelData(dRw,"ApplicationType","CreditForm");
		if(applicationtype.equals("Individual"))
		{
    	int applicantinfo= PGO_creditForm.reviewAndSubmitLabels(driver).size();
		for(int i=0;i<applicantinfo;i++)
		  {
			  String applicantlabel = PGO_creditForm.reviewAndSubmitLabels(driver).get(i).getText().replaceAll("[^A-Za-z]", "").trim();
			  System.out.println(applicantlabel);
			  System.out.println(data.getExcelData(dRw, applicantlabel, "CreditForm"));
			  String applicantdetails = PGO_creditForm.reviewAndSubmitValues(driver).get(i).getText();
			  System.out.println(applicantdetails);
			  libs.VerifyPartialText(PGO_creditForm.reviewAndSubmitValues(driver).get(i), data.getExcelData(dRw, applicantlabel, "CreditForm"), "CreditForm","");
		  }
		}
		else
		{
        libs.componenttHeading("Comparision of Review and Submit Page Information - Joint");
    	int applicantinfo= PGO_creditForm.reviewAndSubmitJointLabels(driver).size();
		for(int i=0;i<applicantinfo;i++)
		  {
			  String applicantlabel = PGO_creditForm.reviewAndSubmitJointLabels(driver).get(i).getText().replaceAll("[^A-Za-z]", "").trim();
			  System.out.println(applicantlabel);
			  System.out.println(data.getExcelData(dRw, applicantlabel, "CreditForm"));
			  String applicantdetails = PGO_creditForm.reviewAndSubmitJointValues(driver).get(i).getText();
			  System.out.println(applicantdetails);
			  libs.VerifyPartialText(PGO_creditForm.reviewAndSubmitJointValues(driver).get(i), data.getExcelData(dRw, applicantlabel, "CreditForm"), "CreditForm","");
		  }
    	
    }
		}
	public void creditReview(int dRw)throws Exception
	{
		libs.componenttHeading("Capturing Applicant Details in Review and Submit page");	
	 try
	 {
			for (int i=1; i<=3; i++)
			{
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
				}
			test.log(LogStatus.INFO,"Contact, Personal and Income & Employment information of Applicant captured in Review and Submit page");
				WebElement nwDisclmer = PGO_creditForm.txt_nwDisclmer(driver);

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

				libs.waitToClick(driver, btn_submit, 10);
				test.log(LogStatus.INFO, "Credit form submitted ");
				System.out.println("Credit form submitted ");
				Thread.sleep(5000);
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
