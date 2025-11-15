package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private By cartBadge = By.className("shopping_cart_badge");
    private By itemNames = By.className("inventory_item_name");

    public ArrayList<String> getProductNames() {
        List<WebElement> elements = browser.findElements(itemNames);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement el : elements) {
            names.add(el.getText());
        }

        return names;
    }

    public CartPage(WebDriver browser) {
        super(browser);
    }

    public String getBadgeCount() {
        return browser.findElements(cartBadge).isEmpty() ? "0" : browser.findElement(cartBadge).getText();
    }
}
