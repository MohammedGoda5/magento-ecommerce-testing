package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;



public class HomePage {

    SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
                /*       Locators       */
    private final By searchBarLocator = By.id("search");
    private final By searchButtonLocator = By.xpath("//button[@title='Search' and @type='submit']");
    private final By heroHoodieItem = By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[5]/div/div/ol/li[4]");
    private final By fusionBackpackItem = By.linkText("Fusion Backpack");
    private final By addBagToCart = By.xpath("//*[@id='maincontent']/div[3]/div/div[2]/div[5]/div/div/ol/li[5]/div/div/div[3]/div/div[1]/form/button");
    private final By addedItemsToCart = By.cssSelector("a.action.showcart");
    //    private final By addedItemsToCart = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]");
    private final By proceedToCheckout = By.id("top-cart-btn-checkout");
    /*       Methods        */
    public void searchForItem(String searchItem) {
        driver.element().type(searchBarLocator, searchItem);
        driver.element().click(searchButtonLocator);
    }
    public AddProductPage ChooseItem(){
        driver.element().scrollToElement(heroHoodieItem);
        driver.element().click(heroHoodieItem);
    return new AddProductPage(driver);
    }
    public AddProductPage ChooseInvalidItem(){
        driver.element().scrollToElement(fusionBackpackItem);
        driver.element().hover(fusionBackpackItem);
        driver.element().click(addBagToCart);
        return new AddProductPage(driver);
    }
public CheckoutPage OpenCheckoutPage(){

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

