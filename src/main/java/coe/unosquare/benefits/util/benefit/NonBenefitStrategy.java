package coe.unosquare.benefits.util.benefit;

import coe.unosquare.benefits.model.ConditionAttributes;
import coe.unosquare.benefits.model.Product;

import java.util.Map;

/**
 * The type Non benefit strategy.
 */
public class NonBenefitStrategy implements BenefitStrategy {
    @Override
    public Double calculateBenefit(Map<Product, Integer> products) {
        return 0.0;
    }

    @Override
    public boolean criteriaEvaluation(Map<Product, Integer> products, ConditionAttributes attributes) {
        return false;
    }
}
