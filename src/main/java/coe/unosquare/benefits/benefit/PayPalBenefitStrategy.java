package coe.unosquare.benefits.benefit;

import coe.unosquare.benefits.product.Product;

import java.util.Calendar;
import java.util.Map;

public class PayPalBenefitStrategy implements BenefitStrategy {
    private  Calendar cal = Calendar.getInstance();

    @Override
    public Double calculateBenefit(Map<Product, Integer> products) {
        double discount = 0;
        if (criteriaEvaluation(products, new ConditionAttributes(10, 100.0))) {
            discount = 0.25;
        } 
        return discount;
    }

    @Override
    public Boolean criteriaEvaluation(Map<Product, Integer> products, ConditionAttributes limit) {
        return ConditionValidator.quantityValidation(products,limit.quantity) || ConditionValidator.amountValidation(products,limit.amount);
    }
}
