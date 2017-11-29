package pageObjectClasses;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

import libraryClasses.FuncitonLibrary;
public class PGO_vehicleCards extends FuncitonLibrary
 {
	
	private static WebElement element = null;
	private static List<WebElement> elements;
	static FuncitonLibrary libs=new FuncitonLibrary();
	
//	Below are the POs for Vehicle cards functionality

	public static WebElement txt_addNewVehicle  (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class ='col-sm-4 saved-vehicles-card add-vehicle']//div[@class='card-content']"));
			libs.HighlightElement(driver, element);
				}catch(Exception e){
//					test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
					System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_addNewVehicle_heading (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='col-sm-4 saved-vehicles-card add-vehicle']/div[@class='card-content']/div[@class='rsg']/h1[@class='rsg-title']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_addNewVehicle_subheading (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='col-sm-4 saved-vehicles-card add-vehicle']/div[@class='card-content']/div[@class='rsg']/p[@class='rsg-available']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_addNewVehicle_dealerTitle (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='col-sm-4 saved-vehicles-card add-vehicle']/div[@class='card-content']/div[@class='rsg']/p[@class='dealer-title']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_addNewVehicle_dealerDistance (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='col-sm-4 saved-vehicles-card add-vehicle']/div[@class='card-content']/div[@class='rsg']/p[@class='dealer-distance ng-binding']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement img_addNewVehicle_icon (WebDriver driver)
	{
			try{element = driver.findElement(By.xpath("//div[@class='add-new-deal']/p[@class='dreicon icon-uniE648 add-icon']"));
			libs.HighlightElement(driver, element);
	}catch(Exception e){
   	 test.log(LogStatus.FAIL,"Not Identified object and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
    		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
    	}
	return element;
	}
	public static WebElement img_addNewVehicle_link (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='add-new-deal']//h1|//div[@class='add-new-deal']//h3"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement returnSearchResults (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//a[@class='logo']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement img_searchInventory_link (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='add-new-deal']/p[2]"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement vehIconno(WebDriver driver)
   {
          try{ element = driver.findElement(By.xpath("//div[@class='saved-vehicles-icon']//span[@class='icon-number ng-binding']"));
		   libs.HighlightElement(driver, element);
         }catch(Exception e){
        	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
         		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
         	}
 
          return element;
  }
  public static List<WebElement> txt_vehicleCardInfo (WebDriver driver)
	{
	 
	  try{
		  List<WebElement> elements=driver.findElements(By.xpath("//div[@class='col-sm-4 saved-vehicles-card Active']/div[@class='card-content']"));
	  
	  }catch(Exception e){
	    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
	     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
	     	}

	  libs.HighlightElement(driver, element); return elements;
	}
	public static WebElement img_savedDeal1 (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//a[@data-ng-href='deal-details#/0/vehicle-details']/img[@class='img-responsive']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_EstTax_Price (WebDriver driver,int vinnumber )
	{
		try{
			element = driver.findElement(By.xpath("(//p[@class='price ng-binding'])[position()="+vinnumber+"]"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_savedDeal1_viewDetails (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='view-delete ng-scope']/p/a[@class='ng-binding']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement  img_deleteIcon(WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='view-delete ng-scope']/p/a[@class='dreicon icon-uniE67F']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}

	public static WebElement txt_savedDeal1_dealerTitle (WebDriver driver,int vinnumber)
	{
		try{
			element = driver.findElement(By.xpath("(//p[@class='dealer-name ng-binding'])[position()="+vinnumber+"]"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_savedDeal1_dealerDistance (WebDriver driver,int vinnumber)
	{
		try{
			element = driver.findElement(By.xpath("(//p[@class='dealer-location ng-binding'])[position()="+vinnumber+"]"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_savedDeal1_vehicleName (WebDriver driver,int vinnumber)
	{
		try{
			element = driver.findElement(By.xpath("(//h1[@class='vehicle-ymm ng-binding'])[position()="+vinnumber+"]"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement txt_savedDeal1_vehicleVin (WebDriver driver,int vinnumber)
	{
		try{
			element = driver.findElement(By.xpath("(//p[@class='vin ng-binding'])[position()="+vinnumber+"]"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement delete_deal_overlay (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='modal-content']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement delete_deal_heading (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='modal-content']/div[@class='modal-body text-center']/h4"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement delete_deal_subheading (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='delete-vehicle-overlay-body']/p"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static <List>WebElement delete_deal_btn (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//div[@class='modal-footer']/button"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	}
	public static WebElement closePopup (WebDriver driver)
	{
		try{
			element = driver.findElement(By.xpath("//button[@class='close']"));
			libs.HighlightElement(driver, element);
	 }catch(Exception e){
//    	 test.log(LogStatus.FAIL,"Missing object name  and method name ", new Exception().getStackTrace()[0].getMethodName()+":"+new Exception().getStackTrace()[1].getMethodName());
     		System.out.println("vehIconno is not there in "+ new Exception().getStackTrace()[0].getMethodName());
     	}
	return element;
	
	}
	

	}

