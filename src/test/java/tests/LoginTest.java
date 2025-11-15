package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void testPositiveLogin() {
        LoginPage loginPage = new LoginPage(browser);
        ProductsPage productsPage = new ProductsPage(browser);

        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isLogoDisplayed(), "Логотип не отображается");
        assertEquals(productsPage.getLogoText(), "Swag Labs", "Неправильный текст логотипа");
    }

    @DataProvider(name = "negativeLoginData")
    public Object[][] negativeLoginData() {
        return new Object[][]{
                {"wrong_user", "wrong_pass", "Epic sadface: Username and password do not match"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "negativeLoginData")
    public void testNegativeLogin(String username, String password, String expectedError) {
        LoginPage loginPage = new LoginPage(browser);

        loginPage.openLoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        assertTrue(loginPage.isErrorDisplayed(), "Ошибка не отображается");
        assertTrue(loginPage.getErrorText().contains(expectedError), "Неправильный текст ошибки");
    }
}
