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
import common.Fields
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create document is not present'
if(!FLAG_P1_REPO_DOC221) {
	CustomKeywords.'actions.Data.create'(DocClass.MASTER_OBJECT_FEATURE, DocType.RENDER_ALL_FIELD_TYPES, P1_REPO_DOC221)
	FLAG_P1_REPO_DOC221 = true
}

String stringFieldOnFocus = P1_REPO_DOC221.get(Fields.STRING_FIELD_ON_FOCUS)

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Right click on BM Ref ROTABLE Nested without Tab from Business Model Sub Menu'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('REPO', 'Business Model', 'Business Model', 'Render All Field Types', 'Chintan Shah', stringFieldOnFocus)

'Click New Document button'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'New Document')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select  Doc Class and Doc Type'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Master Object Feature', 'Render All Field Types')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify value of the field selected in left panel should appear populated in specific field in wmi.'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/stringFieldTextBox'), 'value', stringFieldOnFocus, GlobalVariable.G_LongTimeout)