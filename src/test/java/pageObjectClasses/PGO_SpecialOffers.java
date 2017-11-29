package pageObjectClasses;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import libraryClasses.FuncitonLibrary;
public class PGO_SpecialOffers extends FuncitonLibrary{
	private static WebElement element = null;
	private static List<WebElement> elements = null;
	

	//	Below are the POs for reviewAndSend functionality
	
	public static WebElement btn_SpecialOffers(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,40);		
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-dre nextTab hidden-sm hidden-xs pull-right ng-binding']")));
		libs.HighlightElement(driver, element);
		return element;
	}
	
	
	
}
