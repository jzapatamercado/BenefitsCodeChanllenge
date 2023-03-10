/*
 *  ProductGenerator
 *  1.0
 *  11/8/22, 8:30 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util;

import coe.unosquare.benefits.model.Product;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * The type Product generator.
 */
public final class ProductGenerator {

    /**
     * Hide constructor to avoid instances of this utility class.
     */
    private ProductGenerator() {
    }

    /**
     * Generate products map.
     *
     * @param expectedSize the expected size of the map which matches                     the number of different products in the cart.
     * @return the map
     */
    public static Map<Product, Integer> generateProducts(final int expectedSize) {
        HashMap<Product, Integer> products = new HashMap<>();
        IntStream.rangeClosed(1, expectedSize).forEach(id -> {
            products.put(new Product("Product " + id, //product name
                            Double.parseDouble(new DecimalFormat("0.00")
                                    .format(new Random().nextDouble() * 10.00)), //price
                            new Random().nextInt(3) + 1), //type
                    1); //quantity
        });
        return products;
    }

    /**
     * Generate products map.
     *
     * @param expectedTotal the expected total amount to pay for the order before discount
     * @return the map Last Modification: Juan Zapata Date: 2023-02-10 Modification: It was required to force the method to generate scenarios with the exact expectedTotal value
     */
    public static Map<Product, Integer> generateProducts(final double expectedTotal) {
        HashMap<Product, Integer> products = new HashMap<>();
        double total = 0.0;
        int id = 1;
        while (total < expectedTotal) {
            double price = Double.parseDouble(new DecimalFormat("0.00")
                    .format(new Random().nextDouble() * 10.00));
            int quantity = new Random().nextInt(5) + 1;
            price = priceAdjustment(price, total, quantity, expectedTotal);
            products.put(new Product("Product " + id, //product name
                            price,
                            new Random().nextInt(3) + 1), //type
                    quantity); //quantity
            total = total + price * quantity;
            id++;
        }
        return products;
    }


    /**
     * Generate products map.
     *
     * @param expectedTotal the expected total
     * @param expectedSize  the expected size
     * @return the map
     */
    public static Map<Product, Integer> generateProducts(final Double expectedTotal, final Integer expectedSize) {
        HashMap<Product, Integer> products = new HashMap<>();
        double total = 0.0;
        int count = 0;
        int id = 1;
        while (total < expectedTotal && count < expectedSize) {
            double price = Double.parseDouble(new DecimalFormat("0.00")
                    .format(expectedTotal / expectedSize));
            int quantity = expectedSize;
            price = priceAdjustment(price, total, quantity, expectedTotal);
            products.put(new Product("Product " + id, //product name
                            price,
                            new Random().nextInt(3) + 1), //type
                    quantity); //quantity
            total = total + price * quantity;
            count += quantity;
            id++;
        }
        return products;
    }

    /**
     * Adjust the product price to be within the required test conditions.
     *
     * @param price    the expected total
     * @param quantity the expected size
     * @return the map
     */
    private static double priceAdjustment(double price, double total, int quantity, double expectedTotal) {
        if ((total + price * quantity) > total) {
            price = (expectedTotal - total) / quantity;
        }
        return price;
    }
}
