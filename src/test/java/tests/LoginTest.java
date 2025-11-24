package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import user.User;
import user.UserFactory;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Epic("Модуль логина интернет-магазина")
    @Feature("Авторизация")
    @Story("Позитивный и негативные сценарии входа в систему")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Roman")
    @TmsLink("Perfomance-lab-")
    @Flaky
    @Test (description = "Успешный вход под валидным пользователем")
    public void testPositiveLogin() {
        System.out.println("CorrectLogin Tests are running in thread: " + Thread.currentThread().getId());
        LoginPage loginPage = new LoginPage(browser);
        ProductsPage productsPage = new ProductsPage(browser);

        loginPage.openLoginPage();
        loginPage.login(UserFactory.withAdminPermission());

        assertTrue(productsPage.isLogoDisplayed());
        assertEquals(productsPage.getLogoText(), "Swag Labss");
    }

    @DataProvider(name = "negativeLoginData")
    public Object[][] negativeLoginData() {
        return new Object[][]{
                { UserFactory.withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {new User("", "secret_sauce"), "Epic sadface: Username is required"},
                {new User("standard_user", ""), "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "negativeLoginData", description = "Проверка обработки ошибок при невалидных учётных данных")
    public void testNegativeLogin(User user, String expectedError) {
        System.out.println("InCorrectLogin Tests are running in thread: " + Thread.currentThread().getId());
        LoginPage loginPage = new LoginPage(browser);

        loginPage.openLoginPage();
        loginPage.login(user);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), expectedError);
    }
}
