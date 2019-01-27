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
import utils.Consts
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object InlineResultView')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on WMI Harness page'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_WMI Harness'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))

'Wait for save operation to complete'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Delete'), GlobalVariable.G_LongTimeout)

'Get Window title to verify the name in main window'
String windowTitle = WebUI.getWindowTitle()
String[] str_array = windowTitle.split("-")
String windowTitleText = str_array[0].trim()
String windowTitleDate = str_array[1].trim()
'Click on Close Window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'))

'Switch to main window and close'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/iframe_iframe_103'))

'Get value from Document title from 1st row'
int documentTitleColumn = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Document Title')
String documentTitle = CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, documentTitleColumn)

'Verify document tile and window title is matching'
WebUI.verifyMatch(documentTitle, '.*'+windowTitleText+'.*', true)
WebUI.verifyMatch(documentTitle, '.*'+windowTitleDate+'.*', true)

'Click and open the saved document from recent document table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, documentTitleColumn)

'Switch to opened window'
WebUI.switchToWindowIndex(1)

'Wait till the page loads'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Delete'), GlobalVariable.G_LongTimeout)

'Click on tab 2) InlineResultView'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/tab2_InlineResultView'))

'Click on the first row in table'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/table_CellBMString'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))
////WebUI.delay(10)
//CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/input_ReferenceObjectEvent'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)


'Get value from Reference Object Event text box'
String referenceTextBox = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/input_ReferenceObjectEvent'), 'value').trim()

'Modify value in Reference Object text box'
String addText = DateUtil.getCurrentDateTimeMinusDays(0, Consts.FORMAT_DATETIME)
CustomKeywords.'actions.Common.setTextJQuery'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/input_ReferenceObjectEvent'), addText)

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/save_2InlineResultView_tab'))

'Close the window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'))

'Switch to opened window'
WebUI.switchToWindowTitle('Savana nGage')

'Navigate to Recent docuements'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')

'Open the saved docuemnt'
'Click and open the saved document from recent document table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, documentTitleColumn)

'Switch to opened window'
WebUI.switchToWindowIndex(1)

'Wait till the page loads'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Delete'), GlobalVariable.G_LongTimeout)

'Click on tab 2) InlineResultView'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/tab2_InlineResultView'))

'Click on the first row in table'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/table_CellBMString'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))
WebUI.delay(10)

'Verify the document is opened in InlineView'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/input_ReferenceObjectEvent'))

'Get value from Reference Object Event text box'
String newReferenceTextBox = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/input_ReferenceObjectEvent'), 'value')

'Verify the text from Reference Object Event text box'
WebUI.verifyMatch(newReferenceTextBox, addText, false)