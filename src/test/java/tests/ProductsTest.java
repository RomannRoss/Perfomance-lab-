package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CartPage;
import pages.ProductsPage;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {

    @Test
    void testAddTwoItemsToCartAndVerify() {

        new BasePage(browser).open();
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        browser.findElement(By.id("login-button")).click();

        new ProductsPage(browser).addBackpackToCart();
        browser.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        browser.findElement(By.className("shopping_cart_link")).click();

        CartPage cart = new CartPage(browser);

        assertEquals(cart.getBadgeCount(), "2", "Должно быть 2 товара!");
        ArrayList<String> items = cart.getProductNames();

        assertTrue(items.contains("Sauce Labs Backpack"), "Должен быть рюкзак!");
        assertTrue(items.contains("Sauce Labs Bike Light"), "Должен быть фонарик!");
        assertEquals(items.size(), 2, "Должно быть ровно 2 товара!");
    }
}
