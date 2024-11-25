package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.name("login");
    private By lostPasswordButton = By.cssSelector("[name=lost_password]");
    private By logoutButton = By.cssSelector("a[href*='logout']");
    private By errorMessage = By.cssSelector(".notice.errors");
    private By successMessage = By.cssSelector(".notice.success");

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickLostPassword() {
        driver.findElement(lostPasswordButton).click();
    }

    public boolean errorMessageIsDisplayed (){
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean successMessageIsDisplayed (){
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean logoutButtonIsDisplayed (){
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    public void clickCheckLostPasswordButton (String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLostPassword();
    }
}
