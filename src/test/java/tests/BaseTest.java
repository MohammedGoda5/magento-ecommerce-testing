package tests;

import com.shaft.driver.SHAFT;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AddProductPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {
    protected SHAFT.GUI.WebDriver driver;
    protected SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("testData.json");
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected AddProductPage addProductPage;
    protected CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://magento.softwaretestingboard.com");
    }

//    @AfterMethod
//    public void close() {
//        if (driver != null) {
//            driver.quit();
//        }
//}
}