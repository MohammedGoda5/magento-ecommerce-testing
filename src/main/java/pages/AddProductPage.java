package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AddProductPage {
    SHAFT.GUI.WebDriver driver;

    public AddProductPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }



                    /*        Locators         */
    private final By successfulMessageLocator = By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div");
    private final By failMessageLocator = By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div/div");
    private final By selectSize = By.id("option-label-size-143-item-169");
    private final By selectColor = By.id("option-label-color-93-item-49");
    private final By addToCartButton = By.id("product-addtocart-button");
                    /*        Methods         */


    public void addProductToCart(){
        driver.element().click(selectSize);
        driver.element().click(selectColor);
        driver.element().click(addToCartButton);
    }

    public void SuccessfullAddItemToCart(String successfullMessage){
        driver.element().scrollToElement(successfulMessageLocator);
        driver.element().assertThat(successfulMessageLocator).text().contains(successfullMessage);

    }

    public void setFailMessageLocator(String failMessage){
        driver.element().scrollToElement(failMessageLocator);
        driver.element().assertThat(failMessageLocator).text().contains(failMessage);
    }
}
