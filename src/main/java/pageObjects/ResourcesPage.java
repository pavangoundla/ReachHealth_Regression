package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResourcesPage {
public WebDriver driver;
	
	By RESOURCES_TAB = By.cssSelector("a[href='#/resources']");
	
	public ResourcesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickOnResourcesTab() {
		driver.findElement(RESOURCES_TAB).click();
	} 
	
	public String getResourcesPageURL() {
		return driver.getCurrentUrl();
	}
}
