package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends BaseTest {

    @Test
    public void cartTest() {
        driver.get("https://demowebshop.tricentis.com/");
        test.info("Opened Demo Web Shop");

        // Search and add product
        HomePage home = new HomePage(driver);
        home.searchProduct("computer");
        test.info("Searched for 'computer'");

        ProductPage product = new ProductPage(driver);
        product.openFirstProduct();
        product.addToCart();
        test.info("Clicked Add to Cart");

        // Confirm "added to cart" bar appears
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));

        test.info("Product was added to cart");

        // Go to cart and remove
        CartPage cart = new CartPage(driver);
        cart.goToCart();
        cart.removeItem();

        test.pass("✅ Item removed from cart successfully");
    }
}
