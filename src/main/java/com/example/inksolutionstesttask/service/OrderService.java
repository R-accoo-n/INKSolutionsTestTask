package com.example.inksolutionstesttask.service;

import com.example.inksolutionstesttask.entity.Category;
import com.example.inksolutionstesttask.entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    public void makeOrder(Product product, Map<Category, List<Product>> shoppingList){
        List<Product> temp = shoppingList.get(product.category()) == null ? new ArrayList<>() : shoppingList.get(product.category());
        temp.add(product);
        product.category().setTotalQuantityPerCategory(product.category().getTotalQuantityPerCategory() + product.quantity());
        shoppingList.put(product.category(), temp);
    }
}
