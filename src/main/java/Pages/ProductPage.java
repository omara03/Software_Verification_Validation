package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    By firstProduct = By.cssSelector(".product-item h2 a");
    By addToCart = By.cssSelector("input[value='Add to cart']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openFirstProduct() {
        wait.until(ExpectedConditions.presenceOfElementLocated(firstProduct));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }
}
