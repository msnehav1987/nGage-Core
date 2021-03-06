import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document if not present'
CustomKeywords.'actions.Common.createBulkDocuments_VerticalMenuWizard'(1)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Loan Interactive - Loan application'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click on Reset layout to bring columns to original position'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/td_ResetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

int colNo_DocID_Original=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
int colNo_DocCreateDate_Original = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc Create Date')

'drag and drop item/Change Layout'
WebUI.dragAndDropToObject(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'), findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))

int colNo_DocID_After=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
int colNo_DocCreateDate_After = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc Create Date')

'click on set layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_SetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
WebUI.delay(2) //This is needed as Alert is being displayed for 1.5 sec

WebUI.verifyEqual(colNo_DocCreateDate_After, colNo_DocID_Original)

'Click on Reset layout to bring columns to original position'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/td_ResetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

int colNo_DocID_AfterReset=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
int colNo_DocCreateDate_AfterReset = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc Create Date')

WebUI.verifyEqual(colNo_DocCreateDate_AfterReset, colNo_DocCreateDate_Original)
WebUI.verifyEqual(colNo_DocID_AfterReset, colNo_DocID_AfterReset)