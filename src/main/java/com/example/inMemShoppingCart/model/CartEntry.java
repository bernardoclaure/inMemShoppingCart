package com.example.inMemShoppingCart.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CartEntry {

    private final String itemId;
    private final String name;
    private final BigDecimal unitPrice;
    private int quantity;

    public CartEntry(String itemId, String name, BigDecimal unitPrice, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public BigDecimal getLineTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntry cartEntry = (CartEntry) o;
        return Objects.equals(itemId, cartEntry.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }
}
