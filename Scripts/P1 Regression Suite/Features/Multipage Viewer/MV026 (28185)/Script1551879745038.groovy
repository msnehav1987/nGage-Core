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
import internal.GlobalVariable as GlobalVariable

'Login into application'
CustomKeywords.'actions.Common.login'()

'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\TextPDF.pdf'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovVertical'('FILE - MULTIPAGE VIEWER', filePath)

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Open on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

'Verify Thumbnail Grid is open now'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'), 'class', 'ui-layout-toggler ui-layout-toggler-west ui-layout-toggler-open ui-layout-toggler-west-open', GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/table_Thumbnail_Grid'))

'Click on Thumbnail 2'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify page count value in summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 2/8.*', true)

'Click on Thumbnail 3'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_3'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify page count value in summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 3/8.*', true)