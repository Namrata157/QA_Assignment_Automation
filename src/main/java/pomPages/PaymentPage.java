package pomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.JavaLibrary;
import genericLibraries.WebdriverLibrary;

public class PaymentPage extends WebdriverLibrary{
	
	@FindBy(xpath = "//div[@id='mySelect']")
	private WebElement LanguageDropdown;
	
	@FindBy(xpath = "//input[@placeholder='Enter Amount here']")
	private WebElement AmountField;
	
	@FindBy(xpath="//input[@placeholder='Enter your name']")
	private WebElement NameField;
	
	@FindBy(xpath="//input[@placeholder='Enter your email']")
	private WebElement EmailField;
	
	@FindBy(xpath = "//div[@class='selected-flag']")
	private WebElement CountryCodeDropdown;
	
	@FindBy(xpath = "//ul[@class='country-list ']/li/span")
	private List<WebElement> CountryList;
	
	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	private WebElement PhoneNumberField;
	
	@FindBy(xpath = "(//div[@role='button'])[2]")
	private WebElement ConfirmationDropdown;
	
	@FindBy(xpath="//div[contains(@class,'MuiPaper')]/ul/li")
	private List<WebElement> ConfirmationList;
	
	@FindBy(xpath = "//button[@aria-label='Choose date']")
	private WebElement CalenderLookUp;
	
	@FindBy(xpath = "//button[contains(text(),'PAY NOW')]")
	private WebElement PayNowButton;
	
	
	public PaymentPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void selectLanguage(WebDriver driver,String value)
	{
		LanguageDropdown.click();
		WebElement element = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper')]/ul/li[.='"+value+"']"));
		handledropdownUsingActions(driver, element);
	}
	
	public void makePayment(String amount,String name,String email,WebDriver driver,String countryName,String phoneNumber,String confirmationValue) throws InterruptedException
	{
		AmountField.sendKeys(amount);
		Thread.sleep(2000);
		NameField.sendKeys(name);
		Thread.sleep(2000);
		EmailField.sendKeys(email);
		Thread.sleep(2000);
		handleDropDown(driver, CountryCodeDropdown, CountryList,countryName);
		Thread.sleep(2000);
		PhoneNumberField.sendKeys(phoneNumber);
		Thread.sleep(2000);
		handleDropDown(driver, ConfirmationDropdown, ConfirmationList,confirmationValue);
		Thread.sleep(2000);
		String date=new JavaLibrary().getSystemDate();
		Thread.sleep(2000);
		CalenderLookUp.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='"+date+"']")).click();
		Thread.sleep(2000);
		PayNowButton.click();
	}
	

}
