package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageLocators.ResourcesPageLocators;

public class ResourcesPage implements ResourcesPageLocators{
public WebDriver driver;
	
	
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
