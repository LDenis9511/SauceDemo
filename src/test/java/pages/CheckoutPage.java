package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private final By FIRSTNAME = By.cssSelector("#first-name");
    private final By LASTNAME = By.cssSelector("#last-name");
    private final By ZIP = By.cssSelector("#postal-code");
    private final By COUNTINUE = By.cssSelector("#continue");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");
    private final By FINISH = By.cssSelector("#finish");
    private final By TITLE = By.cssSelector(".title");
    private final By COMPLITE_HEADER = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL+"checkout-step-one.html");
    }

    public void addInformation(String firstName,String lastName,String zip){
        driver.findElement(FIRSTNAME).sendKeys(firstName);
        driver.findElement(LASTNAME).sendKeys(lastName);
        driver.findElement(ZIP).sendKeys(zip);
        driver.findElement(COUNTINUE).click();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void clickFinish(){
    driver.findElement(FINISH).click();
    }

    public String getTitleName(){
        return driver.findElement(TITLE).getText();
    }

    public String getCompleteHeader(){
        return driver.findElement(COMPLITE_HEADER).getText();
    }
}