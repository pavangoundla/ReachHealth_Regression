package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	
public WebDriver driver;
	
	
	By HELLO_USERTEXT = By.xpath("//h1[contains(text(),'Hello pavan!')]");
	
	public DashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement verifyHelloUserText() {
		return driver.findElement(HELLO_USERTEXT);
	}
	
	public String getDashboardPageURL() {
		return driver.getCurrentUrl();
	}
	

}
