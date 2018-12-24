package utils

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

public class Consts {

	public static final String SMOKE_HOME001_STRINGFIELD = 'Chintan Shah'
	public static final String SMOKE_HOME001_FILENAME = 'Automation test document'
	public static String SMOKE_HOME001_DOCID

	public static final String SMOKE_HOME003_STRINGFIELD = 'Chintan Shah'
	public static final String SMOKE_HOME003_FILENAME = 'Automation test document'
	public static String SMOKE_HOME003_DOCID

	public static final String SMOKE_HOME007_BMSTRING = 'Automation test document'
	public static String SMOKE_HOME007_DOCID

	public static final String SMOKE_MYWORK003_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK003_CUSTOMERDETAIL = 'Automation test document'
	public static String SMOKE_MYWORK003_DOCID

	public static final String SMOKE_MYWORK009_CUSTOMERNAME1 = 'Chintan Shah'
	public static final String SMOKE_MYWORK009_CUSTOMERDETAIL1 = 'Automation test document'

	public static final String SMOKE_MYWORK009_CUSTOMERNAME2 = 'Atul Mirvankar'
	public static final String SMOKE_MYWORK009_CUSTOMERDETAIL2 = 'Automation test document'

	public static final String SMOKE_MYWORK018_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK018_CUSTOMERDETAIL = 'Automation test document - MYWORK018'
	public static String SMOKE_MYWORK018_DOCID

	public static final String SMOKE_MYWORK021_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK021_CUSTOMERDETAIL = 'Automation test document - MYWORK021'

	public static final String SMOKE_MYWORK022_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK022_CUSTOMERDETAIL = 'Automation test document - MYWORK022'
	public static String SMOKE_MYWORK022_DOCID

	public static final String SMOKE_MYWORK023_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK023_CUSTOMERDETAIL = 'Automation test document - MYWORK023'
	public static String SMOKE_MYWORK023_DOCID

	public static final String SMOKE_REPO001_STRINGFIELD = 'Chintan Shah'
	public static final String SMOKE_REPO001_FILENAME = 'Automation test document'

	public static String SMOKE_REPO006_SAVEDFILTER_RECORDCOUNT
	public static String SMOKE_REPO006_SAVEDFILTERNAME

	public static final String SMOKE_MWS002_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MWS002_CUSTOMERDETAIL = 'Automation test document - MWS002'
	public static String SMOKE_MWS002_DOCID

	public static final String SMOKE_MWS004_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MWS004_CUSTOMERDETAIL = 'Automation test document - MWS004'

	public static final String SMOKE_MWS007_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MWS007_CUSTOMERDETAIL = 'Automation test document - MWS007'
	public static String SMOKE_MWS007_DOCID

	public static final String SMOKE_WMI005_FIELD1 = '50'
	public static final String SMOKE_WMI005_FIELD2 = 'WMI005-Automation'
	public static final String SMOKE_WMI005_FIELD3 = 'Value 2'
	public static final String SMOKE_WMI005_FIELD4 = '20'
	public static final String SMOKE_WMI005_FIELD4V = '$20.00'
	public static final String SMOKE_WMI005_FIELD5 = '08-10-2018'
	public static final String SMOKE_WMI005_FIELD6 = '60.129'
	public static final String SMOKE_WMI005_FIELD7 = '25'
	public static final String SMOKE_WMI005_FIELD8 = 'Text Field'
	public static String SMOKE_WMI005_FIELD9
	public static final String SMOKE_WMI005_FIELD10 = 'String Field'
	public static final String SMOKE_WMI005_FIELD11 = 'Last Name'

	public static final String SMOKE_WMI006_FIELD1 = '40'
	public static final String SMOKE_WMI006_FIELD2 = 'WMI006-Automation'
	public static final String SMOKE_WMI006_FIELD3 = 'Value 3'
	public static final String SMOKE_WMI006_FIELD4 = '10'
	public static final String SMOKE_WMI006_FIELD4V = '$10.00'
	public static final String SMOKE_WMI006_FIELD5 = '08-10-2018'
	public static final String SMOKE_WMI006_FIELD6 = '70.854'
	public static final String SMOKE_WMI006_FIELD7 = '60'
	public static final String SMOKE_WMI006_FIELD8 = 'Text Field'
	public static String SMOKE_WMI006_FIELD9
	public static final String SMOKE_WMI006_FIELD10 = 'String Field'
	public static final String SMOKE_WMI006_FIELD11 = 'Middle Name'

	public static final String SMOKE_WMI007_FIELD1 = '90'
	public static final String SMOKE_WMI007_FIELD2 = 'WMI007-Automation'
	public static final String SMOKE_WMI007_FIELD3 = 'Value 1'
	public static final String SMOKE_WMI007_FIELD4 = '30'
	public static final String SMOKE_WMI007_FIELD4V = '$30.00'
	public static final String SMOKE_WMI007_FIELD5 = '08-10-2018'
	public static final String SMOKE_WMI007_FIELD6 = '90.113'
	public static final String SMOKE_WMI007_FIELD7 = '80'
	public static final String SMOKE_WMI007_FIELD8 = 'Text Field'
	public static String SMOKE_WMI007_FIELD9
	public static final String SMOKE_WMI007_FIELD10 = 'String Field'
	public static final String SMOKE_WMI007_FIELD11 = 'First Name'





	public static final String P1_MW084_STARTDATE = '01-01-2018'
	public static final String P1_MW084_ENDDATE = '12-31-2025'
	public static final String P1_MW084_STARTDATETIME = '06-01-2018 01:00:00 AM'
	public static final String P1_MW084_ENDDATETIME = '05-31-2025 11:00:00 PM'
	public static String P1_MW084_BMTEXT

	public static final String P1_MW087_STARTDATE = '01-15-2019'
	public static final String P1_MW087_ENDDATE = '12-15-2024'
	public static final String P1_MW087_STARTDATETIME = '06-15-2019 08:00:00 AM'
	public static final String P1_MW087_ENDDATETIME = '05-15-2024 05:00:00 PM'
	public static String P1_MW087_BMTEXT

	public static final String P1_MW095_STARTDATE = ''
	public static final String P1_MW095_ENDDATE = ''
	public static final String P1_MW095_STARTDATETIME = ''
	public static final String P1_MW095_ENDDATETIME = ''
	public static String P1_MW095_BMTEXT

	public static final String P1_MW097_STARTDATE = ''
	public static final String P1_MW097_ENDDATE = ''
	public static final String P1_MW097_STARTDATETIME = '06-01-2018 01:00:00 AM'
	public static final String P1_MW097_ENDDATETIME = ''
	public static String P1_MW097_BMTEXT

	public static final String P1_MW117_STARTDATE = '01-01-2018'
	public static final String P1_MW117_ENDDATE = ''
	public static final String P1_MW117_STARTDATETIME = ''
	public static final String P1_MW117_ENDDATETIME = ''
	public static String P1_MW117_BMTEXT

	
	public static final String P1_REPO_BMDATE_DOC1 = '01-01-2018'
	public static final String P1_REPO_DATERANGE_DOC1 = '03-01-2018'
	public static final String P1_REPO_BMDATETIME_DOC1 = '06-01-2018 01:00:00 AM'
	public static final String P1_REPO_DATETIMERANGE_DOC1 = '09-01-2018'
	
	public static final String P1_REPO_BMDATE_DOC2 = '01-15-2018'
	public static final String P1_REPO_DATERANGE_DOC2 = '03-15-2018'
	public static final String P1_REPO_BMDATETIME_DOC2 = '06-15-2018 01:00:00 AM'
	public static final String P1_REPO_DATETIMERANGE_DOC2 = '09-15-2018'

	public static final String P1_REPO_BMDATE_DOC3 = ''
	public static final String P1_REPO_DATERANGE_DOC3 = ''
	public static final String P1_REPO_BMDATETIME_DOC3 = ''
	public static final String P1_REPO_DATETIMERANGE_DOC3 = ''

	
	/*
	 * Doc Class and Doc Type Variables
	 */

	public static final String DC_DATEREQUIRED = 'daterequiredsearch'
	public static final String DT_DATEREQUIRED = 'daterequiredsearch'

	public static final String DC_DATERANGEREQUIRED = 'daterangerequired'
	public static final String DT_DATERANGEREQUIRED = 'daterangerequired'

	public static final String DC_DATETIMEREQUIRED = 'Datetimerequired'
	public static final String DT_DATETIMEREQUIRED = 'Datetimerequired'

	public static final String DC_DATETIMERANGEREQUIRED = 'Datetimerangerequired'
	public static final String DT_DATETIMERANGEREQUIRED = 'Datetimerangerequired'
	
	

}
