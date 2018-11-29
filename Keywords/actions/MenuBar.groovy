package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

public class MenuBar {

	/**
	 * Method will return record count displayed for Activity in left menu
	 * For Ex: if Left menu activity name is "Activity A(100)", then it will return value 100 as a String"
	 * @param element
	 * @return
	 */

	@Keyword
	def getRecordCountInActivity(TestObject element) {
		WebUI.waitForElementPresent(element, GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(element, GlobalVariable.G_LongTimeout)
		String nodeText = WebUI.getText(element)
		try {
			int startIndex = nodeText.lastIndexOf('(')+1
			int lastIndex = nodeText.length()-1
			String recordCountInString = nodeText.substring(startIndex, lastIndex).trim()
			return Integer.parseInt(recordCountInString)
		}
		catch(Exception e) {
			println "Coult not get record count "+e.toString()
			return -1
		}
	}

	@Keyword
	def refreshActivityUntilRecordCountIncreases(TestObject element, int timeout) {
		int originalCount = getRecordCountInActivity(element)
		int currentCount = originalCount
		boolean hasRecordCountIncreased = false

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		while(currentTime < endTime) {
			println "Original Count = "+originalCount+"currentCount = "+currentCount
			if(originalCount < 0 || currentCount < 0 || currentCount <= originalCount) {
				WebUI.rightClick(element)
				WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/contextMenu_Refresh'), GlobalVariable.G_SmallTimeout)
				WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/contextMenu_Refresh'))
				WebUI.waitForJQueryLoad(GlobalVariable.G_SmallTimeout)
				WebUI.delay(5)
				currentCount = getRecordCountInActivity(element)
				currentTime = System.currentTimeMillis()
			}
			else {
				hasRecordCountIncreased = true
				break
			}
		}

		if(hasRecordCountIncreased) {
			KeywordUtil.markPassed("Activity count refreshed")
		}
		else {
			KeywordUtil.markFailedAndStop("Activity count not refreshed in given time "+timeout+" Seconds")
		}
	}

	@Keyword
	def getAllSubMenu(TestObject menu) {
		WebElement menuWebElement=WebUtil.getWebElement(menu)
		WebElement parent = menuWebElement.findElement(By.xpath(".."))
		List<WebElement> elements = parent.findElements(By.xpath('./ul/li/a'))

		List<String> subMenu=new ArrayList()
		for(WebElement element in elements) {
			subMenu.add(element.getText().trim())
		}
		return subMenu
	}

	@Keyword
	def verifyAllSubmenuAreSortedByActivityCount(List<String> subMenus,String sortOrder) {
		boolean isSorted;
		List<Integer> activityCounts=new ArrayList<Integer>()
		for(String subMenuText in subMenus) {
			try {
				int startIndex = subMenuText.lastIndexOf('(')+1
				int lastIndex = subMenuText.length()-1
				String recordCountInString = subMenuText.substring(startIndex, lastIndex).trim()
				activityCounts.add(Integer.parseInt(recordCountInString))
			}
			catch(Exception e) {
				println "Coult not get record count "+e.toString()
				KeywordUtil.markErrorAndStop('Cannot fetch activity record count. Activity name = '+subMenuText)
			}
		}

		List<Integer> sortedActivityCountsList=new ArrayList<Integer>()
		sortedActivityCountsList.addAll(activityCounts)
		Collections.sort(sortedActivityCountsList)

		if(sortOrder.equalsIgnoreCase('desc'))
			Collections.reverse(sortedActivityCountsList)

		isSorted=activityCounts.equals(sortedActivityCountsList)
		if(!isSorted)
			KeywordUtil.markErrorAndStop("submenus are not sorted")
		else
			KeywordUtil.markPassed("submenus are in sorted order")
	}

	@Keyword
	def verifyAllSubmenuAreSortedByActivityName(List<String> subMenus,String sortOrder) {
		//converting sub menu items to lower case
		List<String> subMenusLowerCase=new ArrayList<String>()
		for(String subMenu in subMenus)
		{
			subMenusLowerCase.add(subMenu.toLowerCase())
		}
		subMenus.clear()
		subMenus.addAll(subMenusLowerCase)

		if(sortOrder.equalsIgnoreCase('asc'))
			subMenus.remove(0)
		else
			subMenus.remove(subMenus.size()-1)

		boolean isSorted;
		List<String> sortedActivityNameList=new ArrayList<String>()
		sortedActivityNameList.addAll(subMenus)
		Collections.sort(sortedActivityNameList)

		if(sortOrder.equalsIgnoreCase('desc'))
			Collections.reverse(sortedActivityNameList)

		println 'Actual: '+subMenus
		println 'Exp: '+sortedActivityNameList
		isSorted=subMenus.equals(sortedActivityNameList)
		if(!isSorted)
			KeywordUtil.markErrorAndStop("submenus are not sorted")
		else
			KeywordUtil.markPassed("submenus are in sorted order")
	}

	StringBuilder treeXpath;


	@Keyword
	def clickTreeMenu(String moduleName, String... menuPath) {

		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		int lastIndex = treePath.size()-1
		treePath.remove(lastIndex)
		expandTree(treePath)

		String appendBrace = lastIndex>1?" (":""
		treeXpath.append("/ul/li/a[contains(text(),'"+menuPath[size-1]+appendBrace+"')]")
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath(treeXpath.toString())).click()
	}

	@Keyword
	def getRecordCountInActivity(String moduleName, String... menuPath) {

		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		int lastIndex = treePath.size()-1
		treePath.remove(lastIndex)
		expandTree(treePath)

		String appendBrace = lastIndex>1?" (":""
		treeXpath.append("/ul/li/a[contains(text(),'"+menuPath[size-1]+appendBrace+"')]")
		WebDriver driver = DriverFactory.getWebDriver()
		String nodeText = driver.findElement(By.xpath(treeXpath.toString())).getText()

		try {
			int startIndex = nodeText.lastIndexOf('(')+1
			int endIndex = nodeText.length()-1
			String recordCountInString = nodeText.substring(startIndex, endIndex).trim()
			return Integer.parseInt(recordCountInString)
		}
		catch(Exception e) {
			println "Coult not get record count "+e.toString()
			return -1
		}
	}

	@Keyword
	def verifyAllActivityNamesAreValidDate(String moduleName, String dateFormat, String... menuPath) {

		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
//		int lastIndex = treePath.size()-1
//		treePath.remove(lastIndex)
		expandTree(treePath)

		WebDriver driver = DriverFactory.getWebDriver()
		treeXpath.append("/ul/li/a")
		List<WebElement> eleList = driver.findElements(By.xpath(treeXpath.toString()))

		for(WebElement e in eleList) {
			String dateValue = e.getText().split(' \\(')[0].trim()
			if(!dateValue.equalsIgnoreCase('[Empty]'))
				(new Common()).verifyDateFormat(dateValue, dateFormat)
		}
	}

	/**
	 * 
	 * @param treePath
	 */
	private void expandTree(List<String> treePath) {
		WebDriver driver = DriverFactory.getWebDriver()
		treeXpath = new StringBuilder("//div[@id='menudiv_104']")
		WebElement a
		WebElement li

		int i = 0
		for(String path in treePath) {

			String appendBrace = i>1?" (":""
			treeXpath.append("/ul/li/a[contains(text(),'"+path+appendBrace+"')]")
			a = driver.findElement(By.xpath(treeXpath.toString()))
			treeXpath.append("/..")
			li = a.findElement(By.xpath(".."))

			if(!isAreaExpanded(li)) {
				Actions asDriver = new Actions(driver)
				asDriver.doubleClick(a).build().perform()
				WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
			}
			i++
		}
	}

	/**
	 * 
	 * @param li
	 * @return
	 */
	private boolean isAreaExpanded(WebElement li) {
		return Boolean.parseBoolean(li.getAttribute("aria-expanded"))
	}
}