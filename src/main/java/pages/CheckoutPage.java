package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class CheckoutPage {

    SHAFT.GUI.WebDriver driver;

    public CheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By streetAddressLocator = By.name("street[0]");
    private final By cityLocator = By.name("city");
    private final By statesListlocator = By.name("region_id");
    private final By selectFirstStateValue = By.xpath("//*[@value='1']");
    private final By countryListlocator = By.id("country_id");
    private final By selectFirstCountry = By.xpath("//*[@value='AF']");
    private final By postalcodeLocator = By.name("postcode");
    private final By phoneNumberLocator = By.name("telephone");
    private final By selectShippingMethod = By.name("ko_unique_3");
    private final By nextButton = By.xpath("//*[@id='shipping-method-buttons-container']/div/button");
    private final By placeOrderButton = By.xpath("//button[@type='submit' and @title='Place Order']");
    private final By successfulPurchase = By.xpath("//h1");


    public void fillShippingAddressForm(String street , String city , String postCode , String phoneNumber){
        driver.element().scrollToElement(streetAddressLocator);
        driver.element().type(streetAddressLocator,street);
        driver.element().type(cityLocator,city);
        driver.element().click(statesListlocator);
        driver.element().click(selectFirstStateValue);
        driver.element().type(postalcodeLocator,postCode);
//        driver.element().click(countryListlocator);
//        driver.element().click(selectFirstCountry);
        driver.element().type(phoneNumberLocator,phoneNumber);
        driver.element().click(selectShippingMethod);
        driver.element().click(nextButton);
    }

public void placeAnOrder(){
        driver.element().click(placeOrderButton);
    }
public void checkSuccessfulPurchase(String sucessfulPurchaseMessage){
        driver.assertThat().element(successfulPurchase).text().contains(sucessfulPurchaseMessage);
}

}
