package pageObjectClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraryClasses.FuncitonLibrary;
public class PGO_creditForm {
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	public  static FuncitonLibrary libs = new FuncitonLibrary();

	//	Below are the POs for creditForm functionality
	public static WebElement txt_priFirstName (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-first-name']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_priLastName (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-last-name']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccStrAdd (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-street-address']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccPriAppCity (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-city']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccPriAppState (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-state']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccPriAppZip (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-zip-code']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccPriAppPhone (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-phone']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccPriAppEmail (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-email']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccPriAppEmailConfirm (WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-email-confirm']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement btn_creditContactInfo (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[@type='submit']"));
		libs.HighlightElement(driver, element);	return element;
	}
	
	public static WebElement btn_creditContactBtn (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		libs.HighlightElement(driver, element);	return element;
	}

// CC personal Info

	public static WebElement txt_ccDob (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@data-ng-model='applicants.primary.personal.dateOfBirth.value']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccDob (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//input[@data-ng-model='applicants.primary.personal.dateOfBirth.value']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccSsn (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-ssn']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccSsn (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-ssn']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccResSt (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-residence-status']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccResSt (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-residence-status']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccResYr (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-residence-period-years']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccResYr (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-residence-period-years']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccResMths (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-residence-period-months']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccResMths (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-residence-period-months']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement btn_creditPersContinue (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		libs.HighlightElement(driver, element);	return element;
	}
	
	// Credit Income Info details 
	
	public static WebElement txt_ccEmpSts (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-employment-status']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccEmpSts (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-employment-status']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccEmployer (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-employer']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccEmployer (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-employer']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccOccu (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-occupation']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccOccu (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-occupation']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccEmpYrs (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-employment-period-years']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccEmpYrs (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-employment-period-years']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccWrkPhone (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-work-phone']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccWrkPhone (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-work-phone']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccGrossIncome (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-gross-income']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccGrossIncome (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-gross-income']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement txt_ccEmpMths (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-employment-period-months']"));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement joint_txt_ccEmpMths (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-employment-period-months']"));
		libs.HighlightElement(driver, element);	return element;
	}
	
	//-----------Form review and submit
	
	//--disclaimer and check box accept terms and conditions
	public static WebElement txt_nwDisclmer (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath("//DIV[@class='termsAndConditions']"));
		libs.HighlightElement(driver, element);	return element;
	}
	
		public static WebElement txt_nwDisclmer1 (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath("(//div[@class='termsAndConditions']//p)[last()]"));
		libs.HighlightElement(driver, element);	return element;
	}
		public static WebElement chkbx_accept_btn (WebDriver driver)
	{
		element = 	driver.findElement(By.xpath("//SPAN[text()='Accept Terms and Conditions']"));
		libs.HighlightElement(driver, element);	return element;
	}
		
		public static WebElement btn_fnlsubmit (WebDriver driver)
		{
			element = 	driver.findElement(By.xpath("//BUTTON[@type='submit'][@data-ng-disabled='hasSubmitted || !termsAccepted']"))	;
			libs.HighlightElement(driver, element);	return element;
		}
	
		public static WebElement btn_crdtBuy (WebDriver driver)
		{
			element = 	driver.findElement(By.xpath("/html/body/div[7]/div/div/div/form/section/div[1]/div[1]/div[1]/div[1]/div[1]/button"))	;
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement overlayImg (WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/header/div[1]/img"));
		 	libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement overlayHeading (WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/header/div[2]/h1"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement overlayText(WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/header/div[2]/p"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement appHead(WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[@class='col-xs-12 application-type']/strong"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static List<WebElement> appOptions(WebDriver driver)
		{
			elements =driver.findElements(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[@class='col-xs-12 application-type']/div/div/button"));
			return elements;
		}
		public static WebElement payHead(WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[1]/strong"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static List<WebElement> payOptions(WebDriver driver)
		{
			elements =driver.findElements(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[1]/div/div/button"));
			return elements;
		}
		public static WebElement buyOptions(WebDriver driver)
		{
			element =driver.findElement(By.xpath("//div[@class='col-xs-12 col-lg-6 finance-type']/div[@class='row']/div[@class='col-xs-6 ng-binding']/button"));
			return element;
		}
		public static WebElement aHead(WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[2]/strong"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static List <WebElement> aOptions(WebDriver driver)
		{
		  elements =driver.findElements(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[2]/div/div/button"));
			return elements;
		}
		public static WebElement lnk_lnkText (WebDriver driver, String lnkName)
		{
			WebDriverWait wait=new WebDriverWait(driver,5);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(lnkName)));
		  libs.HighlightElement(driver, element);	return element;
		}
		public static List <WebElement> infoOptions(WebDriver driver)
		{
		  elements =driver.findElements(By.xpath("//header[@class='hide-print']/div[@class='row hide-print']/div/nav/a"));
			return elements;
		}
		public static WebElement infoOptions1(WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//header[@class='hide-print']/div[@class='row hide-print']/div/nav/a[1]"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement infoOptions2(WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//header[@class='hide-print']/div[@class='row hide-print']/div/nav/a[2]"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement papplicant(WebDriver driver)
		{
		  element =driver.findElement(By.xpath("//section[@class='step step-1 ng-scope']/div/div/section[@class='primary-applicant']/h4"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement noCredit (WebDriver driver)
		{
		 element = driver.findElement(By.xpath("//footer/div[1]/button[2]"));
		libs.HighlightElement(driver, element);	libs.HighlightElement(driver, element);	return element;		
		}
		public static WebElement confirmOverlay (WebDriver driver)
		{
		 element = driver.findElement(By.xpath("//div[@class='modal fade applyForCreditOverlay ng-scope in']/div/div/div/div[@class='confirmClose']"));
		libs.HighlightElement(driver, element);	libs.HighlightElement(driver, element);	return element;		
		}
		public static List<WebElement> confirmOverlayButton (WebDriver driver)
		{
		 elements = driver.findElements(By.xpath("//div[@class='modal fade applyForCreditOverlay ng-scope in']/div/div/div/div[@class='confirmClose']/div/button"));
		 return elements;	
		}
		public static List<WebElement> personalLabel (WebDriver driver)
		{
		 elements = driver.findElements(By.xpath("//section[@class='step step-2 ng-scope']/div/div/section[@class='primary-applicant']/div/div/label"));
		 return elements;	
		}
		public static WebElement alert (WebDriver driver)
		{
		 element = driver.findElement(By.xpath("//section/div[2]/div[1]/label/span/span"));
		libs.HighlightElement(driver, element);		return element;		
		}
		public static WebElement alertText (WebDriver driver)
		{
		 element = driver.findElement(By.xpath("//div[@class='modal fade applyForCreditOverlay ng-scope in']/div/div[2]/div[@class='popover-content']/div[2]"));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement select1 (WebDriver driver)
		{
		 element = driver.findElement(By.xpath("//section[@class='primary-applicant']/div[3]/div[1]/div/select"));
		 libs.HighlightElement(driver, element);		return element;		
		}
		public static WebElement alertClose (WebDriver driver)
		{
		 element = driver.findElement(By.xpath("//div[@class='modal fade applyForCreditOverlay ng-scope in']/div/div[2]/div[@class='popover-content']/div[@class='icon-close close text-right']"));
		 libs.HighlightElement(driver, element);		return element;		
		}
		public static List<WebElement> emplymentLabels (WebDriver driver)
		{
		 elements = driver.findElements(By.xpath("//section[@class='step step-3 ng-scope']/div/div/section[@class='primary-applicant']/div/div/label"));
		 return elements;	
		}
		public static List<WebElement> emplymentLabels1 (WebDriver driver)
		{
		 elements = driver.findElements(By.xpath("//section[@class='step step-3 ng-scope']/div/div/section[@class='primary-applicant']/div/label"));
		 return elements;	
		}
		public static WebElement jobType (WebDriver driver)
		{
		 element = driver.findElement(By.xpath("//section[@class='primary-applicant']/div[2]/div[1]/div/select"));
		 libs.HighlightElement(driver, element);		return element;		
		}
		public static WebElement joint_txt_Firstname(WebDriver driver)
		{
			
			element=driver.findElement(By.xpath("//section[@class='joint-applicant ng-scope']/div[2]/div[1]/input"));
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement joint_txt_Lastname(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,90);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='joint-applicant ng-scope']/div[2]/div[2]/input")));
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement joint_txt_Streetaddress(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,90);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='joint-applicant ng-scope']/div[3]/input")));
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement joint_txt_city(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,90);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='joint-applicant ng-scope']/div[4]/div[1]/input")));
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement joint_txt_zipcode(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,90);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='joint-applicant ng-scope']/div[4]/div[3]/input")));
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement joint_txt_phone(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,90);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='joint-applicant ng-scope']/div[5]/input")));
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement joint_txt_email(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,90);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='joint-applicant ng-scope']/div[6]/div[1]/input")));
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement joint_txt_emailconfirm(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,90);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='joint-applicant ng-scope']/div[6]/div[2]/input")));
			libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement jointAppHeading(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,90);
			WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='step step-1 ng-scope']/div/div/section[@class='joint-applicant ng-scope']/h4")));
			libs.HighlightElement(driver, element);	return element;
		}
		public static List<WebElement> jointLabels(WebDriver driver)
		{
		 elements=driver.findElements(By.xpath("//section[@class='step step-1 ng-scope']/div/div/section[@class='joint-applicant ng-scope']/div/div/label"));
		 return elements;
		}
		public static List<WebElement> jointLabels1(WebDriver driver)
		{
		 elements=driver.findElements(By.xpath("//section[@class='step step-1 ng-scope']/div/div/section[@class='joint-applicant ng-scope']/div/label"));
		 return elements;
		}
		public static WebElement jointState(WebDriver driver)
		{
		 element=driver.findElement(By.xpath("//section[@class='step step-1 ng-scope']/div/div/section[@class='joint-applicant ng-scope']/div[4]/div[2]/div/select[@id='joint-applicant-state']"));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement jointRelation(WebDriver driver)
		{
		  WebDriverWait wait=new WebDriverWait(driver,5);
		  WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='step step-1 ng-scope']/div/div/section[@class='joint-applicant ng-scope']/div[7]/div/div/select[@id='joint-applicant-relationship']")));
		libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement relationship(WebDriver driver)
		{
		 element=driver.findElement(By.xpath("//section/div/div/section[2]/div[8]/div/input[@id='joint-applicant-relationship-description']"));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement dobAlert(WebDriver driver)
		{
		 element=driver.findElement(By.xpath("//section[@class='step step-2 ng-scope']/div/div/section[@class='primary-applicant']/div[2]/div[1]/label/span/span"));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement dobAlertText(WebDriver driver)
		{
		 element=driver.findElement(By.xpath("//div[@class='modal fade applyForCreditOverlay ng-scope in']/div/div[2]/div[2]/div[2]"));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement dobAlertClose(WebDriver driver)
		{
		 element=driver.findElement(By.xpath("//div[@class='modal fade applyForCreditOverlay ng-scope in']/div/div[2]/div[2]/div[@class='icon-close close text-right']"));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement monthlyMortgage(WebDriver driver)
		{
		 element=driver.findElement(By.xpath(".//*[@id='primary-applicant-residence-payment']"));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement jointmonthlyMortgage(WebDriver driver)
		{
		 element=driver.findElement(By.xpath(".//*[@id='joint-applicant-residence-payment']"));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement Others(WebDriver driver)
		{
		 WebDriverWait wait=new WebDriverWait(driver,40);
		 element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='joint-applicant ng-scope']/div[8]/div/input[@id='joint-applicant-relationship-description']")));
		 libs.HighlightElement(driver, element);		return element;	
		}
		public static WebElement donotapply_button(WebDriver driver)
		{
		  element=driver.findElement(By.xpath("//footer/div[1]/button[@type='button']"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement buttons1(WebDriver driver)
		{
		  element=driver.findElement(By.xpath("//div[@class='modal fade applyForCreditOverlay ng-scope in']/div/div/div[@class='modal-body isConfirmingClose']/div[@class='confirmClose']/div[@class='buttons']/button[1]"));
		libs.HighlightElement(driver, element);	return element;
		}
		public static WebElement buttons2(WebDriver driver)
		{
		  element=driver.findElement(By.xpath("//div[@class='modal fade applyForCreditOverlay ng-scope in']/div/div/div[@class='modal-body isConfirmingClose']/div[@class='confirmClose']/div[@class='buttons']/button[2]"));
		libs.HighlightElement(driver, element);	return element;
		}



		public static WebElement Btn_Creditapplicaton(WebDriver driver,String buttonName)
		{
		  element=driver.findElement(By.xpath("//button[@type='button'][contains(text(),'"+buttonName+"')]"));
		libs.HighlightElement(driver, element);	return element;
		}


		public static WebElement Btn_CreditapplicatonBuy(WebDriver driver,String buttonName)
		{
			try{
		  element=driver.findElement(By.xpath("(//button[@type='button'][contains(text(),'"+buttonName+"')])[position()=1]"));
		libs.HighlightElement(driver, element);	}catch(Exception e){
			System.out.println("Btn_CreditapplicatonBuy");
		}
			return element;
		}












		
		
	}