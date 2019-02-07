import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

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
import utils.FileUtil
import utils.ImageUtil

'Login into application'
CustomKeywords.'actions.Common.login'()

'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\TextPDF.pdf'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovVertical'('FILE - MULTIPAGE VIEWER', filePath)

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify Intial page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 1/8.*', true)

'Enter page number in input field'
WebUI.setText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/input_PageNumber'), '8')
WebUI.sendKeys(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/input_PageNumber'), Keys.chord(Keys.ENTER))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 8/8.*', true)

String image1 =  ImageUtil.captureImage()
String actText = CustomKeywords.'actions.OCR.readTextFromImage'(image1)

WebUI.verifyMatch(actText, '.*PAGE 8.*', true)

'Click on next button'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/icon_NextPage'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 8/8.*', true)

String image2 =  ImageUtil.captureImage()
actText = CustomKeywords.'actions.OCR.readTextFromImage'(image2)

WebUI.verifyMatch(actText, '.*PAGE 8.*', true)

FileUtil.delete(image1)
FileUtil.delete(image2)