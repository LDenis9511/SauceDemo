package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.*;
import steps.LoginStep;
import steps.OrderStep;
import steps.ProductStep;

import java.time.Duration;
import java.util.HashMap;

import static tests.AllureUtils.takeScreenshot;

public class BaseTest {

    static WebDriver driver;
    static SoftAssert softAssert;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    MainPage mainPage;
    LoginStep loginStep;
    OrderStep orderStep;
    ProductStep productStep;

    String user1 = System.getProperty("user",PropertyReader.getProperty("user"));
    String password1 = System.getProperty("password",PropertyReader.getProperty("password"));

    @Parameters({"browser"})
    @BeforeMethod (description = "Настройка драйвера")
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
        if (System.getProperty("user")!=null)
        {
        options.addArguments("--headless");
        }
        driver = new ChromeDriver(options);
    }
    else if (browser.equalsIgnoreCase("edge")){
        EdgeOptions options1 = new EdgeOptions();
        options1.addArguments("--headless");
        driver = new EdgeDriver(options1);
    }
        softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        mainPage = new MainPage(driver);
        loginStep = new LoginStep(driver);
        orderStep = new OrderStep(driver);
        productStep = new ProductStep(driver);
    }

    @AfterMethod (description = "Закрытие драйвера/Скриншот (При падении теста)")
    public void tearDown(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            takeScreenshot(driver);
        }
        softAssert.assertAll();
        if(driver != null){
            driver.quit();
        }
    }
}