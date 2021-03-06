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
import utils.Consts
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Create a new Refrence Object Feature Document'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object ImportMode Interactive')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI page'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/lbl_Information'), GlobalVariable.G_LongTimeout)

'Verify information text'
String expText = 'This WMI imparts Reference Object features for ImportMode Interactive'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/lbl_Information'), expText)

'Save WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_CloseWindow'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/lbl_Information'), GlobalVariable.G_LongTimeout)

'Click on tab 1) Interactive'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/span_1) INTERACTIVE'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Perform Mouse over on New button'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/select_New'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/option_RenderAllFieldsTypes'), GlobalVariable.G_LongTimeout)

'Select option Render All Field Types'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/option_RenderAllFieldsTypes'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Scroll to Inline view'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/tab1_dropdown_InlineForm/input_BM String'), GlobalVariable.G_LongTimeout)

String BMText = 'Text - '+DateUtil.getCurrentDateTime(Consts.FORMAT_DATETIME)
'Set text in BM String'
CustomKeywords.'actions.Common.setTextJQuery'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/tab1_dropdown_InlineForm/input_BM String'), BMText)

'Click on Save from reference Object'
//CustomKeywords.'actions.Common.scrollToElement'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/tab1_dropdown_InlineForm/input_Save'))
WebUI.scrollToElement(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/tab1_dropdown_InlineForm/input_Save'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/tab1_dropdown_InlineForm/input_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Verify Document got Saved in Recent Document'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab1_Interactive/tab1_dropdown_InlineForm/input_String Field (with onfoc'), 'value', BMText, GlobalVariable.G_LongTimeout)