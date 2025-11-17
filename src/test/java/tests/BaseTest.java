package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver browser;

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browserName) {

        if ("edge".equalsIgnoreCase(browserName)) {
            WebDriverManager.edgedriver().setup();
            browser = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            browser = new ChromeDriver();
        }

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
