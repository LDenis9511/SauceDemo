package tests;


import dto.User;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    User user = new User();

    @Test (testName = "Авторизация",description = "Проверка  авторизация с корректными данными")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Laptev D.Y.")
    public void checkLogin(){
        loginStep.auth(user);
        assertTrue(productsPage.isPageOpened(),"Не авторизовались");
    }

    @DataProvider (name =  "LoginData")
    public  Object[][] loginData(){
        return new Object[][]{
                {"standard_user","", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test (dataProvider = "LoginData",testName ="Авторизация с неправильными данными",
            description = "Проверка авторизации с неправильными данными")
    @Severity(SeverityLevel.MINOR)
    @Owner("Laptev D.Y.")
    public void checkLoginWithNegativeValue1(String username,String password,String expectedMessage){
        user.setUsername(username);
        user.setPassword(password);
        loginPage.open()
                        .login(user);
        Assert.assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не то ");
    }
}