package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {
    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    private By rubberDucksLink = By.linkText("Rubber Ducks");
    private By productList = By.cssSelector(".listing-wrapper.products");


    public void clickToRubberDucks() {
        driver.findElement(rubberDucksLink).click();
    }

    public boolean productListIsDisplayed (){
        return driver.findElement(productList).isDisplayed();
    }
}
