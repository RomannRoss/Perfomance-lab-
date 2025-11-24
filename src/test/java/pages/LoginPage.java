package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    @Step("Открыть страницу входа")
    public LoginPage openLoginPage() {
        open();
        return this;
    }

    @Step("Ввести логин: {username}")
    public LoginPage enterUsername(String username) {
        browser.findElement(usernameField).sendKeys(username);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage enterPassword(String password) {
        browser.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Нажать кнопку 'Login'")
    public ProductsPage clickLoginButton() {
        browser.findElement(loginButton).click();
        return new ProductsPage(browser);
    }

    @Step("Выполнить вход под пользователем {user.email}")
    public ProductsPage login(User user) {
        enterUsername(user.getEmail());
        enterPassword(user.getPassword());
        return clickLoginButton();
    }

    @Step("Проверить отображение ошибки входа")
    public boolean isErrorDisplayed() {
        return !browser.findElements(errorMessage).isEmpty();
    }

    @Step("Получить текст ошибки")
    public String getErrorText() {
        return browser.findElement(errorMessage).getText();
    }
}
