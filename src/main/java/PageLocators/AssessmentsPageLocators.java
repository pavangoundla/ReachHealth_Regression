package PageLocators;

import org.openqa.selenium.By;

public interface AssessmentsPageLocators {
	
	By ASSESSMENTS_TAB = By.cssSelector("a[href='#/assessments']");
	By QUEALTHSCORE_CARD = By.xpath("//p[text()='%s']");
	By ASSESSMENTSPAGE_TEXTS = By.xpath("//h2[contains(text(),'%s')]");
	By ASSESSMENTSPAGE_ASSESSMENTSTEXT = By.xpath("//h1[contains(text(),'Assessments')]");
}
