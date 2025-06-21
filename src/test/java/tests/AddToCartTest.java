package tests;

import org.testng.annotations.Test;

import pages.HomePage;


@Test
public class AddToCartTest extends BaseTest{

    @Test(description = "Check that the user can add items to card successfully")
    public void successfulAddItemToCart(){
        homePage=new HomePage(driver);
        addProductPage=homePage.ChooseItem();
        addProductPage.addProductToCart();
        addProductPage.SuccessfullAddItemToCart(testData.getTestData("successfulAddedToCartMessage"));

    }
    @Test(description = "check that user can't add item to card while the item is not available")
    public void FailAddItemToCart(){
        homePage=new HomePage(driver);
        addProductPage=homePage.ChooseInvalidItem();
        addProductPage.setFailMessageLocator(testData.getTestData("errorMessageAddingItem"));
    }
}
