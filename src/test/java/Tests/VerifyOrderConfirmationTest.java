package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyOrderConfirmationTest extends BaseTest {

    @Test
    public void verifyOrderConfirmationTest() throws InterruptedException {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser78945@example.com", "Test@123");
        test.info("Successfully logged in");

        // Step 2: Search for a product
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Laptop");
        test.info("Searched for laptop");

        // Step 3: Add first product to cart
        ProductPage productPage = new ProductPage(driver);
        productPage.openFirstProduct();
        productPage.addToCart();
        test.info("Laptop is added to cart");

        Thread.sleep(2000); // Wait for cart update

        // Step 4: Go to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        Thread.sleep(2000);

        // Step 5: Agree to terms and proceed to checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();

        // Step 6: Skip through checkout steps by clicking "Continue"
        checkoutPage.clickContinueBilling();
        checkoutPage.clickContinueShippingAddress();
        checkoutPage.clickContinueShippingMethod();
        checkoutPage.clickContinuePaymentMethod();
        checkoutPage.clickContinuePaymentInfo();
        test.info("Completed checkout steps");

        // Step 7: Scroll and confirm order
        checkoutPage.scrollToConfirmButton();
        checkoutPage.clickConfirmOrder();
        test.info("Confirmed the order");

        // Step 8: Verify order confirmation
        String confirmationMsg = checkoutPage.getOrderConfirmationMessage();
        Assert.assertTrue(confirmationMsg.contains("Your order has been successfully processed!"),
                "Expected order confirmation message not found. Got: " + confirmationMsg);
    }
}
