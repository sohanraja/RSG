package utilityClasses;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShot  {
	
	public void getscreenshot(WebDriver driver, String Path) throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File(Path));
            
            
//            Toolkit toolkit = Toolkit.getDefaultToolkit();
//            Dimension screenSize = toolkit.getScreenSize();
//            Rectangle rectangle = new Rectangle(0, 0, screenSize.width, screenSize.height);
//            Robot robot = null;
//    try
//        {
//            robot = new Robot();
//            } catch (AWTException e) {
//          e.printStackTrace();
//
//            }
//       
//       BufferedImage screenshotImage = robot.createScreenCapture(rectangle);
//    File screenshotFile = new File(Path);
//   try
//       {
//           ImageIO.write(screenshotImage, "jpg", screenshotFile);
//            				
//         } catch (IOException e) {
//           e.printStackTrace();
//
//            /*     */     }
    }

}
