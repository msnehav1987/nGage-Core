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

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Business Model View', 'Standard Grid')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on WMI Harness page'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_WMI Harness'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/iframe_ContentPlaceHolder1'))

'Save WMI'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/btn_Save'))

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/iframe_ContentPlaceHolder1'))

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Close Window'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Open document from Recent Grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'), GlobalVariable.G_LongTimeout)

'Click on Related documents (Child) tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Related Documents(Child)'))

'Wait for related child tab to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/tdCell_Related Documents(Child)'), GlobalVariable.G_LongTimeout)

'Verify the bordercolor for Notes grid.(border color set in wmi is #DA70D6=orchid)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/td_Related Documents(Child)'), 'border-top-color', 'rgba(218, 112, 214, 1)')

'Verify the backgroundcolor for Notes grid (backgroundcolor set in wmi is #2E8B57=seagreen)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/table_Related Documents(Child)'), 'background-color', 'rgba(46, 139, 87, 1)')

'Verify the headerbgcolor for Notes grid (headerbgcolor set in wmi is #ADD8E6=lightblue)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/td_Related Documents(Child)'), 'background-color', 'rgba(173, 216, 230, 1)')

//Add 3 new documents from Attachements Meun

//Record - 1
'Perform Mouse over on Attachements Menu'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/menu_Attachments'))
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/subMenu_AttachNewDocument'), GlobalVariable.G_LongTimeout)

'Select option Attach new Document'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/subMenu_AttachNewDocument'))

'Wait for page to load'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocClass'), GlobalVariable.G_LongTimeout)

'Select Doc Class and Doc Type'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocClass'), 'Business Model View', false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocType'), 'Standard Grid', false)

'Wait for WMI Fields to load'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/textbox_BMString'), GlobalVariable.G_LongTimeout)

'Wait for page load'
//WebUI.delay(3)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/iframe_ContentPlaceHolder'))
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/btn_AttachDocument_AfterLoad'), GlobalVariable.G_LongTimeout)

'Click on Attach Document'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/btn_AttachDocument_AfterLoad'))

'Verify success message on pop up dialog'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Message'), GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Dialog_Message')), '.*Document was attached successfully.*', true)

'Click OK button on Success dialog'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Ok'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Record - 2
'Perform Mouse over on Attachements Menu'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/menu_Attachments'))
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/subMenu_AttachNewDocument'), GlobalVariable.G_LongTimeout)

'Select option Attach new Document'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/subMenu_AttachNewDocument'))

'Wait for page to load'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocClass'), GlobalVariable.G_LongTimeout)

'Select Doc Class and Doc Type'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocClass'), 'Business Model View', false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocType'), 'Standard Grid', false)

'Wait for WMI Fields to load'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/textbox_BMString'), GlobalVariable.G_LongTimeout)

'Wait for page load'
//WebUI.delay(3)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/iframe_ContentPlaceHolder'))
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/btn_AttachDocument_AfterLoad'), GlobalVariable.G_LongTimeout)

'Click on Attach Document'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/btn_AttachDocument_AfterLoad'))

'Verify success message on pop up dialog'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Message'), GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Dialog_Message')), '.*Document was attached successfully.*', true)

'Click OK button on Success dialog'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Ok'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Record - 3
'Perform Mouse over on Attachements Menu'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/menu_Attachments'))
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/subMenu_AttachNewDocument'), GlobalVariable.G_LongTimeout)

'Select option Attach new Document'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/subMenu_AttachNewDocument'))

'Wait for page to load'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocClass'), GlobalVariable.G_LongTimeout)

'Select Doc Class and Doc Type'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocClass'), 'Business Model View', false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocType'), 'Standard Grid', false)

'Wait for WMI Fields to load'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/textbox_BMString'), GlobalVariable.G_LongTimeout)

'Wait for page load'
//WebUI.delay(3)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/iframe_ContentPlaceHolder'))
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/btn_AttachDocument_AfterLoad'), GlobalVariable.G_LongTimeout)

'Click on Attach Document'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/btn_AttachDocument_AfterLoad'))

'Verify success message on pop up dialog'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Message'), GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Dialog_Message')), '.*Document was attached successfully.*', true)

'Click OK button on Success dialog'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Ok'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Verify that maximum 2 Related documents entries are displayed in the grid.'
'Click on WMI Harness page'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_WMI Harness'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))

'Click on Related documents (Child) tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Related Documents(Child)'))

'Wait for related child tab to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/tdCell_Related Documents(Child)'), GlobalVariable.G_LongTimeout)

'Get Actual rows count in result grid'
int actRowsCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/table_ActualRow'))

int expectedRows = 2
'Verify table has 2 rows on every page and 2 pages are appearing for 2+ records'
WebUI.verifyEqual(actRowsCount, expectedRows)

'Get Total Page count in result grid'
String pageCount = WebUI.getText(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/page_Count'))

'Verify total page count is 2'
WebUI.verifyEqual(pageCount.split('of ')[1], expectedRows)