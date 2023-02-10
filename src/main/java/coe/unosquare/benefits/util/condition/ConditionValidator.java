package coe.unosquare.benefits.util.condition;

import coe.unosquare.benefits.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * The type Condition validator.
 * This class allows to calculate and evaluate if a condition is accomplished or not.
 */
public class ConditionValidator {
    private static Logger logger = LoggerFactory.getLogger(ConditionValidator.class);

    /**
     * Amount validation boolean.
     *
     * @param products the products
     * @param limit    the limit
     * @return the boolean
     */
    public static boolean amountValidation(Map<Product, Integer> products, Double limit) {
        Double amount = products.entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
        logger.info("Amount: {}", amount);
        return amount >= limit;
    }

    /**
     * Quantity validation boolean.
     *
     * @param products the products
     * @param limit    the limit
     * @return the boolean
     */
    public static boolean quantityValidation(Map<Product, Integer> products, Integer limit) {
        Integer qty = products.values()
                .stream()
                .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity);
        logger.info("Quantity: {}", qty);

        return qty >= limit;
    }

}
