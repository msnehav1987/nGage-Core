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

'Login Into Application'
CustomKeywords.'actions.Common.login'('Auto_AI_Check', 'Password1234!', 'IPM_EPM50MASTER_502_AUTOMATION')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowTitle('Savana nGage')

'Create a new BovDefault Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Closure Action', 'Closure Action')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

WebUI.setText(findTestObject('Object Repository/Page_WMI/Closure Action/input_eform_Customer_Name'), 'Atul')
WebUI.setText(findTestObject('Object Repository/Page_WMI/Closure Action/input_eform_Customer_Details'), 'Automation Script')

WebUI.mouseOver(findTestObject('Page_WMI_NEW/Closure_Action/span_Actions'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'), GlobalVariable.G_LongTimeout)

'Switch to main window and close'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Navigate to newly created menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes','Closure Action', 'Activity A', 'Atul')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify grid records present'
int activityRecordCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes','Closure Action', 'Activity A', 'Atul')
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'), activityRecordCount)

'Verify the closure actions should not be visible in Action menu'
WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_Actions Button'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/action_AssignWorkItems'), GlobalVariable.G_LongTimeout)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/action_UpdateField'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/action_RouteToActivityC'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/action_RouteToActivityD'), GlobalVariable.G_LongTimeout)

WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_Actions Button'))

'Open Work Item'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocID'))

CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'),1,8)

//WebUI.delay(10)
'switch to new window'
WebUI.switchToWindowIndex(1)

'Click on Customer Information'
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/span_Customer Information'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Closure Action is Not Present'
WebUI.verifyElementNotPresent( findTestObject('Page_WMI/Closure Action/button_CustomerActions'), GlobalVariable.G_LongTimeout)

'Verify field Customer Name Present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Closure_Action/input_Customer Name'), GlobalVariable.G_LongTimeout)