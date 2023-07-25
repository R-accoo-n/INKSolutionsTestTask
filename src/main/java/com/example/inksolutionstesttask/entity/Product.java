package com.example.inksolutionstesttask.entity;

import java.math.BigDecimal;

public record Product(String name, BigDecimal pricePerUnit, int quantity, Category category) {

    @Override
    public String toString() {
        return "Product{" +
            "name='" + name + '\'' +
            ", pricePerUnit=" + pricePerUnit +
            ", quantity=" + quantity +
            ", category=" + category +
            '}';
    }
}