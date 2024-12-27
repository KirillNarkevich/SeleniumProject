package selenideProject;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private By cartLink = By.cssSelector("#cart .content");
    private By noItemsLabel = By.tagName("em");

    @Step("Click on the cart link")
    public void clickCartLink() {
        $(cartLink).click();
    }

    @Step("Validate that 'no items label' is displayed")
    public void noItemsLabelIsDisplayed (){
        $(noItemsLabel).shouldBe(Condition.visible);
    }

    @Step("Getting text from the 'no items label'")
    public void noItemsLabelGetText(String expectedText){
        $(noItemsLabel).shouldHave(Condition.text(expectedText));
    }
}
