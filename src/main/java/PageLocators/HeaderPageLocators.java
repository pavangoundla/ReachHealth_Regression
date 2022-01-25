package PageLocators;

import org.openqa.selenium.By;

public interface HeaderPageLocators {

	
	By USER_ICON = By.xpath("//div[@class='flex items-center']");
	By SIGN_OUT = By.xpath("//a/span[text()='Sign out']");
	By ACCOUNT_SETTINGS = By.xpath("//a/span[text()='Account settings']");
	By ACHIEVEMENTS = By.xpath("//a/span[text()='Achievements']");
}
