package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

/**
 * Page object representing the Login page.
 * Handles user authentication and navigation.
 */
public class LoginPage {

    SHAFT.GUI.WebDriver driver;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /* ==================== Locators ==================== */
    private final By signInLinkLocator = By.linkText("Sign In");
    private final By emailFieldLocator = By.id("email");
    private final By passwordFieldLocator = By.name("login[password]");
    private final By loginButtonLocator = By.name("send");

    /* ==================== Methods ==================== */

    /**
     * Navigates to the login page by clicking the Sign In link.
     */
    public void navigateToLoginPage() {
        driver.element().click(signInLinkLocator);
    }

    /**
     * Enters the email address.
     * @param email the email to enter
     */
    public void setEmailAddress(String email) {
        driver.element().type(emailFieldLocator, email);
    }

    /**
     * Enters the password.
     * @param password the password to enter
     */
    public void setPassword(String password) {
        driver.element().type(passwordFieldLocator, password);
    }

    /**
     * Clicks the login button and navigates to Home page.
     * @return HomePage instance after successful login
     */
    public HomePage navigateHomePage() {
        driver.element().click(loginButtonLocator);
        return new HomePage(driver);
    }

    /**
     * Performs complete login action with email and password.
     * @param email the user email
     * @param password the user password
     */
    public void login(String email, String password) {
        navigateToLoginPage();
        setEmailAddress(email);
        setPassword(password);
        driver.element().click(loginButtonLocator);
    }
}
