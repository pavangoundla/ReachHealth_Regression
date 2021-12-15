package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	
	By SIGN_IN = By.cssSelector("a[href*='login']");
	By HEALTHIEST_POSSIBLE_TITLE = By.cssSelector("h1[data-testid='title']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement signIn() {
		return driver.findElement(SIGN_IN);
	}
	
	public WebElement verifyhealthiestPossibleText() {
		return driver.findElement(HEALTHIEST_POSSIBLE_TITLE);
	}

}
