package pomPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebdriverLibrary;

public class CheckoutPage extends WebdriverLibrary {
	
	@FindBy(xpath = "(//div[@class='languageChanger'])[2]")
	private WebElement CheckoutLanguageDropdown;
	
	@FindBy(xpath = "//div[@id='defaultAddressName']")
	private WebElement Customername;
	
	@FindBy(xpath = "//span[@class='totalAmountCount']")
	private WebElement TotalAmount;
	
	@FindBy(xpath="//a[@aria-controls='wallets']")
	private WebElement Walletdropdown;
	
	@FindBy(id = "GBPRIMEPAY-GBPRIMEPAY_TRUEMONEY_WALLET")
	private WebElement TrueMoneyOption;
	
	@FindBy(xpath = "//a[@aria-controls='bnpls']")
	private WebElement BNPLdropdown;
	
	@FindBy(id="GBPRIMEPAY-GBPRIMEPAY_ATOME")
	private WebElement AtomeOption;
	
	@FindBy(xpath="//a[@aria-controls='qrcodes']")
	private WebElement QRCodedropdown;
	
	@FindBy(xpath = "//label[@for='GBPRIMEPAY-GBPRIMEPAY_QRCASH']")
	private WebElement PromptPayOption;
	
	@FindBy(xpath="//a[@aria-controls='directnetbankings']")
	private WebElement Netbankingdropdown;
	
	@FindBy(id = "GBPRIMEPAY-GBPRIMEPAY_KPLUS_BANK")
	private WebElement KPlusBankOption;
	
	@FindBy(xpath="//a[@id='creditdebitcardlang']")
	private WebElement Credit_DebitCarddropdown;
	
	private String frameID="cardCaptureIframe";
	@FindBy(id = "cardholder_name")
	private WebElement CardholderNameField;
	
	@FindBy(id = "card_number")
	private WebElement CardNumberField;
	
	@FindBy(id = "expiration_date")
	private WebElement ExpirydateField;
	
	@FindBy(id = "service_code")
	private WebElement ServiceCodeField;
	
	@FindBy(xpath="//a[.='COD']")
	private WebElement CODOption;
	
	@FindBy(xpath="//a[@id='directbanktransferlangDirect']")
	private WebElement DirectBankTransferdropdown;
	
	@FindBy(xpath = "//input[@id='uploadimg']")
	private WebElement UploadProof;
	
	@FindBy(xpath="//a[@aria-controls='installments']")
	private WebElement Installmentdropdown;
	
	@FindBy(xpath = "//label[@for='GBPRIMEPAY-004']")
	private WebElement KASIKORNBANKdropdown;
	
	@FindBy(xpath = "(//div[@id='InstallmentBankOpt'])[2]/div/div/input[@type='radio' and @value='installment-3-0']")
	private WebElement InstallmentTypeOption;
	
	@FindBy(xpath = "//button[@id='PayNowButtonWeb']")
	private WebElement PayButton;

	public CheckoutPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}  
	
	public String getCustomername() {
		return Customername.getText();
	}

	
	public String getTotalAmount() {
		return TotalAmount.getText();
	}

	
	public void selectLanguage(WebDriver driver,String value)
	{
		CheckoutLanguageDropdown.click();
		WebElement element = driver.findElement(By.xpath("//div[@class='backToLangChanger hideOnMob']//ul[@class='lang-menu-section open']/li/a[.='"+value+"']"));
		handledropdownUsingActions(driver, element);
	}
	
	public void selectWalletsPaymentOption() throws InterruptedException
	{
		Walletdropdown.click();
		Thread.sleep(2000);
		TrueMoneyOption.click();
		Thread.sleep(2000);
		PayButton.click();
		Thread.sleep(5000);
	}
	public void selectBNPLPaymentOption() throws InterruptedException
	{
		BNPLdropdown.click();
		Thread.sleep(2000);
		AtomeOption.click();
		Thread.sleep(2000);
		PayButton.click();
		Thread.sleep(5000);
	}
	public void selectQRCodePaymentOption() throws InterruptedException
	{
		QRCodedropdown.click();
		Thread.sleep(2000);
		PromptPayOption.click();
		Thread.sleep(2000);
		PayButton.click();
		Thread.sleep(5000);
	}
	public void selectNetBankingPaymentOption() throws InterruptedException
	{
		Netbankingdropdown.click();
		Thread.sleep(2000);
		KPlusBankOption.click();
		Thread.sleep(2000);
		PayButton.click();
		Thread.sleep(5000);
	}
	public void PayUsingCreditDebitCard(String name,String number,String expiry,String code,WebDriver driver) throws InterruptedException
	{
		scrollAction(driver);
		Credit_DebitCarddropdown.click();
		switchToFrame(driver, frameID);
		CardholderNameField.sendKeys(name);
		CardNumberField.sendKeys(number);
		ExpirydateField.sendKeys(expiry);
		ServiceCodeField.sendKeys(code);
		switchToDefaultFrame(driver);
		Thread.sleep(2000);
		PayButton.click();
		Thread.sleep(5000);
	}
	
	public void selectCODPaymentOption() throws InterruptedException
	{
		CODOption.click();
		Thread.sleep(2000);
		PayButton.click();
		Thread.sleep(5000);
	}
	
	public void DirectBankTransferPaymentOption(String fileLocation,WebDriver driver) throws InterruptedException, IOException
	{
		DirectBankTransferdropdown.click();
		Thread.sleep(2000);
		scrollAction(driver);
		UploadProof.sendKeys(fileLocation);
		Thread.sleep(10000);
		PayButton.click();
		Thread.sleep(5000);
	}
	
	public void selectInstallmentPaymentOption(WebDriver driver) throws InterruptedException
	{
		scrollAction(driver);
		Installmentdropdown.click();
		Thread.sleep(2000);
		KASIKORNBANKdropdown.click();
		Thread.sleep(2000);
		InstallmentTypeOption.click();
		Thread.sleep(2000);
		PayButton.click();
		Thread.sleep(5000);
	}

}
