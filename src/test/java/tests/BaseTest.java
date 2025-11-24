package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.PropertyReader;
import utils.TestListener;

import java.time.Duration;

@Listeners({AllureTestNg.class, TestListener.class})
public class BaseTest {

    public WebDriver browser;
    String user;
    String password;

    @Step("Открытие браузера")
    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browserName, ITestContext context) {

        if ("edge".equalsIgnoreCase(browserName)) {
            WebDriverManager.edgedriver().setup();
            browser = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--guest");
            browser = new ChromeDriver(options);
        }

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        context.setAttribute("driver", browser);

        user = PropertyReader.getProperty("saucedemo.user");
        password = PropertyReader.getProperty("saucedemo.password");
    }
    @Step("Закрытие браузера")
    @AfterMethod
    public void close() {
        if (browser != null) {
            browser.quit();
        }
    }
}
