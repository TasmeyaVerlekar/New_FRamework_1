package automation_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
@FindBy(name="email") WebElement username;
@FindBy(name="password") WebElement pass;
@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/form[1]/div[1]/div[3]") WebElement submitButton;

public void loginToCRM(String usernameAppliocaion,String passwordApplication) {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
	}
	username.sendKeys(usernameAppliocaion);
	pass.sendKeys(passwordApplication);
	submitButton.click();
	
}
		
}
