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
import static utils.DateUtil.*
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

//Pre-requisite : Add new document of Doc Class : Date n time
String BM_Date = getCurrentDateTimeMinusDays(0, FORMAT_DATE) //Level1
String DateRange = getCurrentDateTimeMinusDays(1, FORMAT_DATE) // Level2
String BM_DateTime = getCurrentDateTimeMinusDays(2, FORMAT_DATETIME) //Level 3
String DateTimeRange = getCurrentDateTimeMinusDays(3, FORMAT_DATETIME) //Level 4

'Create new Document'
CustomKeywords.'actions.Common.createDocument_DateTimeDT'(BM_Date, DateRange, BM_DateTime, DateTimeRange)

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

String tree_BM_Date = BM_Date
String tree_DateRange = DateRange
String tree_BM_DateTime = convert(BM_DateTime, FORMAT_DATETIME, FORMAT_DATE) 
String tree_DateTimeRange = convert(DateTimeRange, FORMAT_DATETIME, FORMAT_DATE)

'Verify correct tree path is loaded at each level'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', tree_BM_Date, 'Date n Date time EDM','Date n Date time search class')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', tree_DateRange, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', tree_BM_DateTime, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange)
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', tree_DateTimeRange, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)

'Click on Last Tree node'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int recordCountInActivity = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), recordCountInActivity)