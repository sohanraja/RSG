package pageClasses;



import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.common.io.Files;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import libraryClasses.FuncitonLibrary;
import utilityClasses.ExcelUtilityClass;

//import static org.monte.media.AudioFormatKeys.*;
//import static org.monte.media.VideoFormatKeys.*;

public class rsg_DriverClass extends FuncitonLibrary {

	
	public   FuncitonLibrary libs = new FuncitonLibrary();
	WebDriver driver1;
	@BeforeClass
	public WebDriver getDriver() throws Exception 
	{
		
		data = new ExcelUtilityClass();
		if(this.getClass().getName().contains("RSGQA")) {
			applicationname="RSGQA";
		   
		   File dir = new File(System.getProperty("user.dir")+"\\Reports\\"+applicationname+"\\"+libs.datestamp());
			dir.mkdirs();
		}else if(this.getClass().getName().contains("CTPQA"))
		{
			applicationname="CTPQA";
			   
			   File dir = new File(System.getProperty("user.dir")+"\\Reports\\"+applicationname+"\\"+libs.datestamp());
				dir.mkdirs();
		}else if(this.getClass().getName().contains("RSGINT"))
		{
			applicationname="RSGINT";
			   
			   File dir = new File(System.getProperty("user.dir")+"\\Reports\\"+applicationname+"\\"+libs.datestamp());
				dir.mkdirs();
		}else if(this.getClass().getName().contains("CTPINT"))
		{
			applicationname="CTPINT";
			   
			   File dir = new File(System.getProperty("user.dir")+"\\Reports\\"+applicationname+"\\"+libs.datestamp());
				dir.mkdirs();
		}else
		{
			applicationname="RSGDEV";
			   
			   File dir = new File(System.getProperty("user.dir")+"\\Reports\\"+applicationname+"\\"+libs.datestamp());
				dir.mkdirs();
		}
	
	

		try {
		

			File file = new File(System.getProperty("user.dir")+"\\TestData"+applicationname+".xlsx");
			System.out.println("user dir : "+file);
			FileInputStream fis = new FileInputStream(file);
			File fileToDelete= new File(System.getProperty("user.dir")+"\\Reports\\"+applicationname+"\\"+libs.datestamp()+"\\TestData"+applicationname+".xlsx");
			
			if(fileToDelete.delete()){

			    Files.copy(file, fileToDelete);
			}else{
				Files.copy(file, fileToDelete);
			}
		} catch (Exception e1) {
			Count++;
			System.out.println("Excel sheet is not copied");
		}

			browser_val = data.getStrExcelData(1, 2, 0);

			
		System.out.println(browser_val);
		
		return Brosweropen(browser_val);

		
	}
	public WebDriver Brosweropen(String browsername)
	{
		switch (browser_val) 
		{
		case "ie":
			String ie_srvr_path = "C:\\Users\\SSubra68\\workspace\\RSG\\RSG_DRE\\libs\\Browserdrivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", ie_srvr_path);

			System.out.println("one");

			break;
		case "firefox":
			File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SSubra68\\Downloads\\browserDrivers\\geckodriver.exe");
			 FirefoxProfile myProfile = new FirefoxProfile();

			System.out.println("two");

			break;
		case "chrome":
			String path = System.getProperty("user.dir");
			System.out.println(path);
			String  chrome_srvr_path = System.getProperty("user.dir")+"\\libs\\Browserdrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chrome_srvr_path);
			ChromeOptions options = new ChromeOptions();

			
			
			driver1 = new ChromeDriver();
			driver=new EventFiringWebDriver(driver1);

			driver.manage().window().maximize();

			System.out.println("Chrome Browser opened");

			break;

		default:
			System.out.println("default");
		}

		
		return driver;
	}
	@AfterSuite
	public void closebrowsers() throws Exception
	{
		System.out.println("SCript has come to end");
		libs.tearReport();
		libs.testSenariostearsReport();

	}
	@AfterTest
    public void closeDriver(){

        if(driver != null){
            driver.close();


        }
    }
	public String  DateDifference(int NoOfDays,String  dateformate ) throws Exception{
		
		SimpleDateFormat formatter = new SimpleDateFormat(dateformate);
		Calendar c = Calendar.getInstance();
	    c.setTime(new Date()); 
	    c.add(Calendar.DATE, NoOfDays); 
	    String output = formatter.format(c.getTime());

	    return output;
	    
	    


	}


}
