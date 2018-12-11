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

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click On Date Required icon to expand'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/icon_expand_DateRequired'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click On DateRequiredSearch to load Frame'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/a_DateRequiredSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify activity count with grid count'
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/a_DateRequiredSearch'),findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'))

String beforeSearch = WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'))
println beforeSearch

'Expand Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))

'click on search button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_DateReqSearch_Start Dt_required'), GlobalVariable.G_LongTimeout)
println WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_DateReqSearch_Start Dt_required'))
String actualText =  WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_DateReqSearch_Start Dt_required'))

'verify required message is Displaying'
WebUI.verifyMatch(actualText,'Required', false)

String afterSearch = WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'))
println afterSearch

'Verify Grid displaying older search Results'
WebUI.verifyMatch(beforeSearch, afterSearch, true)

