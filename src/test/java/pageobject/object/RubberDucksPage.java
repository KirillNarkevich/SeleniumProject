package pageobject.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RubberDucksPage {
    private WebDriver driver;

    public RubberDucksPage(WebDriver driver) {
        this.driver = driver;
    }

    private By rubberDucksLink = By.linkText("Rubber Ducks");

    public void goToRubberDucks() {
        driver.findElement(rubberDucksLink).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
