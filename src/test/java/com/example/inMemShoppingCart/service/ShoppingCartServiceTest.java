package com.example.inMemShoppingCart.service;

import com.example.inMemShoppingCart.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingCartServiceTest {

    private ShoppingCartService shoppingCartService;

    @BeforeEach
    void setUp() {
        shoppingCartService = new ShoppingCartService();
    }

    @Test
    void addsItemToCart() {
        Item carrot = new Item("carrot", "Carrot", BigDecimal.valueOf(0.49));

        shoppingCartService.addItem(carrot);

        assertThat(shoppingCartService.getEntries()).hasSize(1);
        assertThat(shoppingCartService.getTotal()).isEqualByComparingTo(BigDecimal.valueOf(0.49));
    }

    @Test
    void aggregatesQuantityWhenSameItemAddedMultipleTimes() {
        Item tomato = new Item("tomato", "Tomato", BigDecimal.valueOf(0.99));

        shoppingCartService.addItem(tomato);
        shoppingCartService.addItem(tomato);

        assertThat(shoppingCartService.getEntries()).hasSize(1);
        assertThat(shoppingCartService.getEntries().get(0).getQuantity()).isEqualTo(2);
        assertThat(shoppingCartService.getTotal()).isEqualByComparingTo(BigDecimal.valueOf(1.98));
    }

    @Test
    void clearsCart() {
        Item lettuce = new Item("lettuce", "Lettuce", BigDecimal.valueOf(1.29));

        shoppingCartService.addItem(lettuce);
        shoppingCartService.clear();

        assertThat(shoppingCartService.getEntries()).isEmpty();
        assertThat(shoppingCartService.getTotal()).isEqualByComparingTo(BigDecimal.ZERO);
    }
}
