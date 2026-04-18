package tests;

import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Test class for Add to Cart functionality.
 */
public class AddToCartTest extends BaseTest {

    @Test(description = "Check that the user can add items to cart successfully")
    public void successfulAddItemToCart() {
        homePage = new HomePage(driver);
        addProductPage = homePage.chooseFirstProductItem();
        addProductPage.addProductToCart(
                testData.getTestData("size-l"),
                testData.getTestData("color-blue")
        );
        addProductPage.verifySuccessfulAddToCart(testData.getTestData("successfulAddedToCartMessage"));
    }
}
