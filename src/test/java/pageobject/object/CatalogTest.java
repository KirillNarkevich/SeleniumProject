package pageobject.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CatalogTest extends TestBase {

    @Test
    public void checkRubberDucksCatalogLinkTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        RubberDucksPage rubberDucksPage = new RubberDucksPage(driver);
        rubberDucksPage.goToRubberDucks();

        Assert.assertEquals("Rubber Ducks | My Store", rubberDucksPage.getPageTitle());
    }
}
