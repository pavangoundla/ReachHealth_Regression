package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	
public WebDriver driver;
	
	
	By SIGN_IN_TEXT = By.xpath("//h2[contains(text(),'Sign in')]");
	By EMAIL = By.id("loginEmail");
	By PASSWORD = By.id("loginPassword");
	By LOGIN_BUTTON = By.id("loginSubmit");
	By INCORRECT_EMAILPASSWORD_MESSAGE = By.xpath("//span[contains(text(),'Incorrect email or password')]");
	
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
