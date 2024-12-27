package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartLink = By.cssSelector("#cart .content");

    public void goToCart() {
        driver.findElement(cartLink).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
