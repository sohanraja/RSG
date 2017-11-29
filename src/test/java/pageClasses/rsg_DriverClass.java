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
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import libraryClasses.FuncitonLibrary;
import utilityClasses.ExcelUtilityClass;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class rsg_DriverClass extends FuncitonLibrary {

	
	public   FuncitonLibrary libs = new FuncitonLibrary();
	WebDriver driver1;
	@BeforeClass
	public WebDriver getDriver() throws IOException 
	{
		
		
		
		data = new ExcelUtilityClass();
		if(this.getClass().getName().contains("RSGQA")) {
			applicationname="RSGQA";
		   
		   File dir = new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+libs.datestamp());
			dir.mkdirs();
		}else if(this.getClass().getName().contains("CTPQA"))
		{
			applicationname="CTPQA";
			   
			   File dir = new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+libs.datestamp());
				dir.mkdirs();
		}else if(this.getClass().getName().contains("RSGINT"))
		{
			applicationname="RSGINT";
			   
			   File dir = new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+libs.datestamp());
				dir.mkdirs();
		}else if(this.getClass().getName().contains("CTPINT"))
		{
			applicationname="CTPINT";
			   
			   File dir = new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+libs.datestamp());
				dir.mkdirs();
		}else
		{
			applicationname="RSGDEV";
			   
			   File dir = new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+libs.datestamp());
				dir.mkdirs();
		}
	
	
//		String browser_val = null;
		try {
		

			File file = new File(System.getProperty("user.dir")+"/TestData"+applicationname+".xlsx");
			System.out.println("user dir : "+file);
			FileInputStream fis = new FileInputStream(file);
			File fileToDelete= new File(System.getProperty("user.dir")+"/Reports/"+applicationname+"/"+libs.datestamp()+"/TestData"+applicationname+".xlsx");
			
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
//			url 		= data.getStrExcelData(1, 1, 0);
			
		System.out.println(browser_val);
		
		return Brosweropen(browser_val);

		
	}
	public WebDriver Brosweropen(String browsername)
	{
		switch (browser_val) 
		{
		case "ie":
			String ie_srvr_path = "C:/Users/SSubra68/workspace/RSG/RSG_DRE/libs/Browserdrivers/IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", ie_srvr_path);
//			driver = new InternetExplorerDriver();
			//driver.manage().window().maximize();
			System.out.println("one");
//			driver.get(url);
			break;
		case "firefox":
			File pathToBinary = new File("C:/Program Files/Mozilla Firefox/firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			System.setProperty("webdriver.gecko.driver", "C:/Users/SSubra68/Downloads/browserDrivers/geckodriver.exe");
			 FirefoxProfile myProfile = new FirefoxProfile();
//			 myProfile.setAcceptUntrustedCertificates(true);
//			 myProfile.setAssumeUntrustedCertificateIssuer(false);
//			driver = new FirefoxDriver(ffBinary,myProfile);
			//driver.manage().window().maximize(); 
			System.out.println("two");
////			Gecko
//			String ff_srvr_path = "C:/Users/SSubra68/Downloads/browserDrivers/geckodriver.exe";
//			System.setProperty("webdriver.gecko.driver", ff_srvr_path);
//			FirefoxProfile profile = new FirefoxProfile();
//			profile.setAcceptUntrustedCertificates(true);
//			profile.setAssumeUntrustedCertificateIssuer(false);
//			DesiredCapabilities caps = DesiredCapabilities.firefox();
//			caps.setCapability(FirefoxDriver.PROFILE, profile);
//			driver = new FirefoxDriver(profile);
//			driver.get(url);
//			driver.manage().window().maximize();
//			System.out.println("two");
			break;
		case "chrome":
			String path = System.getProperty("user.dir");
			System.out.println(path);
			String  chrome_srvr_path = System.getProperty("user.dir")+"/chromedriver";
			System.setProperty("webdriver.chrome.driver", chrome_srvr_path);
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--disable-extensions");
			
			// head less mode code
//			ChromeOptions chromeOptions = new ChromeOptions();
////		      chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
//		      chromeOptions.addArguments("headless");
//		      chromeOptions.addArguments("window-size=1200x600");
//		      WebDriver Driver = new ChromeDriver(chromeOptions);
			
			
			driver1 = new ChromeDriver();
			driver=new EventFiringWebDriver(driver1);
			//driver.register(libs);
//			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
//			driver.get(url);
			System.out.println("Chrome Browser opened");
//			driver = new HtmlUnitDriver();
			break;

		default:
			System.out.println("default");
		}
//	}
		
		return driver;
	}
	@AfterSuite
	public void closebrowsers() throws Exception
	{
		System.out.println("SCript has come to end");
		libs.tearReport();
		libs.testSenariostearsReport();
		//driver.unregister(libs);
//	
//		Runtime.getRuntime().exec("TASKKILL /IM chromedriver.exe /F");    // closing the IE.exe, ChromeDriver.exe process from the system
//        Runtime.getRuntime().exec("TASKKILL /IM chrome.exe /F");
	}
	@AfterTest
    public void closeDriver(){

        if(driver != null){
            driver.close();
//            driver.quit();

        }
    }


}
