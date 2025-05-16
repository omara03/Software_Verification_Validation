package Tests;

import Pages.ProductFilterPage;
import org.testng.annotations.Test;

public class ProductFilterTest extends BaseTest {

    @Test
    public void productFilterTest() {
        driver.get("https://demowebshop.tricentis.com/");
        test.info("Opened Demo Web Shop");

        ProductFilterPage filter = new ProductFilterPage(driver);
        filter.goToBooksCategory();
        test.info("Navigated to 'Books' category");

        filter.applySortBy("Price: Low to High");
        test.info("Applied 'Price: Low to High' sort filter");

        filter.setDisplayLimit("4");
        test.info("Set product display limit to 4");

        filter.changeViewMode("List");
        test.pass("✅ Product filter and display options applied successfully");
    }
}
