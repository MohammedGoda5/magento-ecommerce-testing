package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AddProductPage {
    SHAFT.GUI.WebDriver driver;

    public AddProductPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    /*        Locators         */
    private final By getMessageLocator = By.xpath("//div[@role='alert' and @class='messages']");
    private final By addToCartButton = By.id("product-addtocart-button");
    private final By addedItemsToCart = By.cssSelector("a.action.showcart");
    private final By proceedToCheckout = By.id("top-cart-btn-checkout");
    /*        Methods         */

    private By selectSize(String size) {
        return By.xpath("//div[@aria-label='" + size + "']");
    }

    private By selectColor(String color) {
        return By.xpath("//div[@aria-label='" + color + "']");
    }

    public void addProductToCart(String size, String color) {
        driver.element().click(selectSize(size));
        driver.element().click(selectColor(color));
        driver.element().click(addToCartButton);
    }

    public void SuccessfullAddItemToCart(String successfullMessage) {
        driver.element().scrollToElement(getMessageLocator);
        driver.element().assertThat(getMessageLocator).text().contains(successfullMessage);

    }
    public CheckoutPage OpenCheckoutPage() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.element().click(addedItemsToCart);
        driver.element().click(proceedToCheckout);
        return new CheckoutPage(driver);
    }

}
