package pages;

import dto.Product;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.testng.Assert.assertTrue;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("span.title");
    private final String ELEMENTNAME = "//div[text()='%s']";
    private final String ELEMENTPRICE = "//div[text()='%s']/ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
    private final String BUTTON = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(){
        log.info("Проверка открытия страницы");
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Открытие страницы товаров")
    public ProductsPage open(){
        log.info("Открытие страницы товаров");
        driver.get(BASE_URL+"inventory.html");
        return this;
    }

    public ProductsPage addInventoryItem(Product product){
        log.info("Добавление товара {} в корзину",product.getProductName());
        try {
            driver.findElement(By.xpath(String.format(ELEMENTNAME,product.getProductName())));
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
            Assert.fail("Не удалось найти товар");
        }
        String buttonName = driver.findElement(By.xpath(String.format(BUTTON,product.getProductName()))).getText();
        if (buttonName.equals("Add to cart")){
            driver.findElement(By.xpath(String.format(BUTTON,product.getProductName()))).click();
        }
        return this;
    }

    public ProductsPage addInventoryPrice(Product product){
        log.info("Добавление информации о цене товара {}",product.getProductName());
        product.setProductPrice(driver.findElement(By.xpath(String.format(ELEMENTPRICE,product.getProductName()))).getText());
        return this;
    }
}