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

'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovVertical'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')

'Open Thumbnail grid'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))
WebUI.delay(2)

'Clear clipboard'
CustomKeywords.'actions.Common.clearClipBoard'()

//Select 3 Thumbnails
List<TestObject> elements = new ArrayList<TestObject>()
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_4'))
'Click on Multiple Thumbnails Thumbnail 1(Default selected), Thumbnail 2 and Thumbnail 4'
CustomKeywords.'actions.Common.clickMultipleElements'(elements)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Add all 3 thumbnails to clipbpard
'Click on clipboard menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))
'Click on Add to clipboard'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_Add to Clipboard'))

//Open Clipboard document
'Click on clipboard menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))
'Click on View clipboard'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_View Clipboard'))

'Switch to Clipboard window'
WebUI.switchToWindowTitle('Clipboard')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Select Multiple Thumbnails
List<TestObject> clipboardThumbnails = new ArrayList<TestObject>()
clipboardThumbnails.add(findTestObject('Page_WMI/Clipboard/Thumbnail 2'))

'Click on Multiple Thumbnails Thumbnail 1(Default selected), Thumbnail 2'
CustomKeywords.'actions.Common.clickMultipleElements'(clipboardThumbnails)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Page Menu'
WebUI.click(findTestObject('Page_WMI/Clipboard/menu_Page'))

'Click on Delete option'
WebUI.click(findTestObject('Page_WMI/Clipboard/subMenu_Page_Delete'))

'Verify window.alert message'
WebUI.verifyAlertPresent(GlobalVariable.G_LongTimeout)
String alertText = WebUI.getAlertText().trim()
WebUI.verifyEqual(alertText, 'Are you sure you want to mark page(s) as Remove?')

'Click OK button on alert dialog'
WebUI.acceptAlert()
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Page summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/Clipboard/pagination_summary')).trim(), '.*Page 1/1.*', true)

'Click on Clipboard Menu'
WebUI.click(findTestObject('Page_WMI/Clipboard/menu_Clipboard'))

'Click on Save back to clipboard'
WebUI.click(findTestObject('Page_WMI/Clipboard/subMenu_Clipboard_Save back to Clipboard'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Close Clipboard window'
WebUI.closeWindowTitle('Clipboard')

'Switch to WMI Document'
WebUI.switchToWindowTitle('WMI Menu BOV Vertical')

//Open Clipboard document
'Click on clipboard menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))
'Click on View clipboard'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_View Clipboard'))

'Switch to WMI Document'
WebUI.switchToWindowTitle('Clipboard')

'Verify Page summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/Clipboard/pagination_summary')).trim(), '.*Page 1/1.*', true)