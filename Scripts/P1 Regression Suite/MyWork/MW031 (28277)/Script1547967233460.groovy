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

import common.ChartType
import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Docuement if not present'
if(!FLAG_P1_MW_DOC341) {
	CustomKeywords.'actions.Data.create'(DocClass.CLOSURE_ACTION, DocType.CLOSURE_ACTION, P1_MW_DOC341)
	FLAG_P1_MW_DOC341 = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click on "Closure Action" process'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Verify Chart sections and its contents'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Bar Chart - Header'), GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Bar Chart - Header')).trim(), 'Closure Action - SLA Status View', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Pie Chart - Header')).trim(), 'Closure Action - Summary', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/td_Activity Summary')).trim(), 'Activity Summary', false)

WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show All Workitems'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show All Workitems')).trim(), 'Show All Work Items', false)

WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show Due Soon Work Item'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show Due Soon Work Item')).trim(), 'Show Due Soon Work Items', false)

WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show On Time Work Items'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show On Time Work Items')).trim(), 'Show On Time Work Items', false)

WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show Overdue Workitems'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show Overdue Workitems')).trim(), 'Show Overdue Work Items', false)

'Verify activity count in table'
int recordCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/table_SingleProcess'))

'Verify correct number of slices are displayed in pie chart'
CustomKeywords.'actions.Chart.verifyNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_SingleProcess_Summary'), recordCount, ChartType.PIE)

'Verify correct number of slices in bar chart'
CustomKeywords.'actions.Chart.verifyNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_SingleProcess_SLAStatusView'), recordCount*4, ChartType.BAR_VERTICAL)

'Get Row Number for closure activity process'
int rowNo = CustomKeywords.'actions.Table.getCorrectSliceNumber'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/table_SingleProcess'), 7, 2, 'Activity A')
println 'Expected Row No is :'+rowNo

'Click on respective slice in Bar chart'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_SingleProcess_Summary'), rowNo, ChartType.PIE)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Activity A is selected in Tree path'
CustomKeywords.'actions.MenuBar.verifyTreeIsSelected'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')