package com.example.inMemShoppingCart.service;

import com.example.inMemShoppingCart.model.CartEntry;
import com.example.inMemShoppingCart.model.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService {

    private final Map<String, CartEntry> entries = new LinkedHashMap<>();

    public void addItem(Item item) {
        CartEntry entry = entries.get(item.getId());
        if (entry == null) {
            entry = new CartEntry(item.getId(), item.getName(), item.getPrice(), 1);
            entries.put(item.getId(), entry);
        } else {
            entry.incrementQuantity();
        }
    }

    public List<CartEntry> getEntries() {
        return List.copyOf(entries.values());
    }

    public BigDecimal getTotal() {
        return entries.values().stream()
                .map(CartEntry::getLineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void clear() {
        entries.clear();
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }
}
