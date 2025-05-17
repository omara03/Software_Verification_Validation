package Tests;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;
public class ParallelExecution {

    public static void main(String[] args) {
        // Create a new TestNG instance
        TestNG testng = new TestNG();

        // Create an XmlSuite (the suite file)
        XmlSuite suite = new XmlSuite();
        suite.setName("ECommerceSuite");

        // Set parallel execution for the suite
        suite.setParallel(XmlSuite.ParallelMode.CLASSES); // You can also use XmlSuite.ParallelMode.TESTS or METHODS
        suite.setThreadCount(2);  // Set the number of threads (adjust based on your system)

        // Create a test and assign test classes to it
        XmlTest test = new XmlTest(suite);
        test.setName("ECommerceTest");

        List<XmlClass> classes = new ArrayList<>();
        classes.add(new XmlClass("Tests.CartTest"));
        classes.add(new XmlClass("Tests.CheckoutTest"));
        classes.add(new XmlClass("Tests.InvalidLoginTest"));
        classes.add(new XmlClass("Tests.ProductFilterTest"));
        classes.add(new XmlClass("Tests.RegisterTest"));
        classes.add(new XmlClass("Tests.SearchTest"));
        classes.add(new XmlClass("Tests.ValidLoginTest"));
        classes.add(new XmlClass("Tests.VerifyOrderConfirmationTest"));

        // Assign the classes to the test
        test.setClasses(classes);

        // Add the suite to TestNG
        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);

        testng.setXmlSuites(suites);

        // Run the tests
        testng.run();
    }

}
