/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util.payment;

import coe.unosquare.benefits.constants.ExceptionMessage;
import coe.unosquare.benefits.model.Order;
import coe.unosquare.benefits.util.benefit.ConditionValidator;
import coe.unosquare.benefits.util.discount.Discount;
import coe.unosquare.benefits.exception.InvalidAmountException;
import coe.unosquare.benefits.exception.InvalidQuantityException;
import coe.unosquare.benefits.model.Product;

import java.util.Map;

/**
 * The type Order.
 */
public class PaymentCalculation {


    /**
     * Instantiates a new Payment calculation.
     */
    private PaymentCalculation() {}

    /**
     * Pay double.
     *
     * @param order       the order
     * @param paymentType the payment type
     * @return the double
     * @throws InvalidQuantityException the invalid quantity exception
     * @throws InvalidAmountException   the invalid amount exception
     */
    public static Double pay(final Order order, final String paymentType) throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = order.getProducts();
        if (!ConditionValidator.amountValidation(products, 0.01)) {
            throw new InvalidAmountException(ExceptionMessage.INVALID_AMOUNT);
        }
        if (!ConditionValidator.quantityValidation(products, 1)) {
            throw new InvalidQuantityException(ExceptionMessage.INVALID_QUANTITY);
        }
        double discount = 0;
        discount = Discount.getDiscount(products, paymentType);
        double subtotal = getSubTotal(products);
        return subtotal - subtotal * discount;
    }

    private static Double getSubTotal(Map<Product, Integer> products) {
        return products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
    }

}
