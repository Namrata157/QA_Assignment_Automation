package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebdriverLibrary {
	
	public WebDriver driver;
	
	
	
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds to load the page
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	/**
	 * This method will handle drop-down
	 * @param driver
	 * @param element
	 * @param list
	 * @param value
	 */
	public void handleDropDown(WebDriver driver,WebElement element,List<WebElement> list, String value)
	{
		element.click();
		for(WebElement li:list)
		{
			if(li.getText().contains(value))
			{
				li.click();
				break;
			}
		}
	}
	
	/**
	 * This method will handle drop-down using Actions class
	 * @param driver
	 * @param element
	 */
	public void handledropdownUsingActions(WebDriver driver,WebElement element)
	{
		
		Actions a=new Actions(driver);
		a.moveToElement(element).click().build().perform();
		
	}
	
	/**
	 * This method will take the screen shot 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/"+screenshotName+".png");
		FileUtils.copyFile(src, dst); 
		
		return dst.getAbsolutePath(); 
		
	}
	
	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
	}
	
	/**
	 * This method will switch to frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	
	/**
	 * This method will switch from current frame to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}

}
