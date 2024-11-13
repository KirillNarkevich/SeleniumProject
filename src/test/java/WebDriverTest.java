import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebDriverTest {

    @Test
    public void startBrowserTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");

        ArrayList<WebElement> allLinks = (ArrayList<WebElement>) driver.findElements(By.tagName("a"));
//        Assert.assertEquals(allLinks.size(), 10);
        allLinks.get(10).click();
        driver.quit();
    }

}
