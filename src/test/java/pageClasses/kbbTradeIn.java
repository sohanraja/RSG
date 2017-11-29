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
		 int sheetNum =6;
		 test.log(LogStatus.INFO, "Verify the KBB Trade-In page", "KBB Trade-In page is displayed");
		try
		{
		String runVal = data.getStrExcelData(dRw, 8, 1);
		System.out.println("runVal : "+runVal);
		invokeReport("Verify KBBTradeIn",dRw);
		switch(runVal){
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
				test.log(LogStatus.INFO, "'KBB trade in' testcase is not executed. Customer chose Skip Trade in.");
				data.writeToExcel("Not Executed", dRw, 62, sheetNum);
				break;
			}

			tearReport();
		
		}
		catch(Exception kbbtradin)
		 {
			kbbtradin.printStackTrace();
			Count++;
			getscrnSht.getscreenshot(driver, scrnshtPth+"kbbtradin_Failed"+libs.timestamp1()+".jpg");
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
		
		libs.componenttHeading("Home Page");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "KBB_HomePage_header", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageSubHeader(driver), data.getExcelData(1, "KBB_HomePage_Subheader", "KBBTradeIn"), "KBB_HomePage_SubHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageFooter(driver),bottomtext, "KBB_HomePage_Footer", "");
		libs.Pagedisclaimers("KBBTradeIn",2);
		
		libs.Disclosers();
		System.out.println("Click");
		Thread.sleep(3000);
		libs.clickOnButton(PGO_kbbTradeIn.btn_enterVehicleInfo(driver), "btn_enterVehicleInfo");
		Thread.sleep(3000);
		System.out.println();
		libs.componenttHeading("Vehicle Info");
		libs.VerifyText(PGO_kbbTradeIn.kbbVehicleInfoPageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "kbbVehicleInfoPageHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbVehicelInfoPageSubHeader(driver), data.getExcelData(1, "kbb_Vehicel_InfoPage_SubHeader", "KBBTradeIn"), "kbbVehicelInfoPageSubHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageFooter(driver), bottomtext, "kbbHomePageFooter_InfoPage", "");
		test.log(LogStatus.PASS, "Navigated to Vehicle Info section - Trade-In page successfully" );
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbYearSelect(driver), kbbYearSelect, "kbbYearSelect");
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbMakeSelect(driver), kbbMakeSelect, "kbbMakeSelect");
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbModelSelect(driver), kbbModelSelect, "kbbModelSelect");
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbTrimSelect(driver), kbbTrimSelect, "kbbTrimSelect");
		libs.enterValueIntoTextField(PGO_kbbTradeIn.txt_kbbMileageInput(driver), "kbbMileageInput", kbbMileageInput);
		test.log(LogStatus.PASS, "Enter all values in vehicle info tab" );
		String vehicelDetails = kbbYearSelect+" "+kbbMakeSelect+" "+kbbModelSelect+" | "+kbbTrimSelect+" | "+kbbMileageInput+" "+"miles"+" "+" Change|Delete".trim();
		libs.Pagedisclaimers("KBBTradeIn",2);
		libs.Disclosers();
		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		Thread.sleep(2000);
		
		libs.componenttHeading("Add Options");
		libs.VerifyText(PGO_kbbTradeIn.kbbAddOptionPageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "kbbAddOptionPageHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbTradeInPageHeader(driver), vehicelDetails, "kbbTradeInPageHeader_AddOptions", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbAddOptionPageSubHeader(driver), data.getExcelData(1, "kbb_Trade_InPage_SubHeader", "KBBTradeIn"), "kbbAddOptionPageSubHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbHomePageFooter(driver), bottomtext, "kbbHomePageFooter_AddOptions", "");
		test.log(LogStatus.PASS, "Trade in vehicle info completed and clicked on continue" );
		Thread.sleep(2000);
		libs.Pagedisclaimers("KBBTradeIn",2);
		libs.Disclosers();
		test.log(LogStatus.PASS, "Add options completed and clicked on continue" );
		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		Thread.sleep(2000);
		
		libs.componenttHeading("CONDITION & VALUE");
		libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "kbbConditionValuePageHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageSubHeader(driver), vehicelDetails, "kbbConditionValuePageSubHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbChooseConditiontxt(driver), data.getExcelData(1, "choose_Condition", "KBBTradeIn"), "kbbChooseConditiontxt", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbtxt(driver), data.getExcelData(1, "Kelley_Blue_Book", "KBBTradeIn"), "Kelley_Blue_Book(kbbtxt)", "");
				
		//radio txt validations
		libs.componenttHeading("Radio button text verification");
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
		valueChoose = data.getExcelData(1, "Value_choose", "KBBTradeIn");
		String ConditionBottemFotter = data.getExcelData(1, "kbb_TradeIn_Condition_ValuePage_Footer", "KBBTradeIn");
		String kbbTradeInSummaryPageFooter = data.getExcelData(1, "kbb_TradeIn_SummaryPage_Footer", "KBBTradeIn");
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/d/yy");
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date()); 
	    kbbTradeInSummaryPageFooter =kbbTradeInSummaryPageFooter.replaceAll("fromDate", sdf.format(c.getTime()));
	    ConditionBottemFotter = ConditionBottemFotter.replaceAll("fromDate", sdf.format(c.getTime()));
	    valueChoose = valueChoose.replaceAll("fromDate", sdf.format(c.getTime()));
	    c.add(Calendar.DATE, DateDifference); 
	    String output = sdf.format(c.getTime());
	    valueChoose = valueChoose.replaceAll("toDate", output);
	    kbbTradeInSummaryPageFooter = kbbTradeInSummaryPageFooter.replaceAll("toDate", output).trim();
	    ConditionBottemFotter = ConditionBottemFotter.replaceAll("toDate", output).trim();
	
		libs.VerifyText(PGO_kbbTradeIn.kbbVehicleChoosed(driver), valueChoose, "kbbVehicleChoosed", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbEnterOwnDealOption(driver),data.getExcelData(1, "ChooseYoueDeal", "KBBTradeIn") , "kbbEnterOwnDealOption", "");
		

		libs.clickOnButton(PGO_kbbTradeIn.kbbEnterOwnDealOptionCheckBox(driver), "kbbEnterOwnDealOptionCheckBox ");
		Thread.sleep(2000);
		libs.enterValueIntoTextField(PGO_kbbTradeIn.kbbEnterOwnValueTxtBox(driver), "kbbEnterOwnValueTxtBox",data.getExcelData(1, "Deal_Own_Value", "KBBTradeIn"));
		libs.clickOnButton(PGO_kbbTradeIn.kbbEnterOwnDealOptionCheckBox(driver), "kbbEnterOwnDealOptionCheckBox ");
		Thread.sleep(2000);
	
		
		libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageFooter(driver),ConditionBottemFotter, "kbbConditionValuePageFooter", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbConditionValuePageCommonFooter(driver), bottomtext, "kbbConditionValuePageCommonFooter", "");
		test.log(LogStatus.PASS, "Condition and Value section loads successfully" );
		libs.clickOnButton(driver.findElement(By.xpath("(//div[@class='radio'])[last()-5]/label")), "radiobutton");
		libs.Pagedisclaimers("KBBTradeIn",2);
		libs.Disclosers();
		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		Thread.sleep(3000);
		libs.componenttHeading("SUMMARY");
		data.addColumn("kbbSummaryPageTrim","KBBTradeIn");
		data.addColumn("kbbSummaryPageMileage", "KBBTradeIn");
		data.addColumn("KbbSummaryPagecondition", "KBBTradeIn");
		data.addColumn("kbbResponseTotalTxt", "KBBTradeIn");
		libs.VerifyText(PGO_kbbTradeIn.kbbSummaryPageHeader(driver), data.getExcelData(1, "KBB_HomePage_header", "KBBTradeIn"), "kbbSummaryPageHeader", "");
		libs.VerifyText(PGO_kbbTradeIn.kbbSummaryPageSubHeader(driver), vehicelDetails, "kbbSummaryPageSubHeader", "");
		libs.VerifyElement(PGO_kbbTradeIn.link_Change(driver), "Change", driver, test, 1);
		libs.VerifyElement(PGO_kbbTradeIn.link_Delete(driver), "Delete", driver, test, 1);
		
		Thread.sleep(3000);
		System.out.println("Excel Values: "+kbbTrimSelect+" :: "+kbbMileageInput+" :: "+kbbResponseCondition+" :: "+PGO_kbbTradeIn.kbbResponseTotalTxtValue(driver).getText());
		data.writeExceldata(2,"kbbSummaryPageTrim", "KBBTradeIn", kbbTrimSelect);
		data.writeExceldata(2, "kbbSummaryPageMileage", "KBBTradeIn", kbbMileageInput);
		data.writeExceldata(2, "KbbSummaryPagecondition", "KBBTradeIn", kbbResponseCondition);
		data.writeExceldata(2, "kbbResponseTotalTxt", "KBBTradeIn", PGO_kbbTradeIn.kbbResponseTotalTxtValue(driver).getText());
		driver.switchTo().frame(driver.findElement(By.id("kbbWidget")));
		libs.IMGValidation(PGO_kbbTradeIn.kbbSummaryPageImg(driver), "KBB Trade-in Range Img", "KBB trade in image is displayed", "kbbSummaryPageImg");  
		driver.switchTo().defaultContent();
		libs.VerifyText(PGO_kbbTradeIn.kbbTradeInSummaryPageFooter(driver), kbbTradeInSummaryPageFooter, "kbb_TradeIn_SummaryPage_Footer", "");
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
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbYearSelect(driver), kbbYearSelect, "kbbYearSelect");
	
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbMakeSelect(driver), kbbMakeSelect, "kbbMakeSelect");
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbModelSelect(driver), kbbModelSelect, "kbbModelSelect");
		libs.selectValueFromDropDown(PGO_kbbTradeIn.txt_kbbTrimSelect(driver), kbbTrimSelect, "kbbTrimSelect");
		libs.enterValueIntoTextField(PGO_kbbTradeIn.txt_kbbMileageInput(driver), "kbbMileageInput", kbbMileageInput);
		test.log(LogStatus.PASS, "Enter all values in vehicle info tab" );

		libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Trade in vehicle info completed and clicked on continue" );
		test.log(LogStatus.PASS, "Add options completed and clicked on continue" );
			libs.clickOnButton(PGO_kbbTradeIn.btn_vehicleInfo_Continue(driver), "continue");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Condition and Value section loads successfully" );
		if(applicationname.contains("CTP"))  {

			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='condition-grid']"))));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='condition-grid']")));

			Thread.sleep(2000);
			driver.findElement(By.xpath("(//div[@class='radio'])[last()-5]/label")).click();
		} else
			{

			
			libs.clickOnButton(driver.findElement(By.xpath("(//div[@class='radio'])[last()-5]/label")),"radios");
		}

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
