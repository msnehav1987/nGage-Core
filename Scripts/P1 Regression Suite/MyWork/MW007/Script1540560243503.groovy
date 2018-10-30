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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'), GlobalVariable.G_LongTimeout)

'Expand closure action'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'))

'right click on Activity A'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)


'verify labels'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ActivityName'), GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ActivityName')), 'Activity A', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ProcessName')), 'Closure Action', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_SearchClassID')), '100012', false)

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))

WebUI.delay(GlobalVariable.G_LongTimeout)