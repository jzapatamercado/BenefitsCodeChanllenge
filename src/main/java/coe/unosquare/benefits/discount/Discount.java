package coe.unosquare.benefits.discount;

import coe.unosquare.benefits.benefit.*;
import coe.unosquare.benefits.constants.PaymentTypeConstants;
import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class Discount {
    public static double getDiscount(Map<Product, Integer> products, String paymentType){
        BenefitStrategy benefitStrategy;
        switch(paymentType){
            case PaymentTypeConstants.PAYPAL: {
                benefitStrategy = new PayPalBenefitStrategy();
                break;
            }
            case PaymentTypeConstants.VISA: {
                benefitStrategy = new VisaBenefitStrategy();
                break;
            }
            case PaymentTypeConstants.MASTERCARD:{
                benefitStrategy = new MastercardBenefitStrategy();
                break;
            }
            default: {
                benefitStrategy = new NonBenefitStrategy();
            }
        }
        return benefitStrategy.calculateBenefit(products);
    }
}
