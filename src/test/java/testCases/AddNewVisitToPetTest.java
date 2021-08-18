package testCases;

import com.aventstack.extentreports.ExtentTest;
import helperFunctions.driverSettings;
import helperFunctions.reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.UpdateOwnerPage;
import pageObjects.homePage;
import pageObjects.petVisit;

@Test
public class AddNewVisitToPetTest extends driverSettings  {

    public void AddNewVisitToPetTest() {

        reporter reporter = new reporter();
        ExtentTest test= reporter.extent.createTest("Add a new visit for a pet");
        homePage homePage=new homePage(driverSettings.driver);
        petVisit petVisit=new petVisit(driverSettings.driver);
        UpdateOwnerPage UpdateOwnerPage=new UpdateOwnerPage(driverSettings.driver);
        homePage.validateSuccessFulLaunch();
        Assert.assertTrue(driverSettings.driver.getTitle().contains("PetClinic"));
        reporter.reporterFunction(test,"PASS","Page Launched successfully","Launch");
        UpdateOwnerPage.searchForExistingOwner("Mitra",true,true);
        reporter.reporterFunction(test,"PASS","Existing owner with pet and visits searched successfully",
                "ExistingOwner");
        petVisit.addVisit("Not well Pet");
        reporter.reporterFunction(test,"PASS","New visit added successfully",
                "new Visit");
    }
}
