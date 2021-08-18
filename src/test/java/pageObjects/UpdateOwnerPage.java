package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class UpdateOwnerPage {

    WebDriver driver;
    @FindBy(xpath=".//span[text()='Find owners']")
    WebElement findOwnerLink;;

    @FindBy(xpath=".//*[@type='submit']")
    WebElement findOwner;;

    @FindBy(xpath=".//*[text()='Owner Information']//following::table[1]")
    WebElement ownersTable;;

    @FindBy(id="owners")
    WebElement ownersMainTable;;
    @FindBy(xpath=".//*[text()='Owner Information']//following::table[2]")
    WebElement petTable;;

    @FindBy(xpath=".//*[text()='Owner Information']//following::table[3]")
    WebElement visitTable;;
    @FindBy(linkText = "Add Owner")
    WebElement addOwnerButton;;

    @FindBy(linkText = "Edit Owner")
    WebElement editOwnerButton;;

  @FindBy(xpath = ".//*[text()='Update Owner']")

    WebElement updateOwnerButton;;
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


    @FindBy(className="help-inline")
WebElement helperText;

    @FindBy(xpath = ".//*[text()='Owner Information']")
    WebElement ownerInfo;

    @FindBy(xpath =".//*[text()='Name']//following::tr[1]//td//a")
    WebElement firstRow;

    @FindBy(xpath =" (.//*[text()='Name']//following::td)[1]")
    WebElement nameValue;

    @FindBy(linkText = "Add New Pet")
    WebElement addNewPet;

    @FindBy(xpath = ".//*[text()='Visit Date']//following::td[1]")
    WebElement validateDate;
    @FindBy(id="name")
    WebElement petName;

    @FindBy(name="birthDate")
    WebElement petBirthDay;

    @FindBy(xpath = ".//*[contains(text(),'New')]")
    WebElement NewPetHeader;

    @FindBy(xpath = ".//*[text()='Add Pet']")
    WebElement addPetButton;

    @FindBy(xpath = ".//*[text()='Pets and Visits']")
    WebElement petsAndVisits;

    @FindBy(className = "table table-striped")
    WebElement tablesOnPage;

@FindBy(xpath = ".//*[text()='Owner Information']//following::td[1]")
WebElement ownerName;

@FindBy(xpath = ".//*[text()='Owner']//following::span[1]")
WebElement onwerNameOnAdditionPage;

@FindBy(xpath = "(.//*[text()='Type']//following::dd)[1]")
WebElement typeOfPet;

    public UpdateOwnerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait;

    public void validateAddOwner(){
        findOwnerLink.click();
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(lastName));
    }

    public void searchForExistingOwner(String name,boolean hasPet,boolean hasVisit){
        validateAddOwner();
        lastName.sendKeys(name);
        findOwner.click();
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(ownersMainTable));
        Assert.assertTrue(nameValue.getText().contains(name));
        firstRow.click();
        wait.until(ExpectedConditions.visibilityOf(editOwnerButton));
        ownersTable.isDisplayed();
        if(hasPet){
            typeOfPet.isDisplayed();
           petTable.isDisplayed();
        }
        if(hasVisit){
            visitTable.isDisplayed();
            validateDate.isDisplayed();

        }
    }


    public void EditOwner(String firstname,String lastname,String add,String cityName,String phone){

        editOwnerButton.click();
        wait.until(ExpectedConditions.visibilityOf(updateOwnerButton));
       // Random rand = new Random();
        //Integer randomNum = 1 + rand.nextInt((1000) + 1);
        firstName.clear();
        firstName.sendKeys(firstname);
                //+" "+rand);
        lastName.clear();
        lastName.sendKeys(lastname);
        address.clear();
        address.sendKeys(add);
        city.clear();
        city.sendKeys(cityName);
        telephone.clear();
        telephone.sendKeys(phone);
        updateOwnerButton.click();
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(ownerInfo));
        Assert.assertTrue(nameValue.getText().contains(firstname));

    }

    public void addNewPet(String owner,String name,String DOB,String type){

        addNewPet.click();
        wait.until(ExpectedConditions.visibilityOf(NewPetHeader));
        Assert.assertTrue(onwerNameOnAdditionPage.getText().contains(owner));
        //Random rand = new Random();
        //Integer randomNum = 1 + rand.nextInt((1000) + 1);
        petName.sendKeys(name+" ");
                //+randomNum);
        petBirthDay.sendKeys(DOB);
        Select petType=new Select(driver.findElement(By.id("type")));
        petType.selectByValue(type);
        addPetButton.click();
        wait.until(ExpectedConditions.visibilityOf(petsAndVisits));
        Assert.assertTrue(ownerName.getText().contains(owner));

    }
}
