package Tests;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest extends BaseTest {

    @Test
    public void proceedToCheckoutTest() {
        driver.get("https://demowebshop.tricentis.com/");
        test.info("Opened Demo Web Shop");

        // Step 1: Add a product
        HomePage home = new HomePage(driver);
        home.searchProduct("computer");

        ProductPage product = new ProductPage(driver);
        product.openFirstProduct();
        product.addToCart();
        test.info("Product added to cart");

        // Wait for "added to cart" bar
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));

        // Step 2: Proceed to checkout
        CartPage cart = new CartPage(driver);
        cart.goToCart();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.proceedToCheckout();

        test.pass("✅ Proceeded to checkout successfully");
    }
}
