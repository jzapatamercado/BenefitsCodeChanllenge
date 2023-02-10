/*
 *  OrderTest
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.service;

import coe.unosquare.benefits.constants.ExceptionMessage;
import coe.unosquare.benefits.constants.PaymentTypeConstant;
import coe.unosquare.benefits.exception.InvalidAmountException;
import coe.unosquare.benefits.exception.InvalidQuantityException;
import coe.unosquare.benefits.model.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {
    @Test
    void orderWithNonExistentPaymentProductsDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(51);
        assertEquals(0.15, payOrder(products, PaymentTypeConstant.VISA));
    }

    @Test
    void orderWithVisaMoreThan10ProductsDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(15);
        assertEquals(0.15, payOrder(products, PaymentTypeConstant.VISA));
    }

    @Test
    void orderWithVisa10ProductsDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(10);
        assertEquals(0.15, payOrder(products, PaymentTypeConstant.VISA));
    }

    @Test
    void orderWithVisa7ProductsDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(7);
        assertEquals(0.10, payOrder(products, PaymentTypeConstant.VISA));
    }

    @Test
    void orderWithVisaMoreThan7ProductsDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(8);
        assertEquals(0.10, payOrder(products, PaymentTypeConstant.VISA));
    }

    @Test
    void orderWithVisaLessThan7ProductsDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(5);
        assertEquals(0.05, payOrder(products, PaymentTypeConstant.VISA));
    }

    @Test
    void orderWithMastercard100AmountDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(100.0);
        assertEquals(0.17, payOrder(products, PaymentTypeConstant.MASTERCARD));
    }

    @Test
    void orderWithMastercardMoreThan100AmountDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(150.0);
        assertEquals(0.17, payOrder(products, PaymentTypeConstant.MASTERCARD));
    }

    @Test
    void orderWithMastercard75AmountDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(75.0);
        assertEquals(0.12, payOrder(products, PaymentTypeConstant.MASTERCARD));
    }

    @Test
    void orderWithMastercardMoreThan75AmountDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(80.0);
        assertEquals(0.12, payOrder(products, PaymentTypeConstant.MASTERCARD));
    }

    @Test
    void orderWithMastercardLessThan75AmountDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(50.0);
        assertEquals(0.08, payOrder(products, PaymentTypeConstant.MASTERCARD));
    }

    @Test
    void orderWithPaypalMoreThan100AmountLessThan10QuantityDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(101.0, 9);
        assertEquals(0.25, payOrder(products, PaymentTypeConstant.PAYPAL));
    }

    @Test
    void orderWithPaypalLessThan100AmountMoreThan10QuantityDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(99.0, 11);
        assertEquals(0.25, payOrder(products, PaymentTypeConstant.PAYPAL));
    }

    @Test
    void orderWithPaypalMoreThan100AmountMoreThan10QuantityDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(101.0, 11);
        assertEquals(0.25, payOrder(products, PaymentTypeConstant.PAYPAL));
    }

    @Test
    void orderWithPaypalLessThan100AmountLessThan10QuantityDiscountTest() throws InvalidQuantityException, InvalidAmountException {
        Map<Product, Integer> products = ProductGenerator.generateProducts(99.0, 9);
        assertEquals(0, payOrder(products, PaymentTypeConstant.PAYPAL));
    }

    @Test()
    void orderWithPaypal0Amount1QuantityDiscountTest_ExceptionVerification() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(0.0, 1);
        Exception exception = assertThrows(InvalidAmountException.class, () -> {
            payOrder(products, PaymentTypeConstant.PAYPAL);
        });
        assertEquals(ExceptionMessage.INVALID_AMOUNT, exception.getMessage());
    }

    @Test()
    void orderWithPaypal100Amount0QuantityDiscountTest_ExceptionVerification() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(100.0, 0);
        Exception exception = assertThrows(InvalidAmountException.class, () -> {
            payOrder(products, PaymentTypeConstant.PAYPAL);
        });
        assertEquals(ExceptionMessage.INVALID_AMOUNT, exception.getMessage());
    }


    @Test()
    void orderWithMastercard0AmountDiscountTest_ExceptionVerification() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(0.0);
        Exception exception = assertThrows(InvalidAmountException.class, () -> {
            payOrder(products, PaymentTypeConstant.MASTERCARD);
        });
        assertEquals(ExceptionMessage.INVALID_AMOUNT, exception.getMessage());
    }

    @Test()
    void orderWithVisa0QuantityDiscountTest_ExceptionVerification() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(0);
        Exception exception = assertThrows(InvalidAmountException.class, () -> {
            payOrder(products, PaymentTypeConstant.VISA);
        });
        assertEquals(ExceptionMessage.INVALID_AMOUNT, exception.getMessage());
    }

}
