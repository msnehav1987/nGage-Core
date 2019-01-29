import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass
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

'Create document if single result view is not loaded'
CustomKeywords.'actions.Common.createDocument_ForSingleResultView'()

'Create Document to be used as a refernce document.'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Radio List Event')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Select radio button Value 4 in master object'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value4_MasterObject'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Select radio button value 4 in reference object'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_Value4_ReferenceObject'), GlobalVariable.G_LongTimeout)
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_Value4_ReferenceObject'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'save WMI'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'click on tab inline view'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/span_InlineView'))

'Verify grid has atleast 2 records'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/table_InlineResultView'))
WebUI.verifyGreaterThanOrEqual(rowCount, 2)

'Sort DocID'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click On Second Row From Reference Grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/table_InlineResultView'), 2, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify document should be opened in Inline view'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/span_Radio List Event -Header'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/td_InformationInlineView'))

'Click on Value 1 radio button from Refrence object'
WebUI.scrollToElement(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Value1'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Value1'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify date field should be disaply as required filed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/span_SaveErrorMessageLine_ForRequired'),GlobalVariable.G_LongTimeout)

'Enter date in field'
String currDate = DateUtil.getCurrentDateTime(Consts.FORMAT_DATETIME)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Date Field (Required)_ef'), currDate)

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Integer Field (Visible)_'))

//'Get Background color of String Field'
//String background_Color = CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'),'background-color' )

'Verify String filed should be with back ground color Red'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'),'background-color', 'rgba(255, 0, 0, 1)')

'Get Font of String Field'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'), GlobalVariable.G_LongTimeout )
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_StringField'), 'Sanyogita')

'Verify font-weight is Bold'
String actualfont= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'),'font-weight')

'Click on Save from Reference Object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Sort Saved document from Grid'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Open Second Row from Reference Grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/table_InlineResultView'), 2, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify Document should got opened with latest changes in the Grid'
WebUI.scrollToElement(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Value1'), GlobalVariable.G_LongTimeout)
String actualDate=WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Date Field (Required)_ef'),'value')
WebUI.verifyMatch(actualDate,currDate, false)

'Verify font-weight is Bold'
String Font_AfterSave =CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'),'font-weight')

'Verify String filed should be with Font Normal'
WebUI.verifyMatch(actualfont,Font_AfterSave,false)