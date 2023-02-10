/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util.payment;

import coe.unosquare.benefits.constants.ExceptionMessage;
import coe.unosquare.benefits.exception.InvalidAmountException;
import coe.unosquare.benefits.exception.InvalidQuantityException;
import coe.unosquare.benefits.model.Order;
import coe.unosquare.benefits.model.Product;
import coe.unosquare.benefits.util.condition.ConditionValidator;
import coe.unosquare.benefits.util.discount.Discount;

import java.util.Map;

/**
 * The type Order.
 * This class is oriented only to obtain the subtotal and the total after discounts.
 */
public class PaymentCalculation {


    /**
     * Instantiates a new Payment calculation.
     */
    private PaymentCalculation() {
    }

    /**
     * Pay double.
     *
     * @param order       the order
     * @param paymentType the payment type
     * @return the double
     * @throws InvalidQuantityException the invalid quantity exception
     * @throws InvalidAmountException   the invalid amount exception
     */
    public static double pay(final Order order, final String paymentType) throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = order.getProducts();
        minimalConstraintVerification(products);
        double discount = 0;
        discount = Discount.getDiscount(products, paymentType);
        double subtotal = getSubTotal(products);
        return subtotal - subtotal * discount;
    }

    private static void minimalConstraintVerification(Map<Product, Integer> products) throws InvalidAmountException, InvalidQuantityException {
        if (!ConditionValidator.amountValidation(products, 0.01)) {
            throw new InvalidAmountException(ExceptionMessage.INVALID_AMOUNT);
        }
        if (!ConditionValidator.quantityValidation(products, 1)) {
            throw new InvalidQuantityException(ExceptionMessage.INVALID_QUANTITY);
        }
    }

    public static double getSubTotal(Map<Product, Integer> products) {
        return products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
    }

}
