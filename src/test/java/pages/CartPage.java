package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public By cartBadge = By.className("shopping_cart_badge");
    public By itemNames = By.className("inventory_item_name");

    public CartPage(WebDriver browser) {
        super(browser);
    }

    @Step("Количество товаров в корзине: {count}")
    public String getBadgeCount() {
        return browser.findElements(cartBadge).isEmpty()
                ? "0"
                : browser.findElement(cartBadge).getText();
    }

    @Step("Получить названия товаров в корзине: {names}")
    public ArrayList<String> getProductNames() {
        List<WebElement> elements = browser.findElements(itemNames);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement el : elements) {
            names.add(el.getText());
        }

        return names;
    }
}
