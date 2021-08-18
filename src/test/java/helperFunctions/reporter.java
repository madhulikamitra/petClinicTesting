package helperFunctions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class reporter {
   public  static ExtentReports extent = new ExtentReports();
  public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    public  static void reporterFunction(ExtentTest test, String status, String message, String screenshotName) {

        try {
            extent.attachReporter(spark);
            switch (status) {
                case "PASS":
                    test.pass(message);
                    String screenShotPath = capture(driverSettings.driver, screenshotName);
                    test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
                    break;

                case "WARN":
                    test.warning(message);
                    break;

                case "FAIL":
                    Assert.assertTrue(1 == 0, "There was a test faliure");
                    test.fail(message);
                    break;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }


        public static String capture(WebDriver driver,String screenShotName) throws IOException
        {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = System.getProperty("user.dir") +"/ErrorScreenshots/"+screenShotName+".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);

            return dest;
        }

}
