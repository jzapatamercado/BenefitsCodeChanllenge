package coe.unosquare.benefits.util.discount;

import coe.unosquare.benefits.constants.PaymentTypeConstant;
import coe.unosquare.benefits.util.benefit.MastercardBenefitStrategy;
import coe.unosquare.benefits.util.benefit.NonBenefitStrategy;
import coe.unosquare.benefits.util.benefit.PayPalBenefitStrategy;
import coe.unosquare.benefits.util.benefit.VisaBenefitStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class DiscountTest {
    @Test
    void testMastercardGetStrategy() {
        assertInstanceOf(MastercardBenefitStrategy.class, Discount.getStrategy(PaymentTypeConstant.MASTERCARD));
    }

    @Test
    void testVisaGetStrategy() {
        assertInstanceOf(VisaBenefitStrategy.class, Discount.getStrategy(PaymentTypeConstant.VISA));
    }

    @Test
    void testPayPalGetStrategy() {
        assertInstanceOf(PayPalBenefitStrategy.class, Discount.getStrategy(PaymentTypeConstant.PAYPAL));
    }

    @Test
    void testNonGetStrategy() {
        assertInstanceOf(NonBenefitStrategy.class, Discount.getStrategy(PaymentTypeConstant.BANK_TRANSACTION));
    }
}
