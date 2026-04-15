package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    public void anadirUnProductoAlCarrito() {
        loginPage.loginAs("standard_user", "secret_sauce");
        assertTrue(driver.getCurrentUrl().contains("/inventory"));

        inventoryPage.addProductToCart("Sauce Labs Backpack");
        assertEquals(1, inventoryPage.getCartItemCount(), "El carrito debe mostrar un contador igual a 1");
    }

    @Test
    public void anadirDosProductosAlCarrito() {
        loginPage.loginAs("standard_user", "secret_sauce");
        assertTrue(driver.getCurrentUrl().contains("/inventory"));

        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");
        assertEquals(2, inventoryPage.getCartItemCount(), "El carrito debe mostrar un contador igual a 2");
    }

    @Test
    public void botonCambiaTrasAnadirProducto() {
        loginPage.loginAs("standard_user", "secret_sauce");
        assertTrue(driver.getCurrentUrl().contains("/inventory"));

        String antes = inventoryPage.getProductButtonText("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        String despues = inventoryPage.getProductButtonText("Sauce Labs Backpack");

        assertEquals("Add to cart", antes, "El botón inicial debe ser 'Add to cart'");
        assertEquals("Remove", despues, "El botón debe cambiar a 'Remove' tras añadir el producto al carrito");
    }

    @Test
    public void carritoMuestraProducto() {
        loginPage.loginAs("standard_user", "secret_sauce");
        assertTrue(driver.getCurrentUrl().contains("/inventory"));

        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.openCart();
        assertTrue(inventoryPage.isProductInCart("Sauce Labs Backpack"), "El carrito debe incluir el producto agregado");
    }
}
