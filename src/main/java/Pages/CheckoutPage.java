package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    By agreeTerms = By.id("termsofservice");
    By checkoutBtn = By.id("checkout");

    // Continue buttons for each section
    By shippingMethodContinue = By.cssSelector("input.button-1.shipping-method-next-step-button");
    By paymentMethodContinue = By.cssSelector("input.button-1.payment-method-next-step-button");
    By paymentInfoContinue = By.cssSelector("input.button-1.payment-info-next-step-button");
    By confirmOrderBtn = By.cssSelector("input.button-1.confirm-order-next-step-button");
    By confirmationMsg = By.cssSelector("div.section.order-completed div.title strong");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(agreeTerms));
        driver.findElement(agreeTerms).click();
        driver.findElement(checkoutBtn).click();
    }

    public void clickContinueBilling() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("input.button-1.new-address-next-step-button")));
        driver.findElements(By.cssSelector("input.button-1.new-address-next-step-button")).getFirst().click();
    }
    public void clickContinueShippingAddress() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("input.button-1.new-address-next-step-button")));
        driver.findElements(By.cssSelector("input.button-1.new-address-next-step-button")).getLast().click();
    }

    public void clickContinueShippingMethod() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinue)).click();
    }

    public void clickContinuePaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinue)).click();
    }

    public void clickContinuePaymentInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinue)).click();
    }

    public void scrollToConfirmButton() {
        WebElement confirmBtn = wait.until(ExpectedConditions.presenceOfElementLocated(confirmOrderBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmBtn);
    }

    public void clickConfirmOrder() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn)).click();
    }

    public String getOrderConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsg)).getText();
    }
}
