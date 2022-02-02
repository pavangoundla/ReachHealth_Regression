package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageLocators.ActivityPageLocators;

public class ActivityPage implements ActivityPageLocators{
public WebDriver driver;
	
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
	
	public void todayText() {
		driver.findElement(ACTIVITYPAGE_TODAYTEXT).isDisplayed();
	}
	
	public void activityPageTexts(String enterActivityPageText) {
		driver.findElement(By.xpath(String.format("//p[contains(text(),'%s')]", enterActivityPageText))).isDisplayed();
	}
}
