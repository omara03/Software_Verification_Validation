package Tests;

import org.testng.TestNG;

public class AllTestSuite {
    public static void main(String[] args) {
        TestNG testng = new TestNG();

        testng.setTestClasses(new Class[] {
                CartTest.class,
                CheckoutTest.class,
                InvalidLoginTest.class,
                ProductFilterTest.class,
                RegisterTest.class,
                SearchTest.class,
                ValidLoginTest.class,
                VerifyOrderConfirmationTest.class
        });

        testng.setDefaultSuiteName("AllTestSuite");
        testng.setDefaultTestName("ECommerceSelectedTests");

        testng.run();
    }
}
