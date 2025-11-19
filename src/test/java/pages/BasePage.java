package pages;

import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class BasePage {
    public WebDriver browser;
    public static final String BASE_URL = PropertyReader.getProperty("saucedemo.url");

    public BasePage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get(BASE_URL);
    }
}
