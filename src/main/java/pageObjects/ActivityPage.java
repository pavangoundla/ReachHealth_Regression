package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivityPage {
public WebDriver driver;
	
	By ACTIVITY_TAB = By.cssSelector("a[href='#/activity']");
	
	public ActivityPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickOnActivityTab() {
		driver.findElement(ACTIVITY_TAB).click();
	} 
	
	public String getActivityPageURL() {
		return driver.getCurrentUrl();
	}
}
