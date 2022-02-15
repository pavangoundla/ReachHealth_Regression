package PageLocators;

import org.openqa.selenium.By;

public interface AssessmentsPageLocators {
	
	By ASSESSMENTS_TAB = By.cssSelector("a[href='#/assessments']");
	By QUEALTHSCORE_CARD = By.xpath("//p[text()='%s']");
	By ASSESSMENTSPAGE_TEXTS = By.xpath("//h2[contains(text(),'%s')]");
	By ASSESSMENTSPAGE_ASSESSMENTSTEXT = By.xpath("//h1[contains(text(),'Assessments')]");
	By UPDATE_ASSESSMENT_BUTTON = By.xpath("//a/button[contains(text(),'Update assessment')]");
	By WEIGHT_INPUT = By.cssSelector("input[data-testid='primaryInput']");
	By SMOKE_INPUT = By.cssSelector("input[data-testid='numeric-input']");
	By NEXT_BUTTON = By.xpath("(//button[contains(text(),'Next')])[2]");
	By ALL_QUESTIONS_INPUT = By.cssSelector("input[data-testid='numeric-input']");
}
