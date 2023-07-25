package com.example.inksolutionstesttask;

import com.example.inksolutionstesttask.entity.Category;
import com.example.inksolutionstesttask.entity.Product;
import com.example.inksolutionstesttask.entity.ShoppingCart;
import com.example.inksolutionstesttask.service.OrderService;
import com.example.inksolutionstesttask.service.ShoppingCartService;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InkSolutionsTestTaskApplicationTests {
    private final ShoppingCartService service = new ShoppingCartService();
    private final OrderService orderService = new OrderService();

    @BeforeEach
    public void setup(){
        Category.DRINKS.setTotalQuantityPerCategory(0);
        Category.FOOD.setTotalQuantityPerCategory(0);
        ShoppingCartService.setDiscountAmountInPercents(10);
        ShoppingCartService.setMinTotalAmountToGetDiscount(4);
    }


    @Test
    public void calculatesPriceFirstExample()  {
        Map<Category, List<Product>> shoppingList = new EnumMap<>(Category.class);
        Product p1 = new Product("Tea", BigDecimal.valueOf(5), 2, Category.DRINKS);
        Product p2 = new Product("Coffee", BigDecimal.valueOf(6.5), 1, Category.DRINKS);

        orderService.makeOrder(p1, shoppingList);
        orderService.makeOrder(p2, shoppingList);

        ShoppingCart shoppingCart = new ShoppingCart(shoppingList);

        BigDecimal result = service.calculateTotalPrice(shoppingCart);

        Assertions.assertEquals(result, BigDecimal.valueOf(16.5));
    }

    @Test
    public void calculatesPriceSecondExample()  {
        Map<Category, List<Product>> shoppingList = new EnumMap<>(Category.class);
        Product p1 = new Product("Tea", BigDecimal.valueOf(5), 5, Category.DRINKS);
        Product p2 = new Product("Cheese", BigDecimal.valueOf(3.5), 3, Category.FOOD);

        orderService.makeOrder(p1, shoppingList);
        orderService.makeOrder(p2, shoppingList);

        ShoppingCart shoppingCart = new ShoppingCart(shoppingList);

        BigDecimal result = service.calculateTotalPrice(shoppingCart);

        Assertions.assertEquals(result, BigDecimal.valueOf(33.0));
    }

    @Test
    public void calculatesPriceThirdExample()  {
        Map<Category, List<Product>> shoppingList = new EnumMap<>(Category.class);
        Product p1 = new Product("Tea", BigDecimal.valueOf(5.3), 2, Category.DRINKS);
        Product p2 = new Product("Coffee", BigDecimal.valueOf(3.5), 2, Category.DRINKS);
        Product p3 = new Product("Cheese", BigDecimal.valueOf(8), 2, Category.FOOD);

        orderService.makeOrder(p1, shoppingList);
        orderService.makeOrder(p2, shoppingList);
        orderService.makeOrder(p3, shoppingList);

        ShoppingCart shoppingCart = new ShoppingCart(shoppingList);

        BigDecimal result = service.calculateTotalPrice(shoppingCart);

        Assertions.assertEquals(result, BigDecimal.valueOf(31.84));
    }

    @Test
    public void calculatesPriceFourthExample()  {
        Map<Category, List<Product>> shoppingList = new EnumMap<>(Category.class);
        Product p1 = new Product("Tea", BigDecimal.valueOf(5.3), 2, Category.DRINKS);
        Product p2 = new Product("Coffee", BigDecimal.valueOf(3.5), 2, Category.DRINKS);
        Product p3 = new Product("Cheese", BigDecimal.valueOf(8), 2, Category.FOOD);

        orderService.makeOrder(p1, shoppingList);
        orderService.makeOrder(p2, shoppingList);
        orderService.makeOrder(p3, shoppingList);

        ShoppingCart shoppingCart = new ShoppingCart(shoppingList);

        ShoppingCartService.setDiscountAmountInPercents(20);

        BigDecimal result = service.calculateTotalPrice(shoppingCart);

        Assertions.assertEquals(result, BigDecimal.valueOf(30.08));
    }

}
