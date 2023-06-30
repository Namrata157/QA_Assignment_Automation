package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentStatusPage {
	
	@FindBy(xpath = "//div[@class='payment-cta']")
	private WebElement paymentStatusHeader;
	
	public PaymentStatusPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public String getPaymentStatusHeader() 
	{
		return paymentStatusHeader.getText();
	}
	
	

}
