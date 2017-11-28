package pageClasses;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import libraryClasses.*;
import pageObjectClasses.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilityClasses.*;
public class kbbTradeIn extends rsg_DriverClass{

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	WebDriverWait wait = new WebDriverWait(driver,20);

	Actions actions = new Actions(driver);

	String kbbYearSelect;
	String kbbMakeSelect ;
	String kbbModelSelect ;
	String kbbTrimSelect ;
	String kbbMileageInput ;
	String kbbZipInput ;
	String kbbResponseCondition;
	int sheetNum =6;



	public void KbbTrdIn_run(int dRw) throws Exception
	{
		 kbbYearSelect = data.getExcelData(dRw, "kbbYearSelect", "KBBTradeIn");
		 kbbMakeSelect = data.getExcelData(dRw, "kbbMakeSelect", "KBBTradeIn");
		 kbbModelSelect = data.getExcelData(dRw, "kbbModelSelect", "KBBTradeIn");
		 kbbTrimSelect = data.getExcelData(dRw, "kbbTrimSelect", "KBBTradeIn");
		 kbbMileageInput = data.getExcelData(dRw, "kbbMileageInput", "KBBTradeIn");
		 kbbZipInput = data.getExcelData(dRw, "kbbZipInput", "KBBTradeIn");
		 kbbResponseCondition = data.getExcelData(dRw, "kbbResponseCondition", "KBBTradeIn");
		try
		{
		String runVal = data.getExcelData(dRw, "KBB Trade In", "Testcases");
		System.out.println(runVal);
		invokeReport("Verify KBBTradeIn",dRw);
		test.log(LogStatus.INFO, "Verify KBB Trade-In Module", "KBB Trade-In page displayed");
		switch(runVal)
		{
		case"Yes":
				test.log(LogStatus.INFO, "Trade-In execution starts.." );
				System.out.println("ValidationStatus : "+ValidationStatus);
				if(ValidationStatus.equalsIgnoreCase("Yes")){
					kbbTradeAllValidation(dRw);
     			}
				else {
					Thread.sleep(2000);
					kbbTradeinMainmtd(dRw);
					data.writeExceldata(dRw,"Result", "KBBTradeIn","Passed");
				}
				break;
			case"No":
				skipKBBTrade(dRw);
				test.log(LogStatus.INFO, "KBB Trade-In Module is not executed. Customer chose Skip Trade in.");
				data.writeExceldata(dRw, "Result", "KBBTradeIn", "Not Executed");
				break;
			}

			tearReport();
		
		}
		catch(Exception kbbtradin)
		 {
			Count++;
			getscrnSht.getscreenshot(driver, scrnshtPth+"KBBTrade-In_Failed"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, kbbtradin.getMessage(),test.addScreenCapture(scrnshtPth +"kbbtradin_Failed"+libs.timestamp1()+".jpg") );		
			data.writeExceldata(dRw,"Result", "KBBTradeIn","Failed");
			tearReport();	
		
		}

	}

	public void skipKBBTrade(int dRw) throws Exception{
		try{

		libs.clickOnButton(PGO_kbbTradeIn.btn_SkipKBB(driver), "Skip Trade in");
		test.log(LogStatus.PASS, "Trade-In skipped and navigated to Payment Intro page successfully" );
		}
		catch(Exception skip){
			Count++;
			getscrnSht.getscreenshot(driver, scrnshtPth+"skipKBBTrade_Failed"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, skip.getMessage(),test.addScreenCapture(scrnshtPth +"skipKBBTrade_Failed"+libs.timestamp1()+".jpg") );		
			data.writeExceldata(dRw,"Result", "KBBTradeIn","Failed");
		}
	}

	public void kbbTradeAllValidation(int dRw) throws Exception
	{
		String valueChoose ;
		System.out.println(data.getExcelData(1, "DateDiff", "KBBTradeIn"));
		int DateDifference = Integer.parseInt(data.getExcelData(1, "DateDiff", "KBBTradeIn"));
		String bottomtext=data.getExcelData(1, "Bottom_Text", "Vehicle Details");
		SimpleDateFormat formatter = new SimpleDateFormat("MMM d, YYYY");
	    bottomtext=bottomtext.replaceAll("Date", formatter.format(date));
	    
		if(ValidationStatus.equalsIgnoreCase("Yes")){
			try {

		//KBB Trade-IN home Page
		
		libs.componenttHeading("KBB Trade-In Introduction Page");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "KBB_HomePage_header", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageSubHeader(driver), data.getExcelData(1, "KBB_HomePage_Subheader", "KBBTradeIn"), "KBB_HomePage_SubHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageFooter(driver),bottomtext, "KBB_HomePage_Footer", "");
		libs.Pagedisclaimers("KBBTradeIn",2);
		libs.Disclosers();
		Thread.sleep(3000);
		libs.clickOnButton(PGO_kbbTradeIn.btn_enterVehicleInfo(driver), "btn_enterVehicleInfo");
		
		Thread.sleep(3000);
		libs.componenttHeading("Vehicle Info");
		libs.VerifyText(PGO_kbbTradeIn.kbbVehicleInfoPageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "kbbVehicleInfoPageHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbVehicelInfoPageSubHeader(driver), data.getExcelData(1, "kbb_Vehicel_InfoPage_SubHeader", "KBBTradeIn"), "kbbVehicelInfoPageSubHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageFooter(driver), bottomtext, "kbbHomePageFooter_InfoPage", "");
		test.log(LogStatus.PASS, "Navigated to Vehicle Info section - Trade-In page successfully" );
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbYearSelect(driver), kbbYearSelect, "kbbYearSelect",0);
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbMakeSelect(driver), kbbMakeSelect, "kbbMakeSelect",0);
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbModelSelect(driver), kbbModelSelect, "kbbModelSelect",0);
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbTrimSelect(driver), kbbTrimSelect, "kbbTrimSelect",0);
		libs.enterValueIntoTextField(PGO_kbbTradeIn.txt_kbbMileageInput(driver), "kbbMileageInput", kbbMileageInput);
		test.log(LogStatus.PASS, "Vehicle Info details entered successfully" );
		String vehicelDetails = kbbYearSelect+" "+kbbMakeSelect+" "+kbbModelSelect+" | "+kbbTrimSelect+" | "+kbbMileageInput+" "+"miles"+" "+" Change|Delete".trim();
		libs.Pagedisclaimers("KBBTradeIn",2);
		libs.Disclosers();
		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		test.log(LogStatus.PASS, "Trade in vehicle info completed and clicked on continue" );
		
		libs.componenttHeading("Add Options");
		libs.VerifyText(PGO_kbbTradeIn.kbbAddOptionPageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "kbbAddOptionPageHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbTradeInPageHeader(driver), vehicelDetails, "kbbTradeInPageHeader_AddOptions", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbAddOptionPageSubHeader(driver), data.getExcelData(1, "kbb_Trade_InPage_SubHeader", "KBBTradeIn"), "kbbAddOptionPageSubHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageFooter(driver), bottomtext, "kbbHomePageFooter_AddOptions", "");
		test.log(LogStatus.PASS, "Navigated to Add Options - Trade-In page successfully" );
		Thread.sleep(2000);
		libs.Pagedisclaimers("KBBTradeIn",2);
		libs.Disclosers();
		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		test.log(LogStatus.PASS, "Add options completed and clicked on continue" );
		Thread.sleep(2000);
		
		libs.componenttHeading("CONDITION & VALUE");
		libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "kbbConditionValuePageHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageSubHeader(driver), vehicelDetails, "kbbConditionValuePageSubHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbChooseConditiontxt(driver), data.getExcelData(1, "choose_Condition", "KBBTradeIn"), "kbbChooseConditiontxt", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbtxt(driver), data.getExcelData(1, "Kelley_Blue_Book", "KBBTradeIn"), "Kelley_Blue_Book(kbbtxt)", "");
		test.log(LogStatus.PASS, "Navigated to Condition & Value - Trade-In page successfully" );
		//radio txt validations
		libs.componenttHeading("Condition & Value text verification");
		//radio arrow=ra
		try{
			int arwCount = PGO_kbbTradeIn.arw_radioarrow(driver).size();
			for(int ra=0;ra<arwCount;ra++){
				libs.clickOnButton(PGO_kbbTradeIn.arw_radioarrow(driver).get(ra), "arrow buttons");
				libs.VerifyText(PGO_kbbTradeIn.txt_radiodesc(driver).get(ra), data.getExcelData(1, "Radio_desc"+ra, "KBBTradeIn"), "txt_radiodesc"+ra, "txt_radiodesc");
				libs.clickOnButton(PGO_kbbTradeIn.arw_radioarrow(driver).get(ra), "arrow buttons");
			}
		}catch(Exception kbbException){
		}
		libs.clickOnButton(driver.findElement(By.xpath("(//div[@class='radio'])[last()-5]/label")),"radios");
		valueChoose = data.getExcelData(1, "Value_choose", "KBBTradeIn");
//		String ConditionBottemFotter = data.getExcelData(1, "kbb_TradeIn_Condition_ValuePage_Footer", "KBBTradeIn");
//		String kbbTradeInSummaryPageFooter = data.getExcelData(1, "kbb_TradeIn_SummaryPage_Footer", "KBBTradeIn");
//	    SimpleDateFormat sdf = new SimpleDateFormat("MM/d/yy");
//	    Calendar c = Calendar.getInstance();
//	    c.setTime(new Date()); 
//	    kbbTradeInSummaryPageFooter =kbbTradeInSummaryPageFooter.replaceAll("fromDate", sdf.format(c.getTime()));
//	    ConditionBottemFotter = ConditionBottemFotter.replaceAll("fromDate", sdf.format(c.getTime()));
//	    valueChoose = valueChoose.replaceAll("fromDate", sdf.format(c.getTime()));
//	    c.add(Calendar.DATE, DateDifference); 
//	    String output = sdf.format(c.getTime());
//	    valueChoose = valueChoose.replaceAll("toDate", output);
//	    kbbTradeInSummaryPageFooter = kbbTradeInSummaryPageFooter.replaceAll("toDate", output).trim();
//	    ConditionBottemFotter = ConditionBottemFotter.replaceAll("toDate", output).trim();
	
		libs.componenttHeading("Enter Your Own Value Option in Trade-In");
		libs.VerifyText(PGO_kbbTradeIn.kbbVehicleChoosed(driver), valueChoose, "kbbVehicleChoosed", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbEnterOwnDealOption(driver),data.getExcelData(1, "ChooseYoueDeal", "KBBTradeIn") , "kbbEnterOwnDealOption", "");
		//Enter Your Own Value Validation
		String enteryourval=data.getExcelData(dRw, "EnterYourOwnValueOption", "KBBTradeIn");
		System.out.println(enteryourval);
		if(enteryourval.equalsIgnoreCase("Yes"))
		{
			libs.clickOnButton(PGO_kbbTradeIn.kbbEnterOwnDealOptionCheckBox(driver), "kbbEnterOwnDealOptionCheckBox ");
			libs.enterValueIntoTextField(PGO_kbbTradeIn.kbbEnterOwnValueTxtBox(driver), "kbbEnterOwnValueTxtBox",data.getExcelData(1, "EnterYourOwnValue", "KBBTradeIn"));
			libs.enterValueIntoTextField(PGO_kbbTradeIn.kbbEnterOwnValueTxtArea(driver), "kbbEnterOwnValueTxtArea",data.getExcelData(1, "kbbEnterOwnValueTxtArea", "KBBTradeIn"));	 
		    test.log(LogStatus.PASS, "Enter Your Own Value Option is selected and Value is entered in Condition & Value Page");
		 }
		 else
		 {
			 libs.clickOnButton(PGO_kbbTradeIn.kbbEnterOwnDealOptionCheckBox(driver), "kbbEnterOwnDealOptionCheckBox ");
			 libs.enterValueIntoTextField(PGO_kbbTradeIn.kbbEnterOwnValueTxtBox(driver), "kbbEnterOwnValueTxtBox",data.getExcelData(1, "EnterYourOwnValue", "KBBTradeIn"));
			 libs.enterValueIntoTextField(PGO_kbbTradeIn.kbbEnterOwnValueTxtArea(driver), "kbbEnterOwnValueTxtArea",data.getExcelData(1, "kbbEnterOwnValueTxtArea", "KBBTradeIn"));
			 libs.clickOnButton(PGO_kbbTradeIn.kbbEnterOwnDealOptionCheckBox(driver), "kbbEnterOwnDealOptionCheckBox ");
			 test.log(LogStatus.PASS, "Enter Your Own Value Option is selected and Value is entered in Condition & Value Page and check box is cleared");
		 }
		//libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageFooter(driver),ConditionBottemFotter, "kbbConditionValuePageFooter", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageCommonFooter(driver), bottomtext, "kbbConditionValuePageCommonFooter", "");
		libs.Pagedisclaimers("KBBTradeIn",2);
		libs.Disclosers();
		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		test.log(LogStatus.PASS, "Condition and Value section completed and clicked on Continue" );
		Thread.sleep(3000);
		libs.componenttHeading("SUMMARY");
		libs.VerifyText(PGO_kbbTradeIn.kbbSummaryPageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "kbbSummaryPageHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbSummaryPageSubHeader(driver), vehicelDetails, "kbbSummaryPageSubHeader", "");
		test.log(LogStatus.PASS, "Trade-In Summary Page loads successfully" );
		libs.VerifyElement(PGO_kbbTradeIn.link_Change(driver), "Change", driver, test, 1);
		libs.VerifyElement(PGO_kbbTradeIn.link_Delete(driver), "Delete", driver, test, 1);
		libs.componenttHeading("Enter Your Own Value Verification in Trade-In Summary Page");
		//Enter Your Own Validation Verification in Trade-In Summary Page
		if(enteryourval.equalsIgnoreCase("Yes"))
		{
		  System.out.println(PGO_kbbTradeIn.kbbSummaryPageentervalheading(driver).getText().replaceAll("[^A-Za-z]", "").trim());
		  String expected=	data.getExcelData(dRw, PGO_kbbTradeIn.kbbSummaryPageentervalheading(driver).getText().replaceAll("[^A-Za-z]", "").trim(),"KBBTradeIn");
		  System.out.println(expected);
		  libs.VerifyElement(PGO_kbbTradeIn.kbbSummaryPageenterval(driver), "kbbSummaryPageenterval", driver, test, dRw);
		  libs.VerifyText(PGO_kbbTradeIn.kbbSummaryPageenterval(driver), data.getExcelData(dRw, PGO_kbbTradeIn.kbbSummaryPageentervalheading(driver).getText().replaceAll("[^A-Za-z]", "").trim(), "KBBTradeIn"), "kbbSummaryPageenterval", "Yes");
		}
		else
		{
		  libs.VerifyElement(PGO_kbbTradeIn.kbbSummaryPageenterval(driver), "kbbSummaryPageenterval", driver, test, dRw);
		}
		Thread.sleep(3000);
		System.out.println("Excel Values: "+kbbTrimSelect+" :: "+kbbMileageInput+" :: "+kbbResponseCondition+" :: "+PGO_kbbTradeIn.kbbResponseTotalTxtValue(driver).getText());
		data.writeExceldata(dRw,"VehicleTrim", "KBBTradeIn", kbbTrimSelect);
		data.writeExceldata(dRw, "VehicleMileage", "KBBTradeIn", kbbMileageInput);
		data.writeExceldata(dRw, "Condition", "KBBTradeIn", kbbResponseCondition);
		data.writeExceldata(dRw, "KelleyBlueBookTradeInValueA", "KBBTradeIn", PGO_kbbTradeIn.kbbResponseTotalTxtValue(driver).getText().replaceAll("[\\D]", "").trim());
		driver.switchTo().frame(driver.findElement(By.id("kbbWidget")));
		libs.IMGValidation(PGO_kbbTradeIn.kbbSummaryPageImg(driver), "KBB Trade-in Range Img", "KBB trade in image is displayed", "kbbSummaryPageImg");  
		driver.switchTo().defaultContent();
		//libs.VerifyText(PGO_kbbTradeIn.kbbTradeInSummaryPageFooter(driver), kbbTradeInSummaryPageFooter, "kbb_TradeIn_SummaryPage_Footer", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageCommonFooter(driver), bottomtext, "kbbConditionValuePageCommonFooter", "");
		libs.Pagedisclaimers("KBBTradeIn",2);
		libs.Disclosers();
		
		}catch(Exception kbbException){
			Count++;
			getscrnSht.getscreenshot(driver, scrnshtPth+"KbbTradin_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, kbbException.getMessage(),test.addScreenCapture(scrnshtPth +"ChatwindwVal_Failed_"+libs.timestamp1()+".jpg") );		
			data.writeExceldata(dRw,"Result", "KBBTradeIn","Failed");
		}
		}
	}	
	

	public void kbbTradeinMainmtd(int dRw) throws Exception
	{
		try {
			System.out.println("Starts");
		
		libs.clickOnButton(PGO_kbbTradeIn.btn_enterVehicleInfo(driver), "btn_enterVehicleInfo");
		Thread.sleep(5000);

		test.log(LogStatus.PASS, "Navigated to Vehicle Info section - Trade-In page successfully" );
		//vehicle Info tab
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbYearSelect(driver), kbbYearSelect, "kbbYearSelect",0);
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbMakeSelect(driver), kbbMakeSelect, "kbbMakeSelect",0);
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbModelSelect(driver), kbbModelSelect, "kbbModelSelect",0);
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbTrimSelect(driver), kbbTrimSelect, "kbbTrimSelect",0);
		libs.enterValueIntoTextField(PGO_kbbTradeIn.txt_kbbMileageInput(driver), "kbbMileageInput", kbbMileageInput);
		test.log(LogStatus.PASS, "Enter all values in vehicle info tab" );

		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Trade in vehicle info completed and clicked on continue" );
		test.log(LogStatus.PASS, "Add options completed and clicked on continue" );
			libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Condition and Value section loads successfully" );
		libs.clickOnButton(driver.findElement(By.xpath("(//div[@class='radio'])[last()-5]/label")),"radios");
		test.log(LogStatus.PASS, "Condition and Value section completed and clicked on Continue" );
		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		test.log(LogStatus.PASS, "Trade-In summary page loads successfully" );
		
		

		}catch(Exception kbbException){
			Count++;
			getscrnSht.getscreenshot(driver, scrnshtPth+"KbbTradin_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, kbbException.getMessage(),test.addScreenCapture(scrnshtPth +"ChatwindwVal_Failed_"+libs.timestamp1()+".jpg") );		
			data.writeExceldata(dRw,"Result", "KBBTradeIn","Failed");
		}
			
	}


}
