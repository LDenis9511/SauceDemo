package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void checkLoginWithoutPassword(){
        loginPage.open();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение не то ");
    }

    @Test
    public void checkLoginWithoutUsername(){
        loginPage.open();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение не то ");
    }

    @Test
    public void checkLoginWithNegativeValue(){
        loginPage.open();
        loginPage.login("test","test");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение не то ");
    }

    @Test
    public void checkLogin(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertTrue(productsPage.isPageOpened(),"Не авторизовались");
    }
}