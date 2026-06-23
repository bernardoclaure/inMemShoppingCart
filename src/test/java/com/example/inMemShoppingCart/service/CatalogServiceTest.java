package com.example.inMemShoppingCart.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CatalogServiceTest {

    @Autowired
    private CatalogService catalogService;

    @Test
    void returnsPredeterminedCatalog() {
        List<?> items = catalogService.getItems();

        assertThat(items).hasSize(5);
    }
}
