package selenideProject;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Cart Functionality tests")
@Feature("Cart")
public class CartTest extends TestBase {

    @Description("This test verifies that cart is empty")
    @Test
    public void checkThatCartIsEmptyTest() {
        CartPage cartPage = new CartPage();
        String massageWhenCartIsEmpty = "There are no items in your cart.";
        cartPage.clickCartLink();
        cartPage.noItemsLabelIsDisplayed();
        cartPage.noItemsLabelGetText(massageWhenCartIsEmpty);
    }
}
