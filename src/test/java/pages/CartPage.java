package pages;

import dto.Product;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class CartPage extends BasePage{

    private final By CHECKOUT = By.cssSelector("#checkout");
    private final String ELEMENTNAME = "//div[text()='%s']";
    private final String ELEMENTPRICE = "//div[text()='Sauce Labs Backpack']/ancestor::div[@class='cart_item']//div[@class='inventory_item_price']";
    private final String BUTTON = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage open(){
        log.info("Открытие корзины");
        driver.get(BASE_URL+"cart.html");
        return this;
    }

    public CheckoutPage clickCheckout(){
        log.info("Нажатие кнопки 'CHECKOUT'");
        driver.findElement(CHECKOUT).click();
        return new CheckoutPage(driver);
    }

    public String getProductPrise(Product product){
        log.info("получение цены: {}",product.getProductName());
    return driver.findElement(By.xpath(String.format(ELEMENTPRICE,product.getProductName()))).getText();
    }
}