package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BasePage {

    private final By CARTBADGE = By.cssSelector(".shopping_cart_badge");
    private final By CARTLINK = By.cssSelector(".shopping_cart_link");
    protected   final String BASE_URL = "https://www.saucedemo.com/";

    WebDriver driver;
    SoftAssert softAssert;

    public BasePage (WebDriver driver) {
        this.driver = driver;
    }

    public BasePage (WebDriver driver,SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
    }

    public String getCartBadge(){
        String Badge = driver.findElement(CARTBADGE).getText();
        return Badge;
    }

    public void openCart(){
        driver.findElement(CARTLINK).click();
    }
}