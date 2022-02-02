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
	public void TC01_loginToReachHealthWithValidCredentials(String emailId, String password)
			throws IOException, InterruptedException {

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

		// Clicks on Sign out option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Sign out");
	}

	@Test
	public void TC02_loginToReachHealthWithInvalidCredentials() throws IOException {

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
	public void TC03_validateAllPageTabs(String emailId, String password) throws IOException, InterruptedException {
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

		// Verifies the Dashboard page URL
		String dashboardPageURL = dashboardPage.getDashboardPageURL();
		Assert.assertEquals(dashboardPageURL, "https://demo.reachhealth.io/#/dashboard");

		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");

		// Navigates and Verifies the Goals page URL
		GoalsPage goalsPage = new GoalsPage(driver);
		goalsPage.clickOnGoalsTab();
		String goalsPageURL = goalsPage.getGoalsPageURL();
		Assert.assertEquals(goalsPageURL, "https://demo.reachhealth.io/#/goals/create");

		// Navigates and Verifies the Activity page URL
		ActivityPage activityPage = new ActivityPage(driver);
		activityPage.clickOnActivityTab();
		String activityPageURL = activityPage.getActivityPageURL();
		Assert.assertEquals(activityPageURL, "https://demo.reachhealth.io/#/activity");

		// Navigates and Verifies the Resources page URL
		ResourcesPage resourcesPage = new ResourcesPage(driver);
		resourcesPage.clickOnResourcesTab();
		String resourcesPageURL = resourcesPage.getResourcesPageURL();
		Assert.assertEquals(resourcesPageURL, "https://demo.reachhealth.io/#/resources");

		// Clicks on Sign out option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Sign out");
	}

	@Test(dataProvider = "getData")
	public void TC04_verifyDashboardPageSections(String emailId, String password)
			throws IOException, InterruptedException {
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

		// Verifies the Dashboard page URL
		String dashboardPageURL = dashboardPage.getDashboardPageURL();
		Assert.assertEquals(dashboardPageURL, "https://demo.reachhealth.io/#/dashboard");

		// verifies the Dashboard page sections
		String quealthText = dashboardPage.dashboardPageSections("Quealth");
		Assert.assertEquals(quealthText, "Quealth");
		System.out.println(quealthText);

		String healthBalanceText = dashboardPage.dashboardPageSections("Health balance");
		Assert.assertEquals(healthBalanceText, "Health balance");
		System.out.println(healthBalanceText);

		String questionText = dashboardPage.dashboardPageSections("Question");
		Assert.assertEquals(questionText, "Question");
		System.out.println(questionText);

		String riskFactorsText = dashboardPage.dashboardPageSections("Risk factors");
		Assert.assertEquals(riskFactorsText, "Risk factors");
		System.out.println(riskFactorsText);

		String achievementsText = dashboardPage.dashboardPageSections("Achievements");
		Assert.assertEquals(achievementsText, "Achievements");
		System.out.println(achievementsText);

	}

	@Test(dataProvider = "getData")
	public void TC05_viewQuealthReport(String emailId, String password) throws IOException, InterruptedException {
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

		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");
		assessmentsPage.clickOnScoreCard("Quealth");
		assessmentsPage.assessmentPageTexts("Your Quealth score is");

	}

	@Test(dataProvider = "getData")
	public void TC06_verifyAssessmentPageSections(String emailId, String password)
			throws IOException, InterruptedException {
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

		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");
		assessmentsPage.assessmentText();
		assessmentsPage.theBigFiveAndRiskFactorsTexts("The big five");
		assessmentsPage.theBigFiveAndRiskFactorsTexts("Risk factors");
	}

	@Test(dataProvider = "getData")
	public void TC07_verifyGoalsPageSections(String emailId, String password) throws IOException, InterruptedException {
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

		// Navigates and Verifies the Goals page URL
		GoalsPage goalsPage = new GoalsPage(driver);
		goalsPage.clickOnGoalsTab();
		String goalsPageURL = goalsPage.getGoalsPageURL();
		// Assert.assertEquals(goalsPageURL,
		// "https://demo.reachhealth.io/#/goals/create");
		goalsPage.GoalsText();
		goalsPage.dailiesAndHabitsTexts("Dailies");
		goalsPage.dailiesAndHabitsTexts("Habits");
	}

	@Test(dataProvider = "getData")
	public void TC08_verifyActivityPageSections(String emailId, String password)
			throws IOException, InterruptedException {
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

		// Navigates and Verifies the Activity page URL
		ActivityPage activityPage = new ActivityPage(driver);
		activityPage.clickOnActivityTab();
		String activityPageURL = activityPage.getActivityPageURL();
		Assert.assertEquals(activityPageURL, "https://demo.reachhealth.io/#/activity");

		activityPage.todayText();
		activityPage.activityPageTexts("Steps");
		activityPage.activityPageTexts("Exercise");
		activityPage.activityPageTexts("Distance");
		activityPage.activityPageTexts("Calories");
		activityPage.activityPageTexts("Heart");
		activityPage.activityPageTexts("Sleep");
	}

	@Test(dataProvider = "getData")
	public void TC09_verifyResourcesPageSections(String emailId, String password)
			throws IOException, InterruptedException {
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

		// Navigates and Verifies the Resources page URL
		ResourcesPage resourcesPage = new ResourcesPage(driver);
		resourcesPage.clickOnResourcesTab();
		String resourcesPageURL = resourcesPage.getResourcesPageURL();
		Assert.assertEquals(resourcesPageURL, "https://demo.reachhealth.io/#/resources");

		resourcesPage.resourcesPageTexts("Browse categories");
		resourcesPage.resourcesPageTexts("Featured");
		resourcesPage.resourcesPageTexts("Most popular");
		resourcesPage.resourcesPageTexts("Recipes");

	}

	@Test(dataProvider = "getData")
	public void TC11_validateUserAccountSettings(String emailId, String password)
			throws IOException, InterruptedException {
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

		// Clicks on Account settings option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Account settings");
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
