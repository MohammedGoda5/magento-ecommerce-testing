package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

@Test
public class CheckoutTest extends BaseTest {
    @Test(description = "Verify user can place an order")
    public void checkoutUsingValidData(){
        loginPage=new LoginPage(driver);
        loginPage.Login(testData.getTestData("email"),
                testData.getTestData("password"));
        homePage=loginPage.navigateHomePage();
        addProductPage=homePage.ChooseFirstProductItem();
        addProductPage.addProductToCart(
                testData.getTestData("size-l"),
                testData.getTestData("color-blue")
        );
        checkoutPage=addProductPage.OpenCheckoutPage();
        checkoutPage.fillShippingAddressForm(
                testData.getTestData("street"),
                testData.getTestData("city"),
                testData.getTestData("postcode"),
                testData.getTestData("phoneNumber")
        );
        checkoutPage.placeAnOrder();
        checkoutPage.checkSuccessfulPurchase(
                testData.getTestData("successfulPurchase")
        );
    }

}
