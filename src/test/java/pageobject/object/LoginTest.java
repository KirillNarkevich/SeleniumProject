package pageobject.object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void checkLoginWithValidCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("skrillex668@yandex.ru", "passwordtest");
        Assert.assertTrue(loginPage.logoutButtonIsDisplayed(), "Logout Button is not displayed");
    }

    @Test
    public void checkLoginWithInvalidCredentialsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("skrillex667@yandex.ru", "passwordtestt");
        Assert.assertTrue(loginPage.errorMessageIsDisplayed(), "Error message is not displayed after invalid login.");
    }

    @Test
    public void checkLostPasswordButtonTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickCheckLostPasswordButton("skrillex668@yandex.ru", "passwordtest");
        Assert.assertTrue(loginPage.successMessageIsDisplayed(), "Success message is not displayed after clicking lost password button.");
    }
}

