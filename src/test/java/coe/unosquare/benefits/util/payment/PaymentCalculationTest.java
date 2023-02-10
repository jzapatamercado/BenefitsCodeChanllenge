package coe.unosquare.benefits.util.payment;

import coe.unosquare.benefits.model.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentCalculationTest {
    @Test
    void getSubTotalTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(500.0);
        assertEquals(500.0, PaymentCalculation.getSubTotal(products));
    }

    @Test
    void getSubTotalTest2() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(325.0);
        assertEquals(325, PaymentCalculation.getSubTotal(products));
    }
}
