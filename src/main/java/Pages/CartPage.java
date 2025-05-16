package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    By cartLink = By.cssSelector("a[href='/cart']");
    By removeCheckbox = By.name("removefromcart");
    By updateBtn = By.name("updatecart");
    By checkoutButton = By.cssSelector("input[name='checkout']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    public void removeItem() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.page.shopping-cart-page")));
        List<WebElement> items = driver.findElements(removeCheckbox);
        if (items.isEmpty()) {
            throw new NoSuchElementException("❌ No items in cart to remove.");
        }

        items.get(0).click();
        driver.findElement(updateBtn).click();
    }

}
