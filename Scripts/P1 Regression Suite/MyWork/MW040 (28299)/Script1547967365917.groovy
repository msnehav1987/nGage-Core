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
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Route Advance Document'
String description = 'Test - '+DateUtil.getCurrentDateTime('MM-dd-yyyy HH:mm:ss a')
CustomKeywords.'actions.Common.createDocument_RouteAdvance'(description)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//'Expand Route Advance'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Route Advance/icon_expand_RouteAdvance'))
//WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
//
//'Click on Entry Interactive User Activity'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Route Advance/a_EntryInteractiveUserActivity'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click on Activity'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Route Advance', 'Entry Interactive User Activity')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify activity count with grid count'
int recordCountInAtivity = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'Route Advance', 'Entry Interactive User Activity')
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'), recordCountInAtivity)

'Expand Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Enter filter criteria in all required field'
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Route Advance/select_DocID-Operater'), '>', false)
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Route Advance/input_DocID_RouteAdvance'), '1')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Route Advance/input_DocTypeName'),'Route from Entry Interactive User')

'Click Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by DocID Desc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))

int DocID_ColumnPosition = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
int DocTypeName_ColumnPosition = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc Type Name')
int Description_ColumnPosition = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Description')

'Verify Search Results for DocID with Operater >'
CustomKeywords.'actions.Table.verifyFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), DocID_ColumnPosition, 1,'>')

'Verify Search Results for Doc Type Name '
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), DocTypeName_ColumnPosition, 'Route from Entry Interactive User')

'Verify description value matches'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, Description_ColumnPosition, description)