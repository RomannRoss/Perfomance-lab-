package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver browser;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void close() {
        if (browser != null) {
            browser.quit();
        }
    }
}
