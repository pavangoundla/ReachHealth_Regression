package SeleniumJavaFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ActivityPage;
import pageObjects.AssessmentsPage;
import pageObjects.DashboardPage;
import pageObjects.GoalsPage;
import pageObjects.HeaderPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ResourcesPage;
import resources.BaseClass;

public class ReachHealthTests extends BaseClass {

	// public WebDriver driver;
	private static Logger Log = LogManager.getLogger(ReachHealthTests.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {
		// To initialize the web driver
		driver = initiliazeDriver();
		Log.info("Driver is initialized");
		// To load ReachHealth application
		driver.get(prop.getProperty("ReachHealth_Demo"));
	}

	@Test(dataProvider = "getData")
	public void loginToReachHealthWithValidCredentials(String emailId, String password) throws IOException {

//		// To load ReachHealth application
//		driver.get(prop.getProperty("ReachHealth_Demo"));

		// To get access to the LandingPage objects
		LandingPage landingPage = new LandingPage(driver);

		// To maximize the ReachHealth LandingPage
		driver.manage().window().maximize();

		// To verify the text "Become the healthiest possible you"
		// String text = landingPage.verifyhealthiestPossibleText().getText();

		Assert.assertTrue(landingPage.verifyhealthiestPossibleText().isDisplayed(), "TextDisplayed");

		// To print the LandingPage title
		System.out.println("Page title name is " + driver.getTitle());

		// To click on 'Sign in' button in LandingPage
		landingPage.signIn().click();
		Log.info("clicked on Sign In");

		// To get access to the LandingPage objects
		LoginPage loginPage = new LoginPage(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// To verify the text "Sign in"
		String signInText = loginPage.verifysignInText().getText();

		Assert.assertEquals(signInText, "Sign in", "Message displayed");

		// To enter email Id, Password and clicks on Sign in button
		loginPage.enterLoginDetails(emailId, password);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// To get access to the LandingPage objects
		DashboardPage dashboardPage = new DashboardPage(driver);

		String helloUserText = dashboardPage.verifyHelloUserText().getText();

		Assert.assertEquals(helloUserText, "Hello pavan!", "Message displayed");
	}

	@Test
	public void loginToReachHealthWithInvalidCredentials() throws IOException {

//		// To load ReachHealth application
//		driver.get(prop.getProperty("ReachHealth_Demo"));

		// To get access to the LandingPage objects
		LandingPage landingPage = new LandingPage(driver);

		// To maximize the ReachHealth LandingPage
		driver.manage().window().maximize();

		// To verify the text "Become the healthiest possible you"
		// String text = landingPage.verifyhealthiestPossibleText().getText();

		Assert.assertTrue(landingPage.verifyhealthiestPossibleText().isDisplayed(), "TextDisplayed");

		// To print the LandingPage title
		System.out.println("Page title name is " + driver.getTitle());

		// To click on 'Sign in' button in LandingPage
		landingPage.signIn().click();

		// To get access to the LandingPage objects
		LoginPage loginPage = new LoginPage(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// To verify the text "Sign in"
		String signInText = loginPage.verifysignInText().getText();

		Assert.assertEquals(signInText, "Sign in", "Message displayed");

		// To enter email Id, Password and clicks on Sign in button
		loginPage.enterLoginDetails("pavan@gmail.com", "pavan@123");

		String incorrectEmailPassword = loginPage.incorrectEmailPasswordMessage().getText();

		System.out.println(incorrectEmailPassword);

		Assert.assertTrue(loginPage.incorrectEmailPasswordMessage().isDisplayed(),
				"Inccorect Email or Password message not displayed");
		Log.info(incorrectEmailPassword);
	}

	@Test(dataProvider = "getData")
	public void validateAllPageTabs(String emailId, String password) throws IOException, InterruptedException {
//		// To load ReachHealth application
//		driver.get(prop.getProperty("ReachHealth_Demo"));

		// To get access to the LandingPage objects
		LandingPage landingPage = new LandingPage(driver);

		// To maximize the ReachHealth LandingPage
		driver.manage().window().maximize();

		// To verify the text "Become the healthiest possible you"
		// String text = landingPage.verifyhealthiestPossibleText().getText();

		Assert.assertTrue(landingPage.verifyhealthiestPossibleText().isDisplayed(), "TextDisplayed");

		// To print the LandingPage title
		System.out.println("Page title name is " + driver.getTitle());

		// To click on 'Sign in' button in LandingPage
		landingPage.signIn().click();
		Log.info("clicked on Sign In");

		// To get access to the LandingPage objects
		LoginPage loginPage = new LoginPage(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// To verify the text "Sign in"
		String signInText = loginPage.verifysignInText().getText();

		Assert.assertEquals(signInText, "Sign in", "Message displayed");

		// To enter email Id, Password and clicks on Sign in button
		loginPage.enterLoginDetails(emailId, password);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// To get access to the LandingPage objects
		DashboardPage dashboardPage = new DashboardPage(driver);

		String helloUserText = dashboardPage.verifyHelloUserText().getText();

		Assert.assertEquals(helloUserText, "Hello pavan!", "Message displayed");

		String dashboardPageURL = dashboardPage.getDashboardPageURL();

		Assert.assertEquals(dashboardPageURL, "https://demo.reachhealth.io/#/dashboard");
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);

		assessmentsPage.clickOnAssessmentsTab();

		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");

		GoalsPage goalsPage = new GoalsPage(driver);

		goalsPage.clickOnGoalsTab();

		String goalsPageURL = goalsPage.getGoalsPageURL();
		Assert.assertEquals(goalsPageURL, "https://demo.reachhealth.io/#/goals");

		ActivityPage activityPage = new ActivityPage(driver);

		activityPage.clickOnActivityTab();

		String activityPageURL = activityPage.getActivityPageURL();
		Assert.assertEquals(activityPageURL, "https://demo.reachhealth.io/#/activity");
		
		ResourcesPage resourcesPage = new ResourcesPage(driver);

		resourcesPage.clickOnResourcesTab();

		String resourcesPageURL = resourcesPage.getResourcesPageURL();
		Assert.assertEquals(resourcesPageURL, "https://demo.reachhealth.io/#/resources");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];

		data[0][0] = "Pavan.goundla+2210@zenq.com";
		data[0][1] = "Pavan@123";
		return data;
	}

}
