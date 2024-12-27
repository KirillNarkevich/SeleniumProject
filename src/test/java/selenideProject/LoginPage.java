package selenideProject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.name("login");
    private By lostPasswordButton = By.cssSelector("[name=lost_password]");
    private By logoutButton = By.cssSelector("a[href*='logout']");
    private By errorMessage = By.cssSelector(".notice.errors");
    private By successMessage = By.cssSelector(".notice.success");

    @Step("Enter the email in the field")
    public void enterEmail(String email) {
       $(emailField).sendKeys(email);
    }

    @Step("Enter the password in the field")
    public void enterPassword(String password) {
        $(passwordField).sendKeys(password);
    }

    @Step("Click on login button")
    public void clickLogin() {
       $(loginButton).click();
    }

    @Step("Click on lost password button")
    public void clickLostPassword() {
        $(lostPasswordButton).click();
    }

    @Step("Validate that error message is displayed")
    public void errorMessageIsDisplayed (){
         $(errorMessage).shouldBe(Condition.visible);
    }

    @Step("Validate that success message is displayed")
    public void successMessageIsDisplayed (){
       $(successMessage).shouldBe(Condition.visible);
    }

    @Step("Validate that logout button is displayed")
    public void logoutButtonIsDisplayed (){
        $(logoutButton).shouldBe(Condition.visible);
    }

//    @Step("Login with defined credentials")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

    @Step("Validate that lost password button is displayed")
    public void clickCheckLostPasswordButton (String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLostPassword();
    }
}
