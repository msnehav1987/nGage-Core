package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utils.WebUtil

public class Report {

	WebDriver driver;
	Map<String, WebElement> lvlOne
	Map<String, WebElement> lvlTwo
	Map<String, WebElement> lvlThree


	private void setLevelOne() {
		driver = DriverFactory.getWebDriver()

		lvlOne = new HashMap<String, WebElement>()

		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='menudiv_108']/ul/li/a"))
		for(WebElement e in elements) {
			String key = e.getText().replace("\u00a0", " ").trim()
			lvlOne.put(key, e)
		}
	}

	private void setLevelTwo(String lvl_one) {
		lvlTwo = new HashMap<String, WebElement>()
		WebElement lvlOneElement = lvlOne.get(lvl_one)
		WebElement parent = lvlOneElement.findElement(By.xpath(".."))
		if(!isAreaExpanded(parent)) {
			Actions actions = new Actions(driver)
			actions.doubleClick(lvlOneElement).build().perform()
			WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
			setLevelOne()
		}
		lvlOneElement = lvlOne.get(lvl_one)
		parent = lvlOneElement.findElement(By.xpath(".."))
		List<WebElement> elements = parent.findElements(By.xpath('./ul/li/a'))
		for(WebElement e in elements) {
			String key = e.getText().replace("\u00a0", " ").trim()
			lvlTwo.put(key, e)
		}
	}

	private void setLevelThree(String lvl_one, String lvl_two) {
		lvlThree = new HashMap<String, WebElement>()
		WebElement lvlTwoElement = lvlTwo.get(lvl_two)
		WebElement parent = lvlTwoElement.findElement(By.xpath(".."))
		if(!isAreaExpanded(parent)) {
			Actions actions = new Actions(driver)
			actions.doubleClick(lvlTwoElement).build().perform()
			WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
			setLevelOne()
			setLevelTwo(lvl_one)
		}
		lvlTwoElement = lvlTwo.get(lvl_two)
		parent = lvlTwoElement.findElement(By.xpath(".."))
		List<WebElement> elements = parent.findElements(By.xpath('./ul/li/a'))
		for(WebElement e in elements) {
			String key = e.getText().replace("\u00a0", " ").trim()
			lvlThree.put(key, e)
		}
	}

	private boolean isAreaExpanded(WebElement e) {
		if(e.getAttribute('aria-expanded').equalsIgnoreCase('true')) {
			return true
		}
		else {
			return false
		}
	}

	/* ############################# KEYWORDS ##################################### */	
	@Keyword
	def clickReport(String lvl_one, String lvl_two, String lvl_three) {
		setLevelOne()
		setLevelTwo(lvl_one)
		setLevelThree(lvl_one, lvl_two)
		lvlThree.get(lvl_three).click()
		new Common().waitForReportToLoad(300)
	}

	@Keyword
	def rightClickReport(String lvl_one, String lvl_two, String lvl_three) {
		setLevelOne()
		setLevelTwo(lvl_one)
		setLevelThree(lvl_one, lvl_two)
		Actions actions = new Actions(driver)
		actions.contextClick(lvlThree.get(lvl_three)).build().perform()
	}

	@Keyword
	def verifyReportIsPresentUnderSubGroup(String lvl_one, String lvl_two, String reportName) {
		setLevelOne()
		setLevelTwo(lvl_one)
		setLevelThree(lvl_one, lvl_two)
		if(lvlThree.containsKey(reportName)) {
			KeywordUtil.markPassed('Report '+reportName+' is found under subGroup '+lvl_two)
		}
		else {
			KeywordUtil.markFailedAndStop('Report '+reportName+' is not found under subGroup '+lvl_two)
		}
	}
	
	@Keyword
	def verifyReportIsNotPresentUnderSubGroup(String lvl_one, String lvl_two, String reportName) {
		setLevelOne()
		setLevelTwo(lvl_one)
		setLevelThree(lvl_one, lvl_two)
		if(!lvlThree.containsKey(reportName)) {
			KeywordUtil.markPassed('Report '+reportName+' is not found under subGroup '+lvl_two)
		}
		else {
			KeywordUtil.markFailedAndStop('Report '+reportName+' is found under subGroup '+lvl_two)
		}
	}

	@Keyword
	def verifySubGroupIsPresentUnderGroup(String lvl_one, String subGroupName) {
		setLevelOne()
		setLevelTwo(lvl_one)
		if(lvlTwo.containsKey(subGroupName)) {
			KeywordUtil.markPassed('Sub Group '+subGroupName+' is found under Group '+lvl_one)
		}
		else {
			KeywordUtil.markFailedAndStop('Sub Group '+subGroupName+' is not found under Group '+lvl_one)
		}
	}
	
	@Keyword
	def verifySubGroupIsNotPresentUnderGroup(String lvl_one, String subGroupName) {
		setLevelOne()
		setLevelTwo(lvl_one)
		if(!lvlTwo.containsKey(subGroupName)) {
			KeywordUtil.markPassed('Sub Group '+subGroupName+' is not found under Group '+lvl_one)
		}
		else {
			KeywordUtil.markFailedAndStop('Sub Group '+subGroupName+' is found under Group '+lvl_one)
		}
	}

	@Keyword
	def verifyAllReportsUnderSubGroup(String lvl_one, String lvl_two, String... reportNames) {
		setLevelOne()
		setLevelTwo(lvl_one)
		setLevelThree(lvl_one, lvl_two)

		int actReportCount = lvlThree.size()
		int expReportCount = reportNames.length
		WebUI.verifyEqual(actReportCount, expReportCount)

		boolean isReportPresent = true
		String notFoundReport = ''
		for(String reportName in reportNames) {
			if(!lvlThree.containsKey(reportName)) {
				isReportPresent = false
				notFoundReport = reportName
				break
			}
		}

		if(isReportPresent) {
			KeywordUtil.markPassed('All Reports are present in sub group')
		}
		else {
			KeywordUtil.markFailedAndStop('Report '+notFoundReport+' is not present in Sub Group '+lvl_two)
		}
	}

	@Keyword
	def verifyAllSubGroupsUnderGroup(String lvl_one, String... subGroups) {
		setLevelOne()
		setLevelTwo(lvl_one)

		int actSubGroupsCount = lvlTwo.size()
		int expSubGroupsCount = subGroups.length
		WebUI.verifyEqual(actSubGroupsCount, expSubGroupsCount)

		boolean isSubGroupPresent = true
		String notFoundSubGroup = ''
		for(String subGroup in subGroups) {
			if(!lvlTwo.containsKey(subGroup)) {
				isSubGroupPresent = false
				notFoundSubGroup = subGroup
				break
			}
		}

		if(isSubGroupPresent) {
			KeywordUtil.markPassed('All Sub Groups are present in group')
		}
		else {
			KeywordUtil.markFailedAndStop('Sub Group '+notFoundSubGroup+' is not present in Group '+lvl_one)
		}
	}
}