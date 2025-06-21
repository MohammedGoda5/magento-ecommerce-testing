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
    private final By FirstProductLocator = By.xpath("(//li[@class='product-item'])[1]");


    /*       Methods        */
    public void searchForItem(String searchItem) {
        driver.element().type(searchBarLocator, searchItem);
        driver.element().click(searchButtonLocator);
    }

    public AddProductPage ChooseFirstProductItem() {
        driver.element().scrollToElement(FirstProductLocator);
        driver.element().click(FirstProductLocator);
        return new AddProductPage(driver);
    }



}

