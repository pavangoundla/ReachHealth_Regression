package PageLocators;

import org.openqa.selenium.By;

public interface DashboardPageLocators {
	
	By HELLO_USERTEXT = By.xpath("//h1[contains(text(),'Hello pavan!')]");
	//By QUEALTH_QUESTIONTEXT = By.xpath("//h2[text()='%s']");
	By QUEALTH_TEXT = By.xpath("//h2[text()='Quealth']");
	By QUESTION_TEXT = By.xpath("//h2[text()='Question']");
	By HEALTHBALANCE_TEXT = By.xpath("//p[text()='Health balance']");
	By RISKFACTORS_TEXT = By.xpath("//h3[text()='Risk factors']");
	By ACHIEVEMENTS_TEXT = By.xpath("//span[text()='Achievements']");
	By VIEW_REPORTBUTTON = By.xpath("//a/button[contains(text(),'View report')]");

}
