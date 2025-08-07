package pages;

import dto.User;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class LoginPage extends BasePage{

    private final By LOGIN_FIELD = By.cssSelector("#user-name");
    private final By PASSWORD_FIELD = By.cssSelector("#password");
    private final By LOGIN_BUTTON = By.cssSelector("#login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public LoginPage open(){
        log.info("Открытие страницы авторизации");
    driver.get(BASE_URL);
    return this;
    }

    @Step("Вход в систему с именем пользователя: {user} и паролем: {password}")
    public CartPage login(User user){
        log.info("Вход в систему с именем пользователя: {} и паролем: {}",user.getUsername(),user.getPassword());
    driver.findElement(LOGIN_FIELD).sendKeys(user.getUsername());
    driver.findElement(PASSWORD_FIELD).sendKeys(user.getPassword());
    driver.findElement(LOGIN_BUTTON).click();
    return new CartPage(driver);
    }

    public String getErrorMessage(){
        log.info("Получение ошибки");
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}