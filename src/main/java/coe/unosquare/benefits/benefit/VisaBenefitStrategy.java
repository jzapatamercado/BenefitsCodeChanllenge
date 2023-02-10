package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * The type Visa benefit strategy.
 */
public class VisaBenefitStrategy implements BenefitStrategy {
    @Override
    public Double calculateBenefit(Map<Product, Integer> products) {
        double discount = 0.05;
        if (criteriaEvaluation(products, new ConditionAttributes(10))) {
            discount = 0.15;
        } else if (criteriaEvaluation(products, new ConditionAttributes(7))) {
            discount = 0.10;
        }
        return discount;
    }

    @Override
    public Boolean criteriaEvaluation(Map<Product, Integer> products, ConditionAttributes limit) {
        return ConditionValidator.quantityValidation(products,limit.quantity);
    }
}
