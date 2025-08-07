package tests;


import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class LocatorsTest extends BaseTest {

    @Test(testName = "Проверка локаторов",description = "Проверка локаторов")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Laptev D.Y.")
    public void locator(){
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.tagName("span"));
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Facebook"));
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//a[contains(@data-test,'linkedin')]"));
        driver.findElement(By.xpath("//a[contains(text(),'LinkedIn')]"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']//ancestor::a"));
        driver.findElement(By.xpath("//a[@data-test='item-2-title-link']//descendant::div"));
        driver.findElement(By.xpath("//div[@class='inventory_list']//following::*"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//.."));
        driver.findElement(By.xpath("//div[@class='header_container']//preceding::*"));
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light' and @data-test = 'add-to-cart-sauce-labs-bike-light']"));
        driver.findElement(By.cssSelector(".inventory_item_desc"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector("#react-burger-menu-btn"));
        driver.findElement(By.cssSelector("select"));
        driver.findElement(By.cssSelector("select.product_sort_container"));
        driver.findElement(By.cssSelector("select[data-test='product-sort-container']"));
        driver.findElement(By.cssSelector("[alt~='Menu']"));
        driver.findElement(By.cssSelector("a[class|='shopping_cart_link']"));
        driver.findElement(By.cssSelector("a[target^='_']"));
        driver.findElement(By.cssSelector("a[target$='nk']"));
        driver.findElement(By.cssSelector("a[target*='lan']"));
        driver.quit();
    }
}