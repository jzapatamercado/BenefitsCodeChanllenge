package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class QuantityBenefitStrategy implements BenefitStrategy{
    @Override
    public Double calculateBenefit(Map<Product, Integer> products) {
        double discount = 0.05;
        if (criteriaEvaluation(products, 10)) {
            discount = 0.15;
        } else if (criteriaEvaluation(products, 7)) {
            discount = 0.10;
        }
        return discount;
    }

    @Override
    public Boolean criteriaEvaluation(Map<Product, Integer> products, Integer limit) {
        return products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= limit;
    }
}
