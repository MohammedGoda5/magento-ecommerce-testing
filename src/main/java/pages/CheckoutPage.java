package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

/**
 * Page object representing the Checkout page.
 * Handles shipping address entry and order placement.
 */
public class CheckoutPage {

    SHAFT.GUI.WebDriver driver;

    public CheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /* ==================== Locators ==================== */
    private final By addNewAddressButton = By.xpath("//button[@class='action action-show-popup']");
    private final By streetAddressField = By.name("street[0]");
    private final By cityField = By.name("city");
    private final By stateDropdown = By.name("region_id");
    private final By firstStateOption = By.xpath("//*[@value='1']");
    private final By postalCodeField = By.name("postcode");
    private final By phoneNumberField = By.name("telephone");
    private final By shippingMethodRadio = By.name("ko_unique_3");
    private final By shipHereButton = By.xpath("//button[@class='action primary action-save-address']");
    private final By placeOrderButton = By.xpath("//button[@type='submit' and @title='Place Order']");
    private final By successMessageHeader = By.xpath("//h1[@class='page-title']");
    private final By nextButton = By.xpath("//button[@class='button action continue primary']");

    /* ==================== Methods ==================== */

    /**
     * Fills the shipping address form with provided details.
     * @param street the street address
     * @param city the city name
     * @param postalCode the postal code
     * @param phoneNumber the phone number
     */
    public void fillShippingAddressForm(String street, String city, String postalCode, String phoneNumber) {
        driver.element().click(addNewAddressButton);
        driver.element().scrollToElement(streetAddressField);
        driver.element().type(streetAddressField, street);
        driver.element().type(cityField, city);
        driver.element().click(stateDropdown);
        driver.element().click(firstStateOption);
        driver.element().type(postalCodeField, postalCode);
        driver.element().type(phoneNumberField, phoneNumber);
        driver.element().click(shipHereButton);
        driver.element().click(shippingMethodRadio);
        driver.element().click(nextButton);
    }

    /**
     * Places the order by clicking the Place Order button.
     */
    public void placeAnOrder() {
        driver.element().click(placeOrderButton);
    }

    /**
     * Verifies that the purchase was successful.
     * @param expectedMessage the expected success message
     */
    public void verifySuccessfulPurchase(String expectedMessage) {
        driver.assertThat().element(successMessageHeader).text().contains(expectedMessage);
    }
}
