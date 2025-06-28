package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("span.title");
    private final By ELEMENTS = By.cssSelector(".inventory_item");
    private final By ELEMENTNAME = By.cssSelector(".inventory_item_name ");
    private final By ELEMENTPRICE = By.cssSelector(".inventory_item_price ");
    private final By BUTTON = By.cssSelector("button");

    public ProductsPage(WebDriver driver, SoftAssert softAssert) {
        super(driver,softAssert);
    }

    public boolean isPageOpened(){
        return driver.findElement(TITLE).isDisplayed();
    }

    public void open(){
        driver.get(BASE_URL+"inventory.html");
    }

    public HashMap <String, String> addInventoryItems (Set<String>aaa){
        HashMap<String, String> inventory_items = new HashMap<>();
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
            String text = element.findElement(ELEMENTNAME).getText();
            if (aaa.contains(text)) {
                element.findElement(BUTTON).click();
                String item = element.findElement(ELEMENTNAME).getText();
                String price = element.findElement(ELEMENTPRICE).getText();
                inventory_items.put(item,price);
            }
        }
        return inventory_items;
    }

    public HashMap <String, String> addInventoryItems (String Item){
        HashMap<String, String> inventory_items = new HashMap<>();
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
            String text = element.findElement(ELEMENTNAME).getText();
            if (Item.contains(text)) {
                element.findElement(BUTTON).click();
                String item = element.findElement(ELEMENTNAME).getText();
                String price = element.findElement(ELEMENTPRICE).getText();
                inventory_items.put(item,price);
            }
        }
        return inventory_items;
    }

    public HashMap <String, String> addAllInventoryItems (){
        HashMap<String, String> inventory_items = new HashMap<>();
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
                element.findElement(BUTTON).click();
                String item = element.findElement(ELEMENTNAME).getText();
                String price = element.findElement(ELEMENTPRICE).getText();
                inventory_items.put(item,price);
        }
        return inventory_items;
    }

    public HashMap <String, String> getButtonNameByCartName(Set<String>aaa){
        HashMap<String, String> buttonsName = new HashMap<>();
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
            String text = element.findElement(ELEMENTNAME).getText();
            if (aaa.contains(text)) {
                String item = element.findElement(ELEMENTNAME).getText();
                String buttonName = element.findElement(BUTTON).getText();
                buttonsName.put(item,buttonName);
            }
        }
        return buttonsName;
    }

    public HashMap <String, String> getButtonNameByCartName(String item){
        HashMap<String, String> buttonsName = new HashMap<>();
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
            String text = element.findElement(ELEMENTNAME).getText();
            if (item.contains(text)) {
                String itemm = element.findElement(ELEMENTNAME).getText();
                String buttonName = element.findElement(BUTTON).getText();
                buttonsName.put(itemm,buttonName);
            }
        }
        return buttonsName;
    }

    public HashMap <String, String> getAllButtonName(){
        HashMap<String, String> buttonsName = new HashMap<>();
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
                String item = element.findElement(ELEMENTNAME).getText();
                String buttonName = element.findElement(BUTTON).getText();
                buttonsName.put(item,buttonName);
        }
        return buttonsName;
    }

    public void CheckAllButtonNameIs(String buttonName){
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
            softAssert.assertEquals(element.findElement(BUTTON).getText(),buttonName);
        }
    }

    public void CheckButtonNameIs(Set<String>items,String buttonName){
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
            String text = element.findElement(ELEMENTNAME).getText();
            if (items.contains(text)) {
                softAssert.assertEquals(element.findElement(BUTTON).getText(),buttonName);
            }
        }
    }
    public void CheckButtonNameIs(String item,String buttonName){
        List<WebElement> elements = driver.findElements(ELEMENTS);
        for (WebElement element : elements) {
            String text = element.findElement(ELEMENTNAME).getText();
            if (item.contains(text)) {
                softAssert.assertEquals(element.findElement(BUTTON).getText(),buttonName);
            }
        }
    }
}