package selenideProject;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Login Functionality tests")
@Feature("Login")
public class LoginTest extends TestBase {

    @Description("This test attempts to login with valid email and valid password")
    @Test
    public void checkLoginWithValidCredentialsTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("skrillex668@yandex.ru", "passwordtest");
        loginPage.logoutButtonIsDisplayed();
    }

    @Description("This test attempts to login with invalid email and invalid password")
    @Test
    public void checkLoginWithInvalidCredentialsTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("skrillex667@yandex.ru", "passwordtestt");
        loginPage.errorMessageIsDisplayed();
    }

    @Description("This test attempts to check LostPassword button")
    @Test
    public void checkLostPasswordButtonTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickCheckLostPasswordButton("skrillex668@yandex.ru", "passwordtest");
        loginPage.successMessageIsDisplayed();
    }
}

