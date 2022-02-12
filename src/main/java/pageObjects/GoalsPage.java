package pageObjects;

import java.util.concurrent.TimeUnit;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

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
	
	public void GoalsText() {
		driver.findElement(GOALSPAGE_GOALSTEXT).isDisplayed();
	}
	
	public void goalsPageTextsOrButtons(String enterGoalsPageTextOrbutton) {
		if((enterGoalsPageTextOrbutton=="Dailies")||(enterGoalsPageTextOrbutton=="Habits")) {
		driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", enterGoalsPageTextOrbutton))).isDisplayed();
		}
		else
		{
			driver.findElement(By.xpath(String.format("//*[contains(text(),'%s')]", enterGoalsPageTextOrbutton))).click();
		}
	}
	
	public void clickOnAGoal(String enterGoalCategoryName, String enterGoalName) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", enterGoalCategoryName))).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(String.format("(//span[contains(text(),'%s')])[2]", enterGoalName))).click();
		
	}
	
	public void verifyGoalCompletedDate(String enterCurrentDate) {
		System.out.println(driver.findElement(By.xpath(String.format("//p[contains(text(),'%s')]", "Completed "+enterCurrentDate))).getText());
		driver.findElement(By.xpath(String.format("//p[contains(text(),'%s')]", "Completed "+enterCurrentDate))).isDisplayed();
		
	}
}
