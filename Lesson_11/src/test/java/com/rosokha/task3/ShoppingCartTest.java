package com.rosokha.task3;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    void shouldActualizeTotalPriceAfterAddingItem(){
        shoppingCart.addItem("Pasta", 20);
        assertEquals(20, shoppingCart.getTotalPrice());
    }

    @Test
    void shouldThrowExceptionForNegativePrice(){
        assertThrows(IllegalArgumentException.class, () -> {
            shoppingCart.addItem("Sugar", -12);
        });
    }

    @Test
    void shouldClearShoppingCart(){
        shoppingCart.addItem("Pasta", 20);
        shoppingCart.clear();
        assertTrue(shoppingCart.getItems().isEmpty());
        assertEquals(0.0, shoppingCart.getTotalPrice());
    }
}
