package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import user.UserFactory;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {

    @Epic("Модуль логина интернет-магазина")
    @Feature("Работа с корзиной")
    @Story("Добавление товаров в корзину и проверка счётчика")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Roman")
    @TmsLink("Perfomance-lab-")
    @Flaky
    @Test(description = "Проверка добавления двух товаров в корзину и корректного отображения счётчика")
    public void checkGoodsAdded() {
        System.out.println("Products Tests are running in thread: " + Thread.currentThread().getId());

        CartPage cart = new LoginPage(browser)
                .openLoginPage()
                .login(UserFactory.withAdminPermission())
                .addBackpackToCart()
                .addTShirtRedToCart()
                .openCart();

        assertEquals(cart.getBadgeCount(), "2");
        ArrayList<String> items = cart.getProductNames();
        assertTrue(items.contains("Sauce Labs Backpack"));
        assertTrue(items.contains("Test.allTheThings() T-Shirt (Red)"));
        assertEquals(items.size(), 2);
    }
}
