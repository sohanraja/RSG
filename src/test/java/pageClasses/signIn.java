package pageClasses;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilityClasses.*;
public class signIn extends rsg_DriverClass{
//	WebDriver driver = getDriver();
//	ExcelUtilityClass data = new ExcelUtilityClass();
//	ScreenShot getscrnSht = new ScreenShot();
//	ExtentReports report;
//	ExtentTest test;
	WebDriverWait wait = new WebDriverWait(driver,6);
	FuncitonLibrary libs = new FuncitonLibrary();
	Actions actions = new Actions(driver);
	JavascriptExecutor jse=(JavascriptExecutor) driver;	
	int sheetno=14;
	@BeforeTest
	public void invokeReport() {
		report = ExtentReportManager.invokeExtentReport();
		test = report.startTest("Verify Sign In");
	}
	@Test
	public void SignIn_run(int dRw) throws Exception
	{
		try
		{
		String runVal = data.getStrExcelData(1, 2, 1);
		System.out.println(runVal);
		switch(runVal){
		case "Yes":
			invokeReport();
			nvgtSignIn(dRw);
			entrSignIn(dRw);
//			signinVerifications(dRw);
//			RgstrSignInVldTxt(dRw);
//			tearReport();
			break;
		case "No":
			System.out.println("SignIn testcase will not be executed");
			data.writeToExcel("Not Executed", dRw, 7, sheetno);
			break;
		}
		}
		catch(Exception SignIn_run)
		{
			String scrnshtPth = data.getStrExcelData(dRw, 4, 3);
			System.out.println("'SignIn_run' testcase is failed.");
			data.writeToExcel("Failed", dRw, 5, sheetno);
			getscrnSht.getscreenshot(driver, scrnshtPth+"Payment tab_Failed_"+libs.timestamp()+".jpg");
			test.log(LogStatus.FAIL,  SignIn_run.getMessage(),test.addScreenCapture(scrnshtPth +"Payment tab_Failed_"+libs.timestamp()+".jpg") );
		}
	}
  //@Test
	public void nvgtSignIn(int dRw) throws Exception
	{	
	    String scrnshtPth = data.getStrExcelData(dRw, 8, 5);
	    String scrnshtPthNm=scrnshtPth+"Signin_page_failed"+".jpg";
		try
		{
			driver.navigate().to("http://www.ford.com/shared/redirectlogic/frdq3a9er7gt2.html");
			driver.navigate().to("https://wwwqa.shop.ford.com/buy/");
			Thread.sleep(3000);
			// navigate to saved dealer
			libs.waitToClick(driver,PGO_signIn.lnk_svdDlr(driver) , 10);
			System.out.println("Navigated to saved items page successfully");
			test.log(LogStatus.INFO,"Navigated to saved items page successfully");
			// navigate to sign in
			libs.waitToClick(driver,PGO_signIn.lnk_sgnIn(driver), 10);
			 System.out.println("Navigated to Sign in page1 successfully");
			 test.log(LogStatus.INFO,"Clikedon sign-in successfully");
			Thread.sleep(2000);
			libs.waitToClick(driver,PGO_signIn.lnk_sgnIn1(driver) , 10);
            System.out.println("Navigated to Sign in page successfully");
            test.log(LogStatus.INFO,"Navigated to saved dealer page successfully");
            
		}
		catch(Exception nvgtSignInException)
		{	
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, nvgtSignInException.getMessage(), test.addScreenCapture(scrnshtPthNm));
		}
	}
	public void signinVerifications(int dRw) throws Exception
	{	
		System.out.println(1);
		String scrnshtPth = data.getStrExcelData(dRw, 8, 5);
	    String scrnshtPthNm=scrnshtPth+"Signin_Verifications_failed"+".jpg";
	    System.out.println(2);
		try
		{
			Thread.sleep(2000);
			String achsignintext=PGO_signIn.signinText(driver).getText();
            String expsignintext=data.getStrExcelData(dRw,27,sheetno);	
            libs.assertionHandling(achsignintext, expsignintext, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Sign-In Text verified successfully" );
			System.out.println("signin pass");
			String acthead=PGO_signIn.signbenefitsHead(driver).getText();
            String exphead=data.getStrExcelData(dRw,24,sheetno);	
            libs.assertionHandling(acthead, exphead, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Sign-In Benefits Heading verified successfully" );	
			System.out.println("signin benefits pass");
            String acttext=PGO_signIn.signbenefitsText(driver).getText();
            String exptext=data.getStrExcelData(dRw,25,sheetno);	
            libs.assertionHandling(acttext, exptext, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Sign-In Benefits Text verified successfully" );
			System.out.println("signin benefits text pass");
            String achcreateacc=PGO_signIn.createAccount(driver).getText();
            String expcreateacc=data.getStrExcelData(dRw,26,sheetno);	
            libs.assertionHandling(achcreateacc, expcreateacc, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Create account button Text verified successfully" );
			System.out.println("Create account text pass");
            String achcon=PGO_signIn.continueButton(driver).getText();
            String expcon=data.getStrExcelData(dRw,23,sheetno);	
            libs.assertionHandling(achcon, expcon, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Continue without create account button Text verified successfully" );
			System.out.println("Continue without create account text pass");
            String achsocial=PGO_signIn.socialSignin(driver).getText();
            String expsocial=data.getStrExcelData(dRw,28,sheetno);	
            libs.assertionHandling(achsocial, expsocial, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Social Sign-In Text verified successfully" );
			System.out.println("Social signin text pass");
            int i=PGO_signIn.signinForm(driver).size();
            System.out.println(i);
            for(int j=0;j<i;j++)
			{
			String signacttext=PGO_signIn.signinForm(driver).get(j).getText();
			System.out.println(signacttext);
			String signexptext=data.getStrExcelData(dRw,29+i,sheetno);
			System.out.println(signexptext);
			libs.assertionHandling(signacttext, signexptext, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Form fields verified successfully" );
			}	
            String actsigninbtext=PGO_signIn.signinButton(driver).getText();
			String expsigninbtext=data.getStrExcelData(dRw,31,sheetno);
			libs.assertionHandling(actsigninbtext, expsigninbtext, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Signin button text verified successfully" );
			System.out.println("zzz");
            String actforgottext=PGO_signIn.forgotPassword(driver).getText();
			String expforgottext=data.getStrExcelData(dRw,32,sheetno);
			libs.assertionHandling(actforgottext, expforgottext, test,driver,scrnshtPthNm);
			System.out.println("yyy");
			test.log(LogStatus.PASS,"Forgot My Password link text successfully" );
            String actremtext=PGO_signIn.rememberMe(driver).getText();
			String expremtext=data.getStrExcelData(dRw,33,sheetno);
			libs.assertionHandling(actremtext, expremtext, test,driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Remember me link text verified successfully" );
			System.out.println("nnn");

		}catch(Exception signinVerifications)
		{	
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
            test.log(LogStatus.FAIL, signinVerifications.getMessage(), test.addScreenCapture(scrnshtPthNm));
		}
	}

	public void entrSignIn(int dRw) throws Exception
	{	
		try
		{
			Thread.sleep(7000);
			String un=data.getStrExcelData(dRw, 30, sheetno);
			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_signIn.un_text(driver));
			PGO_signIn.un_text(driver).sendKeys(un);
			System.out.println("Un sucessful");
			String pwd=data.getStrExcelData(dRw, 32, sheetno);
			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_signIn.pwd_text(driver));
			PGO_signIn.pwd_text(driver).sendKeys(pwd);
			System.out.println("Pwd sucessful");
			Thread.sleep(7000);
		try
		{
			jse.executeScript("arguments[0].scrollIntoView(true)",PGO_signIn.btnSubmit(driver));
			libs.waitToClick(driver,PGO_signIn.btnSubmit(driver),300);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			test.log(LogStatus.INFO,"Sign-In sucessful");
			System.out.println("Sign-In sucessful");
		
		}catch(Exception entrSignInException)
		{	
			getscrnSht.getscreenshot(driver, "entrSignIn_Failed.jpg");
			test.log(LogStatus.FAIL, entrSignInException.getMessage(), test.addScreenCapture(EnvironmentVariables.screenShtPath+"entrSignIn_Failed.jpg") );
		}


	}

	public void RgstrSignInVldTxt(int dRw) throws Exception
	{	
		String crAccHdExp =data.getStrExcelData(dRw, 8, sheetno);
		String crAccSubHdExp =data.getStrExcelData(dRw, 9, sheetno);
		String crAccPwdVldExp =data.getStrExcelData(dRw, 16, sheetno);
		String clwbnftsttlExp =data.getStrExcelData(dRw, 17, sheetno);
		String clwbnftsDtlExp =data.getStrExcelData(dRw, 18, sheetno);
		String cbtnSubmitExp =data.getStrExcelData(dRw, 19, sheetno);
		String btnCancelExp =data.getStrExcelData(dRw, 20, sheetno);
		String AlrdyMmbrExp =data.getStrExcelData(dRw, 21, sheetno);
		String mmbrSgnInExp =data.getStrExcelData(dRw, 22, sheetno);
		String cntWithoutAccExp =data.getStrExcelData(dRw, 23, sheetno);
		String scrnshtPth = data.getStrExcelData(dRw, 8, 5);
	    String scrnshtPthNm=scrnshtPth+"Signin_Verifications_failed"+".jpg";
		try
		{
			//Create Account
			actions.moveToElement(PGO_signIn.createAccount(driver)).build().perform();
			libs.waitToClick(driver, PGO_signIn.createAccount(driver), 10);
			
			String crAccHd =PGO_signIn.createYourAccount(driver).getText();
			System.out.println("Create Account Page Headline is : "+crAccHd);
			System.out.println("Create Account Page Headline Expected is : "+crAccHdExp);
			test.log(LogStatus.PASS,"Create Account Page Headline is : "+crAccHd);
			libs.assertionHandling(crAccHd, crAccHdExp, test, driver,scrnshtPthNm);

			String crAccSubHd =PGO_signIn.crAccSubhead(driver).getText();
			System.out.println("Create Account Page sub Headline is : "+crAccSubHd);
			System.out.println("Create Account Page sub Headline Expected is : "+crAccSubHdExp);
			test.log(LogStatus.PASS,"Landing Page Sub Headline is : "+crAccSubHd);
			libs.assertionHandling(crAccSubHd, crAccSubHdExp, test, driver,scrnshtPthNm);

			String crAccPwdVld =PGO_signIn.crAccpwdrules(driver).getText();
			System.out.println("Create Account Page password conditions : "+crAccPwdVld);
			System.out.println("Create Account Page password conditions Expected is : "+crAccPwdVldExp);
			test.log(LogStatus.PASS,"Landing Page Sub Headline is : "+crAccSubHd);
			libs.assertionHandling(crAccPwdVld, crAccPwdVldExp, test, driver,scrnshtPthNm);
			
			// Submit and cancel text validation
			
			String btnsubmit =PGO_signIn.btnSubmit(driver).getText();
			System.out.println("Actual Submit button text: "+btnsubmit);
			System.out.println("Expected Submit button text: "+cbtnSubmitExp);
			libs.assertionHandling(btnsubmit, cbtnSubmitExp, test, driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Submit button text verified successfully");
			
			String btncancel =PGO_signIn.btnCancel(driver).getText();
			System.out.println("Actual Cancel button text: "+btncancel);
			System.out.println("Expected Cancel button text: "+btnCancelExp);
			libs.assertionHandling(btncancel, btnCancelExp, test, driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Cancel button text verified successfully");
			

			// Benefits title and text validation
			String clwbnftsttl =PGO_signIn.profileHeading(driver).getText();
			System.out.println("Benefits of creating profile Heading: "+clwbnftsttl);
			System.out.println("Benefits of creating profile Heading Expected is : "+clwbnftsttlExp);
			libs.assertionHandling(clwbnftsttl, clwbnftsttlExp, test, driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Benefits of creating profile Heading verified successfully");
			
			String clwbnftsDtl =PGO_signIn.profileText(driver).getText();
			System.out.println("Benefits of creating profile Text: "+clwbnftsDtl);
			System.out.println("Benefits of creating profile Expected is : "+clwbnftsDtlExp);
			libs.assertionHandling(clwbnftsDtl, clwbnftsDtlExp, test, driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Benefits of creating profile Text verified successfully");
			
			String AlrdyMmbr = PGO_signIn.almember(driver).getText();
			System.out.println("Already a member text: "+AlrdyMmbr);
			System.out.println("Already a member text Expected is : "+AlrdyMmbrExp);
			libs.assertionHandling(AlrdyMmbr, AlrdyMmbrExp, test, driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Already a member text verified successfully");
			
			String mmbrSgnIn = PGO_signIn.alreadymemSignin(driver).getText();
			System.out.println("SignIn text: "+mmbrSgnIn);
			System.out.println("SignIn text Expected "+mmbrSgnInExp);
			libs.assertionHandling(mmbrSgnIn, mmbrSgnInExp, test, driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"SignIn button text verified successfully");
			
			String cntWithoutAcc = PGO_signIn.continuenosignin(driver).getText();
			System.out.println("Continue without an account text: "+cntWithoutAcc);
			System.out.println("Continue without an account Expected is : "+cntWithoutAccExp);
			libs.assertionHandling(cntWithoutAcc, cntWithoutAccExp, test, driver,scrnshtPthNm);
			test.log(LogStatus.PASS,"Continue without an account text verified successfully");
			
			
			

		}catch(Exception RgstrSignInException)
		{	
			getscrnSht.getscreenshot(driver, "RgstrSignIn_Failed.jpg");
			test.log(LogStatus.FAIL, RgstrSignInException.getMessage(), test.addScreenCapture(EnvironmentVariables.screenShtPath+"RgstrSignIn_Failed.jpg"));
		}
	}
		public void signinLabels(int dRw) throws Exception
	    {
	     try
	     {
	    	 System.out.println("signin");
	     String scrnshtPth = data.getStrExcelData(dRw, 22, 4);
		 String scrnshtPthNm =scrnshtPth+"Signin_Page_Failed_"+libs.timestamp()+".jpg";	
	     int i=PGO_signIn.signinFields(driver).size();
	     System.out.println(i);
		  for(int j=0;j<i;j++)
		  {
			  String act=PGO_signIn.signinFields(driver).get(j).getText();
			  String exp=data.getStrExcelData(dRw,10+j,14);
			  libs.assertionHandling(act, exp, test, driver,scrnshtPthNm);
			  test.log(LogStatus.PASS,"SignIn labels text verified successfully");
		  }
	     }
	     catch(Exception signinLabels)
			{	
				getscrnSht.getscreenshot(driver, "RgstrSignIn_Failed.jpg");
				test.log(LogStatus.FAIL, signinLabels.getMessage(), test.addScreenCapture(EnvironmentVariables.screenShtPath+"RgstrSignIn_Failed.jpg"));
			}  
	    }
	//	@AfterTest
	public void tearReport(){
		report.endTest(test);
		report.flush();
	}


}