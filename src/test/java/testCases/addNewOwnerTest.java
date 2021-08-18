package testCases;

import com.aventstack.extentreports.ExtentTest;
import helperFunctions.driverSettings;
import helperFunctions.reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.addOwnerPage;
import pageObjects.homePage;

@Test
public class addNewOwnerTest extends driverSettings {

    ExtentTest test;
    public void addNewOwnerTest() {


            reporter reporter = new reporter();
            test = reporter.extent.createTest("Add a new owner");
            homePage homePage = new homePage(driverSettings.driver);
            addOwnerPage addOwnerPage = new addOwnerPage(driverSettings.driver);
            homePage.validateSuccessFulLaunch();
            Assert.assertTrue(driverSettings.driver.getTitle().contains("PetClinic"));
            reporter.reporterFunction(test, "PASS", "Page Launched successfully", "Launch");
            addOwnerPage.validateAddOwner();
            reporter.reporterFunction(test, "PASS", "Add owner page Launched successfully", "Owner");
            addOwnerPage.validateEmptyOwner();
            reporter.reporterFunction(test, "PASS", "Empty owner submission validated successfully", "EmptyOwner");
            addOwnerPage.AddOwner("Madhulika", "Mitra", "Dubai", "Deira", "9889977887");
            reporter.reporterFunction(test, "PASS", "Owner Added successfully", "ValidOwner");

    }
}
