package PageLocators;

import org.openqa.selenium.By;

public interface LandingPageLocators {
	
	By SIGN_IN = By.cssSelector("a[href*='login']");
	By HEALTHIEST_POSSIBLE_TITLE = By.cssSelector("h1[data-testid='title']");

}
