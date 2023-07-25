package com.example.inksolutionstesttask.entity;

import java.util.List;
import java.util.Map;

public record ShoppingCart(Map<Category, List<Product>> products) {
}
