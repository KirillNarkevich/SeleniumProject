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

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
