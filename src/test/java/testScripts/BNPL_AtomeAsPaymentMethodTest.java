package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pomPages.CheckoutPage;
import pomPages.FinalPaymentMethodPage;
import pomPages.PaymentPage;

@Listeners(genericLibraries.ListenerImplementation.class)
public class BNPL_AtomeAsPaymentMethodTest extends BaseClass{
	
	@Test
	public void BNPL_AtomeAsPaymentMethodTest() throws EncryptedDocumentException, IOException, InterruptedException
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
		
		cg.selectBNPLPaymentOption();
		
		FinalPaymentMethodPage fg=new FinalPaymentMethodPage(driver);
		System.out.println("Final Payment Status----------"+fg.getBNPLStatusHeader()+"-----------");
		
		
	}

}
