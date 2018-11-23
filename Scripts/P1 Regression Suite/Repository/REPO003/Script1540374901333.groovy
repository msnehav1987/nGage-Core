import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login into application'
CustomKeywords.'actions.Common.login'()

'Verify the Repository Menu is visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify Advance Search and Browse Results tab'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/a_Advanced Search Tab'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/a_Browse Results'), GlobalVariable.G_LongTimeout)

'Right click on the EDM'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_SavedSearch'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/contextMenu_Refresh'), GlobalVariable.G_LongTimeout)

'Click on refresh Context Menu.'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Icon_Expand_SavedSearch'))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/li_SavedSearch'), 'aria-busy', 'true', GlobalVariable.G_LongTimeout)
/*String backGroundcss = WebUI.getCSSValue(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Icon_Expand_SavedSearch'), 'background')
WebUI.verifyMatch(backGroundcss, '.*throbber.gif.*', true)*/
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)