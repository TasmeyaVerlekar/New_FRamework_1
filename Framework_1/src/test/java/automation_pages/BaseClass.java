package automation_pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import automation_utility.BrowserFactory;
import automation_utility.ConfigDataProvider;
import automation_utility.ExcelDataProvider;
import automation_utility.Helper;


public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report; 
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		
		Reporter.log("Setting up reports  and test Started", true);
		 excel=new ExcelDataProvider();
		 config=new ConfigDataProvider();
		 
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.getCurrentDateTime()+".html")); 
		 report=new ExtentReports();
		 report.attachReporter(extent);
	}

	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
	}
	@AfterClass
public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE) {
	
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		
		report.flush();
	}
}
