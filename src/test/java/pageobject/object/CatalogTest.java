package pageobject.object;

import org.testng.annotations.Test;
import org.testng.Assert;

public class CatalogTest extends TestBase {

    @Test
    public void checkRubberDucksCatalogLinkTest() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickToRubberDucks();
        Assert.assertTrue(catalogPage.productListIsDisplayed(), "Product list is not displayed on the Rubber Ducks page.");
    }
}
