package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    private final WebDriver driver;
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        String xpath = String.format("//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']//button", productName);
        driver.findElement(By.xpath(xpath)).click();
    }

    public int getCartItemCount() {
        List<WebElement> badges = driver.findElements(cartBadge);
        if (badges.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(badges.get(0).getText());
    }

    public boolean isTextDisplayed(String text) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]") );
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public String getProductButtonText(String productName) {
        String xpath = String.format("//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']//button", productName);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    public boolean isProductInCart(String productName) {
        return !driver.findElements(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']")).isEmpty();
    }
}
