package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

/**
 * Page object representing the Add Product page.
 * Handles interactions for selecting product options and adding to cart.
 */
public class AddProductPage {
    SHAFT.GUI.WebDriver driver;

    public AddProductPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /* ==================== Locators ==================== */
    private final By messageLocator = By.xpath("//div[@role='alert' and @class='messages']");
    private final By addToCartButton = By.id("product-addtocart-button");
    private final By cartIcon = By.cssSelector("a.action.showcart");
    private final By proceedToCheckoutButton = By.id("top-cart-btn-checkout");

    /* ==================== Methods ==================== */

    /**
     * Returns locator for size selection based on size value.
     * @param size the size to select (e.g., "S", "M", "L")
     * @return By locator for the size element
     */
    private By getSizeLocator(String size) {
        return By.xpath("//div[@aria-label='" + size + "']");
    }

    /**
     * Returns locator for color selection based on color value.
     * @param color the color to select (e.g., "Blue", "Black")
     * @return By locator for the color element
     */
    private By getColorLocator(String color) {
        return By.xpath("//div[@aria-label='" + color + "']");
    }

    /**
     * Adds a product to cart with specified size and color.
     * @param size the size to select
     * @param color the color to select
     */
    public void addProductToCart(String size, String color) {
        driver.element().click(getSizeLocator(size));
        driver.element().click(getColorLocator(color));
        driver.element().click(addToCartButton);
    }

    /**
     * Verifies that the item was successfully added to cart.
     * @param expectedMessage the expected success message
     */
    public void verifySuccessfulAddToCart(String expectedMessage) {
        driver.element().scrollToElement(messageLocator);
        driver.element().assertThat(messageLocator).text().contains(expectedMessage);
    }

    /**
     * Opens the checkout page by clicking on cart and proceeding to checkout.
     * Uses SHAFT's implicit waits instead of hardcoded sleep.
     * @return CheckoutPage instance
     */
    public CheckoutPage openCheckoutPage() {
        // Wait for cart update using SHAFT's built-in synchronization
        // Element will be ready automatically via SHAFT synchronization
        driver.element().click(cartIcon);
        driver.element().click(proceedToCheckoutButton);
        return new CheckoutPage(driver);
    }
}
