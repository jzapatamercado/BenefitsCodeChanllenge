/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;
import java.util.Map;

/**
 * The type Order.
 */
public class Order {
    /** Store the final list of products and quantity for each product. **/
    private final Map<Product, Integer> products;

    /**
     * Instantiates a new Order.
     *
     * @param productsMap the list of products added to the order
     */
    public Order(final Map<Product, Integer> productsMap) {
        products = productsMap;
    }

    private Boolean quantityVerification(int limit) {
        return products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= limit;
    }

    private Boolean amountVerification(int amount) {
        return products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum() >= 100;
    }
    /**
     * Pay double.
     *
     * @param paymentType the payment type
     * @return the double
     */
    public double pay(final String paymentType) {
        double discount = 0.0;
        switch(paymentType){
            case "Visa": {
                discount = quantityBasedDiscount();
                break;
            }
            case "Mastercard":{
                discount = amountBasedDiscount();
                break;
            }
            default: {
                discount = 0.0;
                }
        }
        double subtotal = getSubTotal();
        return subtotal - subtotal * discount;
    }

    private double quantityBasedDiscount() {
        double discount = 0.05;
        if (quantityVerification(10)) {
            discount = 0.15;
        } else if (quantityVerification(7)) {
            discount = 0.10;
        }
        return discount;
    }

    private double amountBasedDiscount() {
        double discount = 0.08;
        if (amountVerification(100)) {
            discount = 0.17;
        } else if (amountVerification(75)) {
            discount = 0.12;
        }
        return discount;
    }

    private Double getSubTotal(){
        return products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
    }

    /**
     * Print.
     */
    public void print() {
         products.forEach((product, quantity) ->
                 System.out.println("Product:{" + product.getName() + ","
                         + product.getPrice() + ","
                         + product.getType()
                         + "},Quantity:" + quantity
                         + ",Total:" + product.getPrice() * quantity));
    }
}
