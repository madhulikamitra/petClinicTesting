package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class addOwnerPage {

    WebDriver driver;
    @FindBy(xpath=".//span[text()='Find owners']")
    WebElement findOwnerLink;;

    @FindBy(xpath=".//*[text()='Add Owner']")
    WebElement addOwnerButton;;

    @FindBy(id="firstName")
    WebElement firstName;

    @FindBy(id="lastName")
    WebElement lastName;

    @FindBy(id="address")
    WebElement address;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="telephone")
    WebElement telephone;

    @FindBy(xpath =" (.//*[text()='Name']//following::td)[1]")
    WebElement nameValue;

    @FindBy(className="help-inline")
WebElement helperText;

    @FindBy(xpath = ".//*[text()='Owner Information']")
    WebElement ownerInfo;

    public addOwnerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait;
    public void validateAddOwner(){
        findOwnerLink.click();
        addOwnerButton.click();
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(firstName));
    }

    public void validateEmptyOwner(){

        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(addOwnerButton));
        addOwnerButton.click();
        helperText.isDisplayed();
    }


    public void AddOwner(String firstname,String lastname,String add,String cityName,String phone){

     //   Random rand = new Random();
       // Integer randomNum = 1 + rand.nextInt((1000) + 1);
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        address.sendKeys(add);
        city.sendKeys(cityName);
        telephone.sendKeys(phone);
        addOwnerButton.click();
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(ownerInfo));
        Assert.assertTrue(nameValue.getText().contains(firstname));
    }
}
