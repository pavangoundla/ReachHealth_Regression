package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageLocators.LoginPageLocators;

public class LoginPage implements LoginPageLocators{
	
	
public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement verifysignInText() {
		return driver.findElement(SIGN_IN_TEXT);
	}
	
	public void enterLoginDetails(String emailId, String password) {
		driver.findElement(EMAIL).sendKeys(emailId);
		driver.findElement(PASSWORD).sendKeys(password);
		driver.findElement(LOGIN_BUTTON).click();
	}
	
	public WebElement clickOnSignInButton() {
		return driver.findElement(LOGIN_BUTTON);
	}
	
	public WebElement incorrectEmailPasswordMessage() {
		return driver.findElement(INCORRECT_EMAILPASSWORD_MESSAGE);
	}

}
