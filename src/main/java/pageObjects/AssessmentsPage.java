package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageLocators.AssessmentsPageLocators;

public class AssessmentsPage implements AssessmentsPageLocators{

	public WebDriver driver;
	
	public AssessmentsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickOnAssessmentsTab() {
		driver.findElement(ASSESSMENTS_TAB).click();
	} 
	
	public String getAssessmentsPageURL() {
		return driver.getCurrentUrl();
	}
}
