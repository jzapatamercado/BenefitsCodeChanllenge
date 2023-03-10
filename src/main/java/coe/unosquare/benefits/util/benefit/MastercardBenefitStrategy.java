package coe.unosquare.benefits.util.benefit;

import coe.unosquare.benefits.model.ConditionAttributes;
import coe.unosquare.benefits.model.Product;
import coe.unosquare.benefits.util.condition.ConditionValidator;

import java.util.Map;

/**
 * The type Mastercard benefit strategy.
 */
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
    public boolean criteriaEvaluation(Map<Product, Integer> products, ConditionAttributes attributes) {
        return ConditionValidator.amountValidation(products, attributes.getAmount());
    }
}
