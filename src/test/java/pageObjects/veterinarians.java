package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class veterinarians {

    WebDriver driver;
    @FindBy(xpath=".//span[text()='Veterinarians']")
    WebElement Veterinarians;;


    @FindBy(xpath=".//table[@id='vets']")
    WebElement VeterinariansTable;;


    public veterinarians(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait;

    public void listVeterinarians(){
        Veterinarians.click();
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(VeterinariansTable));
    }


}
