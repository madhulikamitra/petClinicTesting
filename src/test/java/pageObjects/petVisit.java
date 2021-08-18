package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class petVisit {


    WebDriver driver;
    @FindBy(linkText="Add Visit")
    WebElement addVisit;;

    @FindBy(xpath=".//*[contains(text(),'New')]")
    WebElement newVisit;;

    @FindBy(name = "date")
    WebElement date;

    @FindBy(name="description")
    WebElement desc;

    @FindBy(xpath=".//*[text()='Add Visit']")
    WebElement AddVisit;

    @FindBy(xpath = ".//*[text()='Description']//following::td[2]")
    WebElement validateDesc;

    @FindBy(xpath = ".//*[text()='Visit Date']//following::td[1]")
    WebElement validateDate;

    public petVisit(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriverWait wait;
    public void validateAddVisit(){
        addVisit.click();
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(newVisit));
    }

    public void addVisit(String description){
        validateAddVisit();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
       Assert.assertTrue(date.getAttribute("value").equals(timeStamp));
      desc.sendKeys(description);
        AddVisit.click();
        wait.until(ExpectedConditions.visibilityOf(validateDate));
       Assert.assertTrue(validateDate.getText().equals(timeStamp));
        Assert.assertTrue(validateDesc.getText().equals(description));


    }


}
