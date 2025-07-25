package steps;

import dto.User;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void auth(User user) {
        loginPage.open()
                    .login(user);
    }
}