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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

x = WebUI.callTestCase(findTestCase('PIM/FindEmployee'), [('employeeName') : (employeeFirstName + ' ') + employeeLastName
        , ('matchExact') : true], FailureHandling.STOP_ON_FAILURE)

if (x == 0) {
    WebUI.callTestCase(findTestCase('Common/GoToUrl'), [('url') : 'http://opensource.demo.orangehrmlive.com/index.php/pim/addEmployee'], 
        FailureHandling.STOP_ON_FAILURE)

    WebUI.setText(findTestObject('PIM/AddEmployee/input_firstName'), employeeFirstName)

    WebUI.setText(findTestObject('PIM/AddEmployee/input_lastName'), employeeLastName)

    WebUI.click(findTestObject('PIM/AddEmployee/input_btnSave'))

    x = WebUI.callTestCase(findTestCase('PIM/FindEmployee'), [('employeeName') : (employeeFirstName + ' ') + employeeLastName
            , ('matchExact') : true], FailureHandling.STOP_ON_FAILURE)

    assert x == 1
}

