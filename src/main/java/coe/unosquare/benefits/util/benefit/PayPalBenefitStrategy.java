package coe.unosquare.benefits.util.benefit;

import coe.unosquare.benefits.model.ConditionAttributes;
import coe.unosquare.benefits.model.Product;
import coe.unosquare.benefits.util.condition.ConditionValidator;

import java.util.Calendar;
import java.util.Map;

/**
 * The type PayPal benefit strategy.
 * Apart from Visa (quantity related) and Mastercard (amount related) payment benefits
 * it has been included this Mechanism that is evaluating if the order contains
 * OR 10+ products
 * OR 100+ as total cost
 */
public class PayPalBenefitStrategy implements BenefitStrategy {
    private Calendar cal = Calendar.getInstance();

    @Override
    public Double calculateBenefit(Map<Product, Integer> products) {
        double discount = 0;
        if (criteriaEvaluation(products, new ConditionAttributes(10, 100.0))) {
            discount = 0.25;
        }
        return discount;
    }

    @Override
    public boolean criteriaEvaluation(Map<Product, Integer> products, ConditionAttributes attributes) {
        return ConditionValidator.quantityValidation(products, attributes.getQuantity()) || ConditionValidator.amountValidation(products, attributes.getAmount());
    }
}
