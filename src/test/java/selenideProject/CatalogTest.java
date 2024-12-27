package selenideProject;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Catalog Functionality tests")
@Feature("Catalog")
public class CatalogTest extends TestBase {

    @Description("This test verifies that catalog links is exists")
    @Test
    public void checkRubberDucksCatalogLinkTest() {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickToRubberDucks();
        catalogPage.productListIsDisplayed();
    }
}
