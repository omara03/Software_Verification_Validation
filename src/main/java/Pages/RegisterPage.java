package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "https://demowebshop.tricentis.com/";

    By registerLink = By.cssSelector("a[href='/register']");
    By genderMaleRadio = By.id("gender-male");
    By genderFemaleRadio = By.id("gender-female");
    By firstNameField = By.id("FirstName");
    By lastNameField = By.id("LastName");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By confirmPasswordField = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By successMessage = By.cssSelector("div.result");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToRegisterPage() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void register(String gender, String firstName, String lastName, String email, String password) {
        navigateToRegisterPage();

        if (gender.equalsIgnoreCase("male")) {
            wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadio)).click();
        } else if (gender.equalsIgnoreCase("female")) {
            wait.until(ExpectedConditions.elementToBeClickable(genderFemaleRadio)).click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccessful() {
        try {
            String message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
            return message.toLowerCase().contains("completed");
        } catch (Exception e) {
            return false;
        }
    }
}
