package PageLocators;

import org.openqa.selenium.By;

public interface HeaderPageLocators {

	
	//By USER_ICON = By.xpath("//span[text()='pavan']");
	By USER_ICON = By.cssSelector("svg[icon='chevron/down']");
	By SIGN_OUT = By.xpath("//a/span[text()='Sign out']");
	By ACCOUNT_SETTINGS = By.xpath("//a/span[text()='Account settings']");
	By ACHIEVEMENTS = By.xpath("//a/span[text()='Achievements']");
	By BIOLOGICAL_SEX = By.xpath("//select[contains(@id, 'biological')]");
	By PRIMARY_HEIGHT = By.xpath("//input[@data-testid='primaryInput']");
	By SECONDARY_HEIGHT = By.xpath("//input[@data-testid='fractionalInput']");
	By ACHIEVEMENTS_TEXT = By.xpath("//h1[text()='Achievements']");
}
