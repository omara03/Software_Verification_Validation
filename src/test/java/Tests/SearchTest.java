package Tests;

import Pages.HomePage;
import Pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends BaseTest {

    @Test
    public void searchAndAddProductTest() {
        driver.get("https://demowebshop.tricentis.com/");
        test.info("Opened Demo Web Shop");

        HomePage home = new HomePage(driver);
        home.searchProduct("computer");
        test.info("Searched for 'computer'");

        ProductPage product = new ProductPage(driver);
        product.openFirstProduct();
        test.info("Opened first product");

        product.addToCart();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bar-notification")));

        test.pass("✅ Product added to cart successfully");
    }
}
