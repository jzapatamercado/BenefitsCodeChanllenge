package coe.unosquare.benefits.discount;

import coe.unosquare.benefits.benefit.*;
import coe.unosquare.benefits.constants.ExceptionMessage;
import coe.unosquare.benefits.constants.PaymentTypeConstant;
import coe.unosquare.benefits.exception.InvalidAmountException;
import coe.unosquare.benefits.exception.InvalidQuantityException;
import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * The type Discount.
 */
public class Discount {
    /**
     * Gets discount.
     *
     * @param products    the products
     * @param paymentType the payment type
     * @return the discount
     * @throws InvalidQuantityException the invalid quantity exception
     * @throws InvalidAmountException   the invalid amount exception
     */
    public static double getDiscount(Map<Product, Integer> products, String paymentType) throws InvalidQuantityException, InvalidAmountException {
        if(ConditionValidator.amountValidation(products,0.0)){
            throw new InvalidAmountException(ExceptionMessage.INVALID_AMOUNT);
        }
        if(ConditionValidator.quantityValidation(products,0)){
            throw new InvalidQuantityException(ExceptionMessage.INVALID_QUANTITY);
        }
        BenefitStrategy benefitStrategy;
        switch(paymentType){
            case PaymentTypeConstant.PAYPAL: {
                benefitStrategy = new PayPalBenefitStrategy();
                break;
            }
            case PaymentTypeConstant.VISA: {
                benefitStrategy = new VisaBenefitStrategy();
                break;
            }
            case PaymentTypeConstant.MASTERCARD:{
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
