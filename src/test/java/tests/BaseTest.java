package tests;

import com.shaft.driver.SHAFT;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AddProductPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

/**
 * Base test class providing common setup and teardown for all tests.
 * Uses SHAFT_ENGINE for WebDriver management and test data handling.
 */
public class BaseTest {
    protected SHAFT.GUI.WebDriver driver;
    protected SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("testData.json");
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected AddProductPage addProductPage;
    protected CheckoutPage checkoutPage;

    /**
     * Setup method executed before each test method.
     * Initializes WebDriver and navigates to base URL.
     */
    @BeforeMethod
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://magento.softwaretestingboard.com");
    }

    /**
     * Teardown method executed after each test method.
     * Ensures WebDriver is properly closed to prevent resource leaks.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
