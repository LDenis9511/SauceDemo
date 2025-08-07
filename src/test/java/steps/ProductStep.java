package steps;

import dto.Product;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductStep {

    WebDriver driver;
     ProductsPage productsPage;

    public ProductStep(WebDriver driver) {
        this.driver = driver;
        this.productsPage = new ProductsPage(driver);
    }

    public void addProduct(Product product){
        productsPage.addInventoryPrice(product)
                .addInventoryItem(product);
    }
}