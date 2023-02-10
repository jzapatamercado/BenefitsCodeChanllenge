package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class ConditionValidator {
    public static Boolean amountValidation(Map<Product, Integer> products, Double limit){
        Double amount = products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
        System.out.println("amount "+amount);
        return  amount >= limit;
    }

    public static Boolean quantityValidation(Map<Product, Integer> products, Integer limit){
        Integer qty = products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity);
        System.out.println("qty "+qty);
        return  qty >= limit;
    }

}
