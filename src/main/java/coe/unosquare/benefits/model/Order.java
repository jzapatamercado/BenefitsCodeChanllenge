package coe.unosquare.benefits.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * The type Order.
 * Class isolated from logic to contain basic products attribute and printing capability.
 */
public class Order {
    private Logger logger = LoggerFactory.getLogger(Order.class);
    private Map<Product, Integer> products;

    /**
     * Instantiates a new Order.
     *
     * @param products the products
     */
    public Order(Map<Product, Integer> products) {
        this.products = products;
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public Map<Product, Integer> getProducts() {
        return products;
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    /**
     * Print.
     */
    public void print() {
        products.forEach((product, quantity) ->
                logger.info("Product: {{}, {}, {}}, {}, {}", product.getName(), product.getPrice(), product.getType(), quantity, product.getPrice() * quantity));
    }
}
