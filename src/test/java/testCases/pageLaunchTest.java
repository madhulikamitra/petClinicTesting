package testCases;

import com.aventstack.extentreports.ExtentTest;
import helperFunctions.driverSettings;
import helperFunctions.reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.homePage;


@Test
public class pageLaunchTest extends driverSettings {

    public void pageLaunchTest(){

        reporter reporter = new reporter();
       ExtentTest test= reporter.extent.createTest("Page Launch with doggy image test");
        homePage homePage=new homePage(driverSettings.driver);
        homePage.validateSuccessFulLaunch();
        Assert.assertTrue(driverSettings.driver.getTitle().contains("PetClinic"));
        reporter.reporterFunction(test,"PASS","Page Launched successfully","Launch");
    }
}
