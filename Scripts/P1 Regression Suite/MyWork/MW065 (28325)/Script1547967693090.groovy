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

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'(GlobalVariable.Users['MW065_UN'], GlobalVariable.Password, GlobalVariable.Database)

'Create Closure Action Document'
CustomKeywords.'actions.Data.create'(DocClass.CLOSURE_ACTION, DocType.CLOSURE_ACTION, P1_WMI_DOC341)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Navigate to newly created menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes','Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify the closure actions should be visible in Action menu'
WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_Actions Button'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/action_AssignWorkItems'), GlobalVariable.G_LongTimeout)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/action_UpdateField'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/action_RouteToActivityC'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/action_RouteToActivityD'), GlobalVariable.G_LongTimeout)

WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_Actions Button'))

'Sort records by DocID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Open work item'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'),1,8)

'switch to new window'
WebUI.switchToWindowIndex(1)

'Click on Customer Information'
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/span_Customer Information'))
//WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

'Verify Closure Action is Present'
WebUI.verifyElementPresent( findTestObject('Page_WMI/Closure Action/button_CustomerActions'), GlobalVariable.G_LongTimeout)

'Verify field Customer Name Present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Closure_Action/input_Customer Name'), GlobalVariable.G_LongTimeout)