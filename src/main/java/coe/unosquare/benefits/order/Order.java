/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.discount.Discount;
import coe.unosquare.benefits.exception.InvalidAmountException;
import coe.unosquare.benefits.exception.InvalidQuantityException;
import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * The type Order.
 */
public class Order {
    /**
     * Store the final list of products and quantity for each product.
     **/
    private final Map<Product, Integer> products;

    /**
     * Instantiates a new Order.
     *
     * @param productsMap the list of products added to the order
     */
    public Order(final Map<Product, Integer> productsMap) {
        products = productsMap;
    }

    /**
     * Pay double.
     *
     * @param paymentType the payment type
     * @return the double
     * @throws InvalidQuantityException the invalid quantity exception
     * @throws InvalidAmountException   the invalid amount exception
     */
    public Double pay(final String paymentType) throws InvalidQuantityException, InvalidAmountException {
        double discount = 0;
        discount = Discount.getDiscount(products, paymentType);
        double subtotal = getSubTotal();
        return subtotal - subtotal * discount;
    }

    private Double getSubTotal() {
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
