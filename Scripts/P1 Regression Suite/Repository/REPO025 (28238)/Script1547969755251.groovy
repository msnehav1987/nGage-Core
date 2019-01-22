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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create Document render all fields'
CustomKeywords.'actions.Common.createDocument_RenderAllField'('10', 'CShah', '', '', '', '', '', '', '', '', '')

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Right click on BM Ref ROTABLE Nested without Tab from Business Model Sub Menu'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('REPO', 'Business Model', 'Business Model', 'Render All Field Types', 'Chintan Shah', 'CShah')

'Click New Search button'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'New Search')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_iframe_104'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/NewSearch_WithoutTab/iFrameNewSearch'))

'Panel should be populated in search panel for the specific field.'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Repository/NewSearch_WithoutTab/input_Filter_BM String'), 'value', 'CShah', GlobalVariable.G_LongTimeout)