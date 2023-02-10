package coe.unosquare.benefits.util.benefit;

import coe.unosquare.benefits.model.ConditionAttributes;
import coe.unosquare.benefits.model.Product;

import java.util.Map;

/**
 * The interface Benefit strategy.
 * Strategy pattern added to be able to handle the different payment methods with the respective benefit.
 */
public interface BenefitStrategy {
    /**
     * Calculate benefit double.
     *
     * @param products the products
     * @return the double
     */
    Double calculateBenefit(Map<Product, Integer> products);

    /**
     * Criteria evaluation boolean.
     *
     * @param products   the products
     * @param attributes the attributes
     * @return the boolean
     */
    boolean criteriaEvaluation(Map<Product, Integer> products, ConditionAttributes attributes);
}
