import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.annotation.Documented

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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
CustomKeywords.'actions.Data.create'(DocClass.WMI_MENU, DocType.WMI_MENU_BOV_VERTICAL, P1_WMI_DOC061)
FLAG_P1_WMI_DOC061 = true
	
'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')

'Verify all menus are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Annotations'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Export'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Image Processing'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Mouse Tool'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Page'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Rotate'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Zoom'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount'))

'Verify correct pagination is displayed for content section'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 1/8.*', true)