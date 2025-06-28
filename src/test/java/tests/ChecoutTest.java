package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ChecoutTest extends BaseTest {

    @Test
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

    @Test
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

    @Test
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

    @Test
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
}