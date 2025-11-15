package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver browser;
    public static final String BASE_URL = "https://www.saucedemo.com";

    public BasePage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get(BASE_URL);
    }
}
