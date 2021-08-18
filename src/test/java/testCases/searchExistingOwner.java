package testCases;

import com.aventstack.extentreports.ExtentTest;
import helperFunctions.driverSettings;
import helperFunctions.reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.UpdateOwnerPage;
import pageObjects.homePage;
import pageObjects.veterinarians;

@Test
public class searchExistingOwner extends driverSettings  {

    public void searchExistingOwner() {

        reporter reporter = new reporter();
        ExtentTest test= reporter.extent.createTest("Search for an existing owner");
        homePage homePage=new homePage(driverSettings.driver);
        UpdateOwnerPage UpdateOwnerPage=new UpdateOwnerPage(driverSettings.driver);
        homePage.validateSuccessFulLaunch();
        Assert.assertTrue(driverSettings.driver.getTitle().contains("PetClinic"));
        reporter.reporterFunction(test,"PASS","Page Launched successfully","Launch");
        UpdateOwnerPage.searchForExistingOwner("Mitra",false,false);
        reporter.reporterFunction(test,"PASS","Existing owner with pet and visits searched successfully",
                "ExistingOwner");

    }
}
