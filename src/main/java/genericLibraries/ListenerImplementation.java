package genericLibraries;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log("Test Execution Started", true);
		test.log(Status.INFO, "Test Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log("Test Execution Passed", true);
		test.log(Status.PASS, MethodName+" Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebdriverLibrary wlib  = new WebdriverLibrary();
		JavaLibrary jlib = new JavaLibrary();
		String MethodName = result.getMethod().getMethodName()+jlib.getSystemDateWithTimeStamp();
		
		Reporter.log("Test Execution Failed", true);
		test.log(Status.FAIL, MethodName+" Failed");
		
		try {
			String path = wlib.takeScreenShot(BaseClass.sdriver, MethodName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		Reporter.log("Test Execution Skipped", true);
		test.log(Status.SKIP, MethodName+" Skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
        Reporter.log("Execution started", true);
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Report-"+new JavaLibrary().getSystemDateWithTimeStamp()+".html");
		htmlReport.config().setDocumentTitle("PortOne Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Execution Reports for Assignment");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL","https://stage-page.portone.cloud/2Rjv4Sot0o7AUEvyihpgQeMn1Q3");
		report.setSystemInfo("Base Platform", "Windows 10");
		report.setSystemInfo("Reporter Name", "Namrata Mahajan");
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Execution Complete", true);
		report.flush();
	}
	

}
