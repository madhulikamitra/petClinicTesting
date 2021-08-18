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
public class getveterinariansList extends driverSettings  {

    public void getveterinariansList() {

        reporter reporter = new reporter();
        ExtentTest test = reporter.extent.createTest("Get the veterinarians list");
        homePage homePage = new homePage(driverSettings.driver);
        veterinarians veterinarians = new veterinarians(driverSettings.driver);
        homePage.validateSuccessFulLaunch();
        Assert.assertTrue(driverSettings.driver.getTitle().contains("PetClinic"));
        reporter.reporterFunction(test, "PASS", "Page Launched successfully", "Launch");
        veterinarians.listVeterinarians();
        reporter.reporterFunction(test, "PASS", "veterinarians listed successfully",
                "veterinarians");
    }
}
