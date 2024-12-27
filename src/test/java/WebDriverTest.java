import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class WebDriverTest {

    @Test
    public void startBrowserTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        ArrayList<WebElement> allLinks = (ArrayList<WebElement>) driver.findElements(By.tagName("a"));
//      Assert.assertEquals(allLinks.size(), 10);
        allLinks.get(10).click();
        driver.quit();
    }

    @Test
    public void openHomePageTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement homePage = driver.findElement(By.cssSelector(".fa.fa-home"));
        homePage.click();
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
        driver.quit();
    }

    @Test
    public void openRubberDucksPageTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement RubberDucksPage = driver.findElement(By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        RubberDucksPage.click();
        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store");
        driver.quit();
    }

    @Test
    public void openSubcategoryPageTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement RubberDucksPage = driver.findElement(By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(RubberDucksPage).perform();
        WebElement SubcategoryPage = driver.findElement(By.cssSelector("#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/']"));
        SubcategoryPage.click();
        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store");
        driver.quit();
    }

    @Test
    public void doubleClickTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickButton = driver.findElement(By.tagName("button"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
    }

    @Test
    public void rightClickTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement contextMenuButton = driver.findElement(By.cssSelector("[class='context-menu-one btn btn-neutral']"));
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuButton).perform();
    }


    // ТЕСТЫ КЕЙСЫ ДЛЯ https://litecart.stqa.ru/en/

    // Логин
    @Test
    public void checkLoginWithValidCredentialsTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        // Заполняем форму для входа
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("skrillex668@yandex.ru");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("passwordtest");
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href*='logout']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed after login.");
        driver.quit();
    }


    @Test
    public void checkLoginWithInvalidCredentialsTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("skrillex123@yandex.ru");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("passwordtest123");
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.cssSelector(".notice.errors"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed after invalid login.");
        driver.quit();
    }


    @Test
    public void checkLostPasswordButtonTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("skrillex666@yandex.ru");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("passwordtest");
        WebElement lostPasswordButton = driver.findElement(By.cssSelector("[name=lost_password]"));
        lostPasswordButton.click();
        WebElement successMessage = driver.findElement(By.cssSelector(".notice.success"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed after clicking lost password button.");
        driver.quit();
    }


    // Корзина
    @Test
    public void checkThatCartIsEmptyTest () {
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        String massageWhenCartIsEmpty = "There are no items in your cart.";
        driver.get("https://litecart.stqa.ru/en/");
        WebElement cartLink = driver.findElement(By.cssSelector("#cart .content"));
        cartLink.click();
        WebElement noItemsLabel = driver.findElement(By.tagName("em"));
        softAssert.assertTrue(noItemsLabel.isDisplayed(), "Item label is not displayed.");
        softAssert.assertEquals(noItemsLabel.getText(), massageWhenCartIsEmpty);
        driver.quit();
    }

    // Каталог
    @Test
    public void checkRubberDucksCatalogLinkTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        // Находим ссылку на каталог "Rubber Ducks"
        WebElement rubberDucksLink = driver.findElement(By.linkText("Rubber Ducks"));
        rubberDucksLink.click();
        WebElement productList = driver.findElement(By.cssSelector(".listing-wrapper.products"));
        Assert.assertTrue(productList.isDisplayed(), "Product list is not displayed on the Rubber Ducks page.");
        driver.quit();
    }

}