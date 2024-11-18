package pageobject.object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void checkLoginWithValidCredentialsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("skrillex666@yandex.ru", "passwordtest");

        Assert.assertEquals("Online Store | My Store", driver.getTitle());
    }

    @Test
    public void checkLoginWithInvalidCredentialsTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("skrillex123@yandex.ru", "passwordtest123");

        Assert.assertEquals("Login | My Store", driver.getTitle());
    }

    @Test
    public void checkLostPasswordButtonTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("skrillex666@yandex.ru");
        loginPage.enterPassword("passwordtest");
        loginPage.clickLostPassword();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
}

