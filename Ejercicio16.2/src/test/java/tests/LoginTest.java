package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void loginCorrecto() {
        loginPage.loginAs("standard_user", "secret_sauce");
        assertTrue(driver.getCurrentUrl().contains("/inventory"), "La URL debe contener /inventory tras el login correcto");
    }

    @Test
    public void loginIncorrecto() {
        loginPage.loginAs("standard_user", "wrong_password");
        assertTrue(loginPage.isErrorMessageDisplayed(), "Debe mostrarse un mensaje de error cuando la contraseña es incorrecta");
        assertTrue(loginPage.getErrorMessageText().contains("Epic sadface"), "El mensaje de error debe contener 'Epic sadface'");
    }
}
