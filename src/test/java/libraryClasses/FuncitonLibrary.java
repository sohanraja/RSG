package libraryClasses;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pageObjectClasses.*;
import utilityClasses.*;

@SuppressWarnings("unused")
public class FuncitonLibrary  {
	public static WebDriver driver1;
	public static EventFiringWebDriver driver;
	public static ExcelUtilityClass data;
	public static ScreenShot getscrnSht = new ScreenShot();
	public static ExtentReports report,reporttest;
	public static ExtentTest test,testSeranios;
	public static String scrnshtPth;
	public String scrnshtPthNm;
	public static int Count=0;
	public static Actions actions;
	public static String testsenarioname,testSenarioDesc;
	public static String runVal;
	public static String browser_val = null;
	public static String applicationname=null;
	public static int xpathvalue=1;
	public static String ValidationStatus,NonFuncational=null;
	public static String EnvironmentName=null;
	public static String ApplicationName=null;
	public static String Temp[];
	public static String bottomtext;

	public static FuncitonLibrary libs = new FuncitonLibrary();
	public static  Random rand = new Random();
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
	public static Date date = new Date();
	public static List<WebElement> Disclaimers,Disclosers,Iballs,DisclaimbersPopUp,TabList = null;
	//**************************************************************************************************************************************************	
//															LIBRARY Functions
	//**************************************************************************************************************************************************

	public void invokeReport(String testreport,int dRw) throws IOException {
		report = ExtentReportManager.invokeExtentReport();

		test = report.startTest(testreport);

		if( browser_val.contains("iPhone") || browser_val.contains("Galaxy")){
			xpathvalue=2;
		}
		

		
	}
		public static void invokeTestSenario(String TestSenarioName,int rownumber  ){
			test = report.startTest(TestSenarioName);
		
		}
	
		//Check if the alert is present
		public boolean isAlertPresent(WebDriver driver)  
		{
		    try {
		        driver.switchTo().alert();
		        return true;
		    } 
		    catch (Exception e) {
		        return false;
		    } 

		}
	//*********************************************************END**********************************************************************************

		
		
		
		//*********************************************************END**********************************************************************************
		//Quit the driver instance	
		public void driver_quit(WebDriver driver)
		{
			driver.quit();
		}
	//*************************************************************END*************************************************************************************

		//Fluent Wait function until the object is displayed
		public void fluentWait(WebDriver driver, final WebElement element)
		{
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
			wait.withTimeout(500, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
			{	public Boolean apply(WebDriver driver) 
				{
					WebElement this_element = element;
					
					if(this_element.isDisplayed())
					{
						return true;
					}
					return false;
				}
			};
			wait.until(function);
		}
//*************************************************************END*************************************************************************************

		
		public long pageLoadingTime(long strtTime, long endTime)
		{
			long pageloadtime  = endTime - strtTime;
			
			return pageloadtime;
		}

//*************************************************************END*************************************************************************************
		public void waitToClick(WebDriver driver, final WebElement element, int time)
		{
		
			final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.pollingEvery(100,  TimeUnit.MILLISECONDS);
			wait.withTimeout(time, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
			{	
				boolean ele_status = false;
				@Override
				public Boolean apply(WebDriver driver) 
				{
					int countdown = 1;
//					
					
			    	while (countdown<100)
			    	{
			    		try
			    		{	    		
			    			element.click();
			    			return true;
			    		}catch(Exception exception)
			    		{
			    			
			    			
			    		}
			    	++countdown;
			    	}
					
					return false;
				}
			
					
//				}
			};
			wait.until(function);
		}

//*******************************************************************************
		public String timestamp() {
		    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}
		public String timestamp1() {
		    return new SimpleDateFormat("HHmmss").format(new Date());
		}
//*******************************************************************************
				public String datestamp() {
				    return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				}

//*************************************************************END*************************************************************************************

				
	public void scrollIntoView(WebElement element, WebDriver driver){
				
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
					
				}
//*************************************************************END*************************************************************************************

	public String  getNumfrmString(String str)
	{
		char CharVal;
		String numVal = "";
		for(int i=0; i<=str.length()-1;i++)
		{
			CharVal = str.charAt(i);
			if(Character.isDigit(CharVal)){
				numVal += CharVal;
			}
		}
		return numVal;
	}
	
//*************************************************************END*************************************************************************************
	
	public int stringToInt(String val){
		int integerVal = Integer.valueOf(val);
		return integerVal;
		}
//*************************************************************END*************************************************************************************		
			public int parseInt(String strNUm){
				int numval = Integer.parseInt(strNUm);
//				System.out.println(numval);
				return numval;
			}
//===========================
			//Webelement Click by ID
			public static void clickById(WebDriver driver, String id)
			{
			Actions action =new Actions(driver);
			action.moveToElement(driver.findElement(By.id(id))).click().build().perform();
			}
	//===================================
//Webelement Click by 	Span contains 

public static void clickBySpan(WebDriver driver, String conatins)
{
Actions action =new Actions(driver);
action.moveToElement(driver.findElement(By.xpath(conatins))).click().build().perform();

}
//===================================
public void assertionHandling(String str1, String str2, ExtentTest test, WebDriver driver, String scrnshtPthNm) throws Exception

{	scrnshtPthNm=scrnshtPth+"screen"+libs.timestamp1()+".jpg";
       ScreenShot getscrnSht = new ScreenShot();
	try{
	Assert.assertEquals(str1, str2);
	test.log(LogStatus.PASS, "Assertion is success for the String "+str1+" & "+str2);
	}catch(AssertionError exception)
	 {
		  Count++;
		getscrnSht.getscreenshot(driver,scrnshtPthNm );
		test.log(LogStatus.FAIL, "Assertion failed for the String "+str1+" & "+str2 + test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		
	}
	
			
}
//===================================Assertion true============================================
public void assertiontrue(boolean str1,  ExtentTest test, WebDriver driver, String scrnshtPthNm) throws Exception

{	scrnshtPthNm=scrnshtPth+"screen"+libs.timestamp1()+".jpg";
     ScreenShot getscrnSht = new ScreenShot();
	try{
	Assert.assertTrue(str1);
	test.log(LogStatus.PASS, "Assertion is success for the true condition - result is : "+str1);
	}catch(AssertionError exception)
	 {
		  Count++;
		getscrnSht.getscreenshot(driver,scrnshtPthNm );
		String[] st1=scrnshtPthNm.split(datestamp());
		
		test.log(LogStatus.FAIL, "Assertion failed for the true condition - result is :  "+str1+" "+ test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		
	}
}
	//===================================Assertion true============================================
	public void assertionfalse(boolean str1,  ExtentTest test, WebDriver driver, String scrnshtPthNm) throws Exception

	{	scrnshtPthNm=scrnshtPth+"screen"+libs.timestamp1()+".jpg";
	       ScreenShot getscrnSht = new ScreenShot();
		try{
		Assert.assertFalse(str1);
		test.log(LogStatus.PASS, "Assertion is success for the False condition - result is : "+str1);
		}catch(AssertionError exception)
		 {
			  Count++;
			getscrnSht.getscreenshot(driver,scrnshtPthNm );
			test.log(LogStatus.FAIL, "Assertion failed for the true condition - result is :  "+str1+" "+ test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			
		}
		
			
}
	//===================================handle exception============================================
	
	public void handleException(WebDriver driver, String scrnshtNm, Exception exceptionName,ExtentTest test) throws Exception
	{
		System.out.println(scrnshtNm);
		String scrnShotName = scrnshtNm+"_"+timestamp1()+".jpg";
		System.out.println(scrnShotName);
		getscrnSht.getscreenshot(driver,scrnShotName );
		System.out.println(EnvironmentVariables.screenShtPath+scrnShotName);
		test.log(LogStatus.FAIL, test.addScreenCapture(Screenpathforreport(scrnshtNm)) );
		test.log(LogStatus.FAIL, exceptionName.getMessage());
	}
	
	/*--------------------------------Method------------------------------
	 * Method Name: < AddingAttributeValueAtRunTime > 
	 * Description: <Adding the attribute dynamically for the webelement>
	 * Author: <Mohana Priya > 
	 * Created Date: < 04/05/2017 > 
	 * Modified By and On: < >
	 * Modified Comments: < >
	 * --------------------------------------------------------------------
	 */ 
	 public void AddingAttributeValueAtRunTime(WebElement webElement,String AttributeName,String AttributeValue,WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;

           js.executeScript("arguments[0].style.border='2px groove red'", webElement);

			js.executeScript("arguments[0].setAttribute('"+AttributeName+"','"+AttributeValue+"')",webElement);
		}
	 // highlight element1=================================================
	 public void  HighlightElement(WebDriver driver,WebElement element){
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		  try {
			Thread.sleep(1000);
			js.executeScript("arguments[0].style.border='2px groove red'", element);
		} catch (InterruptedException e)  {
			  Count++;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  js.executeScript("arguments[0].style.border=''", element);
		  }
	

	 /**
		 * --------------------------------Method------------------------------
		 * Method Name: < VerifyText > 
		 * Description: <This method will verify the text>
		 * Author: <Chandra Reddy K > 
		 * Created Date: < 16/05/2017 > 
		 * Modified By and On: < >
		 * Modified Comments: < >
		 * --------------------------------------------------------------------
		 */
		public void  VerifyText(WebElement element,String Expected, String objectname,String attributename) throws Exception{
			
			try {if(element.isDisplayed()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("arguments[0].style.border='2px groove red'", element);
			  String actual=element.getText();
			  if(attributename.contains("Yes"))
				{
				 actual=actual.replaceAll("[\\D]", "");
				 }
			  if(actual.trim().equalsIgnoreCase(Expected)){

				  js.executeScript("arguments[0].style.border=''", element);
				  test.log(LogStatus.PASS,"Verify the  text/Number("+Expected+")", "Text/Number has been verified successfully.");

				  
			  } else {

				  scrnshtPthNm=scrnshtPth+objectname+".jpg";
				  getscrnSht.getscreenshot(driver,scrnshtPthNm );
				  test.log(LogStatus.FAIL, "Verify the Text/Number("+Expected+")", "actual Text/Number does't matched with  expected text"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );


			  }
			  }}catch(Exception exception) {
				  System.out.println("Expected :: "+Expected);
				  System.out.println("PASSED :: "+objectname);
				  exception.printStackTrace();
				  scrnshtPthNm=scrnshtPth+objectname+".jpg";
				  getscrnSht.getscreenshot(driver,scrnshtPthNm );
				  test.log(LogStatus.FAIL, "Verify the Text/Number for the ("+objectname+")", "the Given object ("+objectname+") is not displayed on the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );


			  }
		}
public void  VerifyElement(WebElement element,String objectname,WebDriver driver,ExtentTest test,int dRw) throws Exception{

	try 
	{
		if(element.isDisplayed())
				{
			          System.out.println(objectname+" "+"is displayed");
					  test.log(LogStatus.PASS,objectname+" "+"is displayed");
				}
		else
		{
			 System.out.println(objectname+" "+"is not displayed");
			  test.log(LogStatus.FAIL,objectname+" "+"is not displayed",test.addScreenCapture(scrnshtPth +("+objectname+")+".jpg"));
		}
	}
	catch(Exception exception)  {
		  Count++;
        test.log(LogStatus.FAIL, "Verify the text for the" + objectname, "the Given object ("+objectname+") is not displayed on the page"+test.addScreenCapture(scrnshtPth +objectname+".jpg") );
        
 }
}
public String Screenpathforreport(String scrnshtPthNm)
{
	try{
	String[] Mainstring=scrnshtPthNm.split(datestamp());
	return Mainstring[1].substring(1);}catch(Exception e) {
		  Count++;System.out.println("screen path"+scrnshtPthNm); }
	return scrnshtPthNm;
}



public void tearReport() throws Exception{
	if(Count<=0){
		data.writeToExcel("Passed", 1, 1, 1);
		Count=0;//[
		
	}else{
		Count=0;
		data.writeToExcel("Failed", 1, 1, 1);
	}
	report.endTest(test);

	report.flush();
	
}


public void testSenariostearsReport()
{
	reporttest.endTest(testSeranios);

	reporttest.flush();
}

public String Failedreason(Exception Excep){
	String arg[]=Excep.getLocalizedMessage().split("\n");
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
		 StackTraceElement e = stacktrace[1];
		System.out.println("method name: "+ e.getMethodName()+ "\tResoan"+arg[0] );
	return "method name: "+ e.getMethodName();
	
}
public static void invokeReportTestSernarios(String tcName,String tcdescription) 
{
	reporttest = ExtentReportManager.invokeExtentReport();
	if(Count==0){
	testSeranios = reporttest.startTest("<b style=background-color:green;>"+tcName, tcName+" execution is completed successfully");
	testSeranios.log(LogStatus.INFO,"TestSenarios Description:"+tcdescription);
	Count=0;
	}
	else {
		
		testSeranios = reporttest.startTest("<b style=background-color:red;>"+tcName, tcName+" execution is completed with some failures(Total Failures:"+Count+")");	
		testSeranios.log(LogStatus.INFO,"TestSenarios Description:"+tcdescription);
		testSeranios.log(LogStatus.FAIL,tcName+"execution is completed with some failures(Total Failures:"+Count+")");
		Count=0;
	}
	
	libs.testSenariostearsReport();
}
/**
 * --------------------------------Method------------------------------
 * Method Name: < encodeFileToBase64Binary > 
 * Description: <This method will encode image>
 * Author: <Chandra Reddy K > 
 * Created Date: < 09/05/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 */
public static String encodeFileToBase64Binary(String imagePath){
   String base64Image = "";
    File file = new File(imagePath);
    try (FileInputStream imageInFile = new FileInputStream(file)) {
        // Reading a Image file from file system
        byte imageData[] = new byte[(int) file.length()];
        imageInFile.read(imageData);
        base64Image = Base64.encodeBase64String(imageData).toString();
        System.out.println(base64Image);
    } catch (FileNotFoundException e) {
        System.out.println("Image not found" + e);
    } catch (IOException ioe) {
        System.out.println("Exception while reading the Image " + ioe);
    }
    return base64Image;
}
/**
* --------------------------------Method------------------------------
* Method Name: < enterValueIntoTextField > 
* Description: <This method will verify the text>
* Author: <Chandra Reddy K > 
* Created Date: < 09/05/2017 > 
* Modified By and On: < >
* Modified Comments: < >
* --------------------------------------------------------------------
* 
*/
public void enterValueIntoTextField(WebElement ObjectName,String TextFieldName,String Value) throws Exception
{
  
  try
  {		
	 
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].style.border='2px groove red'", ObjectName);
	  if(ObjectName.isEnabled() ==true && ObjectName.isDisplayed() ) {
		  js.executeScript("arguments[0].style.border=''", ObjectName);
		  ObjectName.clear();
		  ObjectName.sendKeys(Value);
	  }else {
		  scrnshtPthNm=scrnshtPth+TextFieldName+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
			test.log(LogStatus.FAIL, "Enter a value into"+TextFieldName, "the given field("+TextFieldName+") is not displayed/disabled "+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

		  
	  }
	  
  }catch (Exception e)
  {scrnshtPthNm=scrnshtPth+TextFieldName+".jpg";
  	getscrnSht.getscreenshot(driver,scrnshtPthNm );
	test.log(LogStatus.FAIL, "Enter a value into"+TextFieldName, "the given field("+TextFieldName+") is not displayed/disabled"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	  
  }

}

/**
* --------------------------------Method------------------------------
* Method Name: < URLverification > 
* Description: <This method will validate the url>
* Author: <Chandra Reddy K > 
* Created Date: < 09/05/2017 > 
* Modified By and On: < >
* Modified Comments: < >
* --------------------------------------------------------------------
* @throws Exception 
*/
public void URLverification(String url,String CookieURL) throws Exception
{
try{
	driver.get(CookieURL);
	Thread.sleep(500);
	driver.get(url);

		test.log(LogStatus.PASS, "Enter the URL", "Application invoked successfully");

	
}catch(Exception e){
	try {driver.get(CookieURL);

	driver.get(url);

		test.log(LogStatus.PASS, "Enter the URL", "Application invoked successfully");

	
	}catch(Exception E){
		 scrnshtPthNm=scrnshtPth+"url.jpg";
		 getscrnSht.getscreenshot(driver,scrnshtPthNm );
		test.log(LogStatus.FAIL, "verify the page", "page is not opened"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	  
	}
}
}
/**
* --------------------------------Method------------------------------
* Method Name: < IMGValidation> 
* Description: <This method will validate the url>
* Author: <Chandra Reddy K > 
* Created Date: < 09/05/2017 > 
* Modified By and On: < >
* Modified Comments: < >
* --------------------------------------------------------------------
* @throws InterruptedException 
*/


public boolean IMGValidation(WebElement element,String actual,String Expected,String ObjectName) throws Exception

{

try{
if(element.isDisplayed()){
	test.log(LogStatus.PASS, actual, Expected);

} else {
	 scrnshtPthNm=scrnshtPth+ObjectName+".jpg";
	 getscrnSht.getscreenshot(driver,scrnshtPthNm );
	test.log(LogStatus.FAIL, actual, "The given object is not identified in the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

}

}catch(AssertionError exception)
{
	scrnshtPthNm=scrnshtPth+ObjectName+".jpg";
	 getscrnSht.getscreenshot(driver,scrnshtPthNm );
	test.log(LogStatus.FAIL, actual, "The given object is not identified in the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	return false;
}
return true;

}

/**
* --------------------------------Method------------------------------
* Method Name: < closePopUP> 
* Description: <This method will close the unexpected Popups>
* Author: <Chandra Reddy K > 
* Created Date: < 16/05/2017 > 
* Modified By and On: < >
* Modified Comments: < >
* --------------------------------------------------------------------
* @throws InterruptedException 
*/

public void UnExpectedPopup(WebElement element)
{
try {
	
	element.click();
	test.log(LogStatus.INFO, "unexpected popup closed");
}catch(Exception e){

	
}

}
/**
* --------------------------------Method------------------------------
* Method Name: < clickOnButton > 
* Description: <This method will click the button>
* Author: <Chandra Reddy K > 
* Created Date: < 09/05/2017 > 
* Modified By and On: < >
* Modified Comments: < >
* --------------------------------------------------------------------
* @throws Exception 
*/

public void clickOnButton(WebElement ObjectName,String butttonname) throws Exception
{
  
  try
  {		
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].style.border='2px groove red'", ObjectName);

	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ObjectName);
	  if(ObjectName.isDisplayed() && ObjectName.isEnabled()) {
		  try{
			  js.executeScript("arguments[0].click();",ObjectName); 
		  }catch(Exception e){
			  
			  ObjectName.click();
		  }
			 
	  }else {
		  scrnshtPthNm=scrnshtPth+butttonname+".jpg";
			 getscrnSht.getscreenshot(driver,scrnshtPthNm );
			test.log(LogStatus.FAIL, butttonname, "The given button is not identified in the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	  }

	  
  }catch (Exception e)
  {scrnshtPthNm=scrnshtPth+butttonname+".jpg";
	 getscrnSht.getscreenshot(driver,scrnshtPthNm );
	test.log(LogStatus.FAIL, butttonname, "The given button is not identified in the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

}
}

public void linktextExist(WebElement ObjectName,String linktextname) throws Exception
{

try
  {		
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].style.border='2px groove red'", ObjectName);
	  if(ObjectName.isDisplayed() && ObjectName.isEnabled()) {
		 
		  js.executeScript("arguments[0].style.border=''", ObjectName);
		  
	  }else {
		  scrnshtPthNm=scrnshtPth+linktextname+".jpg";
			 getscrnSht.getscreenshot(driver,scrnshtPthNm );
			test.log(LogStatus.FAIL, linktextname, "the given link text("+linktextname+")"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	  }

	  
  }catch (Exception e)
  {scrnshtPthNm=scrnshtPth+linktextname+".jpg";
	 getscrnSht.getscreenshot(driver,scrnshtPthNm );
	 test.log(LogStatus.FAIL, linktextname, "the given link text("+linktextname+")"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

  }


}

public void SetValueAttribute(WebElement webElement,String attributename) {

JavascriptExecutor e = (JavascriptExecutor) driver;
e.executeScript("arguments[0].setAttribute('"+attributename+"','')",webElement);

}
public void getUrlAsVariables(String URL){
	
	String Urlvariables[]=URL.split("//.");
	EnvironmentName=Urlvariables[0];
	ApplicationName=Urlvariables[1];
}
public String changeUrlEnvironment()
{	String currenturl=driver.getCurrentUrl();
	if(!EnvironmentName.contains(currenturl)){
		String Urlvariables[]=currenturl.split("\\.");
		currenturl=EnvironmentName;
		for(int url=1;url<Urlvariables.length;url++){
			currenturl=currenturl+"."+Urlvariables[url];
		}
	}
	return currenturl;
}
public String changeUrlApplication()
{	String currenturl=driver.getCurrentUrl();
	if(!applicationname.contains(currenturl)){
		String Urlvariables[]=currenturl.split("\\.");
		currenturl="";
		for(int url=0;url<Urlvariables.length;url++){
			if(url==1){
				currenturl=currenturl+"."+applicationname;
				continue;
			}
			currenturl=currenturl+"."+Urlvariables[url];
		}
	}
	return currenturl;
}
/**
 * --------------------------------Method------------------------------
 * Method Name: < VerifyPartialText > 
 * Description: <This method will verify the text>
 * Author: <Chandra Reddy K > 
 * Created Date: < 24/07/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 */
public void  VerifyPartialText(WebElement element,String Expected, String objectname,String attributename) throws Exception{
try {if(element.isDisplayed())
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].style.border='2px groove red'", element);
	if(attributename.contains("Yes"))
	{
		String actual=element.getText();
		actual=actual.replaceAll("[\\D]", "");
		  if(actual.contains(Expected))
		  {
			  js.executeScript("arguments[0].style.border=''", element);
			  test.log(LogStatus.PASS,"Verify the  text"+Expected, "Text has been verified successfully.");
		  }
		  else {
			  scrnshtPthNm=scrnshtPth+objectname+".jpg";
			  getscrnSht.getscreenshot(driver,scrnshtPthNm );
			  test.log(LogStatus.FAIL, "Verify the text("+Expected+")", "actual text does't matched with  expected text"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

		  }
	 }
	  else
	   if(element.getText().contains(Expected)) {
		  js.executeScript("arguments[0].style.border=''", element);
		  test.log(LogStatus.PASS,"Verify the  text"+Expected, "Text has been verified successfully.");
	  }
		  
	  else {
		  scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Verify the text("+Expected+")", "actual text does't matched with  expected text"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	  }
	  }}catch(Exception exception) {
		  scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Verify the text for the ("+objectname+")", "the Given object ("+objectname+") is not displayed on the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	  }
}
/**
 * --------------------------------Method------------------------------
 * Method Name: < selectvaluefromdropdown > 
 * Description: <This method will select value  drop down >
 * Author: <Chandra Reddy K > 
 * Created Date: < 26/07/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 */
public void  selectValueFromDropDown(WebElement element,String dropdownvalue,String objectname,int index) throws Exception{
	
	try {
		Thread.sleep(2000);
		if(element.isDisplayed() && element.isEnabled()) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].style.border='2px groove red'", element);
	  Select dropDown=new Select(element);
	  if(dropdownvalue.equals("")){
		  dropDown.selectByIndex(index);  
	  }else{
	  dropDown.selectByVisibleText(dropdownvalue);
	  }
	  }else
		  {
		  scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Select the Drop down value ("+dropdownvalue+")", "Drop down  ("+objectname+") is not displayed/enabled on the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		  }
		}catch(Exception exception) {
		 
		  scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Select the Drop down value ("+dropdownvalue+")", "Drop down  ("+objectname+") value is not there"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		 }
	  }
public String  AddingdaysTocureentDate(int NumberofDays)
{

	Calendar c = Calendar.getInstance();
	c.setTime(new Date()); // Now use today date.
	c.add(Calendar.DATE, NumberofDays); // Adding  days
	String output = dateFormat.format(c.getTime());
	return dateFormat.format(c.getTime());
	
}
/**
 * --------------------------------Method------------------------------
 * Method Name: < gettingText > 
 * Description: <This method will get the text from the application based on web element  >
 * Author: <Chandra Reddy K > 
 * Created Date: < 28/07/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 */
public String  gettingText(WebElement element,String objectname) throws Exception{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].style.border='2px groove red'", element);
	try {
		if(element.isDisplayed() && element.isEnabled()) {

		objectname=element.getText();
	  }else
		  {
		  scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "get the text from the ("+objectname+")", "object ("+objectname+") is not displayed/enabled on the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		  }
		}catch(Exception exception) {
		 
		  scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "get the text from the("+objectname+")", "object ("+objectname+") is not there"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		 }
	return objectname;
	  }
/**
 * --------------------------------Method------------------------------
 * Method Name: < Disclaimer > 
 * Description: < this method will verify the disclaimers value and close button for the disclaimers popup>
 * Author: <Chandra Reddy K > 
 * Created Date: < 21/08/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 * @throws Exception 
 */
public void Disclaimers(String objectname) throws Exception
{
	String Expectedvalue,Disclaimername = null,Disclaimerdisc=null;
	String columnname=null;
	
	WebElement webelement=null;
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 int dis=0;
	try{
		
		Disclaimers=driver.findElements(By.xpath("//a[@data-disc='"+objectname+"']|//a[@data-disclosures-pop-over='"+objectname+"']"));
		columnname="Discloser_"+objectname;
		Expectedvalue=data.getExcelData(1, columnname, "LP_Disclaimer");
		Expectedvalue=Expectedvalue.replaceAll("\\s+","");
		Disclaimername=data.getExcelData(2, columnname, "LP_Disclaimer");
		Disclaimername=Disclaimername.replaceAll(objectname+".","");
		Expectedvalue=Disclaimername+Expectedvalue;
		Expectedvalue=Expectedvalue.replaceAll("\\s+","");
		Expectedvalue=Expectedvalue.replaceAll(":","");
		for(dis=0;dis<Disclaimers.size();dis++){
			if(Disclaimers.get(dis).getText().isEmpty())
				continue;
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",Disclaimers.get(dis) );
			Disclaimers.get(dis).click();
			Thread.sleep(1000);

				
				DisclaimbersPopUp=driver.findElements(By.xpath("//div[contains(@class,'popover')]"));
				for(int disp=0;disp<DisclaimbersPopUp.size();disp++){
					if(DisclaimbersPopUp.get(disp).getText().isEmpty())
						continue;
					
					Disclaimerdisc=DisclaimbersPopUp.get(disp).getText();
					break;
				}

				Disclaimerdisc=Disclaimerdisc.replaceAll("\\s+","");
				if(Disclaimerdisc.contains(objectname)){
					Disclaimerdisc=Disclaimerdisc.replaceAll(objectname+".","");
				}
			
			if(Expectedvalue.equalsIgnoreCase(Disclaimerdisc)){
				test.log(LogStatus.PASS, "Verify the Disclaimer value for :"+objectname+"."+Disclaimername, "given disclaimer text has  displayed as excepted");
				
			}else{
				webelement=(WebElement) ((JavascriptExecutor) driver)  
		        .executeScript("return arguments[0].parentNode;", Disclaimers.get(dis));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webelement);				
				  js.executeScript("arguments[0].style.border='2px groove red'", webelement);
				 scrnshtPthNm=scrnshtPth+objectname+dis+".jpg";
				 getscrnSht.getscreenshot(driver,scrnshtPthNm );
				test.log(LogStatus.FAIL, "Verify the Disclaimer value for :"+objectname+"."+Disclaimername, "given disclaimer("+Disclaimername+") text has not matched  as excepted"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			Disclaimerdisc=null;
			try {
			if(Disclaimers.get(dis).getAttribute("aria-describedby").contains("popover")){
		
				test.log(LogStatus.INFO, "Verify the Disclaimer close button for :"+objectname+"."+Disclaimername, "given disclaimer close button has been displayed");
				
			}}catch(Exception exception){
						webelement=(WebElement) ((JavascriptExecutor) driver)  
				        .executeScript("return arguments[0].parentNode;", Disclaimers.get(dis));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webelement);
						  js.executeScript("arguments[0].style.border='2px groove red'", webelement);
						  scrnshtPthNm=scrnshtPth+objectname+dis+"popover.jpg";
						 getscrnSht.getscreenshot(driver,scrnshtPthNm );
						test.log(LogStatus.FAIL, "Verify the Disclaimer close button for :"+objectname+"."+Disclaimername, "given disclaimer("+Disclaimername+") close button not displayed"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			
		}
		
	}catch(Exception exception) {

		 scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Verify the Disclaimer for:"+objectname+"."+Disclaimername, "given disclaimer ("+Disclaimername+")is not there in application"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		 }
}
/**
 * --------------------------------Method------------------------------
 * Method Name: < pageDisclaimers > 
 * Description: < this method will verify disclaimers page wise>
 * Author: <Chandra Reddy K > 
 * Created Date: < 21/08/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 * @throws Exception 
 */


public void Pagedisclaimers(String SheetName,int TotalNumber) throws Exception
{if(NonFuncational.equalsIgnoreCase("Yes")){
	try{
		test.log(LogStatus.INFO,"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style=background-color:yellow;> Disclaimers verification ");
		String disclaimer;
		int disclaimberscount=0;
		for(int disclaimers=0;disclaimers<=TotalNumber;disclaimers++){
			disclaimer=data.getExcelData(1, "Disclosures"+disclaimers, SheetName);

			libs.Disclaimers(disclaimer);
		}
}catch(Exception searchInventoryException){

	getscrnSht.getscreenshot(driver, scrnshtPth +SheetName+"_Failed_"+libs.datestamp()+".jpg");
	test.log(LogStatus.FAIL, searchInventoryException.getMessage(), test.addScreenCapture(scrnshtPth +"searchInventory_Failed_"+libs.datestamp()+".jpg") );
}
}
	}
/**
 * --------------------------------Method------------------------------
 * Method Name: < Disclosers > 
 * Description: < this method will verify the Discloser text>
 * Author: <Chandra Reddy K > 
 * Created Date: < 21/08/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 * @throws Exception 
 */
public void Disclosers() throws Exception
{	if(NonFuncational.equalsIgnoreCase("Yes")){
	test.log(LogStatus.INFO,"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style=background-color:yellow;> Disclosers verification ");
		int Discloser=0;
	String Expected,Actuval,diclosename=null;
	WebElement webelement=null;
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	try{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.linkText("Disclosures")));
		driver.findElement(By.linkText("Disclosures")).click();
		Disclosers=driver.findElements(By.xpath("//li[@class='disclosure_item']"));

		for(Discloser=0;Discloser<Disclosers.size();Discloser++){
			if(Disclosers.get(Discloser).getText().isEmpty())
				continue;
			
			if(Discloser<31){
				diclosename=data.getExcelData(2, "Discloser_"+(Discloser+1), "LP_Disclaimer");
			Expected=diclosename+data.getExcelData(1, "Discloser_"+(Discloser+1), "LP_Disclaimer"); 
				}else{
					diclosename=data.getExcelData(2, "Discloser_A"+(Discloser-29), "LP_Disclaimer");
				Expected=diclosename+data.getExcelData(1, "Discloser_A"+(Discloser-29), "LP_Disclaimer"); 
						}
			Expected=Expected.replaceAll("\\s+","");
			Actuval=Disclosers.get(Discloser).getText();
			Actuval=Actuval.replaceAll("\\s+","");
					
			if(Actuval.equalsIgnoreCase(Expected.trim())){
					test.log(LogStatus.PASS, "Verify the Discloser text("+diclosename+") :", "given discloser text has  displayed as excepted");
				}else{				
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Disclosers.get(Discloser));				
					  js.executeScript("arguments[0].style.border='2px groove red'", Disclosers.get(Discloser));
					 scrnshtPthNm=scrnshtPth+"discloser_"+Discloser+1+".jpg";
					 getscrnSht.getscreenshot(driver,scrnshtPthNm );
					 test.log(LogStatus.FAIL, "Verify the Discloser text :("+diclosename+")", "given discloser text has  not displayed as excepted"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
				
			}
			
		}
		driver.findElement(By.linkText("Disclosures")).click();
	}catch(Exception exception) {
		 scrnshtPthNm=scrnshtPth+"discloser_"+Discloser+1+".jpg";
		 getscrnSht.getscreenshot(driver,scrnshtPthNm );
		 test.log(LogStatus.FAIL, "Verify the Discloser text :", "given discloser text has  not displayed as excepted"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		 }}
}



/**
 * --------------------------------Method------------------------------
 * Method Name: < Disclaimer > 
 * Description: < this method will verify the disclaimers value and close button for the disclaimers popup>
 * Author: <Chandra Reddy K > 
 * Created Date: < 21/08/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 * @throws Exception 
 */
public void Iballs(String objectname) throws Exception
{
	String Expectedvalue,Disclaimername,Disclaimerdisc=null;
	String columnname=null;
	WebElement webelement=null;
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 int ibl=0;
	try{		
		webelement=driver.findElement(By.xpath("//a[@data-title='"+objectname+"']|//a[@data-ng-disc-header='"+objectname+"']|//a[@data-original-title='"+objectname+"']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",webelement);
		webelement.click();
		columnname=objectname;
		Expectedvalue=data.getExcelData(1, columnname, "I_Balls");
		Expectedvalue=Expectedvalue.replaceAll("\\s+","");

			
			Disclaimerdisc=	driver.findElement(By.xpath("//div[contains(@id,'popover')]|//SPAN[@data-ng-bind='flip.discText']")).getText();
			Disclaimerdisc=Disclaimerdisc.replaceAll("\\s+","");
			if(Disclaimerdisc.equalsIgnoreCase(Expectedvalue)){
				test.log(LogStatus.PASS, "Verify the Iball value for :"+objectname, "given Iball text has  displayed as excepted");
			}else{
				webelement=(WebElement) ((JavascriptExecutor) driver)  
		        .executeScript("return arguments[0].parentNode;", Disclaimers.get(ibl));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webelement);				
				  js.executeScript("arguments[0].style.border='2px groove red'", webelement);
				 scrnshtPthNm=scrnshtPth+objectname+ibl+".jpg";
				 getscrnSht.getscreenshot(driver,scrnshtPthNm );
				test.log(LogStatus.FAIL, "Verify the Iball value for :"+objectname, "given Iball("+objectname+") text has not matched  as excepted"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			try {
			if(webelement.getAttribute("aria-describedby").contains("popover") | driver.findElement(By.xpath("//span[@class='icon-closer-blue-new pull-right']")).isDisplayed()){
		
				test.log(LogStatus.INFO, "Verify the Iball close button for :"+objectname, "given Iball close button has been displayed");
				
			}}catch(Exception exception){
						webelement=(WebElement) ((JavascriptExecutor) driver)  
				        .executeScript("return arguments[0].parentNode;", Disclaimers.get(ibl));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webelement);
						  js.executeScript("arguments[0].style.border='2px groove red'", webelement);
						  scrnshtPthNm=scrnshtPth+objectname+ibl+"popover.jpg";
						 getscrnSht.getscreenshot(driver,scrnshtPthNm );
						test.log(LogStatus.FAIL, "Verify the Iball close button for :"+objectname, "given Iball("+objectname+") close button not displayed"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
			}
			
		
		
	}catch(Exception exception) {
		 scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Verify the Iball:"+objectname, "given Iball is not there in application"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );
		 }
}
/**
 * --------------------------------Method------------------------------
 * Method Name: < GlobalHeadingBar > 
 * Description: < this method will verify Global head is present or not in the pages>
 * Author: <Chandra Reddy K > 
 * Created Date: < 07/09/2017 (dd/mm/yyyy> 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 * @throws Exception 
 */


public void GlobalHeadingBar() throws Exception
{
	if(NonFuncational.equalsIgnoreCase("Yes")){
		
		
	try{
		test.log(LogStatus.INFO,"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style=background-color:yellow;> Global Heading verification ");	
		if(driver.findElement(By.id("bs-example-navbar-collapse-1")).isDisplayed()){
		
			test.log(LogStatus.PASS, "Verify Global Heading menu bar","Gloabl heading menu bar has been displayed" );	
		}
}catch(Exception searchInventoryException){

	getscrnSht.getscreenshot(driver, scrnshtPth +"Gobalheading_Failed_"+libs.datestamp()+".jpg");
	test.log(LogStatus.FAIL, "Verify Global Heading", test.addScreenCapture(scrnshtPth +"searchInventory_Failed_"+libs.datestamp()+".jpg") );
}
}
	}
/**
 * --------------------------------Method------------------------------
 * Method Name: < GlobalHeadingBar > 
 * Description: < this method will verify Global head is present or not in the pages>
 * Author: <Chandra Reddy K > 
 * Created Date: < 07/09/2017 (dd/mm/yyyy> 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 * @throws Exception 
 */


public void GlobalBottomBar() throws Exception
{
	if(NonFuncational.equalsIgnoreCase("Yes")){
	try{
		test.log(LogStatus.INFO,"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style=background-color:yellow;> Global Bottom bar verification ");
		if(driver.findElement(By.xpath("//footer[@class='container-fluid global-footer']")).isDisplayed()){
		
			test.log(LogStatus.PASS, "Verify global Bottom  bar","Gloabl Bottom  bar has been displayed" );	
		}
}catch(Exception searchInventoryException){

	getscrnSht.getscreenshot(driver, scrnshtPth +"Gobalheading_Failed_"+libs.datestamp()+".jpg");
	test.log(LogStatus.FAIL, "Verify Global Bottom", test.addScreenCapture(scrnshtPth +"searchInventory_Failed_"+libs.datestamp()+".jpg") );
}
}
	}
/**
 * --------------------------------Method------------------------------
 * Method Name: < VerifyText > 
 * Description: <This method will verify the text>
 * Author: <Chandra Reddy K > 
 * Created Date: < 16/05/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 */
public void  VerifyTextwithAttribute(WebElement element,String Expected, String objectname,String attributename) throws Exception{
	
	try {if(element.isDisplayed()) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].style.border='2px groove red'", element);
//	  element.click();
	  if(element.getAttribute(attributename).equalsIgnoreCase(Expected)){
		  js.executeScript("arguments[0].style.border=''", element);
		  test.log(LogStatus.PASS,"Verify the  text/Number("+Expected+")", "Text/Number has been verified successfully.");

		  
	  } else {
		  scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Verify the Text/Number("+Expected+")", "actual Text/Number does't matched with  expected text"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );


	  }
	  }}catch(Exception exception) {
		  scrnshtPthNm=scrnshtPth+objectname+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Verify the Text/Number for the ("+objectname+")", "the Given object ("+objectname+") is not displayed on the page"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );


	  }
}
/**
 * --------------------------------Method------------------------------
 * Method Name: < UnexpectedPopup > 
 * Description: <This method will close Unexpected Pop up >
 * Author: <Chandra Reddy K > 
 * Created Date: < 09/12/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 */
public void UnexpectedPopup()
{
	try{
		PGO_landing_page.img_UnexeptedcloseDialog(driver).click();
	}catch(Exception e){
		System.out.println("unexpected pop up not appeared ");
	}
}
/**
 * --------------------------------Method------------------------------
 * Method Name: < tabList > 
 * Description: <This method will verify tab List text>
 * Author: <Chandra Reddy K > 
 * Created Date: < 09/13/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 * @throws Exception 
 */
public void tabList(String pagename) throws Exception
{
	componenttHeading("tab Container");
	try{
		String Tablistname=null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		TabList=driver.findElements(By.xpath("//div[@class='tab-header row']//ul[@class='tab-list']//li"));
		for(int Tlist=0;Tlist<TabList.size();Tlist++){
			Tablistname=data.getExcelData(1,TabList.get(Tlist).getText(),"Vehicle Details");
			js.executeScript("arguments[0].style.border='2px groove red'", TabList.get(Tlist));
			if(Tablistname.equalsIgnoreCase(TabList.get(Tlist).getText())){
				js.executeScript("arguments[0].style.border=''", TabList.get(Tlist));
				  test.log(LogStatus.PASS,"Verify the  Tab list text", "Text ("+Tablistname+") has been verified successfully.");
	
			}else{
				test.log(LogStatus.FAIL,"Verify the  Tab list text", "Text ("+Tablistname+") has not displayed.");
			}
		}
		
		
	}catch(Exception exception) {
		  scrnshtPthNm=scrnshtPth+"tablist.jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, "Verify the Tab list for the ("+pagename+")", "the Given Tab list is not displayed for the page of ("+pagename+") "+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	  }
	
}

public void componenttHeading(String Componentname){
	test.log(LogStatus.INFO,"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b style=background-color:yellow;>  "+ Componentname);
}

public String getStringFromAlphaNumaric(String name,String retrun){
		
	switch(retrun)
	{ 
		case "string":	return name.replaceAll("[^a-z^A-Z?!\\.]","");
						
		case "number":  return name.replaceAll("[^0-9?!\\.]",""); 
	
	}
	return "worng input";
	
}

/**
 * --------------------------------Method------------------------------
 * Method Name: < TextCompare > 
 * Description: <This method will compare the text >
 * Author: <Chandra Reddy K > 
 * Created Date: < 10/11/2017 > 
 * Modified By and On: < >
 * Modified Comments: < >
 * --------------------------------------------------------------------
 */
public void  TextCompare(String actuval,String Expected,String actuvalstep , String expectedstep ) throws Exception{
	
	
	  if(actuval.equalsIgnoreCase(Expected)) {
		
		  test.log(LogStatus.PASS,actuvalstep, expectedstep);
	  } else {
		  scrnshtPthNm=scrnshtPth+Expected+".jpg";
		  getscrnSht.getscreenshot(driver,scrnshtPthNm );
		  test.log(LogStatus.FAIL, actuvalstep, "actual text does't matched with  expected text"+test.addScreenCapture(Screenpathforreport(scrnshtPthNm)) );

	  }
	
}


/** --------------------------------Method------------------------------
* Method Name: < DateDifference > 
* Description: <This method will provide the current date in the required format.  >
* Author: <Nagendra T S > 
* Created Date: < 10/27/2017 > 
* Modified By and On: < >
* Modified Comments: < >
* --------------------------------------------------------------------*/
public String  DateDifference(String Value,int NoOfDays,SimpleDateFormat formatter ) throws Exception{
	
	String formatedDate="";
	if(Value.equalsIgnoreCase("Format"))
	{
		SimpleDateFormat formater = new SimpleDateFormat("dd");
		int data = Integer.parseInt(formater.format(date));
		System.out.println(data);
		if(data<9)
		{
			SimpleDateFormat formaterr = new SimpleDateFormat("MMM d, YYYY");
			return formaterr.format(date);
		}
		else
		{
			SimpleDateFormat formaterr = new SimpleDateFormat("MMM dd, YYYY");
			return formaterr.format(date);
		}
	}
	
	
	return formatedDate;
}


}


