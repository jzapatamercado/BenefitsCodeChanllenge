package coe.unosquare.benefits.util.discount;

import coe.unosquare.benefits.constants.PaymentTypeConstant;
import coe.unosquare.benefits.model.Product;
import coe.unosquare.benefits.util.benefit.*;

import java.util.Map;

/**
 * The type Discount.
 * This class based on the distinct BenefitPayment strategies calculates the final discount.
 */
public class Discount {
    /**
     * Gets discount.
     *
     * @param products    the products
     * @param paymentType the payment type
     * @return the discount
     */
    public static double getDiscount(Map<Product, Integer> products, String paymentType) {
        return getStrategy(paymentType).calculateBenefit(products);
    }

    /**
     * Gets Benefit Strategy based on paymentType.
     *
     * @param paymentType the payment type
     * @return BenefitStrategy
     */
    public static BenefitStrategy getStrategy(String paymentType) {
        BenefitStrategy benefitStrategy;
        switch (paymentType) {
            case PaymentTypeConstant.PAYPAL: {
                benefitStrategy = new PayPalBenefitStrategy();
                break;
            }
            case PaymentTypeConstant.VISA: {
                benefitStrategy = new VisaBenefitStrategy();
                break;
            }
            case PaymentTypeConstant.MASTERCARD: {
                benefitStrategy = new MastercardBenefitStrategy();
                break;
            }
            default: {
                benefitStrategy = new NonBenefitStrategy();
            }
        }
        return benefitStrategy;
    }
}
