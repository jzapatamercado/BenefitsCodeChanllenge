package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * The interface Benefit strategy.
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
     * @param products the products
     * @param limits   the limits
     * @return the boolean
     */
    Boolean criteriaEvaluation(Map<Product, Integer> products, ConditionAttributes limits);
}
