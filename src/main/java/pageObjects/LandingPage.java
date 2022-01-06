package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageLocators.LandingPageLocators;

public class LandingPage implements LandingPageLocators{
	
	public WebDriver driver;
	
	
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
