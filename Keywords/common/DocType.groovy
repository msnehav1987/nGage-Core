package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public enum DocType {
	CLOSURE_ACTION("Closure Action"),
	COMPLAINT_TEMPLATE("Complaint Template"),
	WMI_MENU_BOV("WMI Menu BOV"),
	WMI_MENU_BOV_VERTICAL("WMI Menu BOV Vertical"),
	WMI_MENU_DEFAULT("WMI Menu Default"),
	WMI_MENU_DOCTWOROW("WMI Menu DocTwoRow"),
	SM_WEBSERVICE_FILE_1("Storage Server0001 File Object"),	//Encryption ON
	SM_WEBSERVICE_DB_1("Storage Server 0001"),				//Encryption ON
	SM_WEBSERVICE_FILE_2("StorageServer 0002"),				//Encryption OFF
	SM_WEBSERVICE_DB_2("Storage Server 0002")				//Encryption OFF

	
	private final String text

	DocType(String text) {
		this.text = text
	}

	@Override
	public String toString() {
		return text
	}
}