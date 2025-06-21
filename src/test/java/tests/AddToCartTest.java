package tests;

import org.testng.annotations.Test;

import pages.HomePage;


@Test
public class AddToCartTest extends BaseTest{

    @Test(description = "Check that the user can add items to card successfully")
    public void successfulAddItemToCart(){
        homePage=new HomePage(driver);
        addProductPage=homePage.ChooseFirstProductItem();
        addProductPage.addProductToCart(testData.getTestData("size-l"),
                testData.getTestData("color-blue"));
        addProductPage.SuccessfullAddItemToCart(testData.getTestData("successfulAddedToCartMessage"));

    }
}
