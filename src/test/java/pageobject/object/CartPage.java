package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private By cartLink = By.cssSelector("#cart .content");
    private By noItemsLabel = By.tagName("em");

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clicCartLink() {
        driver.findElement(cartLink).click();
    }

    public boolean noItemsLabelIsDisplayed (){
        return driver.findElement(noItemsLabel).isDisplayed();
    }

    public String noItemsLabelGetText(){
        return driver.findElement(noItemsLabel).getText();
    }
}
