import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

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

'Create Docuement'
CustomKeywords.'actions.Common.createDocument_VerticalMenuWizard'(P1_LOANAPPL_FIRSTNAME_DOC1, P1_LOANAPPL_LASTNAME_DOC1, P1_LOANAPPL_AMOUNT_DOC1, '')
CustomKeywords.'actions.Common.createDocument_VerticalMenuWizard'(P1_LOANAPPL_FIRSTNAME_DOC2, P1_LOANAPPL_LASTNAME_DOC2, P1_LOANAPPL_AMOUNT_DOC2, '')

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

'Expand Search bar'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Enter filter criteria Loan amount range'
WebUI.setText(findTestObject('Page_nGage_Dashboard/My_Work/search_LoanAmount_From'), P1_LOANAPPL_AMOUNT_FILTER_FROM)
WebUI.sendKeys(findTestObject('Page_nGage_Dashboard/My_Work/search_LoanAmount_From'), Keys.chord(Keys.TAB))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

WebUI.setText(findTestObject('Page_nGage_Dashboard/My_Work/search_LoanAmount_To'), P1_LOANAPPL_AMOUNT_FILTER_TO)
WebUI.sendKeys(findTestObject('Page_nGage_Dashboard/My_Work/search_LoanAmount_To'), Keys.chord(Keys.TAB))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Atleast 1 record is returned by filter'
int rowsCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
WebUI.verifyGreaterThanOrEqual(rowsCount, 1)

'Sort records by Doc ID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

int colNoLoanAmount=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Loan Amount')

CustomKeywords.'actions.Table.verifyRecordsWithinRange'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNoLoanAmount, Double.parseDouble(P1_LOANAPPL_AMOUNT_FILTER_FROM), Double.parseDouble(P1_LOANAPPL_AMOUNT_FILTER_TO))