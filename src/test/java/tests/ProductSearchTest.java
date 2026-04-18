package tests;

import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Test class for Product Search functionality.
 */
public class ProductSearchTest extends BaseTest {

    @Test(description = "Verify that a valid product search returns relevant results")
    public void searchForExistingItem() {
        homePage = new HomePage(driver);
        homePage.searchForItem(testData.getTestData("validSearchQuery"));
    }

    @Test(description = "Verify that invalid product search doesn't return product items")
    public void searchForInvalidProductItem() {
        homePage = new HomePage(driver);
        homePage.searchForItem(testData.getTestData("invalidSearchQuery"));
        homePage.verifyNoSearchResultsMessage(testData.getTestData("invalidSearchMessage"));
    }
}
