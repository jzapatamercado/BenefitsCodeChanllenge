package coe.unosquare.benefits.util.condition;

import coe.unosquare.benefits.model.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionValidatorTest {
    @Test
    void quantityValidationSameQuantities() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(51);
        assertEquals(true, ConditionValidator.quantityValidation(products, 51));
    }

    @Test
    void quantityValidationLessThanQuantity() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(15);
        assertEquals(false, ConditionValidator.quantityValidation(products, 51));
    }

    @Test
    void quantityValidationGreaterThanQuantity() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(51);
        assertEquals(true, ConditionValidator.quantityValidation(products, 15));
    }


    @Test
    void amountValidationSameAmounts() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(500.0);
        assertEquals(true, ConditionValidator.amountValidation(products, 500.0));
    }

    @Test
    void amountValidationLessThanLimitAmount() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(50.0);
        assertEquals(false, ConditionValidator.amountValidation(products, 500.0));
    }

    @Test
    void amountValidationGreaterThanLimitAmount() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(500.0);
        assertEquals(true, ConditionValidator.amountValidation(products, 50.0));
    }
}
