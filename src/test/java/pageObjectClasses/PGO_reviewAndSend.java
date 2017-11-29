package pageObjectClasses;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import libraryClasses.FuncitonLibrary;
public class PGO_reviewAndSend extends FuncitonLibrary{
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	

	//	Below are the POs for reviewAndSend functionality
	
	public static WebElement btn_reviewAndSend(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,40);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@class='btn btn-dre nextTab hidden-sm hidden-xs pull-right ng-binding']")));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement tab_reviewAndSend(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,40);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='tab4 summary']")));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	
	public static WebElement btn_reviewMyDeal (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//button[@data-ng-click='reviewMyDeal()']"));
		libs.HighlightElement(driver, element);
		return element;
	}

	public static WebElement txt_yourVehicle (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section [@class='vehicle dre-accordion ng-scope']/div[1]/i"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement txt_yourTradeIn (WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section [@class='trade-in dre-accordion ng-scope']/div[1]/i"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	
	public static WebElement txt_yourPayment (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//section [@class='payment dre-accordion ng-scope']/div[1]/i"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement txt_yourProtection (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//section [@class='protection dre-accordion ng-scope']/div[1]/i"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement txt_firstName (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.firstName']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement txt_lastName (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.lastName']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement txt_email (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.email']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement txt_phone (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.phone']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement txt_searchZip (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.user.searchZip']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	
	public static WebElement txt_desiredDate (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//input[@data-ng-model='ctrl.dealFactory.deal.testDrive.desiredDate']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement txt_desiredTime (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//select[@data-ng-model='ctrl.dealFactory.deal.testDrive.desiredTime']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement btn_applyForCredit (WebDriver driver)
	{
	
		WebElement element=driver.findElement(By.xpath("//button[@data-ng-click='applyForCreditOverlay()']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement btn_creditBuy (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//button[contains(text(),'Buy')]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement btn_creditIndiv (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//button[contains(text(),'Individual')]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement btn_sendMyDeal (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//button[@class='send-to-dealer-submit'][@type='submit']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement txt_estPreTaxPrice (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='pricing-summary']/div[1]/h4[1]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement txt_estAmtFin (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='pricing-summary']/div[3]/h4[1]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement txt_estMnthlyPay (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//div[@class='pricing-summary']/div[5]/h4[1]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement btn_sendMyDeal1 (WebDriver driver)
	{											
		element =driver.findElement(By.xpath("//button[@class='close']/span"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement btn_sendMyDeal2 (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//button[@data-ng-click='viewAndPrintDeal()']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement txt_creditName (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//h1 [@class='ng-binding']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	
	public static WebElement txt_dealSentTime (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//p[@class='sent-date ng-binding']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement txt_dealNo (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//section [@class='deal-submitted']/p[2]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement txt_yourTestDrive (WebDriver driver)
	{
		element =driver.findElement(By.xpath("(//i [@class='dreicon icon-uniE680'])[last()-1]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement tab1_vehicleDetails (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//a[@class='tab1 vehicle-details']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement tab2_tradeIn (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//a[@class='tab2 trade-in']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement tab3_payment (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//a[@class='tab3 payment']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement tab4_summary (WebDriver driver)
	{
		element =driver.findElement(By.xpath("//a[@class='tab4 summary']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement heading(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']//h1"));

	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement subHeading(WebDriver driver)
	{
	   element=driver.findElement(By.xpath("//span[@class='subheadingOne']"));

	   libs.HighlightElement(driver, element);	return element;
		}
	public static List<WebElement> sections(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("//section[@class='left-column']/div/section/div[@class='toggle ng-binding']"));
	return elements;
	}
	public static WebElement totMsrpDreicon(WebDriver driver)
	{
	 element=driver.findElement(By.xpath("//table[@class='price striped ng-scope']/tbody/tr[@class='grouped highlight']/td/span"));

	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement note(WebDriver driver)
	{
	 element=driver.findElement(By.xpath("//small[@class='ng-scope']/p"));

	libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> paymentInformation(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/section/section[3]/div[2]/table/tbody/tr/th"));
	
	return elements;
	}
	public static WebElement tradeinVehicle(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//div[@class='trade-in-complete ng-scope']/div/h2[@class='ng-binding']"));
	
	   libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> tradeVehicleDeatilshead(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/section/section[2]/div[2]/div[1]/div/table[1]/tbody/tr/th"));
	 
	  libs.HighlightElement(driver, element);	return elements;
	}
	public static List<WebElement> tradeVehicleDeatils(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/section/section[2]/div[2]/div[1]/div/table[1]/tbody/tr/td"));
	 
	  libs.HighlightElement(driver, element);	return elements;
	}
	public static WebElement vehicleModel(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//section[@class='vehicle dre-accordion ng-scope']/div[2]/h2"));
		
	   libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> paymentFeature(WebDriver driver)
	{
		elements=driver.findElements(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/section/section[3]/div[2]/table/tbody/tr/th"));
		
	return elements;
	}
	public static List<WebElement> paymentDetails(WebDriver driver)
	{
		elements=driver.findElements(By.xpath("//section[@class='payment dre-accordion ng-scope']/div[2]/table/tbody/tr/td"));
	
	   return elements;
	}
	public static WebElement estimatedDreIcon(WebDriver driver)
	{
		element=driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[2]/div[4]/div/div/div[2]/div/section/section[3]/div[2]/table/tbody/tr[7]/td/span"));
		
	   libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement note1(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//section/section[@class='payment dre-accordion ng-scope']/div[2]/section[@class='disclaimers ng-scope']/p[2]/small"));

	   libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement protectionNote(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//div[@class='protect section']/section[@class='protection dre-accordion ng-scope']/div[2]/p"));

	   libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> protectionPlans(WebDriver driver)
	{
		elements=driver.findElements(By.xpath("//div[@class='protection-plan-text col-sm-6']"));
		return elements;
	}
	public static List<WebElement> vehicleHeading(WebDriver driver)
	{
		elements=driver.findElements(By.xpath("//section/section[@class='vehicle dre-accordion ng-scope']/div[2]/table[@class='details ruled ng-scope']/tbody/tr/th"));
		return elements;
	}
	public static List<WebElement> vehicledetails(WebDriver driver)
	{
		elements=driver.findElements(By.xpath("//section[@class='vehicle dre-accordion ng-scope']/div[2]/table[@class='details ruled ng-scope']/tbody/tr/td[@class='ng-binding']"));
		return elements;
	}
	public static List<WebElement> vehicles(WebDriver driver)
	{
		elements=driver.findElements(By.xpath("//section/section[@class='vehicle dre-accordion ng-scope']/div[2]/table[@class='details ruled ng-scope']/tbody/tr"));
		return elements;
	}
	public static List<WebElement> priceDetails(WebDriver driver,int dRw)
	{
		elements=driver.findElements(By.xpath("//section[@class='vehicle dre-accordion ng-scope']/div[2]/table[@class='price striped ng-scope']/tbody/tr/td[@class='ng-binding']"));
		return elements;
	}
	public static List<WebElement> tradeinVehicledetails(WebDriver driver)
	{
		elements=driver.findElements(By.xpath("//div[@class='trade-in-complete ng-scope']/div/table[@class='details ruled']/tbody/tr/td"));
		return elements;
	}
	public static WebElement tradeinPricedetails(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//div[@class='trade-in-complete ng-scope']/div/table[@class='price']/tbody/tr/td"));
		return element;
	}
	public static WebElement paymentType(WebDriver driver)
	{
 		element=driver.findElement(By.xpath("//section/section[@class='payment dre-accordion ng-scope']/div[2]/table/tbody/tr[1]/td"));
 		
       libs.HighlightElement(driver, element);	return element;	
	}
	public static WebElement beforeDealerHeading(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='section dealerInformationBlock']/section[@class='dealer ng-scope']/h2"));
	
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforeDealerAddress(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='section dealerInformationBlock']/section[@class='dealer ng-scope']/address[@class='ng-binding']"));

	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforeDealerDirections(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='section dealerInformationBlock']/section[@class='dealer ng-scope']/a"));

	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforeDealerImage(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='section dealerInformationBlock']/section[@class='dealer ng-scope']/img"));

	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforePledgeImage(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//I[@class='icon-pledge']"));
	
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforePledgeHeading(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='section ourPledge']/section[@class='pledge']/h2"));
	
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforePledge(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='section ourPledge']/section[@class='pledge']/p"));
	
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforeSavePrintHeading(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='saveAndPrint section']/section[@class='print']/h2"));

	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforeSavePrintText(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='saveAndPrint section']/section[@class='print']/div/p"));

	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement beforeSavePrintButton(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='saveAndPrint section']/section[@class='print']/button"));

	 libs.HighlightElement(driver, element);	return element;
	}
//	public static WebElement senddealHeading(WebDriver driver)
//	{
//	  element=driver.findElement(By.xpath("//section[@class='sendToDealerForm']/header/h1"));
//	 libs.HighlightElement(driver, element);	return element;
//	}
//	public static WebElement senddealText(WebDriver driver)
//	{
//	  element=driver.findElement(By.xpath("//section[@class='sendToDealerForm']/header/p"));
//	 libs.HighlightElement(driver, element);	return element;
//	}
	public static List<WebElement> formLabel(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("//section[@class='sendToDealerForm']/form/div/div/div/label/span"));
	  return elements;
	}
	public static List<WebElement> formInput(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("//section[@class='sendToDealerForm']/form/div/div/div/label/input"));
	  return elements;
	}
	public static WebElement formContactHeading(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//section[@class='sendToDealerForm']/form/div/div/h6"));
	  libs.HighlightElement(driver, element);
	 libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> formContactOptions(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("//section[@class='sendToDealerForm']/form/div[4]/div/div"));
	  return elements;
	}
	public static WebElement testDrive(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='sendToDealerForm section']/section[@class='sendToDealerForm']/form[@class='css-form ng-pristine ng-invalid ng-invalid-required']/div[5]/div[1]/div[1]/h6"));
	  libs.HighlightElement(driver, element);
	 libs.HighlightElement(driver, element);	return element;
	}
	public static List<WebElement> formTestdriveLabel(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("//section[@class='sendToDealerForm']/form/div[5]/div[@class='row']/div[@class='col-xs-12 col-md-6']/div/label/span"));
	  return elements;
	}
	public static List<WebElement> formTestdriveOptions(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("//section[@class='sendToDealerForm']/form/div[5]/div[@class='row']/div[@class='col-xs-12 col-md-6']/div/label/input"));
	  return elements;
	}
	public static List<WebElement> dealOptions(WebDriver driver)
	{
	  elements=driver.findElements(By.xpath("//section[@class='sendToDealerForm']/form/div[5]/div[@class='row buttons']/div/button"));
	  return elements;
	}
	public static WebElement dealText(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='sendToDealerForm section']/section[@class='sendToDealerForm']/form/div[5]/div[2]/p"));
	  libs.HighlightElement(driver, element);
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement afterdealMessage(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='modal-body text-center']/header"));
	  libs.HighlightElement(driver, element);
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement afterdealmessage1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='whatHappensNext']/h2[2]")));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement afterdealmessage2(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='whatHappensNext']/p")));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement afterdealmessage3(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='whatHappensNext']/button")));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement afterdealmessage4(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body text-center']/section[@class='contactDealer']")));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement afterdealmessage5(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body text-center']/section[@class='testDrive ng-scope']")));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement afterdealmessage6(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,2);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body text-center']/footer")));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement messageHeading(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/h1"));
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement message(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/p"));
	  libs.HighlightElement(driver, element);
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement messageButton(WebDriver driver)
	{
	  element=driver.findElement(By.xpath("//div[@class='submit-billboard col-xs-12']/button"));
	  libs.HighlightElement(driver, element);
	 libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement name(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal fade sendToDealerOverlay ng-scope in']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-body text-center']/header/h1")));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement messageafterdeal(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body text-center']/header/p")));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static List<WebElement> tabs(WebDriver driver)
	{
		elements=driver.findElements(By.xpath("//div[@class='tab-container col-xs-12 ng-scope']/div[@class='tab-header row']/ul[@class='tab-list']/li/a"));
		return elements;
	}
	public static List<WebElement> labels(WebDriver driver)
	{
	 elements=driver.findElements(By.xpath("//section[@class='sendToDealerForm']/form/div[5]/div[1]/div/div/label/span"));
	 return elements;
	}
	public static WebElement date(WebDriver driver)
	{
	 WebElement element=driver.findElement(By.xpath("//section[@class='sendToDealerForm']/form/div[5]/div[1]/div[2]/div/label/input"));

	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement selectclass(WebDriver driver)
	{
	 WebElement element=driver.findElement(By.xpath("//section[@class='sendToDealerForm']/form/div[5]/div[1]/div[3]/div/label/div/select"));
	
	libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement editButton(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
	
	   libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement summaryTabs(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[1]/ul/li[4]/a"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement noTradein(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@class='left-column']/section[@class='trade-in dre-accordion ng-scope']/div[2]/div[@class='trade-in-incomplete ng-scope']/h2"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement valueTradein(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@class='trade-in dre-accordion ng-scope']/div[2]/div[3]/p[2]/button"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement payment(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@class='payment dre-accordion ng-scope']/div[2]/p[2]/button"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement noTradeinhead(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='trade-in-incomplete ng-scope']/h2"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement noTradeintext(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//div[@class='trade-in-incomplete ng-scope']/p[1]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement paymentHead(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@class='payment dre-accordion ng-scope']/div[2]/h2[@class='ng-scope']"));
		libs.HighlightElement(driver, element);
		return element;
	}
	public static WebElement paymentText(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@class='payment dre-accordion ng-scope']/div[2]/p[1]"));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	public static WebElement dreicon(WebDriver driver)
    {
	   WebDriverWait wait=new WebDriverWait(driver,2);		
	   WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//SPAN[contains(@class,'dreicon icon-uni')])[position()=5]")));
    	libs.HighlightElement(driver, element);	return element;
    } 
	
	
}
