package com.example.inMemShoppingCart.service;

import com.example.inMemShoppingCart.model.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatalogService {

    private final Map<String, Item> catalog;

    public CatalogService() {
        Map<String, Item> items = new LinkedHashMap<>();
        items.put("carrot", new Item("carrot", "Carrot", BigDecimal.valueOf(0.49)));
        items.put("lettuce", new Item("lettuce", "Lettuce", BigDecimal.valueOf(1.29)));
        items.put("tomato", new Item("tomato", "Tomato", BigDecimal.valueOf(0.99)));
        items.put("potato", new Item("potato", "Potato", BigDecimal.valueOf(0.79)));
        items.put("broccoli", new Item("broccoli", "Broccoli", BigDecimal.valueOf(1.49)));
        this.catalog = Collections.unmodifiableMap(items);
    }

    public List<Item> getItems() {
        return List.copyOf(catalog.values());
    }

    public Item findById(String id) {
        return catalog.get(id);
    }
}
