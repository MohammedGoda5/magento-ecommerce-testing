package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    SHAFT.GUI.WebDriver driver;


                            /*        Locators        */
private final By signInLink=By.linkText("Sign In");
private final By emailAddress=By.id("email");
private final By passwordLocator =By.name("login[password]");
private final By loginButton=By.name("send");


                            /*        Methods        */

public void navigateToLoginPage(){
    driver.element().click(signInLink);
}

public void setEmailAddress(String email){
    driver.element().type(emailAddress,email);
}
public void setPasswordLocator(String pass){
    driver.element().type(passwordLocator,pass);
}
public HomePage navigateHomePage(){
    driver.element().click(loginButton);
    return new HomePage(driver);
}

public void Login(String email , String password){
    navigateToLoginPage();
    setEmailAddress(email);
    setPasswordLocator(password);
}
}

