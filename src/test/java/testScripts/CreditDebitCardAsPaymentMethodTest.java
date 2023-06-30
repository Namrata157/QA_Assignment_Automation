package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pomPages.CheckoutPage;
import pomPages.PaymentPage;
import pomPages.PaymentStatusPage;

@Listeners(genericLibraries.ListenerImplementation.class)
public class CreditDebitCardAsPaymentMethodTest extends BaseClass{
	
	@Test
	public void CreditDebitCardAsPaymentMethodTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		PaymentPage pg=new PaymentPage(driver);
		pg.selectLanguage(driver," English");
		String customername=elib.readDataFromExcel("Payment Page",2,1);
		String totalAmount=elib.readDataFromExcel("Payment Page",1,1);
	
		pg.makePayment(totalAmount,customername,elib.readDataFromExcel("Payment Page",3,1), driver,elib.readDataFromExcel("Payment Page",4,1),elib.readDataFromExcel("Payment Page",5,1),elib.readDataFromExcel("Payment Page",6,1));
		
		CheckoutPage cg=new CheckoutPage(driver);
		cg.selectLanguage(driver,"English(EN)");
		
		Assert.assertTrue(cg.getCustomername().contains(customername));
		Assert.assertTrue(cg.getTotalAmount().replace(",","").contains(totalAmount));
		
		cg.PayUsingCreditDebitCard(elib.readDataFromExcel("CardHolderDetails",1,1),elib.readDataFromExcel("CardHolderDetails",2,1),elib.readDataFromExcel("CardHolderDetails",3,1),elib.readDataFromExcel("CardHolderDetails",4,1),driver);
		
		PaymentStatusPage psg=new PaymentStatusPage(driver);
		System.out.println("Final Payment Status------------"+psg.getPaymentStatusHeader()+"------------");
		
	}
	
	

}
