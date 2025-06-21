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
        checkoutPage=homePage.OpenCheckoutPage();
        checkoutPage.fillShippingAddressForm("asd","asd","12345","0");
        checkoutPage.placeAnOrder();
        checkoutPage.checkSuccessfulPurchase(testData.getTestData("successfulPurchase"));
    }

}
