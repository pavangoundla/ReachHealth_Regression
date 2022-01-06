package PageLocators;

import org.openqa.selenium.By;

public interface LoginPageLocators {
	
	By SIGN_IN_TEXT = By.xpath("//h2[contains(text(),'Sign in')]");
	By EMAIL = By.id("loginEmail");
	By PASSWORD = By.id("loginPassword");
	By LOGIN_BUTTON = By.id("loginSubmit");
	By INCORRECT_EMAILPASSWORD_MESSAGE = By.xpath("//span[contains(text(),'Incorrect email or password')]");

}
