package genericLibraries;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public PropertyFileLibrary plib=new PropertyFileLibrary();
	public ExcelFileLibrary elib=new ExcelFileLibrary();
	public JavaLibrary jlib=new JavaLibrary();
	public WebdriverLibrary wlib=new WebdriverLibrary();
	public WebDriver driver=null;
	public static WebDriver sdriver;
	
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("--- Database connected successfully ---");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException 
	{
		String browser = plib.readDataFromPropertyFile("browser");
		String url = plib.readDataFromPropertyFile("url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(" --- Browser launched successfully --- "+browser);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(" --- Browser launched successfully --- "+browser);
		}
		else
		{
			System.out.println("invalid browser name");
		}
		sdriver = driver;
		wlib.maximiseWindow(driver);
		driver.get(url);
		wlib.waitForPageLoad(driver);
		
	}
	
	@BeforeMethod
	public void bmConfig()
	{
	
		System.out.println(" --- login is successfull ---");
	}
	
	@AfterMethod
	public void amConfig()
	{
		
		System.out.println("--- Logout is successfull ---");
	}
	
	@AfterClass
	public void acConfig() 
	{
		driver.quit();
		System.out.println("--- browser closed successfully ---");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("--- Database closed successfully ---");
	}
	

}
