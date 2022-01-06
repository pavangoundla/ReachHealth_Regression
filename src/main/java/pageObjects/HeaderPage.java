package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import PageLocators.HeaderPageLocators;

public class HeaderPage implements HeaderPageLocators{
	
public WebDriver driver;
	
	public HeaderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void selectOptionFromUserIcon() {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(USER_ICON)).perform();
	}
	
	

}
