package selenideProject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    private By rubberDucksLink = By.linkText("Rubber Ducks");
    private By productList = By.cssSelector(".listing-wrapper.products");


    @Step("Click on Rubber Ducks link")
    public void clickToRubberDucks() {
        $(rubberDucksLink).click();
    }

    @Step("Validate that product link is displayed")
    public void productListIsDisplayed (){
        $(productList).shouldBe(Condition.visible);
    }
}
