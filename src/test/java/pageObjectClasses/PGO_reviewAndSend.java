package pageObjectClasses;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import libraryClasses.FuncitonLibrary;
public class PGO_reviewAndSend extends FuncitonLibrary
{
private static WebElement element = null;
private static List<WebElement> elements = null;

public static WebElement txt_firstName (WebDriver driver)
{
try
{
  element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.firstName']"));
  libs.HighlightElement(driver, element);
}
catch(Exception e)
{ 		
	System.out.println("txt_firstName"); 	
}   return element;
}
public static WebElement txt_lastName (WebDriver driver)
{
try
{
 element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.lastName']"));
 libs.HighlightElement(driver, element);
}
catch(Exception e)
{ 		
	System.out.println("txt_lastName"); 
}
return element;
}
public static WebElement txt_email (WebDriver driver)
{
 try
 {
   element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.email']"));
   libs.HighlightElement(driver, element);
 }
 catch(Exception e)
 {
	 System.out.println("txt_email");
 }
 return element;
 }
public static WebElement txt_phone (WebDriver driver)
{
  try
  {
   	element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.phone']"));
	libs.HighlightElement(driver, element);
	}
  catch(Exception e)
  { 		
	  System.out.println("txt_phone"); 
  } 
  return element;
  }
public static WebElement txt_desiredDate (WebDriver driver)
{
  try
  {
	element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.testDrive.desiredDate']"));
	libs.HighlightElement(driver, element);
  }
  catch(Exception e)
  { 		
	 System.out.println("txt_desiredDate"); 	
  } 
  return element;
}
public static WebElement txt_desiredTime (WebDriver driver)
{
  try
  {
	element =driver.findElement(By.xpath("//select[@data-ng-model='ctrl.dealFactory.deal.testDrive.desiredTime']"));
	libs.HighlightElement(driver, element);
  }
  catch(Exception e)
  {
	  System.out.println("txt_desiredTime"); 
  } return element;
}
public static WebElement btn_sendMyDeal (WebDriver driver)
{
  try
  {
	element =driver.findElement(By.xpath("//button[@class='send-to-dealer-submit'][@type='submit']"));
	libs.HighlightElement(driver, element);
	}
  catch(Exception e)
  { 		
	  System.out.println("btn_sendMyDeal");
  }
  return element;
}
public static WebElement txt_dealSentTime (WebDriver driver)
{
 try
 {
  element =driver.findElement(By.xpath("//p[@class='sent-date ng-binding']"));
  libs.HighlightElement(driver, element);
 }
 catch(Exception e)
 {
	 System.out.println("txt_dealSentTime"); 
 }
  return element;
 }
public static WebElement txt_dealNo (WebDriver driver)
{
 try
 {
  element =driver.findElement(By.xpath("//section [@class='deal-submitted']/p[2]"));
  libs.HighlightElement(driver, element);
 }
 catch(Exception e)
 { 	
	 System.out.println("txt_dealNo"); 	
 }
 return element;
}
public static List<WebElement> txt_yourTestDriveLabels (WebDriver driver)
{
  try 
  {
   elements =driver.findElements(By.xpath("(//section[@id='testDrive'])[position()=1]//div[@class='dre-accordion-content']//table[@class='details ruled ng-scope']//tbody//tr//th"));
   libs.HighlightElement(driver, element);
  }
  catch(Exception e)
  {
	  System.out.println("txt_yourTestDriveLabels");
  }
  return elements;
}
public static List<WebElement> txt_yourTestDriveValues (WebDriver driver)
{
  try
  {
   elements =driver.findElements(By.xpath("(//section[@id='testDrive'])[position()=1]//div[@class='dre-accordion-content']//table[@class='details ruled ng-scope']//tbody//tr//td"));
   libs.HighlightElement(driver, element);
  }
  catch(Exception e)
  {
	  System.out.println("txt_yourTestDriveLabels");
  }
  return elements;
}
public static WebElement heading(WebDriver driver)
{
  try
   {
	  element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/h1"));
      libs.HighlightElement(driver, element);	
    }
  catch(Exception e)
  { 
	  System.out.println("heading");
  } 
  return element;
}
public static WebElement subHeading(WebDriver driver)
{
  try
  {
	element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/p"));
    libs.HighlightElement(driver, element);	}
  catch(Exception e)
  {
	System.out.println("subHeading"); 	
  } 
  return element;
  }
public static WebElement totMsrpDreicon(WebDriver driver,int position)
{
  try
  {
	element=driver.findElement(By.xpath("(//section[@id='yourVehicle'])[position()="+position+"]//div[@class='dre-accordion-content']//table[@class='price striped ng-scope']//tbody//tr[4]/td//span"));
	libs.HighlightElement(driver, element);	
  }
  catch(Exception e)
  { 	
	 System.out.println("totMsrpDreicon"); 
  }
  return element;
}
public static WebElement txt_Vehicleaccordion(WebDriver driver,int position)
{
  try
  {
	element=driver.findElement(By.xpath("(//small[@class='ng-scope']/p)[position()="+position+"]"));
	libs.HighlightElement(driver, element);
  }
  catch(Exception e)
  {
	  System.out.println("txt_Vehicleaccordion"); 
  }
  return element;
}
public static WebElement tradeinVehicleModel(WebDriver driver,int position)
{
  try
  {
	element=driver.findElement(By.xpath("(//div[@class='trade-in-complete ng-scope'])[position()="+position+"]/div/h2"));
	libs.HighlightElement(driver, element);	
  }
  catch(Exception e)
  { 	
	  System.out.println("tradeinVehicleModel"); 
  }
  return element;
}
public static List<WebElement> tradeinVehicleDetailsLabel(WebDriver driver,int position)
{
  try
  {
      elements=driver.findElements(By.xpath("(//div[@class='trade-in-complete ng-scope'])[position()="+position+"]//div//table//tbody//tr/th"));
	  libs.HighlightElement(driver, element);
  }
  catch(Exception e)
  { 	
	   System.out.println("tradeinVehicleDetailsLabel"); 
  }
return elements;
}
public static List<WebElement> tradeinVehicleDetails(WebDriver driver,int position)
{
	try
	{
      elements=driver.findElements(By.xpath("(//div[@class='trade-in-complete ng-scope'])[position()="+position+"]//div//table//tbody//tr/td"));
	  libs.HighlightElement(driver, element);	
	}
	catch(Exception e)
	 { 	
	   System.out.println("tradeinVehicleDetails"); 
	  }
	return elements;
}
public static WebElement vehicleModel(WebDriver driver,int position)
{
  try
  {
	element=driver.findElement(By.xpath("(//section[@id='yourVehicle'])[position()="+position+"]//div[@class='dre-accordion-content']/h2"));
	libs.HighlightElement(driver, element);
  }
  catch(Exception e)
  {
	  System.out.println("vehicleModel");
  }
  return element;
}
public static WebElement protectionNote(WebDriver driver)
{
	try
	{
	  element=driver.findElement(By.xpath("(//section[@id='protect'])[position()=2]//div[@class='dre-accordion-content']//p[@class='ng-scope']"));
      libs.HighlightElement(driver, element);
    }
	catch(Exception e)
	{
		System.out.println("protectionNote"); 	
	}
	return element;
	}
	public static List<WebElement> protectionPlans(WebDriver driver)
	 {
	  try
	  {
	   	elements=driver.findElements(By.xpath("//div[@class='protection-plan-text col-sm-6']"));
	   	libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
		{
			System.out.println("protectionPlans"); 	
		}
	  return elements;
	  }
	public static List<WebElement> vehicleLabels(WebDriver driver,int position)
	 {
	  try
	  {
	    elements=driver.findElements(By.xpath("(//section[@id='yourVehicle'])[position()="+position+"]//div[@class='dre-accordion-content']/table[@class='details ruled ng-scope']/tbody/tr/th"));
	    libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
		{
			System.out.println("vehicleLabels"); 	
		}
	  return elements;
	  }
   	public static List<WebElement> vehicleDetails(WebDriver driver,int position)
	 { 
   		try
   		{
   		 elements=driver.findElements(By.xpath("(//section[@id='yourVehicle'])[position()="+position+"]//div[@class='dre-accordion-content']/table[@class='details ruled ng-scope']/tbody/tr/td"));
   		 libs.HighlightElement(driver, element);
	    }
   		catch(Exception e)
		{
			System.out.println("vehicleDetails"); 	
		}
	  return elements;
	  }
	public static List<WebElement> priceDetails(WebDriver driver,int position)
	 { 
		try
		{
	     elements=driver.findElements(By.xpath("(//section[@id='yourVehicle'])[position()="+position+"]//div[@class='dre-accordion-content']//table[@class='price striped ng-scope']/tbody/tr//td"));
	     libs.HighlightElement(driver, element);
	    }
		catch(Exception e)
		{
			System.out.println("priceDetails"); 	
		}
	  return elements;
	  }
	
	public static List<WebElement> priceDetailsLabels(WebDriver driver,int position)
	 { 
	  try 
	  {
	   	elements=driver.findElements(By.xpath("(//section[@id='yourVehicle'])[position()="+position+"]//div[@class='dre-accordion-content']//table[@class='price striped ng-scope']/tbody/tr"));
	   	libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
		{
			System.out.println("priceDetailsLabels"); 	
		}
	  return elements;
	  }
	public static WebElement paymentType(WebDriver driver)
	 {
	  try
	  {
 		element=driver.findElement(By.xpath("//section/section[@class='payment dre-accordion ng-scope']/div[2]/table/tbody/tr[1]/td"));
 		libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  { 	
		  System.out.println("paymentType");
	  }
	  return element;	
	}
	public static List<WebElement> paymentDetailsHeading(WebDriver driver)
	 { 
	  try
	  {
	   elements=driver.findElements(By.xpath("//div[@class='price striped']//th"));
	   libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  { 	
		  System.out.println("paymentDetailsHeading");
	  }
	  return elements;
	}
	public static List<WebElement> paymentDetails(WebDriver driver)
	 { 
	  try
	  {
	   elements=driver.findElements(By.xpath("//div[@class='price striped']//th"));
	   libs.HighlightElement(driver, element);	
	  }
	  catch(Exception e)
	  { 	
		  System.out.println("paymentDetails");
	  }
	  return elements;
	}
   public static WebElement dealerInformationHeading(WebDriver driver)
	 {
	   try
	   {
	     element=driver.findElement(By.xpath("//section[@id='dealerInformationBlock']/h2"));
	     libs.HighlightElement(driver, element);	
	   }
   catch(Exception e)
	  { 	
		  System.out.println("dealerInformationHeading");
	  }
	  return element;
	}
	public static WebElement dealerAddress(WebDriver driver)
	 { 
		try
		{
		  element=driver.findElement(By.xpath("//section[@id='dealerInformationBlock']/address"));
          libs.HighlightElement(driver, element);	}
		catch(Exception e)
		{
			System.out.println("dealerAddress"); 	
		}
		return element;
	}
	public static WebElement directions(WebDriver driver)
	 { 
	  try
	  {
		element=driver.findElement(By.xpath("//section[@id='dealerInformationBlock']/a"));
    	libs.HighlightElement(driver, element);	
      }
	  catch(Exception e)
	  {
		 System.out.println("directions"); 
	  } return element;
	}
	public static WebElement dealerlocationMap(WebDriver driver)
	 { 
		try 
		{
		 element=driver.findElement(By.xpath("//section[@id='dealerInformationBlock']/img"));
    	 libs.HighlightElement(driver, element);	
    	}
		catch(Exception e)
		{
			System.out.println("dealerlocationMap");
	    } return element;
	}
	public static WebElement pledgeIcon(WebDriver driver)
	 { 
		try
		{
	     element=driver.findElement(By.xpath("//I[@class='icon-pledge']"));
		 libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{ 
			System.out.println("pledgeIcon"); 	
		}
		return element;
	}
	public static WebElement pledgeHeading(WebDriver driver)
	 {
	  try
	  {
	   element=driver.findElement(By.xpath("//section[@id='ourPledge']/h2"));
	   libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  {
		System.out.println("pledgeHeading"); 	
	  }
	  return element;
	}
	public static WebElement pledge(WebDriver driver)
	{ 
	 try
	  {
	   element=driver.findElement(By.xpath("//section[@id='ourPledge']/p"));
	   libs.HighlightElement(driver, element);	
	  }
	 catch(Exception e)
	 { 		
	   System.out.println("pledge"); 
	  } return element;
	 }
	public static WebElement savePrintHeading(WebDriver driver)
	 { 
		try
		{
		  element=driver.findElement(By.xpath("//section[@id='saveAndPrint']/h2"));
          libs.HighlightElement(driver, element);	
        }
		catch(Exception e)
		{
		  System.out.println("savePrintHeading"); 
		}
		return element;
	}
	public static WebElement savePrintText(WebDriver driver)
	 { 
		try
		{
	     element=driver.findElement(By.xpath("//section[@id='saveAndPrint']/div/p"));
         libs.HighlightElement(driver, element);	
        }
		catch(Exception e)
		{
			System.out.println("savePrintText"); 
		}
		return element;
	}
	public static WebElement printMyDealLink(WebDriver driver)
	 { 
		try
		{
	     element=driver.findElement(By.xpath("//section[@id='saveAndPrint']/button"));
     	 libs.HighlightElement(driver, element);
     	 }
		catch(Exception e)
		{
		  System.out.println("printMyDealLink"); 
		}
		return element;
	}
	public static WebElement afterdealMessageheading(WebDriver driver)
	 { 
	  try
	  {
		  element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/h1"));
	      libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  {
		 System.out.println("btn_nopopup"); 
	  }
	  return element;
	}
	public static WebElement afterdealMessage(WebDriver driver)
	 { 
	try
	  {
	  element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/p"));
	  libs.HighlightElement(driver, element);
	  }
	 catch(Exception e)
	 {
		System.out.println("afterdealMessage");
	 }
	 return element;
	}
	public static WebElement afterdealPrintbutton(WebDriver driver)
	 {
	  try
	  {
	    element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/button"));
	    libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  {
		System.out.println("afterdealPrintbutton");
	  }
	  return element;
	}
	public static WebElement editButton(WebDriver driver)
	 { 
	  try
	  {
		WebDriverWait wait=new WebDriverWait(driver,90);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
	    libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  {
		System.out.println("editButton");
	  }
	  return element;
	}
	public static WebElement skipTradeinHeading(WebDriver driver)
	 { 
		try
		{
		element = driver.findElement(By.xpath("(//div[@class='trade-in-incomplete ng-scope'])[position()=2]//h2"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
		  System.out.println("skipTradeinHeading"); 	
		}
		return element;
	}
	public static WebElement skipTradeinText(WebDriver driver)
	 { 
		try
		{
		element = driver.findElement(By.xpath("(//div[@class='trade-in-incomplete ng-scope'])[position()=2]//p[1]"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
		System.out.println("skipTradeinText"); 
		}
		return element;
	}
	public static WebElement valueTradein(WebDriver driver)
	 { 
	  try
	  {
		element = driver.findElement(By.xpath("(//div[@class='trade-in-incomplete ng-scope'])[position()=2]//p/button"));
		libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  {
		System.out.println("valueTradein"); 
	  }
	  return element;
	}
	public static WebElement skipPaymentHeading(WebDriver driver)
	 { 
	  try
	  {
		element = driver.findElement(By.xpath("(//section[@id='paymentSummary'])[position()=2]//h2"));
		libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  {
		 System.out.println("skipPaymentHeading");
	  }
	  return element;
	}
	public static WebElement skipPaymentText(WebDriver driver)
	 { 
		try
		{
		 element = driver.findElement(By.xpath("(//section[@id='paymentSummary'])[position()=2]//div[@class='dre-accordion-content']//p[@class='ng-hide']"));
		 libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
		  System.out.println("skipPaymentText"); 
		}
		return element;
	}
	public static WebElement payment(WebDriver driver)
	 { 
	  try
	  {
		element = driver.findElement(By.xpath("(//section[@id='paymentSummary'])[position()=2]//div[@class='dre-accordion-content']//p//button"));
		libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  { 
		System.out.println("payment");
	  }
	  return element;
	}
	public static WebElement dealSubmissionHeading (WebDriver driver)
	{
	 try
	 {
	   element = driver.findElement(By.xpath("//header[@data-ng-show='dealFactory.sendDealNowError == false']/h1"));
	   libs.HighlightElement(driver, element);
	 }
	 catch(Exception e)
	 {
		System.out.println("dealSubmissionHeading");
	 }
	 return element;
	 }
	 public static WebElement dealSubmissionText (WebDriver driver)
	  { 
		try
		{
		element = driver.findElement(By.xpath("//header[@data-ng-show='dealFactory.sendDealNowError == false']/p"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
		  System.out.println("dealSubmissionText"); 	
		}
		return element;
	 }
	 public static WebElement afterdealSubmissionText (WebDriver driver)
	  { 
		try
		{
		element = driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/p"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
		  System.out.println("afterdealSubmissionText"); 	
		}
		return element;
	 }
	 public static WebElement viewandPrintmydeal (WebDriver driver)
	  { 
		 try
		 {
		   element = driver.findElement(By.xpath("//section[@class='whatHappensNext']//button"));
		   libs.HighlightElement(driver, element);
		 }
		 catch(Exception e)
		 {
		    System.out.println("btn_nopopup"); 
		 }
		 return element;
	 }
	public static WebElement btn_reviewAndSend(WebDriver driver)
	{ 
	 try
	 {
			
		element=driver.findElement(By.linkText("Next: Review & Send"));
		libs.HighlightElement(driver, element);
	  }
	 catch(Exception e)
	 {
		System.out.println("btn_reviewAndSend"); 
	 }
	 return element;
	}
	public static List<WebElement> paymentDetailsLabels (WebDriver driver)
	{
	  try
	  {
       	elements = driver.findElements(By.xpath("(//div[@class='price striped'])[position()=2]//th"));
		libs.HighlightElement(driver, element);
	  }
	  catch(Exception e)
	  {
		System.out.println("btn_reviewAndSend"); 
	  }
		return elements;
	 }
	 public static List<WebElement> paymentDetailsValues (WebDriver driver)
	  { 
		try
		{
	    elements = driver.findElements(By.xpath("(//div[@class='price striped'])[position()=2]//th"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
		  System.out.println("btn_reviewAndSend"); 
		}
			return elements;
		 }
	 public static WebElement estimatedTaxesDreicon(WebDriver driver)
		 { 
		 try
		 {
		  element=driver.findElement(By.xpath("(//div[@class='price striped'])[position()=2]//tr/td[@class='cps-icon']//span"));
          libs.HighlightElement(driver, element);
         }
		 catch(Exception e)
		 {
			 System.out.println("estimatedTaxesDreicon"); 
		 }
		 return element;
		}
		public static WebElement applyforCredit(WebDriver driver)
	    {
		  try
		  {
			element=driver.findElement(By.xpath("//button[@class='apply-for-credit-submit']"));
			libs.HighlightElement(driver, element);	
		  }
		  catch(Exception e)
		  { 	
			 System.out.println("btn_nopopup"); 
		  }
		  return element;
		 } 
		 public static List<WebElement> paymentTab_Lables (WebDriver driver)
		  { 
		   try 
		   {
			   elements = driver.findElements(By.xpath("(//div[@class='price striped'])[position()=2]//tr//th"));
			   libs.HighlightElement(driver, element);
		   }
		   catch(Exception e)
		   { 
			   System.out.println("paymentTab_Lables"); 
		   }
			return elements;
		  }
		 public static List<WebElement> paymentTab_Values (WebDriver driver)
		  { 
			 try
			 {
			   elements = driver.findElements(By.xpath("(//div[@class='price striped'])[position()=2]//tr//td"));
			   libs.HighlightElement(driver, element);
			 }
			 catch(Exception e) 
			 {
				System.out.println("paymentTab_Lables"); 
			 }
			return elements;
		 }
		 public static WebElement clickonSavedVehicleIcon(WebDriver driver)
		    {
			  try
			  {
				element=driver.findElement(By.xpath("//div[@class='saved-vehicles-icon']/span[@class='icon-image']"));
				libs.HighlightElement(driver, element);	
			  }
			  catch(Exception e)
			  { 	
				 System.out.println("clickonSavedVehicleIcon"); 
			  }
			  return element;
			 } 
		 
		 
		 public static WebElement lnk_AllSavedVehicle(WebDriver driver)
		    {
			  try
			  {
				element=driver.findElement(By.xpath("//div[@class='all-saved-vehicles']/a"));
				libs.HighlightElement(driver, element);	
			  }
			  catch(Exception e)
			  { 	
				 System.out.println("lnk_AllSavedVehicle"); 
			  }
			  return element;
			 } 
	
}
