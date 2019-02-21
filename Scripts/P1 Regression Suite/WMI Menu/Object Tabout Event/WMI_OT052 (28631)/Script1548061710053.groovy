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
CustomKeywords.'actions.Common.login'()

//No. 1
'Select Doc Class as "Object Tab Out Events" and Doc type as "DoNotSetValueOnLoad and SetFocus Event" from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'DoNotSetValueOnLoad and SetFocus Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/span_Save'))

'Click on Close Window button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Close Global new dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on Recent Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify the tabs SingleresultView and inlineView, click on InlineView tab'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/a_SingleResultView'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/a_InlineView'))

WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/a_InlineView'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/table_InlineResultView'), GlobalVariable.G_LongTimeout)

'Select document from the grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/table_InlineResultView'), 1, 6)
CustomKeywords.'actions.Common.waitForTabLoading'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/iframe_Close Window_ContentPla'), GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_ReferenceObjectCheckBox'), GlobalVariable.G_LongTimeout)

'Verify the fields reference object checkbox control (checkbox), String field (text box with view check box is un-checked) and currency field text box.'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_ReferenceObjectCheckBox'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_StringField'))
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_StringField'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_CurrencyField'))
WebUI.scrollToElement(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_CurrencyField'), GlobalVariable.G_LongTimeout)

'Verify that reference object checkbox control (checkbox) is checked'
WebUI.check(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_ReferenceObjectCheckBox'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

WebUI.waitForElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_StringField'), 'value', 'Checkbox is checked', GlobalVariable.G_LongTimeout)
WebUI.verifyElementChecked(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_ReferenceObjectCheckBox'), GlobalVariable.G_LongTimeout)

'No cursor control in currency field text box.'
CustomKeywords.'actions.Common.verifyElementHasFocus'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_CurrencyField'))