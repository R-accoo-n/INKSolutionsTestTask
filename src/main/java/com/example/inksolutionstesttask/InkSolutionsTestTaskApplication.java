package com.example.inksolutionstesttask;

import com.example.inksolutionstesttask.entity.Category;
import com.example.inksolutionstesttask.entity.Product;
import com.example.inksolutionstesttask.entity.ShoppingCart;
import com.example.inksolutionstesttask.service.OrderService;
import com.example.inksolutionstesttask.service.ShoppingCartService;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InkSolutionsTestTaskApplication {

    public static void main(String[] args) {
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        OrderService orderService = new OrderService();

        Map<Category, List<Product>> shoppingList = new EnumMap<>(Category.class);

        Product p1 = new Product("Tea", BigDecimal.valueOf(5.3), 2, Category.DRINKS);
        Product p2 = new Product("Coffee", BigDecimal.valueOf(3.5), 2, Category.DRINKS);
        Product p3 = new Product("Cheese", BigDecimal.valueOf(8), 2, Category.FOOD);

        orderService.makeOrder(p1, shoppingList);
        orderService.makeOrder(p2, shoppingList);
        orderService.makeOrder(p3, shoppingList);

        ShoppingCart shoppingCart = new ShoppingCart(shoppingList);

        SpringApplication.run(InkSolutionsTestTaskApplication.class, args);

        System.out.println();
        System.out.println();
        System.out.println(shoppingCartService.calculateTotalPrice(shoppingCart));
    }

}
