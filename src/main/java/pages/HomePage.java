package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

/**
 * Page object representing the Home page.
 * Handles navigation, search, and product selection functionality.
 */
public class HomePage {

    SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /* ==================== Locators ==================== */
    private final By searchBarLocator = By.id("search");
    private final By searchButtonLocator = By.xpath("//button[@title='Search' and @type='submit']");
    private final By firstProductLocator = By.xpath("(//li[@class='product-item'])[1]");
    private final By noResultsMessageLocator = By.xpath("//div[@class='message notice']");

    /* ==================== Methods ==================== */

    /**
     * Searches for an item using the search bar.
     * @param searchItem the search term to enter
     */
    public void searchForItem(String searchItem) {
        driver.element().type(searchBarLocator, searchItem);
        driver.element().click(searchButtonLocator);
    }

    /**
     * Verifies the no search results message is displayed.
     * @param expectedMessage the expected message text
     */
    public void verifyNoSearchResultsMessage(String expectedMessage) {
        driver.element().assertThat(noResultsMessageLocator).text().contains(expectedMessage);
    }

    /**
     * Selects the first product from the product list.
     * @return AddProductPage instance after clicking the product
     */
    public AddProductPage chooseFirstProductItem() {
        driver.element().scrollToElement(firstProductLocator);
        driver.element().click(firstProductLocator);
        return new AddProductPage(driver);
    }
}
