import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
String isPresent = CustomKeywords.'actions.Common.isRecordPresentInRecentGridTable'(1, 'Doc Type', DocType.WMI_MENU_BOV_VERTICAL.toString())

if(!(FLAG_P1_WMI_DOC061 && isPresent)){
	CustomKeywords.'actions.Data.create'(DocClass.WMI_MENU, DocType.WMI_MENU_BOV_VERTICAL, P1_WMI_DOC061)
	FLAG_P1_WMI_DOC061 = true
	WebUI.refresh()
}

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Click on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

'Verify Thumbnail Grid is open now'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'), 'class', 'ui-layout-toggler ui-layout-toggler-west ui-layout-toggler-open ui-layout-toggler-west-open', GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/table_Thumbnail_Grid'))

'Click on Page menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Page'))

'Click on Select All option'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Page_Select All'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Page_Select All'))
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Verify All thumbnails are selected'
CustomKeywords.'actions.Table.verifyAttributeValueOfAllRows'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/table_Thumbnail_Grid'), 'aria-selected', 'true')