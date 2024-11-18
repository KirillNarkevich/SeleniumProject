package pageobject.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends TestBase {

    @Test
    public void checkCartLinkTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals("Checkout | My Store", cartPage.getPageTitle());
    }
}
