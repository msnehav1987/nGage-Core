import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Docuement'
CustomKeywords.'actions.Common.createDocument_ClosureAction'(SMOKE_MYWORK009_CUSTOMERNAME1, SMOKE_MYWORK009_CUSTOMERDETAIL1)

'Create Docuement'
CustomKeywords.'actions.Common.createDocument_ClosureAction'(SMOKE_MYWORK009_CUSTOMERNAME2, SMOKE_MYWORK009_CUSTOMERDETAIL2)

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
