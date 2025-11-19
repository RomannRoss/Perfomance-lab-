package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By addTShirtBtn = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By cartLink = By.className("shopping_cart_link");
    private By logo = By.className("app_logo");

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    public boolean isLogoDisplayed() {
        return !browser.findElements(logo).isEmpty();
    }

    public String getLogoText() {
        return browser.findElement(logo).getText();
    }

    public ProductsPage addBackpackToCart() {
        browser.findElement(addBackpackBtn).click();
        return this;
    }

    public ProductsPage addTShirtRedToCart() {
        browser.findElement(addTShirtBtn).click();
        return this;
    }

    public CartPage openCart() {
        browser.findElement(cartLink).click();
        return new CartPage(browser);
    }
}
