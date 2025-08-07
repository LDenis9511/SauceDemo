package tests;

import dto.Product;
import dto.User;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static dto.UserFactory.getUser;

public class ProductTest extends BaseTest{

    User user = getUser();
    Product product = new Product();

    @Test(groups = {"checkDesigns"},testName = "Отображение цены в корзине",
            description = "Проверка отображения цены в корзине")
    @Owner("Laptev D.Y.")
    public  void checkDesigns(){
        user.setUsername(user1);
        user.setPassword(password1);
        loginStep.auth(user);
        productStep.addProduct(product);
        cartPage.open();
        softAssert.assertEquals(cartPage.getProductPrise(product),product.getProductPrice());
    }
}