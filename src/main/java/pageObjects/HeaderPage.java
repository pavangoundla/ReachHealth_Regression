package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import PageLocators.HeaderPageLocators;

public class HeaderPage implements HeaderPageLocators{
	
public WebDriver driver;
	
	public HeaderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void clicOnUserIconOptions(String enterAUserIconOption) {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(USER_ICON)).build().perform();
		if(enterAUserIconOption=="Sign out") {
		driver.findElement(SIGN_OUT).click();
	    }
		else if(enterAUserIconOption=="Account settings") {
			driver.findElement(ACCOUNT_SETTINGS).click();
			}
		else if(enterAUserIconOption=="Achievements"){
			driver.findElement(ACHIEVEMENTS).click();
		}
		}
	

}
