package testCases;

import com.aventstack.extentreports.ExtentTest;
import helperFunctions.driverSettings;
import helperFunctions.reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.UpdateOwnerPage;
import pageObjects.addOwnerPage;
import pageObjects.homePage;

@Test
public class UpdateOwnerTest extends driverSettings  {

    public void UpdateOwnerTest() {

        reporter reporter = new reporter();
        ExtentTest test= reporter.extent.createTest("Update an owner");
        homePage homePage=new homePage(driverSettings.driver);
        UpdateOwnerPage UpdateOwnerPage=new UpdateOwnerPage(driverSettings.driver);
        homePage.validateSuccessFulLaunch();
        Assert.assertTrue(driverSettings.driver.getTitle().contains("PetClinic"));
        reporter.reporterFunction(test,"PASS","Page Launched successfully","Launch");
        UpdateOwnerPage.searchForExistingOwner("Mitra",true,true);
        reporter.reporterFunction(test,"PASS","Existing owner with pet and visits searched successfully",
                "ExistingOwner");
        UpdateOwnerPage.EditOwner("Madhulika-Updated","Mitra","Dubai","Deira","9889977887");
        reporter.reporterFunction(test,"PASS"," owner update submitted successfully","UpdateOwner");

    }
}
