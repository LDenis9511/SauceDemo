package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CartPage extends BasePage{

    private final By CARTLIST = By.cssSelector(".cart_list");
    private final By ELEMENTNAME = By.cssSelector(".inventory_item_name ");
    private final By ELEMENTPRICE = By.cssSelector(".inventory_item_price ");
    private final By BUTTON = By.cssSelector("button");
    private final By CHECKOUT = By.cssSelector("#checkout");
    private final By SHOPPING = By.cssSelector("#continue-shopping");

    public CartPage(WebDriver driver, SoftAssert softAssert) {
        super(driver,softAssert);
    }

    public void open(){
        driver.get(BASE_URL+"cart.html");
    }

    public void CheckItemsAndPriceInCart(HashMap<String, String> ItemsAndPtice){
        List<WebElement> elements = driver.findElements(CARTLIST);
        for (WebElement element : elements) {
            String itemincart = element.findElement(ELEMENTNAME).getText();
            if (ItemsAndPtice.containsKey(itemincart)) {
                //Проверяем цену товара
                softAssert.assertEquals(element.findElement(ELEMENTPRICE).getText(), ItemsAndPtice.get(itemincart));
            }
        }
    }

    public void CheckItemsInCart(Set<String> Item){
        List<WebElement> elements = driver.findElements(CARTLIST);
        for (WebElement element : elements) {
            String itemincart = element.findElement(ELEMENTNAME).getText();
            //Проверяем наличие карточки в корзине по названию
            softAssert.assertTrue(Item.contains(itemincart));
        }
    }

    public void CheckItemsAndPriceInCart(String item, String price){
        List<WebElement> elements = driver.findElements(CARTLIST);
        for (WebElement element : elements) {
            String itemincart = element.findElement(ELEMENTNAME).getText();
            //Проверяем наличие карточки в корзине по названию
            softAssert.assertTrue(item.contains(itemincart));
            //Проверяем цену товара
            softAssert.assertEquals(element.findElement(ELEMENTPRICE).getText(),price);
        }
    }

    public void CheckItemsInCart(String item){
        List<WebElement> elements = driver.findElements(CARTLIST);
        String qqq = null;
        for (WebElement element : elements) {
            String itemincart = element.findElement(ELEMENTNAME).getText();
            if(item.equals(itemincart)) qqq= itemincart;
        }
        softAssert.assertEquals(qqq,item,"Данный товар отсутствует");
    }

    public void CheckItemsNotInCart(String item){
        List<WebElement> elements = driver.findElements(CARTLIST);
        String qqq = null;
        for (WebElement element : elements) {
            String itemincart = element.findElement(ELEMENTNAME).getText();
            if(item.equals(itemincart)) qqq= itemincart;
        }
        softAssert.assertNotEquals(qqq,item,"Данный товар есть в корзине");
    }

    public void RemoveAllItems(){
        List<WebElement> elements = driver.findElements(CARTLIST);
        for (WebElement element : elements) {
            element.findElement(BUTTON).click();
        }
    }

    public void RemoveItems(Set<String> Item){
        List<WebElement> elements = driver.findElements(CARTLIST);
        for (WebElement element : elements) {
            String text = element.findElement(ELEMENTNAME).getText();
            if (Item.contains(text)) {
                element.findElement(BUTTON).click();
            }
        }
    }

    public void RemoveItems(String Item){
        List<WebElement> elements = driver.findElements(CARTLIST);
        for (WebElement element : elements) {
            String text = element.findElement(ELEMENTNAME).getText();
            if (Item.equals(text)) {
                element.findElement(BUTTON).click();
            }
        }
    }

    public void clickCheckout(){
        driver.findElement(CHECKOUT).click();
    }

    public void clickShopping(){
        driver.findElement(SHOPPING).click();
    }
}