import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords

import common.DocClass
import common.DocType
import common.Fields

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Docuement'
CustomKeywords.'actions.Data.create'(DocClass.CLOSURE_ACTION, DocType.CLOSURE_ACTION, SMOKE_WMI_DOC341)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Closure Action - Activity A'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Uncheck Show Assigned only checkbox if already checked'
WebUI.uncheck(findTestObject('Page_nGage_Dashboard/My_Work/chexkbox_ShowAssignedOnly'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort records in grid descending by DocID'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Select Checkbox against document in table'
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1)

'Perform Mouser over on Action button'
WebUI.mouseOver(findTestObject('Page_nGage_Dashboard/My_Work/span_Actions Button'))

'Select action "Open All Selected Items"'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/action_OpenAllSelectedItems'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/action_OpenAllSelectedItems'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Customer Information tab'
WebUI.click(findTestObject('Page_WMI/Closure Action/tab_CustomerInformation'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Name'), 'value', SMOKE_WMI_DOC341.get(Fields.CUSTOMER_NAME), GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Details'), 'value', SMOKE_WMI_DOC341.get(Fields.CUSTOMER_DETAIL), GlobalVariable.G_LongTimeout)