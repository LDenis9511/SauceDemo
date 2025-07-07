package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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

    @Test (enabled = false ,groups = {"checkLogin"})
    public void checkLoginWithoutPassword(){
        loginPage.open();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение не то ");
    }

    @Test (enabled = false ,groups = {"checkLogin"})
    public void checkLoginWithoutUsername(){
        loginPage.open();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение не то ");
    }

    @Test (enabled = false ,groups = {"checkLogin"})
    public void checkLoginWithNegativeValue(){
        loginPage.open();
        loginPage.login("test","test");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение не то ");
    }

    @Test (testName = "Авторизация")
    public void checkLogin(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
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

    @Test (dataProvider = "LoginData",testName ="Авторизация с неправильными данными")
    public void checkLoginWithNegativeValue1(String user,String password,String expectedMessage){
        loginPage.open();
        loginPage.login(user,password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не то ");
    }
}