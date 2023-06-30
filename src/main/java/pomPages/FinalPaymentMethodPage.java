package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalPaymentMethodPage {
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement trueWalletSubmitButton;
	
	@FindBy(xpath = "//h1[@id='problem']")
	private WebElement BNPLStatusHeader;
	
	@FindBy(xpath = "//input[@id='mobileNo']")
	private WebElement netBankingPhoneNumberField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement netBankingSubmitButton;
	
	@FindBy(xpath = "//h1[@id='headingLang']")
	private WebElement ScanQRCodeheader;
	
	@FindBy(xpath = "//h3[normalize-space()='Payment Gateway - Installment']")
	private WebElement InstallmentStatusHeader;

	public FinalPaymentMethodPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public String getBNPLStatusHeader() {
		return BNPLStatusHeader.getText();
	}
	

	public String getInstallmentStatusHeader() {
		return InstallmentStatusHeader.getText();
	}


	public String getScanQRCodeheader() {
		return ScanQRCodeheader.getText();
	}


	public void walletFinalPayment()
	{
		trueWalletSubmitButton.click();
	}
	
	public void NetbankingFinalPayment(String number) throws InterruptedException
	{
		netBankingPhoneNumberField.sendKeys(number);
		Thread.sleep(2000);
		netBankingSubmitButton.click();
	}
}
