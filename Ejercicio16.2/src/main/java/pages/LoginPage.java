package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isErrorMessageDisplayed() {
        return !driver.findElements(errorMessage).isEmpty() && driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
}
