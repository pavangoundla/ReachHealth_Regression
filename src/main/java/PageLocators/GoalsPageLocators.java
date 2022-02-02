package PageLocators;

import org.openqa.selenium.By;

public interface GoalsPageLocators {
	
	By GOALS_TAB = By.cssSelector("a[href='#/goals']");
	By GOALSPAGE_GOALSTEXT = By.xpath("//h1[contains(text(),'Goals')]");

}
