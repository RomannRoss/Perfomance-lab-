package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public By usernameField = By.id("user-name");
    public By passwordField = By.id("password");
    public By loginButton = By.id("login-button");
    public By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void openLoginPage() {
        open();
    }

    public void enterUsername(String username) {
        browser.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        browser.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        browser.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isErrorDisplayed() {
        return !browser.findElements(errorMessage).isEmpty();
    }

    public String getErrorText() {
        return browser.findElement(errorMessage).getText();
    }
}
