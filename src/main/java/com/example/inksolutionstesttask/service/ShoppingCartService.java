package com.example.inksolutionstesttask.service;

import com.example.inksolutionstesttask.entity.ShoppingCart;
import java.math.BigDecimal;

public class ShoppingCartService {
    private static double discountAmountInPercents = 10;
    private static int minTotalAmountToGetDiscount = 4;

    public static double getDiscountAmountInPercents() {
        return discountAmountInPercents;
    }

    public static void setDiscountAmountInPercents(double discountAmountInPercents) {
        ShoppingCartService.discountAmountInPercents = discountAmountInPercents;
    }

    public static int getMinTotalAmountToGetDiscount() {
        return minTotalAmountToGetDiscount;
    }

    public static void setMinTotalAmountToGetDiscount(int minTotalAmountToGetDiscount) {
        ShoppingCartService.minTotalAmountToGetDiscount = minTotalAmountToGetDiscount;
    }

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.products().values()
            .stream()
            .map(products -> products
                .stream()
                .map(product -> product.category().getTotalQuantityPerCategory() >= getMinTotalAmountToGetDiscount()
                    ? product.pricePerUnit().multiply(BigDecimal.valueOf(product.quantity()))
                    .multiply(BigDecimal.valueOf(1 - getDiscountAmountInPercents() / 100))
                    : product.pricePerUnit().multiply(BigDecimal.valueOf(product.quantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO))
            .reduce(BigDecimal::add)
            .orElse(BigDecimal.ZERO);
    }
}
