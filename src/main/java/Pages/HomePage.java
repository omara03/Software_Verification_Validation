package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By searchBox = By.id("small-searchterms");
    By searchBtn = By.cssSelector("input.button-1.search-box-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchBtn).click();
    }
}
