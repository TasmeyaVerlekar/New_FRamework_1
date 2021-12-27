package automation_testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automation_pages.BaseClass;
import automation_pages.LoginPage;



public class LoginTestCRM extends BaseClass {


	
	 
	@Test(priority = 1)
	public void loginApp() {
		
		logger=report.createTest("Login to CRM");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		
		logger.pass("Login done successfully");
		
	//	Helper.captureScreenshot(driver);
		
	}
	
	
}