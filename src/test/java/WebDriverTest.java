import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        emailField.sendKeys("skrillex666@yandex.ru");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("passwordtest");
        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
        // Проверяем, что после входа мы находимся на главной странице
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
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
        Assert.assertEquals(driver.getTitle(), "Login | My Store");
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
        // Проверяем, что перешли на страницу восстановления пароля
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        driver.quit();
    }


    // Корзина
    @Test
    public void checkCartLinkTest () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement cartLink = driver.findElement(By.cssSelector("#cart .content"));
        cartLink.click();
        Assert.assertEquals(driver.getTitle(), "Checkout | My Store");
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
        // Проверяем, что название страницы соответствует ожиданиям
        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store");
//        driver.quit();
    }

}