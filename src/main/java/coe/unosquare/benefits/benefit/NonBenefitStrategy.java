package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class NonBenefitStrategy implements BenefitStrategy{
    @Override
    public Double calculateBenefit(Map<Product, Integer> products) {
        return 0.0;
    }

    @Override
    public Boolean criteriaEvaluation(Map<Product, Integer> products, Integer limit) {
        return false;
    }
}
