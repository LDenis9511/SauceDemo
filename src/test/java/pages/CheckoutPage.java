package pages;

import dto.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
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

    public CheckoutPage open(){
        log.info("Открытие страницы оформления заказа");
        driver.get(BASE_URL+"checkout-step-one.html");
        return this;
    }

    @Step("Оформление заказа с именем: {firstName}, фамилией: {lastName} и Почтовым кодом: {zip}")
    public CheckoutPage addInformation(User user){
        log.info("Оформление заказа с именем: {}, фамилией: {} и Почтовым кодом: {}"
                ,user.getFirstname(),user.getLastname(),user.getZip());
        log.info("Заполнение поля Имя значением {}",user.getFirstname());
        driver.findElement(FIRSTNAME).sendKeys(user.getFirstname());
        log.info("Заполнение поля Фамилия значением {}",user.getLastname());
        driver.findElement(LASTNAME).sendKeys(user.getLastname());
        log.info("Заполнение поля ЗИП значением {}",user.getZip());
        driver.findElement(ZIP).sendKeys(user.getZip());
        driver.findElement(COUNTINUE).click();
        return this;
    }

    public String getErrorMessage(){
        log.info("Получение ошибки");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Нажатие на кнопку 'FINISH'")
    public void clickFinish(){
        log.info("Нажатие на кнопку 'FINISH'");
    driver.findElement(FINISH).click();
    }

    public String getCompleteHeader(){
        log.info("Получение статуса оформления");
        return driver.findElement(COMPLITE_HEADER).getText();
    }
}