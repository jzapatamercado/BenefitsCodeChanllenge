package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public interface BenefitStrategy {
    Double calculateBenefit(Map<Product, Integer> products);
    Boolean criteriaEvaluation(Map<Product, Integer> products, Integer limit);
}
