package pageObjectClasses;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import libraryClasses.FuncitonLibrary;
public class PGO_creditForm 
{
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	public  static FuncitonLibrary libs = new FuncitonLibrary();
	
	public static WebElement txt_priFirstName (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-first-name']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_priFirstName");
		}
		return element;
	}
	
	public static WebElement joint_txt_priFirstName (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-first-name']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_priFirstName");
		}
		return element;
	}
	public static WebElement txt_priLastName (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-last-name']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_priLastName");
		}
		return element;
	}
	public static WebElement joint_txt_priLastName (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-last-name']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_priLastName");
		}
		return element;
	}
	public static WebElement txt_ccStrAdd (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-street-address']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_ccStrAdd");
		}
		return element;
	}
	public static WebElement joint_txt_ccStrAdd (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-street-address']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccStrAdd");
		}
		return element;
	}
	public static WebElement txt_ccPriAppCity (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-city']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_ccPriAppCity");
		}
		return element;
	}
	public static WebElement joint_txt_ccPriAppCity (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-city']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccPriAppCity");
		}
		return element;
	}
	public static WebElement txt_ccPriAppState (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-state']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_ccPriAppState");
		}
		return element;
	}
	public static WebElement joint_txt_ccPriAppState (WebDriver driver)
	{
		try
		{
		 element = driver.findElement(By.xpath(".//*[@id='joint-applicant-state']"));
		 libs.HighlightElement(driver, element);
		}
	catch(Exception e)
	{
		System.out.println("joint_txt_ccPriAppState");
	}
	return element;
	}
	public static WebElement txt_ccPriAppZip (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-zip-code']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_ccPriAppZip");
		}
		return element;
	}
	public static WebElement joint_txt_ccPriAppZip (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-zip-code']"));
		libs.HighlightElement(driver, element);	}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccPriAppZip");
		}
		return element;
	}
	public static WebElement txt_ccPriAppPhone (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-phone']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_ccPriAppPhone");
		}
		return element;
	}
	public static WebElement joint_txt_ccPriAppPhone (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-phone']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccPriAppPhone");
		}
		return element;
	}
	public static WebElement txt_ccPriAppEmail (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-email']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_ccPriAppEmail");
		}
		return element;
	}
	public static WebElement joint_txt_ccPriAppEmail (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-email']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccPriAppEmail");
		}
		return element;
	}
	public static WebElement txt_ccPriAppEmailConfirm (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='primary-applicant-email-confirm']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_ccPriAppEmailConfirm");
		}
		return element;
	}
	public static WebElement joint_txt_ccPriAppEmailConfirm (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-email-confirm']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccPriAppEmailConfirm");
		}
		return element;
	}
	public static WebElement joint_txt_ccrelationship (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath(".//*[@id='joint-applicant-relationship']"));
		libs.HighlightElement(driver, element);	
	    }
	catch(Exception e)
		{
			System.out.println("joint_txt_ccrelationship");
		}
		return element;
	}
	public static WebElement btn_creditContactBtn (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("btn_creditContactBtn");
		}
		return element;
	}

// CC personal Info

	public static WebElement txt_ccDob (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath("//input[@data-ng-model='applicants.primary.personal.dateOfBirth.value']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_ccDob");
		}
		return element;
	}
	public static WebElement joint_txt_ccDob (WebDriver driver)
	{
		try
		{
		element = driver.findElement(By.xpath("//input[@data-ng-model='applicants.joint.personal.dateOfBirth.value']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccDob");
		}
		return element;
	}
	public static WebElement txt_ccSsn (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-ssn']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_ccSsn");
		}
		return element;
	}
	public static WebElement joint_txt_ccSsn (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-ssn']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccSsn");
		}
		return element;
	}
	public static WebElement txt_ccResSt (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-residence-status']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("txt_ccResSt");
		}
		return element;
	}
	public static WebElement joint_txt_ccResSt (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-residence-status']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccResSt");
		}
		return element;
	}
	public static WebElement txt_ccResYr (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-residence-period-years']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("txt_ccResYr");
		}
		return element;
	}
	public static WebElement joint_txt_ccResYr (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-residence-period-years']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			System.out.println("joint_txt_ccResYr");
		}
		return element;
	}
	public static WebElement txt_ccResMths (WebDriver driver)
	{
		try
		{
			element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-residence-period-months']"));
			libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
		  System.out.println("txt_ccResMths");
		}
			return element;
	}
	public static WebElement joint_txt_ccResMths (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-residence-period-months']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
		  System.out.println("joint_txt_ccResMths");
		}
				return element;
	}
		
	// Credit Income Info details 
	
	public static WebElement txt_ccEmpSts (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-employment-status']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
		  System.out.println("txt_ccEmpSts");
		}
				return element;
	}
	public static WebElement joint_txt_ccEmpSts (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-employment-status']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
		  System.out.println("joint_txt_ccEmpSts");
		}
				return element;
	}
	public static WebElement txt_ccEmployer (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-employer']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
		  System.out.println("txt_ccEmployer");
		}
				return element;
	}
	public static WebElement joint_txt_ccEmployer (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-employer']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			  System.out.println("joint_txt_ccEmployer");
			}
					return element;
		}
	public static WebElement txt_ccOccu (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-occupation']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			  System.out.println("txt_ccOccu");
			}
					return element;
	}
	public static WebElement joint_txt_ccOccu (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-occupation']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			  System.out.println("joint_txt_ccOccu");
			}
					return element;
	}
	public static WebElement txt_ccEmpYrs (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-employment-period-years']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			  System.out.println("txt_ccEmpYrs");
			}
					return element;
	}
	public static WebElement joint_txt_ccEmpYrs (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-employment-period-years']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			  System.out.println("joint_txt_ccEmpYrs");
			}
					return element;
	}
	public static WebElement txt_ccEmpMths (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-employment-period-months']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			  System.out.println("txt_ccEmpMths");
			}
					return element;
	}
	public static WebElement joint_txt_ccEmpMths (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-employment-period-months']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			  System.out.println("joint_txt_ccEmpMths");
			}
					return element;
	}
	public static WebElement txt_ccWrkPhone (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-work-phone']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			  System.out.println("txt_ccWrkPhone");
			}
					return element;
	}
	public static WebElement joint_txt_ccWrkPhone (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-work-phone']"));
		libs.HighlightElement(driver, element);	
		}
		catch(Exception e)
		{
			  System.out.println("joint_txt_ccWrkPhone");
			}
					return element;
	}
	public static WebElement txt_ccGrossIncome (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='primary-applicant-gross-income']"));
		libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			  System.out.println("txt_ccGrossIncome");
			}
					return element;
	}
	public static WebElement joint_txt_ccGrossIncome (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath(".//*[@id='joint-applicant-gross-income']"));
		libs.HighlightElement(driver, element);	}
		catch(Exception e)
		{
			  System.out.println("joint_txt_ccGrossIncome");
			}
					return element;
	}
	
	
	//-----------Form review and submit
	
	//--disclaimer and check box accept terms and conditions
	public static WebElement txt_nwDisclmer (WebDriver driver)
	{
		try
		{
		element = 	driver.findElement(By.xpath("//DIV[@class='termsAndConditions']"));
		libs.HighlightElement(driver, element);	}
		catch(Exception e)
		{
			  System.out.println("txt_nwDisclmer");
			}
					return element;
	}
	
		public static WebElement txt_nwDisclmer1 (WebDriver driver)
	{
			try
			{
		element = 	driver.findElement(By.xpath("(//div[@class='termsAndConditions']//p)[last()]"));
		libs.HighlightElement(driver, element);	
			}catch(Exception e)
		{
			  System.out.println("txt_nwDisclmer1");
			}
					return element;
	}
		public static WebElement chkbx_accept_btn (WebDriver driver)
	  {
		try
			{
	
		element = 	driver.findElement(By.xpath("//SPAN[text()='Accept Terms and Conditions']"));
		libs.HighlightElement(driver, element);	
			}
		catch(Exception e)
		{
			  System.out.println("txt_nwDisclmer1");
			}
					return element;
	}
		
		public static WebElement btn_fnlsubmit (WebDriver driver)
		{
			try
			{
			element = 	driver.findElement(By.xpath("//BUTTON[@type='submit'][@data-ng-disabled='hasSubmitted || !termsAccepted']"))	;
			libs.HighlightElement(driver, element);
			}
			catch(Exception e)
			{
			  System.out.println("txt_nwDisclmer1");
			}
			return element;
		}
		public static WebElement btn_crdtBuy (WebDriver driver)
		{
			try
			{
			element = 	driver.findElement(By.xpath("/html/body/div[7]/div/div/div/form/section/div[1]/div[1]/div[1]/div[1]/div[1]/button"))	;
			libs.HighlightElement(driver, element);	
			}
			catch(Exception e)
			{
			  System.out.println("btn_crdtBuy");
			}
			return element;
		}
		public static WebElement creditOverlayImg (WebDriver driver)
		{
			try
			{
		  element =driver.findElement(By.xpath("//section[@id='applyforCreditOverlay-step0']//div[@class='splash']//header//div[@class='col-xs-12']//img"));
		 	libs.HighlightElement(driver, element);	
		 	}
			catch(Exception e)
			{
			  System.out.println("creditOverlayImg");
			}
			return element;
		}
		public static WebElement creditOverlayHeading (WebDriver driver)
		{
			try
			{
		  element =driver.findElement(By.xpath("//section[@id='applyforCreditOverlay-step0']//div[@class='splash']//header//div[@class='col-xs-12']//h1"));
		libs.HighlightElement(driver, element);	
		}
			catch(Exception e)
			{
			  System.out.println("creditOverlayHeading");
			}
			return element;
		}
		public static WebElement creditOverlayText(WebDriver driver)
		{
			try
			{
		  element =driver.findElement(By.xpath("//section[@id='applyforCreditOverlay-step0']//div[@class='splash']//header//div[@class='col-xs-12']//p"));
		libs.HighlightElement(driver, element);	
		}
			catch(Exception e)
			{
			  System.out.println("creditOverlayText");
			}
			return element;
		}
		public static List<WebElement> creditappOptions(WebDriver driver)
		{
			try
			{
			elements =driver.findElements(By.xpath("//section[@id='applyforCreditOverlay-step0']//div[@class='splash']//div[@class='row']//div[@class='col-xs-12 application-type']//div[@class='row']//div//button"));
			libs.HighlightElement(driver, element);
			}
			catch(Exception e)
			{
			  System.out.println("creditappOptions");
			}
			return elements;
		}
		public static WebElement payHead(WebDriver driver)
		{
		try
		{
		  element =driver.findElement(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[1]/strong"));
		  libs.HighlightElement(driver, element);
		  }
		catch(Exception e)
		{
		  System.out.println("payHead");
		}
		return element;
		}
		public static List<WebElement> payOptions(WebDriver driver)
		{
			try
			{
			elements =driver.findElements(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[1]/div/div/button"));
			}
			catch(Exception e)
			{
			  System.out.println("payOptions");
			}
			return elements;
			}
		
		public static WebElement buyOptions(WebDriver driver)
		{
			try
			{
			element =driver.findElement(By.xpath("//div[@class='col-xs-12 col-lg-6 finance-type']/div[@class='row']/div[@class='col-xs-6 ng-binding']/button"));
			}
			catch(Exception e)
			{
			  System.out.println("buyOptions");
			}
			return element;
		}
		public static WebElement aHead(WebDriver driver)
		{
			try
			{
		  element =driver.findElement(By.xpath("//section[@class='intro ng-scope']/div[@class='splash']/div[1]/div[2]/strong"));
		libs.HighlightElement(driver, element);
			}catch(Exception e)
		{
			  System.out.println("aHead");
			}
			return element;
		}
		public static List <WebElement> applicationOptions(WebDriver driver)
		{
			try
			{
		  elements =driver.findElements(By.xpath("//section[@id='applyforCreditOverlay-step0']/div[@class='splash']//div[@class='row']//div[@class='col-xs-12 application-type']/div[@class='row']//div[@class='col-xs-6']//button"));
			}
			catch(Exception e)
			{
				  System.out.println("applicationOptions");
				}
				return elements;
		}
		public static WebElement lnk_lnkText (WebDriver driver, String lnkName)
		{
			try
			{
			WebDriverWait wait=new WebDriverWait(driver,5);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(lnkName)));
		  libs.HighlightElement(driver, element);
			}
			catch(Exception e)
			{
				  System.out.println("lnk_lnkText");
				}
				return element;
		
		}
		public static List <WebElement> infoOptions(WebDriver driver)
		{
			try
			{
		  elements =driver.findElements(By.xpath("//header[@class='hide-print']/div[@class='row hide-print']/div/nav/a"));
			}
			catch(Exception e)
			{
				  System.out.println("infoOptions");
				}
				return elements;
		}
		
		
		

		public static WebElement Btn_Creditapplicaton(WebDriver driver,String buttonName)
		{
			try
			{
		  element=driver.findElement(By.xpath("//button[@type='button'][contains(text(),'"+buttonName+"')]"));
		libs.HighlightElement(driver, element);
			}catch(Exception e)
		{
			  System.out.println("Btn_Creditapplicaton");
			}
			return element;
		}


		public static WebElement Btn_CreditapplicatonBuy(WebDriver driver,String buttonName)
		{
			try
			{
		  element=driver.findElement(By.xpath("(//button[@type='button'][contains(text(),'"+buttonName+"')])[position()=1]"));
		libs.HighlightElement(driver, element);	
			}
			catch(Exception e)
		{
			  System.out.println("Btn_CreditapplicatonBuy");
			}
			return element;
		}
		
		public static List<WebElement>  reviewAndSubmitLabels(WebDriver driver)
		{
			try
			{
		elements=driver.findElements(By.xpath("//section[@class='primary-applicant']//tbody//tr//td[1]"));
		libs.HighlightElement(driver, element);	
			}catch(Exception e)
		{
			  System.out.println("reviewAndSubmitLabels");
			}
			return elements;
	}
		
		
		public static List<WebElement>  reviewAndSubmitValues(WebDriver driver)
		{
			try
			{
		elements=driver.findElements(By.xpath("//section[@id='applyforCreditOverlay-step4']//div[@class='row']//div[@class='col-xs-12']//section[@class='primary-applicant']//tbody//tr//td[2]"));
		libs.HighlightElement(driver, element);	
			}catch(Exception e)
		{
			  System.out.println("reviewAndSubmitValues");
			}
			return elements;
		}
		public static List<WebElement>  reviewAndSubmitJointLabels(WebDriver driver)
		{
			try
			{
		elements=driver.findElements(By.xpath("//section[@class='primary-applicant']//tbody//tr//td[1]"));
		libs.HighlightElement(driver, element);
			}catch(Exception e)
		{
			  System.out.println("reviewAndSubmitJointLabels");
			}
			return elements;
		}
		
		
		public static List<WebElement>  reviewAndSubmitJointValues(WebDriver driver)
		{
			try
			{
		elements=driver.findElements(By.xpath("//section[@id='applyforCreditOverlay-step4']//div[@class='row']//div[@class='col-xs-12']//section[@class='primary-applicant']//tbody//tr//td[2]"));
		libs.HighlightElement(driver, element);
			}catch(Exception e)
		{
			  System.out.println("reviewAndSubmitJointValues");
			}
			return elements;
		}













		
		
	}
