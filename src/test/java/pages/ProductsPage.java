package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    public By logo = By.className("app_logo");

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    public void addBackpackToCart() {
        browser.findElement(addToCartButton).click();
    }

    public boolean isLogoDisplayed() {
        return !browser.findElements(logo).isEmpty();
    }

    public String getLogoText() {
        return browser.findElement(logo).getText();
    }
}
