import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private WebDriver browser;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    @Test
    void test1_positiveLogin() {
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        browser.findElement(By.id("login-button")).click();
        WebElement header = browser.findElement(By.cssSelector(".title"));
        boolean isHeaderVisible = header.isDisplayed();
        assertTrue(isHeaderVisible, "Заголовок 'Swag Labs' должен быть виден на экране");
        assertEquals("Swag Labs", header.getText());
    }

    @Test
    void test2_negativeLogin() {
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.id("user-name")).sendKeys("wrong_user");
        browser.findElement(By.id("password")).sendKeys("wrong_pass");
        browser.findElement(By.id("login-button")).click();
        WebElement errorElement = browser.findElement(By.xpath("//h3[@data-test='error']"));
        boolean isErrorVisible = errorElement.isDisplayed();
        assertTrue(isErrorVisible, "Сообщение об ошибке должно быть видно");
        assertEquals("Epic sadface: Username and password do not match any user in this service",
                errorElement.getText());
    }

    @AfterEach
    void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}

