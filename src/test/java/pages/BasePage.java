package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public abstract class BasePage {

    protected   final String BASE_URL = "https://www.saucedemo.com/";

    WebDriver driver;
    SoftAssert softAssert;
    WebDriverWait webDriverWait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        softAssert = new SoftAssert();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public abstract BasePage open();
}