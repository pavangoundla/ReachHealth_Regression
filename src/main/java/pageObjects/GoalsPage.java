package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoalsPage {
public WebDriver driver;
	
	By GOALS_TAB = By.cssSelector("a[href='#/goals']");
	
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
