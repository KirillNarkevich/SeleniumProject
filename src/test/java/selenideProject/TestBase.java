package selenideProject;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    WebDriver driver;
    String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeMethod
    public void methodSetup() {
        String browser = System.getProperty("browser", "chrome");
        Configuration.browser = browser;
        Configuration.browserSize = "1920 x 1280";
        open("http://litecart.stqa.ru/en/");
        Configuration.pageLoadTimeout = 5000;

    }
}