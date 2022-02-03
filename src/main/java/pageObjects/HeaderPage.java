package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import PageLocators.HeaderPageLocators;

public class HeaderPage implements HeaderPageLocators{
	
public WebDriver driver;
	
	public HeaderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void clickOnUserIconOptions(String enterAUserIconOption) {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(USER_ICON)).click().build().perform();
		if(enterAUserIconOption=="Sign out"||enterAUserIconOption=="Account settings"||enterAUserIconOption=="Achievements") {
		//sdriver.findElement(SIGN_OUT).click();
		driver.findElement(By.xpath(String.format("//a/span[text()='%s']", enterAUserIconOption))).click();
	    }
//		else if(enterAUserIconOption=="Account settings") {
//			driver.findElement(ACCOUNT_SETTINGS).click();
//			}
//		else if(enterAUserIconOption=="Achievements"){
//			driver.findElement(ACHIEVEMENTS).click();
//		}
		}
	
	public String userBioData(String enterBioDateType) {
		String bioData = driver.findElement(By.xpath(String.format("//input[@data-testid='%s']", enterBioDateType))).getAttribute("value");	
		return bioData;
	}
	
	public void biologicalSexDropDown(String selectBioLogicalSex) {
		Select biologicalSex = new Select(driver.findElement(BIOLOGICAL_SEX));
		biologicalSex.selectByVisibleText(selectBioLogicalSex);
	}
	
	public List<String> verifyHeightValues() {
		String primaryValue = driver.findElement(PRIMARY_HEIGHT).getAttribute("value");
		String secondaryValue = driver.findElement(SECONDARY_HEIGHT).getAttribute("value");
		 List<String> heightValues =  new ArrayList<String>();
		 heightValues.add(primaryValue);
		 heightValues.add(secondaryValue);
		return heightValues;
	}
	
	public void achievementsText() {
		driver.findElement(ACHIEVEMENTS_TEXT).isDisplayed();
	}
	
	public void badgesAndTimelineText(String enterAchievementsPageText) {
		driver.findElement(By.xpath(String.format("//h2[contains(text(),'%s')]", enterAchievementsPageText))).isDisplayed();
	}
	

}
