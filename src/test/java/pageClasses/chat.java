package pageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraryClasses.*;
import pageObjectClasses.*;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilityClasses.*;



public class chat extends rsg_DriverClass{

	FuncitonLibrary libs = new FuncitonLibrary();
	WebDriverWait wait = new WebDriverWait(driver,30);
	String SheetNum ="Chat";


	public void  chatWinVal_run(int dRw) throws Exception
	{

			String runVal = data.getExcelData(dRw,"Chat", "Testcases");
		System.out.println(runVal);
		switch(runVal){
		case "Yes":
			invokeReport("Verify chat page",dRw);
			chatWinVal(dRw);
		
			break;
		case "No":
			System.out.println("'Chat' testcase will not be executed");
			 data.writeExceldata(dRw,"Result", "Chat","Not Executed");
	
			break;
		}
		tearReport();
	}


	public void chatWinVal(int dRw)throws Exception {

		String chatName = data.getExcelData(dRw,"chatName", "Chat");
		String chatEmail = data.getExcelData(dRw, "chatEmail", "Chat");
		String txtMessage = data.getExcelData(dRw, "txtMessage", "Chat");
		String chatConMessage = data.getExcelData(dRw, "ChatConnectedMessage", "Chat");
		String parentHandle = null;
		try
		{
			Thread.sleep(1000);
			parentHandle = driver.getWindowHandle();
			libs.clickOnButton(PGO_chat.img_chatIcon(driver), "chatIcon");
			Thread.sleep(1000);

			
			for (String winHandle : driver.getWindowHandles()) 
			{
				driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
			if(driver.getCurrentUrl().contains("fmcc")){
			
			test.log(LogStatus.INFO, "chat window opened ");
			//code to do something on new window
			test.log(LogStatus.INFO, "chat window title is : "+driver.getTitle());
			test.log(LogStatus.INFO, "chat header is : "+PGO_chat.txt_chatHeader(driver).getText());
			libs.IMGValidation(PGO_chat.img_chatLogo(driver), "Verify the Hello chat Image", "Hello chat Image has been displayed", "chat logo");
			libs.enterValueIntoTextField(PGO_chat.txt_ChatName(driver), "Please Enter Your Name:", chatName);
			libs.clickOnButton(PGO_chat.btn_startChat(driver), "start chat");
			// chat connection status
			String chatConSts = PGO_chat.txt_chatConSts(driver).getText();
			test.log(LogStatus.INFO, "chat window title is : "+chatConSts);
			System.out.println("Chat window title is: "+chatConSts);
			String chat_ConSts[] =  chatConSts.split(":");
			System.out.println(chat_ConSts[1]);

			if (chat_ConSts[1].equals("Connected")){
				Thread.sleep(1000);
				libs.enterValueIntoTextField(PGO_chat.txt_chat(driver), "Chat message", chatConMessage);
				Thread.sleep(1000);
				libs.clickOnButton(PGO_chat.btn_chatSend(driver), "chat send");
				test.log(LogStatus.PASS, "chat send button is displayed : "+chatConSts);
			
			}

			else {	test.log(LogStatus.INFO, "Hello chat window text is: "+ PGO_chat.txt_chatLeaveMessage(driver).getText());
					//Chat not live after 8.30 PM 
					Thread.sleep(1000);
//					libs.enterValueIntoTextField(PGO_chat.txt_chatNotLive(driver), "chat Not live", txtMessage);
//					libs.enterValueIntoTextField(PGO_chat.txt_chatUserEmail(driver), "chat user Email", chatEmail);
//					libs.clickOnButton(PGO_chat.btn_chatSend1(driver), "chat send");
//					test.log(LogStatus.PASS, "Hello chat Thank you message: "+ PGO_chat.txt_chatThankYou(driver).getText());
			}
			data.writeExceldata(dRw,"Result", "Chat","Passed");
			driver.close(); // close newly opened window when done with it
			driver.switchTo().window(parentHandle); // switch back to the original window
			}else{
				getscrnSht.getscreenshot(driver, scrnshtPth+"ChatwindowWrongUrl"+libs.timestamp1()+".jpg");
				test.log(LogStatus.FAIL, "Chat has opened with wrong URL",test.addScreenCapture(scrnshtPth +"ChatwindwVal_Failed_"+libs.timestamp1()+".jpg") );		
				driver.close();
				driver.switchTo().window(parentHandle);
			}
		}catch(Exception chatException)
		{	Count++;
			getscrnSht.getscreenshot(driver, scrnshtPth+"ChatwindwVal_Failed_"+libs.timestamp1()+".jpg");
			test.log(LogStatus.FAIL, chatException.getMessage(),test.addScreenCapture(scrnshtPth +"ChatwindwVal_Failed_"+libs.timestamp1()+".jpg") );		
			driver.close(); // close newly opened window when done with it
			driver.switchTo().window(parentHandle); // switch back to the original window
			System.out.println("'Chat' testcase is failed.");
			 data.writeExceldata(dRw,"Result", "Chat","Failed");
		}
		

	}


}
