package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

    WebDriver driver;
    @FindBy(className="img-responsive")
    WebElement welcomeImage;;

    public homePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateSuccessFulLaunch(){

    WebDriverWait wait=new WebDriverWait(driver,15);
    wait.until(ExpectedConditions.visibilityOf(welcomeImage));
    }

}
