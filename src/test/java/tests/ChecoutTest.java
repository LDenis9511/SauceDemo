package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChecoutTest extends BaseTest {

    @Test (enabled = false ,groups = {"checkDesigns"},testName = "Оформление заказа без firstName")
    public  void checkDesignsWithoutFirstName(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.addInformation("","1","1");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Сообщение не то ");
    }

    @Test (enabled = false ,groups = {"checkDesigns"},testName = "Оформление заказа без lastName")
    public  void checkDesignsWithoutLastName(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.addInformation("1","","1");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Сообщение не то ");
    }

    @Test (enabled = false ,groups = {"checkDesigns"},testName = "Оформление заказа без zip")
    public  void checkDesignsWithoutZip(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.addInformation("1","1","");
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Сообщение не то ");
    }

    @Test (groups = {"checkDesigns"},testName = "Оформление заказа")
    public  void checkDesigns(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.addInformation("1","1","1");
        softAssert.assertEquals(checkoutPage.getTitleName(),"Checkout: Overview");
        checkoutPage.clickFinish();
        softAssert.assertEquals(checkoutPage.getCompleteHeader(),"Thank you for your order!");
    }

    @DataProvider(name =  "LoginData")
    public  Object[][] loginData(){
        return new Object[][]{
                {"","1", "1","Error: First Name is required1"},
                {"1", "", "1","Error: Last Name is required"},
                {"1", "1", "","Error: Postal Code is required"}
        };
    }

    @Test (dataProvider = "LoginData",groups = {"checkDesigns"},testName = "Оформление заказа неправильными данными")
    public void checkLoginWithNegativeValue1(String firstName,String lastName,String zip,String expectedMessage){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.openCart();
        cartPage.clickCheckout();
        checkoutPage.addInformation(firstName,lastName,zip);
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не то ");
    }
}