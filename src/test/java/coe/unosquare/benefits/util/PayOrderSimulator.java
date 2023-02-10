/*
 *  PayOrderSimulator
 *  1.0
 *  11/8/22, 8:29 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.util;

import coe.unosquare.benefits.exception.InvalidAmountException;
import coe.unosquare.benefits.exception.InvalidQuantityException;
import coe.unosquare.benefits.model.Order;
import coe.unosquare.benefits.model.Product;
import coe.unosquare.benefits.util.payment.PaymentCalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * The type Pay order simulator.
 */
public final class PayOrderSimulator {
    private PayOrderSimulator() {
    }

    /**
     * Pay order double.
     *
     * @param products    the products
     * @param paymentType the payment type
     * @return the double
     * @throws InvalidQuantityException the invalid quantity exception
     * @throws InvalidAmountException   the invalid amount exception
     */
    public static double payOrder(final Map<Product, Integer> products,
                                  final String paymentType) throws InvalidQuantityException, InvalidAmountException {
        Order order = new Order(products);
        double subtotal = PaymentCalculation.getSubTotal(order.getProducts());
        double total = new BigDecimal((subtotal - PaymentCalculation.pay(order, paymentType)) / subtotal)
                .setScale(2, RoundingMode.HALF_EVEN)
                .doubleValue();
        order.print();
        return total;
    }
}

