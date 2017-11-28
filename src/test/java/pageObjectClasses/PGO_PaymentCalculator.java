package pageObjectClasses;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraryClasses.FuncitonLibrary;
public class PGO_PaymentCalculator
{
	private static WebElement element = null;
	private static List<WebElement> elements=null;
	public  static FuncitonLibrary libs = new FuncitonLibrary();
	public static WebElement lnk_lnkText (WebDriver driver, String lnkName)
	{
	
		WebElement element =driver.findElement(By.xpath("(//a[contains(@data-ng-click,'"+lnkName+"')])[position()=2]"));
		libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement skipTradeIn(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default introSkip']")));
		libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement paymentHeading(WebDriver driver)
	{
    	try {
		WebDriverWait wait=new WebDriverWait(driver,5);
    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='intro']//h2")));
    	libs.HighlightElement(driver, element);	}catch(Exception e){
    		System.out.println("return element;	");
    	}
    	return element;	
	}
    public static WebElement paymentInline(WebDriver driver)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,400);
    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='intro']//p[2]")));
    	libs.HighlightElement(driver, element);	}catch(Exception e){
    		System.out.println("paymentInline");
    		
    	}
		return element;	
	}
    public static List<WebElement> paymentOptions(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
    	List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='row small-gutters']/div[@class='col-xs-12 col-md-4']")));
		return elements;
	}
       
    public static WebElement paymentInlinetext (WebDriver driver,String paymentoption)
	{
		try{
			element =driver.findElement(By.xpath("//section[@data-tabname='"+paymentoption+"']//small[@class='disclaimer']//p"));
		libs.HighlightElement(driver, element);	}catch(Exception e)
		{
			System.out.println("paymentInlinetext");
		}
		return element;	
	}
    
    
    public static WebElement btn_paymenttype(WebDriver driver,String paymentoption)
  	{
  		try{
  			WebDriverWait wait=new WebDriverWait(driver,5);
  			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href=''][text()='"+paymentoption+"'])[position()=2]")));
  		libs.HighlightElement(driver, element);	}catch(Exception e)
  		{
  			System.out.println("btn_paymenttype");
  		}
  		return element;	
  	}
    
    public static WebElement txt_Step1Heading(WebDriver driver,int i)
   	{
   		try{
   			WebDriverWait wait=new WebDriverWait(driver,5);
   			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='accounting']//th)[position()="+i+"]")));
   		libs.HighlightElement(driver, element);	}catch(Exception e)
   		{
   			System.out.println("txt_Step1Heading");
   		}
   		return element;	
   	}
    
    public static WebElement txt_Step2Heading(WebDriver driver)
   	{
   		try{
   			element =driver.findElement(By.xpath("//div[@class='row split-deals']/div/h2"));
   		libs.HighlightElement(driver, element);	}catch(Exception e)
   		{
   			System.out.println("txt_Step2Heading");
   		}
   		return element;	
   	}
    public static WebElement txt_leaseStep2Heading(WebDriver driver)
   	{
   		try{
   			element =driver.findElement(By.xpath("(//div[@class='col-xs-12']//h2)[position()=3]"));
   		libs.HighlightElement(driver, element);	}catch(Exception e)
   		{
   			System.out.println("txt_Step2Heading");
   		}
   		return element;	
   	}
    
    public static WebElement error_Zipcode(WebDriver driver,String option)
	{ try{
	element = 	driver.findElement(By.xpath("//section[@data-tabname='"+option+"']//p[@data-ng-if='zipCodeError']"));
	libs.HighlightElement(driver, element);
	}catch(Exception e)		{ 		System.out.println("error_Zipcode"); 		}		return element;	}

    
    public static WebElement txt_Zipcode(WebDriver driver,String option)
	{
    	try{
	element = 	driver.findElement(By.xpath("//section[@data-tabname='"+option+"']//span//input"));
	libs.HighlightElement(driver, element);	return element;
	}catch(Exception e){
		System.out.println("txt_Zipcode");
		}
		return element;	
    	}
    
    public static WebElement txt_Incentive_Rate(WebDriver driver)
   	{
       	try{
   	element = 	driver.findElement(By.xpath("(//div[@class='section-header'])[position()=1]"));
   	libs.HighlightElement(driver, element);	return element;
   	}catch(Exception e){
   		System.out.println("txt_Zipcode");
   		}
   		return element;	
       	}
    public static WebElement txt_User_Rate(WebDriver driver)
   	{
       	try{
   	element = 	driver.findElement(By.xpath("(//div[@class='section-header'])[position()=2]//label"));
   	libs.HighlightElement(driver, element);	return element;
   	}catch(Exception e){
   		System.out.println("txt_Zipcode");
   		}
   		return element;	
       	}
    
    
    
	public static WebElement txt_BottomText(WebDriver driver,int position)
	{
	  	try{
	element = 	driver.findElement(By.xpath("(//p[@class='ng-binding'])[position()="+position+"]"));
	libs.HighlightElement(driver, element);		}catch(Exception e){
   		System.out.println("txt_BottomText");
   		}
   		return element;	
	
	}
    
	public static WebElement txt_Bottom_Disclaimer(WebDriver driver)
	{
	  	try{
	element = 	driver.findElement(By.xpath("(//small[@class='disclaimer'])[position()=2]"));
	libs.HighlightElement(driver, element);		}catch(Exception e){
   		System.out.println("txt_BottomText");
   		}
   		return element;	
	
	}
    
	
	
	public static WebElement txt_Zip_Code(WebDriver driver,String Option)
	{
	  	try{
	element = 	driver.findElement(By.xpath("//section[@data-tabname='"+Option+"']//p[@class='col-xs-12 zipDetails']"));
	libs.HighlightElement(driver, element);		}catch(Exception e){
   		System.out.println("txt_Zip_Code");
   		}
   		return element;	
	
	}
	
	 public static List<WebElement> duration(WebDriver driver)
		{
			try{elements =driver.findElements(By.xpath("//span[@class='duration ng-binding']"));
					}catch(Exception e){
	   		System.out.println("duration");
	   		}
	   		return elements;	
		
		}
	
	 public static List<WebElement> changeOwnRate(WebDriver driver)
		{
			try{elements =driver.findElements(By.xpath("//span[@data-ng-if='term.defaultRate']"));
					}catch(Exception e){
	   		System.out.println("changeOwnRate");
	   		}
	   		return elements;	
		
		}
	 
	 public static List<WebElement> avaliableIncentives(WebDriver driver)
		{
			try{elements =driver.findElements(By.xpath("//span[@class='cash-back ng-binding']"));
					}catch(Exception e){
	   		System.out.println("avaliableIncentives");
	   		}
	   		return elements;	
		
		}
		
		public static WebElement Enter_Own_Value(WebDriver driver)
		{
		  	try{
		element = 	driver.findElement(By.xpath("//input[@class='percentage ng-pristine ng-valid']"));
		libs.HighlightElement(driver, element);		}catch(Exception e){
	   		System.out.println("Enter_Own_Value");
	   		}
	   		return element;	
		
		}
    
    
    public static WebElement dreicon(WebDriver driver,int position)
	{
		try
		{WebDriverWait wait=new WebDriverWait(driver,200);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(@class,'dreicon icon-uni')])[position()="+position+"]")));
		libs.HighlightElement(driver, element);		}catch(Exception e){
	   		System.out.println("dreicon");
	   		}
	   		return element;	
	}
    
    

	 public static List<WebElement> paymentCalculation(WebDriver driver,String Paymenttype)
		{
			try{if(Paymenttype.equalsIgnoreCase("Finance"))
			{
				Paymenttype="buy";
			}
				elements =driver.findElements(By.xpath("//section[@data-tabname='"+Paymenttype+"']//div[@class='customPricingStackWrapper section']//tr"));
					}catch(Exception e){
	   		System.out.println("paymentCalculation");
	   		}
	   		return elements;	
		
		}
	 
	 
	 public static List<WebElement> Estimated_Monthly_Payment(WebDriver driver,String Paymenttype)
		{
		 try{if(Paymenttype.equalsIgnoreCase("Finance"))
			{
				Paymenttype="buy";
			}
		 elements =driver.findElements(By.xpath("//div[@data-ng-show='estimates.retailIncentives']//div[@data-mode='"+Paymenttype+"']//span[@class='monthly-payment ng-binding']|//div[@data-mode='"+Paymenttype+"']//span[@class='monthly-payment ng-binding']"));
					}catch(Exception e){
	   		System.out.println("Estimated_Monthly_Payment");
	   		}
	   		return elements;	
		
		}
    
    
	 public static WebElement Annual_Mileage (WebDriver driver)
		{
				try
				{element = driver.findElement(By.xpath("//select[@data-ng-model='leaseMiles']"));
		libs.HighlightElement(driver, element);}catch(Exception e){
		
		}
				return element;
		}
    
    
    
    
    
    
    
    
    public static WebElement dreicon1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,200);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div[2]/section[2]/div/div[2]/div/table/tbody/tr[14]/td[3]/span")));
		libs.HighlightElement(driver, element);		return element;	
	}
    public static List<WebElement> buyPricingStack(WebDriver driver)
	{
		elements =driver.findElements(By.xpath("(//div[@class='sidebar ng-scope'])[position()=1]//tr"));
	 	return elements;
	}
    public static List<WebElement> buyPricingStackHeading(WebDriver driver)
	{
		elements =driver.findElements(By.xpath("(//div[@class='sidebar ng-scope'])[position()=1]//tr/th"));
	 	return elements;
	}
    public static List<WebElement> buyPricingStackValues(WebDriver driver)
	{
		elements =driver.findElements(By.xpath("(//div[@class='sidebar ng-scope'])[position()=1]//tr/td[@class='ng-binding']"));
	 	return elements;
	}
    public static List<WebElement> downPaymentInput(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr/td[2]/input")));
	 	return elements;
	}
    
    public static List<WebElement> downPayment1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr/td/strong[@class='ng-binding']")));
	 	return elements;
	}
   
    public static WebElement step1Heading(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div/div/table[@class='accounting']/thead/tr/th")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasestep1Heading(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/thead/tr/th")));
		libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement step2Heading(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div/div/div/h2")));
		libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasestep2Heading(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/div/h2")));
		libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement availableCentives(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[@data-ng-show='dealFactory.deal.totalIncentives > 0']/td[2]")));
		libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leaseavailableCentives(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[@data-ng-show='dealFactory.deal.totalIncentives > 0']")));
		libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement preestimatedTax(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[10]")));
		libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasepreestimatedTax(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[10]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement downPaymentTextbox(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[18]/td[2]/input[@id='downPaymentsMode']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasedownPaymentTextbox(WebDriver driver)
	{
		WebElement element =driver.findElement(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[19]/td[2]/input[@id='downPaymentsMode']"));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasedownPaymentClick(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[18]/td/a/sup")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement dealerSellingPrice(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[7]/td[2]/strong")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasedealerSellingPrice(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[7]/td[2]/strong")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement kellyTradein(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[15]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasekellyTradein(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[16]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement kellyTradeinValue(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[15]/td[@class='tabPrice ng-binding']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasekellyTradeinValue(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[16]/td[@class='tabPrice ng-binding']")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement balanceTradein(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[16]/td[@class='tabPrice']/input")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement leasebalanceTradein(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[17]/td[@class='tabPrice']/input")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement editButton(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,90);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Edit")));
	   libs.HighlightElement(driver, element);		return element;	
	}
    public static WebElement incentivesHeader(WebDriver driver)
	{
	   element=driver.findElement(By.xpath("//div[@class='col-xs-6 incentive-rates']/div[@class='section-header']"));
	 	return element;
	}
    public static WebElement userratesHeader(WebDriver driver)
	{
	   element=driver.findElement(By.xpath("//div[@class='col-xs-6 user-rates']/div[@class='section-header']/label"));
	 	return element;
	}
    public static List<WebElement> creditSectionDuration(WebDriver driver)
   	{
   	    elements=driver.findElements(By.xpath("//div[@class='terms clearfix']/span[@class='duration ng-binding']"));
   	 	return elements;
   	}
    public static List<WebElement> leasecreditSection(WebDriver driver)
	{
	  WebDriverWait wait=new WebDriverWait(driver,5);
	  List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-7 col-xl-8']/div/div/div[@class='section-header']")));
	 	return elements;
	}
	public static WebElement rateBox(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-7 col-xl-8']/div/div/div[@class='section-header']/input[@class='percentage ng-valid ng-dirty ng-valid-numeric']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement creditBox1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-6 incentive-rates']/div[3]/div/div[@class='terms clearfix']")));
	   libs.HighlightElement(driver, element);		return element;		
	}
	public static WebElement creditBox2(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-6 incentive-rates']/div[4]/div/div[@class='terms clearfix']")));
	   libs.HighlightElement(driver, element);		return element;		
	}
	public static List<WebElement> incentives(WebDriver driver)
	{
		elements =driver.findElements(By.xpath("//div[@class='col-xs-6 incentive-rates']/div[@class='ng-scope']"));
	 	return elements;
	}
	public static List<WebElement> rates(WebDriver driver)
	{
		elements =driver.findElements(By.xpath("//div[@class='col-xs-6 user-rates']/div[@class='ng-scope']"));
	 	return elements;
	}
	public static List<WebElement> estimatedtaxFooter(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='pricing-summary']/div[@class='your-price col-xs-12 col-sm-10 col-md-4']")));
	 	return elements;
	}
	public static WebElement leaseOption(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary']/div[@class='your-price col-xs-12 col-sm-10 col-md-4']")));
	   libs.HighlightElement(driver, element);		return element;	
	}

public static WebElement estimatedAmount(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[20]/td[2]/strong")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement leaseestimatedAdCapAmount(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[21]/td[2]/strong")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement estimatedMonthlyPayment(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[21]/td[2]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement leaseestimatedMonthlyPayment(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[22]/td[2]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement term(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[22]/td[2]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement leaseTerm(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[23]/td[2]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement apr(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[23]/td[2]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement estimatedAmtSign(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[24]/td[2]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement leaseAnnualMileage(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[25]/td[2]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement estimatedpretaxFooter(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary']/div[1]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement estimatedamtFooter(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary']/div[3]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement estimatedmonFooter(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pricing-summary']/div[5]")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement annualMileage(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='ng-pristine ng-valid ng-valid-required']")));
 libs.HighlightElement(driver, element);		return element;	
}
public static List<WebElement> creditBoxes(WebDriver driver)
{
	WebDriverWait wait=new WebDriverWait(driver,5);
	List<WebElement> elements=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@data-tabname='lease']/div/div/div/div[@class='col-xs-6 ng-scope']/div")));
	return elements;
}
public static WebElement leasedreIcon(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[4]/td[3]/span")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement leasedreIcon1(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[15]/td[3]/span")));
 libs.HighlightElement(driver, element);		return element;	
}
public static WebElement cashDreIcon(WebDriver driver)
{
  WebDriverWait wait=new WebDriverWait(driver,5);
  WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[4]/td[3]/span[@class='dreicon icon-uniE680']")));
 libs.HighlightElement(driver, element);		return element;	
}
public static List<WebElement> priceElements(WebDriver driver,int dRw)
{
  List<WebElement> elements=driver.findElements(By.xpath("//section[@data-tabname='cash']/div[2]/table[@class='accounting']/tbody/tr/td[2]"));
 	return elements;
}


	public static WebElement cashKellyBook(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div[2]/table[@class='accounting']/tbody/tr[11]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashbalanceTradein(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div[2]/table[@class='accounting']/tbody/tr[12]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement estimatedCash(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div[2]/table[@class='accounting']/tbody/tr[15]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement estimatedNetTradeIn(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div[2]/table[@class='accounting']/tbody/tr[13]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashtotalMSRP(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[4]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	
	
	
	public static WebElement buytotalMSRP(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[4]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasetotalMSRP(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[4]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashbaseMSRP(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[1]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buybaseMSRP(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[1]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasebaseMSRP(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,300);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[1]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashtotalOptions(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[2]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buytotalOptions(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[2]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasetotalOptions(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[2]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashdestdelcharges(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[3]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buydestdelcharges(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[3]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasedestdelcharges(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[3]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashdiffermsrp(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[5]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buydiffermsrp(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[5]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasediffermsrp(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[5]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashdealerprice(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[7]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buydealerprice(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[7]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasedealerprice(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[7]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashEstimatedPrice(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[10]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buyEstimatedPrice(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[10]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaseEstimatedPrice(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[10]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashAvalbalance(WebDriver driver)
	{
		WebElement element=driver.findElement(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[8]/td[2]"));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buyestimatedTax(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[11]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaseestimatedTax(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[11]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buytitleFee(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[12]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasetitleFee(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[12]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buydocumentationFee(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[13]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasedocumentationFee(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[14]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaseacquiFee(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[13]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buytotalTax(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[14]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasetotalTax(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[15]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashkellyblue(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[11]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buykellyblue(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[15]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasekellyblue(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[16]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashrembal(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[12]/td[2]/input")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buyrembal(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[16]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaserembal(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[17]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashtradein(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[13]/td[2]/strong")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leasetradein(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[18]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashestimatedcash(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[15]/td[2]/strong")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buyestimatedamtfinanced(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[2]/div/table[@class='accounting']/tbody/tr[20]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaseadjcapcost(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[21]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaseEstMonPayment(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[22]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaseTermVal(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[23]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaseEstAmtDue(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[24]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement leaseAnnMileage(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div/div/table[@class='accounting']/tbody/tr[25]/td[2]")));
	   libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement footer1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[@class='pricing-summary']/div[1]")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement footer2(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[@class='pricing-summary']/div[6]")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement footer4(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[@class='pricing-summary']/div[6]/h4/span[@class='dreicon icon-uniE680']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement footer5(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='popup popover-container']/div[1]/div[4]/p[3]/span")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static List <WebElement> footer6(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		List <WebElement>	elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='popup popover-container']/div/div/p[2]")));
			return elements;
	}
	public static WebElement footer3(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-4 col-sm-4 next-button']/a[@class='btn btn-dre nextTab hidden-sm hidden-xs pull-right ng-binding']")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement disclaimerFooter(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='cash']/div[3]/small")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement buydisclaimerFooter(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='buy']/div/div[4]/small")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement leasedisclaimerFooter(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div[4]/small")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement leaseFooter1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[@class='pricing-summary']/div[1]")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement leaseFooter2(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[@class='pricing-summary']/div[4]")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement leaseFooter3(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		WebElement	element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-xs-8 col-sm-8 footer-pricing']/div[@class='pricing-summary']/div[5]")));
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement leasepaymentInlinetext (WebDriver driver)
	{
	  WebDriverWait wait=new WebDriverWait(driver,150);
	  WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div[1]/div[1]/small")));
	 libs.HighlightElement(driver, element);		return element;	
	}
	public static List<WebElement> leasedownPayment(WebDriver driver)
	{
		elements =driver.findElements(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr/td[@class='ng-binding']"));
	 	return elements;
	}
	public static List<WebElement> leasedownPayment1(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,150);
		List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@data-tabname='lease']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr/td/strong[@class='ng-binding']")));
	 	return elements;
	}
    public static WebElement leasedownPayment2(WebDriver driver)
   	{
   		WebDriverWait wait=new WebDriverWait(driver,150);
   		WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='lease']/div/div[2]/div/table[@class='accounting']/tbody/tr[21]/td[2]")));
   	   libs.HighlightElement(driver, element);		return element;	
   	}
    public static List<WebElement> leasedownPayment3(WebDriver driver)
   	{
   		WebDriverWait wait=new WebDriverWait(driver,150);
   		List<WebElement> elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@data-tabname='lease']/div/div[2]/div/table[@class='accounting']/tbody/tr[@class='detail-payment-info ng-scope']/td[2]")));
   	 	return elements;
   	}
	
	
	public static WebElement btn_next_Payment_continue (WebDriver driver)
	{
		try
		{
			element = driver.findElement(By.xpath("//a[contains(text(),'Next: Payment')]"));
	        libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{
			System.out.println("btn_next_Payment_continue");
		}
		return element;
	}
	public static WebElement paymentTabs(WebDriver driver)
	{
		element = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div/div[1]/ul/li[3]/a"));			
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement cashAlertIcon(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@data-tabname='cash']/div/table[@class='accounting']/tbody/tr[13]/td[3]/span"));			
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement buyAlin(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[6]/td[2]"));			
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement buyEst(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//section[@data-tabname='buy']/div[@class='row ng-scope']/div[@class='col-xs-12 col-lg-5 col-xl-4']/div/table[@class='accounting']/tbody/tr[10]/td[2]"));			
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement paymentVerification(WebDriver driver)
	{
		element = driver.findElement(By.xpath("//a[@class='tab3 payment']"));			
		libs.HighlightElement(driver, element);	return element;
	}
	public static WebElement buyalertIcon(WebDriver driver)
	{
	 element =driver.findElement(By.xpath("//section[@class='tab-content col-xs-12 clearfix popover-container']/div/div[2]/div/table[@class='accounting']/tbody/tr[17]/td[3]/span[1]"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buyalertHeading(WebDriver driver)
	{
	 element =driver.findElement(By.xpath("//section[@class='tab-content col-xs-12 clearfix popover-container']/div[2]/h3"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buyalertText(WebDriver driver)
	{
	 element =driver.findElement(By.xpath("//section[@class='tab-content col-xs-12 clearfix popover-container']/div[2]/div/div[2]"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement buyalertClose(WebDriver driver)
	{
	 element =driver.findElement(By.xpath("//section[@class='tab-content col-xs-12 clearfix popover-container']/div[2]/div/div[1]"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement downalertIcon(WebDriver driver)
	{
	 element =driver.findElement(By.xpath("//table[@class='accounting']/tbody/tr[18]/td[3]/span"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement downalertText(WebDriver driver)
	{
	 element =driver.findElement(By.xpath("//section[@class='tab-content col-xs-12 clearfix popover-container']/div[2]/div[2]/div[2]"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement downalertClose(WebDriver driver)
	{
	 element =driver.findElement(By.xpath("//section[@class='//section[@class='tab-content col-xs-12 clearfix popover-container']/div[2]/div[2]/div[1]"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashalertHeading(WebDriver driver)
	{
	 element=driver.findElement(By.xpath("//section[@data-tabname='cash']/div[4]/h3"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashalertText(WebDriver driver)
	{
	 element=driver.findElement(By.xpath("//section[@data-tabname='cash']/div[4]/div/div[2]"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static WebElement cashalertClose(WebDriver driver)
	{
	 element=driver.findElement(By.xpath("//section[@data-tabname='cash']/div[4]/div/div[1]"));
	libs.HighlightElement(driver, element);		return element;	
	}
	public static List <WebElement> monthlyRate(WebDriver driver)
	{
	 elements=driver.findElements(By.xpath("//section[@class='tab-content col-xs-12 clearfix popover-container']/div/div[3]/div[@class='row split-deals']/div/div/div/div[2]/div[1]/span"));
		return elements;
	}
	public static  WebElement btn_SkipPaymntCal(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@data-tabname='intro']/div/div/div[3]/div[3]/div/a")));
	    return  element;	
	}
	
	public static WebElement txt_paymentType (WebDriver driver,String paymentoption)
	{
		try{	element = driver.findElement(By.xpath("(//a[@href=''][text()='"+paymentoption+"'])[position()=2]"));
			libs.HighlightElement(driver, element);}catch(Exception e){		
				System.out.println("paymentoption");
			}
			return element;
							

	}
	public static WebElement txt_downPaymentAlert (WebDriver driver)
	{
	try
	{
	 element = driver.findElement(By.xpath("(//div[@class='tradeInEstimatedNetCredit parbase section elementBase']//span)[position()=1]"));
	 libs.HighlightElement(driver, element);
	}
	catch(Exception e)
	{		
	 System.out.println("txt_hightradeinAlert");
	}
	return element;
	}
	public static WebElement txt_downPaymentAlertTitle (WebDriver driver)
	{
	try
	{
	 element = driver.findElement(By.xpath("//div[@class='popover-title']/h3"));
	 libs.HighlightElement(driver, element);
	}
	catch(Exception e)
	{		
	 System.out.println("txt_downPaymentAlertTitle");
	}
	return element;
	}
	public static WebElement txt_downPaymentAlertText (WebDriver driver)
	{
	try
	{
	 element = driver.findElement(By.xpath("//div[@class='popover-content']//div"));
	 libs.HighlightElement(driver, element);
	}
	catch(Exception e)
	{		
	 System.out.println("txt_downPaymentAlertText");
	}
	return element;
	}
	public static WebElement tab_vehicleDetailsTab (WebDriver driver)
	{
	try
	{
	 element = driver.findElement(By.xpath("//li[@class='single-tab vehicle-details active']"));
	 libs.HighlightElement(driver, element);
	}
	catch(Exception e)
	{		
	 System.out.println("tab_vehicleDetailsTab");
	}
	return element;
	}
	public static WebElement tab_payment (WebDriver driver)
	{
	try
	{
	 element = driver.findElement(By.xpath("//li[@class='single-tab payment complete']"));
	 libs.HighlightElement(driver, element);
	}
	catch(Exception e)
	{		
	 System.out.println("tab_vehicleDetailsTab");
	}
	return element;
	}
	public static WebElement val_avlincentives (WebDriver driver)
	{
	try
	{
	 element = driver.findElement(By.xpath("//li[@class='single-tab vehicle-details active']"));
	 libs.HighlightElement(driver, element);
	}
	catch(Exception e)
	{		
	 System.out.println("tab_vehicleDetailsTab");
	}
	return element;
	}
	
	public static WebElement lnk_KBBTradeIn(WebDriver driver)
	{
	try
	{
	 element = driver.findElement(By.xpath("//a[@data-ng-click=\"goToTab('trade-in')\"]"));
	 libs.HighlightElement(driver, element);
	}
	catch(Exception e)
	{		
	 System.out.println("lnk_KBBTradeIn");
	}
	return element;
	}
	public static List<WebElement> paymentTypes(WebDriver driver)
		{
		 try{
			WebDriverWait wait=new WebDriverWait(driver,5);
	    	elements = driver.findElements(By.xpath("(//div[@class = 'row small-gutters'])[position()=1]//a"));
		 }
			catch(Exception e)
			{		
			 System.out.println("paymentTypes");
			}
			return elements;
		}
	
	 public static WebElement Select_AnnualPayment(WebDriver driver)
		{
		 try{
			WebDriverWait wait=new WebDriverWait(driver,5);
	    	element = driver.findElement(By.xpath("//select[@data-ng-model='leaseMiles']"));
		 }
			catch(Exception e)
			{		
			 System.out.println("Select_AnnualPayment");
			}
			return element;
		}
	 
	 public static List<WebElement> monthlyPaymentsList(WebDriver driver)
		{
		 try{
			WebDriverWait wait=new WebDriverWait(driver,5);
	    	elements = driver.findElements(By.xpath("(//span[@class = 'monthly-payment ng-binding'])[position()=1]"));
		 }
			catch(Exception e)
			{		
			 System.out.println("monthlyPaymentsList");
			}
			return elements;
		}
	 
	 public static WebElement monthlyPayments(WebDriver driver , int position)
		{
		 try{
			WebDriverWait wait=new WebDriverWait(driver,5);
	    	elements = driver.findElements(By.xpath("(//span[@class = 'monthly-payment ng-binding'])[position()="+position+"]"));
		 }
			catch(Exception e)
			{		
			 System.out.println("lnk_KBBTradeIn");
			}
			return element;
		}
	 
		public static WebElement txt_EstimateKBBTradeInValue(WebDriver driver)
		{
		try
		{
		 element = driver.findElement(By.xpath("(//div[@class='tradeInEstimatedNetCredit parbase section elementBase']//td[@class='ng-binding'])[position()=1]"));
		 libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{		
		 System.out.println("txt_EstimateKBBTradeInValue");
		}
		return element;
		}
		
		public static WebElement txt_EstimateKBBTradeInInput(WebDriver driver)
		{
		try
		{
		 element = driver.findElement(By.xpath("(//div[@class='tradeInEstimatedNetCredit parbase section elementBase']//td[@class='tabPrice']//input)[position()=1]"));
		 libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{		
		 System.out.println("txt_EstimateKBBTradeInInput");
		}
		return element;
		}
		
		public static WebElement txt_EstimateKBBTradeInPopupHeader(WebDriver driver)
		{
		try
		{
		 element = driver.findElement(By.xpath("//h4[@class = 'modal-title']"));
		 libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{		
		 System.out.println("txt_EstimateKBBTradeInPopupHeader");
		}
		return element;
		}
		
		public static WebElement txt_EstimateKBBTradeInPopupBody(WebDriver driver)
		{
		try
		{
		 element = driver.findElement(By.xpath("//h4[@class = 'modal-title']"));
		 libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{		
		 System.out.println("txt_EstimateKBBTradeInPopupBody");
		}
		return element;
		}
		
		public static WebElement btn_EstimateKBBTradeInPopupClose(WebDriver driver)
		{
		try
		{
		 element = driver.findElement(By.xpath("//button[@type= 'button'][@class = 'btn btn-primary']"));
		 libs.HighlightElement(driver, element);
		}
		catch(Exception e)
		{		
		 System.out.println("btn_EstimateKBBTradeInPopupClose");
		}
		return element;
		}
		 public static WebElement EstmMonthlyPaymentMonts (WebDriver driver)
			{
					try
					{element = driver.findElement(By.xpath("//table[@class = 'elementComponent']//th[contains(text(),'Estimated Monthly Payment')]/..//td[@class = 'ng-binding']//span"));
			libs.HighlightElement(driver, element);}catch(Exception e){
			
			}
					return element;
			}
		 public static WebElement TermInMonths (WebDriver driver)
			{
					try
					{element = driver.findElement(By.xpath("//table[@class = 'elementComponent']//th[contains(text(),'Term')]/..//td[@class = 'ng-binding']"));
			libs.HighlightElement(driver, element);}catch(Exception e){
			
			}
					return element;
			}
		
}
