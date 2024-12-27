package pageobject.object;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends TestBase {

    @Test
    public void checkThatCartIsEmptyTest() {
        CartPage cartPage = new CartPage(driver);
        SoftAssert softAssert = new SoftAssert();
        String massageWhenCartIsEmpty = "There are no items in your cart.";
        cartPage.clicCartLink();
        softAssert.assertTrue(cartPage.noItemsLabelIsDisplayed(), "Item label is not displayed.");
        softAssert.assertEquals(cartPage.noItemsLabelGetText(), massageWhenCartIsEmpty);
        softAssert.assertAll();
    }
}
