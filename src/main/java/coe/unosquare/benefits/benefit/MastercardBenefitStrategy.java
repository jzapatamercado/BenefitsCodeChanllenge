package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class MastercardBenefitStrategy implements BenefitStrategy {
    @Override
    public Double calculateBenefit(Map<Product, Integer> products) {
        double discount = 0.08;
        if (criteriaEvaluation(products, new ConditionAttributes(100.0))) {
            discount = 0.17;
        } else if (criteriaEvaluation(products, new ConditionAttributes(75.0))) {
            discount = 0.12;
        }
        return discount;
    }

    @Override
    public Boolean criteriaEvaluation(Map<Product, Integer> products, ConditionAttributes limit) {
        return ConditionValidator.amountValidation(products,limit.amount);
    }
}
