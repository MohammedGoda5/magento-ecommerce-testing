package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class ProductSearchTest extends BaseTest { // Extend BaseTest


    @Test (description = "Verify that a valid product search returns relevant results")
    public void searchItemTest() {
         homePage= new HomePage(driver);
        homePage.searchForItem(testData.getTestData("validSearchQuery"));

    }

}
