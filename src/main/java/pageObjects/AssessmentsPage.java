package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssessmentsPage {

	public WebDriver driver;
	
	By ASSESSMENTS_TAB = By.cssSelector("a[href='#/assessments']");
	
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
