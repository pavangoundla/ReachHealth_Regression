package SeleniumJavaFramework;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
		LandingPage landingPage = new LandingPage(driver);
		landingPage.acceptCookie();
	}

	public String getDateAndTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		System.out.println(dtf.format(now));
		return currentDate;
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
		Assert.assertEquals(goalsPageURL, "https://demo.reachhealth.io/#/goals/active");

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

		// Clicks on Sign out option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Sign out");

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

		// Clicks on Sign out option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Sign out");
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
		// Clicks on Sign out option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Sign out");
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
		goalsPage.goalsPageTextsOrButtons("Dailies");
		goalsPage.goalsPageTextsOrButtons("Habits");

		// Clicks on Sign out option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Sign out");
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
		// Clicks on Sign out option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Sign out");
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
		// Clicks on Sign out option from user icon
		HeaderPage headerPage = new HeaderPage(driver);
		headerPage.clickOnUserIconOptions("Sign out");
	}

	@Test(dataProvider = "getData")
	public void TC10_createAGoal(String emailId, String password) throws IOException, InterruptedException {
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
		goalsPage.goalsPageTextsOrButtons("Set new goal");
		goalsPage.clickOnAGoal("Weight loss", "Eat more fibre");
		goalsPage.goalsPageTextsOrButtons("Set goal");
		goalsPage.goalsPageTextsOrButtons("Complete goal");
		goalsPage.verifyGoalCompletedDate(getDateAndTime());

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

		// Verifies Name, Email and Date of Birth
		String name = headerPage.userBioData("name");
		String email = headerPage.userBioData("email");
		String day = headerPage.userBioData("day");
		String month = headerPage.userBioData("month");
		String year = headerPage.userBioData("year");
		Assert.assertEquals(name, "pavan", "name displayed incorrectly");
		Assert.assertEquals(email, "Pavan.goundla+2210@zenq.com", "email displayed incorrectly");
		Assert.assertEquals(day, "1", "day displayed incorrectly");
		Assert.assertEquals(month, "9", "month displayed incorrectly");
		Assert.assertEquals(year, "1981", "year displayed incorrectly");

		headerPage.biologicalSexDropDown("Male");

		List<String> heightValues = headerPage.verifyHeightValues();
		System.out.println(heightValues.get(0));
		System.out.println(heightValues.get(1));
		Assert.assertEquals(heightValues.get(0), "1", "Primary value is incorrect");
		Assert.assertEquals(heightValues.get(1), "80", "Secondary value is incorrect");

		// Clicks on Sign out option from user icon
		headerPage.clickOnUserIconOptions("Sign out");
	}

	@Test(dataProvider = "getData")
	public void TC12_validateUserAchievements(String emailId, String password)
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
		headerPage.clickOnUserIconOptions("Achievements");

		// Verifies Achievements, Badges and Timeline sections
		headerPage.achievementsText();
		headerPage.badgesAndTimelineText("Latest badges");
		// Clicks on Sign out option from user icon
		headerPage.clickOnUserIconOptions("Sign out");
	}

	@Test(dataProvider = "getData")
	public void TC13_UpdateQuealthAssessmentWithPoorInputs(String emailId, String password)
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
		dashboardPage.clickOnDashboardPageButton();

		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentPageButton();
		assessmentsPage.answerOptionTypeQuestion("How much do you weigh?", "90");
		assessmentsPage.answerOptionTypeQuestion("Do you know how many minutes of moderate intensity activity you generally carry out each week?", "No");
		assessmentsPage.answerOptionTypeQuestion("In general, how many days a week do you carry out some moderate activity?", "0 days");
		assessmentsPage.answerOptionTypeQuestion("Do you know how many minutes of vigorous intensity activity you generally carry out each week?", "No");
		assessmentsPage.answerOptionTypeQuestion("In general, how many days a week do you carry out some vigorous activity?", "0 days");
		assessmentsPage.answerOptionTypeQuestion("Do you smoke cigarettes on a daily basis?", "Yes");
		assessmentsPage.answerOptionTypeQuestion("How many cigarettes a day do you generally smoke?", "30");
		assessmentsPage.verifyAssessmentScore("Your Quealth score is 1");
	}

	@Test(dataProvider = "getData")
	public void TC14_UpdateQuealthAssessmentWithGoodInputs(String emailId, String password)
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
		dashboardPage.clickOnDashboardPageButton();

		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentPageButton();
		assessmentsPage.answerOptionTypeQuestion("How much do you weigh?", "60");
		assessmentsPage.answerModerateIntensityActivityQuestion(
				"Do you know how many minutes of moderate intensity activity you generally carry out each week?", "Yes",
				"How many minutes of moderate intensity activity do you generally carry out each week?", "150", "", "");
		assessmentsPage.answerVigorousIntensityActivityQuestion(
				"Do you know how many minutes of vigorous intensity activity you generally carry out each week?", "Yes",
				"How many minutes of vigorous intensity activity do you generally carry out each week?", "150", "", "");
		assessmentsPage.answerSmokeQuestion("Do you smoke cigarettes on a daily basis?", "No", "", "",
				"How often do you feel you’re significantly exposed to other people’s cigarette smoke?",
				"Rarely or never");
		assessmentsPage.verifyAssessmentScore("Your Quealth score is 90");
	}

	@Test(dataProvider = "getData")
	public void TC15_UpdateEnergyAssessmentWithGoodInputs(String emailId, String password)
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
		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");
		assessmentsPage.assessmentText();
		assessmentsPage.viewAssessmentsReport("Energy");
		
		assessmentsPage.clickOnAssessmentPageButton();
		assessmentsPage.answerOptionTypeQuestion("How physically active are you?", "I do 20 minutes or more a day of vigorous physical activities, 3 or more days a week.");
		assessmentsPage.answerOptionTypeQuestion("How well do you sleep?", "I feel I sleep well on the whole and wake up feeling refreshed");
		assessmentsPage.answerOptionTypeQuestion("How stressed do you generally feel?", "I felt that I’m coping well emotionally with all the challenges in my life at the moment");
		assessmentsPage.answerOptionTypeQuestion("How often do you wake up feeling at all affected by drinking alcohol the previous day?", "Rarely or never");
		assessmentsPage.answerHowMuchDoYouWeighQueation("How much do you weigh?", "60");
		assessmentsPage.answerOptionTypeQuestion("How many glasses of water would you say you drink each day?", "8 or more");
		assessmentsPage.answerOptionTypeQuestion("How often do you eat refined carbohydrates?", "Rarely or never");
		assessmentsPage.verifyAssessmentScore("Your Energy score is 89");
		
//		assessmentsPage.answerHowMuchDoYouWeighQueation("How much do you weigh?", "60");
//		assessmentsPage.answerOptionTypeQuestion("How many glasses of water would you say you drink each day?", "8 or more");
//		assessmentsPage.answerOptionTypeQuestion("How often do you eat refined carbohydrates?", "Rarely or never");
//		assessmentsPage.verifyAssessmentScore("Your Energy score is 89");
		Thread.sleep(5000);
	}
	
	@Test(dataProvider = "getData")
	public void TC16_UpdateFinancialAssessmentWithGoodInputs(String emailId, String password)
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
		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");
		assessmentsPage.assessmentText();
		assessmentsPage.viewAssessmentsReport("Financial");
		assessmentsPage.clickOnAssessmentPageButton();
		assessmentsPage.answerOptionTypeQuestion("How do you feel about your current financial situation?", "Good");
		assessmentsPage.answerOptionTypeQuestion("Do you know where your money goes?", "Yes, all my spending is planned.");
		assessmentsPage.answerOptionTypeQuestion("Do you ever feel that your spending is out of control?", "Never, I am careful about what I spend my money on.");
		assessmentsPage.answerOptionTypeQuestion("Do you feel that you can comfortably afford to pay for everything that you need each month?", "Yes, and I have money left over.");
		assessmentsPage.answerOptionTypeQuestion("How much do you rely on overdrafts, credit cards, loans or store cards each month?", "Never, I can cover all of my costs.");
		assessmentsPage.answerOptionTypeQuestion("If you do borrow, are you keeping up with repayments?", "Yes, I don’t have any outstanding payments.");
		assessmentsPage.answerOptionTypeQuestion("Do you have any money set aside that you could get to if necessary?", "Yes, I have money set aside.");
		assessmentsPage.answerOptionTypeQuestion("Could you cope if your living expenses went up, or you had to manage on less money?", "Yes, I have some spare money each month and money set aside.");
		assessmentsPage.answerOptionTypeQuestion("Do you have any savings or investments?", "Yes, I save regularly and/or have money invested.");
		assessmentsPage.answerOptionTypeQuestion("Have you made any plans for your pension and retirement?", "Yes, I have a retirement plan which is reviewed regularly.");
		assessmentsPage.verifyAssessmentScore("Finance Score - Green");
	}
	
	@Test(dataProvider = "getData")
	public void TC17_UpdateDepressionAssessmentWithGoodInputs(String emailId, String password)
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
		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");
		assessmentsPage.assessmentText();
		assessmentsPage.viewAssessmentsReport("Depression");
		assessmentsPage.clickOnAssessmentPageButton();
		assessmentsPage.answerOptionTypeQuestion("Little interest or pleasure in doing things?", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Feeling down, depressed, or hopeless?", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Trouble falling or staying asleep, or sleeping too much?", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Feeling tired or having little energy?", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Poor appetite or overeating?", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Feeling bad about yourself - or that you are a failure or have let yourself or your family down?", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Trouble concentrating on things, such as reading the newspaper or watching television?", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Moving or speaking so slowly that other people could have noticed? Or the opposite - being so fidgety or restless that you have been moving around a lot more than usual?", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Thoughts that you would be better off dead, or of hurting yourself in some way?", "Not at all");
		assessmentsPage.verifyAssessmentScore("None or Minimal");
	}
	
	@Test(dataProvider = "getData")
	public void TC18_UpdateAnxietyAssessmentWithGoodInputs(String emailId, String password)
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
		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");
		assessmentsPage.assessmentText();
		assessmentsPage.viewAssessmentsReport("Anxiety");
		assessmentsPage.clickOnAssessmentPageButton();
		assessmentsPage.answerOptionTypeQuestion("Feeling nervous, anxious or on edge", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Not being able to stop or control worrying", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Worrying too much about different things", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Trouble relaxing", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Being so restless that it is hard to sit still.", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Being easily annoyed or irritable", "Not at all");
		assessmentsPage.answerOptionTypeQuestion("Feeling afraid as if something awful might happen", "Not at all");
		assessmentsPage.verifyAssessmentScore("No Symptoms");
	}
	
	@Test(dataProvider = "getData")
	public void TC19_UpdateAlcoholAssessmentWithGoodInputs(String emailId, String password)
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
		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");
		assessmentsPage.assessmentText();
		assessmentsPage.viewAssessmentsReport("Alcohol");
		assessmentsPage.clickOnAssessmentPageButton();
		assessmentsPage.answerOptionTypeQuestion("How often do you have a drink containing alcohol?", "Never");
		assessmentsPage.answerOptionTypeQuestion("How many units of alcohol do you drink on a typical day when you are drinking?", "0 to 2");
		assessmentsPage.answerOptionTypeQuestion("How often have you had 6 or more units if female, or 8 or more if male, on a single occasion in the last year?", "Never");
		assessmentsPage.answerOptionTypeQuestion("How often during the last year have you found that you were not able to stop drinking once you had started?", "Never");
		assessmentsPage.answerOptionTypeQuestion("How often during the last year have you failed to do what was normally expected from you because of your drinking?", "Never");
		assessmentsPage.answerOptionTypeQuestion("How often during the last year have you needed an alcoholic drink in the morning to get yourself going after a heavy drinking session?", "Never");
		assessmentsPage.answerOptionTypeQuestion("How often during the last year have you had a feeling of guilt or remorse after drinking?", "Never");
		assessmentsPage.answerOptionTypeQuestion("How often during the last year have you been unable to remember what happened the night before because you had been drinking?", "Never");
		assessmentsPage.answerOptionTypeQuestion("Have you or somebody else been injured as a result of your drinking?", "No");
		assessmentsPage.answerOptionTypeQuestion("Has a relative or friend, doctor or other health worker been concerned about your drinking or suggested that you cut down?", "No");
		assessmentsPage.verifyAssessmentScore("Lower Risk");
	}
	
	@Test(dataProvider = "getData")
	public void TC20_UpdateMentalWellbeingAssessmentWithGoodInputs(String emailId, String password)
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
		// Navigates and Verifies the Assessment page URL
		AssessmentsPage assessmentsPage = new AssessmentsPage(driver);
		assessmentsPage.clickOnAssessmentsTab();
		String assessmentPageURL = assessmentsPage.getAssessmentsPageURL();
		Assert.assertEquals(assessmentPageURL, "https://demo.reachhealth.io/#/assessments");
		assessmentsPage.assessmentText();
		assessmentsPage.viewAssessmentsReport("Mental Wellbeing");
		assessmentsPage.clickOnAssessmentPageButton();
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling optimistic about the future", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling useful", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling relaxed", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling interested in other people", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve had energy to spare", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been dealing with problems well", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been thinking clearly", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling good about myself", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling close to other people", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling confident", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been able to make up my own mind about things", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling loved", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been interested in new things", "All of the time");
		assessmentsPage.answerOptionTypeQuestion("I’ve been feeling cheerful", "All of the time");
		assessmentsPage.verifyAssessmentScore("Mental wellbeing score - High");
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
