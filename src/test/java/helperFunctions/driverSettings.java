package helperFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class driverSettings {

    public static WebDriver driver;
    @BeforeMethod
   public WebDriver getDriver(){
        driver= startDriver(driver);
       return driver;
   }

    public WebDriver startDriver(WebDriver driver) {

        try {
            String path = new File(".").getCanonicalPath();
            System.setProperty("webdriver.chrome.driver", path + "//src//test//resources//drivers//chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito");
            driver = new ChromeDriver(options);
            driver.get("http://localhost:8080/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    @AfterTest
    public void stopDriver(){
driver.quit();
reporter.extent.flush();

    }
}
