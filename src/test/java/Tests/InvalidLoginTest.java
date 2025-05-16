package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {
        test.info("Starting Invalid Login Test");

        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("invalid@example.com", "Test@123");

            if (loginPage.isLoginSuccessful()) {
                test.fail("Logged in successfully with invalid credentials");
            } else {
                test.pass("Login failed");
                //Assert.fail("Login was not successful.");
            }
        } catch (Exception e) {
            test.fail("Login test failed: " + e.getMessage());
            Assert.fail("Test threw an exception: " + e.getMessage());
        }
    }
}
