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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Docuement'
if(!FLAG_SMOKE_WMI_DOC341) {
	CustomKeywords.'actions.Data.create'(DocClass.CLOSURE_ACTION, DocType.CLOSURE_ACTION, SMOKE_WMI_DOC341)
	FLAG_SMOKE_WMI_DOC341 = true
}
if(!FLAG_SMOKE_WMI_DOC342) {
	CustomKeywords.'actions.Data.create'(DocClass.CLOSURE_ACTION, DocType.CLOSURE_ACTION, SMOKE_WMI_DOC342)
	FLAG_SMOKE_WMI_DOC342 = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Closure Action - Activity A'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Perform right click operation on Activity A'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')

'Verify Foldering configuration option is present in context menu'
CustomKeywords.'actions.ContextMenu.verifyAllOptions'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Refresh', 'Foldering Configuration')

'Click on Foldering configuration option'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')

'Click on Restore defaults button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))

'Verify default options selected in configuration dialog'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'), 'Customer Name', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'None', false, GlobalVariable.G_LongTimeout)

WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level2_FieldAssigned'), 'Select a Field', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level2_Sorting'), 'None', false, GlobalVariable.G_LongTimeout)

WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level3_FieldAssigned'), 'Select a Field', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level3_Sorting'), 'None', false, GlobalVariable.G_LongTimeout)

'Perform lvl1 foldering by Customer Name - Desending by field'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'), 'Customer Name', false)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Desc by Field', false)

'Click on Save button on dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'Click on Close button on dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

List<String> subMenus = CustomKeywords.'actions.MenuBar.getAllSubMenus'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.MenuBar.verifyAllSubmenuAreSortedByActivityName'(subMenus, 'Desc')

'Perform right click operation on Activity A'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')

'Click on Foldering configuration option'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')

'Click on Restore defaults button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))

'Verify default options selected in configuration dialog'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'), 'Customer Name', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'None', false, GlobalVariable.G_LongTimeout)

WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level2_FieldAssigned'), 'Select a Field', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level2_Sorting'), 'None', false, GlobalVariable.G_LongTimeout)

WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level3_FieldAssigned'), 'Select a Field', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level3_Sorting'), 'None', false, GlobalVariable.G_LongTimeout)
