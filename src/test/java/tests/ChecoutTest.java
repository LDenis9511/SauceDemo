package tests;


import dto.User;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static dto.UserFactory.getUser;

public class ChecoutTest extends BaseTest {

    User user = getUser();

    @Test (groups = {"checkDesigns"},testName = "Оформление заказа",
    description = "Проверка оформления зкакза")
    @Owner("Laptev D.Y.")
    public  void checkDesigns(){
        user.setUsername(user1);
        user.setPassword(password1);
        loginStep.auth(user);
      orderStep.validOrder(user);
        Assert.assertEquals(checkoutPage.getCompleteHeader(),"Thank you for your order!");
    }

    @DataProvider(name =  "LoginData")
    public  Object[][] loginData(){
        return new Object[][]{
                {"","1", "1","Error: First Name is required"},
                {"1", "", "1","Error: Last Name is required"},
                {"1", "1", "","Error: Postal Code is required"}
        };
    }

    @Test (dataProvider = "LoginData",groups = {"checkDesigns"},testName = "Оформление заказа неправильными данными",
    description = "Проверка оформления заказа с неправильными данными")
    @Owner("Laptev D.Y.")
    public void checkLoginWithNegativeValue1(String firstName,String lastName,String zip,String expectedMessage){
        user.setUsername(user1);
        user.setPassword(password1);
        loginStep.auth(user);
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setZip(zip);
        orderStep.notValidOrder(user);
        Assert.assertEquals(checkoutPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не то ");
    }
}