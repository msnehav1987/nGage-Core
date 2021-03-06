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
import static utils.DateUtil.*
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document if not present'
if(!FLAG_P1_REPO_DOC247) {
	CustomKeywords.'actions.Data.create'(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC247)
	FLAG_P1_REPO_DOC247 = true
}

String BM_Date = P1_REPO_DOC247.get(Fields.DATE)					//Level 1
String DateRange = P1_REPO_DOC247.get(Fields.DATE_RANGE) 			//Level 2
String BM_DateTime = P1_REPO_DOC247.get(Fields.DATE_TIME)			//Level 3
String DateTimeRange = P1_REPO_DOC247.get(Fields.DATE_TIME_RANGE)	//Level 4

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select repository and search for value in drop down'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'('Date n Date time EDM', 'Date n Date time search class')

'Enter End Date values'
String filterEndDate = P1_REPO_DOC247_FILTER_TO
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_DateRange_To'), filterEndDate)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify atleast 1 record is present in result'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'))
WebUI.verifyGreaterThan(rowCount, 0)

'Click on Save search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSaveSearchAdv'))

'Enter Saved search name'
String filterName = 'SEARCH_'+getCurrentDateTime()
WebUI.setText(findTestObject('Page_nGage_Dashboard/Repository/input_txtSaveDesc'), filterName)

'Click on Save button to save search criteia'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSave'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Sort Saved search table with Modified Date value - Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SavedSearch'), 'Modified Date')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SavedSearch'), 'Modified Date')

'Validate Search criteria is displayed in the saved search grid'
int colNo_filterName = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SavedSearch'), 'Search Description')
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Page_nGage_Dashboard/Repository/table_SavedSearch'), colNo_filterName, filterName)

'Select filter from table'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/column_Saved Search table first row Search Desc'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on Delete button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnDelete'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on OK button on confirmation dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/span_Delete Dialog Ok Button'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Sort Saved search table with Modified Date value - Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SavedSearch'), 'Modified Date')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SavedSearch'), 'Modified Date')

'Verify filter is no longer displayed in saved search grid'
CustomKeywords.'actions.Table.verifyRecordNotPresentInColumn'(findTestObject('Page_nGage_Dashboard/Repository/table_SavedSearch'), 2, filterName)