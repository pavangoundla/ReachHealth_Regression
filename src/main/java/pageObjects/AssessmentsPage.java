package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageLocators.AssessmentsPageLocators;

public class AssessmentsPage implements AssessmentsPageLocators {

	public WebDriver driver;

	public AssessmentsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void waitUntilElementIsVisible(int enterTimeInSeconds, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, enterTimeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void clickOnAssessmentsTab() {
		driver.findElement(ASSESSMENTS_TAB).click();
	}

	public String getAssessmentsPageURL() {
		return driver.getCurrentUrl();
	}

	public void clickOnScoreCard(String enterScoreCardName) {
		driver.findElement(By.xpath(String.format("//p[text()='%s']", enterScoreCardName))).click();
	}

	public void assessmentPageTexts(String enterAssessmentPageText) {
		driver.findElement(By.xpath(String.format("//h2[contains(text(),'%s')]", enterAssessmentPageText)))
				.isDisplayed();
	}

	public void assessmentText() {
		driver.findElement(ASSESSMENTSPAGE_ASSESSMENTSTEXT).isDisplayed();
	}

	public void theBigFiveAndRiskFactorsTexts(String enterAssessmentPageText) {
		driver.findElement(By.xpath(String.format("//h2[contains(text(),'%s')]", enterAssessmentPageText)))
				.isDisplayed();
	}

	public void clickOnAssessmentPageButton() {
		driver.findElement(UPDATE_ASSESSMENT_BUTTON).click();
	}

	public void answerHowMuchDoYouWeighQueation(String enterWeightQuestionText, String enterWeightInKgs) {
		String weightQuestionText = driver
				.findElement(By.xpath(String.format("//h2[contains(text(),'%s')]", enterWeightQuestionText))).getText();
		Assert.assertEquals(weightQuestionText, enterWeightQuestionText,
				enterWeightQuestionText + "Not Message displayed");
		waitUntilElementIsVisible(10, WEIGHT_INPUT);
		driver.findElement(WEIGHT_INPUT).click();
		driver.findElement(WEIGHT_INPUT).sendKeys(Keys.BACK_SPACE);
		driver.findElement(WEIGHT_INPUT).sendKeys(enterWeightInKgs);
		driver.findElement(NEXT_BUTTON).click();
	}

	public void answerModerateIntensityActivityQuestion(String doYouPerformMinutesOfModerateIntensity,
			String enterYesOrNo, String howManyMinutesOfModerateIntensity,
			String enterMinutesOfModerateIntensityActivity, String howManyDaysDoYouPerformModerateIntensity,
			String enterNumberOfModerateIntensityActivityDays) {
		waitUntilElementIsVisible(10,
				By.xpath(String.format("//h2[contains(text(),'%s')]", doYouPerformMinutesOfModerateIntensity)));
		String ModerateIntensityText = driver
				.findElement(
						By.xpath(String.format("//h2[contains(text(),'%s')]", doYouPerformMinutesOfModerateIntensity)))
				.getText();
		Assert.assertEquals(ModerateIntensityText, doYouPerformMinutesOfModerateIntensity,
				doYouPerformMinutesOfModerateIntensity + "Not Message displayed");
		waitUntilElementIsVisible(10, By.xpath(String.format("//span[contains(text(),'%s')]", enterYesOrNo)));
		driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", enterYesOrNo))).click();
		if (enterYesOrNo == "Yes") {
			waitUntilElementIsVisible(10,
					By.xpath(String.format("//h2[contains(text(),'%s')]", howManyMinutesOfModerateIntensity)));
			String minutesOfModerateIntensityText = driver
					.findElement(
							By.xpath(String.format("//h2[contains(text(),'%s')]", howManyMinutesOfModerateIntensity)))
					.getText();
			Assert.assertEquals(minutesOfModerateIntensityText, howManyMinutesOfModerateIntensity,
					"Not Message displayed");
			waitUntilElementIsVisible(20, ALL_QUESTIONS_INPUT);
			driver.findElement(ALL_QUESTIONS_INPUT).sendKeys(enterMinutesOfModerateIntensityActivity);
			driver.findElement(NEXT_BUTTON).click();
		} else {
			waitUntilElementIsVisible(10,
					By.xpath(String.format("//h2[contains(text(),'%s')]", howManyDaysDoYouPerformModerateIntensity)));
			String howManyDaysDoYouPerformModerateIntensityText = driver
					.findElement(By.xpath(
							String.format("//h2[contains(text(),'%s')]", howManyDaysDoYouPerformModerateIntensity)))
					.getText();
			Assert.assertEquals(howManyDaysDoYouPerformModerateIntensityText, howManyDaysDoYouPerformModerateIntensity,
					howManyDaysDoYouPerformModerateIntensity + "Not Message displayed");
			waitUntilElementIsVisible(10, By
					.xpath(String.format("//span[contains(text(),'%s')]", enterNumberOfModerateIntensityActivityDays)));
			driver.findElement(By
					.xpath(String.format("//span[contains(text(),'%s')]", enterNumberOfModerateIntensityActivityDays)))
					.click();
		}
	}

	public void answerVigorousIntensityActivityQuestion(String doYouPerformMinutesOfVigorousIntensity,String enterYesOrNo, 
			String howManyMinutesOfVigorousIntensity, String enterMinutesOfVigorousIntensityActivity,
			String howManyDaysDoYouPerformVigorousIntensity, String enterNumberOfVigorousIntensityActivityDays) {
		waitUntilElementIsVisible(10,
				By.xpath(String.format("//h2[contains(text(),'%s')]", doYouPerformMinutesOfVigorousIntensity)));
		String VigorousIntensityText = driver
				.findElement(
						By.xpath(String.format("//h2[contains(text(),'%s')]", doYouPerformMinutesOfVigorousIntensity)))
				.getText();
		Assert.assertEquals(VigorousIntensityText, doYouPerformMinutesOfVigorousIntensity,
				doYouPerformMinutesOfVigorousIntensity + "Not Message displayed");
		waitUntilElementIsVisible(10, By.xpath(String.format("//span[contains(text(),'%s')]", enterYesOrNo)));
		driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", enterYesOrNo))).click();
		if (enterYesOrNo == "Yes") {
			waitUntilElementIsVisible(10,
					By.xpath(String.format("//h2[contains(text(),'%s')]", howManyMinutesOfVigorousIntensity)));
			String minutesOfVigorousIntensityText = driver
					.findElement(
							By.xpath(String.format("//h2[contains(text(),'%s')]", howManyMinutesOfVigorousIntensity)))
					.getText();
			Assert.assertEquals(minutesOfVigorousIntensityText, howManyMinutesOfVigorousIntensity,
					howManyMinutesOfVigorousIntensity + "Not Message displayed");
			waitUntilElementIsVisible(10, ALL_QUESTIONS_INPUT);
			driver.findElement(ALL_QUESTIONS_INPUT).sendKeys(enterMinutesOfVigorousIntensityActivity);
			driver.findElement(NEXT_BUTTON).click();
		} else {
			waitUntilElementIsVisible(10,
					By.xpath(String.format("//h2[contains(text(),'%s')]", howManyDaysDoYouPerformVigorousIntensity)));
			String howManyDaysDoYouPerformVigorousIntensityText = driver
					.findElement(By.xpath(
							String.format("//h2[contains(text(),'%s')]", howManyDaysDoYouPerformVigorousIntensity)))
					.getText();
			Assert.assertEquals(howManyDaysDoYouPerformVigorousIntensityText, howManyDaysDoYouPerformVigorousIntensity,
					howManyDaysDoYouPerformVigorousIntensity + "Not Message displayed");
			waitUntilElementIsVisible(10, By
					.xpath(String.format("//span[contains(text(),'%s')]", enterNumberOfVigorousIntensityActivityDays)));
			driver.findElement(By
					.xpath(String.format("//span[contains(text(),'%s')]", enterNumberOfVigorousIntensityActivityDays)))
					.click();
		}
	}

	public void answerSmokeQuestion(String enterDoYouSmokeText, String selectDoYouSmoke,
			String enterHowManyCigarrettesADayText, String enterNumberOfCiggarretesPerDay,
			String exposedToOtherPeopleCigarrettesSmokeText, String exposedToOtherPeoplesSmokeOption)
			throws InterruptedException {
		waitUntilElementIsVisible(10, By.xpath(String.format("//h2[contains(text(),'%s')]", enterDoYouSmokeText)));
		String doYouSmokeText = driver
				.findElement(By.xpath(String.format("//h2[contains(text(),'%s')]", enterDoYouSmokeText))).getText();
		Assert.assertEquals(doYouSmokeText, enterDoYouSmokeText, enterDoYouSmokeText + "Not Message displayed");
		waitUntilElementIsVisible(10, By.xpath(String.format("//span[contains(text(),'%s')]", selectDoYouSmoke)));
		driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", selectDoYouSmoke))).click();

		if (selectDoYouSmoke == "Yes") {
			waitUntilElementIsVisible(10,
					By.xpath(String.format("//h2[contains(text(),'%s')]", enterHowManyCigarrettesADayText)));
			String howManyCigarrettesADayText = driver
					.findElement(
							By.xpath(String.format("//h2[contains(text(),'%s')]", enterHowManyCigarrettesADayText)))
					.getText();
			Assert.assertEquals(howManyCigarrettesADayText, enterHowManyCigarrettesADayText,
					enterHowManyCigarrettesADayText + "Not Message displayed");
			waitUntilElementIsVisible(10, ALL_QUESTIONS_INPUT);
			driver.findElement(ALL_QUESTIONS_INPUT).sendKeys(enterNumberOfCiggarretesPerDay);
			driver.findElement(NEXT_BUTTON).click();
		}

		else {
			waitUntilElementIsVisible(10,
					By.xpath(String.format("//h2[contains(text(),'%s')]", exposedToOtherPeopleCigarrettesSmokeText)));
			String s = driver
					.findElement(By.xpath(
							String.format("//h2[contains(text(),'%s')]", exposedToOtherPeopleCigarrettesSmokeText)))
					.getText();
			Assert.assertEquals(s, exposedToOtherPeopleCigarrettesSmokeText,
					exposedToOtherPeopleCigarrettesSmokeText + "Not Message displayed");
			waitUntilElementIsVisible(10,
					By.xpath(String.format("//span[contains(text(),'%s')]", exposedToOtherPeoplesSmokeOption)));
			driver.findElement(
					By.xpath(String.format("//span[contains(text(),'%s')]", exposedToOtherPeoplesSmokeOption))).click();
		}
	}

	public void verifyQuealthScore(String enterQuealthScoreText) {
		waitUntilElementIsVisible(10, By.xpath(String.format("//h2[contains(text(),'%s')]", enterQuealthScoreText)));
		String yourQuealthScore = driver
				.findElement(By.xpath(String.format("//h2[contains(text(),'%s')]", enterQuealthScoreText))).getText();
		Assert.assertEquals(yourQuealthScore, enterQuealthScoreText, enterQuealthScoreText + "Not Message displayed");
	}

}
