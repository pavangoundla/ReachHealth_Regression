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
	
	public void clickOnScoreCard(String enterScoreCardName) {
		driver.findElement(By.xpath(String.format("//p[text()='%s']", enterScoreCardName))).click();
	}
	
	public void assessmentPageTexts(String enterAssessmentPageText) {
		driver.findElement(By.xpath(String.format("//h2[contains(text(),'%s')]", enterAssessmentPageText))).isDisplayed();
	}
	
	public void assessmentText() {
		driver.findElement(ASSESSMENTSPAGE_ASSESSMENTSTEXT).isDisplayed();
	}
	
	public void theBigFiveAndRiskFactorsTexts(String enterAssessmentPageText) {
		driver.findElement(By.xpath(String.format("//h2[contains(text(),'%s')]", enterAssessmentPageText))).isDisplayed();
	}
}
