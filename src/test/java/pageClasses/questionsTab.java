package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class questionsTab extends rsg_DriverClass{

	FuncitonLibrary libs = new FuncitonLibrary();
	WebDriverWait wait = new WebDriverWait(driver,10);
	Actions actions = new Actions(driver);
	int SheetNum =10;

	public void quesTabVal_run(int dRw) throws Exception
	{
		String runVal = data.getExcelData(dRw,"Questions", "Testcases");
		System.out.println(runVal);
		
				switch(runVal){
				case "Yes":
					invokeReport("Verify questionsTab",dRw);
					quesTabAdd(dRw);
					quesTabMap(dRw);
					quesTabFaqs(dRw);
					tearReport();
					
				break;
				case "No":
					System.out.println("'Questions Tab' testcase is not Executed.");
					data.writeToExcel("Not Executed",dRw, 2, SheetNum);
				break;
				}	
	}


	public void quesTabAdd(int dRw)throws Exception {

		String questionsTitleExp = data.getExcelData(1,"questionsTitleExp", "Questions tab");
		try{
			Thread.sleep(3000);

			libs.clickOnButton(PGO_questionsTab.img_questions(driver), "Question img");
			libs.VerifyText(PGO_questionsTab.title_questions(driver), questionsTitleExp, "Questions","");
			libs.componenttHeading("Dealer information");
			libs.VerifyText(PGO_questionsTab.txt_dealerName(driver), data.getExcelData(1,"txt_dealerName", "Questions tab"), "Questions","");
			libs.VerifyText(PGO_questionsTab.txt_dealerContactNo(driver), data.getExcelData(1,"txt_dealerContactNo", "Questions tab"), "Questions","");
			libs.VerifyText(PGO_questionsTab.txt_dealerAddressStreet1(driver), data.getExcelData(1,"txt_dealerAddressStreet1", "Questions tab"), "Questions","");
			libs.VerifyText(PGO_questionsTab.txt_dealerAddressStreet2(driver), data.getExcelData(1,"txt_dealerAddressStreet2", "Questions tab"), "Questions","");
			libs.VerifyText(PGO_questionsTab.txt_dealerShopOpen(driver), data.getExcelData(1,"txt_dealerShopOpen", "Questions tab"), "Questions","");

		}catch(Exception quesTabAddException)
		{
			System.out.println(quesTabAddException);
			getscrnSht.getscreenshot(driver, scrnshtPth+"quesTabVal_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, quesTabAddException.getMessage(),test.addScreenCapture(scrnshtPth +"quesTabVal_Failed_"+libs.timestamp1()+".jpg") );
		}
	}
	public void quesTabMap(int dRw)throws Exception {

		try{
			
			Thread.sleep(500);
			PGO_questionsTab.img_DNmapOpen(driver).click();
			if(driver.findElement(By.xpath("//div[@class='col-md-4']//div[@class='mapIcon']//i[2]")).getAttribute("class").contains("hide") ==false) {
			test.log(LogStatus.INFO, "Dealer Map open");
            libs.VerifyElement(PGO_questionsTab.img_mapDisplayed(driver), "img_mapDisplayed", driver, test, dRw);
			}
			

			test.log(LogStatus.INFO, "Dealer Map close");

		}catch(Exception quesTabMapException)
		{
			System.out.println(quesTabMapException);
			getscrnSht.getscreenshot(driver, scrnshtPth+"quesTabVal_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, quesTabMapException.getMessage(),test.addScreenCapture(scrnshtPth +"quesTabVal_Failed_"+libs.timestamp1()+".jpg") );
		}
	}			
	public void quesTabFaqs(int dRw)throws Exception {

		try{
			// FAQ's and questions
			int disclimersnumber,totalqs;
			disclimersnumber=PGO_questionsTab.Question_disclimers(driver).size();
			
			
			for(int disc=0;disc<disclimersnumber;disc++){
				String Expected=data.getExcelData(1, PGO_questionsTab.Question_qstabs(driver).get(disc).getText(), "Questions tab");
				libs.VerifyText(PGO_questionsTab.Question_qstabs(driver).get(disc), Expected, "Expected", "");
				clickOnButton(PGO_questionsTab.Question_disclimers(driver).get(disc), "Disclaimers");
					
				totalqs=PGO_questionsTab.Question_tatalqs(driver).size();
					
					for(int qs=0;qs<totalqs;qs++){
						Expected=Expected.replaceAll(" ", "_");
						libs.VerifyText(PGO_questionsTab.Question_tatalqs(driver).get(qs), data.getExcelData(1,Expected+"_"+qs , "Questions tab"), Expected+"_Questions", "");

			}

					clickOnButton(PGO_questionsTab.Question_disclimers(driver).get(disc), "Disclaimers");
			
			}
			
			clickOnButton(PGO_questionsTab.questions_Close(driver), "close question tab");		
	}catch(Exception quesTabValException)
	{
		System.out.println(quesTabValException);
		libs.waitToClick(driver, PGO_questionsTab.img_closeQuestionsTab(driver), 10);
		System.out.println("'Questions Tab' testcase is failed.");
		data.writeToExcel("Failed", dRw, 2, SheetNum);
		getscrnSht.getscreenshot(driver, scrnshtPth+"quesTabVal_Failed_"+libs.timestamp1()+".jpg");
		test.log(LogStatus.FAIL, quesTabValException.getMessage(),test.addScreenCapture(scrnshtPth +"quesTabVal_Failed_"+libs.timestamp1()+".jpg") );
		
	}
}


}
