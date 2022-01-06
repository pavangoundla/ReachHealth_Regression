package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageLocators.DashboardPageLocators;

public class DashboardPage implements DashboardPageLocators{
	
public WebDriver driver;
	
	
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement verifyHelloUserText() {
		return driver.findElement(HELLO_USERTEXT);
	}
	
	public String getDashboardPageURL() {
		return driver.getCurrentUrl();
	}
	

}
