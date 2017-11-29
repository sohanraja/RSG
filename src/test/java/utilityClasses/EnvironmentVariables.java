package utilityClasses;

import libraryClasses.FuncitonLibrary;

public class EnvironmentVariables {
	
	static FuncitonLibrary libs = new FuncitonLibrary();
	
	 public static final  String browserVal = "chrome";
	 public static final  String autUrl = "https:\\wwwqa.shop.ford.com/buy";
//     public static final  String aut_usrNm = "SSUBRA68";
//	 public static final  String aut_pswd = "Ford12345";
	 public static final String projName = "RSG_DRE";
	 public static final  String projPath = "C:\\Users\\SSubra68\\workspace\\RSG_DRE_QA_Saravana\\RSG_QA\\"+projName;
	 public static final  String tstDataSht = projPath+"\\TestData.xlsx";
	 public static final  String screenShtPath = projPath+"\\Screenshots\\";
	 public static final  String selDriverPath = projPath+"\\Browser_Driver\\";
	 public static final  String rprtPath = projPath+"\\Reports\\TestReport_"+libs.datestamp()+".html";
//	 Driver class constant variables
	 public static final  String ieDriverPath = selDriverPath+"IEDriverServer.exe";
	 public static final  String ffDriverPath = selDriverPath+"";
	 public static final  String chromeDriverPath = selDriverPath+"chromedriver.exe";
	 public static final  String ie_setPropVal = "webdriver.ie.driver";
	 public static final  String ff_setPropVal = "webdriver.gecko.driver";
	 public static final  String chrome_setPropVal = "webdriver.chrome.driver";
	 
	 
}
