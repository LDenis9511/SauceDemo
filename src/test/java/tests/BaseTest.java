package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.time.Duration;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
//@Listeners (TestListener.class)
public class BaseTest {

    static WebDriver driver;
    static SoftAssert softAssert;
    LoginPage loginPage;
    ProductsPage productsPage;
    BasePage basePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
    if(browser.equalsIgnoreCase("chrome")){
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
    }
    else if (browser.equalsIgnoreCase("edge")){
        driver = new EdgeDriver();
    }

        softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver,softAssert);
        basePage = new BasePage(driver);
        cartPage = new CartPage(driver,softAssert);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        softAssert.assertAll();
    }
}