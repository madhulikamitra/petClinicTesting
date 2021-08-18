package testCases;

import com.aventstack.extentreports.ExtentTest;
import helperFunctions.driverSettings;
import helperFunctions.reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.UpdateOwnerPage;
import pageObjects.homePage;

@Test
public class AddNewPetToExistingOwnerTest extends driverSettings  {

    public void AddNewPetToExistingOwnerTest() {

        reporter reporter = new reporter();
        ExtentTest test= reporter.extent.createTest("Add a new pet to an existing owner");
        homePage homePage=new homePage(driverSettings.driver);
        UpdateOwnerPage UpdateOwnerPage=new UpdateOwnerPage(driverSettings.driver);
        homePage.validateSuccessFulLaunch();
        Assert.assertTrue(driverSettings.driver.getTitle().contains("PetClinic"));
        reporter.reporterFunction(test,"PASS","Page Launched successfully","Launch");
        UpdateOwnerPage.searchForExistingOwner("Mitra",true,true);
        reporter.reporterFunction(test,"PASS","Existing owner with pet and visits searched successfully",
                "ExistingOwner");
        UpdateOwnerPage.addNewPet("Madhulika","chonky Boy","2018-09-09","cat");
        reporter.reporterFunction(test,"PASS"," New Pet added successfully","UpdateOwner");

    }
}
