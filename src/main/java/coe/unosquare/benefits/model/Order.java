package coe.unosquare.benefits.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Order {
    private Logger logger = LoggerFactory.getLogger(Order.class);
    /**
     * Store the final list of products and quantity for each product.
     **/
    private Map<Product, Integer> products;

    public Order(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    /**
     * Print.
     */
    public void print() {
        products.forEach((product, quantity) ->
              logger.info("Product: {{}, {}, {}}, {}, {}", product.getName(),product.getPrice(), product.getType(), quantity, product.getPrice()*quantity));
    }
}
