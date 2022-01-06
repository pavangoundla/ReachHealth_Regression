package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageLocators.GoalsPageLocators;

public class GoalsPage implements GoalsPageLocators{
public WebDriver driver;
	
	public GoalsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickOnGoalsTab() {
		driver.findElement(GOALS_TAB).click();
	} 
	
	public String getGoalsPageURL() {
		return driver.getCurrentUrl();
	}
}
