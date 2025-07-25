package steps;

import dto.User;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.MainPage;

public class OrderStep {

    WebDriver driver;
    MainPage mainPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public OrderStep(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void validOrder(User user){
        mainPage.openCart()
                .clickCheckout()
                .addInformation(user)
                .clickFinish();
    }
    public void notValidOrder(User user){
        mainPage.openCart()
                .clickCheckout()
                .addInformation(user);
    }
}