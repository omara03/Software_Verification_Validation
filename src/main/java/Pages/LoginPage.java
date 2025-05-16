package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "https://demowebshop.tricentis.com/";

    By loginLink = By.cssSelector("a[href='/login']");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginButton = By.cssSelector("input.button-1.login-button");
    By errorMessage = By.cssSelector("div.validation-summary-errors > span");
    By accountEmail = By.cssSelector("a.account"); // Appears after successful login

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo() {
        driver.get(baseUrl);
    }

    public void login(String email, String password) {
        try {
            navigateTo();
            Thread.sleep(2000);

            WebElement loginLinkElement = wait.until(ExpectedConditions.elementToBeClickable(loginLink));
            loginLinkElement.click();
            Thread.sleep(2000);

            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
            emailInput.clear();
            emailInput.sendKeys(email);
            Thread.sleep(1000);

            WebElement passwordInput = driver.findElement(passwordField);
            passwordInput.clear();
            passwordInput.sendKeys(password);
            Thread.sleep(1000);

            WebElement loginBtn = driver.findElement(loginButton);
            loginBtn.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException("Login failed: " + e.getMessage());
        }
    }

    public boolean isLoginSuccessful() {
        try {
            // Check if error message is displayed
            if (driver.findElements(errorMessage).size() > 0) {
                String errorText = driver.findElement(errorMessage).getText().toLowerCase();
                if (errorText.contains("login was unsuccessful")) {
                    return false;
                }
            }

            // If error message not found, check if account email element is visible
            WebElement accountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountEmail));
            return accountElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
