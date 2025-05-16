package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductFilterPage {
    WebDriver driver;

    By categoryLink = By.linkText("Books");
    By sortByDropdown = By.id("products-orderby");
    By displayDropdown = By.id("products-pagesize");
    By viewModeDropdown = By.id("products-viewmode");

    public ProductFilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToBooksCategory() {
        driver.findElement(categoryLink).click();
    }

    public void applySortBy(String sortOption) {
        Select sortSelect = new Select(driver.findElement(sortByDropdown));
        sortSelect.selectByVisibleText(sortOption);
    }

    public void setDisplayLimit(String value) {
        Select displaySelect = new Select(driver.findElement(displayDropdown));
        displaySelect.selectByVisibleText(value);
    }

    public void changeViewMode(String viewType) {
        Select viewSelect = new Select(driver.findElement(viewModeDropdown));
        viewSelect.selectByVisibleText(viewType);
    }
}
