package Tests;

import Pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ValidLoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        test.info("Starting Valid Login Test");

        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("testuser78945@example.com", "Test@123");

            if (loginPage.isLoginSuccessful()) {
                test.pass("Logged in successfully with valid credentials");
            } else {
                test.fail("Login failed");
                //Assert.fail("Login was not successful.");
            }
        } catch (Exception e) {
            test.fail("Login test failed: " + e.getMessage());
            Assert.fail("Test threw an exception: " + e.getMessage());
        }
    }
}
