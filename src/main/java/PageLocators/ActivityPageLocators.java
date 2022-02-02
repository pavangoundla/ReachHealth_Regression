package PageLocators;

import org.openqa.selenium.By;

public interface ActivityPageLocators {
	
	By ACTIVITY_TAB = By.cssSelector("a[href='#/activity']");
	By ACTIVITYPAGE_TODAYTEXT = By.xpath("//h1[contains(text(),'Today')]");

}
