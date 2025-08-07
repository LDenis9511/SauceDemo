package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class MainPage  {

    WebDriver driver;
    private final By CARTLINK = By.cssSelector(".shopping_cart_link");

    public MainPage(WebDriver driver) {
        this.driver=driver;
    }

    @Step("Нажатие на иконку 'Корзина'")
    public CartPage openCart(){
        log.info("Нажатие на иконку 'Корзина'");
        driver.findElement(CARTLINK).click();
        return new CartPage(driver);
    }
}