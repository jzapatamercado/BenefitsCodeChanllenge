package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class AmountBenefitStrategy implements BenefitStrategy{
    @Override
    public Double calculateBenefit(Map<Product, Integer> products) {
        double discount = 0.08;
        if (criteriaEvaluation(products, 100)) {
            discount = 0.17;
        } else if (criteriaEvaluation(products, 75)) {
            discount = 0.12;
        }
        return discount;
    }

    @Override
    public Boolean criteriaEvaluation(Map<Product, Integer> products, Integer limit) {
        return products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum() >= limit;
    }
}
