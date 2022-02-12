package pageObjects;

import java.util.concurrent.TimeUnit;

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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver.findElement(HELLO_USERTEXT);
		
	}
	
	public String getDashboardPageURL() {
		return driver.getCurrentUrl();
	}
	public String dashboardPageSections(String enterSectionName) throws InterruptedException {
		 
		
		if(enterSectionName=="Quealth") {
			driver.findElement(QUEALTH_TEXT);
		}
		else if(enterSectionName=="Health balance") {
			driver.findElement(HEALTHBALANCE_TEXT);
		}
		else if(enterSectionName=="Question") {
			driver.findElement(QUESTION_TEXT);
		}
		else if(enterSectionName=="Risk factors") {
			driver.findElement(RISKFACTORS_TEXT);
		}
		else if(enterSectionName=="Achievements") {
			driver.findElement(ACHIEVEMENTS_TEXT);
		}
		else if(enterSectionName=="Question") {
			driver.findElement(QUESTION_TEXT);
		}
		
		return enterSectionName;
		
	}
	
	public void clickOnDashboardPageButton() {
		driver.findElement(VIEW_REPORTBUTTON).click();
	}
	

}
