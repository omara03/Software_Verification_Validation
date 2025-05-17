package Tests;

import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class RegisterTest extends BaseTest {

    @Test
    public void registrationTest() {
        test.info("Starting user registration test");

        try {
            RegisterPage registerPage = new RegisterPage(driver);

            // Use unique email each time
            String uniqueEmail = "testuser_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";

            registerPage.register(
                    "male",
                    "TestFirstName",
                    "TestLastName",
                    uniqueEmail,
                    "Test@123"
            );

            Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Registration failed");
            test.pass("User registered successfully");
        } catch (Exception e) {
            test.fail("Registration test failed: " + e.getMessage());
        }
    }
}
