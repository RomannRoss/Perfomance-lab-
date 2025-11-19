package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public LoginPage openLoginPage() {
        open();
        return this;
    }

    public ProductsPage login(User user) {
        enterUsername(user.getEmail());
        enterPassword(user.getPassword());
        clickLogin();
        return new ProductsPage(browser);
    }

    private void enterUsername(String username) {
        browser.findElement(usernameField).sendKeys(username);
    }

    private void enterPassword(String password) {
        browser.findElement(passwordField).sendKeys(password);
    }

    private void clickLogin() {
        browser.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        return !browser.findElements(errorMessage).isEmpty();
    }

    public String getErrorText() {
        return browser.findElement(errorMessage).getText();
    }
}
